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
    PreloadSurfaceTexture.ActionCallback localActionCallback = this.actionCallback;
    if (localActionCallback != null) {
      localActionCallback.onReleased();
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