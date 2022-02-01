package com.tencent.mobileqq.mini.out.nativePlugins.foundation;

import org.json.JSONObject;

public abstract interface NativePlugin
{
  public abstract void onDestroy();
  
  public abstract void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
 * JD-Core Version:    0.7.0.1
 */