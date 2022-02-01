package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;

public class SuitUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "SuitUIPlugin";
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    WebViewProvider localWebViewProvider = this.mRuntime.a();
    if (localWebViewProvider != null) {
      localWebViewProvider.setCurUrl(super.decodeUrl(localWebViewProvider.getCurrentUrl()));
    }
  }
  
  protected long getPluginBusiness()
  {
    return 262144L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 3L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin
 * JD-Core Version:    0.7.0.1
 */