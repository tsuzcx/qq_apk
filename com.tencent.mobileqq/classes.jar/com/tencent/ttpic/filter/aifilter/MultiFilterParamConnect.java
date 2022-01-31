package com.tencent.ttpic.filter.aifilter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.BeautysFilter;
import com.tencent.filter.Curve2D;
import com.tencent.filter.FlaresFilter;
import com.tencent.filter.HDRHSVFilter;
import com.tencent.filter.HDRHSVFilter.ChannelStretchFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.HistogramsStrectchFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.filter.art.BaibianFilter;
import com.tencent.filter.art.CartoonFilter;
import com.tencent.filter.art.OilPaintFilter;
import com.tencent.filter.ttpic.BlackWhite3Filter;
import com.tencent.filter.ttpic.ChannelStretchFilter3;
import com.tencent.filter.ttpic.CoffeeFilter;
import com.tencent.filter.ttpic.FaceBeautyAutoFilter;
import com.tencent.filter.ttpic.FairyTaleFilter;
import com.tencent.filter.ttpic.Fen2Filter;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.filter.ttpic.GradientAndyWarholCowFilter;
import com.tencent.filter.ttpic.GradientGlareFashionFilter;
import com.tencent.filter.ttpic.GradientGlareFondDreamFilter;
import com.tencent.filter.ttpic.GradientPurpleYellowFilter;
import com.tencent.filter.ttpic.LightFilter;
import com.tencent.filter.ttpic.LightGreenFilter;
import com.tencent.filter.ttpic.LightRedFilter;
import com.tencent.filter.ttpic.LightWhiteFilter;
import com.tencent.filter.ttpic.LipNewFilter;
import com.tencent.filter.ttpic.LollyFilter;
import com.tencent.filter.ttpic.MedSeaFilter;
import com.tencent.filter.ttpic.MilkBlueFilter;
import com.tencent.filter.ttpic.MilkCoffeeFilter;
import com.tencent.filter.ttpic.MilkGreenFilter;
import com.tencent.filter.ttpic.NextDoorFilter;
import com.tencent.filter.ttpic.NightFilter;
import com.tencent.filter.ttpic.OceanFilter;
import com.tencent.filter.ttpic.OkinawaFilter;
import com.tencent.filter.ttpic.QiangWeiFilter;
import com.tencent.filter.ttpic.RichBlueFilter;
import com.tencent.filter.ttpic.RichRedFilter;
import com.tencent.filter.ttpic.RichYellowFilter;
import com.tencent.filter.ttpic.SapporoFilter;
import com.tencent.filter.ttpic.ShuiLianFilter;
import com.tencent.filter.ttpic.TangGuoMeiGuiFilter;
import com.tencent.filter.ttpic.TeaMilkFilter;
import com.tencent.filter.ttpic.ThreeDFilter;
import com.tencent.filter.ttpic.ThursdayFilter;
import com.tencent.filter.ttpic.TianMeiZiPaiFilter;
import com.tencent.filter.ttpic.TokyoFilter;
import com.tencent.filter.ttpic.XinYeFilter;
import com.tencent.filter.ttpic.YouJiaLiFilter;
import com.tencent.filter.ttpic.YoungFilter;
import com.tencent.filter.ttpic.ZiranFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.filter.IOSSharpenFilter;
import com.tencent.ttpic.openapi.filter.BlurEffectForMultiConnect;
import com.tencent.ttpic.openapi.filter.BorderFilter;
import com.tencent.ttpic.openapi.filter.ChannelScaleFilter;
import com.tencent.ttpic.openapi.filter.ChannelTranslateFilter;
import com.tencent.ttpic.openapi.filter.DislocationFilter;
import com.tencent.ttpic.openapi.filter.MoscoFilter;
import com.tencent.ttpic.openapi.model.BaseFilterMaterial;
import com.tencent.ttpic.openapi.model.BridgeMaterial;
import com.tencent.ttpic.openapi.model.FilterMaterial;
import com.tencent.ttpic.openapi.model.FilterParam;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiFilterParamConnect
{
  static int filterNum = 0;
  private static Map<String, List<Float>> mFilterRandomMap = new HashMap();
  
  public static void clearFilterRandomMap()
  {
    mFilterRandomMap.clear();
  }
  
  private static BaseFilter createBaseFilter(BaseFilterMaterial paramBaseFilterMaterial, float paramFloat1, float paramFloat2, String paramString)
  {
    Object localObject3 = paramBaseFilterMaterial.name;
    Object localObject1;
    if (((String)localObject3).equals("MIC_BASE_LENS")) {
      localObject1 = new BaseFilter(BaseFilter.getFragmentShader(0));
    }
    float f1;
    float f2;
    float f4;
    float f3;
    int i;
    float f7;
    float f6;
    float f5;
    Object localObject2;
    int k;
    int j;
    Object localObject4;
    do
    {
      return localObject1;
      float f9;
      float f8;
      if (((String)localObject3).equals("MIC_BASE_CHANNELMIXER"))
      {
        paramString = new BaseFilter(BaseFilter.getFragmentShader(58));
        paramFloat1 = 0.4F;
        paramFloat2 = 0.4F;
        f1 = 0.2F;
        f2 = 1.0F;
        f4 = 1.0F;
        f3 = 1.0F;
        i = 0;
        if (i < paramBaseFilterMaterial.params.size())
        {
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("rparam"))
          {
            f9 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f8 = paramFloat2;
            f7 = f1;
            f6 = f2;
            f5 = f3;
          }
          for (;;)
          {
            i += 1;
            f3 = f5;
            f2 = f6;
            f1 = f7;
            paramFloat2 = f8;
            paramFloat1 = f9;
            break;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("gparam"))
            {
              f8 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f5 = f3;
              f6 = f2;
              f7 = f1;
              f9 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("bparam"))
            {
              f7 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f5 = f3;
              f6 = f2;
              f8 = paramFloat2;
              f9 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("rm"))
            {
              f6 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f5 = f3;
              f7 = f1;
              f8 = paramFloat2;
              f9 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("bm"))
            {
              f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f6 = f2;
              f7 = f1;
              f8 = paramFloat2;
              f9 = paramFloat1;
            }
            else
            {
              f5 = f3;
              f6 = f2;
              f7 = f1;
              f8 = paramFloat2;
              f9 = paramFloat1;
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("gm"))
              {
                f4 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                f5 = f3;
                f6 = f2;
                f7 = f1;
                f8 = paramFloat2;
                f9 = paramFloat1;
              }
            }
          }
        }
        paramString.addParam(new UniformParam.FloatsParam("channelparam", new float[] { paramFloat1, paramFloat2, f1 }));
        paramString.addParam(new UniformParam.FloatsParam("mixparam", new float[] { f2, f4, f3 }));
        return paramString;
      }
      if (((String)localObject3).equals("MIC_BASE_MULTIPLYBLEND_2"))
      {
        paramString = new BaseFilter(BaseFilter.getFragmentShader(59));
        paramFloat1 = 0.9098039F;
        paramFloat2 = 0.8705882F;
        f1 = 0.8588235F;
        f2 = 1.0F;
        f3 = 0.55F;
        i = 0;
        if (i < paramBaseFilterMaterial.params.size())
        {
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("r"))
          {
            f7 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f6 = paramFloat2;
            f5 = f1;
            f4 = f2;
          }
          for (;;)
          {
            i += 1;
            f2 = f4;
            f1 = f5;
            paramFloat2 = f6;
            paramFloat1 = f7;
            break;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("g"))
            {
              f6 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f5 = f1;
              f7 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("b"))
            {
              f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f6 = paramFloat2;
              f7 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("a"))
            {
              f4 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f5 = f1;
              f6 = paramFloat2;
              f7 = paramFloat1;
            }
            else
            {
              f4 = f2;
              f5 = f1;
              f6 = paramFloat2;
              f7 = paramFloat1;
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("t"))
              {
                f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                f4 = f2;
                f5 = f1;
                f6 = paramFloat2;
                f7 = paramFloat1;
              }
            }
          }
        }
        paramString.addParam(new UniformParam.FloatsParam("color2", new float[] { paramFloat1, paramFloat2, f1, f2 }));
        paramString.addParam(new UniformParam.FloatParam("transparency", f3));
        return paramString;
      }
      if (((String)localObject3).equals("MIC_BASE_SCREENBLEND"))
      {
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(118));
        i = 0;
        while (i < paramBaseFilterMaterial.params.size())
        {
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("inputTextureImage"))
          {
            localObject2 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).type;
            ((BaseFilter)localObject1).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", cropMaterialBitmap(BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value), paramFloat1, paramFloat2, (String)localObject2), 33986, true));
          }
          i += 1;
        }
        return localObject1;
      }
      if (((String)localObject3).equals("MIC_BASE_SCREENBLEND_2"))
      {
        paramString = new BaseFilter(BaseFilter.getFragmentShader(56));
        paramFloat1 = 0.0627451F;
        paramFloat2 = 0.07058824F;
        f1 = 0.09019608F;
        f2 = 1.0F;
        f3 = 1.0F;
        i = 0;
        if (i < paramBaseFilterMaterial.params.size())
        {
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("r"))
          {
            f7 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f6 = paramFloat2;
            f5 = f1;
            f4 = f2;
          }
          for (;;)
          {
            i += 1;
            f2 = f4;
            f1 = f5;
            paramFloat2 = f6;
            paramFloat1 = f7;
            break;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("g"))
            {
              f6 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f5 = f1;
              f7 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("b"))
            {
              f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f6 = paramFloat2;
              f7 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("a"))
            {
              f4 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f5 = f1;
              f6 = paramFloat2;
              f7 = paramFloat1;
            }
            else
            {
              f4 = f2;
              f5 = f1;
              f6 = paramFloat2;
              f7 = paramFloat1;
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("t"))
              {
                f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                f4 = f2;
                f5 = f1;
                f6 = paramFloat2;
                f7 = paramFloat1;
              }
            }
          }
        }
        paramString.addParam(new UniformParam.FloatsParam("color2", new float[] { paramFloat1, paramFloat2, f1, f2 }));
        paramString.addParam(new UniformParam.FloatParam("transparency", f3));
        return paramString;
      }
      if (((String)localObject3).equals("MIC_BASE_MICCURVE"))
      {
        localObject1 = new BaseFilter(BaseFilter.getFragmentShader(97));
        paramFloat1 = 1.0F;
        paramFloat2 = 0.0F;
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = 0.0F;
        i = 0;
        if (i < paramBaseFilterMaterial.params.size())
        {
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("inputTextureImage"))
          {
            ((BaseFilter)localObject1).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value), 33986, true));
            f7 = paramFloat1;
            f6 = paramFloat2;
            f5 = f1;
            f4 = f2;
          }
          for (;;)
          {
            i += 1;
            f2 = f4;
            f1 = f5;
            paramFloat2 = f6;
            paramFloat1 = f7;
            break;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("quality"))
            {
              f7 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f5 = f1;
              f6 = paramFloat2;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("add_red"))
            {
              f6 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f5 = f1;
              f7 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("red_m"))
            {
              f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f6 = paramFloat2;
              f7 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("green_m"))
            {
              f4 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f5 = f1;
              f6 = paramFloat2;
              f7 = paramFloat1;
            }
            else
            {
              f4 = f2;
              f5 = f1;
              f6 = paramFloat2;
              f7 = paramFloat1;
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("blue_m"))
              {
                f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                f4 = f2;
                f5 = f1;
                f6 = paramFloat2;
                f7 = paramFloat1;
              }
            }
          }
        }
        ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("quality", paramFloat1));
        ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("add_red", paramFloat2));
        ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("red_m", f1));
        ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("green_m", f2));
        ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("blue_m", f3));
        return localObject1;
      }
      if (((String)localObject3).equals("MIC_BASE_LOOKUP"))
      {
        localObject1 = new GPUImageLookupFilter();
        i = 0;
        while (i < paramBaseFilterMaterial.params.size())
        {
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("inputTextureImage")) {
            ((BaseFilter)localObject1).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value), 33986, true));
          }
          i += 1;
        }
        return localObject1;
      }
      if (((String)localObject3).equals("MIC_BASE_DECONVSHARPEN"))
      {
        paramString = new BaibianFilter(0, null, 0.3F, 0.5F, 0.0F, 0.12F, 0.02F);
        i = 0;
        if (i < paramBaseFilterMaterial.params.size())
        {
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("strength"))
          {
            localObject1 = new HashMap();
            ((Map)localObject1).put("intensity", Float.valueOf(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value)));
            paramString.setParameterDic((Map)localObject1);
          }
          for (;;)
          {
            i += 1;
            break;
            if (!((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("amount")) {}
          }
        }
        return paramString;
      }
      if (((String)localObject3).equals("MIC_BASE_PORTRAITBEAUTY"))
      {
        int m = 1;
        k = 1;
        i = 0;
        while (i < paramBaseFilterMaterial.params.size())
        {
          j = m;
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("bSmooth"))
          {
            j = m;
            if ("NO".equals(((FilterParam)paramBaseFilterMaterial.params.get(i)).value)) {
              j = 0;
            }
          }
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("flag")) {
            k = Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
          }
          i += 1;
          m = j;
        }
        paramBaseFilterMaterial = new BeautysFilter(0, m);
        paramBaseFilterMaterial.setEffectIndex(k);
        return paramBaseFilterMaterial;
      }
      if (((String)localObject3).equals("MIC_BASE_COLORBALANCE"))
      {
        paramString = new BaseFilter(BaseFilter.getFragmentShader(57));
        localObject1 = new float[3];
        Object tmp2739_2737 = localObject1;
        tmp2739_2737[0] = 0.0F;
        Object tmp2743_2739 = tmp2739_2737;
        tmp2743_2739[1] = 0.0F;
        Object tmp2747_2743 = tmp2743_2739;
        tmp2747_2743[2] = 0.0F;
        tmp2747_2743;
        localObject2 = new float[3];
        Object tmp2759_2757 = localObject2;
        tmp2759_2757[0] = 0.0772549F;
        Object tmp2765_2759 = tmp2759_2757;
        tmp2765_2759[1] = 0.0F;
        Object tmp2769_2765 = tmp2765_2759;
        tmp2769_2765[2] = 0.0F;
        tmp2769_2765;
        localObject3 = new float[3];
        Object tmp2781_2779 = localObject3;
        tmp2781_2779[0] = 0.03905882F;
        Object tmp2787_2781 = tmp2781_2779;
        tmp2787_2781[1] = 0.0F;
        Object tmp2791_2787 = tmp2787_2781;
        tmp2791_2787[2] = 0.0F;
        tmp2791_2787;
        i = 0;
        while (i < paramBaseFilterMaterial.params.size())
        {
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("shadow"))
          {
            localObject4 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).value.split(",");
            j = 0;
            while ((j < localObject4.length) && (j < 3))
            {
              localObject1[j] = Float.parseFloat(localObject4[j]);
              j += 1;
            }
          }
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("midtone"))
          {
            localObject4 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).value.split(",");
            j = 0;
            while ((j < localObject4.length) && (j < 3))
            {
              localObject2[j] = Float.parseFloat(localObject4[j]);
              j += 1;
            }
          }
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("hilight"))
          {
            localObject4 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).value.split(",");
            j = 0;
            while ((j < localObject4.length) && (j < 3))
            {
              localObject3[j] = Float.parseFloat(localObject4[j]);
              j += 1;
            }
          }
          i += 1;
        }
        paramString.addParam(new UniformParam.FloatsParam("shadowsShift", (float[])localObject1));
        paramString.addParam(new UniformParam.FloatsParam("midtonesShift", (float[])localObject2));
        paramString.addParam(new UniformParam.FloatsParam("highlightsShift", (float[])localObject3));
        paramString.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        return paramString;
      }
      if (((String)localObject3).equals("MIC_BASE_HSVCOLORCHANNEL"))
      {
        f5 = 0.5F;
        f4 = 0.5F;
        f3 = 0.5F;
        f2 = -1.0F;
        f1 = -1.0F;
        paramFloat1 = -1.0F;
        paramFloat2 = -1.0F;
        paramString = new HSVColorChannelFilter();
        i = 0;
        if (i < paramBaseFilterMaterial.params.size())
        {
          float f11;
          float f10;
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("h"))
          {
            f6 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f11 = paramFloat1;
            f10 = f1;
            f9 = f2;
            f8 = f3;
            f7 = f4;
          }
          for (;;)
          {
            i += 1;
            f5 = f6;
            f4 = f7;
            f3 = f8;
            f2 = f9;
            f1 = f10;
            paramFloat1 = f11;
            break;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("s"))
            {
              f7 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f6 = f5;
              f8 = f3;
              f9 = f2;
              f10 = f1;
              f11 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("v"))
            {
              f8 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f6 = f5;
              f7 = f4;
              f9 = f2;
              f10 = f1;
              f11 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("lb"))
            {
              f9 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f6 = f5;
              f7 = f4;
              f8 = f3;
              f10 = f1;
              f11 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("ld"))
            {
              f10 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f6 = f5;
              f7 = f4;
              f8 = f3;
              f9 = f2;
              f11 = paramFloat1;
            }
            else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("rd"))
            {
              f11 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f6 = f5;
              f7 = f4;
              f8 = f3;
              f9 = f2;
              f10 = f1;
            }
            else
            {
              f6 = f5;
              f7 = f4;
              f8 = f3;
              f9 = f2;
              f10 = f1;
              f11 = paramFloat1;
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("rb"))
              {
                paramFloat2 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                f6 = f5;
                f7 = f4;
                f8 = f3;
                f9 = f2;
                f10 = f1;
                f11 = paramFloat1;
              }
            }
          }
        }
        ((HSVColorChannelFilter)paramString).setInput(f5, f4, f3, f2, f1, paramFloat1, paramFloat2);
        return paramString;
      }
      if (((String)localObject3).equals("MIC_BASE_HSV2"))
      {
        paramString = new BaseFilter(BaseFilter.getFragmentShader(108));
        paramFloat1 = 1.0F;
        paramFloat2 = 1.0F;
        f1 = 0.953F;
        i = 0;
        if (i < paramBaseFilterMaterial.params.size())
        {
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("h"))
          {
            f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f2 = paramFloat2;
          }
          for (;;)
          {
            i += 1;
            paramFloat2 = f2;
            paramFloat1 = f3;
            break;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("s"))
            {
              f2 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f3 = paramFloat1;
            }
            else
            {
              f2 = paramFloat2;
              f3 = paramFloat1;
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("v"))
              {
                f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                f2 = paramFloat2;
                f3 = paramFloat1;
              }
            }
          }
        }
        paramString.addParam(new UniformParam.FloatParam("inputH", paramFloat1));
        paramString.addParam(new UniformParam.FloatParam("inputS", paramFloat2));
        paramString.addParam(new UniformParam.FloatParam("inputV", f1));
        return paramString;
      }
      if (!((String)localObject3).equals("MIC_BASE_CURVE2D")) {
        break;
      }
      localObject3 = new float[16];
      Object tmp4097_4095 = localObject3;
      tmp4097_4095[0] = 0.0F;
      Object tmp4101_4097 = tmp4097_4095;
      tmp4101_4097[1] = 0.0F;
      Object tmp4105_4101 = tmp4101_4097;
      tmp4105_4101[2] = 0.0F;
      Object tmp4109_4105 = tmp4105_4101;
      tmp4109_4105[3] = 0.0F;
      Object tmp4113_4109 = tmp4109_4105;
      tmp4113_4109[4] = 0.0F;
      Object tmp4117_4113 = tmp4113_4109;
      tmp4117_4113[5] = 0.0F;
      Object tmp4121_4117 = tmp4117_4113;
      tmp4121_4117[6] = 0.0F;
      Object tmp4126_4121 = tmp4121_4117;
      tmp4126_4121[7] = 0.0F;
      Object tmp4131_4126 = tmp4126_4121;
      tmp4131_4126[8] = 0.0F;
      Object tmp4136_4131 = tmp4131_4126;
      tmp4136_4131[9] = 0.0F;
      Object tmp4141_4136 = tmp4136_4131;
      tmp4141_4136[10] = 0.0F;
      Object tmp4146_4141 = tmp4141_4136;
      tmp4146_4141[11] = 0.0F;
      Object tmp4151_4146 = tmp4146_4141;
      tmp4151_4146[12] = 0.0F;
      Object tmp4156_4151 = tmp4151_4146;
      tmp4156_4151[13] = 0.0F;
      Object tmp4161_4156 = tmp4156_4151;
      tmp4161_4156[14] = 0.0F;
      Object tmp4166_4161 = tmp4161_4156;
      tmp4166_4161[15] = 0.0F;
      tmp4166_4161;
      localObject2 = new Curve2D();
      i = 0;
      localObject1 = localObject2;
    } while (i >= paramBaseFilterMaterial.params.size());
    if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("inputTextureImage")) {
      ((BaseFilter)localObject2).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value), 33986, true));
    }
    for (;;)
    {
      i += 1;
      break;
      if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("matrix"))
      {
        localObject1 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).value.split(",");
        j = 0;
        while ((j < localObject1.length) && (j < localObject3.length))
        {
          localObject3[j] = Float.parseFloat(localObject1[j]);
          j += 1;
        }
        ((Curve2D)localObject2).setMatrix((float[])localObject3);
      }
    }
    if (((String)localObject3).equals("MIC_BASE_OVERLAYBLEND2"))
    {
      paramString = new BaseFilter(BaseFilter.getFragmentShader(115));
      paramFloat1 = 0.0F;
      paramFloat2 = 0.0F;
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      i = 0;
      if (i < paramBaseFilterMaterial.params.size())
      {
        if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("r"))
        {
          f7 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
          f6 = paramFloat2;
          f5 = f1;
          f4 = f2;
        }
        for (;;)
        {
          i += 1;
          f2 = f4;
          f1 = f5;
          paramFloat2 = f6;
          paramFloat1 = f7;
          break;
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("g"))
          {
            f6 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f4 = f2;
            f5 = f1;
            f7 = paramFloat1;
          }
          else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("b"))
          {
            f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f4 = f2;
            f6 = paramFloat2;
            f7 = paramFloat1;
          }
          else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("a"))
          {
            f4 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f5 = f1;
            f6 = paramFloat2;
            f7 = paramFloat1;
          }
          else
          {
            f4 = f2;
            f5 = f1;
            f6 = paramFloat2;
            f7 = paramFloat1;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("t"))
            {
              f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f5 = f1;
              f6 = paramFloat2;
              f7 = paramFloat1;
            }
          }
        }
      }
      paramString.addParam(new UniformParam.FloatsParam("color2", new float[] { paramFloat1, paramFloat2, f1, f2 }));
      paramString.addParam(new UniformParam.FloatParam("transparency", f3));
      return paramString;
    }
    if (((String)localObject3).equals("MIC_BASE_SATURATION"))
    {
      paramString = new BaseFilter(BaseFilter.getFragmentShader(31));
      paramFloat1 = 1.25F;
      i = 0;
      while (i < paramBaseFilterMaterial.params.size())
      {
        if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("saturation")) {
          paramFloat1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
        }
        i += 1;
      }
      paramString.addParam(new UniformParam.FloatParam("saturation", paramFloat1));
      return paramString;
    }
    if (((String)localObject3).equals("MIC_BASE_HSV"))
    {
      paramString = new BaseFilter(BaseFilter.getFragmentShader(60));
      paramFloat1 = 0.0F;
      paramFloat2 = 0.0F;
      f1 = 0.0F;
      i = 0;
      if (i < paramBaseFilterMaterial.params.size())
      {
        if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("h"))
        {
          f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
          f2 = paramFloat2;
        }
        for (;;)
        {
          i += 1;
          paramFloat2 = f2;
          paramFloat1 = f3;
          break;
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("s"))
          {
            f2 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f3 = paramFloat1;
          }
          else
          {
            f2 = paramFloat2;
            f3 = paramFloat1;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("v"))
            {
              f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f2 = paramFloat2;
              f3 = paramFloat1;
            }
          }
        }
      }
      paramString.addParam(new UniformParam.FloatParam("inputH", paramFloat1));
      paramString.addParam(new UniformParam.FloatParam("inputS", paramFloat2));
      paramString.addParam(new UniformParam.FloatParam("inputV", f1));
      return paramString;
    }
    if (((String)localObject3).equals("MIC_BASE_TEMP"))
    {
      paramString = new BaseFilter(BaseFilter.getFragmentShader(55));
      paramFloat1 = 0.0F;
      paramFloat2 = 0.0F;
      i = 0;
      if (i < paramBaseFilterMaterial.params.size())
      {
        if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("scaleC")) {
          f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
        }
        for (;;)
        {
          i += 1;
          paramFloat1 = f1;
          break;
          f1 = paramFloat1;
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("scaleT"))
          {
            paramFloat2 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f1 = paramFloat1;
          }
        }
      }
      paramString.addParam(new UniformParam.FloatParam("scaleC", paramFloat1));
      paramString.addParam(new UniformParam.FloatParam("scaleT", paramFloat2));
      return paramString;
    }
    if (((String)localObject3).equals("MIC_BASE_CONTRAST"))
    {
      paramString = new BaseFilter(BaseFilter.getFragmentShader(13));
      paramFloat1 = 1.0F;
      paramFloat2 = 1.0F;
      f1 = 1.0F;
      i = 0;
      if (i < paramBaseFilterMaterial.params.size())
      {
        if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("contrast"))
        {
          f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
          f2 = paramFloat2;
        }
        for (;;)
        {
          i += 1;
          paramFloat2 = f2;
          paramFloat1 = f3;
          break;
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("saturation"))
          {
            f2 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f3 = paramFloat1;
          }
          else
          {
            f2 = paramFloat2;
            f3 = paramFloat1;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("brightness"))
            {
              f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f2 = paramFloat2;
              f3 = paramFloat1;
            }
          }
        }
      }
      paramString.addParam(new UniformParam.FloatParam("contrast", paramFloat1));
      paramString.addParam(new UniformParam.FloatParam("saturation", paramFloat2));
      paramString.addParam(new UniformParam.FloatParam("brightness", f1));
      return paramString;
    }
    if (((String)localObject3).equals("MIC_BASE_SOFTLIGHTBLEND2"))
    {
      paramString = new BaseFilter(BaseFilter.getFragmentShader(116));
      paramFloat1 = 0.0F;
      paramFloat2 = 0.0F;
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      i = 0;
      if (i < paramBaseFilterMaterial.params.size())
      {
        if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("r"))
        {
          f7 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
          f6 = paramFloat2;
          f5 = f1;
          f4 = f2;
        }
        for (;;)
        {
          i += 1;
          f2 = f4;
          f1 = f5;
          paramFloat2 = f6;
          paramFloat1 = f7;
          break;
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("g"))
          {
            f6 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f4 = f2;
            f5 = f1;
            f7 = paramFloat1;
          }
          else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("b"))
          {
            f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f4 = f2;
            f6 = paramFloat2;
            f7 = paramFloat1;
          }
          else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("a"))
          {
            f4 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f5 = f1;
            f6 = paramFloat2;
            f7 = paramFloat1;
          }
          else
          {
            f4 = f2;
            f5 = f1;
            f6 = paramFloat2;
            f7 = paramFloat1;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("t"))
            {
              f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f5 = f1;
              f6 = paramFloat2;
              f7 = paramFloat1;
            }
          }
        }
      }
      paramString.addParam(new UniformParam.FloatsParam("color2", new float[] { paramFloat1, paramFloat2, f1, f2 }));
      paramString.addParam(new UniformParam.FloatParam("transparency", f3));
      return paramString;
    }
    if (((String)localObject3).equals("MIC_BASE_SOFTLIGHTBLEND"))
    {
      localObject1 = new BaseFilter(BaseFilter.getFragmentShader(61));
      i = 0;
      while (i < paramBaseFilterMaterial.params.size())
      {
        if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("inputTextureImage1"))
        {
          localObject2 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).type;
          ((BaseFilter)localObject1).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", cropMaterialBitmap(BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value), paramFloat1, paramFloat2, (String)localObject2), 33986, true));
        }
        i += 1;
      }
      return localObject1;
    }
    if (((String)localObject3).equals("MIC_BASE_DARKENBLEND2"))
    {
      paramString = new BaseFilter(BaseFilter.getFragmentShader(63));
      paramFloat1 = 0.0F;
      paramFloat2 = 0.0F;
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      i = 0;
      if (i < paramBaseFilterMaterial.params.size())
      {
        if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("r"))
        {
          f7 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
          f6 = paramFloat2;
          f5 = f1;
          f4 = f2;
        }
        for (;;)
        {
          i += 1;
          f2 = f4;
          f1 = f5;
          paramFloat2 = f6;
          paramFloat1 = f7;
          break;
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("g"))
          {
            f6 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f4 = f2;
            f5 = f1;
            f7 = paramFloat1;
          }
          else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("b"))
          {
            f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f4 = f2;
            f6 = paramFloat2;
            f7 = paramFloat1;
          }
          else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("a"))
          {
            f4 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
            f5 = f1;
            f6 = paramFloat2;
            f7 = paramFloat1;
          }
          else
          {
            f4 = f2;
            f5 = f1;
            f6 = paramFloat2;
            f7 = paramFloat1;
            if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("t"))
            {
              f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              f4 = f2;
              f5 = f1;
              f6 = paramFloat2;
              f7 = paramFloat1;
            }
          }
        }
      }
      paramString.addParam(new UniformParam.FloatsParam("color3", new float[] { paramFloat1, paramFloat2, f1, f2 }));
      paramString.addParam(new UniformParam.FloatParam("transparency", f3));
      return paramString;
    }
    if (((String)localObject3).equals("MIC_BASE_MICCURVE2"))
    {
      localObject1 = new BaseFilter(BaseFilter.getFragmentShader(107));
      i = 0;
      if (i < paramBaseFilterMaterial.params.size())
      {
        if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("inputTextureImage")) {
          ((BaseFilter)localObject1).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value), 33986, true));
        }
        for (;;)
        {
          i += 1;
          break;
          if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("inputTextureImage2")) {
            ((BaseFilter)localObject1).addParam(new UniformParam.TextureBitmapParam("inputImageTexture3", BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value), 33987, true));
          }
        }
      }
      return localObject1;
    }
    if (((String)localObject3).equals("MIC_BASE_LEVELS"))
    {
      i = 0;
      paramFloat1 = 0.0F;
      paramFloat2 = 0.0F;
      f1 = 0.0F;
      f3 = 0.0F;
      f2 = 1.0F;
      localObject1 = "";
      localObject2 = "";
      j = 0;
      label7073:
      if (j < paramBaseFilterMaterial.params.size()) {
        if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("type"))
        {
          i = Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(j)).value);
          f4 = f2;
          f5 = f3;
          localObject3 = localObject2;
          f3 = paramFloat1;
          f2 = paramFloat2;
          paramFloat2 = f5;
          paramFloat1 = f4;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      j += 1;
      f4 = f3;
      f5 = f2;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      f2 = paramFloat1;
      f3 = paramFloat2;
      paramFloat2 = f5;
      paramFloat1 = f4;
      break label7073;
      if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("min"))
      {
        f4 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(j)).value);
        paramFloat1 = f2;
        f2 = paramFloat2;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        paramFloat2 = f3;
        f3 = f4;
      }
      else if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("mid"))
      {
        f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(j)).value);
        f4 = paramFloat1;
        paramFloat2 = f3;
        f3 = f5;
        localObject3 = localObject1;
        paramFloat1 = f2;
        localObject1 = localObject2;
        localObject2 = localObject3;
        f2 = f3;
        f3 = f4;
      }
      else if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("max"))
      {
        f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(j)).value);
        f4 = paramFloat2;
        f5 = paramFloat1;
        localObject3 = localObject1;
        paramFloat1 = f2;
        paramFloat2 = f3;
        localObject1 = localObject2;
        localObject2 = localObject3;
        f2 = f4;
        f3 = f5;
      }
      else if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("minOut"))
      {
        f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(j)).value);
        f3 = paramFloat2;
        f4 = paramFloat1;
        localObject3 = localObject1;
        paramFloat1 = f2;
        paramFloat2 = f5;
        localObject1 = localObject2;
        localObject2 = localObject3;
        f2 = f3;
        f3 = f4;
      }
      else if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("maxOut"))
      {
        f5 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(j)).value);
        f2 = paramFloat2;
        f4 = paramFloat1;
        localObject3 = localObject1;
        paramFloat1 = f5;
        localObject1 = localObject2;
        localObject2 = localObject3;
        paramFloat2 = f3;
        f3 = f4;
      }
      else if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("channel"))
      {
        localObject3 = ((FilterParam)paramBaseFilterMaterial.params.get(j)).value;
        f4 = paramFloat2;
        f5 = paramFloat1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        paramFloat1 = f2;
        paramFloat2 = f3;
        f2 = f4;
        f3 = f5;
      }
      else if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("inputTextureImage1"))
      {
        localObject3 = paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(j)).value;
        localObject2 = localObject1;
        f4 = paramFloat2;
        f5 = paramFloat1;
        localObject1 = localObject3;
        paramFloat1 = f2;
        paramFloat2 = f3;
        f2 = f4;
        f3 = f5;
        continue;
        float[] arrayOfFloat;
        if (i == 0)
        {
          paramBaseFilterMaterial = new BaseFilter(BaseFilter.getFragmentShader(109));
          if (((String)localObject2).length() > 0) {
            paramBaseFilterMaterial.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), (String)localObject2), 33986, true));
          }
          paramString = new float[3];
          String tmp7844_7843 = paramString;
          tmp7844_7843[0] = 0.0F;
          String tmp7848_7844 = tmp7844_7843;
          tmp7848_7844[1] = 0.0F;
          String tmp7852_7848 = tmp7848_7844;
          tmp7852_7848[2] = 0.0F;
          tmp7852_7848;
          localObject2 = new float[3];
          Object tmp7864_7862 = localObject2;
          tmp7864_7862[0] = 0.3F;
          Object tmp7869_7864 = tmp7864_7862;
          tmp7869_7864[1] = 0.3F;
          Object tmp7874_7869 = tmp7869_7864;
          tmp7874_7869[2] = 0.3F;
          tmp7874_7869;
          localObject3 = new float[3];
          Object tmp7887_7885 = localObject3;
          tmp7887_7885[0] = 1.0F;
          Object tmp7891_7887 = tmp7887_7885;
          tmp7891_7887[1] = 1.0F;
          Object tmp7895_7891 = tmp7891_7887;
          tmp7895_7891[2] = 1.0F;
          tmp7895_7891;
          localObject4 = new float[3];
          Object tmp7907_7905 = localObject4;
          tmp7907_7905[0] = 0.0F;
          Object tmp7911_7907 = tmp7907_7905;
          tmp7911_7907[1] = 0.0F;
          Object tmp7915_7911 = tmp7911_7907;
          tmp7915_7911[2] = 0.0F;
          tmp7915_7911;
          arrayOfFloat = new float[3];
          float[] tmp7927_7925 = arrayOfFloat;
          tmp7927_7925[0] = 1.0F;
          float[] tmp7931_7927 = tmp7927_7925;
          tmp7931_7927[1] = 1.0F;
          float[] tmp7935_7931 = tmp7931_7927;
          tmp7935_7931[2] = 1.0F;
          tmp7935_7931;
          if (!((String)localObject1).equals("red")) {
            break label8080;
          }
          paramString[0] = paramFloat1;
          localObject2[0] = paramFloat2;
          localObject3[0] = f1;
          localObject4[0] = f3;
          arrayOfFloat[0] = f2;
        }
        for (;;)
        {
          paramBaseFilterMaterial.addParam(new UniformParam.FloatsParam("levelMinimum", paramString));
          paramBaseFilterMaterial.addParam(new UniformParam.FloatsParam("levelMiddle", (float[])localObject2));
          paramBaseFilterMaterial.addParam(new UniformParam.FloatsParam("levelMaximum", (float[])localObject3));
          paramBaseFilterMaterial.addParam(new UniformParam.FloatsParam("minOutput", (float[])localObject4));
          paramBaseFilterMaterial.addParam(new UniformParam.FloatsParam("maxOutput", arrayOfFloat));
          return paramBaseFilterMaterial;
          paramBaseFilterMaterial = new BaseFilter(BaseFilter.getFragmentShader(125));
          break;
          label8080:
          if (((String)localObject1).equals("green"))
          {
            paramString[1] = paramFloat1;
            localObject2[1] = paramFloat2;
            localObject3[1] = f1;
            localObject4[1] = f3;
            arrayOfFloat[1] = f2;
          }
          else if (((String)localObject1).equals("blue"))
          {
            paramString[2] = paramFloat1;
            localObject2[2] = paramFloat2;
            localObject3[2] = f1;
            localObject4[2] = f3;
            arrayOfFloat[2] = f2;
          }
          else if (((String)localObject1).equals("all"))
          {
            paramString[2] = paramFloat1;
            paramString[1] = paramFloat1;
            paramString[0] = paramFloat1;
            localObject2[2] = paramFloat2;
            localObject2[1] = paramFloat2;
            localObject2[0] = paramFloat2;
            localObject3[2] = f1;
            localObject3[1] = f1;
            localObject3[0] = f1;
            localObject4[2] = f3;
            localObject4[1] = f3;
            localObject4[0] = f3;
            arrayOfFloat[2] = f2;
            arrayOfFloat[1] = f2;
            arrayOfFloat[0] = f2;
          }
        }
        if (((String)localObject3).equals("MIC_BASE_FLARES"))
        {
          i = 0;
          j = 0;
          while (j < paramBaseFilterMaterial.params.size())
          {
            if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("index")) {
              i = Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(j)).value);
            }
            if (((FilterParam)paramBaseFilterMaterial.params.get(j)).name.equals("effectIndex")) {
              i = Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(j)).value);
            }
            j += 1;
          }
          return new FlaresFilter(i);
        }
        if (((String)localObject3).equals("MIC_BASE_SNOWBLEND"))
        {
          paramString = new BaseFilter("precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float param;\n void main(void)\n {\n     vec4 color  = texture2D(inputImageTexture, textureCoordinate);\n     vec4 color2 = texture2D(inputImageTexture2, textureCoordinate);\n     vec3 ret=color.rgb+color2.rgb*param;\n     gl_FragColor = vec4(ret.rgb,1.0);\n }\n");
          f1 = 0.35F;
          i = 0;
          label8433:
          if (i < paramBaseFilterMaterial.params.size())
          {
            if (!((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("param")) {
              break label13791;
            }
            f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
          }
        }
        label9662:
        label9922:
        label13782:
        label13788:
        label13791:
        for (;;)
        {
          i += 1;
          break label8433;
          paramString.addParam(new TextureResParam("inputImageTexture2", "sh/snow.png", 33986, paramFloat1 / paramFloat2));
          paramString.addParam(new UniformParam.FloatParam("param", f1));
          return paramString;
          if (((String)localObject3).equals("MIC_BASE_HISTOGRAM")) {
            return new BaseFilter(BaseFilter.getFragmentShader(0));
          }
          if (((String)localObject3).equals("MIC_BASE_HISTOGRAMSTRETCH"))
          {
            paramFloat1 = 0.001F;
            paramFloat2 = 0.999F;
            i = 0;
            if (i < paramBaseFilterMaterial.params.size())
            {
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("min")) {
                f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              }
              for (;;)
              {
                i += 1;
                paramFloat1 = f1;
                break;
                f1 = paramFloat1;
                if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("max"))
                {
                  paramFloat2 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  f1 = paramFloat1;
                }
              }
            }
            return new HistogramsStrectchFilter(paramFloat1, paramFloat2);
          }
          if (((String)localObject3).equals("MIC_BASE_SATURATIONCONTRAST"))
          {
            paramString = new BaseFilter(BaseFilter.getFragmentShader(13));
            paramFloat1 = 1.0F;
            paramFloat2 = 1.0F;
            f1 = 1.0F;
            i = 0;
            if (i < paramBaseFilterMaterial.params.size())
            {
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("c"))
              {
                f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                f2 = paramFloat2;
              }
              for (;;)
              {
                i += 1;
                paramFloat2 = f2;
                paramFloat1 = f3;
                break;
                if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("s"))
                {
                  f2 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  f3 = paramFloat1;
                }
                else
                {
                  f2 = paramFloat2;
                  f3 = paramFloat1;
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("brightness"))
                  {
                    f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                    f2 = paramFloat2;
                    f3 = paramFloat1;
                  }
                }
              }
            }
            paramString.addParam(new UniformParam.FloatParam("contrast", paramFloat1));
            paramString.addParam(new UniformParam.FloatParam("saturation", paramFloat2));
            paramString.addParam(new UniformParam.FloatParam("brightness", f1));
            return paramString;
          }
          if (((String)localObject3).equals("MIC_BASE_CHANNELSHARPEN"))
          {
            paramString = new BaseFilter(BaseFilter.getVertexShader(2), BaseFilter.getFragmentShader(33));
            paramFloat1 = 0.377F;
            i = 0;
            if (i < paramBaseFilterMaterial.params.size())
            {
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("step")) {
                Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              }
              for (;;)
              {
                i += 1;
                break;
                if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("s")) {
                  paramFloat1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                }
              }
            }
            paramString.addParam(new UniformParam.FloatParam("sharpness", paramFloat1));
            return paramString;
          }
          if (((String)localObject3).equals("MIC_BASE_CHANNELSTRETCH2"))
          {
            paramString = new ChannelStretchFilter3(Math.min(400.0F / Math.min(paramFloat2, paramFloat1), 1.0F));
            paramFloat1 = 24.4F;
            paramFloat2 = 26.700001F;
            i = 0;
            if (i < paramBaseFilterMaterial.params.size())
            {
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("hightlight"))
              {
                f2 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                f1 = paramFloat2;
              }
              for (;;)
              {
                i += 1;
                paramFloat2 = f1;
                paramFloat1 = f2;
                break;
                if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("shadow"))
                {
                  f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  f2 = paramFloat1;
                }
                else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("contrast"))
                {
                  Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  f1 = paramFloat2;
                  f2 = paramFloat1;
                }
                else
                {
                  f1 = paramFloat2;
                  f2 = paramFloat1;
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("saturation"))
                  {
                    Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                    f1 = paramFloat2;
                    f2 = paramFloat1;
                  }
                }
              }
            }
            paramString.addParam(new UniformParam.FloatParam("strength", 50.0F));
            paramString.addParam(new UniformParam.FloatParam("highlight", paramFloat1));
            paramString.addParam(new UniformParam.FloatParam("shadow", paramFloat2));
            return paramString;
          }
          if (((String)localObject3).equals("MIC_BASE_CHANNELSTRETCH"))
          {
            Math.min(paramFloat2, paramFloat1);
            paramString = new HDRHSVFilter.ChannelStretchFilter();
            paramFloat1 = 25.0F;
            i = 0;
            while (i < paramBaseFilterMaterial.params.size())
            {
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("strength")) {
                paramFloat1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              }
              i += 1;
            }
            ((HDRHSVFilter.ChannelStretchFilter)paramString).updateparam(paramFloat1);
            return paramString;
          }
          if (((String)localObject3).equals("MIC_BASE_SHADER"))
          {
            localObject1 = "";
            i = 0;
            if (i < paramBaseFilterMaterial.params.size())
            {
              if (!((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("shader")) {
                break label13788;
              }
              localObject1 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).value;
            }
          }
          for (;;)
          {
            i += 1;
            break label9662;
            localObject1 = new BaseFilter((String)localObject1);
            i = 0;
            if (i < paramBaseFilterMaterial.params.size())
            {
              if (((FilterParam)paramBaseFilterMaterial.params.get(i)).type.equals("int")) {
                ((BaseFilter)localObject1).addParam(new UniformParam.IntParam(((FilterParam)paramBaseFilterMaterial.params.get(i)).name, Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value)));
              }
              label9834:
              do
              {
                for (;;)
                {
                  i += 1;
                  break;
                  if (!((FilterParam)paramBaseFilterMaterial.params.get(i)).type.equals("float")) {
                    break label9922;
                  }
                  ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam(((FilterParam)paramBaseFilterMaterial.params.get(i)).name, Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value)));
                }
              } while (!((FilterParam)paramBaseFilterMaterial.params.get(i)).type.equals("image"));
              localObject2 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).name.substring("inputTextureImage".length());
              if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
                break label13782;
              }
            }
            for (j = Integer.parseInt((String)localObject2);; j = 2)
            {
              localObject2 = BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
              ((BaseFilter)localObject1).addParam(new UniformParam.TextureBitmapParam("inputImageTexture" + Integer.toString(j), (Bitmap)localObject2, j + 33984, true));
              break label9834;
              ((BaseFilter)localObject1).addParam(new UniformParam.IntParam("width", (int)paramFloat1));
              ((BaseFilter)localObject1).addParam(new UniformParam.IntParam("height", (int)paramFloat2));
              return localObject1;
              if (((String)localObject3).equals("MIC_CPU_OILPAINTPRO"))
              {
                j = 0;
                i = 0;
                while (i < paramBaseFilterMaterial.params.size())
                {
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("flag")) {
                    j = Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  }
                  i += 1;
                }
                return new OilPaintFilter(j);
              }
              if (((String)localObject3).equals("MIC_CPU_NIGHTENHANCE")) {
                return new NightFilter();
              }
              if (((String)localObject3).equals("MIC_MULTICONNECT_PORTRAITBEAUTY"))
              {
                k = 1;
                j = 1;
                i = 0;
                while (i < paramBaseFilterMaterial.params.size())
                {
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("bSmooth")) {
                    k = Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  }
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("flag")) {
                    j = Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  }
                  i += 1;
                }
                paramBaseFilterMaterial = new BeautysFilter(0, k);
                paramBaseFilterMaterial.setEffectIndex(j);
                return paramBaseFilterMaterial;
              }
              if (((String)localObject3).equals("MIC_MULTICONNECT_NEWPRINT"))
              {
                j = 0;
                i = 0;
                while (i < paramBaseFilterMaterial.params.size())
                {
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("t")) {
                    j = Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  }
                  i += 1;
                }
                return new CartoonFilter(j);
              }
              if (((String)localObject3).equals("MIC_MULTICONNECT_GLOW"))
              {
                paramString = new HDRHSVFilter();
                paramFloat2 = 25.0F;
                paramFloat1 = 0.3F;
                f1 = 1.3F;
                f2 = 0.001F;
                i = 0;
                if (i < paramBaseFilterMaterial.params.size())
                {
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("strength"))
                  {
                    paramFloat2 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                    f4 = f1;
                    f3 = f2;
                  }
                  for (;;)
                  {
                    i += 1;
                    f2 = f3;
                    f1 = f4;
                    break;
                    if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("sharpeness"))
                    {
                      paramFloat1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                      f3 = f2;
                      f4 = f1;
                    }
                    else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("saturation"))
                    {
                      f4 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                      f3 = f2;
                    }
                    else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("percent"))
                    {
                      f3 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                      f4 = f1;
                    }
                    else
                    {
                      f3 = f2;
                      f4 = f1;
                      if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("p"))
                      {
                        paramFloat1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                        paramFloat2 = 50.0F * paramFloat1;
                        paramFloat1 = 0.6F * paramFloat1;
                        f3 = f2;
                        f4 = f1;
                      }
                    }
                  }
                }
                paramBaseFilterMaterial = new HashMap();
                paramBaseFilterMaterial.put("stretechMag", Float.valueOf(paramFloat2));
                paramBaseFilterMaterial.put("sharpnessMag", Float.valueOf(paramFloat1));
                paramBaseFilterMaterial.put("saturationMag", Float.valueOf(f1));
                paramBaseFilterMaterial.put("percent", Float.valueOf(f2));
                paramString.setParameterDic(paramBaseFilterMaterial);
                return paramString;
              }
              if (((String)localObject3).equals("MIC_BASE_GPUSHARPEN"))
              {
                paramString = new IOSSharpenFilter();
                i = 0;
                for (;;)
                {
                  localObject1 = paramString;
                  if (i >= paramBaseFilterMaterial.params.size()) {
                    break;
                  }
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("sharpeness")) {
                    ((IOSSharpenFilter)paramString).setSharpness(Float.valueOf(((FilterParam)paramBaseFilterMaterial.params.get(i)).value).floatValue());
                  }
                  i += 1;
                }
              }
              if (((String)localObject3).equals("MIC_BASE_MULTIPLYBLEND"))
              {
                localObject1 = new BaseFilter(BaseFilter.getFragmentShader(117));
                f1 = 1.0F;
                i = 0;
                while (i < paramBaseFilterMaterial.params.size())
                {
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("inputTextureImage"))
                  {
                    localObject2 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).type;
                    ((BaseFilter)localObject1).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", cropMaterialBitmap(BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value), paramFloat1, paramFloat2, (String)localObject2), 33986, true));
                  }
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("t")) {
                    f1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  }
                  i += 1;
                }
                ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("transparency", f1));
                return localObject1;
              }
              if (((String)localObject3).equals("MIC_BASE_ALPHAFACEMASK"))
              {
                paramString = new AlphaFaceMaskFilter();
                boolean bool1 = true;
                j = 1;
                i = 0;
                if (i < paramBaseFilterMaterial.params.size())
                {
                  boolean bool2;
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("internalFaceDetect"))
                  {
                    k = j;
                    bool2 = bool1;
                    if ("NO".equals(((FilterParam)paramBaseFilterMaterial.params.get(i)).value))
                    {
                      bool2 = false;
                      k = j;
                    }
                  }
                  for (;;)
                  {
                    i += 1;
                    j = k;
                    bool1 = bool2;
                    break;
                    k = j;
                    bool2 = bool1;
                    if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("maskInterior"))
                    {
                      k = j;
                      bool2 = bool1;
                      if ("NO".equals(((FilterParam)paramBaseFilterMaterial.params.get(i)).value))
                      {
                        k = 0;
                        bool2 = bool1;
                      }
                    }
                  }
                }
                ((AlphaFaceMaskFilter)paramString).setInternalFaceDetect(bool1, null);
                ((AlphaFaceMaskFilter)paramString).setMaskInterior(j);
                return paramString;
              }
              if (((String)localObject3).equals("MIC_BASE_CHANNELTRANSLATE"))
              {
                paramString = new ChannelTranslateFilter();
                i = 0;
                localObject1 = paramString;
                if (i >= paramBaseFilterMaterial.params.size()) {
                  break;
                }
                localObject1 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).name;
                if (((String)localObject1).equals("redX")) {
                  ((ChannelTranslateFilter)paramString).setRedX(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (((String)localObject1).equals("redY")) {
                    ((ChannelTranslateFilter)paramString).setRedY(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("greenX")) {
                    ((ChannelTranslateFilter)paramString).setGreenX(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("greenY")) {
                    ((ChannelTranslateFilter)paramString).setGreenY(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("blueX")) {
                    ((ChannelTranslateFilter)paramString).setBlueX(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("blueY")) {
                    ((ChannelTranslateFilter)paramString).setBlueY(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("face")) {
                    ((ChannelTranslateFilter)paramString).setExceptFace(Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  }
                }
              }
              if (((String)localObject3).equals("MIC_BASE_CHANNELSCALE"))
              {
                paramString = new ChannelScaleFilter();
                i = 0;
                localObject1 = paramString;
                if (i >= paramBaseFilterMaterial.params.size()) {
                  break;
                }
                localObject1 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).name;
                if (((String)localObject1).equals("redCenterX")) {
                  ((ChannelScaleFilter)paramString).setRedCenterX(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (((String)localObject1).equals("redCenterY")) {
                    ((ChannelScaleFilter)paramString).setRedCenterY(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("redScaleX")) {
                    ((ChannelScaleFilter)paramString).setRedScaleX(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("redScaleY")) {
                    ((ChannelScaleFilter)paramString).setRedScaleY(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("greenCenterX")) {
                    ((ChannelScaleFilter)paramString).setGreenCenterX(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("greenCenterY")) {
                    ((ChannelScaleFilter)paramString).setGreenCenterY(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("greenScaleX")) {
                    ((ChannelScaleFilter)paramString).setGreenScaleX(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("greenScaleY")) {
                    ((ChannelScaleFilter)paramString).setGreenScaleY(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("blueCenterX")) {
                    ((ChannelScaleFilter)paramString).setBlueCenterX(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("blueCenterY")) {
                    ((ChannelScaleFilter)paramString).setBlueCenterY(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("blueScaleX")) {
                    ((ChannelScaleFilter)paramString).setBlueScaleX(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("blueScaleY")) {
                    ((ChannelScaleFilter)paramString).setBlueScaleY(Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  } else if (((String)localObject1).equals("face")) {
                    ((ChannelScaleFilter)paramString).setExceptFace(Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  }
                }
              }
              if (((String)localObject3).equals("MIC_BASE_ZQB3"))
              {
                paramString = new ZQB3Filter(paramString);
                i = 0;
                for (;;)
                {
                  localObject1 = paramString;
                  if (i >= paramBaseFilterMaterial.params.size()) {
                    break;
                  }
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("face")) {
                    ((ZQB3Filter)paramString).setExceptFace(Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  }
                  i += 1;
                }
              }
              if (((String)localObject3).equals("MIC_BASE_DISLOCATION"))
              {
                paramString = new DislocationFilter();
                i = 0;
                while (i < paramBaseFilterMaterial.params.size())
                {
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("location"))
                  {
                    localObject1 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).value.split(",");
                    if (localObject1.length >= 6)
                    {
                      paramFloat1 = Float.parseFloat(localObject1[0]);
                      paramFloat2 = Float.parseFloat(localObject1[1]);
                      f1 = Float.parseFloat(localObject1[2]);
                      f2 = Float.parseFloat(localObject1[3]);
                      f3 = Float.parseFloat(localObject1[4]);
                      f4 = Float.parseFloat(localObject1[5]);
                      ((DislocationFilter)paramString).addLocation(paramFloat1, paramFloat2, f1, f2, f3, f4);
                    }
                  }
                  i += 1;
                }
                return paramString;
              }
              if (((String)localObject3).equals("MIC_BASE_VIDEOCAMERABLEND"))
              {
                localObject2 = new VideoCameraBlendFilter();
                i = 0;
                localObject1 = localObject2;
                if (i >= paramBaseFilterMaterial.params.size()) {
                  break;
                }
                if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("inputTextureImage"))
                {
                  localObject1 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).type;
                  ((BaseFilter)localObject2).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", cropMaterialBitmap(BitmapUtils.getBitmapFromEncryptedFile(AEModule.getContext(), paramString + File.separator + ((FilterParam)paramBaseFilterMaterial.params.get(i)).value), paramFloat1, paramFloat2, (String)localObject1), 33986, true));
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("blendMode"))
                  {
                    ((BaseFilter)localObject2).addParam(new UniformParam.IntParam("blendMode", Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value)));
                  }
                  else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("location"))
                  {
                    localObject1 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).value.split(",");
                    if (localObject1.length == 5)
                    {
                      localObject4 = new float[5];
                      j = 0;
                      while (j < 5)
                      {
                        localObject4[j] = Float.parseFloat(localObject1[j]);
                        j += 1;
                      }
                      ((VideoCameraBlendFilter)localObject2).setTop(localObject4[0], localObject4[1]);
                      ((VideoCameraBlendFilter)localObject2).setBottom(localObject4[2], localObject4[3]);
                      ((VideoCameraBlendFilter)localObject2).setPicRatio(localObject4[4]);
                    }
                    else if (localObject1.length == 2)
                    {
                      f3 = Float.parseFloat(localObject1[0]);
                      f4 = Float.parseFloat(localObject1[1]);
                      localObject1 = (List)mFilterRandomMap.get(localObject3);
                      if ((localObject1 == null) || (((List)localObject1).size() < 2)) {
                        f1 = (float)Math.random();
                      }
                      for (f2 = (float)Math.random();; f2 = ((Float)((List)localObject1).get(1)).floatValue())
                      {
                        localObject1 = new ArrayList();
                        ((List)localObject1).add(Float.valueOf(f1));
                        ((List)localObject1).add(Float.valueOf(f2));
                        mFilterRandomMap.put(localObject3, localObject1);
                        ((VideoCameraBlendFilter)localObject2).setRandomHeight(f3, f1, f2);
                        ((VideoCameraBlendFilter)localObject2).setPicRatio(f4);
                        break;
                        f1 = ((Float)((List)localObject1).get(0)).floatValue();
                      }
                    }
                  }
                  else if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("rotateType"))
                  {
                    ((VideoCameraBlendFilter)localObject2).setRotateType(Integer.parseInt(((FilterParam)paramBaseFilterMaterial.params.get(i)).value));
                  }
                }
              }
              if (((String)localObject3).equals("MIC_BASE_BLUREFFECT"))
              {
                paramString = new BlurEffectForMultiConnect();
                i = 0;
                for (;;)
                {
                  localObject1 = paramString;
                  if (i >= paramBaseFilterMaterial.params.size()) {
                    break;
                  }
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("strength"))
                  {
                    paramFloat1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                    ((BlurEffectForMultiConnect)paramString).updateFilterBlurStrength(paramFloat1);
                  }
                  i += 1;
                }
              }
              if (((String)localObject3).equals("MIC_BASE_BORDER"))
              {
                paramString = new BorderFilter();
                i = 0;
                localObject1 = paramString;
                if (i >= paramBaseFilterMaterial.params.size()) {
                  break;
                }
                localObject1 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).name;
                if (((String)localObject1).equals("borderWidth"))
                {
                  paramFloat1 = Float.parseFloat(((FilterParam)paramBaseFilterMaterial.params.get(i)).value);
                  ((BorderFilter)paramString).updateBorderWidth(paramFloat1);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (((String)localObject1).equals("borderColor"))
                  {
                    localObject1 = ((FilterParam)paramBaseFilterMaterial.params.get(i)).value.split(",");
                    localObject2 = new float[4];
                    tmp13590_13588 = localObject2;
                    tmp13590_13588[0] = 0.0F;
                    tmp13594_13590 = tmp13590_13588;
                    tmp13594_13590[1] = 0.0F;
                    tmp13598_13594 = tmp13594_13590;
                    tmp13598_13594[2] = 0.0F;
                    tmp13602_13598 = tmp13598_13594;
                    tmp13602_13598[3] = 1.0F;
                    tmp13602_13598;
                    j = 0;
                    while (j < localObject1.length)
                    {
                      localObject2[j] = Float.parseFloat(localObject1[j]);
                      j += 1;
                    }
                    ((BorderFilter)paramString).updateBorderColor((float[])localObject2);
                  }
                }
              }
              if (((String)localObject3).equals("MIC_BASE_WATERMARK"))
              {
                localObject2 = new WatermarkFilter();
                i = 0;
                for (;;)
                {
                  localObject1 = localObject2;
                  if (i >= paramBaseFilterMaterial.params.size()) {
                    break;
                  }
                  if (((FilterParam)paramBaseFilterMaterial.params.get(i)).name.equals("fileName"))
                  {
                    localObject1 = VideoTemplateParser.parseVideoMaterial(paramString, ((FilterParam)paramBaseFilterMaterial.params.get(i)).value, true, new MultiFilterParamConnect.2());
                    LogicDataManager.getInstance().init((VideoMaterial)localObject1);
                    ((WatermarkFilter)localObject2).setWatermarkMaterial((VideoMaterial)localObject1);
                  }
                  i += 1;
                }
              }
              return createMultiFilterConnect(paramBaseFilterMaterial);
            }
          }
        }
      }
      else
      {
        localObject3 = localObject1;
        f4 = paramFloat2;
        f5 = paramFloat1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        paramFloat1 = f2;
        paramFloat2 = f3;
        f2 = f4;
        f3 = f5;
      }
    }
  }
  
  public static BaseFilter createFilter(FilterMaterial paramFilterMaterial, float paramFloat1, float paramFloat2, MultiFilterParamConnect.OnSingleFilterCreatedCallback paramOnSingleFilterCreatedCallback)
  {
    BaseFilter localBaseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(0));
    filterNum = 0;
    BaseFilter localBaseFilter1 = localBaseFilter4;
    int[] arrayOfInt;
    if (filterNum < paramFilterMaterial.baseFilterMaterials.size())
    {
      BaseFilter localBaseFilter3;
      try
      {
        localBaseFilter2 = createBaseFilter((BaseFilterMaterial)paramFilterMaterial.baseFilterMaterials.get(filterNum), paramFloat1, paramFloat2, paramFilterMaterial.path);
        if (paramOnSingleFilterCreatedCallback != null) {
          paramOnSingleFilterCreatedCallback.onCreated((BaseFilterMaterial)paramFilterMaterial.baseFilterMaterials.get(filterNum));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BaseFilter localBaseFilter2;
          List localList;
          int i;
          localBaseFilter3 = null;
        }
      }
      if (localBaseFilter2 == null) {
        break label254;
      }
      localBaseFilter2.setSrcFilterIndex(localBaseFilter4.getLastFilterID() - 1);
      localBaseFilter2.applyFilterChain(false, paramFloat1, paramFloat2);
      localList = (List)paramFilterMaterial.bridgeMaterialMap.get(Integer.valueOf(filterNum));
      if (localList == null) {
        break label248;
      }
      Collections.sort(localList, new MultiFilterParamConnect.1());
      arrayOfInt = new int[localList.size()];
      i = 0;
      while (i < localList.size())
      {
        arrayOfInt[i] = ((BridgeMaterial)localList.get(i)).output;
        i += 1;
      }
      label212:
      localBaseFilter1.getLastFilter().setNextFilter(localBaseFilter3, arrayOfInt);
      localBaseFilter1 = localBaseFilter3.getLastFilter();
    }
    label248:
    label254:
    for (;;)
    {
      filterNum += 1;
      break;
      return localBaseFilter4.getmNextFilter();
      arrayOfInt = null;
      break label212;
    }
  }
  
  private static BaseFilter createMultiFilterConnect(BaseFilterMaterial paramBaseFilterMaterial)
  {
    HashMap localHashMap = null;
    String str = paramBaseFilterMaterial.name;
    if (str.equals("MIC_FACE_LUOZHUANG"))
    {
      paramBaseFilterMaterial = new FaceBeautyAutoFilter();
      localHashMap = new HashMap();
      localHashMap.put("filter_type", Integer.valueOf(1));
      localHashMap.put("filter_quality", Integer.valueOf(2));
      paramBaseFilterMaterial.setParameterDic(localHashMap);
    }
    do
    {
      return paramBaseFilterMaterial;
      if (str.equals("MIC_FACE_NENHONG"))
      {
        paramBaseFilterMaterial = new FaceBeautyAutoFilter();
        localHashMap = new HashMap();
        localHashMap.put("filter_type", Integer.valueOf(2));
        localHashMap.put("filter_quality", Integer.valueOf(2));
        paramBaseFilterMaterial.setParameterDic(localHashMap);
        return paramBaseFilterMaterial;
      }
      if (str.equals("MIC_FACE_ZHENBAI"))
      {
        paramBaseFilterMaterial = new FaceBeautyAutoFilter();
        localHashMap = new HashMap();
        localHashMap.put("filter_type", Integer.valueOf(3));
        localHashMap.put("filter_quality", Integer.valueOf(2));
        paramBaseFilterMaterial.setParameterDic(localHashMap);
        return paramBaseFilterMaterial;
      }
      if (str.equals("MIC_FACE_LANGMAN"))
      {
        paramBaseFilterMaterial = new FaceBeautyAutoFilter();
        localHashMap = new HashMap();
        localHashMap.put("filter_type", Integer.valueOf(4));
        localHashMap.put("filter_quality", Integer.valueOf(2));
        paramBaseFilterMaterial.setParameterDic(localHashMap);
        return paramBaseFilterMaterial;
      }
      if (str.equals("MIC_FACE_NUANYANG"))
      {
        paramBaseFilterMaterial = new FaceBeautyAutoFilter();
        localHashMap = new HashMap();
        localHashMap.put("filter_type", Integer.valueOf(6));
        localHashMap.put("filter_quality", Integer.valueOf(2));
        paramBaseFilterMaterial.setParameterDic(localHashMap);
        return paramBaseFilterMaterial;
      }
      if (str.equals("MIC_FACE_QINGTOU"))
      {
        paramBaseFilterMaterial = new FaceBeautyAutoFilter();
        localHashMap = new HashMap();
        localHashMap.put("filter_type", Integer.valueOf(7));
        localHashMap.put("filter_quality", Integer.valueOf(2));
        paramBaseFilterMaterial.setParameterDic(localHashMap);
        return paramBaseFilterMaterial;
      }
      if (str.equals("MIC_FACE_QINGYI")) {
        return new Curve2D("qingyi.png");
      }
      if (str.equals("MIC_FACE_YINGHONG")) {
        return new LightRedFilter();
      }
      if (str.equals("MIC_FACE_FENBI")) {
        return new OkinawaFilter();
      }
      if (str.equals("MIC_FACE_ZHAHUANG")) {
        return new SapporoFilter();
      }
      if (str.equals("MIC_FACE_DIZHONGHAI")) {
        return new RichBlueFilter();
      }
      if (str.equals("MIC_FACE_ZHIZI")) {
        return new TeaMilkFilter();
      }
      if (str.equals("MIC_FACE_RAN")) {
        return new GradientGlareFondDreamFilter();
      }
      if (str.equals("MIC_FACE_MO")) {
        return new BaseFilter(BaseFilter.getFragmentShader(0));
      }
      if (str.equals("MIC_ZIPAI_SHENGDAI")) {
        return new LightWhiteFilter();
      }
      if (str.equals("MIC_ZIPAI_LINJIA")) {
        return new NextDoorFilter();
      }
      if (str.equals("MIC_ZIPAI_TIANBOHE")) {
        return new LightGreenFilter();
      }
      if (str.equals("MIC_ZIPAI_MOLV")) {
        return new MilkGreenFilter();
      }
      if (str.equals("MIC_ZIPAI_SHOUER")) {
        return new RichRedFilter();
      }
      if (str.equals("MIC_ZIPAI_FOLUOLUNSA")) {
        return new RichYellowFilter();
      }
      if (str.equals("MIC_ZIPAI_MOSIKE")) {
        return new MoscoFilter();
      }
      if (str.equals("MIC_ZIPAI_CHONGSHEN")) {
        return new OceanFilter();
      }
      if (str.equals("MIC_ZIPAI_ZHAOHE")) {
        return new YoungFilter();
      }
      if (str.equals("MIC_ZIPAI_DONGJING")) {
        return new TokyoFilter();
      }
      if (str.equals("MIC_ZIPAI_NAILIANG")) {
        return new MedSeaFilter();
      }
      if (str.equals("MIC_ZIPAI_NIUNAIKAFEI")) {
        return new MilkCoffeeFilter();
      }
      if (str.equals("MIC_ZIPAI_JIDIBINGCHUAN")) {
        return new MilkBlueFilter();
      }
      if (str.equals("MIC_ZIPAI_LIZIDANGAO")) {
        return new ThursdayFilter();
      }
      if (str.equals("MIC_ZIPAI_BANGBANGTANG")) {
        return new LollyFilter();
      }
      if (str.equals("MIC_ZIPAI_MEIGUICHUXUE")) {
        return new FairyTaleFilter();
      }
      if (str.equals("MIC_ZIPAI_YINGTAOBUDING")) {
        return new LipNewFilter();
      }
      if (str.equals("MIC_ZIPAI_BAICHA")) {
        return new LightFilter();
      }
      if (str.equals("MIC_ZIPAI_JIAOCHA")) {
        return new CoffeeFilter();
      }
      if (str.equals("MIC_ZIPAI_DAIZI")) {
        return new GradientGlareFashionFilter();
      }
      if (str.equals("MIC_ZIPAI_BOPU")) {
        return new GradientAndyWarholCowFilter();
      }
      if (str.equals("MIC_ZIPAI_JIWEIJIU")) {
        return new GradientPurpleYellowFilter();
      }
      if (str.equals("MIC_ZIPAI_CUOJUE")) {
        return new ThreeDFilter();
      }
      if (str.equals("MIC_LAB_LAOXIANGPIAN")) {
        return new BlackWhite3Filter();
      }
      if (str.equals("MIC_PTU_QIANGWEI")) {
        return new QiangWeiFilter();
      }
      if (str.equals("MIC_PTU_ZIRAN")) {
        return new ZiranFilter();
      }
      if (str.equals("MIC_PTU_XINYE")) {
        return new XinYeFilter();
      }
      if (str.equals("MIC_PTU_TANGGUOMEIGUI")) {
        return new TangGuoMeiGuiFilter();
      }
      if (str.equals("MIC_PTU_SHUILIAN")) {
        return new ShuiLianFilter();
      }
      if (str.equals("MIC_PTU_YOUJIALI")) {
        return new YouJiaLiFilter();
      }
      if (str.equals("MIC_PTU_ZIPAI_TIANMEI")) {
        return new TianMeiZiPaiFilter();
      }
      if (str.equals("MIC_PTU_ZIPAI_FENNEN")) {
        return new Fen2Filter();
      }
      if (str.equals("MIC_PTU_ZIPAI_MILKGREEN")) {
        return new MilkGreenFilter();
      }
      if (str.equals("MIC_PTU_ZIPAI_NEXTDOOR")) {
        return new NextDoorFilter();
      }
      if (str.equals("MIC_PTU_ZIPAI_NAILIANG")) {
        return new MedSeaFilter();
      }
      if (str.equals("MIC_PTU_ZIPAI_YANJING"))
      {
        paramBaseFilterMaterial = new Curve2D("danya.png");
        ((Curve2D)paramBaseFilterMaterial).setMatrix(new float[] { 0.825F, 0.075F, 0.075F, 0.0F, 0.147F, 0.897F, 0.147F, 0.0F, 0.029F, 0.029F, 0.779F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
        return paramBaseFilterMaterial;
      }
      paramBaseFilterMaterial = localHashMap;
    } while (!str.equals("MIC_PTU_ZIPAI_COFFEE"));
    return new CoffeeFilter();
  }
  
  private static Bitmap cropMaterialBitmap(Bitmap paramBitmap, float paramFloat1, float paramFloat2, String paramString)
  {
    float f1 = 0.0F;
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return paramBitmap;
          } while (("image".equals(paramString)) || ("fill".equals(paramString)));
          if (("header".equals(paramString)) || ("body".equals(paramString)) || ("footer".equals(paramString)))
          {
            f2 = paramBitmap.getWidth();
            float f3 = paramBitmap.getHeight();
            if (f2 / f3 >= paramFloat1 / paramFloat2)
            {
              paramFloat1 = f3 * paramFloat1 / paramFloat2;
              return Bitmap.createBitmap(paramBitmap, (int)(f2 - paramFloat1) / 2, 0, (int)paramFloat1, (int)f3);
            }
            paramFloat2 = f2 * paramFloat2 / paramFloat1;
            if ("body".equals(paramString)) {
              paramFloat1 = (f3 - paramFloat2) / 2.0F;
            }
            for (;;)
            {
              return Bitmap.createBitmap(paramBitmap, 0, (int)paramFloat1, (int)f2, (int)paramFloat2);
              paramFloat1 = f1;
              if ("footer".equals(paramString)) {
                paramFloat1 = f3 - paramFloat2;
              }
            }
          }
          if (!"fit".equals(paramString)) {
            break;
          }
          f1 = paramBitmap.getWidth();
          float f2 = paramBitmap.getHeight();
          int i;
          int j;
          if (f1 / f2 < paramFloat1 / paramFloat2)
          {
            paramFloat1 = f2 * paramFloat1 / paramFloat2;
            i = (int)paramFloat1;
            j = (int)f2;
          }
          try
          {
            paramString = Bitmap.createBitmap(i, j, paramBitmap.getConfig());
            paramString.eraseColor(-16777216);
            localCanvas = new Canvas(paramString);
            localPaint = new Paint(6);
            localPaint.setAntiAlias(true);
            localCanvas.drawBitmap(paramBitmap, (paramFloat1 - f1) / 2.0F, 0.0F, localPaint);
            return paramString;
          }
          catch (Exception paramString)
          {
            Canvas localCanvas;
            Paint localPaint;
            int k;
            return paramBitmap;
          }
          catch (OutOfMemoryError paramString) {}
        } while (f1 / f2 <= paramFloat1 / paramFloat2);
        paramFloat1 = f1 * paramFloat2 / paramFloat1;
        i = (int)f1;
        j = (int)paramFloat1;
        try
        {
          paramString = Bitmap.createBitmap(i, j, paramBitmap.getConfig());
          paramString.eraseColor(-16777216);
          localCanvas = new Canvas(paramString);
          localPaint = new Paint(6);
          localPaint.setAntiAlias(true);
          localCanvas.drawBitmap(paramBitmap, 0.0F, (paramFloat1 - f2) / 2.0F, localPaint);
          return paramString;
        }
        catch (Exception paramString)
        {
          return paramBitmap;
        }
        catch (OutOfMemoryError paramString)
        {
          return paramBitmap;
        }
      } while (!"fitMaterial".equals(paramString));
      f1 = paramBitmap.getWidth();
      f2 = paramBitmap.getHeight();
      if (f1 / f2 < paramFloat1 / paramFloat2)
      {
        paramFloat1 = f1 * paramFloat2 / paramFloat1;
        i = (int)(f2 - paramFloat1);
      }
      try
      {
        paramString = Bitmap.createBitmap(paramBitmap, 0, i / 2, (int)f1, (int)paramFloat1);
        return paramString;
      }
      catch (Exception paramString)
      {
        return paramBitmap;
      }
      catch (OutOfMemoryError paramString)
      {
        return paramBitmap;
      }
    } while (f1 / f2 <= paramFloat1 / paramFloat2);
    paramFloat1 = f2 * paramFloat1 / paramFloat2;
    i = (int)((f1 - paramFloat1) / 2.0F);
    j = (int)paramFloat1;
    k = (int)f2;
    try
    {
      paramString = Bitmap.createBitmap(paramBitmap, i, 0, j, k);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      return paramBitmap;
    }
    catch (Exception paramString)
    {
      return paramBitmap;
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.MultiFilterParamConnect
 * JD-Core Version:    0.7.0.1
 */