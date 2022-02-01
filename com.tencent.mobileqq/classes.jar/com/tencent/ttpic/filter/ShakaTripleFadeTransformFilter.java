package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float1sParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class ShakaTripleFadeTransformFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "scaleUp", "scaleMid", "scaleDown", "alphaUp", "alphaMid", "alphaDown" };
  
  public ShakaTripleFadeTransformFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_TRIPLE_FACE_TRANSFORM);
  }
  
  private void setParams(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    addParam(new UniformParam.IntParam("layers", paramInt));
    addParam(new UniformParam.Float1sParam("scales", paramArrayOfFloat1));
    addParam(new UniformParam.Float1sParam("alphaRatios", paramArrayOfFloat2));
  }
  
  protected float getDefaultParamValue()
  {
    return 1.0F;
  }
  
  protected String[] getParamKeys()
  {
    return PARAM_KEYS;
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("layers", 1));
    addParam(new UniformParam.Float1sParam("scales", new float[] { 1.0F, 0.0F, 0.0F, 0.0F }));
    addParam(new UniformParam.Float1sParam("alphaRatios", new float[] { 1.0F, 0.0F, 0.0F, 0.0F }));
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    float f2 = ((Float)paramMap.get("scaleUp")).floatValue();
    int k = 0;
    float f3 = ((Float)paramMap.get("scaleMid")).floatValue();
    float f4 = ((Float)paramMap.get("scaleDown")).floatValue();
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[0] = ((Float)paramMap.get("alphaUp")).floatValue();
    arrayOfFloat[1] = ((Float)paramMap.get("alphaMid")).floatValue();
    arrayOfFloat[2] = ((Float)paramMap.get("alphaDown")).floatValue();
    int m = arrayOfFloat.length;
    int i = 0;
    float f1 = 0.0F;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      f1 += arrayOfFloat[i];
      i += 1;
    }
    while (j < arrayOfFloat.length)
    {
      arrayOfFloat[j] /= f1;
      j += 1;
    }
    setParams(3, new float[] { f2, f3, f4 }, arrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaTripleFadeTransformFilter
 * JD-Core Version:    0.7.0.1
 */