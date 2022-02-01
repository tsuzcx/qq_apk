package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.inject.webview.WebViewCompatHelper;
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
    JsInterface localJsInterface = null;
    if (this.mJsInterfaceCache.containsKey(paramObject)) {
      localJsInterface = (JsInterface)this.mJsInterfaceCache.get(paramObject);
    }
    if (localJsInterface != null) {
      return localJsInterface;
    }
    localJsInterface = new JsInterface(paramObject);
    this.mJsInterfaceCache.put(paramObject, localJsInterface);
    return localJsInterface;
  }
  
  public static JsBridgeController getInstance()
  {
    return JsBridgeController.InstanceHolder.sInstance;
  }
  
  private boolean isValidMessage(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.startsWith("DtJsBridge://");
    }
    return false;
  }
  
  public boolean shouldIntercept(Object paramObject1, String paramString1, String paramString2, Object paramObject2)
  {
    if (!isValidMessage(paramString1)) {}
    while (paramObject1 == null) {
      return false;
    }
    WebViewCompatHelper.onJsConfirmResult(paramObject2, JsBridgeCall.call(fetchJsInterface(paramObject1), paramString1.substring("DtJsBridge://".length()), paramString2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController
 * JD-Core Version:    0.7.0.1
 */