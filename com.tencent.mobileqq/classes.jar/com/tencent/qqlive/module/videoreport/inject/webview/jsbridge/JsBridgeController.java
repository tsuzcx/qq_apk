package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.JsInterface;
import java.util.Map;
import java.util.WeakHashMap;

public class JsBridgeController
{
  private static final String JS_BRIDGE_PRE_FIX = "DtJsBridge://";
  public static final String JS_INSTANCE = "DtJsReporter";
  private Map<Object, JsInterface> mJsInterfaceCache = new WeakHashMap();
  
  private JsInterface fetchJsInterface(@NonNull Object paramObject)
  {
    if (this.mJsInterfaceCache.containsKey(paramObject)) {
      localJsInterface = (JsInterface)this.mJsInterfaceCache.get(paramObject);
    } else {
      localJsInterface = null;
    }
    if (localJsInterface != null) {
      return localJsInterface;
    }
    JsInterface localJsInterface = new JsInterface(paramObject);
    this.mJsInterfaceCache.put(paramObject, localJsInterface);
    return localJsInterface;
  }
  
  public static JsBridgeController getInstance()
  {
    return JsBridgeController.InstanceHolder.sInstance;
  }
  
  private String getJsonBody(String paramString)
  {
    return paramString.substring(13);
  }
  
  private boolean isValidMessage(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.startsWith("DtJsBridge://");
    }
    return false;
  }
  
  public String shouldIntercept(Object paramObject, String paramString1, String paramString2)
  {
    if (!isValidMessage(paramString1)) {
      return "";
    }
    if (paramObject == null) {
      return "";
    }
    return JsBridgeCall.call(fetchJsInterface(paramObject), getJsonBody(paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController
 * JD-Core Version:    0.7.0.1
 */