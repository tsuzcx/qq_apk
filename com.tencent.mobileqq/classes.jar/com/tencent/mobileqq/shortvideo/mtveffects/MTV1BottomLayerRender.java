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
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      Object localObject = this.mMaterialFilter;
      if (localObject != null)
      {
        ((MaterialFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        this.mMaterialFilter = new MaterialFilter();
        this.mMaterialFilter.init();
        this.mMaterialFilter.onOutputSizeChanged(paramInt1, paramInt2);
      }
      localObject = this.mDistortFilter;
      if (localObject != null)
      {
        ((DistortionFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        this.mDistortFilter = new DistortionFilter();
        this.mDistortFilter.init();
        this.mDistortFilter.onOutputSizeChanged(paramInt1, paramInt2);
      }
      localObject = this.mRenderBuffer;
      if (localObject != null)
      {
        releaseRenderBuffer((RenderBuffer)localObject);
        this.mRenderBuffer = null;
      }
      if (this.mRenderBuffer == null) {
        this.mRenderBuffer = new RenderBuffer(getWidth(), getHeight(), 33984);
      }
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    Object localObject = this.mDistortFilter;
    if (localObject != null)
    {
      ((DistortionFilter)localObject).destroy();
      this.mDistortFilter = null;
    }
    localObject = this.mMaterialFilter;
    if (localObject != null)
    {
      ((MaterialFilter)localObject).destroy();
      this.mMaterialFilter = null;
    }
    localObject = this.mRenderBuffer;
    if (localObject != null)
    {
      releaseRenderBuffer((RenderBuffer)localObject);
      this.mRenderBuffer = null;
    }
  }
  
  public int process(RenderBuffer paramRenderBuffer, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    clearColorBuffer(paramRenderBuffer, this.mBGColor);
    if (this.mMaterialFilter != null)
    {
      Object localObject = this.mTextParam;
      if ((localObject != null) && (((MTVBaseFilter.TextParam)localObject).mShow)) {
        if (!this.mTextParam.mDistortion)
        {
          paramRenderBuffer.bind();
          this.mMaterialFilter.process(getMaterialTextureID(), getMaterialArea(0), this.mTextParam.mRect, this.mTextParam.mChangeColor, this.mTextParam.mColor, paramArrayOfFloat1, paramArrayOfFloat2);
          paramRenderBuffer.unbind();
        }
        else
        {
          localObject = this.mRenderBuffer;
          if (localObject != null)
          {
            clearColorBuffer((RenderBuffer)localObject, 0);
            localObject = new RectF(0.0F, 1.0F, 1.0F, 0.0F);
            this.mRenderBuffer.bind();
            this.mMaterialFilter.process(getMaterialTextureID(), getMaterialArea(0), (RectF)localObject, this.mTextParam.mChangeColor, this.mTextParam.mColor, paramArrayOfFloat1, paramArrayOfFloat2);
            this.mRenderBuffer.unbind();
            paramRenderBuffer.bind();
            GLES20.glViewport((int)(getWidth() * this.mTextParam.mRect.left), (int)(this.mTextParam.mRect.bottom * getHeight()), (int)(getWidth() * this.mTextParam.mRect.width()), (int)(getHeight() * (this.mTextParam.mRect.height() * -1.0F)));
            this.mDistortFilter.process(this.mRenderBuffer.getTexId(), 1.5F, 0.5F, 1.0F, 0.5F, 0.5F, paramArrayOfFloat1, paramArrayOfFloat2);
            GLES20.glViewport(0, 0, getWidth(), getHeight());
            paramRenderBuffer.unbind();
          }
        }
      }
    }
    return paramRenderBuffer.getTexId();
  }
  
  public void updateData(int paramInt, MTVBaseFilter.TextParam paramTextParam)
  {
    this.mBGColor = paramInt;
    this.mTextParam = paramTextParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTV1BottomLayerRender
 * JD-Core Version:    0.7.0.1
 */