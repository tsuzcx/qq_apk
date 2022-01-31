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
  private boolean mIsNeedBlur = true;
  private float mRadiusInPixels = 1.0F;
  private int previewHeight;
  private int previewWidth;
  private BaseFilter vertical = null;
  
  public GaussinNoMaskFilter(float paramFloat)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.mRadiusInPixels = paramFloat;
    if (paramFloat > 1.0F) {}
    for (;;)
    {
      this.mIsNeedBlur = bool;
      return;
      bool = false;
    }
  }
  
  public static String gaussianFragmentShaderForOptimizedBlurOfRadius(int paramInt, float paramFloat1, boolean paramBoolean, float paramFloat2)
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
    String str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = vec4(0.0);\n", new Object[] { Integer.valueOf(j * 2 + 1) });
    str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy) * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) });
    if (paramBoolean) {}
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
    str = (String)localObject + "gl_FragColor =sum;\n";
    return str + "}\n";
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
    int i = 0;
    float f1 = 1.0F;
    float f2 = f1;
    if (this.mRadiusInPixels >= 1.0F)
    {
      if (this.mRadiusInPixels > 18.0F)
      {
        f1 = 2.0F;
        this.mRadiusInPixels /= 2.0F;
      }
      i = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(this.mRadiusInPixels, 2.0D) * Math.log(0.0039063F * Math.sqrt(6.283185307179586D * Math.pow(this.mRadiusInPixels, 2.0D)))));
      i += i % 2;
      f2 = f1;
    }
    this.horizontal = new BaseFilter(gaussianFragmentShaderForOptimizedBlurOfRadius(i, this.mRadiusInPixels, true, f2));
    this.vertical = new BaseFilter(gaussianFragmentShaderForOptimizedBlurOfRadius(i, this.mRadiusInPixels, false, f2));
    setNextFilter(this.horizontal, null);
    this.horizontal.setNextFilter(this.vertical, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void clear()
  {
    ClearGLSL();
  }
  
  public void setMaskTextureId(int paramInt) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.previewWidth = paramInt1;
    this.previewHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.blurmaskfilter.GaussinNoMaskFilter
 * JD-Core Version:    0.7.0.1
 */