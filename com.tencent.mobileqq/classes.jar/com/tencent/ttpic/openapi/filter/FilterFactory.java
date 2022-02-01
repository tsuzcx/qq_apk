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
    if (paramInt != 80)
    {
      if (paramInt != 81)
      {
        if (paramInt != 87)
        {
          if (paramInt != 117)
          {
            if (paramInt != 125)
            {
              if (paramInt != 150)
              {
                if (paramInt != 202)
                {
                  if (paramInt != 214)
                  {
                    if (paramInt != 127)
                    {
                      if (paramInt != 128)
                      {
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            switch (paramInt)
                            {
                            default: 
                              return CameraFilterFactory.createFilterById4Local(paramInt);
                            case 122: 
                              return new FrameMontageFilter(0);
                            case 121: 
                              return new MangaFilter(0);
                            }
                            return new PosterFilter(0);
                          case 96: 
                            return new CartoonFilter(2);
                          case 95: 
                            return new CartoonFilter(1);
                          }
                          return new CartoonFilter(0);
                        case 12: 
                          localObject = new Curve2D("danya.png");
                          ((Curve2D)localObject).setMatrix(new float[] { 0.825F, 0.075F, 0.075F, 0.0F, 0.147F, 0.897F, 0.147F, 0.0F, 0.029F, 0.029F, 0.779F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
                          return localObject;
                        case 11: 
                          localObject = new Curve2D("jingdianheibai.png");
                          ((Curve2D)localObject).setMatrix(new float[] { 0.299F, 0.299F, 0.299F, 0.0F, 0.587F, 0.587F, 0.587F, 0.0F, 0.114F, 0.114F, 0.114F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
                          return localObject;
                        case 10: 
                          return new Curve2D("qiurisiyu.png");
                        case 9: 
                          return new Curve2D("xpro2.png");
                        case 8: 
                          return new FlaresFilter(0);
                        case 7: 
                          return new BaibianFilter(0, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
                        case 6: 
                          return new Curve2D("hudson.png");
                        case 5: 
                          return new QingYiFilter();
                        case 4: 
                          return new BeautysFilter(0, 0);
                        case 3: 
                          return new Curve2D("rise.png");
                        case 2: 
                          return new BeautysFilter(0, 1);
                        case 1: 
                          return new AlphaAdjustFilter(3);
                        }
                        return new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
                      }
                      localObject = new BaseFilter(BaseFilter.getFragmentShader(67));
                      ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sketch.png", 33986));
                      return localObject;
                    }
                    return new BaseFilter(BaseFilter.getFragmentShader(66));
                  }
                  return new ShareFilm_1();
                }
                return new ColorFilterSH();
              }
              return new FilterWraper("Curve2D/amaro");
            }
            return new DpiLensFilter();
          }
          return new AlphaAdjustFilter(4);
        }
        Object localObject = new BaseFilter(BaseFilter.getFragmentShader(10));
        ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sketch.png", 33986));
        return localObject;
      }
      return new NightRGBStretchFilter();
    }
    return new HDRHSVFilter();
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
    if (paramString.equals("MIC_Montage"))
    {
      paramInt = 122;
    }
    else
    {
      if (paramString.equals("MIC_GLOW")) {}
      do
      {
        paramInt = 80;
        break label374;
        if (paramString.equals("MIC_AVG_ROUND"))
        {
          paramInt = 119;
          break label374;
        }
        if (paramString.equals("MIC_OILPAINTING"))
        {
          paramInt = 99;
          break label374;
        }
        if (paramString.equals("MIC_MANGASAVE"))
        {
          paramInt = 121;
          break label374;
        }
        if (paramString.equals("MIC_Poster"))
        {
          paramInt = 120;
          break label374;
        }
        if ((paramString.equals("MR_COLORPENCIL")) || (paramString.equals("MIC_COLORPENCIL"))) {
          break;
        }
        if (paramString.equals("MIC_MARK"))
        {
          paramInt = 127;
          break label374;
        }
        if (paramString.equals("MIC_NEWSKETCH"))
        {
          paramInt = 128;
          break label374;
        }
        if (paramString.equals("MIC_CartoonRomantic"))
        {
          paramInt = 96;
          break label374;
        }
        if (paramString.equals("MIC_GLOW_CPU_FILTER")) {}
        while (paramString.equals("MIC_GLOW_FORG_FILTER"))
        {
          paramInt = 126;
          break;
        }
        if (paramString.equals("MIC_Portait"))
        {
          paramInt = 2;
          break label374;
        }
      } while (paramString.equals("MIC_GLOW"));
      if (paramString.equals("MIC_Flares")) {
        paramInt = 8;
      } else if (paramString.equals("MIC_Portait_NB")) {
        paramInt = 4;
      } else if (!paramString.equals("MIC_LENS")) {
        if (paramString.equals("MIC_SHARE_FILM"))
        {
          paramInt = 214;
        }
        else if (paramString.equals("MIC_ABAO"))
        {
          paramInt = 83;
        }
        else if ((!paramString.equals("MIC_COLOR_SH")) && (!paramString.equals("MIC_PTU_COLOR_SH")))
        {
          if ((!paramString.equals("MIC_SHISHANG_SH")) && (!paramString.equals("MIC_PTU_SHISHANG_SH")))
          {
            if ((paramString.equals("MIC_FUGU_SH")) || (paramString.equals("MIC_PTU_FUGU_SH"))) {
              paramInt = 201;
            }
          }
          else {
            paramInt = 200;
          }
        }
        else
        {
          paramInt = 202;
          break label374;
          paramInt = 87;
        }
      }
    }
    label374:
    if (paramString.equals("MIC_PTU_SNOW")) {
      return 222;
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
    if ((!paramString.equals("MIC_XPRO2")) && (!paramString.equals("MIC_XPRO")))
    {
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
    return 9;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FilterFactory
 * JD-Core Version:    0.7.0.1
 */