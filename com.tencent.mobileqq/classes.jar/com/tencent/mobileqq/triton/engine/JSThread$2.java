package com.tencent.mobileqq.triton.engine;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.concurrent.atomic.AtomicInteger;

class JSThread$2
  implements Choreographer.FrameCallback
{
  JSThread$2(JSThread paramJSThread) {}
  
  public void doFrame(long paramLong)
  {
    if (JSThread.access$000(this.this$0).get() < 1)
    {
      JSThread.access$000(this.this$0).incrementAndGet();
      JSThread.access$300(this.this$0).postRunnable(JSThread.access$200(this.this$0));
    }
    Choreographer.getInstance().postFrameCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.JSThread.2
 * JD-Core Version:    0.7.0.1
 */