package org.light.gles;

import android.os.Handler;
import android.os.Looper;

class SimpleGLThread$2
  implements Runnable
{
  SimpleGLThread$2(SimpleGLThread paramSimpleGLThread, Runnable paramRunnable) {}
  
  public void run()
  {
    Runnable localRunnable = this.val$clearRunable;
    if (localRunnable != null) {
      localRunnable.run();
    }
    if (SimpleGLThread.access$000(this.this$0) != null)
    {
      SimpleGLThread.access$100(this.this$0).release();
      SimpleGLThread.access$000(this.this$0).release();
      SimpleGLThread.access$200(this.this$0).getLooper().quitSafely();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.gles.SimpleGLThread.2
 * JD-Core Version:    0.7.0.1
 */