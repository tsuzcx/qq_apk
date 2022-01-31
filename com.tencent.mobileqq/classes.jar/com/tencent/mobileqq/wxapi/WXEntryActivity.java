package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import bjnt;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AndroidOreoUtils;

public class WXEntryActivity
  extends Activity
{
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
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
        bjnt.a().a(this, getIntent());
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
            for (;;)
            {
              WXMiniProgramHelper.a().a(this, getIntent());
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
            }
          }
          catch (Throwable paramBundle)
          {
            for (;;)
            {
              QLog.e("WXEntryActivity", 2, "WXMiniProgramHelper.getInstance().handleWXEntryActivityIntent error = " + paramBundle);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */