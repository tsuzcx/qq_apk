package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;

public final class PreloadSurfaceTexture
  extends SurfaceTexture
{
  @Nullable
  private PreloadSurfaceTexture.ActionCallback actionCallback;
  
  public PreloadSurfaceTexture(int paramInt)
  {
    super(paramInt);
  }
  
  public void release()
  {
    super.release();
    if (this.actionCallback != null) {
      this.actionCallback.onReleased();
    }
  }
  
  public final void setActionCallback(@Nullable PreloadSurfaceTexture.ActionCallback paramActionCallback)
  {
    this.actionCallback = paramActionCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.hook.PreloadSurfaceTexture
 * JD-Core Version:    0.7.0.1
 */