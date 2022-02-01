package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.filter.BoxFilterWithRadius;
import com.tencent.ttpic.filter.PreviewDenoiseFilterSimple;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.util.List;

public class SmoothBFilters
{
  private boolean ifDenoise = false;
  private BoxFilterWithRadius mBoxFilter = new BoxFilterWithRadius();
  private Frame mBoxFrame2 = new Frame();
  private PreviewDenoiseFilterSimple mDenoiseFilterSimple = new PreviewDenoiseFilterSimple();
  private SmoothBProcessFilter mProcessVarianceFilter = new SmoothBProcessFilter();
  private SmoothBVarianceFilter mVarianceFilter = new SmoothBVarianceFilter();
  private Frame mlastBeforeDenoiseFrame = new Frame();
  
  public void clear()
  {
    this.mVarianceFilter.clearGLSLSelf();
    this.mBoxFilter.clearGLSL();
    this.mProcessVarianceFilter.clearGLSLSelf();
    this.mDenoiseFilterSimple.clearGLSLSelf();
    this.mBoxFrame2.clear();
  }
  
  public Frame getVarianceFrame()
  {
    return this.mBoxFrame2;
  }
  
  public void initial()
  {
    this.mVarianceFilter.apply();
    this.mBoxFilter.applyFilterChain(true, 0.0F, 0.0F);
    this.mProcessVarianceFilter.apply();
    this.mDenoiseFilterSimple.apply();
  }
  
  public void setRenderMode(int paramInt)
  {
    VideoFilterUtil.setRenderMode(this.mVarianceFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mBoxFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mProcessVarianceFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mDenoiseFilterSimple, paramInt);
  }
  
  public Frame updateAndRender(Frame paramFrame, List<List<PointF>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mProcessVarianceFilter.getBlurAlpha() <= 0.01F) || (paramList.size() == 0)) {
      return paramFrame;
    }
    int j = paramFrame.height * 360 / paramFrame.width;
    this.mBoxFilter.updateParam(360, j);
    Frame localFrame1 = this.mBoxFilter.RenderProcess(paramFrame.getTextureId(), 360, j);
    this.mVarianceFilter.setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    this.mVarianceFilter.setTexCords(GlUtil.ORIGIN_TEX_COORDS);
    this.mVarianceFilter.setTexture2(localFrame1.getTextureId());
    Frame localFrame2 = FrameBufferCache.getInstance().get(360, j);
    FrameUtil.clearFrame(localFrame2, 0.0F, 1.0F, 0.0F, 1.0F, 360, j);
    this.mVarianceFilter.setInFaceRect(1);
    this.mVarianceFilter.setRotation(paramInt3);
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = AlgoUtils.getFaceRectF((List)paramList.get(i));
      float f1;
      float f2;
      if (localObject != null)
      {
        if (paramInt3 != 0) {
          break label338;
        }
        f1 = ((RectF)localObject).width();
        f2 = ((RectF)localObject).height();
        ((RectF)localObject).left -= 0.1F * f1;
        ((RectF)localObject).top -= 0.2F * f2;
        ((RectF)localObject).right = (f1 * 0.1F + ((RectF)localObject).right);
        ((RectF)localObject).bottom += f2 * 0.6F;
      }
      for (;;)
      {
        localObject = AlgoUtils.calPositions(((RectF)localObject).left, ((RectF)localObject).top, ((RectF)localObject).right, ((RectF)localObject).bottom, paramInt1, paramInt2);
        this.mVarianceFilter.setPositions((float[])localObject);
        this.mVarianceFilter.OnDrawFrameGLSL();
        this.mVarianceFilter.renderTexture(paramFrame.getTextureId(), 360, j);
        i += 1;
        break;
        label338:
        if (paramInt3 == 90)
        {
          f1 = ((RectF)localObject).width();
          f2 = ((RectF)localObject).height();
          ((RectF)localObject).left -= 0.6F * f1;
          ((RectF)localObject).top -= 0.1F * f2;
          ((RectF)localObject).right = (f1 * 0.2F + ((RectF)localObject).right);
          ((RectF)localObject).bottom += f2 * 0.1F;
        }
        else if (paramInt3 == 180)
        {
          f1 = ((RectF)localObject).width();
          f2 = ((RectF)localObject).height();
          ((RectF)localObject).left -= 0.1F * f1;
          ((RectF)localObject).top -= 0.6F * f2;
          ((RectF)localObject).right = (f1 * 0.1F + ((RectF)localObject).right);
          ((RectF)localObject).bottom += f2 * 0.2F;
        }
        else
        {
          f1 = ((RectF)localObject).width();
          f2 = ((RectF)localObject).height();
          ((RectF)localObject).left -= 0.2F * f1;
          ((RectF)localObject).top -= 0.1F * f2;
          ((RectF)localObject).right = (f1 * 0.6F + ((RectF)localObject).right);
          ((RectF)localObject).bottom += f2 * 0.1F;
        }
      }
    }
    this.mBoxFilter.updateParam(360, j);
    this.mBoxFilter.RenderProcess(localFrame2.getTextureId(), 360, j, -1, 0.0D, this.mBoxFrame2);
    if (this.ifDenoise)
    {
      this.mDenoiseFilterSimple.updateSize(paramFrame.width, paramFrame.height);
      this.mDenoiseFilterSimple.updateTextures(localFrame1.getTextureId(), FrameUtil.getLastRenderFrame(this.mBoxFrame2).getTextureId(), this.mlastBeforeDenoiseFrame.getTextureId());
      paramList = this.mDenoiseFilterSimple.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      paramFrame.unlock();
      this.ifDenoise = false;
    }
    for (paramFrame = paramList;; paramFrame = paramList)
    {
      localFrame1.unlock();
      localFrame2.unlock();
      return paramFrame;
      this.mProcessVarianceFilter.updateTextures(localFrame1.getTextureId(), FrameUtil.getLastRenderFrame(this.mBoxFrame2).getTextureId());
      paramList = this.mProcessVarianceFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      paramFrame.unlock();
    }
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    this.mProcessVarianceFilter.updateBlurAlpha(0.7F * paramFloat);
    this.mDenoiseFilterSimple.updateBlurAlpha(0.7F * paramFloat);
  }
  
  public void updateLastFrameForDenoise(Frame paramFrame)
  {
    this.ifDenoise = true;
    this.mlastBeforeDenoiseFrame = paramFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.SmoothBFilters
 * JD-Core Version:    0.7.0.1
 */