package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;

public class ColorRingUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ColorRingUIPlugin";
  
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
    return 4194304L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 3L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin
 * JD-Core Version:    0.7.0.1
 */