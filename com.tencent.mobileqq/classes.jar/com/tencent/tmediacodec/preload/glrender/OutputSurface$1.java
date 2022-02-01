package com.tencent.tmediacodec.preload.glrender;

import com.tencent.tmediacodec.hook.PreloadSurfaceTexture.ActionCallback;
import com.tencent.tmediacodec.util.LogUtils;

class OutputSurface$1
  implements PreloadSurfaceTexture.ActionCallback
{
  OutputSurface$1(OutputSurface paramOutputSurface) {}
  
  public void onReleased()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSurfaceTexture:");
    localStringBuilder.append(this.this$0.mSurfaceTexture);
    localStringBuilder.append(" onReleased, release OutputSurface");
    LogUtils.d("OutputSurface", localStringBuilder.toString());
    this.this$0.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.preload.glrender.OutputSurface.1
 * JD-Core Version:    0.7.0.1
 */