package com.tencent.taveffect.core;

import android.graphics.Matrix;

public abstract class TAVBaseFilter
  implements TAVTextureProcessor, Cloneable
{
  protected final String TAG = getClass().getSimpleName();
  protected float alpha = 1.0F;
  protected TAVRectangle cropRect;
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
  protected TAVTimeRange timeRange;
  protected String vertexShaderCode;
  protected Matrix xyMatrix;
  protected int xyMatrixHandle;
  
  public TAVTextureInfo applyFilter(TAVTextureInfo paramTAVTextureInfo)
  {
    TAVTextureInfo localTAVTextureInfo = paramTAVTextureInfo;
    if (isValid(paramTAVTextureInfo))
    {
      localTAVTextureInfo = applyNewTexture(paramTAVTextureInfo);
      onProcess(localTAVTextureInfo);
    }
    return localTAVTextureInfo;
  }
  
  public TAVBaseFilter clone()
  {
    return this;
  }
  
  protected <T extends TAVBaseFilter> T cloneFilter(T paramT)
  {
    TAVTimeRange localTAVTimeRange = this.timeRange;
    if (localTAVTimeRange != null) {
      paramT.setTimeRange(new TAVTimeRange(localTAVTimeRange.start(), this.timeRange.duration()));
    }
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
  
  public TAVTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public boolean isOverlay()
  {
    return this.overlay;
  }
  
  protected boolean isValid(TAVTextureInfo paramTAVTextureInfo)
  {
    TAVTimeRange localTAVTimeRange = this.timeRange;
    if (localTAVTimeRange == null) {
      return true;
    }
    return localTAVTimeRange.contain(paramTAVTextureInfo.frameTimeUs);
  }
  
  public void onProcess(TAVTextureInfo paramTAVTextureInfo) {}
  
  public void setOverlay(boolean paramBoolean)
  {
    this.overlay = paramBoolean;
  }
  
  public void setParams(Matrix paramMatrix1, Matrix paramMatrix2, TAVRectangle paramTAVRectangle, float paramFloat) {}
  
  public void setRendererHeight(int paramInt)
  {
    this.rendererHeight = paramInt;
  }
  
  public void setRendererWidth(int paramInt)
  {
    this.rendererWidth = paramInt;
  }
  
  public void setTimeRange(TAVTimeRange paramTAVTimeRange)
  {
    this.timeRange = paramTAVTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVBaseFilter
 * JD-Core Version:    0.7.0.1
 */