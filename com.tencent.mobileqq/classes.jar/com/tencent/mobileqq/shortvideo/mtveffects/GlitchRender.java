package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class GlitchRender
{
  private static final String TAG = "GlitchRender";
  private int mDisColorH = -1;
  private int mDisColorV = -1;
  private GlitchFilter mGlitchFiler;
  private MaterialFilter mMaterialFilter;
  private float mMaxDisH = 0.5F;
  private float mMaxDisV = 0.5F;
  private RectF mRcSrc = null;
  private RenderBuffer mRenderFBO;
  private RenderBuffer mRenderFBO2;
  private ScaleFilter mScaleFilter;
  
  public boolean init(RectF paramRectF, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2)
  {
    this.mDisColorH = paramInt1;
    this.mDisColorV = paramInt2;
    this.mMaxDisH = paramFloat1;
    this.mMaxDisV = paramFloat2;
    this.mRcSrc = paramRectF;
    paramRectF = new int[1];
    GLES20.glGetIntegerv(35660, paramRectF, 0);
    return paramRectF[0] > 0;
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      Object localObject = this.mGlitchFiler;
      if (localObject != null)
      {
        ((GlitchFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        localObject = this.mRcSrc;
        if (localObject != null)
        {
          this.mGlitchFiler = new GlitchFilter((RectF)localObject);
          this.mGlitchFiler.init();
          this.mGlitchFiler.onOutputSizeChanged(paramInt1, paramInt2);
        }
        else
        {
          this.mGlitchFiler = null;
        }
      }
      localObject = this.mScaleFilter;
      if (localObject != null)
      {
        ((ScaleFilter)localObject).onOutputSizeChanged(paramInt1, paramInt2);
      }
      else
      {
        this.mScaleFilter = new ScaleFilter();
        this.mScaleFilter.init();
        this.mScaleFilter.onOutputSizeChanged(paramInt1, paramInt2);
      }
      localObject = this.mMaterialFilter;
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
      localObject = this.mRenderFBO;
      if ((localObject == null) || (((RenderBuffer)localObject).getWidth() != paramInt1) || (this.mRenderFBO.getHeight() != paramInt2))
      {
        localObject = this.mRenderFBO;
        if (localObject != null)
        {
          if (((RenderBuffer)localObject).getTexId() >= 0) {
            GlUtil.deleteTexture(this.mRenderFBO.getTexId());
          }
          this.mRenderFBO.destroy();
          this.mRenderFBO = null;
        }
        this.mRenderFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
      }
      localObject = this.mRenderFBO2;
      if ((localObject == null) || (((RenderBuffer)localObject).getWidth() != paramInt1) || (this.mRenderFBO2.getHeight() != paramInt2))
      {
        localObject = this.mRenderFBO2;
        if (localObject != null)
        {
          if (((RenderBuffer)localObject).getTexId() >= 0) {
            GlUtil.deleteTexture(this.mRenderFBO2.getTexId());
          }
          this.mRenderFBO2.destroy();
          this.mRenderFBO2 = null;
        }
        this.mRenderFBO2 = new RenderBuffer(paramInt1, paramInt2, 33984);
      }
    }
  }
  
  public void onSurfaceDestroy()
  {
    Object localObject = this.mGlitchFiler;
    if (localObject != null)
    {
      ((GlitchFilter)localObject).destroy();
      this.mGlitchFiler = null;
    }
    localObject = this.mScaleFilter;
    if (localObject != null)
    {
      ((ScaleFilter)localObject).destroy();
      this.mScaleFilter = null;
    }
    localObject = this.mMaterialFilter;
    if (localObject != null)
    {
      ((MaterialFilter)localObject).destroy();
      this.mMaterialFilter = null;
    }
    LayerRenderBase.releaseRenderBuffer(this.mRenderFBO);
    LayerRenderBase.releaseRenderBuffer(this.mRenderFBO2);
  }
  
  public int process(RenderBuffer paramRenderBuffer, int paramInt1, int paramInt2, RectF paramRectF, boolean paramBoolean, int paramInt3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramInt2 >= 0) && (paramRenderBuffer != null) && (this.mRcSrc != null))
    {
      if (paramRectF == null) {
        return -1;
      }
      long l1 = System.currentTimeMillis();
      int j = 0;
      if ((paramInt1 >= 0) && (this.mGlitchFiler != null))
      {
        LayerRenderBase.clearColorBuffer(this.mRenderFBO, 0);
        this.mRenderFBO.bind();
        this.mGlitchFiler.updateData(this.mDisColorH, this.mMaxDisH, paramRectF.left - this.mRcSrc.left, this.mDisColorV, this.mMaxDisV, paramRectF.top - this.mRcSrc.top);
        this.mGlitchFiler.process(paramInt1, paramInt2, paramBoolean, paramInt3, true);
        this.mRenderFBO.unbind();
        paramInt1 = this.mRenderFBO.getTexId();
        paramInt2 = 1;
      }
      else
      {
        paramInt1 = paramInt2;
        paramInt2 = 0;
      }
      long l2 = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("glitch time:");
      ((StringBuilder)localObject).append(l2 - l1);
      Log.d("GlitchRender", ((StringBuilder)localObject).toString());
      l1 = System.currentTimeMillis();
      int i;
      if (((paramRectF.width() != this.mRcSrc.width()) || (paramRectF.height() != this.mRcSrc.height())) && (this.mScaleFilter != null))
      {
        LayerRenderBase.clearColorBuffer(this.mRenderFBO2, 0);
        this.mRenderFBO2.bind();
        float f1;
        if (paramInt2 != 0) {
          f1 = paramRectF.left;
        } else {
          f1 = this.mRcSrc.left;
        }
        float f2;
        if (paramInt2 != 0) {
          f2 = paramRectF.top;
        } else {
          f2 = this.mRcSrc.top;
        }
        this.mScaleFilter.process(paramInt1, f1, f2, paramRectF.width() / this.mRcSrc.width(), paramArrayOfFloat1, paramArrayOfFloat2);
        this.mRenderFBO2.unbind();
        paramInt1 = this.mRenderFBO2.getTexId();
        i = 1;
      }
      else
      {
        i = 0;
      }
      l2 = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sclae time:");
      ((StringBuilder)localObject).append(l2 - l1);
      Log.d("GlitchRender", ((StringBuilder)localObject).toString());
      l1 = System.currentTimeMillis();
      if (this.mMaterialFilter != null)
      {
        if (paramInt2 != 0)
        {
          localObject = new RectF(0.0F, 1.0F, 1.0F, 0.0F);
          paramInt2 = 1;
        }
        else
        {
          if (i != 0) {
            localObject = new RectF(this.mRcSrc.left, this.mRcSrc.top, this.mRcSrc.left + paramRectF.width(), this.mRcSrc.top + paramRectF.height());
          } else {
            localObject = this.mRcSrc;
          }
          paramInt2 = j;
        }
        paramRenderBuffer.bind();
        MaterialFilter localMaterialFilter = this.mMaterialFilter;
        if (paramInt2 != 0) {
          paramRectF = (RectF)localObject;
        }
        localMaterialFilter.process(paramInt1, (RectF)localObject, paramRectF, paramBoolean, paramInt3, paramArrayOfFloat1, paramArrayOfFloat2);
        paramRenderBuffer.unbind();
        l2 = System.currentTimeMillis();
        paramRectF = new StringBuilder();
        paramRectF.append("final time:");
        paramRectF.append(l2 - l1);
        Log.d("GlitchRender", paramRectF.toString());
        return paramRenderBuffer.getTexId();
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.GlitchRender
 * JD-Core Version:    0.7.0.1
 */