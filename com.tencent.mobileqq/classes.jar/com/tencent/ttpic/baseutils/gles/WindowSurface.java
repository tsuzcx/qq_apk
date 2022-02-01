package com.tencent.ttpic.baseutils.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public class WindowSurface
  extends EglSurfaceBase
{
  private boolean mReleaseSurface;
  private Surface mSurface;
  
  public WindowSurface(EglCore paramEglCore, SurfaceTexture paramSurfaceTexture)
  {
    super(paramEglCore);
    createWindowSurface(paramSurfaceTexture);
  }
  
  public WindowSurface(EglCore paramEglCore, Surface paramSurface, boolean paramBoolean)
  {
    super(paramEglCore);
    createWindowSurface(paramSurface);
    this.mSurface = paramSurface;
    this.mReleaseSurface = paramBoolean;
  }
  
  public void recreate(EglCore paramEglCore)
  {
    Surface localSurface = this.mSurface;
    if (localSurface != null)
    {
      this.mEglCore = paramEglCore;
      createWindowSurface(localSurface);
      return;
    }
    throw new RuntimeException("not yet implemented for SurfaceTexture");
  }
  
  public void release()
  {
    releaseEglSurface();
    Surface localSurface = this.mSurface;
    if (localSurface != null)
    {
      if (this.mReleaseSurface) {
        localSurface.release();
      }
      this.mSurface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.gles.WindowSurface
 * JD-Core Version:    0.7.0.1
 */