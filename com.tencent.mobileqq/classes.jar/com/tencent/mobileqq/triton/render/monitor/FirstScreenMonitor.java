package com.tencent.mobileqq.triton.render.monitor;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.jni.JNICaller.TTEngine;
import com.tencent.mobileqq.triton.render.RenderContext.ISwapListener;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;

public class FirstScreenMonitor
  implements RenderContext.ISwapListener
{
  private boolean isFirstScreen = true;
  private TTEngine mTritonEngine;
  
  public FirstScreenMonitor(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  private void checkIsFirstScreen()
  {
    if ((this.isFirstScreen) && (JNICaller.TTEngine.nativeStartDrawCall(this.mTritonEngine)))
    {
      this.isFirstScreen = false;
      ITTEngine.IListener localIListener = this.mTritonEngine.getEngineListener();
      if (localIListener != null) {
        localIListener.onFirstRender();
      }
    }
  }
  
  public void onSwap()
  {
    checkIsFirstScreen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.monitor.FirstScreenMonitor
 * JD-Core Version:    0.7.0.1
 */