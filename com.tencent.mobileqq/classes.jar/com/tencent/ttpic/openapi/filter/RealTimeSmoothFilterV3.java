package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.filter.RealTimeBilateralFilterV3;
import com.tencent.ttpic.filter.RealTimeProcessVarianceFilterAndDenoiseV3;
import com.tencent.ttpic.filter.RealTimeProcessVarianceFilterV3;
import com.tencent.ttpic.filter.RealTimeSmoothSharpenFilterV3;
import com.tencent.ttpic.filter.RealTimeVarianceFilterV3;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.util.List;

public class RealTimeSmoothFilterV3
  implements InterfaceRealTimeSmoothFilter
{
  private static final String TAG = "RealTimeSmoothFilterV3";
  private float alphaValue;
  private float femalePercent = 1.0F;
  private boolean ifDenoise = false;
  private RealTimeSmoothSharpenFilterV3 mBgSharpenFilter = new RealTimeSmoothSharpenFilterV3();
  private RealTimeBilateralFilterV3 mBilaterialFilter = new RealTimeBilateralFilterV3();
  private Frame mBoxFrame1 = new Frame();
  private Frame mBoxFrame2 = new Frame();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private RealTimeProcessVarianceFilterV3 mProcessVarianceFilter = new RealTimeProcessVarianceFilterV3();
  private RealTimeProcessVarianceFilterAndDenoiseV3 mProcessVarianceFilterDenoise = new RealTimeProcessVarianceFilterAndDenoiseV3();
  private RealTimeVarianceFilterV3 mVarianceFilter = new RealTimeVarianceFilterV3();
  private Frame mVarianceFrame1 = new Frame();
  private float malePercent = 1.0F;
  private Frame mlastBeforeDenoiseFrame = new Frame();
  
  private Frame renderSmoothMulti(Frame paramFrame)
  {
    int i = paramFrame.height * 360 / paramFrame.width;
    Object localObject = GlUtil.ORIGIN_POSITION_COORDS;
    this.mBilaterialFilter.updateParam(360, i);
    this.mBilaterialFilter.RenderProcess(paramFrame.getTextureId(), 360, i, -1, 0.0D, this.mBoxFrame1);
    FrameUtil.clearFrame(this.mVarianceFrame1, 0.0F, 0.0F, 0.0F, 1.0F, 360, i);
    this.mVarianceFilter.setPositions((float[])localObject);
    this.mVarianceFilter.setTexCords(GlUtil.ORIGIN_TEX_COORDS);
    this.mVarianceFilter.setTexture2(this.mBoxFrame1.getLastRenderTextureId());
    this.mVarianceFilter.setSkinAlpha(1.0F);
    this.mVarianceFilter.RenderProcess(paramFrame.getTextureId(), 360, i, -1, 0.0D, this.mVarianceFrame1);
    this.mBilaterialFilter.updateParam(360, i);
    this.mBilaterialFilter.RenderProcess(this.mVarianceFrame1.getTextureId(), 360, i, -1, 0.0D, this.mBoxFrame2);
    if (this.ifDenoise)
    {
      this.mProcessVarianceFilterDenoise.setTexture2(this.mBoxFrame1.getLastRenderTextureId());
      this.mProcessVarianceFilterDenoise.setTexture3(this.mBoxFrame2.getLastRenderTextureId());
      this.mProcessVarianceFilterDenoise.setDenoiseTexture(this.mlastBeforeDenoiseFrame.getTextureId());
    }
    for (localObject = this.mProcessVarianceFilterDenoise.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);; localObject = this.mProcessVarianceFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height))
    {
      paramFrame.unlock();
      this.ifDenoise = false;
      this.mBgSharpenFilter.setVarianceMask(this.mBoxFrame2.getLastRenderTextureId());
      paramFrame = this.mBgSharpenFilter.RenderProcess(((Frame)localObject).getTextureId(), ((Frame)localObject).width, ((Frame)localObject).height);
      ((Frame)localObject).unlock();
      return paramFrame;
      this.mProcessVarianceFilter.setTexture2(this.mBoxFrame1.getLastRenderTextureId());
      this.mProcessVarianceFilter.setTexture3(this.mBoxFrame2.getLastRenderTextureId());
    }
  }
  
  private Frame renderSmoothSingle(Frame paramFrame, List<List<PointF>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramFrame.height * 360 / paramFrame.width;
    paramList = AlgoUtils.getFaceRectF((List)paramList.get(0));
    if (paramList == null) {
      return paramFrame;
    }
    float f1;
    float f2;
    if (paramInt3 == 0)
    {
      f1 = paramList.width();
      f2 = paramList.height();
      paramList.left -= 0.1F * f1;
      paramList.top -= 0.1F * f2;
      paramList.right = (f1 * 0.1F + paramList.right);
      paramList.bottom += f2 * 0.5F;
      float[] arrayOfFloat = AlgoUtils.calPositions(paramList.left, paramList.top, paramList.right, paramList.bottom, paramInt1, paramInt2);
      f1 = Math.min(0.16F, paramList.width() * paramList.height() / paramInt1 / paramInt2) / 0.16F;
      this.mBilaterialFilter.updateParam(360, i);
      this.mBilaterialFilter.RenderProcess(paramFrame.getTextureId(), 360, i, -1, 0.0D, this.mBoxFrame1);
      FrameUtil.clearFrame(this.mVarianceFrame1, 0.0F, 0.0F, 0.0F, 1.0F, 360, i);
      this.mVarianceFilter.setPositions(arrayOfFloat);
      this.mVarianceFilter.setTexCords(GlUtil.ORIGIN_TEX_COORDS);
      this.mVarianceFilter.setTexture2(this.mBoxFrame1.getLastRenderTextureId());
      this.mVarianceFilter.setSkinAlpha(f1);
      this.mVarianceFilter.RenderProcess(paramFrame.getTextureId(), 360, i, -1, 0.0D, this.mVarianceFrame1);
      this.mBilaterialFilter.updateParam(360, i);
      this.mBilaterialFilter.RenderProcess(this.mVarianceFrame1.getTextureId(), 360, i, -1, 0.0D, this.mBoxFrame2);
      if (!this.ifDenoise) {
        break label663;
      }
      this.mProcessVarianceFilterDenoise.setTexture2(this.mBoxFrame1.getLastRenderTextureId());
      this.mProcessVarianceFilterDenoise.setTexture3(this.mBoxFrame2.getLastRenderTextureId());
      this.mProcessVarianceFilterDenoise.setDenoiseTexture(this.mlastBeforeDenoiseFrame.getTextureId());
    }
    for (paramList = this.mProcessVarianceFilterDenoise.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);; paramList = this.mProcessVarianceFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height))
    {
      paramFrame.unlock();
      this.ifDenoise = false;
      this.mBgSharpenFilter.setVarianceMask(this.mBoxFrame2.getLastRenderTextureId());
      paramFrame = this.mBgSharpenFilter.RenderProcess(paramList.getTextureId(), paramList.width, paramList.height);
      paramList.unlock();
      return paramFrame;
      if (paramInt3 == 90)
      {
        f1 = paramList.width();
        f2 = paramList.height();
        paramList.left -= 0.5F * f1;
        paramList.top -= 0.1F * f2;
        paramList.right = (f1 * 0.1F + paramList.right);
        paramList.bottom += f2 * 0.1F;
        break;
      }
      if (paramInt3 == 180)
      {
        f1 = paramList.width();
        f2 = paramList.height();
        paramList.left -= 0.1F * f1;
        paramList.top -= 0.5F * f2;
        paramList.right = (f1 * 0.1F + paramList.right);
        paramList.bottom += f2 * 0.1F;
        break;
      }
      f1 = paramList.width();
      f2 = paramList.height();
      paramList.left -= 0.1F * f1;
      paramList.top -= 0.1F * f2;
      paramList.right = (f1 * 0.5F + paramList.right);
      paramList.bottom += f2 * 0.1F;
      break;
      label663:
      this.mProcessVarianceFilter.setTexture2(this.mBoxFrame1.getLastRenderTextureId());
      this.mProcessVarianceFilter.setTexture3(this.mBoxFrame2.getLastRenderTextureId());
    }
  }
  
  public void clear()
  {
    this.mVarianceFilter.clearGLSLSelf();
    this.mBgSharpenFilter.ClearGLSL();
    this.mBilaterialFilter.ClearGLSL();
    this.mProcessVarianceFilter.clearGLSLSelf();
    this.mProcessVarianceFilterDenoise.clearGLSLSelf();
    this.mCopyFilter.ClearGLSL();
    this.mBoxFrame1.clear();
    this.mBoxFrame2.clear();
    this.mVarianceFrame1.clear();
  }
  
  public void initial()
  {
    this.mVarianceFilter.apply();
    this.mBgSharpenFilter.apply();
    this.mBilaterialFilter.applyFilterChain(true, 0.0F, 0.0F);
    this.mProcessVarianceFilter.apply();
    this.mProcessVarianceFilterDenoise.apply();
    this.mCopyFilter.apply();
  }
  
  public void setRenderMode(int paramInt)
  {
    VideoFilterUtil.setRenderMode(this.mVarianceFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mBgSharpenFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mBilaterialFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mProcessVarianceFilter, paramInt);
    VideoFilterUtil.setRenderMode(this.mProcessVarianceFilterDenoise, paramInt);
    VideoFilterUtil.setRenderMode(this.mCopyFilter, paramInt);
  }
  
  public void setSharpenFactor(float paramFloat)
  {
    this.mBgSharpenFilter.setSharpenFactor(paramFloat);
  }
  
  public void setSharpenSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mProcessVarianceFilter.setSize(paramInt1, paramInt2);
      this.mProcessVarianceFilterDenoise.setSize(paramInt1, paramInt2);
      this.mBgSharpenFilter.setStepSize(1.0F / paramInt1, 1.0F / paramInt2);
    }
  }
  
  public Frame updateAndRender(Frame paramFrame, PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramFrame.width <= 0) || (paramFrame.height <= 0)) {
      return paramFrame;
    }
    List localList = paramPTFaceAttr.getAllFacePoints();
    if (localList.size() == 1)
    {
      int i = ((FaceStatus)paramPTFaceAttr.getFaceStatusList().get(0)).gender;
      if ((i == 2) || (i == 0)) {
        updateBlurAlphaValue(this.alphaValue * this.malePercent);
      }
      for (;;)
      {
        return renderSmoothSingle(paramFrame, localList, paramInt1, paramInt2, paramInt3);
        updateBlurAlphaValue(this.alphaValue * this.femalePercent);
      }
    }
    updateBlurAlphaValue(this.alphaValue * this.femalePercent);
    return renderSmoothMulti(paramFrame);
  }
  
  public Frame updateAndRender(Frame paramFrame, List<List<PointF>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramFrame.width <= 0) || (paramFrame.height <= 0)) {
      return paramFrame;
    }
    if (paramList.size() == 1)
    {
      updateBlurAlphaValue(this.alphaValue * this.malePercent);
      return renderSmoothSingle(paramFrame, paramList, paramInt1, paramInt2, paramInt3);
    }
    updateBlurAlphaValue(this.alphaValue * this.femalePercent);
    return renderSmoothMulti(paramFrame);
  }
  
  public void updateBlurAlpha(float paramFloat)
  {
    this.alphaValue = paramFloat;
  }
  
  public void updateBlurAlphaValue(float paramFloat)
  {
    this.mProcessVarianceFilter.setBlendAlpha(paramFloat);
    this.mProcessVarianceFilterDenoise.setBlendAlpha(paramFloat);
  }
  
  public void updateFemalePercent(float paramFloat)
  {
    this.femalePercent = paramFloat;
  }
  
  public void updateLastFrameForDenoise(Frame paramFrame)
  {
    this.ifDenoise = true;
    this.mlastBeforeDenoiseFrame = paramFrame;
  }
  
  public void updateMalePercent(float paramFloat)
  {
    this.malePercent = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.RealTimeSmoothFilterV3
 * JD-Core Version:    0.7.0.1
 */