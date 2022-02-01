package com.tencent.ttpic.openapi.filter.stylizefilter;

import com.tencent.aekit.openrender.UniformParam.Float2sParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class BSkinSmoothProcessFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = " precision highp float; \n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinateUpscale;\n varying highp vec2 textureScale;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n uniform highp float blurOpacity;\n uniform lowp float factor1;\n uniform lowp float factor2;\n uniform lowp float factor3;\n uniform lowp float factor4;\n uniform lowp float factor5;\n uniform lowp float factor6;\n uniform lowp float factor7;\n uniform lowp float filterOpacity;\n \n lowp vec3 rgb2hsv(lowp vec3 c)\n{\n    lowp    vec4    K   = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n    lowp    vec4    p   = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n    lowp    vec4    q   = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n    lowp    float   d   = q.x - min(q.w, q.y);\n    lowp    float   e   = 1.0e-10;\n    lowp    vec3    hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n    return hsv;\n}\n \n lowp vec3 ContrastSaturationBrightness(lowp vec3 color, lowp float brt, lowp float sat, lowp float con)\n{\n    const lowp float AvgLumR = 0.5;\n    const lowp float AvgLumG = 0.5;\n    const lowp float AvgLumB = 0.5;\n    \n    const lowp vec3 LumCoeff    = vec3(0.2125, 0.7154, 0.0721);\n    lowp vec3 AvgLumin          = vec3(AvgLumR, AvgLumG, AvgLumB);\n    lowp vec3 brtColor      = color * brt;\n    lowp vec3 intensity     = vec3(dot(brtColor, LumCoeff));\n    lowp vec3 satColor      = mix(intensity, brtColor, sat);\n    lowp vec3 conColor      = mix(AvgLumin, satColor, con);\n    return conColor;\n}\n \n void main()\n{\n    lowp vec4 inputColor    = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec3 hsv           = rgb2hsv(inputColor.rgb);\n    \n    lowp float opacityLimit = 1.0;\n    if ((0.18 <= hsv.x && hsv.x <= 0.89) || hsv.z <= 0.2) {\n        opacityLimit = 0.0;\n    }\n    if (0.16 < hsv.x && hsv.x < 0.18) {\n        opacityLimit = min(opacityLimit, (0.18 - hsv.x) / 0.02);\n    }\n    if (0.89 < hsv.x && hsv.x < 0.91) {\n        opacityLimit = min(opacityLimit, 1.0 - (0.91 - hsv.x) / 0.02);\n    }\n    if (0.2 < hsv.z && hsv.x < 0.3) {\n        opacityLimit = min(opacityLimit, 1.0 - (0.3 - hsv.z) / 0.1);\n    }\n    if (opacityLimit == 0.0) {\n        gl_FragColor = inputColor;\n        return;\n    }\n    \n    lowp vec4 blurColor = texture2D (inputImageTexture2, textureCoordinate);\n    opacityLimit        = blurOpacity * opacityLimit;\n\n    \n    lowp float  cDistance   = distance(vec3(0.0, 0.0, 0.0), max(blurColor.rgb - inputColor.rgb, 0.0)) * factor1;\n\n    lowp vec3   brightColor = inputColor.rgb;\n\n    lowp vec3   mix11Color  = mix(inputColor.rgb, brightColor.rgb, cDistance);\n\n    lowp float  dDistance       = distance(vec3(0.0, 0.0, 0.0), max(inputColor.rgb-blurColor.rgb, 0.0)) * factor4;\n\n    lowp vec3   darkColor       = inputColor.rgb;\n\n    lowp vec3   mix115Color     = mix(mix11Color.rgb, darkColor.rgb, dDistance);\n\n    lowp vec3 mix12Color;\n\n    mix12Color     = mix(inputColor.rgb, blurColor.rgb, blurOpacity);\n\n    if (filterOpacity < 0.999) {\n        gl_FragColor = vec4(mix(inputColor.rgb, mix12Color.rgb, filterOpacity), 1.0);\n    }\n    else {\n        gl_FragColor = vec4(mix12Color.rgb, 1.0);\n    }\n} \n";
  private static final String VERTEX_SHADER = " precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n uniform vec2 inputTextureSize;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinateUpscale;\n varying vec2 textureScale;\n void main()\n{\n    gl_Position                 = position;\n    textureScale                = 1.0 / inputTextureSize;\n    textureCoordinate           = inputTextureCoordinate.xy;\n    textureCoordinateUpscale    = inputTextureCoordinate.xy * inputTextureSize;\n} \n";
  
  public BSkinSmoothProcessFilter()
  {
    super(" precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n uniform vec2 inputTextureSize;\n varying vec2 textureCoordinate;\n varying vec2 textureCoordinateUpscale;\n varying vec2 textureScale;\n void main()\n{\n    gl_Position                 = position;\n    textureScale                = 1.0 / inputTextureSize;\n    textureCoordinate           = inputTextureCoordinate.xy;\n    textureCoordinateUpscale    = inputTextureCoordinate.xy * inputTextureSize;\n} \n", " precision highp float; \n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinateUpscale;\n varying highp vec2 textureScale;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n uniform highp float blurOpacity;\n uniform lowp float factor1;\n uniform lowp float factor2;\n uniform lowp float factor3;\n uniform lowp float factor4;\n uniform lowp float factor5;\n uniform lowp float factor6;\n uniform lowp float factor7;\n uniform lowp float filterOpacity;\n \n lowp vec3 rgb2hsv(lowp vec3 c)\n{\n    lowp    vec4    K   = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n    lowp    vec4    p   = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n    lowp    vec4    q   = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n    lowp    float   d   = q.x - min(q.w, q.y);\n    lowp    float   e   = 1.0e-10;\n    lowp    vec3    hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n    return hsv;\n}\n \n lowp vec3 ContrastSaturationBrightness(lowp vec3 color, lowp float brt, lowp float sat, lowp float con)\n{\n    const lowp float AvgLumR = 0.5;\n    const lowp float AvgLumG = 0.5;\n    const lowp float AvgLumB = 0.5;\n    \n    const lowp vec3 LumCoeff    = vec3(0.2125, 0.7154, 0.0721);\n    lowp vec3 AvgLumin          = vec3(AvgLumR, AvgLumG, AvgLumB);\n    lowp vec3 brtColor      = color * brt;\n    lowp vec3 intensity     = vec3(dot(brtColor, LumCoeff));\n    lowp vec3 satColor      = mix(intensity, brtColor, sat);\n    lowp vec3 conColor      = mix(AvgLumin, satColor, con);\n    return conColor;\n}\n \n void main()\n{\n    lowp vec4 inputColor    = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec3 hsv           = rgb2hsv(inputColor.rgb);\n    \n    lowp float opacityLimit = 1.0;\n    if ((0.18 <= hsv.x && hsv.x <= 0.89) || hsv.z <= 0.2) {\n        opacityLimit = 0.0;\n    }\n    if (0.16 < hsv.x && hsv.x < 0.18) {\n        opacityLimit = min(opacityLimit, (0.18 - hsv.x) / 0.02);\n    }\n    if (0.89 < hsv.x && hsv.x < 0.91) {\n        opacityLimit = min(opacityLimit, 1.0 - (0.91 - hsv.x) / 0.02);\n    }\n    if (0.2 < hsv.z && hsv.x < 0.3) {\n        opacityLimit = min(opacityLimit, 1.0 - (0.3 - hsv.z) / 0.1);\n    }\n    if (opacityLimit == 0.0) {\n        gl_FragColor = inputColor;\n        return;\n    }\n    \n    lowp vec4 blurColor = texture2D (inputImageTexture2, textureCoordinate);\n    opacityLimit        = blurOpacity * opacityLimit;\n\n    \n    lowp float  cDistance   = distance(vec3(0.0, 0.0, 0.0), max(blurColor.rgb - inputColor.rgb, 0.0)) * factor1;\n\n    lowp vec3   brightColor = inputColor.rgb;\n\n    lowp vec3   mix11Color  = mix(inputColor.rgb, brightColor.rgb, cDistance);\n\n    lowp float  dDistance       = distance(vec3(0.0, 0.0, 0.0), max(inputColor.rgb-blurColor.rgb, 0.0)) * factor4;\n\n    lowp vec3   darkColor       = inputColor.rgb;\n\n    lowp vec3   mix115Color     = mix(mix11Color.rgb, darkColor.rgb, dDistance);\n\n    lowp vec3 mix12Color;\n\n    mix12Color     = mix(inputColor.rgb, blurColor.rgb, blurOpacity);\n\n    if (filterOpacity < 0.999) {\n        gl_FragColor = vec4(mix(inputColor.rgb, mix12Color.rgb, filterOpacity), 1.0);\n    }\n    else {\n        gl_FragColor = vec4(mix12Color.rgb, 1.0);\n    }\n} \n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("blurOpacity", 0.2F));
    addParam(new UniformParam.Float2sParam("inputTextureSize", new float[] { 0.0F, 0.0F }));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.FloatParam("factor1", 2.0F));
    addParam(new UniformParam.FloatParam("factor2", 1.17F));
    addParam(new UniformParam.FloatParam("factor3", 1.125F));
    addParam(new UniformParam.FloatParam("factor4", 0.8F));
    addParam(new UniformParam.FloatParam("factor5", 0.8F));
    addParam(new UniformParam.FloatParam("factor6", 0.8F));
    addParam(new UniformParam.FloatParam("factor7", 1.0F));
    addParam(new UniformParam.FloatParam("filterOpacity", 0.7233F));
  }
  
  public void setTexture2(Frame paramFrame)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramFrame.getTextureId(), 33986));
    addParam(new UniformParam.Float2sParam("inputTextureSize", new float[] { paramFrame.width, paramFrame.height }));
  }
  
  public void updateSmoothOpacity(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("blurOpacity", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.BSkinSmoothProcessFilter
 * JD-Core Version:    0.7.0.1
 */