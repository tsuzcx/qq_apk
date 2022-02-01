package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQzoneShareApi;
import mqq.app.AndroidOreoUtils;

public class WXEntryActivity
  extends Activity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = new AndroidOreoUtils(this);
    if ((Build.VERSION.SDK_INT == 26) && (getApplicationInfo().targetSdkVersion >= 27) && (((AndroidOreoUtils)localObject).isTranslucentOrFloating()))
    {
      boolean bool = ((AndroidOreoUtils)localObject).fixOrientation();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate fixOrientation when Oreo, result = ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("WXEntryActivity", 1, ((StringBuilder)localObject).toString());
    }
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = new Intent("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE");
    try
    {
      paramBundle.putExtras(getIntent());
    }
    catch (Exception localException)
    {
      QLog.e("WXEntryActivity", 1, "get intent exception:", localException);
    }
    sendBroadcast(paramBundle, "com.tencent.msg.permission.pushnotify");
    try
    {
      ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).handleWXEntryActivityIntent(this, getIntent());
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    StringBuilder localStringBuilder;
    try
    {
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).handleWXEntryActivityIntent(this, getIntent());
    }
    catch (Throwable paramBundle)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WxShareHelperFromReadInjoy.getInstance().handleWXEntryActivityIntent error = ");
      localStringBuilder.append(paramBundle);
      QLog.e("WXEntryActivity", 2, localStringBuilder.toString());
    }
    try
    {
      ((IWXMiniProgramHelper)QRoute.api(IWXMiniProgramHelper.class)).handleWXEntryActivityIntent(this, getIntent());
    }
    catch (Throwable paramBundle)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WXMiniProgramHelperImpl.getInstance().handleWXEntryActivityIntent error = ");
      localStringBuilder.append(paramBundle);
      QLog.e("WXEntryActivity", 2, localStringBuilder.toString());
    }
    try
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).handleWXEntryActivityIntent(this, getIntent());
    }
    catch (Throwable paramBundle)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WXShareHelperFromQQMiniApp.getInstance().handleWXEntryActivityIntent error = ");
      localStringBuilder.append(paramBundle);
      QLog.e("WXEntryActivity", 2, localStringBuilder.toString());
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */