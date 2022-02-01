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
  private int jdField_a_of_type_Int = 0;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QPUpdateConfig jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig = null;
  private SFU.UpdateSection jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection = null;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap<String, NetReq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public QPUpdateManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qp_sfu_config", 0);
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig = new QPUpdateConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private int a()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0;
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
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("last_update_config_version", 0) < paramInt) {
      return 0;
    }
    String str = b();
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
  
  private String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getDir("qqprotect", 0).toString());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("SFU/");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localObject;
  }
  
  private String a(SFU.UpdateSection paramUpdateSection)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(paramUpdateSection.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append(File.separator);
    paramUpdateSection = ((StringBuilder)localObject).toString();
    localObject = new File(paramUpdateSection);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramUpdateSection;
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
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MobileQQprotect.QPUpdate");
      ((ToServiceMsg)localObject).putWupBuffer(localUpdateQueryRequest.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService((ToServiceMsg)localObject);
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
      if (localUserData.jdField_d_of_type_Int < 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] retried to download, retry=%d, result=%b, url=%s", new Object[] { Integer.valueOf(localUserData.jdField_d_of_type_Int), Boolean.valueOf(bool), localUserData.jdField_c_of_type_JavaLangString }));
        }
        a(localUserData);
        return;
      }
      File localFile = new File(paramNetResp.mReq.mOutPath);
      if (localFile.exists()) {
        localFile.delete();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localUserData.jdField_d_of_type_JavaLangString.toLowerCase());
      a(bool, paramNetResp.mReq);
      return;
    }
    catch (Throwable paramNetResp)
    {
      paramNetResp.printStackTrace();
    }
  }
  
  private void a(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update complete: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      paramUpdateSection.a();
      if (b())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(String.format("#%d#", new Object[] { Long.valueOf(paramUpdateSection.jdField_b_of_type_Long) }));
        this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(String.format("#%d#", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
        this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      }
      a("0X80078B4", 0, "", "");
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    paramString3 = String.format("%d", new Object[] { Integer.valueOf(paramInt) });
    paramString2 = this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection;
    if (paramString2 != null) {
      paramInt = (int)paramString2.jdField_b_of_type_Long;
    } else {
      paramInt = 0;
    }
    paramString2 = this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection;
    if (paramString2 != null) {
      paramString2 = String.format("%d", new Object[] { Long.valueOf(paramString2.jdField_a_of_type_Long) });
    } else {
      paramString2 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] report: actiontype=%s, actionname=%s, actionfrom=%d, actionresult=%d, sectionId=%s, reportId=%s, fileInfo: %s", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int), paramString2, paramString3, "", "" }));
    }
    QSecRptHelper localQSecRptHelper = new QSecRptHelper();
    localQSecRptHelper.a(paramString1).a(paramString1).a(paramString3).a(paramString2).a(this.jdField_a_of_type_Int);
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
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] http download complete: %s, %s", new Object[] { paramNetReq.mOutPath, localUserData.jdField_c_of_type_JavaLangString }));
        }
        int i = localUserData.jdField_a_of_type_Int;
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          a("0X80078AE", localUserData.jdField_c_of_type_Int, "", "");
          d(7);
          return;
        }
        localFile = new File(b());
        new File(paramNetReq.mOutPath).renameTo(localFile);
        a("0X80078AC", localUserData.jdField_c_of_type_Int, "", "");
        if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a(localFile.toString()))
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("last_update_config_version", localUserData.jdField_c_of_type_Int).commit();
          if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a().isEmpty())
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
        a("0X80078AC", localUserData.jdField_c_of_type_Int, localUserData.jdField_b_of_type_JavaLangString, localUserData.jdField_c_of_type_JavaLangString);
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
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      if (!((SFU.UpdateSection)((List)localObject).get(i)).a())
      {
        bool = false;
        break label50;
      }
      i += 1;
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
  
  private boolean a(QPUpdateManager.UserData paramUserData)
  {
    if (paramUserData == null) {
      return false;
    }
    if ((paramUserData.jdField_a_of_type_Int == 2) && (paramUserData.e != 1) && (!NetworkUtils.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] donot download file because not using wifi");
      }
      CommTvRpt.a(3, 1);
      return false;
    }
    if ((paramUserData.jdField_d_of_type_Int < 3) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramUserData.jdField_d_of_type_JavaLangString.toLowerCase()))) {
      return false;
    }
    IHttpEngineService localIHttpEngineService = (IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mSupportBreakResume = true;
    localHttpNetReq.mReqUrl = paramUserData.jdField_c_of_type_JavaLangString;
    localHttpNetReq.mHttpMethod = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUserData.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramUserData.jdField_b_of_type_JavaLangString);
    localHttpNetReq.mOutPath = localStringBuilder.toString();
    paramUserData.jdField_d_of_type_Int += 1;
    paramUserData.jdField_a_of_type_Long = new Date().getTime();
    localHttpNetReq.setUserData(paramUserData);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramUserData.jdField_d_of_type_JavaLangString.toLowerCase(), localHttpNetReq);
    localIHttpEngineService.sendReq(localHttpNetReq);
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] begin http download %s", new Object[] { paramUserData.jdField_c_of_type_JavaLangString }));
    }
    return true;
  }
  
  private boolean a(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] rollback: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      if (paramUpdateSection.jdField_b_of_type_JavaUtilList.isEmpty())
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
          String str = b(paramUpdateSection);
          l2 = 0L;
          int i = 0;
          while (i < paramUpdateSection.jdField_b_of_type_JavaUtilList.size())
          {
            Object localObject = (SFU.FileInfo)paramUpdateSection.jdField_b_of_type_JavaUtilList.get(i);
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
            if (((SFU.FileInfo)localObject).jdField_a_of_type_Int == 2)
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
            localObject = new File(str, ((SFU.FileInfo)localObject).jdField_c_of_type_JavaLangString);
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
            i += 1;
            l2 = l1;
          }
        } while (l2 == paramUpdateSection.jdField_b_of_type_JavaUtilList.size());
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
    //   7: invokevirtual 130	java/io/File:exists	()Z
    //   10: ifeq +12 -> 22
    //   13: aload_2
    //   14: invokevirtual 311	java/io/File:delete	()Z
    //   17: ifne +36 -> 53
    //   20: iconst_0
    //   21: ireturn
    //   22: new 124	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokevirtual 533	java/io/File:getParent	()Ljava/lang/String;
    //   30: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 6
    //   35: aload 6
    //   37: invokevirtual 130	java/io/File:exists	()Z
    //   40: ifne +13 -> 53
    //   43: aload 6
    //   45: invokevirtual 166	java/io/File:mkdirs	()Z
    //   48: ifne +5 -> 53
    //   51: iconst_0
    //   52: ireturn
    //   53: new 535	java/io/FileOutputStream
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 538	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_2
    //   62: new 540	java/io/BufferedInputStream
    //   65: dup
    //   66: new 542	java/io/FileInputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 543	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 546	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore 5
    //   79: invokestatic 552	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   82: sipush 4096
    //   85: invokevirtual 556	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   88: astore_1
    //   89: aload 5
    //   91: aload_1
    //   92: invokevirtual 560	java/io/BufferedInputStream:read	([B)I
    //   95: istore_3
    //   96: iload_3
    //   97: iconst_m1
    //   98: if_icmpeq +17 -> 115
    //   101: aload_2
    //   102: aload_1
    //   103: iconst_0
    //   104: iload_3
    //   105: invokevirtual 564	java/io/FileOutputStream:write	([BII)V
    //   108: aload_2
    //   109: invokevirtual 567	java/io/FileOutputStream:flush	()V
    //   112: goto -23 -> 89
    //   115: invokestatic 552	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   118: aload_1
    //   119: invokevirtual 570	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   122: aload_2
    //   123: invokevirtual 573	java/io/FileOutputStream:close	()V
    //   126: aload 5
    //   128: invokevirtual 574	java/io/BufferedInputStream:close	()V
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
    //   175: invokevirtual 575	java/io/IOException:printStackTrace	()V
    //   178: aload_2
    //   179: ifnull +10 -> 189
    //   182: aload_2
    //   183: invokevirtual 573	java/io/FileOutputStream:close	()V
    //   186: goto +3 -> 189
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 574	java/io/BufferedInputStream:close	()V
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
    //   212: invokevirtual 573	java/io/FileOutputStream:close	()V
    //   215: goto +3 -> 218
    //   218: aload 4
    //   220: ifnull +8 -> 228
    //   223: aload 4
    //   225: invokevirtual 574	java/io/BufferedInputStream:close	()V
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
    //   95	10	3	i	int
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
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("qp_sfu_config.dat");
    return localStringBuilder.toString();
  }
  
  private String b(SFU.UpdateSection paramUpdateSection)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a(paramUpdateSection));
    ((StringBuilder)localObject).append("bak");
    ((StringBuilder)localObject).append(File.separator);
    paramUpdateSection = ((StringBuilder)localObject).toString();
    localObject = new File(paramUpdateSection);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramUpdateSection;
  }
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_query_time", new Date().getTime()).commit();
        d(2);
        this.jdField_a_of_type_Boolean = true;
      }
      else
      {
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_query_time", 0L);
        if (new Date().getTime() - l > 3600000L)
        {
          this.jdField_a_of_type_Boolean = false;
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
  
  private void b(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] cleanup: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      FileUtils.delete(a(paramUpdateSection), false);
    }
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  private boolean b(SFU.UpdateSection paramUpdateSection)
  {
    return true;
  }
  
  private String c(SFU.UpdateSection paramUpdateSection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramUpdateSection));
    localStringBuilder.append(paramUpdateSection.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  private void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = false;
      a("0X80078B5", 0, "", "");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection = null;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] update ended");
      }
      return;
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private boolean c()
  {
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection = null;
    List localList = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a();
    int i = 0;
    while (i < localList.size())
    {
      SFU.UpdateSection localUpdateSection = (SFU.UpdateSection)localList.get(i);
      if (!localUpdateSection.a())
      {
        if ((localUpdateSection.jdField_b_of_type_Boolean) && (localUpdateSection.jdField_a_of_type_Boolean) && (localUpdateSection.jdField_c_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection = localUpdateSection;
          c(0);
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] next update: sid=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection.jdField_a_of_type_Long) }));
          }
          bool = true;
          break label206;
        }
        if (QLog.isColorLevel()) {
          QLog.w("QQProtect.QPUpdate", 2, String.format("[SFU] not matched section: sid=%d, os: %b, qq:%b, cpu:%b", new Object[] { Long.valueOf(localUpdateSection.jdField_a_of_type_Long), Boolean.valueOf(localUpdateSection.jdField_b_of_type_Boolean), Boolean.valueOf(localUpdateSection.jdField_a_of_type_Boolean), Boolean.valueOf(localUpdateSection.jdField_c_of_type_Boolean) }));
        }
        localUpdateSection.a();
      }
      i += 1;
    }
    boolean bool = false;
    label206:
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] get next section result? %b", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private boolean c(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool;
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify package: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      String str = MD5FileUtil.a(c(paramUpdateSection));
      if (str == null) {
        return false;
      }
      bool = str.equalsIgnoreCase(paramUpdateSection.jdField_b_of_type_JavaLangString);
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
  
  private void d()
  {
    a(1, this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("last_update_config_version", 0));
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("last_update_bids").commit();
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
    e();
    d(17);
    return;
    a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection);
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection = null;
    if (a())
    {
      d(16);
      return;
    }
    d(5);
    return;
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) {
      b(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection);
    }
    d(15);
    return;
    if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
    {
      a(0);
      return;
    }
    a("0X80078B3", 0, "", "");
    a(10);
    return;
    if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (b(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
    {
      a(0);
      return;
    }
    a(9);
    return;
    if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (d(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
    {
      d(12);
      return;
    }
    c(8);
    d(13);
    return;
    if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (f(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
    {
      d(11);
      return;
    }
    c(7);
    d(13);
    return;
    if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (e(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
    {
      d(10);
      return;
    }
    a("0X80078B1", 0, "", "");
    a(6);
    return;
    if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (g(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
    {
      d(9);
      return;
    }
    a("0X80078B0", 0, "", "");
    a(5);
    return;
    if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (c(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
    {
      d(8);
      return;
    }
    a("0X80078AF", 0, "", "");
    a(4);
    return;
    if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (h(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection))) {
      return;
    }
    a(3);
    return;
    if ((c()) && (this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null))
    {
      if (!i(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection))
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
    if (this.jdField_a_of_type_Int == 1)
    {
      d(17);
      return;
    }
    d(14);
    return;
  }
  
  private boolean d(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool;
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      if (paramUpdateSection.jdField_c_of_type_JavaUtilList.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] no diff: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
        }
      }
      else
      {
        int i = 0;
        while (i < paramUpdateSection.jdField_c_of_type_JavaUtilList.size())
        {
          SFU.FileInfo localFileInfo = (SFU.FileInfo)paramUpdateSection.jdField_c_of_type_JavaUtilList.get(i);
          if (TextUtils.isEmpty(localFileInfo.g)) {
            str = localFileInfo.f;
          } else {
            str = localFileInfo.g;
          }
          String str = MD5FileUtil.a(str);
          if ((str != null) && (str.equalsIgnoreCase(localFileInfo.jdField_b_of_type_JavaLangString)))
          {
            i += 1;
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label229;
            }
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] not matched: %s!=%s, sid=%d", new Object[] { str, localFileInfo.jdField_b_of_type_JavaLangString, Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
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
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, "[SFU] all sections update complete");
    }
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QSecFramework.a().b();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_update_bids", this.jdField_a_of_type_JavaLangString).putString("last_update_sections", this.jdField_b_of_type_JavaLangString).commit();
        a("0X80078B6", 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] notify update complete: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean e(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      long l2 = paramUpdateSection.f;
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
        if (paramUpdateSection.f <= 0L) {
          break;
        }
        String str = b(paramUpdateSection);
        int i = 0;
        while (i < paramUpdateSection.jdField_c_of_type_JavaUtilList.size())
        {
          SFU.FileInfo localFileInfo = (SFU.FileInfo)paramUpdateSection.jdField_c_of_type_JavaUtilList.get(i);
          l2 = l1;
          if (1 == localFileInfo.jdField_a_of_type_Int)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append(localFileInfo.jdField_c_of_type_JavaLangString);
            localObject = ((StringBuilder)localObject).toString();
            a(new File(localFileInfo.f), new File((String)localObject));
            l2 = l1 + 1L;
          }
          i += 1;
          l1 = l2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup %d files of %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramUpdateSection.jdField_c_of_type_JavaUtilList.size()) }));
        }
      } while (paramUpdateSection.f == l1);
    }
    boolean bool = false;
    label265:
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup result: %b", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private boolean f(SFU.UpdateSection paramUpdateSection)
  {
    if ((paramUpdateSection != null) && (!paramUpdateSection.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] do update files: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      String str = a(paramUpdateSection);
      int i = 0;
      while (i < paramUpdateSection.jdField_c_of_type_JavaUtilList.size())
      {
        SFU.FileInfo localFileInfo = (SFU.FileInfo)paramUpdateSection.jdField_c_of_type_JavaUtilList.get(i);
        File localFile1 = new File(str, localFileInfo.jdField_b_of_type_JavaLangString);
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
            localFileInfo.jdField_a_of_type_Int = 3;
            localFileInfo.g = ((String)localObject);
            bool2 = a(localFile1, localFile2);
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] copied failed, renamed to: %s", new Object[] { localFileInfo.g }));
            }
            bool1 = bool2;
            if (bool2)
            {
              this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(localFileInfo.f, localFileInfo.g).commit();
              bool1 = bool2;
            }
          }
          if (bool1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] success copied: %s", new Object[] { localFileInfo.f }));
            }
            paramUpdateSection.jdField_b_of_type_JavaUtilList.add(localFileInfo);
            paramUpdateSection.g += 1L;
          }
          else
          {
            a("0X80078B2", (int)localFileInfo.jdField_b_of_type_Long, localFileInfo.jdField_a_of_type_JavaLangString, localFileInfo.jdField_b_of_type_JavaLangString);
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
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update %d files of %d", new Object[] { Long.valueOf(paramUpdateSection.g), Integer.valueOf(paramUpdateSection.jdField_c_of_type_JavaUtilList.size()) }));
      }
      if (paramUpdateSection.g == paramUpdateSection.jdField_c_of_type_JavaUtilList.size())
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
  
  private boolean g(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] unzip package: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      String str = a(paramUpdateSection);
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (a() >= 30)
      {
        if (ZipUtils.unZipFile3(c(paramUpdateSection), str) != 0) {}
      }
      else {
        while (ZipUtils.unZipFile2(c(paramUpdateSection), str) == 0)
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
  
  private boolean h(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] download package: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      return a(new QPUpdateManager.UserData(2, 0, a(paramUpdateSection), paramUpdateSection.jdField_a_of_type_JavaLangString, paramUpdateSection.jdField_c_of_type_JavaLangString, paramUpdateSection.jdField_b_of_type_JavaLangString, 0, true, 0, new Date().getTime(), paramUpdateSection.jdField_b_of_type_Int));
    }
    return false;
  }
  
  private boolean i(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] get different: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      List localList = paramUpdateSection.jdField_a_of_type_JavaUtilList;
      int i = 0;
      while (i < localList.size())
      {
        SFU.FileInfo localFileInfo = (SFU.FileInfo)localList.get(i);
        if (!new File(localFileInfo.f).exists())
        {
          localFileInfo.jdField_a_of_type_Int = 2;
          paramUpdateSection.jdField_c_of_type_JavaUtilList.add(localFileInfo);
        }
        else
        {
          String str = MD5FileUtil.a(localFileInfo.f);
          if ((str == null) || (!str.equalsIgnoreCase(localFileInfo.jdField_b_of_type_JavaLangString)))
          {
            localFileInfo.jdField_a_of_type_Int = 1;
            if (str == null) {
              str = "";
            }
            localFileInfo.jdField_c_of_type_JavaLangString = str;
            paramUpdateSection.jdField_c_of_type_JavaUtilList.add(localFileInfo);
            paramUpdateSection.f += 1L;
          }
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] need to update %d files of %d", new Object[] { Integer.valueOf(paramUpdateSection.jdField_c_of_type_JavaUtilList.size()), Integer.valueOf(paramUpdateSection.jdField_a_of_type_JavaUtilList.size()) }));
      }
      return paramUpdateSection.jdField_c_of_type_JavaUtilList.isEmpty() ^ true;
    }
    return false;
  }
  
  public void a()
  {
    long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_query_time", -28800000L);
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
      File localFile = new File(b());
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
        j = -1;
        int i = j;
        if (localUpdateQueryResponse.int32_status != null)
        {
          i = j;
          if (localUpdateQueryResponse.int32_status.has()) {
            i = localUpdateQueryResponse.int32_status.get();
          }
        }
        a("0X80078B8", i, "", "");
        boolean bool3 = true;
        boolean bool2 = false;
        if (i == 0)
        {
          if ((localUpdateQueryResponse.uint32_sec_cmd == null) || (!localUpdateQueryResponse.uint32_sec_cmd.has())) {
            break label615;
          }
          j = localUpdateQueryResponse.uint32_sec_cmd.get();
          if ((localUpdateQueryResponse.uint32_file_id == null) || (!localUpdateQueryResponse.uint32_file_id.has())) {
            break label621;
          }
          k = localUpdateQueryResponse.uint32_file_id.get();
          if ((localUpdateQueryResponse.uint32_file_version == null) || (!localUpdateQueryResponse.uint32_file_version.has())) {
            break label627;
          }
          m = localUpdateQueryResponse.uint32_file_version.get();
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
          n = localUpdateQueryResponse.uint32_zip_flag.get();
          break label648;
          int i1 = a(m, paramToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] resp: cmd=%d, status=%d, fileid=%d, fileversion=%d, md5=%s, url=%s, zipped: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(n) }));
          }
          if ((i1 == 0) && (k == 1))
          {
            a("0X80078AB", k, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, String.format("Need to update config file, fileid=%d", new Object[] { Integer.valueOf(k) }));
            }
            bool1 = a(new QPUpdateManager.UserData(1, k, a(), "qp_sfu_config.dat", paramFromServiceMsg, paramToServiceMsg, m, bool1, 0, new Date().getTime(), 1));
          }
          else
          {
            if (i1 == 1)
            {
              paramToServiceMsg = new File(b());
              if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a(paramToServiceMsg.toString())) {
                break label666;
              }
              if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a().isEmpty())
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
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] Server replied with error, status=%d", new Object[] { Integer.valueOf(i) }));
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
      int j = 0;
      continue;
      label621:
      int k = 0;
      continue;
      label627:
      int m = 0;
      continue;
      label633:
      paramToServiceMsg = "";
      continue;
      label639:
      paramFromServiceMsg = "";
      continue;
      int n = 0;
      if (n == 1)
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
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.obtainMessage(1052688, paramNetResp).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1052689, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPUpdateManager
 * JD-Core Version:    0.7.0.1
 */