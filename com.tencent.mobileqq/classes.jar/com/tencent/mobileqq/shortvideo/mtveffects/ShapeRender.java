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
    if (this.mType == 1)
    {
      RenderBuffer localRenderBuffer = this.mMaskFBO;
      if (localRenderBuffer != null)
      {
        LayerRenderBase.clearColorBuffer(localRenderBuffer, 0);
        this.mMaskFBO.bind();
        this.mMaskFilter.drawShape(this.mShapePoints, this.mColor, null);
        this.mMaskFBO.unbind();
      }
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
      Object localObject = this.mMaskFilter;
      if (localObject != null)
      {
        ((MaskFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        this.mMaskFilter = new MaskFilter();
        this.mMaskFilter.init();
        this.mMaskFilter.onOutputSizeChanged(paramInt1, paramInt2);
      }
      localObject = this.mShapeFilter;
      if (localObject != null)
      {
        ((ShapeFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        this.mShapeFilter = new ShapeFilter();
        this.mShapeFilter.init();
        this.mShapeFilter.onOutputSizeChanged(paramInt1, paramInt2);
      }
      localObject = this.mMaskFBO;
      if (localObject != null)
      {
        LayerRenderBase.releaseRenderBuffer((RenderBuffer)localObject);
        this.mMaskFBO = null;
      }
      this.mMaskFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
  }
  
  public void onSurfaceDestroy()
  {
    Object localObject = this.mMaskFilter;
    if (localObject != null)
    {
      ((MaskFilter)localObject).destroy();
      this.mMaskFilter = null;
    }
    localObject = this.mShapeFilter;
    if (localObject != null)
    {
      ((ShapeFilter)localObject).destroy();
      this.mShapeFilter = null;
    }
    localObject = this.mMaskFBO;
    if (localObject != null)
    {
      LayerRenderBase.releaseRenderBuffer((RenderBuffer)localObject);
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
    ShapeFilter localShapeFilter = this.mShapeFilter;
    if ((localShapeFilter != null) && (this.mMaskFBO != null))
    {
      if (localShapeFilter == null) {
        return paramInt;
      }
      paramRenderBuffer.bind();
      this.mShapeFilter.process(paramInt, this.mMaskFBO.getTexId(), null, null);
      paramRenderBuffer.unbind();
      return paramRenderBuffer.getTexId();
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.ShapeRender
 * JD-Core Version:    0.7.0.1
 */