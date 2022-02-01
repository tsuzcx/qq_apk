package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.TextureInfo;

public abstract class TAVBaseFilter
  implements TAVTextureProcessor, Cloneable
{
  protected final String TAG = getClass().getSimpleName();
  protected float alpha = 1.0F;
  protected CGRect cropRect;
  protected int[] defaultViewport = new int[4];
  protected String fragmentShaderCode;
  protected long id = System.nanoTime();
  protected boolean overlay;
  protected int program;
  protected int rendererHeight;
  protected int rendererWidth;
  protected Matrix stMatrix;
  protected int stMatrixHandle;
  protected int textureType;
  protected String vertexShaderCode;
  protected Matrix xyMatrix;
  protected int xyMatrixHandle;
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo)
  {
    paramTextureInfo = applyNewTexture(paramTextureInfo);
    onProcess(paramTextureInfo);
    return paramTextureInfo;
  }
  
  public TAVBaseFilter clone()
  {
    return this;
  }
  
  protected <T extends TAVBaseFilter> T cloneFilter(T paramT)
  {
    paramT.setRendererWidth(this.rendererWidth);
    paramT.setRendererWidth(this.rendererHeight);
    paramT.setOverlay(this.overlay);
    paramT.alpha = this.alpha;
    paramT.cropRect = this.cropRect;
    paramT.xyMatrix = this.xyMatrix;
    paramT.stMatrix = this.stMatrix;
    paramT.id = this.id;
    return paramT;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public boolean isOverlay()
  {
    return this.overlay;
  }
  
  public void onProcess(TextureInfo paramTextureInfo) {}
  
  public void setOverlay(boolean paramBoolean)
  {
    this.overlay = paramBoolean;
  }
  
  public void setParams(Matrix paramMatrix1, Matrix paramMatrix2, CGRect paramCGRect, float paramFloat) {}
  
  public void setRendererHeight(int paramInt)
  {
    this.rendererHeight = paramInt;
  }
  
  public void setRendererWidth(int paramInt)
  {
    this.rendererWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.TAVBaseFilter
 * JD-Core Version:    0.7.0.1
 */