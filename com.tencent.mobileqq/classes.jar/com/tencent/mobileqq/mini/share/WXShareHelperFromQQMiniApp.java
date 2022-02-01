package com.tencent.mobileqq.mini.share;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.util.QQToastUtil;

public class WXShareHelperFromQQMiniApp
  extends BroadcastReceiver
  implements IWXAPIEventHandler
{
  private static final int LAUNCH_WX_PENDING_INTENT_REQUEST_CODE = 1;
  private static final String TAG = "WXShareHelperFromQQMiniApp";
  public static final String WX_APPID_DEBUG = "wx76a769350165bcff";
  public static final String WX_APPID_RELEASE = "wxf0a80d0ac2e82aa7";
  private static final byte[] lock = new byte[0];
  private static WXShareHelperFromQQMiniApp mWxShareHelperFromQQMiniApp;
  private IWXAPI api = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication(), this.mWxAppId, true);
  private com.tencent.mobileqq.mini.sdk.LaunchParam launchParamFromQQ;
  private String mWxAppId = "wxf0a80d0ac2e82aa7";
  private com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfoFromQQ;
  private com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfoFromSDK;
  
  public WXShareHelperFromQQMiniApp()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    registerApp();
  }
  
  public static WXShareHelperFromQQMiniApp getInstance()
  {
    if (mWxShareHelperFromQQMiniApp == null) {
      synchronized (lock)
      {
        if (mWxShareHelperFromQQMiniApp == null) {
          mWxShareHelperFromQQMiniApp = new WXShareHelperFromQQMiniApp();
        }
      }
    }
    return mWxShareHelperFromQQMiniApp;
  }
  
  public void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WXShareHelperFromQQMiniApp", 2, "handleWXEntryActivityIntent");
    }
    if (this.api != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WXShareHelperFromQQMiniApp", 2, "handleWXEntryActivityIntent api != null");
      }
      this.api.handleIntent(paramIntent, this);
    }
    paramIntent = this.miniAppInfoFromQQ;
    if (paramIntent != null)
    {
      com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = this.launchParamFromQQ;
      if (localLaunchParam != null)
      {
        try
        {
          MiniAppController.launchMiniAppByAppInfo(paramActivity, paramIntent, localLaunchParam);
        }
        catch (MiniAppException paramActivity)
        {
          paramActivity.printStackTrace();
        }
        this.miniAppInfoFromQQ = null;
        this.launchParamFromQQ = null;
        return;
      }
    }
    paramIntent = this.miniAppInfoFromSDK;
    if (paramIntent != null)
    {
      if (paramIntent.launchParam != null) {
        paramIntent = String.valueOf(this.miniAppInfoFromSDK.launchParam.scene);
      } else {
        paramIntent = "";
      }
      if (MiniAppStartUtils.shouldInterceptStartMiniApp(this.miniAppInfoFromSDK.appId, paramIntent))
      {
        paramActivity = new StringBuilder();
        paramActivity.append("study mode, can't start in current scene = ");
        paramActivity.append(paramIntent);
        QLog.i("WXShareHelperFromQQMiniApp", 1, paramActivity.toString());
        QQToastUtil.a(0, 2131891806);
        return;
      }
      MiniSDK.startMiniApp(paramActivity, this.miniAppInfoFromSDK);
      this.miniAppInfoFromSDK = null;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {}
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp) {}
  
  public void recordMiniAppInfoFromQQ(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo, com.tencent.mobileqq.mini.sdk.LaunchParam paramLaunchParam)
  {
    this.miniAppInfoFromQQ = paramMiniAppInfo;
    this.launchParamFromQQ = paramLaunchParam;
    this.miniAppInfoFromSDK = null;
  }
  
  public void recordMiniAppInfoFromSDK(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppInfoFromSDK = paramMiniAppInfo;
    this.miniAppInfoFromQQ = null;
    this.launchParamFromQQ = null;
  }
  
  public void registerApp()
  {
    try
    {
      this.api.registerApp(this.mWxAppId);
      if (QLog.isColorLevel())
      {
        QLog.d("WXShareHelperFromQQMiniApp", 1, "registerApp()");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("WXShareHelperFromQQMiniApp", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.WXShareHelperFromQQMiniApp
 * JD-Core Version:    0.7.0.1
 */