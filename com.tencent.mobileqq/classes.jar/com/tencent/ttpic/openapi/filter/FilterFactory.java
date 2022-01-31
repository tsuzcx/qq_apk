package com.tencent.ttpic.openapi.filter;

import com.tencent.filter.AlphaAdjustFilter;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.BeautysFilter;
import com.tencent.filter.ColorFilterSH;
import com.tencent.filter.Curve2D;
import com.tencent.filter.DpiLensFilter;
import com.tencent.filter.FilterWraper;
import com.tencent.filter.FlaresFilter;
import com.tencent.filter.FrameMontageFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HDRHSVFilter;
import com.tencent.filter.ShareFilm_1;
import com.tencent.filter.TextureResParam;
import com.tencent.filter.art.BaibianFilter;
import com.tencent.filter.art.CartoonFilter;
import com.tencent.filter.art.MangaFilter;
import com.tencent.filter.art.NightRGBStretchFilter;
import com.tencent.filter.art.PosterFilter;
import com.tencent.filter.ttpic.QingYiFilter;
import java.util.HashMap;
import java.util.Map;

public class FilterFactory
{
  public static BaseFilter createFilter(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return CameraFilterFactory.createFilterById4Local(paramInt);
    case 0: 
      return new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    case 125: 
      return new DpiLensFilter();
    case 1: 
      return new AlphaAdjustFilter(3);
    case 117: 
      return new AlphaAdjustFilter(4);
    case 2: 
      return new BeautysFilter(0, 1);
    case 3: 
      return new Curve2D("rise.png");
    case 4: 
      return new BeautysFilter(0, 0);
    case 5: 
      return new QingYiFilter();
    case 6: 
      return new Curve2D("hudson.png");
    case 7: 
      return new BaibianFilter(0, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
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
      localObject = new Curve2D("jingdianheibai.png");
      ((Curve2D)localObject).setMatrix(new float[] { 0.299F, 0.299F, 0.299F, 0.0F, 0.587F, 0.587F, 0.587F, 0.0F, 0.114F, 0.114F, 0.114F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      return localObject;
    case 12: 
      localObject = new Curve2D("danya.png");
      ((Curve2D)localObject).setMatrix(new float[] { 0.825F, 0.075F, 0.075F, 0.0F, 0.147F, 0.897F, 0.147F, 0.0F, 0.029F, 0.029F, 0.779F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      return localObject;
    case 87: 
      localObject = new BaseFilter(BaseFilter.getFragmentShader(10));
      ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sketch.png", 33986));
      return localObject;
    case 128: 
      localObject = new BaseFilter(BaseFilter.getFragmentShader(67));
      ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sketch.png", 33986));
      return localObject;
    case 127: 
      return new BaseFilter(BaseFilter.getFragmentShader(66));
    case 94: 
      return new CartoonFilter(0);
    case 95: 
      return new CartoonFilter(1);
    case 96: 
      return new CartoonFilter(2);
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
    int i = 80;
    if (paramString == null) {
      return 0;
    }
    if (paramString.equals("MIC_Montage")) {
      paramInt = 122;
    }
    for (;;)
    {
      if (paramString.equals("MIC_PTU_SNOW"))
      {
        return 222;
        paramInt = i;
        if (paramString.equals("MIC_GLOW")) {
          continue;
        }
        if (paramString.equals("MIC_AVG_ROUND"))
        {
          paramInt = 119;
          continue;
        }
        if (paramString.equals("MIC_OILPAINTING"))
        {
          paramInt = 99;
          continue;
        }
        if (paramString.equals("MIC_MANGASAVE"))
        {
          paramInt = 121;
          continue;
        }
        if (paramString.equals("MIC_Poster"))
        {
          paramInt = 120;
          continue;
        }
        if ((paramString.equals("MR_COLORPENCIL")) || (paramString.equals("MIC_COLORPENCIL")))
        {
          paramInt = 87;
          continue;
        }
        if (paramString.equals("MIC_MARK"))
        {
          paramInt = 127;
          continue;
        }
        if (paramString.equals("MIC_NEWSKETCH"))
        {
          paramInt = 128;
          continue;
        }
        if (paramString.equals("MIC_CartoonRomantic"))
        {
          paramInt = 96;
          continue;
        }
        if (paramString.equals("MIC_GLOW_CPU_FILTER"))
        {
          paramInt = 126;
          continue;
        }
        if (paramString.equals("MIC_GLOW_FORG_FILTER"))
        {
          paramInt = 126;
          continue;
        }
        if (paramString.equals("MIC_Portait"))
        {
          paramInt = 2;
          continue;
        }
        paramInt = i;
        if (paramString.equals("MIC_GLOW")) {
          continue;
        }
        if (paramString.equals("MIC_Flares"))
        {
          paramInt = 8;
          continue;
        }
        if (paramString.equals("MIC_Portait_NB"))
        {
          paramInt = 4;
          continue;
        }
        if (paramString.equals("MIC_LENS"))
        {
          paramInt = 0;
          continue;
        }
        if (paramString.equals("MIC_SHARE_FILM"))
        {
          paramInt = 214;
          continue;
        }
        if (paramString.equals("MIC_ABAO"))
        {
          paramInt = 83;
          continue;
        }
        if ((paramString.equals("MIC_COLOR_SH")) || (paramString.equals("MIC_PTU_COLOR_SH")))
        {
          paramInt = 202;
          continue;
        }
        if ((paramString.equals("MIC_SHISHANG_SH")) || (paramString.equals("MIC_PTU_SHISHANG_SH")))
        {
          paramInt = 200;
          continue;
        }
        if ((paramString.equals("MIC_FUGU_SH")) || (paramString.equals("MIC_PTU_FUGU_SH"))) {
          paramInt = 201;
        }
      }
      else
      {
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
      paramInt = 0;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FilterFactory
 * JD-Core Version:    0.7.0.1
 */