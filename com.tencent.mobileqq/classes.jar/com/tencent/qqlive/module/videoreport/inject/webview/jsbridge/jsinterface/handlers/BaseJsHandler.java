package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.inject.webview.WebViewCompatHelper;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.IJsEntityFormatter;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.JsCallbackBuilder;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public abstract class BaseJsHandler
{
  protected WeakReference<Object> mWeakWebViewImpl;
  
  private BaseJsHandler() {}
  
  BaseJsHandler(WeakReference<Object> paramWeakReference)
  {
    this.mWeakWebViewImpl = paramWeakReference;
  }
  
  public static String getCallbackId(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optString("callbackId");
    }
    return null;
  }
  
  @Nullable
  private Object getRealWebView()
  {
    WeakReference localWeakReference = this.mWeakWebViewImpl;
    if (localWeakReference != null) {
      return localWeakReference.get();
    }
    return null;
  }
  
  private void handleCallback(String paramString1, String paramString2, String paramString3, IJsEntityFormatter paramIJsEntityFormatter)
  {
    paramString2 = new JsCallbackBuilder().setRet(paramString2).setMsg(paramString3).setData(paramIJsEntityFormatter).format();
    paramString3 = getRealWebView();
    paramIJsEntityFormatter = new StringBuilder();
    paramIJsEntityFormatter.append("javascript:DtJsReporter.callback('");
    paramIJsEntityFormatter.append(paramString1);
    paramIJsEntityFormatter.append("',");
    paramIJsEntityFormatter.append(paramString2);
    paramIJsEntityFormatter.append(");");
    WebViewCompatHelper.loadUrl(paramString3, paramIJsEntityFormatter.toString());
  }
  
  protected void callback(String paramString1, String paramString2, String paramString3, IJsEntityFormatter paramIJsEntityFormatter)
  {
    if (ThreadUtils.isMainThread())
    {
      handleCallback(paramString1, paramString2, paramString3, paramIJsEntityFormatter);
      return;
    }
    ThreadUtils.runOnUiThread(new BaseJsHandler.1(this, paramString1, paramString2, paramString3, paramIJsEntityFormatter));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.BaseJsHandler
 * JD-Core Version:    0.7.0.1
 */