package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface;

import android.webkit.JavascriptInterface;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.JsReportHandler;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.JsSdkInfoHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsInterface
{
  private static final String KEY_GET_SDK_INFO = "getSdkInfo";
  private static final String KEY_REPORT_EVENT = "reportEvent";
  private Map<String, IJsObjectHandler> mObjectHandlers = new HashMap();
  
  private JsInterface() {}
  
  public JsInterface(Object paramObject)
  {
    registerHandlers(new WeakReference(paramObject));
  }
  
  private IJsObjectHandler getHandlerByName(String paramString)
  {
    return (IJsObjectHandler)this.mObjectHandlers.get(paramString);
  }
  
  private void registerHandlers(WeakReference<Object> paramWeakReference)
  {
    this.mObjectHandlers.put("reportEvent", new JsReportHandler(paramWeakReference));
    this.mObjectHandlers.put("getSdkInfo", new JsSdkInfoHandler(paramWeakReference));
  }
  
  @JavascriptInterface
  public void getSdkVersion(JSONObject paramJSONObject)
  {
    getHandlerByName("getSdkInfo").handle("getSdkVersion", paramJSONObject);
  }
  
  @JavascriptInterface
  public void reportEvent(JSONObject paramJSONObject)
  {
    getHandlerByName("reportEvent").handle("reportEvent", paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.JsInterface
 * JD-Core Version:    0.7.0.1
 */