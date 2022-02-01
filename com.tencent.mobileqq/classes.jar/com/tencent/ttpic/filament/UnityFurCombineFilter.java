package com.tencent.ttpic.filament;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.util.List;

public class UnityFurCombineFilter
  extends AEChainI
{
  private static final String TAG = NoFurFilter.class.getSimpleName();
  private UnityFurConfig config = new UnityFurConfig();
  private Frame copyFrame = new Frame();
  private UnityFurFilter furFilter = new UnityFurFilter();
  private List<Bitmap> layerMasks;
  private UnityNoFurFilter noFurFilter = new UnityNoFurFilter();
  private long startTime;
  private int[] tex = new int[2];
  
  private void genNoiseTex()
  {
    this.layerMasks = FurUtil.createFurTexture(23234, this.config.maskSize, 1, this.config.g_Density);
  }
  
  public void destroy()
  {
    this.furFilter.clearGLSLSelf();
    this.noFurFilter.clearGLSLSelf();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
    this.mIsApplied = false;
  }
  
  public void getTexture(int paramInt)
  {
    Bitmap localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), "assets://noise.jpg", 1);
    GlUtil.loadTexture(this.tex[1], localBitmap);
  }
  
  public void init()
  {
    if (this.mIsApplied) {
      return;
    }
    this.furFilter.updateParams(this.config);
    this.noFurFilter.updateParams(this.config);
    this.furFilter.ApplyGLSLFilter();
    this.noFurFilter.ApplyGLSLFilter();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
    this.config._SubTex = this.tex[1];
    Bitmap localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), "assets://fur.jpg", 1);
    GlUtil.loadTexture(this.tex[0], localBitmap);
    localBitmap.recycle();
    setFurValue(UnityFurConfig.FurValueType.DENSITY, this.config.g_Density);
    this.mIsApplied = true;
  }
  
  public Frame render(Frame paramFrame)
  {
    long l = System.currentTimeMillis();
    if (this.startTime <= 0L) {
      this.startTime = System.currentTimeMillis();
    }
    FrameUtil.clearFrame(this.copyFrame, 0.0F, 0.0F, 1.0F, 1.0F, paramFrame.width, paramFrame.height);
    getTexture(0);
    this.config._Time[1] = ((float)(l - this.startTime) / 5000.0F);
    this.config.FUR_OFFSET = 0.0F;
    this.furFilter.updateParams(this.config);
    this.noFurFilter.updateParams(this.config);
    this.noFurFilter.OnDrawFrameGLSL();
    this.noFurFilter.renderTexture(this.tex[0], paramFrame.width, paramFrame.height);
    GlUtil.setBlendModeSrcAlpha(true);
    int i = 0;
    while (i < this.config.g_NumLayers)
    {
      this.config.FUR_OFFSET = (i / this.config.g_NumLayers);
      this.furFilter.updateParams(this.config);
      this.furFilter.OnDrawFrameGLSL();
      this.furFilter.renderTexture(this.tex[0], paramFrame.width, paramFrame.height);
      i += 1;
    }
    GlUtil.setBlendModeSrcAlpha(false);
    return this.copyFrame;
  }
  
  public void setFurValue(UnityFurConfig.FurValueType paramFurValueType, int paramInt)
  {
    if (paramFurValueType == UnityFurConfig.FurValueType.DENSITY)
    {
      this.config.g_Density = paramInt;
      genNoiseTex();
    }
    do
    {
      return;
      if (paramFurValueType == UnityFurConfig.FurValueType.WIDTH)
      {
        this.config.maskSize = paramInt;
        genNoiseTex();
        return;
      }
      if (paramFurValueType == UnityFurConfig.FurValueType.LENGTH)
      {
        this.config._Spacing = (paramInt / 10.0F);
        return;
      }
      if (paramFurValueType == UnityFurConfig.FurValueType.LAYER_COUNT)
      {
        this.config.g_NumLayers = paramInt;
        return;
      }
    } while (paramFurValueType != UnityFurConfig.FurValueType.Y_DEGREE);
    this.config.g_fSpinY = (paramInt - 180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.UnityFurCombineFilter
 * JD-Core Version:    0.7.0.1
 */