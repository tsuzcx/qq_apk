package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.filter.DirectionalBlurFilter;
import com.tencent.ttpic.filter.TTNLMeansDenoiseFilterSimple;
import com.tencent.ttpic.filter.TTNLMeansMaskFilter;
import com.tencent.ttpic.filter.TTNLMeansMixFilter;
import java.util.ArrayList;
import java.util.List;

public class TTNLMeansDenoiseFilterGroup
  extends AEChainI
{
  private List<List<PointF>> mAllFacePoints = new ArrayList();
  private Frame mBlurFrame = new Frame();
  private Frame mBlurFrameTemp = new Frame();
  private DirectionalBlurFilter mDirectionalBlurFilter = new DirectionalBlurFilter();
  private boolean mFilterInited = false;
  private Frame mMeanMixFrame = new Frame();
  private TTNLMeansDenoiseFilterSimple mMeansDenoiseFilter = new TTNLMeansDenoiseFilterSimple();
  private TTNLMeansMaskFilter mMeansMaskFilter = new TTNLMeansMaskFilter();
  private Frame mMeansMaskFrame = new Frame();
  private TTNLMeansMixFilter mMeansMixFilter = new TTNLMeansMixFilter();
  private Frame mMeasDenoiseFrame = new Frame();
  private BaseFilter mResizeFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mResizeFrame = new Frame();
  
  private float getResizeScale(int paramInt1, int paramInt2)
  {
    float f = Math.min(paramInt1, paramInt2);
    return Math.min(1.0F, Math.min(720.0F, f) / f);
  }
  
  private Frame render(Frame paramFrame, List<List<PointF>> paramList)
  {
    if (paramList.size() == 0) {
      return paramFrame;
    }
    float f1 = getResizeScale(paramFrame.width, paramFrame.height);
    int j = (int)(paramFrame.width * f1);
    int k = (int)(paramFrame.height * f1);
    this.mResizeFilter.RenderProcess(paramFrame.getTextureId(), j, k, -1, 0.0D, this.mResizeFrame);
    TTNLMeansMaskFilter localTTNLMeansMaskFilter = this.mMeansMaskFilter;
    f1 = j;
    float f2 = k;
    localTTNLMeansMaskFilter.updateSize(f1, f2);
    this.mMeansMaskFilter.updateGlobalAttribute();
    this.mMeansMaskFilter.RenderProcess(this.mResizeFrame.getTextureId(), j, k, -1, 0.0D, this.mMeansMaskFrame);
    int i = 0;
    while (i < paramList.size())
    {
      this.mMeansMaskFilter.updateLeftEyeAttribute((List)paramList.get(i));
      this.mMeansMaskFilter.RenderProcess(this.mResizeFrame.getTextureId(), j, k, -1, 0.0D, this.mMeansMaskFrame);
      this.mMeansMaskFilter.updateRightEyeAttribute((List)paramList.get(i));
      this.mMeansMaskFilter.RenderProcess(this.mResizeFrame.getTextureId(), j, k, -1, 0.0D, this.mMeansMaskFrame);
      i += 1;
    }
    this.mDirectionalBlurFilter.setTexOffset(1.0F / f1, 0.0F);
    this.mDirectionalBlurFilter.RenderProcess(this.mMeansMaskFrame.getTextureId(), j, k, -1, 0.0D, this.mBlurFrameTemp);
    this.mDirectionalBlurFilter.setTexOffset(0.0F, 1.0F / f2);
    this.mDirectionalBlurFilter.RenderProcess(this.mBlurFrameTemp.getTextureId(), j, k, -1, 0.0D, this.mBlurFrame);
    this.mMeansDenoiseFilter.updateSize(f1, f2);
    this.mMeansDenoiseFilter.updateTexture(this.mBlurFrame.getTextureId());
    this.mMeansDenoiseFilter.RenderProcess(this.mResizeFrame.getTextureId(), j, k, -1, 0.0D, this.mMeasDenoiseFrame);
    this.mMeansMixFilter.setMaskTexture(this.mBlurFrame.getTextureId());
    this.mMeansMixFilter.setDenoiseTexture(this.mMeasDenoiseFrame.getTextureId());
    this.mMeansMixFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mMeanMixFrame);
    return this.mMeanMixFrame;
  }
  
  public void ApplyGLSLFilter()
  {
    if (this.mFilterInited) {
      return;
    }
    this.mResizeFilter.apply();
    this.mMeansMaskFilter.ApplyGLSLFilter();
    this.mDirectionalBlurFilter.apply();
    this.mMeansDenoiseFilter.apply();
    this.mMeansMixFilter.apply();
    this.mFilterInited = true;
  }
  
  public void clear()
  {
    this.mResizeFilter.clearGLSL();
    this.mMeansMaskFilter.clearGLSLSelf();
    this.mDirectionalBlurFilter.clearGLSL();
    this.mMeansDenoiseFilter.clearGLSL();
    this.mMeansMixFilter.clearGLSL();
    this.mResizeFrame.clear();
    this.mMeansMaskFrame.clear();
    this.mBlurFrameTemp.clear();
    this.mBlurFrame.clear();
    this.mMeasDenoiseFrame.clear();
    this.mMeanMixFrame.clear();
  }
  
  public Frame render(Frame paramFrame)
  {
    List localList = this.mAllFacePoints;
    Frame localFrame = paramFrame;
    if (localList != null) {
      localFrame = render(paramFrame, localList);
    }
    return localFrame;
  }
  
  public void setAllFacePoints(List<List<PointF>> paramList)
  {
    this.mAllFacePoints = paramList;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mResizeFilter.setRenderMode(paramInt);
    this.mMeansMaskFilter.setRenderMode(paramInt);
    this.mDirectionalBlurFilter.setRenderMode(paramInt);
    this.mMeansDenoiseFilter.setRenderMode(paramInt);
    this.mMeansMixFilter.setRenderMode(paramInt);
  }
  
  public void updateFaceDetSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mMeansMaskFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTNLMeansDenoiseFilterGroup
 * JD-Core Version:    0.7.0.1
 */