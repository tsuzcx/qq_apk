package org.light.gles;

public class OffscreenSurface
  extends EglSurfaceBase
{
  public OffscreenSurface(EglCore paramEglCore, int paramInt1, int paramInt2)
  {
    super(paramEglCore);
    createOffscreenSurface(paramInt1, paramInt2);
  }
  
  public void release()
  {
    releaseEglSurface();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.gles.OffscreenSurface
 * JD-Core Version:    0.7.0.1
 */