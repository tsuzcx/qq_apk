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
    if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01F)
    {
      if (paramList.size() == 0) {
        return paramFrame;
      }
      int j = paramFrame.height * 360 / paramFrame.width;
      Object localObject1 = this.mBoxFilter;
      float f1 = 360;
      float f2 = j;
      ((BoxFilterWithRadius)localObject1).updateParam(f1, f2);
      localObject1 = this.mBoxFilter.RenderProcess(paramFrame.getTextureId(), 360, j);
      this.mVarianceFilter.setPositions(GlUtil.ORIGIN_POSITION_COORDS);
      this.mVarianceFilter.setTexCords(GlUtil.ORIGIN_TEX_COORDS);
      this.mVarianceFilter.setTexture2(((Frame)localObject1).getTextureId());
      Frame localFrame = FrameBufferCache.getInstance().get(360, j);
      FrameUtil.clearFrame(localFrame, 0.0F, 1.0F, 0.0F, 1.0F, 360, j);
      this.mVarianceFilter.setInFaceRect(1);
      this.mVarianceFilter.setRotation(paramInt3);
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject2 = AlgoUtils.getFaceRectF((List)paramList.get(i));
        if (localObject2 != null)
        {
          float f5;
          float f3;
          float f4;
          if (paramInt3 == 0)
          {
            f5 = ((RectF)localObject2).width();
            f3 = ((RectF)localObject2).height();
            f4 = ((RectF)localObject2).left;
            f5 *= 0.1F;
            ((RectF)localObject2).left = (f4 - f5);
            ((RectF)localObject2).top -= 0.2F * f3;
            ((RectF)localObject2).right += f5;
            ((RectF)localObject2).bottom += f3 * 0.6F;
          }
          else if (paramInt3 == 90)
          {
            f3 = ((RectF)localObject2).width();
            f5 = ((RectF)localObject2).height();
            ((RectF)localObject2).left -= 0.6F * f3;
            f4 = ((RectF)localObject2).top;
            f5 *= 0.1F;
            ((RectF)localObject2).top = (f4 - f5);
            ((RectF)localObject2).right += f3 * 0.2F;
            ((RectF)localObject2).bottom += f5;
          }
          else if (paramInt3 == 180)
          {
            f5 = ((RectF)localObject2).width();
            f3 = ((RectF)localObject2).height();
            f4 = ((RectF)localObject2).left;
            f5 *= 0.1F;
            ((RectF)localObject2).left = (f4 - f5);
            ((RectF)localObject2).top -= 0.6F * f3;
            ((RectF)localObject2).right += f5;
            ((RectF)localObject2).bottom += f3 * 0.2F;
          }
          else
          {
            f3 = ((RectF)localObject2).width();
            f5 = ((RectF)localObject2).height();
            ((RectF)localObject2).left -= 0.2F * f3;
            f4 = ((RectF)localObject2).top;
            f5 *= 0.1F;
            ((RectF)localObject2).top = (f4 - f5);
            ((RectF)localObject2).right += f3 * 0.6F;
            ((RectF)localObject2).bottom += f5;
          }
          localObject2 = AlgoUtils.calPositions(((RectF)localObject2).left, ((RectF)localObject2).top, ((RectF)localObject2).right, ((RectF)localObject2).bottom, paramInt1, paramInt2);
          this.mVarianceFilter.setPositions((float[])localObject2);
          this.mVarianceFilter.OnDrawFrameGLSL();
          this.mVarianceFilter.renderTexture(paramFrame.getTextureId(), 360, j);
        }
        i += 1;
      }
      this.mBoxFilter.updateParam(f1, f2);
      this.mBoxFilter.RenderProcess(localFrame.getTextureId(), 360, j, -1, 0.0D, this.mBoxFrame2);
      if (this.ifDenoise)
      {
        this.mDenoiseFilterSimple.updateSize(paramFrame.width, paramFrame.height);
        this.mDenoiseFilterSimple.updateTextures(((Frame)localObject1).getTextureId(), FrameUtil.getLastRenderFrame(this.mBoxFrame2).getTextureId(), this.mlastBeforeDenoiseFrame.getTextureId());
        paramList = this.mDenoiseFilterSimple.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        paramFrame.unlock();
        this.ifDenoise = false;
        paramFrame = paramList;
      }
      else
      {
        this.mProcessVarianceFilter.updateTextures(((Frame)localObject1).getTextureId(), FrameUtil.getLastRenderFrame(this.mBoxFrame2).getTextureId());
        paramList = this.mProcessVarianceFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        paramFrame.unlock();
        paramFrame = paramList;
      }
      ((Frame)localObject1).unlock();
      localFrame.unlock();
      return paramFrame;
    }
    return paramFrame;
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    SmoothBProcessFilter localSmoothBProcessFilter = this.mProcessVarianceFilter;
    paramFloat *= 0.7F;
    localSmoothBProcessFilter.updateBlurAlpha(paramFloat);
    this.mDenoiseFilterSimple.updateBlurAlpha(paramFloat);
  }
  
  public void updateLastFrameForDenoise(Frame paramFrame)
  {
    this.ifDenoise = true;
    this.mlastBeforeDenoiseFrame = paramFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.SmoothBFilters
 * JD-Core Version:    0.7.0.1
 */