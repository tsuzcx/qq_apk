package com.tencent.mobileqq.shortvideo.mtveffects;

import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ShapeRender
{
  public static final int TYPE_IMAGE = 2;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_POLYGON = 1;
  private int mColor = -65536;
  private RenderBuffer mMaskFBO;
  private MaskFilter mMaskFilter;
  private ShapeFilter mShapeFilter;
  private float[] mShapePoints;
  private int mType = 1;
  
  private void drawShape()
  {
    if ((this.mType == 1) && (this.mMaskFBO != null))
    {
      LayerRenderBase.clearColorBuffer(this.mMaskFBO, 0);
      this.mMaskFBO.bind();
      this.mMaskFilter.drawShape(this.mShapePoints, this.mColor, null);
      this.mMaskFBO.unbind();
    }
  }
  
  public void begin()
  {
    if (this.mType == 0) {
      return;
    }
    drawShape();
  }
  
  public void end()
  {
    if (this.mType == 0) {}
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (this.mMaskFilter == null) {
        break label75;
      }
      this.mMaskFilter.onOutputSizeChanged(paramInt1, paramInt2);
      if (this.mShapeFilter == null) {
        break label105;
      }
      this.mShapeFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
    for (;;)
    {
      if (this.mMaskFBO != null)
      {
        LayerRenderBase.releaseRenderBuffer(this.mMaskFBO);
        this.mMaskFBO = null;
      }
      this.mMaskFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
      return;
      label75:
      this.mMaskFilter = new MaskFilter();
      this.mMaskFilter.init();
      this.mMaskFilter.onOutputSizeChanged(paramInt1, paramInt2);
      break;
      label105:
      this.mShapeFilter = new ShapeFilter();
      this.mShapeFilter.init();
      this.mShapeFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceDestroy()
  {
    if (this.mMaskFilter != null)
    {
      this.mMaskFilter.destroy();
      this.mMaskFilter = null;
    }
    if (this.mShapeFilter != null)
    {
      this.mShapeFilter.destroy();
      this.mShapeFilter = null;
    }
    if (this.mMaskFBO != null)
    {
      LayerRenderBase.releaseRenderBuffer(this.mMaskFBO);
      this.mMaskFBO = null;
    }
  }
  
  public void setShapeData(int paramInt, float[] paramArrayOfFloat)
  {
    this.mType = paramInt;
    this.mShapePoints = paramArrayOfFloat;
  }
  
  public int shape(RenderBuffer paramRenderBuffer, int paramInt)
  {
    if ((this.mShapeFilter == null) || (this.mMaskFBO == null) || (this.mShapeFilter == null)) {
      return paramInt;
    }
    paramRenderBuffer.bind();
    this.mShapeFilter.process(paramInt, this.mMaskFBO.getTexId(), null, null);
    paramRenderBuffer.unbind();
    return paramRenderBuffer.getTexId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.ShapeRender
 * JD-Core Version:    0.7.0.1
 */