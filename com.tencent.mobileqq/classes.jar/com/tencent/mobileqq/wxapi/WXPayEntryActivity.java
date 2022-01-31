package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;

public class WXPayEntryActivity
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
    try
    {
      WXPayHelper.getInstance().handleIntent(getIntent());
      finish();
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXPayEntryActivity
 * JD-Core Version:    0.7.0.1
 */