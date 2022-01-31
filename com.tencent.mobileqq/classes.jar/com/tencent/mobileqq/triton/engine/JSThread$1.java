package com.tencent.mobileqq.triton.engine;

import java.util.concurrent.atomic.AtomicInteger;

class JSThread$1
  implements Runnable
{
  JSThread$1(JSThread paramJSThread) {}
  
  public void run()
  {
    JSThread.access$000(this.this$0).decrementAndGet();
    JSThread.IListener localIListener = JSThread.access$100(this.this$0);
    if (localIListener != null) {
      localIListener.onVSync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.JSThread.1
 * JD-Core Version:    0.7.0.1
 */