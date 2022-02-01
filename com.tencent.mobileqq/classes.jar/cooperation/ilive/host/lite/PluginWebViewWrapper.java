package cooperation.ilive.host.lite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiveBusinessJsInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper;
import cooperation.ilive.host.lite.white.IJsAdapter;
import cooperation.ilive.host.lite.white.IWebviewListener;
import cooperation.ilive.host.lite.white.IWebviewWrapper;

public class PluginWebViewWrapper
  implements IWebviewWrapper
{
  private static final String TAG = "PluginWebViewWrapper";
  private PluginLiteLiveJsProvider mLiteLiveJsProvider;
  private LiveBusinessJsInterface mLiveBusinessJsInterface = new PluginWebViewWrapper.1(this);
  private WebviewWrapper mWebViewWrapper;
  
  public PluginWebViewWrapper(IJsAdapter paramIJsAdapter, View paramView)
  {
    this.mLiteLiveJsProvider = new PluginLiteLiveJsProvider(paramIJsAdapter);
    this.mWebViewWrapper = new WebviewWrapper(BaseApplicationImpl.getContext(), null, this.mLiteLiveJsProvider, this.mLiveBusinessJsInterface, paramView);
  }
  
  public void callJs(String paramString)
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.callJs(paramString);
  }
  
  public PluginWebView getWebview()
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return null;
    }
    return new PluginWebView(localWebviewWrapper.getWebview());
  }
  
  public void onDestroy()
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.onDestroy();
  }
  
  public void onDetach()
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.onDestroy();
  }
  
  public void onInit(Context paramContext, Intent paramIntent, String paramString, IWebviewListener paramIWebviewListener)
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.onInit((Activity)paramContext, paramIntent, paramString, new PluginWebViewWrapper.2(this, paramIWebviewListener));
  }
  
  public void onPause()
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.onPause();
  }
  
  public void onResume()
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.onResume();
  }
  
  public void onWebViewReady(Intent paramIntent, boolean paramBoolean)
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.onWebViewReady(paramIntent, paramBoolean);
  }
  
  public void preInit()
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.preInit();
  }
  
  public void setOnWebviewTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.setOnWebviewTouchListener(paramOnTouchListener);
  }
  
  public void webViewDirectorConstruct()
  {
    WebviewWrapper localWebviewWrapper = this.mWebViewWrapper;
    if (localWebviewWrapper == null) {
      return;
    }
    localWebviewWrapper.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.lite.PluginWebViewWrapper
 * JD-Core Version:    0.7.0.1
 */