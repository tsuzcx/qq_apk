package com.tencent.qqmini.sdk.core.plugins;

import behq;
import bekk;
import bekr;
import betc;
import org.json.JSONObject;

public class NativeFeatureJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NativeFeatureJsPlugin";
  
  public void invokeNativePlugin(bekr parambekr)
  {
    try
    {
      String str = new JSONObject(parambekr.b).optString("api_name", null);
      this.mMiniAppContext.a(bekk.a("NativePlugin", str, parambekr));
      return;
    }
    catch (Throwable parambekr)
    {
      betc.d("NativeFeatureJsPlugin", "invokeNativePlugin err", parambekr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NativeFeatureJsPlugin
 * JD-Core Version:    0.7.0.1
 */