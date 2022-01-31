package com.tencent.mobileqq.triton.engine;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.concurrent.atomic.AtomicInteger;

class JSThread$1
  implements Choreographer.FrameCallback
{
  JSThread$1(JSThread paramJSThread) {}
  
  public void doFrame(long paramLong)
  {
    if (JSThread.access$000(this.this$0).get() < 1)
    {
      JSThread.access$000(this.this$0).incrementAndGet();
      JSThread.access$200(this.this$0).postRunnable(new JSThread.CallbackMainLoop(this.this$0, paramLong));
    }
    Choreographer.getInstance().postFrameCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.JSThread.1
 * JD-Core Version:    0.7.0.1
 */