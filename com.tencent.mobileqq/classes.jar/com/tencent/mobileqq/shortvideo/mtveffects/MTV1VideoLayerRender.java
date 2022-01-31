package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class MTV1VideoLayerRender
  extends LayerRenderBase
{
  public static final int MATERIAL_ID_PALETTE_BLUE = 1;
  public static final int MATERIAL_ID_PALETTE_RED = 0;
  private ColoramaFilter mColoramaFilter;
  private int mPaletteID = -1;
  private RenderBuffer mRenderFBO;
  private float[] mShapePoints;
  private ShapeRender mShapeRender = new ShapeRender();
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramInt1, paramInt2);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    this.mShapeRender.onSurfaceChanged(paramInt1, paramInt2);
    if (this.mRenderFBO != null)
    {
      releaseRenderBuffer(this.mRenderFBO);
      this.mRenderFBO = null;
    }
    this.mRenderFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
    if (this.mColoramaFilter != null)
    {
      this.mColoramaFilter.onOutputSizeChanged(paramInt1, paramInt2);
      return;
    }
    this.mColoramaFilter = new ColoramaFilter();
    this.mColoramaFilter.init();
    this.mColoramaFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    this.mShapeRender.onSurfaceDestroy();
    if (this.mRenderFBO != null)
    {
      releaseRenderBuffer(this.mRenderFBO);
      this.mRenderFBO = null;
    }
    if (this.mColoramaFilter != null)
    {
      this.mColoramaFilter.destroy();
      this.mColoramaFilter = null;
    }
    this.mShapePoints = null;
  }
  
  public int process(RenderBuffer paramRenderBuffer, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = paramInt;
    if (this.mPaletteID >= 0)
    {
      i = paramInt;
      if (this.mColoramaFilter != null)
      {
        i = paramInt;
        if (this.mRenderFBO != null)
        {
          clearColorBuffer(this.mRenderFBO, 0);
          RectF localRectF = getMaterialArea(this.mPaletteID);
          i = paramInt;
          if (localRectF != null)
          {
            this.mRenderFBO.bind();
            this.mColoramaFilter.process(paramInt, getMaterialTextureID(), localRectF, localRectF.left, localRectF.width(), 1.0F, paramArrayOfFloat1, paramArrayOfFloat2);
            this.mRenderFBO.unbind();
            i = this.mRenderFBO.getTexId();
          }
        }
      }
    }
    if ((this.mShapePoints != null) && (this.mShapePoints.length > 2)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      int j = i;
      if (paramInt != 0)
      {
        this.mShapeRender.setShapeData(1, this.mShapePoints);
        this.mShapeRender.begin();
        j = this.mShapeRender.shape(paramRenderBuffer, i);
        this.mShapeRender.end();
        this.mShapeRender.setShapeData(0, null);
      }
      return j;
    }
  }
  
  public void updateData(float[] paramArrayOfFloat, int paramInt)
  {
    this.mShapePoints = paramArrayOfFloat;
    this.mPaletteID = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTV1VideoLayerRender
 * JD-Core Version:    0.7.0.1
 */