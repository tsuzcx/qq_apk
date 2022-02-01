package com.tencent.tmediacodec.preload.glrender;

import com.tencent.tmediacodec.hook.PreloadSurfaceTexture.ActionCallback;
import com.tencent.tmediacodec.util.LogUtils;

class OutputSurface$1
  implements PreloadSurfaceTexture.ActionCallback
{
  OutputSurface$1(OutputSurface paramOutputSurface) {}
  
  public void onReleased()
  {
    LogUtils.d("OutputSurface", "mSurfaceTexture:" + this.this$0.mSurfaceTexture + " onReleased, release OutputSurface");
    this.this$0.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.preload.glrender.OutputSurface.1
 * JD-Core Version:    0.7.0.1
 */