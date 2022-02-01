package com.tencent.mobileqq.identification;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyServlet;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqconnectface.impl.VideoProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class IdentificationIpcServer
  extends QIPCModule
{
  private static volatile IdentificationIpcServer jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer;
  private static final List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "setFaceData", "identify", "deleteFace", "changeSecureMobile" });
  private int jdField_a_of_type_Int;
  private VideoProxy jdField_a_of_type_ComTencentMobileqqQqconnectfaceImplVideoProxy;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private int b;
  
  private IdentificationIpcServer(String paramString)
  {
    super(paramString);
  }
  
  private ITransactionCallback a(File paramFile, EIPCResult paramEIPCResult, AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3)
  {
    return new IdentificationIpcServer.4(this, paramFile, paramEIPCResult, paramAppRuntime, paramInt2, paramInt3, paramInt1);
  }
  
  public static IdentificationIpcServer a()
  {
    if (jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer == null) {
          jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer = new IdentificationIpcServer("IdentificationIpcServer_Model");
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqIdentificationIdentificationIpcServer;
  }
  
  private AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  private void a(Bundle paramBundle)
  {
    QLog.d("qqidentification_server", 1, "start upload file");
    EIPCResult localEIPCResult = new EIPCResult();
    Bundle localBundle = new Bundle();
    localEIPCResult.data = localBundle;
    Object localObject1 = paramBundle.getString("filePath", null);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      File localFile = new File((String)localObject1);
      if (localFile.exists())
      {
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
        Object localObject2 = a();
        int j = paramBundle.getInt("srcAppId", 0);
        int k = paramBundle.getInt("key_identification_type", 2);
        this.jdField_a_of_type_JavaLangString = paramBundle.getString("method", null);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("");
        ((StringBuilder)localObject4).append(k);
        localObject4 = ((StringBuilder)localObject4).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(j);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X80097EB", "0X80097EB", 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), "");
        localObject3 = this.jdField_a_of_type_JavaLangString;
        if ((localObject3 != null) && (!jdField_a_of_type_JavaUtilList.contains(localObject3)))
        {
          localObject3 = paramBundle.getString("uin", "");
          localObject4 = paramBundle.getString("ticket", "");
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
            QLog.i("qqidentification_server", 1, "uin or ticket is null");
          }
          localObject1 = new Transaction((String)localObject3, 61, (String)localObject1, 0, Base64.decode((String)localObject4, 11), arrayOfByte, a(localFile, localEIPCResult, (AppRuntime)localObject2, j, i, k));
        }
        else
        {
          localObject1 = new Transaction(((AppRuntime)localObject2).getCurrentAccountUin(), 61, (String)localObject1, 0, arrayOfByte, a(localFile, localEIPCResult, (AppRuntime)localObject2, j, i, k), null, false);
        }
        localObject2 = ((AppInterface)localObject2).getHwEngine();
        if (IdentificationConstant.d.contains(this.jdField_a_of_type_JavaLangString)) {
          ((HwEngine)localObject2).currentUin = paramBundle.getString("uin", "");
        }
        i = ((HwEngine)localObject2).submitTransactionTask((Transaction)localObject1);
        if (i != 0)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("submit error: ");
          paramBundle.append(i);
          QLog.e("qqidentification_server", 1, paramBundle.toString());
          localEIPCResult.code = -102;
          localBundle.putBoolean("reset_null", true);
          paramBundle = new StringBuilder();
          paramBundle.append("UPLOAD submitTransaction retCode=");
          paramBundle.append(i);
          localBundle.putString("subError", paramBundle.toString());
          callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
        }
        return;
      }
    }
    QLog.e("qqidentification_server", 1, "invalid path");
    localEIPCResult.code = -102;
    localBundle.putString("subError", "no file");
    localBundle.putBoolean("reset_null", true);
    callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
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
    if ((i != 0) && (!TextUtils.isEmpty(str1)))
    {
      if ((IdentificationConstant.d.contains(str3)) && (TextUtils.isEmpty(str4)))
      {
        QLog.d("qqidentification_server", 1, "method is loginVerify but uin is empty");
        return;
      }
      paramBundle = a();
      FaceDetectForThirdPartyServlet.a(paramBundle, str3, str4, i, AppSetting.a(), str2, str1, l, new IdentificationIpcServer.3(this, paramInt, paramBundle));
      return;
    }
    QLog.d("qqidentification_server", 1, " KEY_APP_ID not exist or temKey is empty");
  }
  
  private void a(AppRuntime paramAppRuntime, Bundle paramBundle, int paramInt)
  {
    String str = paramBundle.getString("method", null);
    int i = paramBundle.getInt("srcAppId");
    paramBundle = paramBundle.getString("uin");
    FaceAreaManager.a().a(paramAppRuntime, BaseApplication.getContext(), i, str, paramBundle, new IdentificationIpcServer.2(this, paramInt));
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = new EIPCResult();
    ((EIPCResult)localObject).code = (paramBoolean ^ true);
    callbackResult(this.b, (EIPCResult)localObject);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadFinish download result = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("qqidentification_server", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.e("qqidentification_server", 1, "downloadRes, is downloading now");
      return;
    }
    if (!FaceConfigManager.b())
    {
      QLog.e("qqidentification_server", 1, "downloadRes, do not need update");
      a(true);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    String str = FaceConfigManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start download , config content.....");
    localStringBuilder.append(str);
    QLog.d("qqidentification_server", 1, localStringBuilder.toString());
    FaceConfigManager.a(a(), str, new IdentificationIpcServer.5(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, params=");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(", action=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", callBackId=");
      localStringBuilder.append(paramInt);
      QLog.d("qqidentification_server", 2, localStringBuilder.toString());
    }
    if ("action_upload".equals(paramString))
    {
      if (paramBundle == null)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCall, param is null, action=");
        paramBundle.append(paramString);
        paramBundle.append(", callBackId=");
        paramBundle.append(paramInt);
        QLog.d("qqidentification_server", 1, paramBundle.toString());
        paramString = new Bundle();
        paramString.putString("subError", "no params");
        paramString.putBoolean("reset_null", true);
        callbackResult(paramInt, EIPCResult.createResult(-102, paramString));
        return null;
      }
      ThreadManager.excute(new IdentificationIpcServer.1(this, paramBundle), 128, null, false);
      return null;
    }
    if ("action_is_video_chatting".equals(paramString))
    {
      paramString = a();
      if (this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceImplVideoProxy == null) {
        this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceImplVideoProxy = new VideoProxy();
      }
      paramBundle = new EIPCResult();
      paramInt = i;
      if (this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceImplVideoProxy.a(paramString)) {
        paramInt = 1;
      }
      paramBundle.code = paramInt;
      return paramBundle;
    }
    if ("action_res_download".equals(paramString))
    {
      this.b = paramInt;
      a();
      return null;
    }
    if ("action_face_usable".equals(paramString))
    {
      a(a(), paramBundle, paramInt);
      return null;
    }
    if ("action_app_conf".equals(paramString))
    {
      paramString = a();
      a(paramBundle, paramInt);
      FaceConfigManager.a(paramString, null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationIpcServer
 * JD-Core Version:    0.7.0.1
 */