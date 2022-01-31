package com.tencent.ttpic.filter.blurmaskfilter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public class GaussianMaskFilter
  extends BaseFilter
  implements BlurMaskFilter.IBlurMaskFilter
{
  private static String kGPUImagePassthroughFragmentShaderString = "precision highp float;\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }\n";
  private static HashMap<Float, Integer> sFilterCount;
  private static HashMap<Float, GaussianMaskFilter> sRadiusFilter;
  private GaussianMaskFilter gaussianMaskFilterVertic;
  private boolean mIsInited = false;
  private boolean mNeedBlur = true;
  private float mRadiusInPixels = 1.0F;
  private int previewHeight;
  private int previewWidth;
  
  public GaussianMaskFilter(float paramFloat, boolean paramBoolean)
  {
    super(getGaussianFragment(paramFloat, true, paramBoolean));
    if (paramFloat > 1.0F) {}
    for (;;)
    {
      this.mNeedBlur = bool;
      this.mRadiusInPixels = paramFloat;
      if (this.mNeedBlur) {
        this.gaussianMaskFilterVertic = new GaussianMaskFilter(getGaussianFragment(paramFloat, false, paramBoolean));
      }
      return;
      bool = false;
    }
  }
  
  public GaussianMaskFilter(String paramString)
  {
    super(paramString);
  }
  
  public static void clearGaussianFilterWithRadius(float paramFloat)
  {
    if (sFilterCount != null) {}
    for (Object localObject = (Integer)sFilterCount.get(Float.valueOf(paramFloat)); localObject == null; localObject = null)
    {
      localObject = Integer.valueOf(0);
      if ((((Integer)localObject).intValue() == 0) && (sRadiusFilter != null))
      {
        localObject = (GaussianMaskFilter)sRadiusFilter.remove(Float.valueOf(paramFloat));
        if (localObject != null) {
          ((GaussianMaskFilter)localObject).ClearGLSL();
        }
      }
      return;
    }
    localObject = Integer.valueOf(((Integer)localObject).intValue() - 1);
    if (((Integer)localObject).intValue() <= 0) {}
    for (int i = 0;; i = ((Integer)localObject).intValue())
    {
      localObject = Integer.valueOf(i);
      sFilterCount.put(Float.valueOf(paramFloat), localObject);
      break;
    }
  }
  
  public static void clearGaussianFilters()
  {
    if (sRadiusFilter == null) {
      return;
    }
    Iterator localIterator = sRadiusFilter.values().iterator();
    while (localIterator.hasNext())
    {
      GaussianMaskFilter localGaussianMaskFilter = (GaussianMaskFilter)localIterator.next();
      if (localGaussianMaskFilter != null) {
        localGaussianMaskFilter.ClearGLSL();
      }
    }
    sRadiusFilter.clear();
    sRadiusFilter = null;
    sFilterCount.clear();
    sFilterCount = null;
  }
  
  public static String gaussianFragmentShaderForOptimizedBlurOfRadiusGap(int paramInt, float paramFloat1, boolean paramBoolean1, boolean paramBoolean2, float paramFloat2)
  {
    if (paramInt < 1) {
      return kGPUImagePassthroughFragmentShaderString;
    }
    float[] arrayOfFloat = new float[paramInt + 1];
    float f1 = 0.0F;
    int i = 0;
    if (i < paramInt + 1)
    {
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat1, 2.0D)) * Math.exp(-Math.pow(i, 2.0D) / (2.0D * Math.pow(paramFloat1, 2.0D)))));
      if (i == 0) {}
      for (f1 = arrayOfFloat[i] + f1;; f1 = (float)(f1 + 2.0D * arrayOfFloat[i]))
      {
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < paramInt + 1)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    int j = Math.min(paramInt / 2 + paramInt % 2, 7);
    Object localObject = new float[j];
    i = 0;
    while (i < j)
    {
      paramFloat1 = arrayOfFloat[(i * 2 + 1)];
      f1 = arrayOfFloat[(i * 2 + 2)];
      localObject[i] = ((paramFloat1 * (i * 2 + 1) + f1 * (i * 2 + 2)) / (paramFloat1 + f1));
      i += 1;
    }
    i = paramInt / 2 + paramInt % 2;
    String str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = vec4(0.0);\n", new Object[] { Integer.valueOf(j * 2 + 1) });
    if (paramBoolean2)
    {
      str = str + String.format(Locale.ENGLISH, "if(texture2D(inputImageTexture2,textureCoordinate).r>0.019){\n", new Object[0]);
      str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy) * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) });
      if (!paramBoolean1) {
        break label558;
      }
    }
    label558:
    for (str = str + "highp vec2 singleStepOffset = vec2(horStep, 0.0);\n";; str = str + "highp vec2 singleStepOffset = vec2(0.0, verStep);\n")
    {
      paramInt = 0;
      while (paramInt < j)
      {
        paramFloat1 = arrayOfFloat[(paramInt * 2 + 1)] + arrayOfFloat[(paramInt * 2 + 2)];
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject[paramInt] * paramFloat2), Float.valueOf(paramFloat1) });
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject[paramInt] * paramFloat2), Float.valueOf(paramFloat1) });
        paramInt += 1;
      }
      str = str + String.format(Locale.ENGLISH, "if(texture2D(inputImageTexture2,textureCoordinate).r<0.981){\n", new Object[0]);
      break;
    }
    localObject = str;
    if (i > j)
    {
      paramInt = j;
      for (;;)
      {
        localObject = str;
        if (paramInt >= i) {
          break;
        }
        f1 = arrayOfFloat[(paramInt * 2 + 1)];
        float f2 = arrayOfFloat[(paramInt * 2 + 2)];
        paramFloat1 = f1 + f2;
        f1 = (f1 * (paramInt * 2 + 1) + f2 * (paramInt * 2 + 2)) / paramFloat1;
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1 * paramFloat2), Float.valueOf(paramFloat1) });
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1 * paramFloat2), Float.valueOf(paramFloat1) });
        paramInt += 1;
      }
    }
    if (paramBoolean2) {}
    for (str = (String)localObject + "gl_FragColor = gl_FragColor =mix(texture2D(inputImageTexture, textureCoordinate),sum,texture2D(inputImageTexture2,textureCoordinate).r);\n";; str = (String)localObject + "gl_FragColor = mix(sum,texture2D(inputImageTexture, textureCoordinate),texture2D(inputImageTexture2,textureCoordinate).r);\n")
    {
      str = str + String.format(Locale.ENGLISH, "}\n", new Object[0]);
      str = str + String.format(Locale.ENGLISH, "else{\n", new Object[0]);
      str = str + String.format(Locale.ENGLISH, "gl_FragColor =texture2D(inputImageTexture, textureCoordinate.xy);\n", new Object[0]);
      str = str + String.format(Locale.ENGLISH, "}\n", new Object[0]);
      return str + "}\n";
    }
  }
  
  public static GaussianMaskFilter getGaussianFilter(float paramFloat, boolean paramBoolean)
  {
    if (sRadiusFilter == null)
    {
      sRadiusFilter = new HashMap();
      sFilterCount = new HashMap();
    }
    GaussianMaskFilter localGaussianMaskFilter = (GaussianMaskFilter)sRadiusFilter.get(Float.valueOf(paramFloat));
    if (localGaussianMaskFilter == null)
    {
      localGaussianMaskFilter = new GaussianMaskFilter(paramFloat, paramBoolean);
      sRadiusFilter.put(Float.valueOf(paramFloat), localGaussianMaskFilter);
    }
    for (;;)
    {
      if (sFilterCount.get(Float.valueOf(paramFloat)) == null) {}
      for (int i = 0;; i = ((Integer)sFilterCount.get(Float.valueOf(paramFloat))).intValue())
      {
        sFilterCount.put(Float.valueOf(paramFloat), Integer.valueOf(i + 1));
        return localGaussianMaskFilter;
      }
    }
  }
  
  public static String getGaussianFragment(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f = 2.0F;
    int i = 0;
    if (paramFloat > 24.0F) {
      paramFloat /= 2.0F;
    }
    for (;;)
    {
      if (paramFloat >= 1.0F)
      {
        i = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(paramFloat, 2.0D) * Math.log(0.0039063F * Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)))));
        i += i % 2;
      }
      return gaussianFragmentShaderForOptimizedBlurOfRadiusGap(i, paramFloat, paramBoolean1, paramBoolean2, f);
      f = 1.0F;
    }
  }
  
  public void ClearGLSL()
  {
    this.mIsInited = false;
    if (this.gaussianMaskFilterVertic != null) {
      this.gaussianMaskFilterVertic.ClearGLSL();
    }
    super.ClearGLSL();
  }
  
  public Frame RenderProcess(Frame paramFrame1, Frame paramFrame2)
  {
    if (!this.mNeedBlur) {
      return paramFrame1;
    }
    super.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, this.previewWidth, this.previewHeight, -1, 0.0D, paramFrame2);
    if (this.gaussianMaskFilterVertic != null)
    {
      this.gaussianMaskFilterVertic.RenderProcess(paramFrame2.getTextureId(), this.previewWidth, this.previewHeight, -1, 0.0D, paramFrame1);
      return paramFrame1;
    }
    return paramFrame2;
  }
  
  public BaseFilter addParam(UniformParam paramUniformParam)
  {
    return super.addParam(paramUniformParam);
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if ((this.mIsInited) || (!this.mNeedBlur)) {
      return;
    }
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    this.mIsInited = true;
    if (this.gaussianMaskFilterVertic != null) {
      this.gaussianMaskFilterVertic.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    }
    this.previewWidth = ((int)paramFloat1);
    this.previewHeight = ((int)paramFloat2);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void clear()
  {
    if ((sRadiusFilter.values() != null) && (sRadiusFilter.values().contains(this)))
    {
      clearGaussianFilterWithRadius(this.mRadiusInPixels);
      return;
    }
    ClearGLSL();
  }
  
  public void setMaskTextureId(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
    if (this.gaussianMaskFilterVertic != null) {
      this.gaussianMaskFilterVertic.setMaskTextureId(paramInt);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.previewHeight = paramInt2;
    this.previewWidth = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.GaussianMaskFilter
 * JD-Core Version:    0.7.0.1
 */