package com.tencent.mobileqq.triton.sdk.bridge;

public abstract interface ITTJSRuntime
{
  public static final String CODE_CACHE_SUFFIX = ".cc";
  public static final int CONTEXT_TYPE_MAIN = 1;
  public static final int CONTEXT_TYPE_OPENDATA = 2;
  public static final int CONTEXT_TYPE_UNKNOWN = 0;
  public static final int CONTEXT_TYPE_WORKER = 3;
  public static final String EMPTY_RESULT = "{}";
  
  public abstract void evaluateCallbackJs(int paramInt, String paramString);
  
  public abstract void evaluateJs(String paramString);
  
  public abstract void evaluateSubscribeJs(String paramString1, String paramString2);
  
  public abstract void runOnJsThread(Runnable paramRunnable);
  
  public abstract void runOnJsThreadDelayed(Runnable paramRunnable, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime
 * JD-Core Version:    0.7.0.1
 */