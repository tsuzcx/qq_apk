package com.tencent.mobileqq.vaswebviewplugin;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

class VasWebviewJsPluginV2$SubscriberMethod
{
  final String args;
  final Method method;
  final String scheme;
  final int threadMode;
  
  public VasWebviewJsPluginV2$SubscriberMethod(Method paramMethod, String paramString1, int paramInt, String paramString2)
  {
    this.method = paramMethod;
    this.threadMode = paramInt;
    this.scheme = paramString1;
    this.args = paramString2;
  }
  
  public Runnable buildSafeRunnable(VasWebviewJsPluginV2 paramVasWebviewJsPluginV2, VasWebviewJsPluginV2.JsData paramJsData, JSONObject paramJSONObject)
  {
    return new VasWebviewJsPluginV2.SubscriberMethod.1(this, new WeakReference(paramVasWebviewJsPluginV2), paramJsData, paramJSONObject);
  }
  
  public String toString()
  {
    return "SubscriberMethod{method=" + this.method + ", threadMode=" + this.threadMode + ", scheme='" + this.scheme + '\'' + ", args='" + this.args + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2.SubscriberMethod
 * JD-Core Version:    0.7.0.1
 */