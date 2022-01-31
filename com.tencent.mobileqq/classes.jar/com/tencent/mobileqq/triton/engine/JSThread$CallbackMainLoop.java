package com.tencent.mobileqq.triton.engine;

import java.util.concurrent.atomic.AtomicInteger;

class JSThread$CallbackMainLoop
  implements Runnable
{
  private long frameTimeNanos;
  
  public JSThread$CallbackMainLoop(JSThread paramJSThread, long paramLong)
  {
    this.frameTimeNanos = paramLong;
  }
  
  public void run()
  {
    JSThread.access$000(this.this$0).decrementAndGet();
    JSThread.IListener localIListener = JSThread.access$100(this.this$0);
    if (localIListener != null) {
      localIListener.onVSync(this.frameTimeNanos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.JSThread.CallbackMainLoop
 * JD-Core Version:    0.7.0.1
 */