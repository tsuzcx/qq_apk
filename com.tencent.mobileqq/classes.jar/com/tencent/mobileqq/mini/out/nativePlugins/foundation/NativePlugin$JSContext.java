package com.tencent.mobileqq.mini.out.nativePlugins.foundation;

import android.app.Activity;
import org.json.JSONObject;

public abstract interface NativePlugin$JSContext
{
  public abstract void callJs(String paramString, JSONObject paramJSONObject);
  
  public abstract void evaluateCallback(boolean paramBoolean, JSONObject paramJSONObject, String paramString);
  
  public abstract Activity getActivity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext
 * JD-Core Version:    0.7.0.1
 */