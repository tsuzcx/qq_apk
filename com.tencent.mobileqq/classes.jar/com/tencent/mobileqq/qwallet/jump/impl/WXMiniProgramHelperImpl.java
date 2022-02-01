package com.tencent.mobileqq.qwallet.jump.impl;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class WXMiniProgramHelperImpl
  extends BroadcastReceiver
  implements IWXAPIEventHandler, IWXMiniProgramHelper
{
  private static final int LAUNCH_WX_PENDING_INTENT_REQUEST_CODE = 1;
  private static final String TAG = "WXMiniProgramHelperImpl";
  public static final String WX_APPID_DEBUG = "wx76a769350165bcff";
  public static final String WX_APPID_RELEASE = "wxf0a80d0ac2e82aa7";
  private IWXAPI api = WXAPIFactory.createWXAPI(MobileQQ.sMobileQQ, this.mWxAppId, true);
  private String mWxAppId = "wxf0a80d0ac2e82aa7";
  
  public WXMiniProgramHelperImpl()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
    registerApp();
  }
  
  private void launchWXUsingPendingIntent()
  {
    try
    {
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      if (QLog.isColorLevel()) {
        QLog.i("WXMiniProgramHelperImpl", 2, "launchWXUsingPendingIntent");
      }
      PendingIntent.getActivity(localMobileQQ, 1, localMobileQQ.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"), 134217728).send(localMobileQQ, 1, null, new WXMiniProgramHelperImpl.2(this), null);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("launchWXUsingPendingIntent pendingIntent send failed: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("WXMiniProgramHelperImpl", 1, localStringBuilder.toString());
      this.api.openWXApp();
    }
  }
  
  private void showToast(MqqHandler paramMqqHandler, int paramInt)
  {
    paramMqqHandler.post(new WXMiniProgramHelperImpl.1(this, paramInt));
  }
  
  public void handleWXEntryActivityIntent(Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WXMiniProgramHelperImpl", 2, "handleWXEntryActivityIntent");
    }
    if (this.api != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WXMiniProgramHelperImpl", 2, "handleWXEntryActivityIntent api != null");
      }
      this.api.handleIntent(paramIntent, this);
    }
  }
  
  public void launchMiniProgram(Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXMiniProgramHelperImpl", 2, "launchMiniProgram: ");
    }
    Object localObject = ThreadManager.getUIHandler();
    if (!this.api.isWXAppInstalled())
    {
      showToast((MqqHandler)localObject, R.string.f);
      return;
    }
    if (this.api.getWXAppSupportAPI() < 621086464)
    {
      showToast((MqqHandler)localObject, R.string.g);
      return;
    }
    if (Build.VERSION.SDK_INT >= 29) {
      launchWXUsingPendingIntent();
    }
    localObject = new WXLaunchMiniProgram.Req();
    ((WXLaunchMiniProgram.Req)localObject).userName = ((String)paramMap.get("user_name"));
    int i = 0;
    try
    {
      int j = Integer.valueOf((String)paramMap.get("app_type")).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      QLog.e("WXMiniProgramHelperImpl", 1, localException, new Object[0]);
    }
    ((WXLaunchMiniProgram.Req)localObject).miniprogramType = i;
    String str = (String)paramMap.get("path");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        ((WXLaunchMiniProgram.Req)localObject).path = URLDecoder.decode(str, "UTF-8");
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    paramMap = (String)paramMap.get("ext");
    if (paramMap != null) {
      ((WXLaunchMiniProgram.Req)localObject).extData = paramMap;
    }
    this.api.sendReq((BaseReq)localObject);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.api != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WXMiniProgramHelperImpl", 1, "onReceive() api != null");
      }
      this.api.handleIntent(paramIntent, this);
    }
  }
  
  public void onReq(BaseReq paramBaseReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXMiniProgramHelperImpl", 1, "onReq: ");
    }
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXMiniProgramHelperImpl", 1, "onResp: ");
    }
  }
  
  public void registerApp()
  {
    try
    {
      this.api.registerApp(this.mWxAppId);
      if (QLog.isColorLevel())
      {
        QLog.d("WXMiniProgramHelperImpl", 1, "registerApp()");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("WXMiniProgramHelperImpl", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.jump.impl.WXMiniProgramHelperImpl
 * JD-Core Version:    0.7.0.1
 */