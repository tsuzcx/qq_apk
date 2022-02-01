package com.tencent.qqmini.sdk.browser;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.webkit.WebView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class BrowserPlugin
{
  public static final String KEY_ERROR_CODE = "errorCode";
  public static final String KEY_ERROR_MSG = "errorMsg";
  public static final String KEY_PERFORMANCE = "performanceData";
  public static final String KEY_REQUEST_URL = "requestUrl";
  public static final String KEY_TARGET = "target";
  public static final String KEY_URL = "url";
  AtomicBoolean inited = new AtomicBoolean(false);
  WeakReference<Activity> mActivity;
  WeakReference<Fragment> mFragment;
  WeakReference<WebView> mWebView;
  
  public static JSONObject getJsonFromJSBridge(String paramString)
  {
    try
    {
      int i = paramString.indexOf("=");
      if (i != -1)
      {
        i += 1;
        if (i <= paramString.length() - 1) {
          return new JSONObject(URLDecoder.decode(paramString.substring(i), "UTF-8"));
        }
      }
      throw new Exception("illegal json");
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getJsonFromJSBridge error!");
      localStringBuilder.append(paramString);
      QMLog.e("WebViewPlugin", localStringBuilder.toString(), localException);
    }
    return null;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  protected boolean handleJsRequest(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
  
  final void initRuntime(Activity paramActivity)
  {
    if (this.inited.compareAndSet(false, true)) {
      this.mActivity = new WeakReference(paramActivity);
    }
  }
  
  protected void onCreate() {}
  
  protected void onDestroy() {}
  
  protected void onWebViewCreated(WebView paramWebView)
  {
    if (paramWebView != null) {
      this.mWebView = new WeakReference(paramWebView);
    }
  }
  
  public void setFragment(Fragment paramFragment)
  {
    this.mFragment = new WeakReference(paramFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.browser.BrowserPlugin
 * JD-Core Version:    0.7.0.1
 */