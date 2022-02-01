package com.tencent.mobileqq.splashad;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class SplashADWebPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  private boolean a = false;
  
  public SplashADWebPlugin()
  {
    this.mPluginNameSpace = "splashADPlugin";
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934598L)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "handleEvent finish or destroy. isFromSP:" + this.a);
      if (this.a) {
        this.mRuntime.a().startActivity(new Intent(this.mRuntime.a(), SplashActivity.class));
      }
      return true;
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent.getBooleanExtra("key_from_splash_ad", false)) {
      if (!paramString2.equals("http"))
      {
        bool1 = bool2;
        if (!paramString2.equals("https")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (this.mRuntime.a().getIntent() != null) {
      this.a = this.mRuntime.a().getIntent().getBooleanExtra("key_from_splash_ad", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADWebPlugin
 * JD-Core Version:    0.7.0.1
 */