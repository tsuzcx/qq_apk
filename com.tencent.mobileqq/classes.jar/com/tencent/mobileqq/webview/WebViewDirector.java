package com.tencent.mobileqq.webview;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class WebViewDirector
{
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public long e = 0L;
  public long f = 0L;
  private IWebViewBuilder g;
  
  public WebViewDirector(IWebViewBuilder paramIWebViewBuilder)
  {
    this.g = paramIWebViewBuilder;
  }
  
  public void a(Bundle paramBundle, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_init_webview_plugin", true))) {
      this.g.preInitWebviewPlugin();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_get_key", true))) {
      WebAccelerateHelper.getInstance().preGetKey(paramIntent, paramAppRuntime);
    }
    long l2 = System.currentTimeMillis();
    this.g.buildLayout();
    long l1 = System.currentTimeMillis();
    this.b = (l1 - l2);
    this.g.buildContentView(paramBundle);
    l2 = System.currentTimeMillis();
    this.e = (l2 - l1);
    this.g.buildTitleBar();
    l1 = System.currentTimeMillis();
    this.c = (l1 - l2);
    this.g.buildBottomBar();
    l2 = System.currentTimeMillis();
    this.d = (l2 - l1);
    this.g.buildWebView(paramAppRuntime);
    l1 = System.currentTimeMillis();
    this.a = (l1 - l2);
    this.g.buildData();
    this.f = (System.currentTimeMillis() - l1);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("buildLayoutTime : ");
      paramBundle.append(this.b);
      paramBundle.append(", buildContentTime ");
      paramBundle.append(this.e);
      paramBundle.append(", buildTitleTime ");
      paramBundle.append(this.c);
      paramBundle.append(", buildWebViewTime ");
      paramBundle.append(this.a);
      paramBundle.append(", buildBottomTime ");
      paramBundle.append(this.d);
      paramBundle.append(", buildDataTime ");
      paramBundle.append(this.f);
      QLog.i("WebViewDirector", 2, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewDirector
 * JD-Core Version:    0.7.0.1
 */