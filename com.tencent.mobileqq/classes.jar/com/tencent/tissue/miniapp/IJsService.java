package com.tencent.tissue.miniapp;

import com.tencent.tissue.v8rt.engine.V8JsRuntime;

public abstract interface IJsService
{
  public abstract Object executeScriptWithReturn(String paramString1, String paramString2);
  
  public abstract long executeScriptWithReturnPtr(String paramString1, String paramString2);
  
  public abstract V8JsRuntime getRuntime(String paramString);
  
  public abstract int getStatus();
  
  public abstract void loadScript(String paramString1, String paramString2);
  
  public abstract void release();
  
  public abstract void release(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.IJsService
 * JD-Core Version:    0.7.0.1
 */