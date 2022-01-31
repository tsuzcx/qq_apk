package com.tencent.mobileqq.triton.bridge;

import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;

public class TTJSRuntime
  implements ITTJSRuntime
{
  private int mContextType;
  private TTJSBridge mJSBridge;
  
  public TTJSRuntime(TTJSBridge paramTTJSBridge, int paramInt)
  {
    this.mJSBridge = paramTTJSBridge;
    this.mContextType = paramInt;
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    this.mJSBridge.evaluateCallbackJs("WeixinJSBridge.invokeCallbackHandler", this.mContextType, paramInt, paramString);
  }
  
  public void evaluateJs(String paramString)
  {
    this.mJSBridge.evaluateJs(this.mContextType, paramString);
  }
  
  public void evaluateSubscribeJs(String paramString1, String paramString2)
  {
    this.mJSBridge.evaluateSubscribeJs("WeixinJSBridge.subscribeHandler", this.mContextType, paramString1, paramString2);
  }
  
  public void runOnJsThread(Runnable paramRunnable)
  {
    this.mJSBridge.runOnJsThread(paramRunnable);
  }
  
  public void runOnJsThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    this.mJSBridge.runOnJsThreadDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.TTJSRuntime
 * JD-Core Version:    0.7.0.1
 */