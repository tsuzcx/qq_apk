package com.tencent.mobileqq.litelivesdk.sdkimpl.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.ilive.util.IlivePreloadHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LiteLiveSDKClientIPCModule
  extends QIPCModule
  implements SDKInitListener
{
  private static LiteLiveSDKClientIPCModule d;
  private static final Object e = new Object();
  private LiteLiveSDKClientIPCModule.IPCConnectListenerImpl a;
  private ILiveSDK b;
  private AppRuntime c;
  
  private LiteLiveSDKClientIPCModule(String paramString)
  {
    super(paramString);
    if ((this.c == null) && (MobileQQ.sMobileQQ.waitAppRuntime(null) != null)) {
      this.c = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("ilive_plugin");
    }
    if (!QQVideoPlaySDKManager.isSDKReady())
    {
      paramString = this.c;
      if ((paramString != null) && (paramString.isLogin())) {
        QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getContext(), this);
      }
    }
    this.b = new LiteLiveSDKClientIPCModule.1(this);
    this.a = new LiteLiveSDKClientIPCModule.IPCConnectListenerImpl(this, null);
    QLog.e("LiteLiveSDKClientIPCModule", 1, "LiteLiveSDKClientIPCModule register IPC Bind");
    try
    {
      QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
      QIPCClientHelper.getInstance().register(this);
      QIPCClientHelper.getInstance().getClient().addListener(this.a);
      b();
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.e("LiteLiveSDKClientIPCModule", 1, "LiteLiveSDKClientIPCModule create error", paramString);
    }
    WebViewPool.a.a();
  }
  
  public static LiteLiveSDKClientIPCModule a()
  {
    QLog.e("LiteLiveSDKClientIPCModule", 1, "getInstance");
    IlivePreloadHelper.b();
    return a(false);
  }
  
  public static LiteLiveSDKClientIPCModule a(Intent paramIntent)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("liveBindState", 0) == 0) {
        bool1 = true;
      }
      IliveLiteMonitorUtil.b(paramIntent.getLongExtra("startTime", System.currentTimeMillis()));
    }
    paramIntent = new StringBuilder();
    paramIntent.append("getInstance foe tool service , isNeedReset = ");
    paramIntent.append(bool1);
    QLog.e("LiteLiveSDKClientIPCModule", 1, paramIntent.toString());
    return a(bool1);
  }
  
  private static LiteLiveSDKClientIPCModule a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d = null;
      QLog.e("LiteLiveSDKClientIPCModule", 1, "getInstance reset create instance");
    }
    if (d == null) {
      synchronized (e)
      {
        if (d == null) {
          d = new LiteLiveSDKClientIPCModule("LiteSDKClientModuleName");
        }
      }
    }
    return d;
  }
  
  private void b()
  {
    if (this.a.a()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ilive connect, [");
      localStringBuilder.append(this.a.a.get());
      localStringBuilder.append("]");
      QLog.d("LiteLiveSDKClientIPCModule", 2, localStringBuilder.toString());
    }
    QIPCClientHelper.getInstance().getClient().connect(this.a);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ilive LiteLiveSDKClientIPCModule--onCall-----action = ");
    localStringBuilder.append(paramString);
    ((LogInterface)localObject).e("LiteLiveSDKClientIPCModule", localStringBuilder.toString());
    if ((this.c == null) && (MobileQQ.sMobileQQ.waitAppRuntime(null) != null)) {
      this.c = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("ilive_plugin");
    }
    if (!QQVideoPlaySDKManager.isSDKReady())
    {
      localObject = this.c;
      if ((localObject != null) && (((AppRuntime)localObject).isLogin())) {
        QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getContext(), this);
      }
    }
    if ("Action_Client_isInitLiteSDK".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putBoolean("Key_Inited", BusinessManager.a.a());
      return EIPCResult.createSuccessResult(paramString);
    }
    if ("Action_Client_InitLiteSDK".equals(paramString))
    {
      paramBundle.setClassLoader(BusinessConfig.class.getClassLoader());
      paramString = (BusinessConfig)paramBundle.getParcelable("Key_BusinessConfig");
      this.b.a(paramString);
    }
    else if ("Action_Client_UninitLiteSDK".equals(paramString))
    {
      this.b.a();
    }
    else if ("Action_Client_Login".equals(paramString))
    {
      paramBundle.setClassLoader(BizLoginRequest.class.getClassLoader());
      paramString = (BizLoginRequest)paramBundle.getParcelable("Key_BizLoginRequest");
      this.b.a(paramString);
    }
    else if ("Action_Client_Logout".equals(paramString))
    {
      this.b.e();
    }
    else if ("Action_Client_EnterRoom".equals(paramString))
    {
      paramString = paramBundle.getString("Key_mqq");
      this.b.a(BusinessManager.a.b().a, paramString);
    }
    else
    {
      if ("Action_Client_getLiveLoginTicket".equals(paramString))
      {
        paramString = new Bundle();
        paramString.putParcelable("Key_LoginResult", this.b.d());
        return EIPCResult.createSuccessResult(paramString);
      }
      if ("Action_Client_customizedBizSDKService".equals(paramString))
      {
        paramString = paramBundle.getString("Key_Appid");
        localObject = (Class)paramBundle.getSerializable("Key_ServiceClazz");
        paramBundle = (Class)paramBundle.getSerializable("Key_ServiceBuildClazz");
        this.b.a(paramString, (Class)localObject, paramBundle);
      }
      else if ("Action_Client_CustomizedBizModules".equals(paramString))
      {
        paramString = paramBundle.getString("Key_Appid");
        paramInt = paramBundle.getInt("Key_PageType");
        paramBundle = (Class)paramBundle.getSerializable("Key_BizModulesClazz");
        this.b.a(paramString, paramInt, paramBundle);
      }
      else
      {
        if ("Action_Client_GetActiveBizConfig".equals(paramString))
        {
          paramString = new Bundle();
          paramString.putParcelable("Key_BusinessConfig", this.b.b());
          return EIPCResult.createSuccessResult(paramString);
        }
        if ("Action_Client_UpdateActiveBizConfig".equals(paramString))
        {
          paramBundle.setClassLoader(BusinessConfig.class.getClassLoader());
          paramString = (BusinessConfig)paramBundle.getParcelable("Key_BusinessConfig");
          this.b.b(paramString);
        }
        else
        {
          paramBundle = new StringBuilder();
          paramBundle.append("LiteLiveSDKClientIPCModule======invaild action: ");
          paramBundle.append(paramString);
          EIPCResult.createExceptionResult(new Throwable(paramBundle.toString()));
        }
      }
    }
    return EIPCResult.createSuccessResult(null);
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("======onSDKInited:  ");
    localStringBuilder.append(paramBoolean);
    QLog.d("LiteLiveSDKClientIPCModule", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteLiveSDKClientIPCModule
 * JD-Core Version:    0.7.0.1
 */