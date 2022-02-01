package com.tencent.mobileqq.vaswebviewplugin;

import bioy;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class ColorRingUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ColorRingUIPlugin";
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    WebViewFragment localWebViewFragment = this.mRuntime.a();
    if (localWebViewFragment != null) {
      localWebViewFragment.mUrl = super.decodeUrl(localWebViewFragment.mUrl);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 4194304L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin
 * JD-Core Version:    0.7.0.1
 */