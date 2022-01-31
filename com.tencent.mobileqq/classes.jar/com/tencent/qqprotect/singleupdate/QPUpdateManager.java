package com.tencent.qqprotect.singleupdate;

import alyf;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.CommTvRpt;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.qqprotect.common.QSecRptController;
import com.tencent.qqprotect.common.QSecRptHelper;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class QPUpdateManager
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, Manager
{
  private int jdField_a_of_type_Int = 0;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QPUpdateConfig jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig;
  private SFU.UpdateSection jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
  
  private int a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "No matched update from server.");
      }
    }
    String str;
    do
    {
      return -1;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("last_update_config_version", 0) < paramInt) {
        return 0;
      }
      str = b();
      if (!new File(str).exists()) {
        return 0;
      }
      str = MD5FileUtil.a(str);
      if ((str == null) || (!str.equalsIgnoreCase(paramString))) {
        return 0;
      }
    } while ((str == null) || (!str.equalsIgnoreCase(paramString)));
    return 1;
  }
  
  private String a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getDir("qqprotect", 0).toString() + File.separator + "SFU/";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  private String a(SFU.UpdateSection paramUpdateSection)
  {
    paramUpdateSection = a() + paramUpdateSection.jdField_a_of_type_Long + File.separator;
    File localFile = new File(paramUpdateSection);
    if (!localFile.exists()) {
      localFile.mkdirs();
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
        this.jdField_a_of_type_JavaLangString += String.format("#%d#", new Object[] { Long.valueOf(paramUpdateSection.jdField_b_of_type_Long) });
        this.jdField_b_of_type_JavaLangString += String.format("#%d#", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) });
      }
      a("0X80078B4", 0, "", "");
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    paramString3 = String.format("%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null)
    {
      paramInt = (int)this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection.jdField_b_of_type_Long;
      if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection == null) {
        break label188;
      }
    }
    label188:
    for (paramString2 = String.format("%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection.jdField_a_of_type_Long) });; paramString2 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] report: actiontype=%s, actionname=%s, actionfrom=%d, actionresult=%d, sectionId=%s, reportId=%s, fileInfo: %s", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int), paramString2, paramString3, "", "" }));
      }
      QSecRptHelper localQSecRptHelper = new QSecRptHelper();
      localQSecRptHelper.a(paramString1).a(paramString1).a(paramString3).a(paramString2).a(this.jdField_a_of_type_Int);
      QSecRptController.a(localQSecRptHelper.toString(), 105, paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean, NetReq paramNetReq)
  {
    if ((!paramBoolean) || (paramNetReq == null))
    {
      a(3);
      return;
    }
    File localFile = new File(paramNetReq.jdField_c_of_type_JavaLangString);
    alyf localalyf = (alyf)paramNetReq.a();
    if ((!localFile.exists()) || (localalyf == null))
    {
      a(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] http download complete: %s, %s", new Object[] { paramNetReq.jdField_c_of_type_JavaLangString, localalyf.jdField_c_of_type_JavaLangString }));
    }
    switch (localalyf.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      localFile = new File(b());
      new File(paramNetReq.jdField_c_of_type_JavaLangString).renameTo(localFile);
      a("0X80078AC", localalyf.jdField_c_of_type_Int, "", "");
      if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a(localFile.toString()))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("last_update_config_version", localalyf.jdField_c_of_type_Int).commit();
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
      a("0X80078AC", localalyf.jdField_c_of_type_Int, localalyf.jdField_b_of_type_JavaLangString, localalyf.jdField_c_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] invalid config (sig not accepted)");
      }
      a(1);
      return;
    }
    a("0X80078AE", localalyf.jdField_c_of_type_Int, "", "");
    d(7);
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a();
    int i = 0;
    if (i < ((List)localObject).size()) {
      if (((SFU.UpdateSection)((List)localObject).get(i)).a()) {}
    }
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        if (!bool) {
          break label81;
        }
      }
      label81:
      for (localObject = "yes";; localObject = "no")
      {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] all complete: %s", new Object[] { localObject }));
        return bool;
        i += 1;
        break;
      }
    }
  }
  
  private boolean a(alyf paramalyf)
  {
    if (paramalyf == null) {}
    do
    {
      return false;
      if ((paramalyf.jdField_a_of_type_Int == 2) && (paramalyf.e != 1) && (!NetworkUtils.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, "[SFU] donot download file because not using wifi");
        }
        CommTvRpt.a(3, 1);
        return false;
      }
    } while ((paramalyf.jdField_d_of_type_Int < 3) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.contains(paramalyf.jdField_d_of_type_JavaLangString.toLowerCase())));
    INetEngine localINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramalyf.jdField_c_of_type_JavaLangString;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_c_of_type_JavaLangString = (paramalyf.jdField_a_of_type_JavaLangString + paramalyf.jdField_b_of_type_JavaLangString);
    paramalyf.jdField_d_of_type_Int += 1;
    paramalyf.jdField_a_of_type_Long = new Date().getTime();
    localHttpNetReq.a(paramalyf);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramalyf.jdField_d_of_type_JavaLangString.toLowerCase(), localHttpNetReq);
    localINetEngine.a(localHttpNetReq);
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] begin http download %s", new Object[] { paramalyf.jdField_c_of_type_JavaLangString }));
    }
    return true;
  }
  
  private boolean a(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool;
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] rollback: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      if (paramUpdateSection.jdField_b_of_type_JavaUtilList.isEmpty())
      {
        if (!QLog.isColorLevel()) {
          break label355;
        }
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] no files need to rollback");
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] rollback result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      String str = b(paramUpdateSection);
      long l2 = 0L;
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
      if (l2 == paramUpdateSection.jdField_b_of_type_JavaUtilList.size())
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        label355:
        bool = false;
      }
    }
  }
  
  /* Error */
  private boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_2
    //   10: invokevirtual 118	java/io/File:exists	()Z
    //   13: ifeq +41 -> 54
    //   16: aload_2
    //   17: invokevirtual 473	java/io/File:delete	()Z
    //   20: istore 5
    //   22: iload 5
    //   24: ifne +90 -> 114
    //   27: iconst_0
    //   28: ifeq +11 -> 39
    //   31: new 494	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 495	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: iconst_0
    //   40: ifeq +11 -> 51
    //   43: new 494	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 495	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: iload 4
    //   53: ireturn
    //   54: new 112	java/io/File
    //   57: dup
    //   58: aload_2
    //   59: invokevirtual 498	java/io/File:getParent	()Ljava/lang/String;
    //   62: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore 8
    //   67: aload 8
    //   69: invokevirtual 118	java/io/File:exists	()Z
    //   72: ifne +42 -> 114
    //   75: aload 8
    //   77: invokevirtual 154	java/io/File:mkdirs	()Z
    //   80: istore 5
    //   82: iload 5
    //   84: ifne +30 -> 114
    //   87: iconst_0
    //   88: ifeq +11 -> 99
    //   91: new 494	java/lang/NullPointerException
    //   94: dup
    //   95: invokespecial 495	java/lang/NullPointerException:<init>	()V
    //   98: athrow
    //   99: iconst_0
    //   100: ifeq -49 -> 51
    //   103: new 494	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 495	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: astore_1
    //   112: iconst_0
    //   113: ireturn
    //   114: new 500	java/io/FileOutputStream
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 503	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   122: astore_2
    //   123: new 505	java/io/BufferedInputStream
    //   126: dup
    //   127: new 507	java/io/FileInputStream
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 508	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   135: invokespecial 511	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   138: astore_1
    //   139: invokestatic 517	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   142: sipush 4096
    //   145: invokevirtual 521	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   148: astore 6
    //   150: aload_1
    //   151: aload 6
    //   153: invokevirtual 525	java/io/BufferedInputStream:read	([B)I
    //   156: istore_3
    //   157: iload_3
    //   158: iconst_m1
    //   159: if_icmpeq +58 -> 217
    //   162: aload_2
    //   163: aload 6
    //   165: iconst_0
    //   166: iload_3
    //   167: invokevirtual 529	java/io/FileOutputStream:write	([BII)V
    //   170: aload_2
    //   171: invokevirtual 532	java/io/FileOutputStream:flush	()V
    //   174: goto -24 -> 150
    //   177: astore 7
    //   179: aload_1
    //   180: astore 6
    //   182: aload_2
    //   183: astore_1
    //   184: aload 6
    //   186: astore_2
    //   187: aload 7
    //   189: astore 6
    //   191: aload 6
    //   193: invokevirtual 533	java/io/IOException:printStackTrace	()V
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 536	java/io/FileOutputStream:close	()V
    //   204: aload_2
    //   205: ifnull -154 -> 51
    //   208: aload_2
    //   209: invokevirtual 537	java/io/BufferedInputStream:close	()V
    //   212: iconst_0
    //   213: ireturn
    //   214: astore_1
    //   215: iconst_0
    //   216: ireturn
    //   217: invokestatic 517	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   220: aload 6
    //   222: invokevirtual 540	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   225: iconst_1
    //   226: istore 4
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 536	java/io/FileOutputStream:close	()V
    //   236: aload_1
    //   237: ifnull -186 -> 51
    //   240: aload_1
    //   241: invokevirtual 537	java/io/BufferedInputStream:close	()V
    //   244: iconst_1
    //   245: ireturn
    //   246: astore_1
    //   247: iconst_1
    //   248: ireturn
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_2
    //   252: aload_2
    //   253: ifnull +7 -> 260
    //   256: aload_2
    //   257: invokevirtual 536	java/io/FileOutputStream:close	()V
    //   260: aload 6
    //   262: ifnull +8 -> 270
    //   265: aload 6
    //   267: invokevirtual 537	java/io/BufferedInputStream:close	()V
    //   270: aload_1
    //   271: athrow
    //   272: astore_1
    //   273: goto -234 -> 39
    //   276: astore_1
    //   277: iconst_0
    //   278: ireturn
    //   279: astore_1
    //   280: goto -181 -> 99
    //   283: astore_2
    //   284: goto -48 -> 236
    //   287: astore_1
    //   288: goto -84 -> 204
    //   291: astore_2
    //   292: goto -32 -> 260
    //   295: astore_2
    //   296: goto -26 -> 270
    //   299: astore_1
    //   300: goto -48 -> 252
    //   303: astore 7
    //   305: aload_1
    //   306: astore 6
    //   308: aload 7
    //   310: astore_1
    //   311: goto -59 -> 252
    //   314: astore 6
    //   316: aload_1
    //   317: astore 7
    //   319: aload 6
    //   321: astore_1
    //   322: aload_2
    //   323: astore 6
    //   325: aload 7
    //   327: astore_2
    //   328: goto -76 -> 252
    //   331: astore 6
    //   333: aconst_null
    //   334: astore_1
    //   335: aload 7
    //   337: astore_2
    //   338: goto -147 -> 191
    //   341: astore 6
    //   343: aload_2
    //   344: astore_1
    //   345: aload 7
    //   347: astore_2
    //   348: goto -157 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	QPUpdateManager
    //   0	351	1	paramFile1	File
    //   0	351	2	paramFile2	File
    //   156	11	3	i	int
    //   7	220	4	bool1	boolean
    //   20	63	5	bool2	boolean
    //   1	306	6	localObject1	Object
    //   314	6	6	localObject2	Object
    //   323	1	6	localFile1	File
    //   331	1	6	localIOException1	java.io.IOException
    //   341	1	6	localIOException2	java.io.IOException
    //   4	1	7	localObject3	Object
    //   177	11	7	localIOException3	java.io.IOException
    //   303	6	7	localObject4	Object
    //   317	29	7	localFile2	File
    //   65	11	8	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   103	111	111	java/io/IOException
    //   139	150	177	java/io/IOException
    //   150	157	177	java/io/IOException
    //   162	174	177	java/io/IOException
    //   217	225	177	java/io/IOException
    //   208	212	214	java/io/IOException
    //   240	244	246	java/io/IOException
    //   9	22	249	finally
    //   54	82	249	finally
    //   114	123	249	finally
    //   31	39	272	java/io/IOException
    //   43	51	276	java/io/IOException
    //   91	99	279	java/io/IOException
    //   232	236	283	java/io/IOException
    //   200	204	287	java/io/IOException
    //   256	260	291	java/io/IOException
    //   265	270	295	java/io/IOException
    //   123	139	299	finally
    //   139	150	303	finally
    //   150	157	303	finally
    //   162	174	303	finally
    //   217	225	303	finally
    //   191	196	314	finally
    //   9	22	331	java/io/IOException
    //   54	82	331	java/io/IOException
    //   114	123	331	java/io/IOException
    //   123	139	341	java/io/IOException
  }
  
  private String b()
  {
    return a() + "qp_sfu_config.dat";
  }
  
  private String b(SFU.UpdateSection paramUpdateSection)
  {
    paramUpdateSection = a(paramUpdateSection) + "bak" + File.separator;
    File localFile = new File(paramUpdateSection);
    if (!localFile.exists()) {
      localFile.mkdirs();
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
      do
      {
        return;
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_query_time", 0L);
        if (new Date().getTime() - l > 3600000L)
        {
          this.jdField_a_of_type_Boolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, "[SFU] last udpate timeout");
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQProtect.QPUpdate", 2, "[SFU] already being updating");
    }
  }
  
  private void b(NetResp paramNetResp)
  {
    boolean bool = true;
    if (paramNetResp == null) {}
    alyf localalyf;
    do
    {
      do
      {
        return;
        if (paramNetResp.jdField_a_of_type_Int != 3) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] http download error=%d", new Object[] { Integer.valueOf(paramNetResp.jdField_a_of_type_Int) }));
      return;
      localalyf = (alyf)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    } while (localalyf == null);
    if (paramNetResp.jdField_a_of_type_Int == 0) {}
    while (!bool)
    {
      try
      {
        if (localalyf.jdField_d_of_type_Int >= 3) {
          break label146;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] retried to download, retry=%d, result=%b, url=%s", new Object[] { Integer.valueOf(localalyf.jdField_d_of_type_Int), Boolean.valueOf(bool), localalyf.jdField_c_of_type_JavaLangString }));
        }
        a(localalyf);
        return;
      }
      catch (Throwable paramNetResp)
      {
        paramNetResp.printStackTrace();
        return;
      }
      bool = false;
      continue;
      label146:
      File localFile = new File(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_c_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localalyf.jdField_d_of_type_JavaLangString.toLowerCase());
    a(bool, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
  }
  
  private void b(SFU.UpdateSection paramUpdateSection)
  {
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] cleanup: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      FileUtils.a(a(paramUpdateSection), false);
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
    return a(paramUpdateSection) + paramUpdateSection.jdField_a_of_type_JavaLangString;
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
    label150:
    boolean bool;
    if (i < localList.size())
    {
      SFU.UpdateSection localUpdateSection = (SFU.UpdateSection)localList.get(i);
      if (localUpdateSection.a()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localUpdateSection.jdField_b_of_type_Boolean) && (localUpdateSection.jdField_a_of_type_Boolean) && (localUpdateSection.jdField_c_of_type_Boolean)) {
          break label150;
        }
        if (QLog.isColorLevel()) {
          QLog.w("QQProtect.QPUpdate", 2, String.format("[SFU] not matched section: sid=%d, os: %b, qq:%b, cpu:%b", new Object[] { Long.valueOf(localUpdateSection.jdField_a_of_type_Long), Boolean.valueOf(localUpdateSection.jdField_b_of_type_Boolean), Boolean.valueOf(localUpdateSection.jdField_a_of_type_Boolean), Boolean.valueOf(localUpdateSection.jdField_c_of_type_Boolean) }));
        }
        localUpdateSection.a();
      }
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection = localUpdateSection;
      c(0);
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] next update: sid=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection.jdField_a_of_type_Long) }));
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] get next section result? %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      bool = true;
      continue;
      bool = false;
    }
  }
  
  private boolean c(SFU.UpdateSection paramUpdateSection)
  {
    String str;
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify package: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      str = MD5FileUtil.a(c(paramUpdateSection));
      if (str == null) {
        return false;
      }
    }
    for (boolean bool = str.equalsIgnoreCase(paramUpdateSection.jdField_b_of_type_JavaLangString);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
    }
  }
  
  private void d()
  {
    a(1, this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("last_update_config_version", 0));
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("last_update_bids").commit();
  }
  
  private void d(int paramInt)
  {
    QLog.d("QQProtect.QPUpdate", 1, String.format("[SFU] update event: %d", new Object[] { Integer.valueOf(paramInt) }));
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
    case 1: 
    case 2: 
    case 5: 
    case 6: 
      do
      {
        return;
        try
        {
          if (this.jdField_a_of_type_Int == 1)
          {
            d(17);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return;
        }
        d(14);
        return;
        d();
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
      } while ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (h(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)));
      a(3);
      return;
    case 7: 
      if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (c(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
      {
        d(8);
        return;
      }
      a("0X80078AF", 0, "", "");
      a(4);
      return;
    case 8: 
      if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (g(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
      {
        d(9);
        return;
      }
      a("0X80078B0", 0, "", "");
      a(5);
      return;
    case 9: 
      if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (e(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
      {
        d(10);
        return;
      }
      a("0X80078B1", 0, "", "");
      a(6);
      return;
    case 10: 
      if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (f(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
      {
        d(11);
        return;
      }
      c(7);
      d(13);
      return;
    case 11: 
      if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (d(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
      {
        d(12);
        return;
      }
      c(8);
      d(13);
      return;
    case 12: 
      if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (b(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
      {
        a(0);
        return;
      }
      a(9);
      return;
    case 13: 
      if ((this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) && (a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection)))
      {
        a(0);
        return;
      }
      a("0X80078B3", 0, "", "");
      a(10);
      return;
    case 14: 
      if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection != null) {
        b(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection);
      }
      d(15);
      return;
    case 15: 
      a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection);
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateSFU$UpdateSection = null;
      if (a())
      {
        d(16);
        return;
      }
      d(5);
      return;
    case 16: 
      e();
      d(17);
      return;
    }
    c();
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
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      int i = 0;
      for (;;)
      {
        if (i < paramUpdateSection.jdField_c_of_type_JavaUtilList.size())
        {
          SFU.FileInfo localFileInfo = (SFU.FileInfo)paramUpdateSection.jdField_c_of_type_JavaUtilList.get(i);
          if (TextUtils.isEmpty(localFileInfo.g)) {}
          for (String str = localFileInfo.f;; str = localFileInfo.g)
          {
            str = MD5FileUtil.a(str);
            if ((str != null) && (str.equalsIgnoreCase(localFileInfo.jdField_b_of_type_JavaLangString))) {
              break label246;
            }
            if (!QLog.isColorLevel()) {
              break label253;
            }
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] not matched: %s!=%s, sid=%d", new Object[] { str, localFileInfo.jdField_b_of_type_JavaLangString, Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
            bool = false;
            break;
          }
          label246:
          i += 1;
          continue;
          label253:
          bool = false;
          break;
        }
      }
      bool = true;
    }
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
        Intent localIntent = new Intent("com.tencent.qqprotect.singleupdate");
        localIntent.setPackage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
        localIntent.putExtra("UPDATED_BIDS", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("last_update_bids", this.jdField_a_of_type_JavaLangString).putString("last_update_sections", this.jdField_b_of_type_JavaLangString).commit();
        a("0X80078B6", 0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] notify update complete: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean e(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool;
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      if (paramUpdateSection.f == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, "[SFU] no files need to backup");
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      if (paramUpdateSection.f > 0L)
      {
        String str1 = b(paramUpdateSection);
        long l1 = 0L;
        int i = 0;
        while (i < paramUpdateSection.jdField_c_of_type_JavaUtilList.size())
        {
          SFU.FileInfo localFileInfo = (SFU.FileInfo)paramUpdateSection.jdField_c_of_type_JavaUtilList.get(i);
          long l2 = l1;
          if (1 == localFileInfo.jdField_a_of_type_Int)
          {
            String str2 = str1 + localFileInfo.jdField_c_of_type_JavaLangString;
            a(new File(localFileInfo.f), new File(str2));
            l2 = l1 + 1L;
          }
          i += 1;
          l1 = l2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] backup %d files of %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramUpdateSection.jdField_c_of_type_JavaUtilList.size()) }));
        }
        if (paramUpdateSection.f == l1) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private boolean f(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool1;
    if ((paramUpdateSection != null) && (!paramUpdateSection.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] do update files: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      String str = a(paramUpdateSection);
      int i = 0;
      if (i < paramUpdateSection.jdField_c_of_type_JavaUtilList.size())
      {
        SFU.FileInfo localFileInfo = (SFU.FileInfo)paramUpdateSection.jdField_c_of_type_JavaUtilList.get(i);
        File localFile1 = new File(str, localFileInfo.jdField_b_of_type_JavaLangString);
        Object localObject = new File(localFileInfo.f);
        if ((!localFile1.exists()) || (!localFile1.canRead())) {
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] copied failed, src not existed or cannot read: %s", new Object[] { localFile1.toString() }));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          boolean bool2 = a(localFile1, (File)localObject);
          bool1 = bool2;
          if (!bool2)
          {
            localObject = localFileInfo.f + ".1";
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
          if (!bool1) {
            break label376;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] success copied: %s", new Object[] { localFileInfo.f }));
          }
          paramUpdateSection.jdField_b_of_type_JavaUtilList.add(localFileInfo);
          paramUpdateSection.g += 1L;
        }
        label376:
        a("0X80078B2", (int)localFileInfo.jdField_b_of_type_Long, localFileInfo.jdField_a_of_type_JavaLangString, localFileInfo.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] failed copied: %s", new Object[] { localFileInfo.f }));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update %d files of %d", new Object[] { Long.valueOf(paramUpdateSection.g), Integer.valueOf(paramUpdateSection.jdField_c_of_type_JavaUtilList.size()) }));
      }
      if (paramUpdateSection.g == paramUpdateSection.jdField_c_of_type_JavaUtilList.size()) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] update result: %b", new Object[] { Boolean.valueOf(bool1) }));
      }
      return bool1;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  private boolean g(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool;
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
      if (ZipUtils.b(c(paramUpdateSection), str) == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] unzip result: %b", new Object[] { Boolean.valueOf(bool) }));
      }
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private boolean h(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool = false;
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] download package: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      bool = a(new alyf(2, 0, a(paramUpdateSection), paramUpdateSection.jdField_a_of_type_JavaLangString, paramUpdateSection.jdField_c_of_type_JavaLangString, paramUpdateSection.jdField_b_of_type_JavaLangString, 0, true, 0, new Date().getTime(), paramUpdateSection.jdField_b_of_type_Int));
    }
    return bool;
  }
  
  private boolean i(SFU.UpdateSection paramUpdateSection)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramUpdateSection != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] get different: sid=%d", new Object[] { Long.valueOf(paramUpdateSection.jdField_a_of_type_Long) }));
      }
      List localList = paramUpdateSection.jdField_a_of_type_JavaUtilList;
      int i = 0;
      if (i < localList.size())
      {
        SFU.FileInfo localFileInfo = (SFU.FileInfo)localList.get(i);
        if (!new File(localFileInfo.f).exists())
        {
          localFileInfo.jdField_a_of_type_Int = 2;
          paramUpdateSection.jdField_c_of_type_JavaUtilList.add(localFileInfo);
        }
        String str;
        do
        {
          i += 1;
          break;
          str = MD5FileUtil.a(localFileInfo.f);
        } while ((str != null) && (str.equalsIgnoreCase(localFileInfo.jdField_b_of_type_JavaLangString)));
        localFileInfo.jdField_a_of_type_Int = 1;
        if (str != null) {}
        for (;;)
        {
          localFileInfo.jdField_c_of_type_JavaLangString = str;
          paramUpdateSection.jdField_c_of_type_JavaUtilList.add(localFileInfo);
          paramUpdateSection.f += 1L;
          break;
          str = "";
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] need to update %d files of %d", new Object[] { Integer.valueOf(paramUpdateSection.jdField_c_of_type_JavaUtilList.size()), Integer.valueOf(paramUpdateSection.jdField_a_of_type_JavaUtilList.size()) }));
      }
      bool1 = bool2;
      if (!paramUpdateSection.jdField_c_of_type_JavaUtilList.isEmpty()) {
        bool1 = true;
      }
    }
    return bool1;
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
    }
    for (;;)
    {
      d(1);
      return;
      File localFile = new File(b());
      if (localFile.exists())
      {
        localFile.delete();
        continue;
        c(paramInt);
      }
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1052689, (int)paramLong1, (int)paramLong2, paramNetReq).sendToTarget();
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    while (!(paramNetReq instanceof HttpNetReq)) {
      return;
    }
    paramNetReq = (HttpNetReq)paramNetReq;
    paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
    paramNetResp.c = 0L;
    paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
    paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
  }
  
  public void a(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1052688, paramNetResp).sendToTarget();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    for (;;)
    {
      int i;
      int j;
      int n;
      try
      {
        QQProtectUpdate.UpdateQueryResponse localUpdateQueryResponse = new QQProtectUpdate.UpdateQueryResponse();
        bool1 = bool2;
        int i1;
        if (localUpdateQueryResponse != null)
        {
          localUpdateQueryResponse.mergeFrom((byte[])paramObject);
          if ((localUpdateQueryResponse.int32_status == null) || (!localUpdateQueryResponse.int32_status.has())) {
            break label644;
          }
          i = localUpdateQueryResponse.int32_status.get();
          a("0X80078B8", i, "", "");
          if (i != 0) {
            break label597;
          }
          if ((localUpdateQueryResponse.uint32_sec_cmd == null) || (!localUpdateQueryResponse.uint32_sec_cmd.has())) {
            break label638;
          }
          j = localUpdateQueryResponse.uint32_sec_cmd.get();
          int m = 0;
          int k = m;
          if (localUpdateQueryResponse.uint32_file_id != null)
          {
            k = m;
            if (localUpdateQueryResponse.uint32_file_id.has()) {
              k = localUpdateQueryResponse.uint32_file_id.get();
            }
          }
          n = 0;
          m = n;
          if (localUpdateQueryResponse.uint32_file_version != null)
          {
            m = n;
            if (localUpdateQueryResponse.uint32_file_version.has()) {
              m = localUpdateQueryResponse.uint32_file_version.get();
            }
          }
          paramFromServiceMsg = "";
          paramToServiceMsg = paramFromServiceMsg;
          if (localUpdateQueryResponse.string_file_hash != null)
          {
            paramToServiceMsg = paramFromServiceMsg;
            if (localUpdateQueryResponse.string_file_hash.has()) {
              paramToServiceMsg = localUpdateQueryResponse.string_file_hash.get();
            }
          }
          paramObject = "";
          paramFromServiceMsg = paramObject;
          if (localUpdateQueryResponse.string_file_url != null)
          {
            paramFromServiceMsg = paramObject;
            if (localUpdateQueryResponse.string_file_url.has()) {
              paramFromServiceMsg = localUpdateQueryResponse.string_file_url.get();
            }
          }
          i1 = 0;
          n = i1;
          if (localUpdateQueryResponse.uint32_zip_flag == null) {
            break label650;
          }
          n = i1;
          if (!localUpdateQueryResponse.uint32_zip_flag.has()) {
            break label650;
          }
          n = localUpdateQueryResponse.uint32_zip_flag.get();
          break label650;
          i1 = a(m, paramToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] resp: cmd=%d, status=%d, fileid=%d, fileversion=%d, md5=%s, url=%s, zipped: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(n) }));
          }
          if ((i1 == 0) && (k == 1))
          {
            a("0X80078AB", k, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("QQProtect.QPUpdate", 2, String.format("Need to update config file, fileid=%d", new Object[] { Integer.valueOf(k) }));
            }
            bool1 = a(new alyf(1, k, a(), "qp_sfu_config.dat", paramFromServiceMsg, paramToServiceMsg, m, bool1, 0, new Date().getTime(), 1));
          }
        }
        else
        {
          if (bool1) {
            break label662;
          }
          d(17);
          return;
        }
        if (i1 == 1)
        {
          paramToServiceMsg = new File(b());
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a(paramToServiceMsg.toString())) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPUpdateConfig.a().isEmpty()) {
            d(16);
          } else {
            d(5);
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        d(17);
        return;
      }
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QPUpdate", 2, "[SFU] NO Need UPDATE");
        bool1 = bool2;
        continue;
        label597:
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("QQProtect.QPUpdate", 2, String.format("[SFU] Server replied with error, status=%d", new Object[] { Integer.valueOf(i) }));
          bool1 = bool2;
          continue;
          label638:
          j = 0;
          continue;
          label644:
          i = -1;
          continue;
          label650:
          if (n == 1)
          {
            bool1 = true;
          }
          else
          {
            label662:
            bool1 = false;
            continue;
            bool1 = true;
          }
        }
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
    }
    for (;;)
    {
      return false;
      b((NetResp)paramMessage.obj);
      continue;
      a((NetReq)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPUpdateManager
 * JD-Core Version:    0.7.0.1
 */