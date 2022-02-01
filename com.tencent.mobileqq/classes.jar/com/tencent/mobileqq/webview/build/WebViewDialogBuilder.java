package com.tencent.mobileqq.webview.build;

import android.os.Bundle;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import mqq.app.AppRuntime;

public class WebViewDialogBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public final void buildWebView(AppRuntime paramAppRuntime)
  {
    super.buildBaseWebView(paramAppRuntime);
    onWebViewReady();
  }
  
  public final void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.build.WebViewDialogBuilder
 * JD-Core Version:    0.7.0.1
 */