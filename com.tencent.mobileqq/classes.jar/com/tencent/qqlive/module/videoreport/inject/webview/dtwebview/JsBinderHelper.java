package com.tencent.qqlive.module.videoreport.inject.webview.dtwebview;

import android.os.Build.VERSION;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;

class JsBinderHelper
{
  private static final String TAG = "JsBinderHelper";
  private boolean mIsJsInterfaceInject;
  
  public boolean allowInjectOnLoad()
  {
    if (!DTConfigConstants.config.webViewReportSupport())
    {
      Log.w("JsBinderHelper", "webView report not support!");
      return false;
    }
    if (this.mIsJsInterfaceInject) {
      return false;
    }
    if (Build.VERSION.SDK_INT < 17)
    {
      Log.d("JsBinderHelper", "skip bind javascript bridge for low sdk api level");
      return false;
    }
    Log.d("JsBinderHelper", "on bind javascript bridge");
    return true;
  }
  
  public boolean interceptOnAddJavascriptInterface(String paramString)
  {
    if (!"DTJsBridgeInterface".equals(paramString)) {
      return false;
    }
    if (this.mIsJsInterfaceInject)
    {
      Log.d("JsBinderHelper", "intercept bind javascript bridge");
      return true;
    }
    this.mIsJsInterfaceInject = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.JsBinderHelper
 * JD-Core Version:    0.7.0.1
 */