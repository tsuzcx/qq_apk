package com.tencent.ttpic;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Curve2D;
import com.tencent.filter.ImageFilterFactory;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.openapi.filter.PtuFilterFactory;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.view.FilterEnum;

public class PTFilter
{
  protected BaseFilter mFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  protected Frame mFilterFrame = new Frame();
  
  @Deprecated
  public static PTFilter createByFile(String paramString)
  {
    return null;
  }
  
  public static PTFilter createById(int paramInt1, int paramInt2)
  {
    PTFilter localPTFilter = new PTFilter();
    if (FilterEnum.isImageFilter(paramInt1)) {
      localPTFilter.mFilter = ImageFilterFactory.createFilter(paramInt1);
    } else {
      localPTFilter.mFilter = PtuFilterFactory.createFilter(paramInt1);
    }
    BaseFilter localBaseFilter = localPTFilter.mFilter;
    localBaseFilter.needFlipBlend = true;
    localBaseFilter.setSrcFilterIndex(-1);
    localPTFilter.mFilter.setEffectIndex(paramInt2);
    return localPTFilter;
  }
  
  public static PTFilter createByLut(String paramString)
  {
    PTFilter localPTFilter = new PTFilter();
    Bitmap localBitmap2 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
    }
    localPTFilter.mFilter = TTPicFilterFactoryLocal.lutFilterWithBitmap(localBitmap1);
    paramString = localPTFilter.mFilter;
    if (paramString == null) {
      return null;
    }
    paramString.needFlipBlend = true;
    paramString.setSrcFilterIndex(-1);
    localPTFilter.mFilterFrame = new Frame();
    return localPTFilter;
  }
  
  public static PTFilter createCopyFilter()
  {
    return new PTFilter.PTCopyFilter();
  }
  
  public static PTFilter createCurve2D(String paramString)
  {
    return createCurve2D(paramString, null);
  }
  
  public static PTFilter createCurve2D(String paramString, float[] paramArrayOfFloat)
  {
    PTFilter localPTFilter = new PTFilter();
    paramString = new Curve2D(paramString);
    if (paramArrayOfFloat != null) {
      paramString.setMatrix(paramArrayOfFloat);
    }
    localPTFilter.mFilter = paramString;
    paramString = localPTFilter.mFilter;
    paramString.needFlipBlend = true;
    paramString.setSrcFilterIndex(-1);
    localPTFilter.mFilterFrame = new Frame();
    return localPTFilter;
  }
  
  public static PTFilter createYUV2RGBAFilter()
  {
    PTFilter localPTFilter = new PTFilter();
    localPTFilter.mFilter = new SurfaceTextureFilter();
    return localPTFilter;
  }
  
  public void destroy()
  {
    this.mFilter.clearGLSL();
    this.mFilterFrame.clear();
  }
  
  public BaseFilter getFilter()
  {
    return this.mFilter;
  }
  
  public int init()
  {
    this.mFilter.applyFilterChain(true, 1.0F, 1.0F);
    return 0;
  }
  
  public Frame process(Frame paramFrame)
  {
    this.mFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mFilterFrame);
    return FrameUtil.getLastRenderFrame(this.mFilterFrame);
  }
  
  public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
  {
    this.mFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mFilterFrame);
    return FrameUtil.getLastRenderFrame(this.mFilterFrame);
  }
  
  public void processToScreen(Frame paramFrame, int paramInt1, int paramInt2)
  {
    this.mFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, 0, 0.0D, this.mFilterFrame);
  }
  
  public void setFilter(BaseFilter paramBaseFilter)
  {
    this.mFilter = paramBaseFilter;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mFilter.setRenderMode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter
 * JD-Core Version:    0.7.0.1
 */