package com.tencent.qcircle.weseevideo.composition.filter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class MotionBlurFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n \n uniform sampler2D inputImageTexture;\n uniform vec2 directionalTexelStep;\n uniform vec2 motionBlurEllipseCenter;\n uniform float motionBlurEllipseA;\n uniform float motionBlurEllipseB;\n uniform int directionalTexelNumSamples;\n uniform float motionBlurEllipseGradientRatio;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n    // 判断在椭圆外部正常模糊，两个椭圆之间渐变模糊，内椭圆里面不模糊\n    float x0 = textureCoordinate.x - motionBlurEllipseCenter.x;\n    float y0 = textureCoordinate.y - motionBlurEllipseCenter.y;\n    \n    float motionBlurInnerEllipseA = motionBlurEllipseGradientRatio * motionBlurEllipseA;\n    float motionBlurInnerEllipseB = motionBlurEllipseGradientRatio * motionBlurEllipseB;\n    \n    float x = x0 / motionBlurInnerEllipseA;\n    float y = y0 / motionBlurInnerEllipseB;\n    \n    vec2 step = directionalTexelStep;\n    int numSamples = directionalTexelNumSamples;\n    \n    if (x*x + y*y < 1.0)\n    {\n        // no blur\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n    else\n    {\n        x = x0 / motionBlurEllipseA;\n        y = y0 / motionBlurEllipseB;\n        float d2 = x*x + y*y;\n        \n        float r2 = motionBlurEllipseGradientRatio * motionBlurEllipseGradientRatio;\n        float factor = min(r2 >= 1.0 ? 1.0 : (d2 - r2) / (1.0 - r2), 1.0);\n        step *= factor;\n        \n        lowp vec4 tot = vec4(0.0);\n        vec2 offset = textureCoordinate - float(numSamples) * step;\n        for (int i = -numSamples; i <= numSamples; i++)\n        {\n            offset += step;\n            tot += texture2D(inputImageTexture, offset);\n        }\n\n        gl_FragColor = tot / (float(numSamples * 2) + 1.0);\n    }\n }";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
  private int mMotionBlurAngle = 0;
  private float mMotionBlurSize = 2.0F;
  
  public MotionBlurFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\n \n uniform sampler2D inputImageTexture;\n uniform vec2 directionalTexelStep;\n uniform vec2 motionBlurEllipseCenter;\n uniform float motionBlurEllipseA;\n uniform float motionBlurEllipseB;\n uniform int directionalTexelNumSamples;\n uniform float motionBlurEllipseGradientRatio;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n    // 判断在椭圆外部正常模糊，两个椭圆之间渐变模糊，内椭圆里面不模糊\n    float x0 = textureCoordinate.x - motionBlurEllipseCenter.x;\n    float y0 = textureCoordinate.y - motionBlurEllipseCenter.y;\n    \n    float motionBlurInnerEllipseA = motionBlurEllipseGradientRatio * motionBlurEllipseA;\n    float motionBlurInnerEllipseB = motionBlurEllipseGradientRatio * motionBlurEllipseB;\n    \n    float x = x0 / motionBlurInnerEllipseA;\n    float y = y0 / motionBlurInnerEllipseB;\n    \n    vec2 step = directionalTexelStep;\n    int numSamples = directionalTexelNumSamples;\n    \n    if (x*x + y*y < 1.0)\n    {\n        // no blur\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n    else\n    {\n        x = x0 / motionBlurEllipseA;\n        y = y0 / motionBlurEllipseB;\n        float d2 = x*x + y*y;\n        \n        float r2 = motionBlurEllipseGradientRatio * motionBlurEllipseGradientRatio;\n        float factor = min(r2 >= 1.0 ? 1.0 : (d2 - r2) / (1.0 - r2), 1.0);\n        step *= factor;\n        \n        lowp vec4 tot = vec4(0.0);\n        vec2 offset = textureCoordinate - float(numSamples) * step;\n        for (int i = -numSamples; i <= numSamples; i++)\n        {\n            offset += step;\n            tot += texture2D(inputImageTexture, offset);\n        }\n\n        gl_FragColor = tot / (float(numSamples * 2) + 1.0);\n    }\n }");
    resetParameters();
  }
  
  public Frame render(Frame paramFrame)
  {
    if (paramFrame != null)
    {
      float f = paramFrame.height * 1.0F / paramFrame.width;
      double d1 = this.mMotionBlurSize;
      double d2 = this.mMotionBlurAngle;
      Double.isNaN(d2);
      d2 = Math.cos(d2 * 3.141592653589793D / 180.0D);
      Double.isNaN(d1);
      double d3 = f;
      Double.isNaN(d3);
      f = (float)(d1 * d2 * d3 / 1024.0D);
      d1 = this.mMotionBlurSize;
      d2 = this.mMotionBlurAngle;
      Double.isNaN(d2);
      d2 = Math.sin(d2 * 3.141592653589793D / 180.0D);
      Double.isNaN(d1);
      addParam(new UniformParam.Float2fParam("directionalTexelStep", f, (float)(d1 * d2 / 1024.0D)));
    }
    return super.render(paramFrame);
  }
  
  public void resetParameters()
  {
    addParam(new UniformParam.Float2fParam("directionalTexelStep", 0.0F, 0.0F));
    addParam(new UniformParam.Float2fParam("motionBlurEllipseCenter", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("motionBlurEllipseA", 0.0F));
    addParam(new UniformParam.FloatParam("motionBlurEllipseB", 0.0F));
    addParam(new UniformParam.IntParam("directionalTexelNumSamples", 5));
    addParam(new UniformParam.FloatParam("motionBlurEllipseGradientRatio", 0.1F));
  }
  
  public void setParameters(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt1, float paramFloat6, int paramInt2)
  {
    this.mMotionBlurSize = paramFloat1;
    if ((paramFloat2 >= 0.0F) && (paramFloat3 >= 0.0F)) {
      addParam(new UniformParam.Float2fParam("motionBlurEllipseCenter", paramFloat2, paramFloat3));
    }
    if (paramFloat4 >= 0.0F) {
      addParam(new UniformParam.FloatParam("motionBlurEllipseA", paramFloat4));
    }
    if (paramFloat5 >= 0.0F) {
      addParam(new UniformParam.FloatParam("motionBlurEllipseB", paramFloat5));
    }
    if (paramInt1 > 0) {
      addParam(new UniformParam.IntParam("directionalTexelNumSamples", paramInt1));
    }
    paramFloat1 = 1.0F - paramFloat6;
    if ((paramFloat1 >= 0.0F) && (paramFloat1 <= 1.0F)) {
      addParam(new UniformParam.FloatParam("motionBlurEllipseGradientRatio", paramFloat1));
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 360)) {
      this.mMotionBlurAngle = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.filter.MotionBlurFilter
 * JD-Core Version:    0.7.0.1
 */