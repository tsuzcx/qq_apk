package com.tencent.qqmini.v8rt.engine;

import android.content.Context;

public abstract interface IJsEngine
{
  public abstract boolean canHandleEvent(String paramString);
  
  public abstract V8JsRuntime getJsRuntime(int paramInt);
  
  public abstract void onCreate(Context paramContext);
  
  public abstract void onDestroy();
  
  public abstract String onScriptCall(String paramString1, String paramString2, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.IJsEngine
 * JD-Core Version:    0.7.0.1
 */