package com.tencent.qqmini.sdk.core.plugins;

import begz;
import bejt;
import beka;
import besl;
import org.json.JSONObject;

public class NativeFeatureJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NativeFeatureJsPlugin";
  
  public void invokeNativePlugin(beka parambeka)
  {
    try
    {
      String str = new JSONObject(parambeka.b).optString("api_name", null);
      this.mMiniAppContext.a(bejt.a("NativePlugin", str, parambeka));
      return;
    }
    catch (Throwable parambeka)
    {
      besl.d("NativeFeatureJsPlugin", "invokeNativePlugin err", parambeka);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NativeFeatureJsPlugin
 * JD-Core Version:    0.7.0.1
 */