package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

public class ColorRingUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ColorRingUIPlugin";
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    WebViewFragment localWebViewFragment = this.mRuntime.a();
    if (localWebViewFragment != null) {
      localWebViewFragment.g = super.decodeUrl(localWebViewFragment.g);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 4194304L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin
 * JD-Core Version:    0.7.0.1
 */