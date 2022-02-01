package com.tencent.mobileqq.webview.build;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.AbsWebView;

public class WebViewDialogBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public final void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
    onWebViewReady();
  }
  
  public final void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.build.WebViewDialogBuilder
 * JD-Core Version:    0.7.0.1
 */