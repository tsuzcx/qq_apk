package com.tencent.mobileqq.triton.engine;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.util.concurrent.atomic.AtomicInteger;

class b$b
  implements Choreographer.FrameCallback
{
  b$b(b paramb) {}
  
  public void doFrame(long paramLong)
  {
    if (b.a(this.a).get() < 1)
    {
      b.d(this.a).l().updateDisplayFrameTime(paramLong, b.c(this.a));
      b.a(this.a, false);
      b.a(this.a).incrementAndGet();
      b.d(this.a).a(b.e(this.a));
    }
    Choreographer.getInstance().postFrameCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.b.b
 * JD-Core Version:    0.7.0.1
 */