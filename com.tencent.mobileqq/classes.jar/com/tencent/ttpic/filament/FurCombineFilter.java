package com.tencent.ttpic.filament;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FurCombineFilter
  extends AEChainI
{
  private static final String TAG = NoFurFilter.class.getSimpleName();
  private FurConfig config = new FurConfig();
  private Frame copyFrame = new Frame();
  private FurFilter furFilter = new FurFilter();
  private FurShadowFilter furShadowFilter = new FurShadowFilter();
  private Random gravityRandom = new Random();
  private List<Bitmap> layerMasks;
  private NoFurFilter noFurFilter = new NoFurFilter();
  private long startUpdate;
  private int[] tex = new int[2];
  
  public void destroy()
  {
    this.furFilter.clearGLSLSelf();
    this.noFurFilter.clearGLSLSelf();
    this.furShadowFilter.clearGLSLSelf();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
    Iterator localIterator = this.layerMasks.iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)localIterator.next());
    }
    this.layerMasks.clear();
  }
  
  public void getTexture(int paramInt)
  {
    GlUtil.loadTexture(this.tex[0], (Bitmap)this.layerMasks.get(paramInt));
  }
  
  public void init()
  {
    this.furFilter.updateParams(this.config);
    this.noFurFilter.updateParams(this.config);
    this.furShadowFilter.updateParams(this.config);
    this.furFilter.ApplyGLSLFilter();
    this.noFurFilter.ApplyGLSLFilter();
    this.furShadowFilter.ApplyGLSLFilter();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
    Bitmap localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), "assets://noise.jpg", 1);
    this.layerMasks = FurUtil.createFurTextureFromBitmap(23234, this.config.maskSize, 20, this.config.g_Density, localBitmap);
    GlUtil.loadTexture(this.tex[1], localBitmap);
    BitmapUtils.recycle(localBitmap);
  }
  
  public Frame render(Frame paramFrame)
  {
    FrameUtil.clearFrame(this.copyFrame, 0.0F, 0.0F, 1.0F, 1.0F, paramFrame.width, paramFrame.height);
    long l = System.currentTimeMillis();
    int i = 0;
    while (i < this.config.g_vGravity.length)
    {
      paramFrame = this.config.g_vGravity;
      paramFrame[i] = ((float)(paramFrame[i] + (this.gravityRandom.nextFloat() - 0.5D) / 20.0D));
      this.config.g_vGravity[i] = Math.max(-0.2F, Math.min(this.config.g_vGravity[i], 0.2F));
      i += 1;
    }
    this.furFilter.updateParams(this.config);
    this.noFurFilter.updateParams(this.config);
    this.furShadowFilter.updateParams(this.config);
    this.startUpdate = l;
    getTexture(19);
    this.noFurFilter.OnDrawFrameGLSL();
    this.noFurFilter.renderTexture(this.tex[0], this.config.maskSize, this.config.maskSize);
    GlUtil.setBlendMode(true);
    i = 0;
    while (i < this.config.g_NumLayers)
    {
      float f1 = (i + 1.0F) / this.config.g_NumLayers;
      float f2 = this.config.g_FurLength * f1;
      float f3 = -this.config.g_FurLength;
      getTexture(i * 20 / this.config.g_NumLayers);
      if (this.config.g_Shadow)
      {
        this.furShadowFilter.addParam(new UniformParam.FloatParam("FurLength", f2));
        this.furShadowFilter.addParam(new UniformParam.FloatParam("Layer", f1));
        this.furShadowFilter.addParam(new UniformParam.FloatParam("UVScale", this.config.g_UVScale));
        this.furShadowFilter.OnDrawFrameGLSL();
        this.furShadowFilter.renderTexture(this.tex[0], this.config.maskSize, this.config.maskSize);
      }
      this.furFilter.addParam(new UniformParam.FloatParam("FurLength", f2));
      this.furFilter.addParam(new UniformParam.FloatParam("Layer", f1));
      this.furFilter.addParam(new UniformParam.FloatParam("UVScale", this.config.g_UVScale));
      this.furFilter.OnDrawFrameGLSL();
      this.furFilter.renderTexture(this.tex[0], this.config.maskSize, this.config.maskSize);
      i += 1;
    }
    GlUtil.setBlendMode(false);
    return this.copyFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.FurCombineFilter
 * JD-Core Version:    0.7.0.1
 */