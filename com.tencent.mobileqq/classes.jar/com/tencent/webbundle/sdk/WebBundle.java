package com.tencent.webbundle.sdk;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class WebBundle
  implements IStateHolder<WebBundle.WebBundlePreloadState>
{
  private static final String TAG = "WebBundle.WebBundle";
  private String mBizId;
  private final MutableContextWrapper mContext;
  private ArrayList<WebBundle.PreloadStateListener> mListeners = new ArrayList();
  private WebBundle.WebBundlePreloadState mPreloadState = WebBundle.WebBundlePreloadState.INIT;
  private final Runnable mPreloadTimeOutChecker = new WebBundle.1(this);
  private final WebBundle.WebBundleInterface mWebBundleInterface = new WebBundle.WebBundleInterface(this, this);
  private String preloadUrl = "";
  private String realUrl = "";
  private IWebBundleWebView webView = null;
  
  public WebBundle(Context paramContext, String paramString)
  {
    this.mContext = new MutableContextWrapper(paramContext);
    this.mBizId = paramString;
  }
  
  private void notifyPreloadStateChanged(@NotNull WebBundle.WebBundlePreloadState paramWebBundlePreloadState)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((WebBundle.PreloadStateListener)this.mListeners.get(i)).onStateChange(this, paramWebBundlePreloadState);
      i += 1;
    }
  }
  
  public void destroy()
  {
    ThreadManager.getUiHandler().removeCallbacks(this.mPreloadTimeOutChecker);
    resetContext(this.mContext.getApplicationContext());
    if (this.webView != null)
    {
      this.webView.destroy();
      this.webView = null;
    }
    this.mListeners.clear();
  }
  
  public void forceStop(@NotNull String paramString)
  {
    if (getPreloadState() != WebBundle.WebBundlePreloadState.SUCCESS)
    {
      WebBundleManager.getInstance(this.mBizId).log(3, "WebBundle.WebBundle", new String[] { "stop preloading webbundle because ", paramString });
      setPreloadState(WebBundle.WebBundlePreloadState.FAILED);
    }
  }
  
  public WebBundle.WebBundlePreloadState getPreloadState()
  {
    return this.mPreloadState;
  }
  
  public String getPreloadUrl()
  {
    return this.preloadUrl;
  }
  
  public String getRealUrl()
  {
    return this.realUrl;
  }
  
  public IWebBundleWebView getWebView()
  {
    return this.webView;
  }
  
  public void resetContext(Context paramContext)
  {
    this.mContext.setBaseContext(paramContext);
  }
  
  public void setPreloadState(@NotNull WebBundle.WebBundlePreloadState paramWebBundlePreloadState)
  {
    ThreadManager.executeOnUiThread(new WebBundle.4(this, paramWebBundlePreloadState));
  }
  
  public void startPreload(@NotNull String paramString, @NotNull JSONObject paramJSONObject, WebBundle.PreloadStateListener paramPreloadStateListener)
  {
    ThreadManager.checkMainThread("startPreload");
    IWebBundleRuntime localIWebBundleRuntime = WebBundleManager.getInstance(this.mBizId).getRuntime();
    if (localIWebBundleRuntime == null)
    {
      ThreadManager.getUiHandler().post(new WebBundle.2(this));
      return;
    }
    this.preloadUrl = paramString;
    if (paramPreloadStateListener != null) {
      this.mListeners.add(paramPreloadStateListener);
    }
    long l = 15000L;
    paramPreloadStateListener = WebBundleManager.getInstance(this.mBizId).getConfig();
    if (paramPreloadStateListener != null) {
      l = paramPreloadStateListener.getPreloadTimeoutLimit();
    }
    ThreadManager.getUiHandler().postDelayed(this.mPreloadTimeOutChecker, l);
    setPreloadState(WebBundle.WebBundlePreloadState.CREATE_WEBVIEW);
    this.webView = localIWebBundleRuntime.createWebView(this.mContext);
    if (this.webView != null)
    {
      this.webView.enableJavaScript(true);
      this.webView.addJavascriptInterface(this.mWebBundleInterface, "webbundle");
      this.webView.setOnPageFinishedListener(new WebBundle.3(this, paramJSONObject));
      setPreloadState(WebBundle.WebBundlePreloadState.LOAD_PAGE);
      this.webView.loadUrl(paramString);
    }
    WebBundleManager.getInstance(this.mBizId).log(3, "WebBundle.WebBundle", new String[] { "[preload][step 1][#", String.valueOf(hashCode()), "] init webview finish.." });
  }
  
  public void use(@NotNull JSONObject paramJSONObject)
  {
    ThreadManager.checkMainThread("use");
    String str = "";
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    if (localJSONObject != null) {
      str = localJSONObject.toString();
    }
    this.mWebBundleInterface.setJson(str);
    this.realUrl = paramJSONObject.optString("url");
    paramJSONObject.remove("data");
    if (this.webView != null) {
      this.webView.dispatchJsEvent("vashybrid_bundle_message", paramJSONObject, null);
    }
    WebBundleManager.getInstance(this.mBizId).log(3, "WebBundle.WebBundle", new String[] { "[use][step 1][#", String.valueOf(hashCode()), "] send message to h5 for push view. url = ", this.realUrl, ", data = ", WebBundle.WebBundleInterface.access$100(this.mWebBundleInterface) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.webbundle.sdk.WebBundle
 * JD-Core Version:    0.7.0.1
 */