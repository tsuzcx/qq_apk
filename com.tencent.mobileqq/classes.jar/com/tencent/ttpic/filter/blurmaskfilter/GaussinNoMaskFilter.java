package com.tencent.ttpic.filter.blurmaskfilter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.util.FrameUtil;
import java.util.Locale;

public class GaussinNoMaskFilter
  extends BaseFilter
  implements BlurMaskFilter.IBlurMaskFilter
{
  private static String kGPUImagePassthroughFragmentShaderString = "precision highp float;\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }\n";
  private BaseFilter horizontal = null;
  private boolean mIsNeedBlur;
  private float mRadiusInPixels = 1.0F;
  private int previewHeight;
  private int previewWidth;
  private BaseFilter vertical = null;
  
  public GaussinNoMaskFilter(float paramFloat)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    boolean bool = true;
    this.mIsNeedBlur = true;
    this.mRadiusInPixels = paramFloat;
    if (paramFloat <= 1.0F) {
      bool = false;
    }
    this.mIsNeedBlur = bool;
  }
  
  public static String gaussianFragmentShaderForOptimizedBlurOfRadius(int paramInt, float paramFloat1, boolean paramBoolean, float paramFloat2)
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
    Object localObject1 = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = vec4(0.0);\n", new Object[] { Integer.valueOf(i * 2 + 1) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy) * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) }));
    localObject1 = localStringBuilder.toString();
    if (paramBoolean)
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
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("gl_FragColor =sum;\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}\n");
    return ((StringBuilder)localObject2).toString();
  }
  
  public Frame RenderProcess(Frame paramFrame1, Frame paramFrame2)
  {
    Frame localFrame = paramFrame1;
    if (this.mIsNeedBlur)
    {
      super.RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, this.previewWidth, this.previewHeight, -1, 0.0D, paramFrame2);
      localFrame = FrameUtil.getLastRenderFrame(paramFrame2);
    }
    return localFrame;
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (!this.mIsNeedBlur) {
      return;
    }
    this.previewWidth = ((int)paramFloat1);
    this.previewHeight = ((int)paramFloat2);
    float f2 = this.mRadiusInPixels;
    float f1 = 1.0F;
    int i;
    if (f2 >= 1.0F)
    {
      if (f2 > 18.0F)
      {
        this.mRadiusInPixels = (f2 / 2.0F);
        f1 = 2.0F;
      }
      double d1 = Math.pow(this.mRadiusInPixels, 2.0D);
      double d2 = 0.0039063F;
      double d3 = Math.sqrt(Math.pow(this.mRadiusInPixels, 2.0D) * 6.283185307179586D);
      Double.isNaN(d2);
      i = (int)Math.floor(Math.sqrt(d1 * -2.0D * Math.log(d2 * d3)));
      i += i % 2;
    }
    else
    {
      i = 0;
    }
    this.horizontal = new BaseFilter(gaussianFragmentShaderForOptimizedBlurOfRadius(i, this.mRadiusInPixels, true, f1));
    this.vertical = new BaseFilter(gaussianFragmentShaderForOptimizedBlurOfRadius(i, this.mRadiusInPixels, false, f1));
    setNextFilter(this.horizontal, null);
    this.horizontal.setNextFilter(this.vertical, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void clear()
  {
    clearGLSL();
  }
  
  public void setMaskTextureId(int paramInt) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.previewWidth = paramInt1;
    this.previewHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.GaussinNoMaskFilter
 * JD-Core Version:    0.7.0.1
 */