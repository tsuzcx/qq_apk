package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class QQImage2FrameFilter
  extends QQBaseFilter
{
  private GPUBaseFilter mBaseFilter;
  private GaussianBlurFilterCompose mGaussianBlurFilter;
  private int mImageHeight;
  private int mImageWidth;
  private float[] mMvpMatirx;
  private RenderBuffer mRenderFBO;
  private RenderBuffer mRollFBO;
  private boolean mRollY = true;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  
  public QQImage2FrameFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(170, paramQQFilterRenderManager);
  }
  
  private void initTexture(int paramInt1, int paramInt2)
  {
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    this.mRenderFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
    this.mBaseFilter = new GPUBaseFilter();
    this.mBaseFilter.init();
    this.mGaussianBlurFilter = new GaussianBlurFilterCompose();
    this.mGaussianBlurFilter.init(paramInt1, paramInt2);
    this.mMvpMatirx = new float[16];
    if (this.mRollY) {
      this.mRollFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
  }
  
  public void onDrawFrame()
  {
    super.onDrawFrame();
    this.mRenderFBO.bind();
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 0.0F);
    GLES20.glClear(16384);
    this.mRenderFBO.unbind();
    float f1 = this.mSurfaceWidth * 1.0F / this.mSurfaceHeight;
    float f2 = this.mImageWidth * 1.0F / this.mImageHeight;
    Matrix.setIdentityM(this.mMvpMatirx, 0);
    if (f2 > f1)
    {
      f1 = this.mSurfaceWidth * 1.0F / this.mImageWidth * this.mImageHeight / this.mSurfaceHeight;
      Matrix.scaleM(this.mMvpMatirx, 0, 1.0F, f1, 1.0F);
    }
    for (;;)
    {
      if (this.mGaussianBlurFilter != null)
      {
        this.mGaussianBlurFilter.drawTexture(this.mInputTextureID);
        this.mOutputTextureID = this.mGaussianBlurFilter.getTextureId();
      }
      this.mRenderFBO.bind();
      this.mBaseFilter.drawTexture(this.mOutputTextureID, null, null);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.75F);
      this.mBaseFilter.drawTexture(this.mInputTextureID, null, this.mMvpMatirx);
      GLES20.glDisable(3042);
      this.mRenderFBO.unbind();
      if (!this.mRollY) {
        break;
      }
      this.mRollFBO.bind();
      this.mBaseFilter.drawTexture(this.mRenderFBO.getTexId(), new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F }, null);
      this.mRollFBO.unbind();
      this.mOutputTextureID = this.mRollFBO.getTexId();
      return;
      f1 = this.mSurfaceHeight * 1.0F / this.mImageHeight * this.mImageWidth / this.mSurfaceWidth;
      Matrix.scaleM(this.mMvpMatirx, 0, f1, 1.0F, 1.0F);
    }
    this.mOutputTextureID = this.mRenderFBO.getTexId();
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    initTexture(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (this.mGaussianBlurFilter != null)
    {
      this.mGaussianBlurFilter.destroy();
      this.mGaussianBlurFilter = null;
    }
    if (this.mRenderFBO != null)
    {
      GlUtil.deleteTexture(this.mRenderFBO.getTexId());
      this.mRenderFBO.destroy();
      this.mRenderFBO = null;
    }
    this.mMvpMatirx = null;
    if (this.mBaseFilter != null)
    {
      this.mBaseFilter.destroy();
      this.mBaseFilter = null;
    }
    if (this.mRollFBO != null)
    {
      GlUtil.deleteTexture(this.mRollFBO.getTexId());
      this.mRollFBO.destroy();
      this.mRollFBO = null;
    }
    this.mImageWidth = 0;
    this.mImageHeight = 0;
    this.mSurfaceWidth = 0;
    this.mSurfaceHeight = 0;
  }
  
  public void setImageSize(int paramInt1, int paramInt2)
  {
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter
 * JD-Core Version:    0.7.0.1
 */