package com.tencent.mobileqq.triton.bridge;

import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;

public class c
  implements ITTJSRuntime
{
  private TTJSBridge a;
  private int b;
  
  public c(TTJSBridge paramTTJSBridge, int paramInt)
  {
    this.a = paramTTJSBridge;
    this.b = paramInt;
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    this.a.a("WeixinJSBridge.invokeCallbackHandler", this.b, paramInt, paramString);
  }
  
  public void evaluateJs(String paramString)
  {
    this.a.a(this.b, paramString);
  }
  
  public void evaluateSubscribeJs(String paramString1, String paramString2)
  {
    this.a.a("WeixinJSBridge.subscribeHandler", this.b, paramString1, paramString2);
  }
  
  public void runOnJsThread(Runnable paramRunnable)
  {
    this.a.a(paramRunnable);
  }
  
  public void runOnJsThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    this.a.a(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.c
 * JD-Core Version:    0.7.0.1
 */