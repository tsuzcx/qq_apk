package com.tencent.plato.web;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.plato.JSONWritableArray;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IWritableArray;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.core.utils.PLog;
import java.io.File;
import java.util.Locale;
import org.json.JSONArray;

public class PWebView
  extends WebView
  implements IWebView
{
  private static final String TAG = "PWebView";
  @Nullable
  private IWebView.IUrlRequestHandler mUrlRequestHandler;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
  }
  
  public PWebView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private IReadableArray coverToArray(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      return new JSONWritableArray();
    }
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if ((localObject instanceof IWritableMap)) {
        localJSONArray.put(((IWritableMap)localObject).toJSONObject());
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof IWritableArray)) {
          localJSONArray.put(((IWritableArray)localObject).toJSONArray());
        } else {
          localJSONArray.put(localObject);
        }
      }
    }
    return new JSONWritableArray(localJSONArray);
  }
  
  private void init()
  {
    setWebViewClient(new H5WebViewClient(null));
    setWebChromeClient(new H5ChromeClient(null));
    removeJavascriptInterface("searchBoxJavaBridge_");
    requestFocus();
    initWebSettings();
  }
  
  public void callFunction(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    evaluateScript(String.format(Locale.US, "javascript:window._jsf&&window._jsf.callFunction(%s,%s,%s)", new Object[] { paramString1, paramString2, coverToArray(paramArrayOfObject).toString() }));
  }
  
  public void evaluateScript(final String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.loadUrl(paramString);
      return;
    }
    post(new Runnable()
    {
      public void run()
      {
        PWebView.this.loadUrl(paramString);
      }
    });
  }
  
  protected void initWebSettings()
  {
    WebSettings localWebSettings = getSettings();
    if (localWebSettings == null) {
      return;
    }
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
    }
    if (i >= 8) {
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
    }
    localWebSettings.setSaveFormData(false);
    localWebSettings.setSavePassword(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSavePassword(false);
    localWebSettings.setAllowContentAccess(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheMaxSize(8388608L);
    File localFile = getContext().getDir("cache", 0);
    if (localFile != null) {
      localWebSettings.setAppCachePath(localFile.getPath());
    }
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setCacheMode(-1);
  }
  
  public void invokeCallback(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject)
  {
    evaluateScript(String.format(Locale.US, "javascript:window._jsf&&window._jsf.invokeCallback(%d,%d,%d,%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), coverToArray(paramArrayOfObject).toString() }));
  }
  
  public void loadUrl(String paramString)
  {
    PLog.i("PWebView", "loadUrl:" + paramString);
    super.loadUrl(paramString);
  }
  
  public void setUrlRequestHandler(IWebView.IUrlRequestHandler paramIUrlRequestHandler)
  {
    this.mUrlRequestHandler = paramIUrlRequestHandler;
  }
  
  private class H5ChromeClient
    extends WebChromeClient
  {
    private H5ChromeClient() {}
  }
  
  private class H5WebViewClient
    extends WebViewClient
  {
    private H5WebViewClient() {}
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (PWebView.this.mUrlRequestHandler != null) {
        PWebView.this.mUrlRequestHandler.onUrlRequest(paramString);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.web.PWebView
 * JD-Core Version:    0.7.0.1
 */