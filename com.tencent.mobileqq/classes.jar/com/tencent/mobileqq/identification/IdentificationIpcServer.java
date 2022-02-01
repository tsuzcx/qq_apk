package com.tencent.mobileqq.identification;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyServlet;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.old.AEOldResInfo;
import dov.com.qq.im.ae.download.old.AEOldResManager;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.SVConfigItem;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class IdentificationIpcServer
  extends QIPCModule
{
  private static volatile IdentificationIpcServer jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer;
  private static String jdField_a_of_type_JavaLangString = "{\n\"name\": \"new_qq_android_native_short_new_other_7\",\n\"arm_url\": \"\",\n\"armv7a_url\": \"https://downv6.qq.com/faceIdentify/new_qq_android_native_short_other_new_7_7.zip\",\n\"arm64v8a_url\": \"https://downv6.qq.com/faceIdentify/new_qq_android_native_short_other_new64_7_7.zip\",\n\"x86_url\": \" \",\n\"arm_md5\": \" \",\n\"arm64v8a_md5\": \"b2a772fb3347f863a2ec69b4459d5869\",\n\"armv7a_md5\": \"c2efd14194e1f7c6af3b75c9e5bd0414\",\n\"x86_md5\": \"\",\n\"versionCode\": \"7\",\n\"predownload\": false\n}";
  private static final List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "setFaceData", "identify", "deleteFace", "changeSecureMobile" });
  private int jdField_a_of_type_Int;
  private ConfigManager jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager;
  private HttpEngineServiceImpl jdField_a_of_type_ComTencentMobileqqTransfileApiImplHttpEngineServiceImpl;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  
  private IdentificationIpcServer(String paramString)
  {
    super(paramString);
  }
  
  private ITransactionCallback a(File paramFile, EIPCResult paramEIPCResult, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    return new IdentificationIpcServer.4(this, paramFile, paramEIPCResult, paramQQAppInterface, paramInt2, paramInt3, paramInt1);
  }
  
  public static IdentificationIpcServer a()
  {
    if (jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer == null) {
        jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer = new IdentificationIpcServer("IdentificationIpcServer_Model");
      }
      return jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer;
    }
    finally {}
  }
  
  private JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(jdField_a_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("qqidentification_server", 1, "getDefaultConfigJson e: ", localJSONException);
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager.onDestroy();
    }
  }
  
  private void a(Bundle paramBundle)
  {
    QLog.d("qqidentification_server", 1, "start upload file");
    EIPCResult localEIPCResult = new EIPCResult();
    Bundle localBundle = new Bundle();
    localEIPCResult.data = localBundle;
    Object localObject1 = paramBundle.getString("filePath", null);
    File localFile;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localFile = new File((String)localObject1);
      if (localFile.exists()) {}
    }
    else
    {
      QLog.e("qqidentification_server", 1, "invalid path");
      localEIPCResult.code = -102;
      localBundle.putString("subError", "no file");
      localBundle.putBoolean("reset_null", true);
      callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("md5");
    if (arrayOfByte == null)
    {
      QLog.e("qqidentification_server", 1, "md5 is null");
      localEIPCResult.code = -102;
      localBundle.putString("subError", "no md5");
      localBundle.putBoolean("reset_null", true);
      callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
    }
    int i = paramBundle.getInt("serviceType", -1);
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int j = paramBundle.getInt("srcAppId", 0);
    int k = paramBundle.getInt("key_identification_type", 2);
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("method", null);
    ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X80097EB", "0X80097EB", 0, 0, i + "", "" + k, j + "", "");
    if ((this.jdField_b_of_type_JavaLangString == null) || (jdField_a_of_type_JavaUtilList.contains(this.jdField_b_of_type_JavaLangString))) {}
    String str1;
    String str2;
    for (localObject1 = new Transaction(((QQAppInterface)localObject2).getCurrentAccountUin(), 61, (String)localObject1, 0, arrayOfByte, a(localFile, localEIPCResult, (QQAppInterface)localObject2, j, i, k), null, false);; localObject1 = new Transaction(str1, 61, (String)localObject1, 0, Base64.decode(str2, 11), arrayOfByte, a(localFile, localEIPCResult, (QQAppInterface)localObject2, j, i, k)))
    {
      localObject2 = ((QQAppInterface)localObject2).getHwEngine();
      if (FaceContext.c.contains(this.jdField_b_of_type_JavaLangString))
      {
        ((HwEngine)localObject2).currentUin = paramBundle.getString("uin", "");
        this.jdField_a_of_type_ComTencentMobileqqHighwayConfigConfigManager = ConfigManager.getInstance(BaseApplicationImpl.getContext(), (HwEngine)localObject2);
      }
      i = ((HwEngine)localObject2).submitTransactionTask((Transaction)localObject1);
      if (i == 0) {
        break;
      }
      QLog.e("qqidentification_server", 1, "submit error: " + i);
      localEIPCResult.code = -102;
      localBundle.putBoolean("reset_null", true);
      localBundle.putString("subError", "UPLOAD submitTransaction retCode=" + i);
      callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
      return;
      str1 = paramBundle.getString("uin", "");
      str2 = paramBundle.getString("ticket", "");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
        QLog.i("qqidentification_server", 1, "uin or ticket is null");
      }
    }
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null)
    {
      QLog.d("qqidentification_server", 1, " params = null");
      return;
    }
    int i = paramBundle.getInt("srcAppId", 0);
    String str1 = paramBundle.getString("key", "");
    String str2 = paramBundle.getString("lightInfo", null);
    String str3 = paramBundle.getString("method", null);
    String str4 = paramBundle.getString("uin", null);
    long l = paramBundle.getLong("nonce", -1L);
    if ((i == 0) || (TextUtils.isEmpty(str1)))
    {
      QLog.d("qqidentification_server", 1, " KEY_APP_ID not exist or temKey is empty");
      return;
    }
    if ((FaceContext.c.contains(str3)) && (TextUtils.isEmpty(str4)))
    {
      QLog.d("qqidentification_server", 1, "method is loginVerify but uin is empty");
      return;
    }
    paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FaceDetectForThirdPartyManager localFaceDetectForThirdPartyManager = (FaceDetectForThirdPartyManager)paramBundle.getManager(QQManagerFactory.THIRD_PARTY_FACE_DETECT_MANAGER);
    FaceDetectForThirdPartyServlet.a(paramBundle, str3, str4, i, AppSetting.a(), str2, str1, l, new IdentificationIpcServer.3(this, localFaceDetectForThirdPartyManager, paramInt, paramBundle));
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    QLog.d("qqidentification_server", 1, "start downloadDefaultConfig");
    JSONObject localJSONObject = a();
    if (localJSONObject == null)
    {
      QLog.e("qqidentification_server", 1, "downloadDefaultConfig, defaultConfigJson is null");
      return;
    }
    a(paramQQAppInterface, (AEOldShortVideoResManager.SVConfigItem)JSONUtils.a(localJSONObject, AEOldShortVideoResManager.SVConfigItem.class));
  }
  
  private void a(QQAppInterface paramQQAppInterface, Bundle paramBundle, int paramInt)
  {
    String str = paramBundle.getString("method", null);
    int i = paramBundle.getInt("srcAppId");
    paramBundle = paramBundle.getString("uin");
    FaceContext.a().a(paramQQAppInterface, BaseApplicationImpl.getContext(), i, str, paramBundle, new IdentificationIpcServer.2(this, paramInt));
  }
  
  private void a(QQAppInterface paramQQAppInterface, AEOldShortVideoResManager.SVConfigItem paramSVConfigItem)
  {
    int i = paramSVConfigItem.versionCode;
    if (i < 7)
    {
      a(paramQQAppInterface);
      return;
    }
    String str1 = paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath() + "/YT_identify_new/";
    String str2 = paramSVConfigItem.armv7a_url;
    paramSVConfigItem = paramSVConfigItem.armv7a_md5;
    QLog.d("qqidentification_server", 1, new Object[] { "no res,start download, localpath is", str1, " version is : ", Integer.valueOf(i), " app so bits is : ", Integer.valueOf(IdentificationActivityHelper.b()) });
    a(paramQQAppInterface, str2, paramSVConfigItem, str1, i);
  }
  
  /* Error */
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_0
    //   6: getfield 52	com/tencent/mobileqq/identification/IdentificationIpcServer:jdField_b_of_type_Boolean	Z
    //   9: iload_1
    //   10: iand
    //   11: putfield 52	com/tencent/mobileqq/identification/IdentificationIpcServer:jdField_b_of_type_Boolean	Z
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 421	com/tencent/mobileqq/identification/IdentificationIpcServer:jdField_a_of_type_Boolean	Z
    //   19: aload_0
    //   20: getfield 421	com/tencent/mobileqq/identification/IdentificationIpcServer:jdField_a_of_type_Boolean	Z
    //   23: ifeq +69 -> 92
    //   26: new 103	eipc/EIPCResult
    //   29: dup
    //   30: invokespecial 104	eipc/EIPCResult:<init>	()V
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 52	com/tencent/mobileqq/identification/IdentificationIpcServer:jdField_b_of_type_Boolean	Z
    //   38: ifeq +57 -> 95
    //   41: aload_3
    //   42: iload_2
    //   43: putfield 137	eipc/EIPCResult:code	I
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 423	com/tencent/mobileqq/identification/IdentificationIpcServer:jdField_b_of_type_Int	I
    //   51: aload_3
    //   52: invokevirtual 155	com/tencent/mobileqq/identification/IdentificationIpcServer:callbackResult	(ILeipc/EIPCResult;)V
    //   55: aload_0
    //   56: getfield 50	com/tencent/mobileqq/identification/IdentificationIpcServer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: iconst_0
    //   60: invokevirtual 426	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   63: ldc 79
    //   65: iconst_1
    //   66: new 199	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 428
    //   76: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 52	com/tencent/mobileqq/identification/IdentificationIpcServer:jdField_b_of_type_Boolean	Z
    //   83: invokevirtual 431	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   86: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: iconst_1
    //   96: istore_2
    //   97: goto -56 -> 41
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	IdentificationIpcServer
    //   0	105	1	paramBoolean	boolean
    //   1	96	2	i	int
    //   33	19	3	localEIPCResult	EIPCResult
    //   100	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	41	100	finally
    //   41	92	100	finally
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.d("qqidentification_server", 1, "getManageConf, app is null");
      return;
    }
    if (!paramQQAppInterface.isLogin())
    {
      QLog.d("qqidentification_server", 1, "startDownloadResourceNoLogin");
      AEOldShortVideoResDownload.b(paramQQAppInterface);
      return;
    }
    QLog.d("qqidentification_server", 1, "startDownloadResource");
    AEOldResManager.a().b(AEOldResInfo.b, null, false);
    AEOldShortVideoResDownload.a(paramQQAppInterface);
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramQQAppInterface = paramString3 + "identification.zip";
    paramString2 = new IdentificationIpcServer.5(this, paramString2, paramString3, paramString1, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiImplHttpEngineServiceImpl == null)
    {
      paramString3 = new HttpCommunicator(4);
      paramString3.start();
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiImplHttpEngineServiceImpl = new HttpEngineServiceImpl(paramString3, false);
    }
    paramString3 = new HttpNetReq();
    paramString3.mCallback = paramString2;
    paramString3.mHttpMethod = 0;
    paramString3.mReqUrl = paramString1;
    paramString3.mOutPath = paramQQAppInterface;
    paramString3.mPrioty = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiImplHttpEngineServiceImpl.sendReq(paramString3);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.d("qqidentification_server", 1, "identification res downloading,repeat request... ");
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_b_of_type_Boolean = true;
    FileUtils.b(paramString3);
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = AEOldShortVideoResManager.a();
    QLog.d("qqidentification_server", 1, "config content....." + (String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new ArrayList();
      QLog.d("qqidentification_server", 1, new Object[] { "configContent is not empty, parseConfig result is ", Integer.valueOf(AEOldShortVideoResManager.a((String)localObject1, (List)localObject2)) });
      if (((List)localObject2).size() > 0)
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AEOldShortVideoResManager.SVConfigItem)((Iterator)localObject1).next();
          if (((AEOldShortVideoResManager.SVConfigItem)localObject2).name.startsWith("new_qq_android_native_short_new_other_")) {
            a(localQQAppInterface, (AEOldShortVideoResManager.SVConfigItem)localObject2);
          }
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        b(localQQAppInterface);
        if (localQQAppInterface.isLogin()) {
          a(localQQAppInterface);
        }
      }
      return bool;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("qqidentification_server", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    if ("action_upload".equals(paramString))
    {
      if (paramBundle == null)
      {
        QLog.d("qqidentification_server", 1, "onCall, param is null, action=" + paramString + ", callBackId=" + paramInt);
        paramString = new Bundle();
        paramString.putString("subError", "no params");
        paramString.putBoolean("reset_null", true);
        callbackResult(paramInt, EIPCResult.createResult(-102, paramString));
        return null;
      }
      ThreadManager.excute(new IdentificationIpcServer.1(this, paramBundle), 128, null, false);
    }
    for (;;)
    {
      return null;
      if ("action_is_video_chatting".equals(paramString))
      {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        paramBundle = new EIPCResult();
        if (paramString.isUsingCameraOnVideo()) {}
        for (paramInt = 1;; paramInt = 2)
        {
          paramBundle.code = paramInt;
          return paramBundle;
        }
      }
      if ("action_res_download".equals(paramString))
      {
        this.jdField_b_of_type_Int = paramInt;
        a();
        return null;
      }
      if ("action_face_usable".equals(paramString))
      {
        a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, paramInt);
      }
      else if ("action_app_conf".equals(paramString))
      {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        a(paramBundle, paramInt);
        b(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationIpcServer
 * JD-Core Version:    0.7.0.1
 */