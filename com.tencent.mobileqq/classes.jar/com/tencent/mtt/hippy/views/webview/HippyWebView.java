package com.tencent.mtt.hippy.views.webview;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.FrameLayout;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportWebChromeClient;

public class HippyWebView
  extends FrameLayout
  implements HippyViewBase
{
  private HippyViewEvent mEventOnMessage = null;
  protected final HippyWebViewInner mWebView;
  
  public HippyWebView(Context paramContext)
  {
    super(paramContext);
    this.mWebView = new HippyWebViewInner(paramContext);
    addView(this.mWebView);
    initWebView();
  }
  
  private void initWebView()
  {
    this.mWebView.setWebViewClient(new HippyWebView.1(this));
    this.mWebView.setWebChromeClient(new ReportWebChromeClient());
    if (Build.VERSION.SDK_INT >= 17) {
      this.mWebView.addJavascriptInterface(new HippyWebViewBridge(this), "hippy");
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      this.mWebView.removeJavascriptInterface("accessibility");
      this.mWebView.removeJavascriptInterface("accessibilityTraversal");
    }
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void postMessage(String paramString)
  {
    if (this.mEventOnMessage == null) {
      this.mEventOnMessage = new HippyViewEvent("onMessage");
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("data", paramString);
    this.mEventOnMessage.send(this, localHippyMap);
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.webview.HippyWebView
 * JD-Core Version:    0.7.0.1
 */