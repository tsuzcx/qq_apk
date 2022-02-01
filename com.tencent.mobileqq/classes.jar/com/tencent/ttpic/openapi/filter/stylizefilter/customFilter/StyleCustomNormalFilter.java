package com.tencent.ttpic.openapi.filter.stylizefilter.customFilter;

import com.tencent.aekit.openrender.UniformParam.Float2sParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.TextureResParam;

public class StyleCustomNormalFilter
  extends VideoFilterBase
{
  public StyleCustomNormalFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", 0.0F));
    addParam(new UniformParam.FloatParam("texelHeightOffset", 0.0F));
    addParam(new UniformParam.Float2sParam("img_size", new float[] { 0.0F, 0.0F }));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputLutTexture1", 0, 33987));
    addParam(new UniformParam.TextureParam("inputLutTexture2", 0, 33988));
    addParam(new UniformParam.TextureParam("inputLutTexture3", 0, 33989));
    addParam(new UniformParam.TextureParam("inputMaterialTexture1", 0, 33990));
    addParam(new UniformParam.TextureParam("inputMaterialTexture2", 0, 33991));
    addParam(new UniformParam.TextureParam("inputMaterialTexture3", 0, 33992));
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void updateImgSize(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.Float2sParam("img_size", new float[] { paramInt1, paramInt2 }));
  }
  
  public void updateLut(String paramString1, String paramString2)
  {
    boolean bool = "lut1".equals(paramString2);
    int i = 33987;
    String str = "inputLutTexture1";
    if (!bool) {
      if ("lut2".equals(paramString2))
      {
        i = 33988;
        str = "inputLutTexture2";
      }
      else if ("lut3".equals(paramString2))
      {
        i = 33989;
        str = "inputLutTexture3";
      }
    }
    addParam(new TextureResParam(str, paramString1, i));
  }
  
  public void updateMaterial(String paramString1, String paramString2)
  {
    boolean bool = "material1".equals(paramString2);
    int i = 33990;
    String str = "inputMaterialTexture1";
    if (!bool) {
      if ("material2".equals(paramString2))
      {
        i = 33991;
        str = "inputMaterialTexture2";
      }
      else if ("material3".equals(paramString2))
      {
        i = 33992;
        str = "inputMaterialTexture3";
      }
    }
    addParam(new TextureResParam(str, paramString1, i));
  }
  
  public void updateWidthHeightParam(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", paramFloat1));
    addParam(new UniformParam.FloatParam("texelHeightOffset", paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.customFilter.StyleCustomNormalFilter
 * JD-Core Version:    0.7.0.1
 */