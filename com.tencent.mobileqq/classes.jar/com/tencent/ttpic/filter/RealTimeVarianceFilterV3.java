package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class RealTimeVarianceFilterV3
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\nvarying highp vec2 canvasCoordinate;\nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \nuniform highp float skinAlpha;\n\nlowp vec3 rgb2hsv(lowp vec3 c) {\n  lowp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n  highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n  highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n  highp float d = q.x - min(q.w, q.y);\n  highp float e = 1.0e-10;\n  lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n  return hsv;\n}\n \nvoid main() \n{ \n  lowp vec3 iColor = texture2D(inputImageTexture, canvasCoordinate).rgb;\n  lowp vec3 meanColor = texture2D(inputImageTexture2, canvasCoordinate).rgb;\n  lowp vec3 diffColor = (iColor - meanColor) * 7.07;\n  diffColor = min(diffColor * diffColor, 1.0);\n     \n  lowp float theta = 0.1;\n  mediump float diffAvg = (diffColor.r + diffColor.g + diffColor.b) / 3.0;\n  mediump float diffFactor = (1.0 - diffAvg / (diffAvg + theta));\n  \n  lowp vec3 hsv = rgb2hsv(iColor.rgb);\n  mediump float p1 = clamp((min(iColor.r, meanColor.r - 0.1) - 0.2) * 4.0, 0.0, 1.0);\n  mediump float p2_left = (0.18 - clamp(hsv.x, 0.16, 0.18)) / 0.02;\n  mediump float p2_right = 1.0 - (0.91 - clamp(hsv.x, 0.89, 0.91)) / 0.02;\n  mediump float p2_value = 1.0 - (0.3 - clamp(hsv.z, 0.2, 0.3)) / 0.1;\n  mediump float p2 = min(max(p2_left, p2_right), p2_value);\n  mediump float p = max(p1, p2);\n  \n  mediump float kSkin = skinAlpha;\n  lowp vec2 centerPos = vec2(0.5, 0.5);\n  highp float centerDis = distance(textureCoordinate, centerPos);\n  highp float centerFactor = (clamp(0.7071 - centerDis, 0.0, 0.3071)) / 0.3071;// 0.7071=length(vec2(0.5))\n  kSkin *= centerFactor;\n  \n  mediump float kMin = diffFactor * p * kSkin;\n  mediump vec3 maskColor = vec3(diffAvg, kMin, kSkin);\n  gl_FragColor = vec4(maskColor, 1.0);\n  \n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  
  public RealTimeVarianceFilterV3()
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n", "varying highp vec2 textureCoordinate;\nvarying highp vec2 canvasCoordinate;\nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \nuniform highp float skinAlpha;\n\nlowp vec3 rgb2hsv(lowp vec3 c) {\n  lowp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n  highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n  highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n  highp float d = q.x - min(q.w, q.y);\n  highp float e = 1.0e-10;\n  lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n  return hsv;\n}\n \nvoid main() \n{ \n  lowp vec3 iColor = texture2D(inputImageTexture, canvasCoordinate).rgb;\n  lowp vec3 meanColor = texture2D(inputImageTexture2, canvasCoordinate).rgb;\n  lowp vec3 diffColor = (iColor - meanColor) * 7.07;\n  diffColor = min(diffColor * diffColor, 1.0);\n     \n  lowp float theta = 0.1;\n  mediump float diffAvg = (diffColor.r + diffColor.g + diffColor.b) / 3.0;\n  mediump float diffFactor = (1.0 - diffAvg / (diffAvg + theta));\n  \n  lowp vec3 hsv = rgb2hsv(iColor.rgb);\n  mediump float p1 = clamp((min(iColor.r, meanColor.r - 0.1) - 0.2) * 4.0, 0.0, 1.0);\n  mediump float p2_left = (0.18 - clamp(hsv.x, 0.16, 0.18)) / 0.02;\n  mediump float p2_right = 1.0 - (0.91 - clamp(hsv.x, 0.89, 0.91)) / 0.02;\n  mediump float p2_value = 1.0 - (0.3 - clamp(hsv.z, 0.2, 0.3)) / 0.1;\n  mediump float p2 = min(max(p2_left, p2_right), p2_value);\n  mediump float p = max(p1, p2);\n  \n  mediump float kSkin = skinAlpha;\n  lowp vec2 centerPos = vec2(0.5, 0.5);\n  highp float centerDis = distance(textureCoordinate, centerPos);\n  highp float centerFactor = (clamp(0.7071 - centerDis, 0.0, 0.3071)) / 0.3071;// 0.7071=length(vec2(0.5))\n  kSkin *= centerFactor;\n  \n  mediump float kMin = diffFactor * p * kSkin;\n  mediump vec3 maskColor = vec3(diffAvg, kMin, kSkin);\n  gl_FragColor = vec4(maskColor, 1.0);\n  \n}\n");
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.FloatParam("skinAlpha", 1.0F));
  }
  
  public void setSkinAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("skinAlpha", paramFloat));
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.RealTimeVarianceFilterV3
 * JD-Core Version:    0.7.0.1
 */