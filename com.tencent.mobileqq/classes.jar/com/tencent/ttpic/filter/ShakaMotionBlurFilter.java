package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;

public class ShakaMotionBlurFilter
  extends BaseFilter
{
  private static String FRAGMENT_SHADER = "precision highp float;\n \n uniform sampler2D inputImageTexture;\n \n varying vec2 textureCoordinate;\n varying vec2 oneStepBackTextureCoordinate;\n varying vec2 twoStepsBackTextureCoordinate;\n varying vec2 threeStepsBackTextureCoordinate;\n varying vec2 fourStepsBackTextureCoordinate;\n varying vec2 oneStepForwardTextureCoordinate;\n varying vec2 twoStepsForwardTextureCoordinate;\n varying vec2 threeStepsForwardTextureCoordinate;\n varying vec2 fourStepsForwardTextureCoordinate;\n \n void main()\n {\n     lowp vec4 fragmentColor = texture2D(inputImageTexture, textureCoordinate) * 0.18;\n     fragmentColor += texture2D(inputImageTexture, oneStepBackTextureCoordinate) * 0.15;\n     fragmentColor += texture2D(inputImageTexture, twoStepsBackTextureCoordinate) *  0.12;\n     fragmentColor += texture2D(inputImageTexture, threeStepsBackTextureCoordinate) * 0.09;\n     fragmentColor += texture2D(inputImageTexture, fourStepsBackTextureCoordinate) * 0.05;\n     fragmentColor += texture2D(inputImageTexture, oneStepForwardTextureCoordinate) * 0.15;\n     fragmentColor += texture2D(inputImageTexture, twoStepsForwardTextureCoordinate) *  0.12;\n     fragmentColor += texture2D(inputImageTexture, threeStepsForwardTextureCoordinate) * 0.09;\n     fragmentColor += texture2D(inputImageTexture, fourStepsForwardTextureCoordinate) * 0.05;\n\n     gl_FragColor = fragmentColor;\n }";
  private static String VERTEXT_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform vec2 directionalTexelStep;\n \n varying vec2 textureCoordinate;\n varying vec2 oneStepBackTextureCoordinate;\n varying vec2 twoStepsBackTextureCoordinate;\n varying vec2 threeStepsBackTextureCoordinate;\n varying vec2 fourStepsBackTextureCoordinate;\n varying vec2 oneStepForwardTextureCoordinate;\n varying vec2 twoStepsForwardTextureCoordinate;\n varying vec2 threeStepsForwardTextureCoordinate;\n varying vec2 fourStepsForwardTextureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     \n     textureCoordinate = inputTextureCoordinate.xy;\n     oneStepBackTextureCoordinate = inputTextureCoordinate.xy - directionalTexelStep;\n     twoStepsBackTextureCoordinate = inputTextureCoordinate.xy - 2.0 * directionalTexelStep;\n     threeStepsBackTextureCoordinate = inputTextureCoordinate.xy - 3.0 * directionalTexelStep;\n     fourStepsBackTextureCoordinate = inputTextureCoordinate.xy - 4.0 * directionalTexelStep;\n     oneStepForwardTextureCoordinate = inputTextureCoordinate.xy + directionalTexelStep;\n     twoStepsForwardTextureCoordinate = inputTextureCoordinate.xy + 2.0 * directionalTexelStep;\n     threeStepsForwardTextureCoordinate = inputTextureCoordinate.xy + 3.0 * directionalTexelStep;\n     fourStepsForwardTextureCoordinate = inputTextureCoordinate.xy + 4.0 * directionalTexelStep;\n }";
  private BaseFilter blurFilter2 = new BaseFilter(VERTEXT_SHADER, FRAGMENT_SHADER);
  private float mBlurAngle;
  private float mBlurSize;
  private float mHeight;
  private BaseFilter mScaleFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private float mWidth;
  
  public ShakaMotionBlurFilter()
  {
    super(VERTEXT_SHADER, FRAGMENT_SHADER);
    BaseFilter localBaseFilter = this.blurFilter2;
    localBaseFilter.scaleFact = 0.25F;
    this.scaleFact = 0.25F;
    this.mBlurSize = 0.0F;
    this.mBlurAngle = 0.0F;
    setNextFilter(localBaseFilter, null);
    this.blurFilter2.setNextFilter(this.mScaleFilter, null);
  }
  
  private void recalculateTexelOffsets()
  {
    float[] arrayOfFloat = new float[2];
    float f1 = this.mHeight / this.mWidth;
    float f2 = this.mBlurSize;
    if (f2 <= 2.0F)
    {
      d1 = f2;
      d2 = this.mBlurAngle;
      Double.isNaN(d2);
      d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
      Double.isNaN(d1);
      d3 = f1;
      Double.isNaN(d3);
      d4 = this.mWidth;
      Double.isNaN(d4);
      arrayOfFloat[0] = ((float)(d1 * d2 * d3 / d4));
      d1 = this.mBlurSize;
      d2 = this.mBlurAngle;
      Double.isNaN(d2);
      d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
      Double.isNaN(d1);
      d3 = this.mWidth;
      Double.isNaN(d3);
      arrayOfFloat[1] = ((float)(d1 * d2 / d3));
      addParam(new UniformParam.FloatsParam("directionalTexelStep", arrayOfFloat));
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      this.blurFilter2.addParam(new UniformParam.FloatsParam("directionalTexelStep", arrayOfFloat));
      return;
    }
    double d1 = this.mBlurAngle;
    Double.isNaN(d1);
    double d2 = Math.cos(d1 * 3.141592653589793D / 180.0D);
    d1 = f1;
    Double.isNaN(d1);
    double d3 = this.mWidth;
    Double.isNaN(d3);
    arrayOfFloat[0] = ((float)(d2 * 2.0D * d1 / d3));
    d2 = this.mBlurAngle;
    Double.isNaN(d2);
    d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
    d3 = this.mWidth;
    Double.isNaN(d3);
    arrayOfFloat[1] = ((float)(d2 * 2.0D / d3));
    addParam(new UniformParam.FloatsParam("directionalTexelStep", arrayOfFloat));
    d2 = this.mBlurSize - 2.0F;
    d3 = this.mBlurAngle;
    Double.isNaN(d3);
    d3 = Math.cos(d3 * 3.141592653589793D / 180.0D);
    Double.isNaN(d2);
    Double.isNaN(d1);
    double d4 = this.mWidth;
    Double.isNaN(d4);
    arrayOfFloat[0] = ((float)(d2 * d3 * d1 / d4));
    d1 = this.mBlurSize - 2.0F;
    d2 = this.mBlurAngle;
    Double.isNaN(d2);
    d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
    Double.isNaN(d1);
    d3 = this.mWidth;
    Double.isNaN(d3);
    arrayOfFloat[1] = ((float)(d1 * d2 / d3));
    this.blurFilter2.addParam(new UniformParam.FloatsParam("directionalTexelStep", arrayOfFloat));
  }
  
  public void updateParams(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.mBlurSize = paramFloat1;
    this.mBlurAngle = paramFloat2;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    recalculateTexelOffsets();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.ShakaMotionBlurFilter
 * JD-Core Version:    0.7.0.1
 */