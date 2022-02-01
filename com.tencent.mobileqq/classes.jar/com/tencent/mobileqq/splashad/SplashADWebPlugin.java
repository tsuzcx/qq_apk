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
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934598L)
    {
      paramString = new StringBuilder();
      paramString.append("handleEvent finish or destroy. isFromSP:");
      paramString.append(this.a);
      QLog.i("QSplash@VasSplashUtil", 1, paramString.toString());
      if (this.a) {
        this.mRuntime.d().startActivity(new Intent(this.mRuntime.d(), SplashActivity.class));
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
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (this.mRuntime.d().getIntent() != null) {
      this.a = this.mRuntime.d().getIntent().getBooleanExtra("key_from_splash_ad", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADWebPlugin
 * JD-Core Version:    0.7.0.1
 */