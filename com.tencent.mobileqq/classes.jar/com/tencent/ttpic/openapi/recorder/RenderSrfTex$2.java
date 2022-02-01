package com.tencent.ttpic.openapi.recorder;

import android.opengl.EGLContext;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.WindowSurface;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.recorder.MyRecorder;

class RenderSrfTex$2
  implements Runnable
{
  RenderSrfTex$2(RenderSrfTex paramRenderSrfTex, EGLContext paramEGLContext) {}
  
  public void run()
  {
    LogUtils.d(RenderSrfTex.access$1000(), "[record] mRecorder.getInputSurface() begin");
    Object localObject = RenderSrfTex.access$900(this.this$0).getInputSurface();
    LogUtils.d(RenderSrfTex.access$1000(), "[record] mRecorder.getInputSurface() end");
    if (localObject == null)
    {
      RenderSrfTex.access$802(this.this$0, null);
      LogUtils.e(RenderSrfTex.access$1000(), "[record] mInputSurface = null!");
      return;
    }
    LogUtils.d(RenderSrfTex.access$1000(), "[record] new InputSurface begin");
    RenderSrfTex.access$1102(this.this$0, new EglCore(this.val$eglContext, 0));
    localObject = this.this$0;
    RenderSrfTex.access$802((RenderSrfTex)localObject, new WindowSurface(RenderSrfTex.access$1100((RenderSrfTex)localObject), RenderSrfTex.access$900(this.this$0).getInputSurface(), true));
    LogUtils.d(RenderSrfTex.access$1000(), "[record] new InputSurface end");
    LogUtils.d(RenderSrfTex.access$1000(), "[record] makeCurrent begin");
    RenderSrfTex.access$800(this.this$0).makeCurrent();
    LogUtils.d(RenderSrfTex.access$1000(), "[record] makeCurrent end");
    LogUtils.d(RenderSrfTex.access$1000(), "[record] initGL begin");
    RenderSrfTex.access$1200(this.this$0);
    LogUtils.d(RenderSrfTex.access$1000(), "[record] initGL end");
    try
    {
      LogUtils.d(RenderSrfTex.access$1000(), "[record] mRecorder.start() begin");
      RenderSrfTex.access$900(this.this$0).start();
      LogUtils.d(RenderSrfTex.access$1000(), "[record] mRecorder.start() end");
    }
    catch (Exception localException)
    {
      LogUtils.e(RenderSrfTex.access$1000(), "[record] mRecorder.start() exception!");
      RenderSrfTex.access$900(this.this$0).releaseEncoder();
      localException.printStackTrace();
    }
    LogUtils.d(RenderSrfTex.access$1000(), "[record] initGlThread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.RenderSrfTex.2
 * JD-Core Version:    0.7.0.1
 */