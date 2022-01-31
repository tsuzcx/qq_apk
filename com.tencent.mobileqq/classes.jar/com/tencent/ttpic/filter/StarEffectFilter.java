package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StarEffectFilter
{
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private StarDrawMaskFilter mDrawFilter = new StarDrawMaskFilter();
  private Frame mDrawFrame1 = new Frame();
  private Frame mDrawFrame2 = new Frame();
  private Frame mDrawFrame3 = new Frame();
  private Frame mDrawFrame4 = new Frame();
  private Frame mDrawFrameTemp1 = new Frame();
  private Frame mDrawFrameTemp2 = new Frame();
  private Frame mDrawFrameTemp3 = new Frame();
  private Frame mDrawFrameTemp4 = new Frame();
  private StarGaussianBlurFilter mGaussianBlurFilter = new StarGaussianBlurFilter();
  private Frame mGaussianSrcFrame = new Frame();
  private Frame mGaussianThreshFrame = new Frame();
  private StarOverlayFilter mOverlayFilter = new StarOverlayFilter();
  private Frame mResizeFrame = new Frame();
  private int[] mStarColorTex = new int[1];
  private Bitmap mStarMaskBitmap;
  private String mStarMaterialId = "";
  private long mStartTime = -1L;
  private StarThreshFilter mThreshFilter = new StarThreshFilter();
  private StarThreshFilterForMask mThreshFilterForMask = new StarThreshFilterForMask();
  private Frame mThreshFrame = new Frame();
  private Frame mThreshResizeFrame = new Frame();
  private Frame result1 = new Frame();
  private Frame result2 = new Frame();
  private Frame result3 = new Frame();
  private Frame resultRotateFrame = new Frame();
  
  private float getCurrentScale(long paramLong, StarParam paramStarParam)
  {
    if (paramStarParam.starBlurScalePeriod <= 0L) {
      return 1.0F;
    }
    paramLong = (paramLong - this.mStartTime) % paramStarParam.starBlurScalePeriod;
    if (paramLong < paramStarParam.starBlurScalePeriod / 2L)
    {
      f = (paramStarParam.starBlurMinScale - paramStarParam.starBlurMaxScale) / (float)(paramStarParam.starBlurScalePeriod / 2L);
      return (float)paramLong * f + paramStarParam.starBlurMaxScale;
    }
    float f = (paramStarParam.starBlurMaxScale - paramStarParam.starBlurMinScale) / (float)(paramStarParam.starBlurScalePeriod / 2L);
    return (float)paramLong * f + (2.0F * paramStarParam.starBlurMinScale - paramStarParam.starBlurMaxScale);
  }
  
  private float getFilterThreshold(StarParam paramStarParam)
  {
    return Math.min(1.0F, Math.max(0.0F, (paramStarParam.starMinThreshold - paramStarParam.starMaxThreshold) * paramStarParam.starStrength + paramStarParam.starMaxThreshold));
  }
  
  private int getStarPointsNum(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      return Math.max(10, Math.min(40, (int)(30.0F * paramFloat + 10.0F)));
    }
    return 0;
  }
  
  public void clear()
  {
    this.mGaussianBlurFilter.ClearGLSL();
    this.mThreshFilter.ClearGLSL();
    this.mThreshFilterForMask.ClearGLSL();
    this.mDrawFilter.ClearGLSL();
    this.mOverlayFilter.ClearGLSL();
    this.mCopyFilter.ClearGLSL();
    this.mResizeFrame.clear();
    this.mGaussianSrcFrame.clear();
    this.mThreshFrame.clear();
    this.mThreshResizeFrame.clear();
    this.mGaussianThreshFrame.clear();
    this.mDrawFrameTemp1.clear();
    this.mDrawFrame1.clear();
    this.mDrawFrameTemp2.clear();
    this.mDrawFrame2.clear();
    this.mDrawFrameTemp3.clear();
    this.mDrawFrame3.clear();
    this.mDrawFrameTemp4.clear();
    this.mDrawFrame4.clear();
    this.result1.clear();
    this.result2.clear();
    this.result3.clear();
    this.resultRotateFrame.clear();
    GLES20.glDeleteTextures(this.mStarColorTex.length, this.mStarColorTex, 0);
    BitmapUtils.recycle(this.mStarMaskBitmap);
    this.mStarMaskBitmap = null;
  }
  
  public Frame getMaskFrame(Frame paramFrame, StarParam paramStarParam, int paramInt)
  {
    if ((paramFrame.width * paramFrame.height == 0) || (!VideoMaterialUtil.needRenderStar(paramStarParam))) {
      return null;
    }
    long l = System.currentTimeMillis();
    if (this.mStartTime < 0L) {
      this.mStartTime = l;
    }
    float f = getCurrentScale(l, paramStarParam);
    int i;
    if ((paramInt == 90) || (paramInt == 270))
    {
      i = 1;
      if (paramInt == 0) {
        break label1009;
      }
    }
    label1009:
    for (int j = 1;; j = 0)
    {
      int k = 180;
      int m = paramFrame.height * 180 / paramFrame.width;
      if (i != 0)
      {
        m = 180;
        k = paramFrame.width * 180 / paramFrame.height;
      }
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), k, m, -1, 0.0D, this.mResizeFrame);
      this.mGaussianBlurFilter.updateTexelSize(0.5F / k, 0.5F / m);
      this.mGaussianBlurFilter.RenderProcess(this.mResizeFrame.getTextureId(), k, m, -1, 0.0D, this.mGaussianSrcFrame);
      this.mThreshFilterForMask.setTexture2(this.mGaussianSrcFrame.getLastRenderTextureId());
      this.mThreshFilterForMask.setThreshold(getFilterThreshold(paramStarParam));
      this.mThreshFilterForMask.updatePattern();
      if ((!TextUtils.isEmpty(paramStarParam.materialId)) && (!paramStarParam.materialId.equals(this.mStarMaterialId)))
      {
        this.mStarMaterialId = paramStarParam.materialId;
        if (BitmapUtils.isLegal(paramStarParam.starBlurColorImage))
        {
          GlUtil.loadTexture(this.mStarColorTex[0], paramStarParam.starBlurColorImage);
          this.mThreshFilterForMask.setColorTex(this.mStarColorTex[0], paramStarParam.starBlurColorImage.getWidth());
        }
      }
      this.mThreshFilterForMask.RenderProcess(this.mResizeFrame.getTextureId(), k, m, -1, 0.0D, this.mThreshFrame);
      this.mGaussianBlurFilter.updateTexelSize(0.15F / k, 0.15F / m);
      this.mGaussianBlurFilter.RenderProcess(this.mThreshFrame.getTextureId(), k, m, -1, 0.0D, this.mGaussianThreshFrame);
      this.mDrawFilter.setScale(f);
      this.mDrawFilter.setTexSize(k, m);
      this.mDrawFilter.setIteration(1);
      this.mDrawFilter.setDirection(1.5F, 1.5F);
      this.mDrawFilter.RenderProcess(this.mGaussianThreshFrame.getLastRenderTextureId(), k, m, -1, 0.0D, this.mDrawFrameTemp1);
      this.mDrawFilter.setTexSize(k, m);
      this.mDrawFilter.setIteration(0);
      this.mDrawFilter.setDirection(1.5F, 1.5F);
      this.mDrawFilter.RenderProcess(this.mDrawFrameTemp1.getTextureId(), k, m, -1, 0.0D, this.mDrawFrame1);
      this.mDrawFilter.setTexSize(k, m);
      this.mDrawFilter.setIteration(1);
      this.mDrawFilter.setDirection(-1.5F, 1.5F);
      this.mDrawFilter.RenderProcess(this.mGaussianThreshFrame.getLastRenderTextureId(), k, m, -1, 0.0D, this.mDrawFrameTemp2);
      this.mDrawFilter.setTexSize(k, m);
      this.mDrawFilter.setIteration(0);
      this.mDrawFilter.setDirection(-1.5F, 1.5F);
      this.mDrawFilter.RenderProcess(this.mDrawFrameTemp2.getTextureId(), k, m, -1, 0.0D, this.mDrawFrame2);
      this.mDrawFilter.setTexSize(k, m);
      this.mDrawFilter.setIteration(1);
      this.mDrawFilter.setDirection(1.5F, -1.5F);
      this.mDrawFilter.RenderProcess(this.mGaussianThreshFrame.getLastRenderTextureId(), k, m, -1, 0.0D, this.mDrawFrameTemp3);
      this.mDrawFilter.setTexSize(k, m);
      this.mDrawFilter.setIteration(0);
      this.mDrawFilter.setDirection(1.5F, -1.5F);
      this.mDrawFilter.RenderProcess(this.mDrawFrameTemp3.getTextureId(), k, m, -1, 0.0D, this.mDrawFrame3);
      this.mDrawFilter.setTexSize(k, m);
      this.mDrawFilter.setIteration(1);
      this.mDrawFilter.setDirection(-1.5F, -1.5F);
      this.mDrawFilter.RenderProcess(this.mGaussianThreshFrame.getLastRenderTextureId(), k, m, -1, 0.0D, this.mDrawFrameTemp4);
      this.mDrawFilter.setTexSize(k, m);
      this.mDrawFilter.setIteration(0);
      this.mDrawFilter.setDirection(-1.5F, -1.5F);
      this.mDrawFilter.RenderProcess(this.mDrawFrameTemp4.getTextureId(), k, m, -1, 0.0D, this.mDrawFrame4);
      this.mOverlayFilter.setTexture2(this.mDrawFrame2.getTextureId());
      this.mOverlayFilter.RenderProcess(this.mDrawFrame1.getTextureId(), k, m, -1, 0.0D, this.result1);
      this.mOverlayFilter.setTexture2(this.mDrawFrame3.getTextureId());
      this.mOverlayFilter.RenderProcess(this.result1.getTextureId(), k, m, -1, 0.0D, this.result2);
      this.mOverlayFilter.setTexture2(this.mDrawFrame4.getTextureId());
      this.mOverlayFilter.RenderProcess(this.result2.getTextureId(), k, m, -1, 0.0D, this.result3);
      if (j == 0) {
        break label1015;
      }
      this.mCopyFilter.setRotationAndFlip(-paramInt, 0, 0);
      this.mCopyFilter.RenderProcess(this.result3.getTextureId(), m, k, -1, 0.0D, this.resultRotateFrame);
      this.mCopyFilter.setRotationAndFlip(0, 0, 0);
      return this.resultRotateFrame;
      i = 0;
      break;
    }
    label1015:
    return this.result3;
  }
  
  public List<PointF> getStarPoints(Frame paramFrame, StarParam paramStarParam, int paramInt)
  {
    if ((paramFrame.width * paramFrame.height == 0) || (!VideoMaterialUtil.needRenderStar(paramStarParam))) {
      return new ArrayList();
    }
    int j;
    label50:
    int k;
    if ((paramInt == 90) || (paramInt == 270))
    {
      j = 1;
      if (paramInt == 0) {
        break label403;
      }
      i = 1;
      int m = 180;
      k = paramFrame.height * 180 / paramFrame.width;
      if (j != 0)
      {
        k = 180;
        m = paramFrame.width * 180 / paramFrame.height;
      }
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), m, k, -1, 0.0D, this.mResizeFrame);
      this.mGaussianBlurFilter.updateTexelSize(0.5F / m, 0.5F / k);
      this.mGaussianBlurFilter.RenderProcess(this.mResizeFrame.getTextureId(), m, k, -1, 0.0D, this.mGaussianSrcFrame);
      this.mThreshFilter.setTexture2(this.mGaussianSrcFrame.getLastRenderTextureId());
      this.mThreshFilter.setThreshold(getFilterThreshold(paramStarParam));
      this.mThreshFilter.RenderProcess(this.mResizeFrame.getTextureId(), m, k, -1, 0.0D, this.mThreshFrame);
      j = m / 2;
      k /= 2;
      if (i == 0) {
        break label409;
      }
      this.mCopyFilter.setRotationAndFlip(-paramInt, 0, 0);
      this.mCopyFilter.RenderProcess(this.mThreshFrame.getTextureId(), k, j, -1, 0.0D, this.mThreshResizeFrame);
      this.mCopyFilter.setRotationAndFlip(0, 0, 0);
      label273:
      if ((!BitmapUtils.isLegal(this.mStarMaskBitmap)) || (this.mStarMaskBitmap.getWidth() != this.mThreshResizeFrame.width) || (this.mStarMaskBitmap.getHeight() != this.mThreshResizeFrame.height)) {
        break label436;
      }
      RendererUtils.saveTextureToBitmap(this.mThreshResizeFrame.getTextureId(), this.mThreshResizeFrame.width, this.mThreshResizeFrame.height, this.mStarMaskBitmap);
    }
    HashMap localHashMap;
    for (;;)
    {
      paramFrame = new ArrayList();
      localHashMap = new HashMap();
      paramInt = 0;
      while (paramInt < 256)
      {
        localHashMap.put(Integer.valueOf(paramInt), new LinkedList());
        paramInt += 1;
      }
      j = 0;
      break;
      label403:
      i = 0;
      break label50;
      label409:
      this.mCopyFilter.RenderProcess(this.mThreshFrame.getTextureId(), j, k, -1, 0.0D, this.mThreshResizeFrame);
      break label273;
      label436:
      BitmapUtils.recycle(this.mStarMaskBitmap);
      this.mStarMaskBitmap = RendererUtils.saveTexture(this.mThreshResizeFrame.getTextureId(), this.mThreshResizeFrame.width, this.mThreshResizeFrame.height);
    }
    paramInt = 5;
    while (paramInt < this.mStarMaskBitmap.getWidth() - 5)
    {
      i = 5;
      while (i < this.mStarMaskBitmap.getHeight() - 5)
      {
        ((LinkedList)localHashMap.get(Integer.valueOf(Color.red(this.mStarMaskBitmap.getPixel(paramInt, i))))).addLast(new PointF(paramInt / (this.mStarMaskBitmap.getWidth() - 1), i / (this.mStarMaskBitmap.getHeight() - 1)));
        i += 1;
      }
      paramInt += 1;
    }
    int i = getStarPointsNum(paramStarParam.starStrength);
    paramInt = 255;
    for (;;)
    {
      if (paramInt > 1)
      {
        paramStarParam = (LinkedList)localHashMap.get(Integer.valueOf(paramInt));
        if (!paramStarParam.isEmpty())
        {
          Collections.shuffle(paramStarParam);
          paramFrame.addAll(paramStarParam);
        }
        if (paramFrame.size() < i) {}
      }
      else
      {
        if (paramFrame.size() <= i) {
          break;
        }
        return paramFrame.subList(0, i);
      }
      paramInt -= 1;
    }
    return paramFrame;
  }
  
  public void initial()
  {
    this.mGaussianBlurFilter.applyFilterChain(true, 720.0F, 960.0F);
    this.mThreshFilter.apply();
    this.mThreshFilterForMask.apply();
    this.mDrawFilter.apply();
    this.mOverlayFilter.apply();
    this.mCopyFilter.apply();
    GLES20.glGenTextures(this.mStarColorTex.length, this.mStarColorTex, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.StarEffectFilter
 * JD-Core Version:    0.7.0.1
 */