package com.tencent.ttpic.openapi.filter;

public class TextureRender
{
  public static final int DISPLAY_FULL = 0;
  public static final int DISPLAY_LEFT_HALF = 1;
  public static final int DISPLAY_RIGHT_HALF = 2;
  private GPUBaseFilter mGPU2DFilter = new GPUBaseFilter();
  private GPUOESBaseFilter mGPUOESFilter = new GPUOESBaseFilter();
  
  public TextureRender()
  {
    this.mGPU2DFilter.init();
    this.mGPUOESFilter.init();
  }
  
  public void drawTexture(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 == 36197)
    {
      this.mGPUOESFilter.drawTexture(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    if (paramInt1 == 3553)
    {
      this.mGPU2DFilter.drawTexture(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
  }
  
  public void release()
  {
    this.mGPU2DFilter.destroy();
    this.mGPUOESFilter.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TextureRender
 * JD-Core Version:    0.7.0.1
 */