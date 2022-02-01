package com.tencent.qqprotect.singleupdate;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.ims.QQProtectCommon.QQProtectQueryHead;
import com.tencent.ims.QQProtectUpdate.UpdateQueryBody;
import com.tencent.ims.QQProtectUpdate.UpdateQueryRequest;
import com.tencent.ims.QQProtectUpdate.UpdateQueryResponse;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.CommTvRpt;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.qqprotect.common.QSecRptController;
import com.tencent.qqprotect.common.QSecRptHelper;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class QPUpdateManager
  implements Handler.Callback, INetEngineListener, Manager
{
  final Object a = new Object();
  private ConcurrentHashMap<String, NetReq> b = new ConcurrentHashMap();
  private QQAppInterface c;
  private Handler d;
  private int e = 0;
  private SFU.UpdateSection f = null;
  private boolean g;
  private String h = "";
  private String i = "";
  private SharedPreferences j = null;
  private QPUpdateConfig k = null;
  
  public QPUpdateManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.d = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.g = false;
    this.j = this.c.getApp().getSharedPreferences("qp_sfu_config", 0);
    this.k = new QPUpdateConfig(this.c);
  }
  
  private int a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "No matched update from server.");
      }
      return -1;
    }
    if (this.j.getInt("last_update_config_version", 0) < paramInt) {
      return 0;
    }
    String str = f();
    if (!new File(str).exists()) {
      return 0;
    }
    str = MD5FileUtil.a(str);
    if (str != null)
    {
      if (!str.equalsIgnoreCase(paramString)) {
        return 0;
      }
      if ((str != null) && (str.equalsIgnoreCase(paramString))) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = QPMiscUtils.a(1);
      if (localObject == null) {
        return;
      }
      QQProtectUpdate.UpdateQueryBody localUpdateQueryBody = new QQProtectUpdate.UpdateQueryBody();
      localUpdateQueryBody.uint32_file_id.set(paramInt1);
      localUpdateQueryBody.uint32_file_local_version.set(paramInt2);
      QQProtectUpdate.UpdateQueryRequest localUpdateQueryRequest = new QQProtectUpdate.UpdateQueryRequest();
      localUpdateQueryRequest.head_update_query.set((MessageMicro)localObject);
      localUpdateQueryRequest.body_update_query.set(localUpdateQueryBody);
      localObject = new ToServiceMsg("mobileqq.service", this.c.getCurrentAccountUin(), "MobileQQprotect.QPUpdate");
      ((ToServiceMsg)localObject).putWupBuffer(localUpdateQueryRequest.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
      this.c.sendToService((ToServiceMsg)localObject);
      a("0X80078AA", paramInt1, "", "");
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] sent update query: fileid=%d, localversion=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void a(NetReq paramNetReq, int paramInt1, int paramInt2) {}
  
  private void a(NetResp paramNetResp)
  {
    if (paramNetResp == null) {
      return;
    }
    if (paramNetResp.mResult == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] http download error=%d", new Object[] { Integer.valueOf(paramNetResp.mResult) }));
      }
      return;
    }
    QPUpdateManager.UserData localUserData = (QPUpdateManager.UserData)paramNetResp.mReq.getUserData();
    if (localUserData == null) {
      return;
    }
    boolean bool;
    if (paramNetResp.mResult == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {}
    try
    {
      if (localUserData.i < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] retried to download, retry=%d, result=%b, url=%s", new Object[] { Integer.valueOf(localUserData.i), Boolean.valueOf(bool), localUserData.e }));
        }
        a(localUserData);
        return;
      }
      File localFile = new File(paramNetResp.mReq.mOutPath);
      if (localFile.exists()) {
        localFile.delete();
      }
      this.b.remove(localUserData.f.toLowerCase());
      a(bool, paramNetResp.mReq);
      return;
    }
    catch (Throwable paramNetResp)
    {
      paramNetResp.printStackTrace();
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    paramString3 = String.format("%d", new Object[] { Integer.valueOf(paramInt) });
    paramString2 = this.f;
    if (paramString2 != null) {
      paramInt = (int)paramString2.b;
    } else {
      paramInt = 0;
    }
    paramString2 = this.f;
    if (paramString2 != null) {
      paramString2 = String.format("%d", new Object[] { Long.valueOf(paramString2.a) });
    } else {
      paramString2 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] report: actiontype=%s, actionname=%s, actionfrom=%d, actionresult=%d, sectionId=%s, reportId=%s, fileInfo: %s", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt), Integer.valueOf(this.e), paramString2, paramString3, "", "" }));
    }
    QSecRptHelper localQSecRptHelper = new QSecRptHelper();
    localQSecRptHelper.a(paramString1).a(paramString1).a(paramString3).a(paramString2).a(this.e);
    QSecRptController.a(localQSecRptHelper.toString(), 105, paramInt);
  }
  
  private void a(boolean paramBoolean, NetReq paramNetReq)
  {
    if ((paramBoolean) && (paramNetReq != null))
    {
      File localFile = new File(paramNetReq.mOutPath);
      QPUpdateManager.UserData localUserData = (QPUpdateManager.UserData)paramNetReq.getUserData();
      if ((localFile.exists()) && (localUserData != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] http download complete: %s, %s", new Object[] { paramNetReq.mOutPath, localUserData.e }));
        }
        int m = localUserData.a;
        if (m != 1)
        {
          if (m != 2) {
            return;
          }
          a("0X80078AE", localUserData.g, "", "");
          d(7);
          return;
        }
        localFile = new File(f());
        new File(paramNetReq.mOutPath).renameTo(localFile);
        a("0X80078AC", localUserData.g, "", "");
        if (this.k.a(localFile.toString()))
        {
          this.j.edit().putInt("last_update_config_version", localUserData.g).commit();
          if (this.k.a().isEmpty())
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, "[SFU] config ok but without any sections");
            }
            d(16);
            return;
          }
          d(5);
          return;
        }
        a("0X80078AC", localUserData.g, localUserData.d, localUserData.e);
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, "[SFU] invalid config (sig not accepted)");
        }
        a(1);
        return;
      }
      a(3);
      return;
    }
    a(3);
  }
  
  private boolean a(QPUpdateManager.UserData paramUserData)
  {
    if (paramUserData == null) {
      return false;
    }
    if ((paramUserData.a == 2) && (paramUserData.k != 1) && (!NetworkUtils.isWifiConnected(this.c.getApplication())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] donot download file because not using wifi");
      }
      CommTvRpt.a(3, 1);
      return false;
    }
    if ((paramUserData.i < 3) && (this.b.contains(paramUserData.f.toLowerCase()))) {
      return false;
    }
    IHttpEngineService localIHttpEngineService = (IHttpEngineService)this.c.getRuntimeService(IHttpEngineService.class, "all");
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mSupportBreakResume = true;
    localHttpNetReq.mReqUrl = paramUserData.e;
    localHttpNetReq.mHttpMethod = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUserData.c);
    localStringBuilder.append(paramUserData.d);
    localHttpNetReq.mOutPath = localStringBuilder.toString();
    paramUserData.i += 1;
    paramUserData.j = new Date().getTime();
    localHttpNetReq.setUserData(paramUserData);
    this.b.put(paramUserData.f.toLowerCase(), localHttpNetReq);
    localIHttpEngineService.sendReq(localHttpNetReq);
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] begin http download %s", new Object[] { paramUserData.e }));
    }
    return true;
  }
  
  private boolean a(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] rollback: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      if (paramUpdateSection.q.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, "[SFU] no files need to rollback");
        }
      }
      else
      {
        long l2;
        do
        {
          bool = true;
          break;
          String str = d(paramUpdateSection);
          l2 = 0L;
          int m = 0;
          while (m < paramUpdateSection.q.size())
          {
            Object localObject = (SFU.FileInfo)paramUpdateSection.q.get(m);
            File localFile1 = new File(((SFU.FileInfo)localObject).f);
            File localFile2 = new File(((SFU.FileInfo)localObject).g);
            long l1 = l2;
            if (localFile2.exists())
            {
              if (!localFile2.delete()) {
                localFile2.deleteOnExit();
              }
              l1 = l2 + 1L;
            }
            l2 = l1;
            if (((SFU.FileInfo)localObject).l == 2)
            {
              l2 = l1;
              if (localFile1.exists())
              {
                if (!localFile1.delete()) {
                  localFile1.deleteOnExit();
                }
                l2 = l1 + 1L;
              }
            }
            localObject = new File(str, ((SFU.FileInfo)localObject).c);
            l1 = l2;
            if (((File)localObject).exists())
            {
              l1 = l2;
              if (((File)localObject).canRead())
              {
                l1 = l2;
                if (localFile1.exists())
                {
                  l1 = l2;
                  if (localFile1.canWrite())
                  {
                    a((File)localObject, localFile1);
                    l1 = l2 + 1L;
                  }
                }
              }
            }
            m += 1;
            l2 = l1;
          }
        } while (l2 == paramUpdateSection.q.size());
      }
    }
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] rollback result: %b", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  /* Error */
  private boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_2
    //   7: invokevirtual 127	java/io/File:exists	()Z
    //   10: ifeq +12 -> 22
    //   13: aload_2
    //   14: invokevirtual 276	java/io/File:delete	()Z
    //   17: ifne +36 -> 53
    //   20: iconst_0
    //   21: ireturn
    //   22: new 121	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokevirtual 500	java/io/File:getParent	()Ljava/lang/String;
    //   30: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 6
    //   35: aload 6
    //   37: invokevirtual 127	java/io/File:exists	()Z
    //   40: ifne +13 -> 53
    //   43: aload 6
    //   45: invokevirtual 503	java/io/File:mkdirs	()Z
    //   48: ifne +5 -> 53
    //   51: iconst_0
    //   52: ireturn
    //   53: new 505	java/io/FileOutputStream
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 508	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_2
    //   62: new 510	java/io/BufferedInputStream
    //   65: dup
    //   66: new 512	java/io/FileInputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 513	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 516	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore 5
    //   79: invokestatic 522	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   82: sipush 4096
    //   85: invokevirtual 526	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   88: astore_1
    //   89: aload 5
    //   91: aload_1
    //   92: invokevirtual 530	java/io/BufferedInputStream:read	([B)I
    //   95: istore_3
    //   96: iload_3
    //   97: iconst_m1
    //   98: if_icmpeq +17 -> 115
    //   101: aload_2
    //   102: aload_1
    //   103: iconst_0
    //   104: iload_3
    //   105: invokevirtual 534	java/io/FileOutputStream:write	([BII)V
    //   108: aload_2
    //   109: invokevirtual 537	java/io/FileOutputStream:flush	()V
    //   112: goto -23 -> 89
    //   115: invokestatic 522	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   118: aload_1
    //   119: invokevirtual 540	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   122: aload_2
    //   123: invokevirtual 543	java/io/FileOutputStream:close	()V
    //   126: aload 5
    //   128: invokevirtual 544	java/io/BufferedInputStream:close	()V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_1
    //   134: aload 5
    //   136: astore 4
    //   138: goto +69 -> 207
    //   141: astore 4
    //   143: aload 5
    //   145: astore_1
    //   146: goto +11 -> 157
    //   149: astore_1
    //   150: goto +57 -> 207
    //   153: astore 4
    //   155: aconst_null
    //   156: astore_1
    //   157: goto +16 -> 173
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_2
    //   163: goto +44 -> 207
    //   166: astore 4
    //   168: aconst_null
    //   169: astore_1
    //   170: aload 5
    //   172: astore_2
    //   173: aload 4
    //   175: invokevirtual 545	java/io/IOException:printStackTrace	()V
    //   178: aload_2
    //   179: ifnull +10 -> 189
    //   182: aload_2
    //   183: invokevirtual 543	java/io/FileOutputStream:close	()V
    //   186: goto +3 -> 189
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 544	java/io/BufferedInputStream:close	()V
    //   197: iconst_0
    //   198: ireturn
    //   199: astore 5
    //   201: aload_1
    //   202: astore 4
    //   204: aload 5
    //   206: astore_1
    //   207: aload_2
    //   208: ifnull +10 -> 218
    //   211: aload_2
    //   212: invokevirtual 543	java/io/FileOutputStream:close	()V
    //   215: goto +3 -> 218
    //   218: aload 4
    //   220: ifnull +8 -> 228
    //   223: aload 4
    //   225: invokevirtual 544	java/io/BufferedInputStream:close	()V
    //   228: goto +5 -> 233
    //   231: aload_1
    //   232: athrow
    //   233: goto -2 -> 231
    //   236: astore_1
    //   237: goto -111 -> 126
    //   240: astore_1
    //   241: iconst_1
    //   242: ireturn
    //   243: astore_2
    //   244: goto -55 -> 189
    //   247: astore_1
    //   248: iconst_0
    //   249: ireturn
    //   250: astore_2
    //   251: goto -33 -> 218
    //   254: astore_2
    //   255: goto -27 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	QPUpdateManager
    //   0	258	1	paramFile1	File
    //   0	258	2	paramFile2	File
    //   95	10	3	m	int
    //   1	136	4	localObject1	Object
    //   141	1	4	localIOException1	java.io.IOException
    //   153	1	4	localIOException2	java.io.IOException
    //   166	8	4	localIOException3	java.io.IOException
    //   202	22	4	localFile1	File
    //   4	167	5	localBufferedInputStream	java.io.BufferedInputStream
    //   199	6	5	localObject2	Object
    //   33	11	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   79	89	133	finally
    //   89	96	133	finally
    //   101	112	133	finally
    //   115	122	133	finally
    //   79	89	141	java/io/IOException
    //   89	96	141	java/io/IOException
    //   101	112	141	java/io/IOException
    //   115	122	141	java/io/IOException
    //   62	79	149	finally
    //   62	79	153	java/io/IOException
    //   6	20	160	finally
    //   22	51	160	finally
    //   53	62	160	finally
    //   6	20	166	java/io/IOException
    //   22	51	166	java/io/IOException
    //   53	62	166	java/io/IOException
    //   173	178	199	finally
    //   122	126	236	java/io/IOException
    //   126	131	240	java/io/IOException
    //   182	186	243	java/io/IOException
    //   193	197	247	java/io/IOException
    //   211	215	250	java/io/IOException
    //   223	228	254	java/io/IOException
  }
  
  private void b()
  {
    synchronized (this.a)
    {
      if (!this.g)
      {
        this.j.edit().putLong("last_query_time", new Date().getTime()).commit();
        d(2);
        this.g = true;
      }
      else
      {
        long l = this.j.getLong("last_query_time", 0L);
        if (new Date().getTime() - l > 3600000L)
        {
          this.g = false;
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, "[SFU] last udpate timeout");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, "[SFU] already being updating");
        }
      }
      return;
    }
  }
  
  private boolean b(SFU.UpdateSection paramUpdateSection)
  {
    return true;
  }
  
  private String c(SFU.UpdateSection paramUpdateSection)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(e());
    ((StringBuilder)localObject).append(paramUpdateSection.a);
    ((StringBuilder)localObject).append(File.separator);
    paramUpdateSection = ((StringBuilder)localObject).toString();
    localObject = new File(paramUpdateSection);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramUpdateSection;
  }
  
  private void c()
  {
    synchronized (this.a)
    {
      this.g = false;
      a("0X80078B5", 0, "", "");
      this.f = null;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] update ended");
      }
      return;
    }
  }
  
  private void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  private String d(SFU.UpdateSection paramUpdateSection)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c(paramUpdateSection));
    ((StringBuilder)localObject).append("bak");
    ((StringBuilder)localObject).append(File.separator);
    paramUpdateSection = ((StringBuilder)localObject).toString();
    localObject = new File(paramUpdateSection);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramUpdateSection;
  }
  
  private void d()
  {
    a(1, this.j.getInt("last_update_config_version", 0));
    this.j.edit().remove("last_update_bids").commit();
  }
  
  private void d(int paramInt)
  {
    QLog.d("QQProtect.QPUpdate", 1, String.format("[SFU] update event: %d", new Object[] { Integer.valueOf(paramInt) }));
    if (paramInt != 1) {
      if (paramInt != 2) {
        switch (paramInt)
        {
        default: 
          return;
        }
      }
    }
    try
    {
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    g();
    d(17);
    return;
    g(this.f);
    this.f = null;
    if (h())
    {
      d(16);
      return;
    }
    d(5);
    return;
    if (this.f != null) {
      h(this.f);
    }
    d(15);
    return;
    if ((this.f != null) && (a(this.f)))
    {
      a(0);
      return;
    }
    a("0X80078B3", 0, "", "");
    a(10);
    return;
    if ((this.f != null) && (b(this.f)))
    {
      a(0);
      return;
    }
    a(9);
    return;
    if ((this.f != null) && (i(this.f)))
    {
      d(12);
      return;
    }
    c(8);
    d(13);
    return;
    if ((this.f != null) && (k(this.f)))
    {
      d(11);
      return;
    }
    c(7);
    d(13);
    return;
    if ((this.f != null) && (j(this.f)))
    {
      d(10);
      return;
    }
    a("0X80078B1", 0, "", "");
    a(6);
    return;
    if ((this.f != null) && (l(this.f)))
    {
      d(9);
      return;
    }
    a("0X80078B0", 0, "", "");
    a(5);
    return;
    if ((this.f != null) && (f(this.f)))
    {
      d(8);
      return;
    }
    a("0X80078AF", 0, "", "");
    a(4);
    return;
    if ((this.f != null) && (m(this.f))) {
      return;
    }
    a(3);
    return;
    if ((k()) && (this.f != null))
    {
      if (!n(this.f))
      {
        d(15);
        return;
      }
      d(6);
      return;
    }
    d(16);
    return;
    d();
    return;
    if (this.e == 1)
    {
      d(17);
      return;
    }
    d(14);
    return;
  }
  
  private String e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c.getApp().getDir("qqprotect", 0).toString());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("SFU/");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localObject;
  }
  
  private String e(SFU.UpdateSection paramUpdateSection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(paramUpdateSection));
    localStringBuilder.append(paramUpdateSection.d);
    return localStringBuilder.toString();
  }
  
  private String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append("qp_sfu_config.dat");
    return localStringBuilder.toString();
  }
  
  private boolean f(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool;
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify package: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      String str = MD5FileUtil.a(e(paramUpdateSection));
      if (str == null) {
        return false;
      }
      bool = str.equalsIgnoreCase(paramUpdateSection.e);
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, "[SFU] all sections update complete");
    }
    try
    {
      if (!TextUtils.isEmpty(this.h))
      {
        QSecFramework.c().e();
        this.j.edit().putString("last_update_bids", this.h).putString("last_update_sections", this.i).commit();
        a("0X80078B6", 0, this.h, this.i);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] notify update complete: %s", new Object[] { this.h }));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void g(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update complete: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      paramUpdateSection.b();
      if (i())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.h);
        localStringBuilder.append(String.format("#%d#", new Object[] { Long.valueOf(paramUpdateSection.b) }));
        this.h = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.i);
        localStringBuilder.append(String.format("#%d#", new Object[] { Long.valueOf(paramUpdateSection.a) }));
        this.i = localStringBuilder.toString();
      }
      a("0X80078B4", 0, "", "");
    }
  }
  
  private void h(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] cleanup: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      FileUtils.delete(c(paramUpdateSection), false);
    }
  }
  
  private boolean h()
  {
    Object localObject = this.k.a();
    int m = 0;
    while (m < ((List)localObject).size())
    {
      if (!((SFU.UpdateSection)((List)localObject).get(m)).a())
      {
        bool = false;
        break label50;
      }
      m += 1;
    }
    boolean bool = true;
    label50:
    if (QLog.isColorLevel())
    {
      if (bool) {
        localObject = "yes";
      } else {
        localObject = "no";
      }
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] all complete: %s", new Object[] { localObject }));
    }
    return bool;
  }
  
  private boolean i()
  {
    return this.e == 0;
  }
  
  private boolean i(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool;
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      if (paramUpdateSection.r.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] no diff: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
        }
      }
      else
      {
        int m = 0;
        while (m < paramUpdateSection.r.size())
        {
          SFU.FileInfo localFileInfo = (SFU.FileInfo)paramUpdateSection.r.get(m);
          if (TextUtils.isEmpty(localFileInfo.g)) {
            str = localFileInfo.f;
          } else {
            str = localFileInfo.g;
          }
          String str = MD5FileUtil.a(str);
          if ((str != null) && (str.equalsIgnoreCase(localFileInfo.b)))
          {
            m += 1;
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label229;
            }
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] not matched: %s!=%s, sid=%d", new Object[] { str, localFileInfo.b, Long.valueOf(paramUpdateSection.a) }));
            break label229;
          }
        }
      }
      bool = true;
    }
    else
    {
      label229:
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private int j()
  {
    try
    {
      int m = Build.VERSION.SDK_INT;
      return m;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
  }
  
  private boolean j(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      long l2 = paramUpdateSection.s;
      long l1 = 0L;
      if (l2 == 0L) {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, "[SFU] no files need to backup");
        }
      }
      do
      {
        bool = true;
        break label265;
        if (paramUpdateSection.s <= 0L) {
          break;
        }
        String str = d(paramUpdateSection);
        int m = 0;
        while (m < paramUpdateSection.r.size())
        {
          SFU.FileInfo localFileInfo = (SFU.FileInfo)paramUpdateSection.r.get(m);
          l2 = l1;
          if (1 == localFileInfo.l)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(localFileInfo.c);
            localObject = ((StringBuilder)localObject).toString();
            a(new File(localFileInfo.f), new File((String)localObject));
            l2 = l1 + 1L;
          }
          m += 1;
          l1 = l2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup %d files of %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramUpdateSection.r.size()) }));
        }
      } while (paramUpdateSection.s == l1);
    }
    boolean bool = false;
    label265:
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup result: %b", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private boolean k()
  {
    this.f = null;
    List localList = this.k.a();
    int m = 0;
    while (m < localList.size())
    {
      SFU.UpdateSection localUpdateSection = (SFU.UpdateSection)localList.get(m);
      if (!localUpdateSection.a())
      {
        if ((localUpdateSection.n) && (localUpdateSection.m) && (localUpdateSection.o))
        {
          this.f = localUpdateSection;
          c(0);
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] next update: sid=%d", new Object[] { Long.valueOf(this.f.a) }));
          }
          bool = true;
          break label206;
        }
        if (QLog.isColorLevel()) {
          QLog.w("QQProtect.QPUpdate", 2, String.format("[SFU] not matched section: sid=%d, os: %b, qq:%b, cpu:%b", new Object[] { Long.valueOf(localUpdateSection.a), Boolean.valueOf(localUpdateSection.n), Boolean.valueOf(localUpdateSection.m), Boolean.valueOf(localUpdateSection.o) }));
        }
        localUpdateSection.b();
      }
      m += 1;
    }
    boolean bool = false;
    label206:
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] get next section result? %b", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private boolean k(SFU.UpdateSection paramUpdateSection)
  {
    if ((paramUpdateSection != null) && (!paramUpdateSection.r.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] do update files: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      String str = c(paramUpdateSection);
      int m = 0;
      while (m < paramUpdateSection.r.size())
      {
        SFU.FileInfo localFileInfo = (SFU.FileInfo)paramUpdateSection.r.get(m);
        File localFile1 = new File(str, localFileInfo.b);
        Object localObject = new File(localFileInfo.f);
        if ((localFile1.exists()) && (localFile1.canRead()))
        {
          boolean bool2 = a(localFile1, (File)localObject);
          bool1 = bool2;
          if (!bool2)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localFileInfo.f);
            ((StringBuilder)localObject).append(".1");
            localObject = ((StringBuilder)localObject).toString();
            File localFile2 = new File((String)localObject);
            localFileInfo.l = 3;
            localFileInfo.g = ((String)localObject);
            bool2 = a(localFile1, localFile2);
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] copied failed, renamed to: %s", new Object[] { localFileInfo.g }));
            }
            bool1 = bool2;
            if (bool2)
            {
              this.j.edit().putString(localFileInfo.f, localFileInfo.g).commit();
              bool1 = bool2;
            }
          }
          if (bool1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] success copied: %s", new Object[] { localFileInfo.f }));
            }
            paramUpdateSection.q.add(localFileInfo);
            paramUpdateSection.t += 1L;
          }
          else
          {
            a("0X80078B2", (int)localFileInfo.j, localFileInfo.a, localFileInfo.b);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] failed copied: %s", new Object[] { localFileInfo.f }));
            break;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] copied failed, src not existed or cannot read: %s", new Object[] { localFile1.toString() }));
        }
        m += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update %d files of %d", new Object[] { Long.valueOf(paramUpdateSection.t), Integer.valueOf(paramUpdateSection.r.size()) }));
      }
      if (paramUpdateSection.t == paramUpdateSection.r.size())
      {
        bool1 = true;
        break label517;
      }
    }
    boolean bool1 = false;
    label517:
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update result: %b", new Object[] { Boolean.valueOf(bool1) }));
    }
    return bool1;
  }
  
  private boolean l(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] unzip package: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      String str = c(paramUpdateSection);
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (j() >= 30)
      {
        if (ZipUtils.unZipFile3(e(paramUpdateSection), str) != 0) {}
      }
      else {
        while (ZipUtils.unZipFile2(e(paramUpdateSection), str) == 0)
        {
          bool = true;
          break;
        }
      }
    }
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] unzip result: %b", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private boolean m(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] download package: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      return a(new QPUpdateManager.UserData(2, 0, c(paramUpdateSection), paramUpdateSection.d, paramUpdateSection.f, paramUpdateSection.e, 0, true, 0, new Date().getTime(), paramUpdateSection.v));
    }
    return false;
  }
  
  private boolean n(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] get different: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.a) }));
      }
      List localList = paramUpdateSection.p;
      int m = 0;
      while (m < localList.size())
      {
        SFU.FileInfo localFileInfo = (SFU.FileInfo)localList.get(m);
        if (!new File(localFileInfo.f).exists())
        {
          localFileInfo.l = 2;
          paramUpdateSection.r.add(localFileInfo);
        }
        else
        {
          String str = MD5FileUtil.a(localFileInfo.f);
          if ((str == null) || (!str.equalsIgnoreCase(localFileInfo.b)))
          {
            localFileInfo.l = 1;
            if (str == null) {
              str = "";
            }
            localFileInfo.c = str;
            paramUpdateSection.r.add(localFileInfo);
            paramUpdateSection.s += 1L;
          }
        }
        m += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] need to update %d files of %d", new Object[] { Integer.valueOf(paramUpdateSection.r.size()), Integer.valueOf(paramUpdateSection.p.size()) }));
      }
      return paramUpdateSection.r.isEmpty() ^ true;
    }
    return false;
  }
  
  public void a()
  {
    long l1 = this.j.getLong("last_query_time", -28800000L);
    long l2 = new Date().getTime() - l1;
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 1, String.format("[SFU] startSFU last time: %d, interval: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    }
    if (l2 >= 28800000L) {
      b();
    }
  }
  
  protected void a(int paramInt)
  {
    QLog.e("QQProtect.QPUpdate", 1, String.format("[SFU] update error: %d", new Object[] { Integer.valueOf(paramInt) }));
    switch (paramInt)
    {
    default: 
      break;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 10: 
      c(paramInt);
      break;
    case 1: 
      File localFile = new File(f());
      if (localFile.exists()) {
        localFile.delete();
      }
      break;
    }
    d(1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    label645:
    label648:
    label666:
    label669:
    for (;;)
    {
      boolean bool1;
      try
      {
        QQProtectUpdate.UpdateQueryResponse localUpdateQueryResponse = new QQProtectUpdate.UpdateQueryResponse();
        localUpdateQueryResponse.mergeFrom((byte[])paramObject);
        n = -1;
        int m = n;
        if (localUpdateQueryResponse.int32_status != null)
        {
          m = n;
          if (localUpdateQueryResponse.int32_status.has()) {
            m = localUpdateQueryResponse.int32_status.get();
          }
        }
        a("0X80078B8", m, "", "");
        boolean bool3 = true;
        boolean bool2 = false;
        if (m == 0)
        {
          if ((localUpdateQueryResponse.uint32_sec_cmd == null) || (!localUpdateQueryResponse.uint32_sec_cmd.has())) {
            break label615;
          }
          n = localUpdateQueryResponse.uint32_sec_cmd.get();
          if ((localUpdateQueryResponse.uint32_file_id == null) || (!localUpdateQueryResponse.uint32_file_id.has())) {
            break label621;
          }
          i1 = localUpdateQueryResponse.uint32_file_id.get();
          if ((localUpdateQueryResponse.uint32_file_version == null) || (!localUpdateQueryResponse.uint32_file_version.has())) {
            break label627;
          }
          i2 = localUpdateQueryResponse.uint32_file_version.get();
          if ((localUpdateQueryResponse.string_file_hash == null) || (!localUpdateQueryResponse.string_file_hash.has())) {
            break label633;
          }
          paramToServiceMsg = localUpdateQueryResponse.string_file_hash.get();
          if ((localUpdateQueryResponse.string_file_url == null) || (!localUpdateQueryResponse.string_file_url.has())) {
            break label639;
          }
          paramFromServiceMsg = localUpdateQueryResponse.string_file_url.get();
          if ((localUpdateQueryResponse.uint32_zip_flag == null) || (!localUpdateQueryResponse.uint32_zip_flag.has())) {
            break label645;
          }
          i3 = localUpdateQueryResponse.uint32_zip_flag.get();
          break label648;
          int i4 = a(i2, paramToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] resp: cmd=%d, status=%d, fileid=%d, fileversion=%d, md5=%s, url=%s, zipped: %d", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(i2), paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i3) }));
          }
          if ((i4 == 0) && (i1 == 1))
          {
            a("0X80078AB", i1, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, String.format("Need to update config file, fileid=%d", new Object[] { Integer.valueOf(i1) }));
            }
            bool1 = a(new QPUpdateManager.UserData(1, i1, e(), "qp_sfu_config.dat", paramFromServiceMsg, paramToServiceMsg, i2, bool1, 0, new Date().getTime(), 1));
          }
          else
          {
            if (i4 == 1)
            {
              paramToServiceMsg = new File(f());
              if (!this.k.a(paramToServiceMsg.toString())) {
                break label666;
              }
              if (this.k.a().isEmpty())
              {
                d(16);
                bool1 = bool3;
                break label669;
              }
              d(5);
              bool1 = bool3;
              break label669;
            }
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("QQProtect.QPUpdate", 2, "[SFU] NO Need UPDATE");
              bool1 = bool2;
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] Server replied with error, status=%d", new Object[] { Integer.valueOf(m) }));
            bool1 = bool2;
          }
        }
        if (!bool1)
        {
          d(17);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        d(17);
      }
      return;
      label615:
      int n = 0;
      continue;
      label621:
      int i1 = 0;
      continue;
      label627:
      int i2 = 0;
      continue;
      label633:
      paramToServiceMsg = "";
      continue;
      label639:
      paramFromServiceMsg = "";
      continue;
      int i3 = 0;
      if (i3 == 1)
      {
        bool1 = true;
      }
      else
      {
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] received update push from server: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 1052689: 
      a((NetReq)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
      break;
    case 1052688: 
      a((NetResp)paramMessage.obj);
    }
    return false;
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.d;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Handler localHandler = this.d;
    if (localHandler != null) {
      localHandler.obtainMessage(1052688, paramNetResp).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.d.obtainMessage(1052689, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPUpdateManager
 * JD-Core Version:    0.7.0.1
 */