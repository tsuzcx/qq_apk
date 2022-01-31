package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.filter.DirectionalBlurFilter;

public class HighlightShadowFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\n \n varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n uniform float highlights;\n uniform float shadows;\n \n float powerBow(float inVal, float mag) {\n     float outVal;\n     float power = 1.0 + abs(mag);\n     \n     if (mag > 0.0) {\n         power = 1.0 / power;\n     }\n     \n     outVal = pow(inVal, power);\n     \n     return outVal;\n }\n \n vec3 rgbToHsv(vec3 c) {\n     vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n     vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);\n     vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);\n     \n     float d = q.x - min(q.w, q.y);\n     float e = 1.0e-10;\n     return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n }\n \n float getBowValue(float sign, float inLum) {\n     if (sign > 0.0) {\n         float base = 2.0;\n         return log2(inLum * base + 1.0) / log2(base + 1.0);\n     } else {\n         return pow(inLum, 1.8);\n     }\n }\n \n float shadowsAdjust(float inLum, float inBlurredLum, float shadowsAmount) {\n     float darkVal = getBowValue(shadowsAmount, inLum);\n     float brightVal = 0.0;\n     if (shadowsAmount > 0.0) {\n         brightVal = powerBow(inLum, 0.1);\n     } else {\n         brightVal = powerBow(inLum, -0.1);\n     }\n     \n     float mixVal = clamp((inBlurredLum - 0.00)/0.4, 0.0, 1.0);\n     float mixedVal = mix(darkVal, brightVal, inBlurredLum);\n     \n     return mix(inLum, mixedVal, abs(shadowsAmount));\n }\n \n float highlightsAdjust(float inLum, float inBlurredLum, float highlightsAmount) {\n     float darkVal = 0.0;\n     float brightVal = 1.0 - getBowValue(-highlightsAmount, 1.0 - inLum);\n     if (highlightsAmount < 0.0) {\n         darkVal = 1.0 - powerBow(1.0 - inLum, 0.1);\n     } else {\n         darkVal = 1.0 - powerBow(1.0 - inLum, -0.1);\n     }\n     \n     float mixVal = clamp((inBlurredLum - 0.6)/0.4, 0.0, 1.0);\n     float mixedVal = mix(darkVal, brightVal, inBlurredLum);\n     \n     return mix(inLum, mixedVal, abs(highlightsAmount));\n }\n \n \n void main() {\n     vec4 texel = texture2D(inputImageTexture, textureCoordinate);\n     vec3 blurredTexel = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     float blurredLum = rgbToHsv(blurredTexel).z;\n     \n     if ((abs(highlights) > 0.01)) {\n         texel.r = highlightsAdjust(texel.r, blurredLum, highlights);\n         texel.g = highlightsAdjust(texel.g, blurredLum, highlights);\n         texel.b = highlightsAdjust(texel.b, blurredLum, highlights);\n     }\n     \n     if (abs(shadows) > 0.01) {\n         texel.r = shadowsAdjust(texel.r, blurredLum, shadows);\n         texel.g = shadowsAdjust(texel.g, blurredLum, shadows);\n         texel.b = shadowsAdjust(texel.b, blurredLum, shadows);\n     }\n     \n     gl_FragColor = texel;\n }\n";
  private DirectionalBlurFilter mBlurFilter = new DirectionalBlurFilter();
  private Frame mBlurFrame1 = new Frame();
  private Frame mBlurFrame2 = new Frame();
  private float mHighlights;
  private float mShadows;
  
  public HighlightShadowFilter()
  {
    super("precision mediump float;\n \n varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n uniform float highlights;\n uniform float shadows;\n \n float powerBow(float inVal, float mag) {\n     float outVal;\n     float power = 1.0 + abs(mag);\n     \n     if (mag > 0.0) {\n         power = 1.0 / power;\n     }\n     \n     outVal = pow(inVal, power);\n     \n     return outVal;\n }\n \n vec3 rgbToHsv(vec3 c) {\n     vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n     vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);\n     vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);\n     \n     float d = q.x - min(q.w, q.y);\n     float e = 1.0e-10;\n     return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n }\n \n float getBowValue(float sign, float inLum) {\n     if (sign > 0.0) {\n         float base = 2.0;\n         return log2(inLum * base + 1.0) / log2(base + 1.0);\n     } else {\n         return pow(inLum, 1.8);\n     }\n }\n \n float shadowsAdjust(float inLum, float inBlurredLum, float shadowsAmount) {\n     float darkVal = getBowValue(shadowsAmount, inLum);\n     float brightVal = 0.0;\n     if (shadowsAmount > 0.0) {\n         brightVal = powerBow(inLum, 0.1);\n     } else {\n         brightVal = powerBow(inLum, -0.1);\n     }\n     \n     float mixVal = clamp((inBlurredLum - 0.00)/0.4, 0.0, 1.0);\n     float mixedVal = mix(darkVal, brightVal, inBlurredLum);\n     \n     return mix(inLum, mixedVal, abs(shadowsAmount));\n }\n \n float highlightsAdjust(float inLum, float inBlurredLum, float highlightsAmount) {\n     float darkVal = 0.0;\n     float brightVal = 1.0 - getBowValue(-highlightsAmount, 1.0 - inLum);\n     if (highlightsAmount < 0.0) {\n         darkVal = 1.0 - powerBow(1.0 - inLum, 0.1);\n     } else {\n         darkVal = 1.0 - powerBow(1.0 - inLum, -0.1);\n     }\n     \n     float mixVal = clamp((inBlurredLum - 0.6)/0.4, 0.0, 1.0);\n     float mixedVal = mix(darkVal, brightVal, inBlurredLum);\n     \n     return mix(inLum, mixedVal, abs(highlightsAmount));\n }\n \n \n void main() {\n     vec4 texel = texture2D(inputImageTexture, textureCoordinate);\n     vec3 blurredTexel = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     float blurredLum = rgbToHsv(blurredTexel).z;\n     \n     if ((abs(highlights) > 0.01)) {\n         texel.r = highlightsAdjust(texel.r, blurredLum, highlights);\n         texel.g = highlightsAdjust(texel.g, blurredLum, highlights);\n         texel.b = highlightsAdjust(texel.b, blurredLum, highlights);\n     }\n     \n     if (abs(shadows) > 0.01) {\n         texel.r = shadowsAdjust(texel.r, blurredLum, shadows);\n         texel.g = shadowsAdjust(texel.g, blurredLum, shadows);\n         texel.b = shadowsAdjust(texel.b, blurredLum, shadows);\n     }\n     \n     gl_FragColor = texel;\n }\n");
    addParam(new UniformParam.FloatParam("highlights", 0.0F));
    addParam(new UniformParam.FloatParam("shadows", 0.0F));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mBlurFilter.setTexOffset(1.0F / paramInt2, 0.0F);
    Frame localFrame2 = this.mBlurFilter.RenderProcess(paramInt1, paramInt2, paramInt3);
    this.mBlurFilter.setTexOffset(0.0F, 1.0F / paramInt3);
    Frame localFrame1 = this.mBlurFilter.RenderProcess(localFrame2.getTextureId(), paramInt2, paramInt3);
    localFrame2.unlock();
    addParam(new UniformParam.TextureParam("inputImageTexture2", localFrame1.getTextureId(), 33986));
    localFrame2 = super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    localFrame1.unlock();
    return localFrame2;
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, Frame paramFrame)
  {
    this.mBlurFilter.setTexOffset(1.0F / paramInt2, 0.0F);
    this.mBlurFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mBlurFrame1);
    this.mBlurFilter.setTexOffset(0.0F, 1.0F / paramInt3);
    this.mBlurFilter.RenderProcess(this.mBlurFrame1.getTextureId(), paramInt2, paramInt3, -1, 0.0D, this.mBlurFrame2);
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.mBlurFrame2.getTextureId(), 33986));
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramDouble, paramFrame);
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.mBlurFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void clearGLSLSelf()
  {
    this.mBlurFilter.clearGLSLSelf();
    this.mBlurFrame1.clear();
    this.mBlurFrame2.clear();
    super.clearGLSLSelf();
  }
  
  public Frame render(Frame paramFrame)
  {
    if ((this.mHighlights == 0.0F) && (this.mShadows == 0.0F)) {
      return paramFrame;
    }
    return super.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public void setHighlights(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("highlights", paramFloat));
    this.mHighlights = paramFloat;
  }
  
  public void setShadows(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("shadows", paramFloat));
    this.mShadows = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.HighlightShadowFilter
 * JD-Core Version:    0.7.0.1
 */