package com.tencent.webbundle.sdk;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

class WebBundle$3
  implements IWebBundleWebView.OnPageFinishedListener
{
  WebBundle$3(WebBundle paramWebBundle, JSONObject paramJSONObject) {}
  
  public void onPageFinished(@NotNull IWebBundleWebView paramIWebBundleWebView, @NotNull String paramString)
  {
    if (this.this$0.getPreloadState() == WebBundle.WebBundlePreloadState.FAILED) {
      return;
    }
    this.this$0.setPreloadState(WebBundle.WebBundlePreloadState.ANALYSIS_JS_BUNDLE);
    paramIWebBundleWebView.dispatchJsEvent("vashybrid_bundle_message", this.val$pendingData, null);
    WebBundleManager.getInstance(WebBundle.access$000(this.this$0)).log(3, "WebBundle.WebBundle", new String[] { "[preload][step 2][#", String.valueOf(this.this$0.hashCode()), "] send message to h5 to load template. pendingData = ", this.val$pendingData.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.webbundle.sdk.WebBundle.3
 * JD-Core Version:    0.7.0.1
 */