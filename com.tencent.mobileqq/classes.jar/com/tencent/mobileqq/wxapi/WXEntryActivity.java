package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import bhlr;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;

public class WXEntryActivity
  extends Activity
{
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
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
        bhlr.a().a(this, getIntent());
      }
      catch (Throwable paramBundle)
      {
        try
        {
          for (;;)
          {
            WxShareHelperFromReadInjoy.a().a(this, getIntent());
            finish();
            return;
            localException = localException;
            QLog.e("WXEntryActivity", 1, "get intent exception:", localException);
            continue;
            paramBundle = paramBundle;
            paramBundle.printStackTrace();
          }
        }
        catch (Throwable paramBundle)
        {
          for (;;)
          {
            QLog.e("WXEntryActivity", 2, "WxShareHelperFromReadInjoy.getInstance().handleWXEntryActivityIntent error = " + paramBundle);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */