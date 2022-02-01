package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.filter.blurmaskfilter.BlurMaskFilter.IBlurMaskFilter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public class GaussianMaskFilter
  extends BaseFilter
  implements BlurMaskFilter.IBlurMaskFilter
{
  private static String kGPUImagePassthroughFragmentShaderString = "precision highp float;\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }\n";
  public static boolean reuseFilter = true;
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
    if (paramFloat <= 1.0F) {
      bool = false;
    }
    this.mNeedBlur = bool;
    this.mRadiusInPixels = paramFloat;
    if (this.mNeedBlur) {
      this.gaussianMaskFilterVertic = new GaussianMaskFilter(getGaussianFragment(paramFloat, false, paramBoolean));
    }
  }
  
  public GaussianMaskFilter(String paramString)
  {
    super(paramString);
  }
  
  public static void clearGaussianFilterWithRadius(float paramFloat)
  {
    Object localObject = sFilterCount;
    if (localObject != null) {
      localObject = (Integer)((HashMap)localObject).get(Float.valueOf(paramFloat));
    } else {
      localObject = null;
    }
    int i = 0;
    if (localObject == null)
    {
      localObject = Integer.valueOf(0);
    }
    else
    {
      localObject = Integer.valueOf(((Integer)localObject).intValue() - 1);
      if (((Integer)localObject).intValue() > 0) {
        i = ((Integer)localObject).intValue();
      }
      localObject = Integer.valueOf(i);
      sFilterCount.put(Float.valueOf(paramFloat), localObject);
    }
    if (((Integer)localObject).intValue() == 0)
    {
      localObject = sRadiusFilter;
      if (localObject != null)
      {
        localObject = (GaussianMaskFilter)((HashMap)localObject).remove(Float.valueOf(paramFloat));
        if (localObject != null) {
          ((GaussianMaskFilter)localObject).clearGLSL();
        }
      }
    }
  }
  
  public static void clearGaussianFilters()
  {
    Object localObject = sRadiusFilter;
    if (localObject == null) {
      return;
    }
    localObject = ((HashMap)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      GaussianMaskFilter localGaussianMaskFilter = (GaussianMaskFilter)((Iterator)localObject).next();
      if (localGaussianMaskFilter != null) {
        localGaussianMaskFilter.clearGLSL();
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
    int j = paramInt + 1;
    float[] arrayOfFloat = new float[j];
    int i = 0;
    float f1 = 0.0F;
    while (i < j)
    {
      double d1 = paramFloat1;
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(Math.pow(d1, 2.0D) * 6.283185307179586D) * Math.exp(-Math.pow(i, 2.0D) / (Math.pow(d1, 2.0D) * 2.0D))));
      if (i == 0)
      {
        f1 += arrayOfFloat[i];
      }
      else
      {
        d1 = f1;
        double d2 = arrayOfFloat[i];
        Double.isNaN(d2);
        Double.isNaN(d1);
        f1 = (float)(d1 + d2 * 2.0D);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    j = paramInt / 2 + paramInt % 2;
    i = Math.min(j, 7);
    Object localObject2 = new float[i];
    paramInt = 0;
    int k;
    while (paramInt < i)
    {
      int m = paramInt * 2;
      k = m + 1;
      paramFloat1 = arrayOfFloat[k];
      m += 2;
      f1 = arrayOfFloat[m];
      localObject2[paramInt] = ((paramFloat1 * k + f1 * m) / (paramFloat1 + f1));
      paramInt += 1;
    }
    Object localObject1 = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = vec4(0.0);\n", new Object[] { Integer.valueOf(i * 2 + 1) });
    if (paramBoolean2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format(Locale.ENGLISH, "if(texture2D(inputImageTexture2,textureCoordinate).r>0.019){\n", new Object[0]));
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format(Locale.ENGLISH, "if(texture2D(inputImageTexture2,textureCoordinate).r<0.981){\n", new Object[0]));
      localObject1 = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy) * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) }));
    localObject1 = localStringBuilder.toString();
    if (paramBoolean1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("highp vec2 singleStepOffset = vec2(horStep, 0.0);\n");
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("highp vec2 singleStepOffset = vec2(0.0, verStep);\n");
      localObject1 = localStringBuilder.toString();
    }
    paramInt = 0;
    while (paramInt < i)
    {
      k = paramInt * 2;
      paramFloat1 = arrayOfFloat[(k + 1)] + arrayOfFloat[(k + 2)];
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject2[paramInt] * paramFloat2), Float.valueOf(paramFloat1) }));
      localObject1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject2[paramInt] * paramFloat2), Float.valueOf(paramFloat1) }));
      localObject1 = localStringBuilder.toString();
      paramInt += 1;
    }
    localObject2 = localObject1;
    if (j > i)
    {
      paramInt = i;
      for (;;)
      {
        localObject2 = localObject1;
        if (paramInt >= j) {
          break;
        }
        k = paramInt * 2;
        i = k + 1;
        f1 = arrayOfFloat[i];
        k += 2;
        float f2 = arrayOfFloat[k];
        paramFloat1 = f1 + f2;
        f1 = (f1 * i + f2 * k) / paramFloat1;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = Locale.ENGLISH;
        f1 *= paramFloat2;
        ((StringBuilder)localObject2).append(String.format((Locale)localObject1, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat1) }));
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat1) }));
        localObject1 = ((StringBuilder)localObject2).toString();
        paramInt += 1;
      }
    }
    if (paramBoolean2)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject2 = "gl_FragColor = gl_FragColor =mix(texture2D(inputImageTexture, textureCoordinate),sum,texture2D(inputImageTexture2,textureCoordinate).r);\n";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject2 = "gl_FragColor = mix(sum,texture2D(inputImageTexture, textureCoordinate),texture2D(inputImageTexture2,textureCoordinate).r);\n";
    }
    ((StringBuilder)localObject1).append((String)localObject2);
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "}\n", new Object[0]));
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "else{\n", new Object[0]));
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "gl_FragColor =texture2D(inputImageTexture, textureCoordinate.xy);\n", new Object[0]));
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(String.format(Locale.ENGLISH, "}\n", new Object[0]));
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}\n");
    return ((StringBuilder)localObject2).toString();
  }
  
  public static GaussianMaskFilter getGaussianFilter(float paramFloat, boolean paramBoolean)
  {
    if (!reuseFilter) {
      return new GaussianMaskFilter(paramFloat, paramBoolean);
    }
    if (sRadiusFilter == null)
    {
      sRadiusFilter = new HashMap();
      sFilterCount = new HashMap();
    }
    GaussianMaskFilter localGaussianMaskFilter2 = (GaussianMaskFilter)sRadiusFilter.get(Float.valueOf(paramFloat));
    GaussianMaskFilter localGaussianMaskFilter1 = localGaussianMaskFilter2;
    if (localGaussianMaskFilter2 == null)
    {
      localGaussianMaskFilter1 = new GaussianMaskFilter(paramFloat, paramBoolean);
      sRadiusFilter.put(Float.valueOf(paramFloat), localGaussianMaskFilter1);
    }
    int i;
    if (sFilterCount.get(Float.valueOf(paramFloat)) == null) {
      i = 0;
    } else {
      i = ((Integer)sFilterCount.get(Float.valueOf(paramFloat))).intValue();
    }
    sFilterCount.put(Float.valueOf(paramFloat), Integer.valueOf(i + 1));
    return localGaussianMaskFilter1;
  }
  
  public static String getGaussianFragment(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f1 = 2.0F;
    float f2;
    if (paramFloat > 24.0F)
    {
      f2 = paramFloat / 2.0F;
      paramFloat = f1;
      f1 = f2;
    }
    else
    {
      f2 = 1.0F;
      f1 = paramFloat;
      paramFloat = f2;
    }
    int i;
    if (f1 >= 1.0F)
    {
      double d3 = f1;
      double d1 = Math.pow(d3, 2.0D);
      double d2 = 0.0039063F;
      d3 = Math.sqrt(Math.pow(d3, 2.0D) * 6.283185307179586D);
      Double.isNaN(d2);
      i = (int)Math.floor(Math.sqrt(d1 * -2.0D * Math.log(d2 * d3)));
      i += i % 2;
    }
    else
    {
      i = 0;
    }
    return gaussianFragmentShaderForOptimizedBlurOfRadiusGap(i, f1, paramBoolean1, paramBoolean2, paramFloat);
  }
  
  public Frame RenderProcess(Frame paramFrame1, Frame paramFrame2)
  {
    if (!this.mNeedBlur) {
      return paramFrame1;
    }
    super.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, this.previewWidth, this.previewHeight, -1, 0.0D, paramFrame2);
    GaussianMaskFilter localGaussianMaskFilter = this.gaussianMaskFilterVertic;
    if (localGaussianMaskFilter != null)
    {
      localGaussianMaskFilter.RenderProcess(paramFrame2.getTextureId(), this.previewWidth, this.previewHeight, -1, 0.0D, paramFrame1);
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
    if (!this.mIsInited)
    {
      if (!this.mNeedBlur) {
        return;
      }
      addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
      this.mIsInited = true;
      GaussianMaskFilter localGaussianMaskFilter = this.gaussianMaskFilterVertic;
      if (localGaussianMaskFilter != null) {
        localGaussianMaskFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      }
      this.previewWidth = ((int)paramFloat1);
      this.previewHeight = ((int)paramFloat2);
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public void clear()
  {
    HashMap localHashMap = sRadiusFilter;
    if ((localHashMap != null) && (localHashMap.values() != null) && (sRadiusFilter.values().contains(this)))
    {
      clearGaussianFilterWithRadius(this.mRadiusInPixels);
      return;
    }
    clearGLSL();
  }
  
  public void clearGLSL()
  {
    this.mIsInited = false;
    GaussianMaskFilter localGaussianMaskFilter = this.gaussianMaskFilterVertic;
    if (localGaussianMaskFilter != null) {
      localGaussianMaskFilter.clearGLSL();
    }
    super.clearGLSL();
  }
  
  public void setMaskTextureId(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
    GaussianMaskFilter localGaussianMaskFilter = this.gaussianMaskFilterVertic;
    if (localGaussianMaskFilter != null) {
      localGaussianMaskFilter.setMaskTextureId(paramInt);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.previewHeight = paramInt2;
    this.previewWidth = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GaussianMaskFilter
 * JD-Core Version:    0.7.0.1
 */