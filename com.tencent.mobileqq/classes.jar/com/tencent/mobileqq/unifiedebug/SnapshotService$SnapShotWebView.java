package com.tencent.mobileqq.unifiedebug;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.utils.ProxyConfig;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

class SnapshotService$SnapShotWebView
  extends AbsWebView
{
  public SnapshotService$SnapShotWebView(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.preInitPluginEngine();
    this.mWebview = new TouchWebView(this.mContext);
    buildBaseWebView(paramAppInterface);
  }
  
  public void a()
  {
    super.doOnResume();
  }
  
  public void a(Intent paramIntent)
  {
    super.doOnCreate(paramIntent);
  }
  
  public void a(String paramString)
  {
    ProxyConfig.a(this.mWebview, ProxyConfig.a);
    this.mUrl = paramString;
    this.mWebview.loadUrl(this.mUrl);
  }
  
  public void b()
  {
    super.doOnPause();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList.add(new WebViewJumpPlugin());
    }
  }
  
  public void c()
  {
    super.doOnDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramString = new StringBuilder();
    paramString.append("javascript:");
    paramString.append(SnapshotService.b);
    paramWebView.loadUrl(paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.SnapShotWebView
 * JD-Core Version:    0.7.0.1
 */