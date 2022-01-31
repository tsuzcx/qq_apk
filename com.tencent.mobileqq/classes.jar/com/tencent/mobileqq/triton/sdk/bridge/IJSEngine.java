package com.tencent.mobileqq.triton.sdk.bridge;

import android.content.Context;

public abstract interface IJSEngine
{
  public abstract boolean canHandleEvent(String paramString);
  
  public abstract ITTJSRuntime getJsRuntime(int paramInt);
  
  public abstract void onCreate(Context paramContext);
  
  public abstract void onDestroy();
  
  public abstract String onScriptCall(String paramString1, String paramString2, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.bridge.IJSEngine
 * JD-Core Version:    0.7.0.1
 */