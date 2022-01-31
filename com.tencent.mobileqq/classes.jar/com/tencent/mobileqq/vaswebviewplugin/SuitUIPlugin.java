package com.tencent.mobileqq.vaswebviewplugin;

import begz;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class SuitUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "SuitUIPlugin";
  
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
    return 262144L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin
 * JD-Core Version:    0.7.0.1
 */