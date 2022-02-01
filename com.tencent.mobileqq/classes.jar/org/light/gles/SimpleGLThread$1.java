package org.light.gles;

import android.opengl.EGLContext;
import android.util.Log;

class SimpleGLThread$1
  implements Runnable
{
  SimpleGLThread$1(SimpleGLThread paramSimpleGLThread, EGLContext paramEGLContext, SimpleGLThread.OnSurfaceCreatedListener paramOnSurfaceCreatedListener) {}
  
  public void run()
  {
    try
    {
      SimpleGLThread.access$002(this.this$0, new EglCore(this.val$shareContext, 0));
      SimpleGLThread.access$102(this.this$0, new OffscreenSurface(SimpleGLThread.access$000(this.this$0), 720, 960));
      SimpleGLThread.access$100(this.this$0).makeCurrent();
      if (this.val$listener != null) {
        this.val$listener.onSurfaceCreated(SimpleGLThread.access$100(this.this$0));
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("SimpleGLThread", "new EglCore crash : " + localRuntimeException.getMessage());
      SimpleGLThread.access$002(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.gles.SimpleGLThread.1
 * JD-Core Version:    0.7.0.1
 */