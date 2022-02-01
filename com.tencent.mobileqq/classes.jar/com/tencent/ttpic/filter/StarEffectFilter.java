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
import com.tencent.ttpic.openapi.model.VideoMaterial;
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
    if (paramLong < paramStarParam.starBlurScalePeriod / 2L) {
      return (paramStarParam.starBlurMinScale - paramStarParam.starBlurMaxScale) / (float)(paramStarParam.starBlurScalePeriod / 2L) * (float)paramLong + paramStarParam.starBlurMaxScale;
    }
    return (paramStarParam.starBlurMaxScale - paramStarParam.starBlurMinScale) / (float)(paramStarParam.starBlurScalePeriod / 2L) * (float)paramLong + (paramStarParam.starBlurMinScale * 2.0F - paramStarParam.starBlurMaxScale);
  }
  
  private float getFilterThreshold(StarParam paramStarParam)
  {
    return Math.min(1.0F, Math.max(0.0F, (paramStarParam.starMinThreshold - paramStarParam.starMaxThreshold) * paramStarParam.starStrength + paramStarParam.starMaxThreshold));
  }
  
  private int getStarPointsNum(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      return Math.max(10, Math.min(40, (int)(paramFloat * 30.0F + 10.0F)));
    }
    return 0;
  }
  
  public void clear()
  {
    this.mGaussianBlurFilter.clearGLSL();
    this.mThreshFilter.clearGLSL();
    this.mThreshFilterForMask.clearGLSL();
    this.mDrawFilter.clearGLSL();
    this.mOverlayFilter.clearGLSL();
    this.mCopyFilter.clearGLSL();
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
    int[] arrayOfInt = this.mStarColorTex;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    BitmapUtils.recycle(this.mStarMaskBitmap);
    this.mStarMaskBitmap = null;
  }
  
  public Frame getMaskFrame(Frame paramFrame, StarParam paramStarParam, int paramInt)
  {
    if ((paramFrame.width * paramFrame.height != 0) && (VideoMaterial.needRenderStar(paramStarParam)))
    {
      long l = System.currentTimeMillis();
      if (this.mStartTime < 0L) {
        this.mStartTime = l;
      }
      float f1 = getCurrentScale(l, paramStarParam);
      int j;
      if ((paramInt != 90) && (paramInt != 270)) {
        j = 0;
      } else {
        j = 1;
      }
      int i;
      if (paramInt != 0) {
        i = 1;
      } else {
        i = 0;
      }
      int k = paramFrame.height * 180 / paramFrame.width;
      if (j != 0)
      {
        j = paramFrame.width * 180 / paramFrame.height;
        k = 180;
      }
      else
      {
        j = 180;
      }
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), j, k, -1, 0.0D, this.mResizeFrame);
      paramFrame = this.mGaussianBlurFilter;
      float f2 = j;
      float f3 = 0.5F / f2;
      float f4 = k;
      paramFrame.updateTexelSize(f3, 0.5F / f4);
      this.mGaussianBlurFilter.RenderProcess(this.mResizeFrame.getTextureId(), j, k, -1, 0.0D, this.mGaussianSrcFrame);
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
      this.mThreshFilterForMask.RenderProcess(this.mResizeFrame.getTextureId(), j, k, -1, 0.0D, this.mThreshFrame);
      this.mGaussianBlurFilter.updateTexelSize(0.15F / f2, 0.15F / f4);
      this.mGaussianBlurFilter.RenderProcess(this.mThreshFrame.getTextureId(), j, k, -1, 0.0D, this.mGaussianThreshFrame);
      this.mDrawFilter.setScale(f1);
      this.mDrawFilter.setTexSize(f2, f4);
      this.mDrawFilter.setIteration(1);
      this.mDrawFilter.setDirection(1.5F, 1.5F);
      this.mDrawFilter.RenderProcess(this.mGaussianThreshFrame.getLastRenderTextureId(), j, k, -1, 0.0D, this.mDrawFrameTemp1);
      this.mDrawFilter.setTexSize(f2, f4);
      this.mDrawFilter.setIteration(0);
      this.mDrawFilter.setDirection(1.5F, 1.5F);
      this.mDrawFilter.RenderProcess(this.mDrawFrameTemp1.getTextureId(), j, k, -1, 0.0D, this.mDrawFrame1);
      this.mDrawFilter.setTexSize(f2, f4);
      this.mDrawFilter.setIteration(1);
      this.mDrawFilter.setDirection(-1.5F, 1.5F);
      this.mDrawFilter.RenderProcess(this.mGaussianThreshFrame.getLastRenderTextureId(), j, k, -1, 0.0D, this.mDrawFrameTemp2);
      this.mDrawFilter.setTexSize(f2, f4);
      this.mDrawFilter.setIteration(0);
      this.mDrawFilter.setDirection(-1.5F, 1.5F);
      this.mDrawFilter.RenderProcess(this.mDrawFrameTemp2.getTextureId(), j, k, -1, 0.0D, this.mDrawFrame2);
      this.mDrawFilter.setTexSize(f2, f4);
      this.mDrawFilter.setIteration(1);
      this.mDrawFilter.setDirection(1.5F, -1.5F);
      this.mDrawFilter.RenderProcess(this.mGaussianThreshFrame.getLastRenderTextureId(), j, k, -1, 0.0D, this.mDrawFrameTemp3);
      this.mDrawFilter.setTexSize(f2, f4);
      this.mDrawFilter.setIteration(0);
      this.mDrawFilter.setDirection(1.5F, -1.5F);
      this.mDrawFilter.RenderProcess(this.mDrawFrameTemp3.getTextureId(), j, k, -1, 0.0D, this.mDrawFrame3);
      this.mDrawFilter.setTexSize(f2, f4);
      this.mDrawFilter.setIteration(1);
      this.mDrawFilter.setDirection(-1.5F, -1.5F);
      this.mDrawFilter.RenderProcess(this.mGaussianThreshFrame.getLastRenderTextureId(), j, k, -1, 0.0D, this.mDrawFrameTemp4);
      this.mDrawFilter.setTexSize(f2, f4);
      this.mDrawFilter.setIteration(0);
      this.mDrawFilter.setDirection(-1.5F, -1.5F);
      this.mDrawFilter.RenderProcess(this.mDrawFrameTemp4.getTextureId(), j, k, -1, 0.0D, this.mDrawFrame4);
      this.mOverlayFilter.setTexture2(this.mDrawFrame2.getTextureId());
      this.mOverlayFilter.RenderProcess(this.mDrawFrame1.getTextureId(), j, k, -1, 0.0D, this.result1);
      this.mOverlayFilter.setTexture2(this.mDrawFrame3.getTextureId());
      this.mOverlayFilter.RenderProcess(this.result1.getTextureId(), j, k, -1, 0.0D, this.result2);
      this.mOverlayFilter.setTexture2(this.mDrawFrame4.getTextureId());
      this.mOverlayFilter.RenderProcess(this.result2.getTextureId(), j, k, -1, 0.0D, this.result3);
      if (i != 0)
      {
        this.mCopyFilter.setRotationAndFlip(-paramInt, 0, 0);
        this.mCopyFilter.RenderProcess(this.result3.getTextureId(), k, j, -1, 0.0D, this.resultRotateFrame);
        this.mCopyFilter.setRotationAndFlip(0, 0, 0);
        return this.resultRotateFrame;
      }
      return this.result3;
    }
    return null;
  }
  
  public List<PointF> getStarPoints(Frame paramFrame, StarParam paramStarParam, int paramInt)
  {
    if ((paramFrame.width * paramFrame.height != 0) && (VideoMaterial.needRenderStar(paramStarParam)))
    {
      int j;
      if ((paramInt != 90) && (paramInt != 270)) {
        j = 0;
      } else {
        j = 1;
      }
      if (paramInt != 0) {
        i = 1;
      } else {
        i = 0;
      }
      int k = paramFrame.height * 180 / paramFrame.width;
      if (j != 0)
      {
        k = paramFrame.width * 180 / paramFrame.height;
        j = 180;
      }
      else
      {
        int m = 180;
        j = k;
        k = m;
      }
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), k, j, -1, 0.0D, this.mResizeFrame);
      this.mGaussianBlurFilter.updateTexelSize(0.5F / k, 0.5F / j);
      this.mGaussianBlurFilter.RenderProcess(this.mResizeFrame.getTextureId(), k, j, -1, 0.0D, this.mGaussianSrcFrame);
      this.mThreshFilter.setTexture2(this.mGaussianSrcFrame.getLastRenderTextureId());
      this.mThreshFilter.setThreshold(getFilterThreshold(paramStarParam));
      this.mThreshFilter.RenderProcess(this.mResizeFrame.getTextureId(), k, j, -1, 0.0D, this.mThreshFrame);
      k /= 2;
      j /= 2;
      if (i != 0)
      {
        this.mCopyFilter.setRotationAndFlip(-paramInt, 0, 0);
        this.mCopyFilter.RenderProcess(this.mThreshFrame.getTextureId(), j, k, -1, 0.0D, this.mThreshResizeFrame);
        this.mCopyFilter.setRotationAndFlip(0, 0, 0);
      }
      else
      {
        this.mCopyFilter.RenderProcess(this.mThreshFrame.getTextureId(), k, j, -1, 0.0D, this.mThreshResizeFrame);
      }
      if ((BitmapUtils.isLegal(this.mStarMaskBitmap)) && (this.mStarMaskBitmap.getWidth() == this.mThreshResizeFrame.width) && (this.mStarMaskBitmap.getHeight() == this.mThreshResizeFrame.height))
      {
        RendererUtils.saveTextureToBitmap(this.mThreshResizeFrame.getTextureId(), this.mThreshResizeFrame.width, this.mThreshResizeFrame.height, this.mStarMaskBitmap);
      }
      else
      {
        BitmapUtils.recycle(this.mStarMaskBitmap);
        this.mStarMaskBitmap = RendererUtils.saveTexture(this.mThreshResizeFrame.getTextureId(), this.mThreshResizeFrame.width, this.mThreshResizeFrame.height);
      }
      ArrayList localArrayList = new ArrayList();
      paramFrame = new HashMap();
      paramInt = 0;
      while (paramInt < 256)
      {
        paramFrame.put(Integer.valueOf(paramInt), new LinkedList());
        paramInt += 1;
      }
      paramInt = 5;
      while (paramInt < this.mStarMaskBitmap.getWidth() - 5)
      {
        i = 5;
        while (i < this.mStarMaskBitmap.getHeight() - 5)
        {
          ((LinkedList)paramFrame.get(Integer.valueOf(Color.red(this.mStarMaskBitmap.getPixel(paramInt, i))))).addLast(new PointF(paramInt / (this.mStarMaskBitmap.getWidth() - 1), i / (this.mStarMaskBitmap.getHeight() - 1)));
          i += 1;
        }
        paramInt += 1;
      }
      paramInt = 255;
      int i = getStarPointsNum(paramStarParam.starStrength);
      do
      {
        if (paramInt <= 1) {
          break;
        }
        paramStarParam = (LinkedList)paramFrame.get(Integer.valueOf(paramInt));
        if (!paramStarParam.isEmpty())
        {
          Collections.shuffle(paramStarParam);
          localArrayList.addAll(paramStarParam);
        }
        paramInt -= 1;
      } while (localArrayList.size() < i);
      paramFrame = localArrayList;
      if (localArrayList.size() > i) {
        paramFrame = localArrayList.subList(0, i);
      }
      return paramFrame;
    }
    return new ArrayList();
  }
  
  public void initial()
  {
    this.mGaussianBlurFilter.applyFilterChain(true, 720.0F, 960.0F);
    this.mThreshFilter.apply();
    this.mThreshFilterForMask.apply();
    this.mDrawFilter.apply();
    this.mOverlayFilter.apply();
    this.mCopyFilter.apply();
    int[] arrayOfInt = this.mStarColorTex;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.StarEffectFilter
 * JD-Core Version:    0.7.0.1
 */