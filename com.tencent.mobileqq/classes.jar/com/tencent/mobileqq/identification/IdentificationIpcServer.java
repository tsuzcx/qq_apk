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
  private static final List<String> a = Arrays.asList(new String[] { "setFaceData", "identify", "deleteFace", "changeSecureMobile", "studyModeIdentify" });
  private static volatile IdentificationIpcServer b;
  private int c;
  private int d;
  private AtomicBoolean e = new AtomicBoolean();
  private String f;
  private VideoProxy g;
  
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
    if (b == null) {
      try
      {
        if (b == null) {
          b = new IdentificationIpcServer("IdentificationIpcServer_Model");
        }
      }
      finally {}
    }
    return b;
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
          callbackResult(this.c, localEIPCResult);
          return;
        }
        int i = paramBundle.getInt("serviceType", -1);
        Object localObject2 = c();
        int j = paramBundle.getInt("srcAppId", 0);
        int k = paramBundle.getInt("key_identification_type", 2);
        this.f = paramBundle.getString("method", null);
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
        localObject3 = this.f;
        if ((localObject3 != null) && (!a.contains(localObject3)))
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
        if (IdentificationConstant.d.contains(this.f)) {
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
          callbackResult(this.c, localEIPCResult);
        }
        return;
      }
    }
    QLog.e("qqidentification_server", 1, "invalid path");
    localEIPCResult.code = -102;
    localBundle.putString("subError", "no file");
    localBundle.putBoolean("reset_null", true);
    callbackResult(this.c, localEIPCResult);
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
      paramBundle = c();
      FaceDetectForThirdPartyServlet.a(paramBundle, str3, str4, i, AppSetting.b(), str2, str1, l, new IdentificationIpcServer.3(this, paramInt, paramBundle));
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
    callbackResult(this.d, (EIPCResult)localObject);
    this.e.set(false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadFinish download result = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("qqidentification_server", 1, ((StringBuilder)localObject).toString());
  }
  
  private AppRuntime c()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public void b()
  {
    if (this.e.get())
    {
      QLog.e("qqidentification_server", 1, "downloadRes, is downloading now");
      return;
    }
    if (!FaceConfigManager.c())
    {
      QLog.e("qqidentification_server", 1, "downloadRes, do not need update");
      a(true);
      return;
    }
    this.e.set(true);
    String str = FaceConfigManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start download , config content.....");
    localStringBuilder.append(str);
    QLog.d("qqidentification_server", 1, localStringBuilder.toString());
    FaceConfigManager.a(c(), str, new IdentificationIpcServer.5(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    this.c = paramInt;
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
      paramString = c();
      if (this.g == null) {
        this.g = new VideoProxy();
      }
      paramBundle = new EIPCResult();
      paramInt = i;
      if (this.g.a(paramString)) {
        paramInt = 1;
      }
      paramBundle.code = paramInt;
      return paramBundle;
    }
    if ("action_res_download".equals(paramString))
    {
      this.d = paramInt;
      b();
      return null;
    }
    if ("action_face_usable".equals(paramString))
    {
      a(c(), paramBundle, paramInt);
      return null;
    }
    if ("action_app_conf".equals(paramString))
    {
      paramString = c();
      a(paramBundle, paramInt);
      FaceConfigManager.a(paramString, null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationIpcServer
 * JD-Core Version:    0.7.0.1
 */