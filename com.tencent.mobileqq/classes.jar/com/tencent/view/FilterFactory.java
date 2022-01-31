package com.tencent.view;

import android.graphics.Bitmap;
import com.tencent.filter.AlphaAdjustFilter;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.BeautysFilter;
import com.tencent.filter.ColorFilterSH;
import com.tencent.filter.Curve2D;
import com.tencent.filter.DpiLensFilter;
import com.tencent.filter.FilterWraper;
import com.tencent.filter.FlaresFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.FrameMontageFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HDRHSVFilter;
import com.tencent.filter.QImage;
import com.tencent.filter.ShareFilm_1;
import com.tencent.filter.art.BaibianFilter;
import com.tencent.filter.art.CartoonFilter;
import com.tencent.filter.art.DofCpuFilter;
import com.tencent.filter.art.MangaFilter;
import com.tencent.filter.art.NightRGBStretchFilter;
import com.tencent.filter.art.OilPaintFilter;
import com.tencent.filter.art.PosterFilter;
import com.tencent.filter.ttpic.QingYiFilter;
import com.tencent.filter.ttpic.TTPicFilterFactory;
import java.util.HashMap;
import java.util.Map;

public class FilterFactory
{
  public static BaseFilter createFilter(int paramInt)
  {
    Curve2D localCurve2D;
    switch (paramInt)
    {
    default: 
      return TTPicFilterFactory.creatFilterById(paramInt);
    case 0: 
      return new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    case 125: 
      return new DpiLensFilter();
    case 1: 
      return new AlphaAdjustFilter(GLSLRender.FILTER_ALPHA_ADJUST);
    case 117: 
      return new AlphaAdjustFilter(GLSLRender.FILTER_ALPHA_ADJUST_REAL);
    case 2: 
      return new BeautysFilter(GLSLRender.FILTER_SHADER_NONE, 1);
    case 3: 
      return new Curve2D("rise.png");
    case 4: 
      return new BeautysFilter(GLSLRender.FILTER_SHADER_NONE, 0);
    case 5: 
      return new QingYiFilter();
    case 6: 
      return new Curve2D("hudson.png");
    case 7: 
      return new BaibianFilter(GLSLRender.FILTER_SHADER_NONE, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
    case 8: 
      return new FlaresFilter(0);
    case 9: 
      return new Curve2D("xpro2.png");
    case 80: 
      return new HDRHSVFilter();
    case 81: 
      return new NightRGBStretchFilter();
    case 10: 
      return new Curve2D("qiurisiyu.png");
    case 11: 
      localCurve2D = new Curve2D("jingdianheibai.png");
      ((Curve2D)localCurve2D).setMatrix(new float[] { 0.299F, 0.299F, 0.299F, 0.0F, 0.587F, 0.587F, 0.587F, 0.0F, 0.114F, 0.114F, 0.114F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      return localCurve2D;
    case 12: 
      localCurve2D = new Curve2D("danya.png");
      ((Curve2D)localCurve2D).setMatrix(new float[] { 0.825F, 0.075F, 0.075F, 0.0F, 0.147F, 0.897F, 0.147F, 0.0F, 0.029F, 0.029F, 0.779F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      return localCurve2D;
    case 87: 
      return new BaseFilter(GLSLRender.FILTER_COLORPENCIL, "colorPencil.png");
    case 128: 
      return new BaseFilter(GLSLRender.FILTER_NEW_SKETCH, "sketch.png");
    case 127: 
      return new BaseFilter(GLSLRender.FILTER_MARK);
    case 94: 
      return new CartoonFilter(0);
    case 95: 
      return new CartoonFilter(1);
    case 96: 
      return new CartoonFilter(2);
    case 99: 
      return new OilPaintFilter(0);
    case 100: 
      return new OilPaintFilter(1);
    case 110: 
      return new DofCpuFilter(0);
    case 119: 
      return new DofCpuFilter(1);
    case 120: 
      return new PosterFilter(0);
    case 121: 
      return new MangaFilter(0);
    case 122: 
      return new FrameMontageFilter(0);
    case 202: 
      return new ColorFilterSH();
    case 214: 
      return new ShareFilm_1();
    }
    return new FilterWraper("Curve2D/amaro");
  }
  
  public static BaseFilter createFilter(String paramString, int paramInt)
  {
    paramString = createFilter(filterIdFromString(paramString, paramInt));
    HashMap localHashMap = new HashMap();
    localHashMap.put("effectIndex", Integer.valueOf(paramInt));
    paramString.setParameterDic(localHashMap);
    localHashMap.clear();
    return paramString;
  }
  
  public static int deinitMagicEngine(int paramInt)
  {
    return GLSLRender.nativeDeinitMagicEngine(paramInt);
  }
  
  public static int filterIdFromString(String paramString, int paramInt)
  {
    paramInt = 0;
    if (paramString == null) {
      return 0;
    }
    if (paramString.equals("MIC_Montage")) {
      paramInt = 122;
    }
    while (paramString.equals("MIC_PTU_SNOW"))
    {
      return 222;
      if (paramString.equals("MIC_GLOW")) {
        paramInt = 80;
      } else if (paramString.equals("MIC_AVG_ROUND")) {
        paramInt = 119;
      } else if (paramString.equals("MIC_OILPAINTING")) {
        paramInt = 99;
      } else if (paramString.equals("MIC_MANGASAVE")) {
        paramInt = 121;
      } else if (paramString.equals("MIC_Poster")) {
        paramInt = 120;
      } else if ((paramString.equals("MR_COLORPENCIL")) || (paramString.equals("MIC_COLORPENCIL"))) {
        paramInt = 87;
      } else if (paramString.equals("MIC_MARK")) {
        paramInt = 127;
      } else if (paramString.equals("MIC_NEWSKETCH")) {
        paramInt = 128;
      } else if (paramString.equals("MIC_CartoonRomantic")) {
        paramInt = 96;
      } else if (paramString.equals("MIC_GLOW_CPU_FILTER")) {
        paramInt = 126;
      } else if (paramString.equals("MIC_GLOW_FORG_FILTER")) {
        paramInt = 126;
      } else if (paramString.equals("MIC_Portait")) {
        paramInt = 2;
      } else if (paramString.equals("MIC_GLOW")) {
        paramInt = 80;
      } else if (paramString.equals("MIC_Flares")) {
        paramInt = 8;
      } else if (paramString.equals("MIC_Portait_NB")) {
        paramInt = 4;
      } else if (paramString.equals("MIC_LENS")) {
        paramInt = 0;
      } else if (paramString.equals("MIC_SHARE_FILM")) {
        paramInt = 214;
      } else if (paramString.equals("MIC_ABAO")) {
        paramInt = 83;
      } else if ((paramString.equals("MIC_COLOR_SH")) || (paramString.equals("MIC_PTU_COLOR_SH"))) {
        paramInt = 202;
      } else if ((paramString.equals("MIC_SHISHANG_SH")) || (paramString.equals("MIC_PTU_SHISHANG_SH"))) {
        paramInt = 200;
      } else if ((paramString.equals("MIC_FUGU_SH")) || (paramString.equals("MIC_PTU_FUGU_SH"))) {
        paramInt = 201;
      }
    }
    if (paramString.equals("MIC_PTU_GAOLENG")) {
      return 223;
    }
    if (paramString.equals("MIC_PTU_FEN")) {
      return 204;
    }
    if (paramString.equals("MIC_PTU_FUGUHUANG")) {
      return 205;
    }
    if (paramString.equals("MIC_PTU_GOGUANGLANZI")) {
      return 206;
    }
    if (paramString.equals("MIC_PTU_HEIBAI")) {
      return 207;
    }
    if (paramString.equals("MIC_PTU_HUAIJIU")) {
      return 208;
    }
    if (paramString.equals("MIC_PTU_JIAOPIAN")) {
      return 209;
    }
    if (paramString.equals("MIC_PTU_LAN")) {
      return 210;
    }
    if (paramString.equals("MIC_PTU_LANTUISE")) {
      return 211;
    }
    if (paramString.equals("MIC_PTU_MOLV")) {
      return 212;
    }
    if (paramString.equals("MIC_PTU_NUANHUANG")) {
      return 213;
    }
    if (paramString.equals("MIC_PTU_FEN2")) {
      return 215;
    }
    if (paramString.equals("MIC_PTU_HEIBAI2")) {
      return 216;
    }
    if (paramString.equals("MIC_PTU_DRAMA")) {
      return 217;
    }
    if (paramString.equals("MIC_PTU_NIGHT")) {
      return 218;
    }
    if (paramString.equals("MIC_PTU_FUGU")) {
      return 219;
    }
    if (paramString.equals("MIC_PTU_HEIBAI3")) {
      return 220;
    }
    if (paramString.equals("MIC_AMARO")) {
      return 5;
    }
    if (paramString.equals("MIC_EARLYBIRD")) {
      return 10;
    }
    if (paramString.equals("MIC_HUDSON")) {
      return 6;
    }
    if (paramString.equals("MIC_RISE")) {
      return 3;
    }
    if ((paramString.equals("MIC_XPRO2")) || (paramString.equals("MIC_XPRO"))) {
      return 9;
    }
    if (paramString.equals("WEICO_FILM")) {
      return 12;
    }
    if (paramString.equals("WEICO_BW")) {
      return 11;
    }
    if (paramString.equals("MIC_TEST")) {
      return 150;
    }
    return paramInt;
  }
  
  public static int initMagicEngine(int paramInt1, int paramInt2)
  {
    return GLSLRender.nativeCheckMagicEngine(paramInt1, paramInt2);
  }
  
  public static boolean isSupportOrignalProcess(int paramInt)
  {
    switch (paramInt)
    {
    case 97: 
    case 98: 
    default: 
      return true;
    }
    return false;
  }
  
  public static void renderBitmapByFilterID(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    BaseFilter localBaseFilter1 = createFilter(paramInt1);
    Object localObject = new HashMap();
    ((Map)localObject).put("effectIndex", Integer.valueOf(paramInt2));
    localBaseFilter1.setParameterDic((Map)localObject);
    ((Map)localObject).clear();
    if (localBaseFilter1.isAdjustFilter()) {
      localBaseFilter1.setAdjustParam(paramFloat);
    }
    QImage localQImage;
    if (localBaseFilter1.isGPUProcess())
    {
      localBaseFilter1.ApplyGLSLFilter(true, paramBitmap.getWidth(), paramBitmap.getHeight());
      if ((!localBaseFilter1.isAdjustFilter()) && (paramFloat < 1.0F))
      {
        localObject = createFilter(117);
        localBaseFilter1.getLastFilter().setNextFilter((BaseFilter)localObject, new int[] { -1 });
        ((BaseFilter)localObject).setAdjustParam(paramFloat);
        ((BaseFilter)localObject).ApplyGLSLFilter(true, paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      localObject = new Frame();
      if (localBaseFilter1.isSupportForGloableRender())
      {
        localQImage = QImage.BindBitmap(paramBitmap);
        localBaseFilter1.RendProcessImage(localQImage, (Frame)localObject);
        localQImage.UnBindBitmap(paramBitmap);
      }
      for (;;)
      {
        localBaseFilter1.ClearGLSL();
        ((Frame)localObject).clear();
        return;
        localBaseFilter1.RenderProcessBitmap(paramBitmap, (Frame)localObject);
      }
    }
    localObject = QImage.Bitmap2QImage(paramBitmap);
    localBaseFilter1.ApplyFilter((QImage)localObject);
    if ((!localBaseFilter1.isAdjustFilter()) && (paramFloat < 1.0F))
    {
      localQImage = QImage.Bitmap2QImage(paramBitmap);
      BaseFilter localBaseFilter2 = createFilter(1);
      localBaseFilter2.setAdjustParam(paramFloat);
      localBaseFilter2.ApplyGLSLFilter(true, ((QImage)localObject).getWidth(), ((QImage)localObject).getHeight());
      paramInt1 = RendererUtils.createTexture();
      GLSLRender.nativeTextImage((QImage)localObject, paramInt1);
      localBaseFilter2.setTextureParam(paramInt1, 0);
      Frame localFrame = new Frame();
      localBaseFilter1.RendProcessImage(localQImage, localFrame);
      localFrame.clear();
      localBaseFilter2.ClearGLSL();
      RendererUtils.clearTexture(paramInt1);
      localQImage.ToBitmap(paramBitmap);
      localQImage.Dispose();
    }
    for (;;)
    {
      ((QImage)localObject).Dispose();
      return;
      ((QImage)localObject).ToBitmap(paramBitmap);
    }
  }
  
  public static void renderBitmapByFilterIDAsync(Bitmap paramBitmap, final int paramInt1, final int paramInt2, final float paramFloat, final Runnable paramRunnable)
  {
    paramBitmap = new Runnable()
    {
      public void run()
      {
        if (FilterEngineFactory.getInstance().usecurruntContext()) {
          FilterFactory.renderBitmapByFilterID(this.val$src, paramInt1, paramInt2, paramFloat);
        }
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    };
    FilterEngineFactory.getInstance().queue(paramBitmap);
  }
  
  public static void renderBitmapByFilterIDAsync(Bitmap paramBitmap, String paramString, int paramInt, float paramFloat, Runnable paramRunnable)
  {
    renderBitmapByFilterIDAsync(paramBitmap, filterIdFromString(paramString, paramInt), paramInt, paramFloat, paramRunnable);
  }
  
  public static void renderBitmapByFilterIDSync(Bitmap paramBitmap, final int paramInt1, final int paramInt2, final float paramFloat)
  {
    paramBitmap = new Runnable()
    {
      public void run()
      {
        if (FilterEngineFactory.getInstance().usecurruntContext()) {
          FilterFactory.renderBitmapByFilterID(this.val$src, paramInt1, paramInt2, paramFloat);
        }
        try
        {
          notify();
          return;
        }
        finally {}
      }
    };
    FilterEngineFactory.getInstance().queue(paramBitmap);
    try
    {
      paramBitmap.wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public static void renderBitmapByFilterIDSync(Bitmap paramBitmap, String paramString, int paramInt, float paramFloat)
  {
    renderBitmapByFilterIDSync(paramBitmap, filterIdFromString(paramString, paramInt), paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.view.FilterFactory
 * JD-Core Version:    0.7.0.1
 */