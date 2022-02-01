package org.libpag;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;

class GPUDecoder$3
  implements Runnable
{
  GPUDecoder$3(GPUDecoder paramGPUDecoder, Runnable paramRunnable, HandlerThread paramHandlerThread) {}
  
  public void run()
  {
    this.val$runnable.run();
    GPUDecoder.access$100().getAndDecrement();
    new Handler(Looper.getMainLooper()).post(new GPUDecoder.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.GPUDecoder.3
 * JD-Core Version:    0.7.0.1
 */