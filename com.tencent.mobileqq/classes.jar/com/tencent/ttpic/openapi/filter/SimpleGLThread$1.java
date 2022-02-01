package com.tencent.ttpic.openapi.filter;

import android.opengl.EGLContext;
import android.util.Log;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.openapi.config.MediaConfig;

class SimpleGLThread$1
  implements Runnable
{
  SimpleGLThread$1(SimpleGLThread paramSimpleGLThread, EGLContext paramEGLContext, SimpleGLThread.OnSurfaceCreatedListener paramOnSurfaceCreatedListener) {}
  
  public void run()
  {
    try
    {
      SimpleGLThread.access$002(this.this$0, new EglCore(this.val$shareContext, 0));
      Object localObject = this.this$0;
      SimpleGLThread.access$102((SimpleGLThread)localObject, new OffscreenSurface(SimpleGLThread.access$000((SimpleGLThread)localObject), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
      SimpleGLThread.access$100(this.this$0).makeCurrent();
      localObject = this.val$listener;
      if (localObject != null) {
        ((SimpleGLThread.OnSurfaceCreatedListener)localObject).onSurfaceCreated(SimpleGLThread.access$100(this.this$0));
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new EglCore crash : ");
      localStringBuilder.append(localRuntimeException.getMessage());
      Log.e("SimpleGLThread", localStringBuilder.toString());
      SimpleGLThread.access$002(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.SimpleGLThread.1
 * JD-Core Version:    0.7.0.1
 */