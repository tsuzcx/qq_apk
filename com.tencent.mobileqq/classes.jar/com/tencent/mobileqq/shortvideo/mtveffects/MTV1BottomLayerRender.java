package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class MTV1BottomLayerRender
  extends LayerRenderBase
{
  private static final float DISTORTION_CENTER_X = 0.5F;
  private static final float DISTORTION_CENTER_Y = 0.5F;
  private static final float DISTORTION_RATE_1 = 1.5F;
  private static final float DISTORTION_RATE_2 = 0.5F;
  private static final float DISTORTION_SCALE = 1.0F;
  public static final int MATERIAL_ID_TEXT = 0;
  private int mBGColor = 0;
  private DistortionFilter mDistortFilter;
  private MaterialFilter mMaterialFilter;
  private RenderBuffer mRenderBuffer;
  private MTVBaseFilter.TextParam mTextParam;
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramInt1, paramInt2);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    if (this.mMaterialFilter != null)
    {
      this.mMaterialFilter.onOutputSizeChanged(paramInt1, paramInt2);
      label31:
      if (this.mDistortFilter == null) {
        break label125;
      }
      this.mDistortFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
    for (;;)
    {
      if (this.mRenderBuffer != null)
      {
        releaseRenderBuffer(this.mRenderBuffer);
        this.mRenderBuffer = null;
      }
      if (this.mRenderBuffer != null) {
        break;
      }
      this.mRenderBuffer = new RenderBuffer(getWidth(), getHeight(), 33984);
      return;
      this.mMaterialFilter = new MaterialFilter();
      this.mMaterialFilter.init();
      this.mMaterialFilter.onOutputSizeChanged(paramInt1, paramInt2);
      break label31;
      label125:
      this.mDistortFilter = new DistortionFilter();
      this.mDistortFilter.init();
      this.mDistortFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (this.mDistortFilter != null)
    {
      this.mDistortFilter.destroy();
      this.mDistortFilter = null;
    }
    if (this.mMaterialFilter != null)
    {
      this.mMaterialFilter.destroy();
      this.mMaterialFilter = null;
    }
    if (this.mRenderBuffer != null)
    {
      releaseRenderBuffer(this.mRenderBuffer);
      this.mRenderBuffer = null;
    }
  }
  
  public int process(RenderBuffer paramRenderBuffer, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    clearColorBuffer(paramRenderBuffer, this.mBGColor);
    if ((this.mMaterialFilter != null) && (this.mTextParam != null) && (this.mTextParam.mShow))
    {
      if (this.mTextParam.mDistortion) {
        break label96;
      }
      paramRenderBuffer.bind();
      this.mMaterialFilter.process(getMaterialTextureID(), getMaterialArea(0), this.mTextParam.mRect, this.mTextParam.mChangeColor, this.mTextParam.mColor, paramArrayOfFloat1, paramArrayOfFloat2);
      paramRenderBuffer.unbind();
    }
    for (;;)
    {
      return paramRenderBuffer.getTexId();
      label96:
      if (this.mRenderBuffer != null)
      {
        clearColorBuffer(this.mRenderBuffer, 0);
        RectF localRectF = new RectF(0.0F, 1.0F, 1.0F, 0.0F);
        this.mRenderBuffer.bind();
        this.mMaterialFilter.process(getMaterialTextureID(), getMaterialArea(0), localRectF, this.mTextParam.mChangeColor, this.mTextParam.mColor, paramArrayOfFloat1, paramArrayOfFloat2);
        this.mRenderBuffer.unbind();
        paramRenderBuffer.bind();
        GLES20.glViewport((int)(getWidth() * this.mTextParam.mRect.left), (int)(this.mTextParam.mRect.bottom * getHeight()), (int)(getWidth() * this.mTextParam.mRect.width()), (int)(getHeight() * (this.mTextParam.mRect.height() * -1.0F)));
        this.mDistortFilter.process(this.mRenderBuffer.getTexId(), 1.5F, 0.5F, 1.0F, 0.5F, 0.5F, paramArrayOfFloat1, paramArrayOfFloat2);
        GLES20.glViewport(0, 0, getWidth(), getHeight());
        paramRenderBuffer.unbind();
      }
    }
  }
  
  public void updateData(int paramInt, MTVBaseFilter.TextParam paramTextParam)
  {
    this.mBGColor = paramInt;
    this.mTextParam = paramTextParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTV1BottomLayerRender
 * JD-Core Version:    0.7.0.1
 */