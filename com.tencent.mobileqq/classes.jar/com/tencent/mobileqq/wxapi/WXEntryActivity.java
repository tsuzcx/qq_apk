package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.share.WXShareFromQZHelper;
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
    AndroidOreoUtils localAndroidOreoUtils = new AndroidOreoUtils(this);
    if ((Build.VERSION.SDK_INT == 26) && (getApplicationInfo().targetSdkVersion >= 27) && (localAndroidOreoUtils.isTranslucentOrFloating()))
    {
      boolean bool = localAndroidOreoUtils.fixOrientation();
      QLog.i("WXEntryActivity", 1, "onCreate fixOrientation when Oreo, result = " + bool);
    }
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = new Intent("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE");
    try
    {
      paramBundle.putExtras(getIntent());
      sendBroadcast(paramBundle, "com.tencent.msg.permission.pushnotify");
    }
    catch (Exception paramBundle)
    {
      try
      {
        WXShareFromQZHelper.getInstance().handleWXEntryActivityIntent(this, getIntent());
      }
      catch (Throwable paramBundle)
      {
        try
        {
          WxShareHelperFromReadInjoy.a().a(this, getIntent());
        }
        catch (Throwable paramBundle)
        {
          try
          {
            WXMiniProgramHelper.a().a(this, getIntent());
          }
          catch (Throwable paramBundle)
          {
            try
            {
              for (;;)
              {
                ((IMiniAppService)QRoute.api(IMiniAppService.class)).handleWXEntryActivityIntent(this, getIntent());
                finish();
                return;
                localException = localException;
                QLog.e("WXEntryActivity", 1, "get intent exception:", localException);
                continue;
                paramBundle = paramBundle;
                paramBundle.printStackTrace();
                continue;
                paramBundle = paramBundle;
                QLog.e("WXEntryActivity", 2, "WxShareHelperFromReadInjoy.getInstance().handleWXEntryActivityIntent error = " + paramBundle);
                continue;
                paramBundle = paramBundle;
                QLog.e("WXEntryActivity", 2, "WXMiniProgramHelper.getInstance().handleWXEntryActivityIntent error = " + paramBundle);
              }
            }
            catch (Throwable paramBundle)
            {
              for (;;)
              {
                QLog.e("WXEntryActivity", 2, "WXShareHelperFromQQMiniApp.getInstance().handleWXEntryActivityIntent error = " + paramBundle);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */