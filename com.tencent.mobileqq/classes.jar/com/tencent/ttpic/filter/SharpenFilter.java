package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class SharpenFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\nuniform float width;\nuniform float height;\nuniform float sharpness;\n\nvec4 sharpenColor(vec4 mixColor, vec4 iColor, float sharpen) {\n     float sum = 0.25*iColor.g;\n     float horStep = 1.0 / width; \n     float verStep = 1.0 / height; \n     sum += 0.125*texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, 0.0)).g;\n     sum += 0.125*texture2D(inputImageTexture, textureCoordinate+vec2(horStep, 0.0)).g;\n     sum += 0.125*texture2D(inputImageTexture, textureCoordinate+vec2(0.0, -verStep)).g;\n     sum += 0.125*texture2D(inputImageTexture, textureCoordinate+vec2(0.0, verStep)).g;\n     sum += 0.0625*texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, -verStep)).g;\n     sum += 0.0625*texture2D(inputImageTexture, textureCoordinate+vec2(horStep, -verStep)).g;\n     sum += 0.0625*texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, verStep)).g;\n     sum += 0.0625*texture2D(inputImageTexture, textureCoordinate+vec2(horStep, verStep)).g;\n     \n     float hPass = iColor.g-sum;\n     vec3 sColor = max(vec3(0.0), min(vec3(1.0), (mixColor.rgb + hPass * 2.0 * sharpen)));\n     return vec4(sColor, mixColor.a);\n} \n\n\nvoid main() {\n    vec4 origin = texture2D(inputImageTexture, textureCoordinate);\n    vec4 color0 = origin;\n    if (sharpness > 0.0) {\n        color0 = sharpenColor(color0, origin, sharpness);\n    }\n    gl_FragColor = color0;\n}\n";
  private float sharpness = 0.0F;
  
  public SharpenFilter()
  {
    super("precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\nuniform float width;\nuniform float height;\nuniform float sharpness;\n\nvec4 sharpenColor(vec4 mixColor, vec4 iColor, float sharpen) {\n     float sum = 0.25*iColor.g;\n     float horStep = 1.0 / width; \n     float verStep = 1.0 / height; \n     sum += 0.125*texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, 0.0)).g;\n     sum += 0.125*texture2D(inputImageTexture, textureCoordinate+vec2(horStep, 0.0)).g;\n     sum += 0.125*texture2D(inputImageTexture, textureCoordinate+vec2(0.0, -verStep)).g;\n     sum += 0.125*texture2D(inputImageTexture, textureCoordinate+vec2(0.0, verStep)).g;\n     sum += 0.0625*texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, -verStep)).g;\n     sum += 0.0625*texture2D(inputImageTexture, textureCoordinate+vec2(horStep, -verStep)).g;\n     sum += 0.0625*texture2D(inputImageTexture, textureCoordinate+vec2(-horStep, verStep)).g;\n     sum += 0.0625*texture2D(inputImageTexture, textureCoordinate+vec2(horStep, verStep)).g;\n     \n     float hPass = iColor.g-sum;\n     vec3 sColor = max(vec3(0.0), min(vec3(1.0), (mixColor.rgb + hPass * 2.0 * sharpen)));\n     return vec4(sColor, mixColor.a);\n} \n\n\nvoid main() {\n    vec4 origin = texture2D(inputImageTexture, textureCoordinate);\n    vec4 color0 = origin;\n    if (sharpness > 0.0) {\n        color0 = sharpenColor(color0, origin, sharpness);\n    }\n    gl_FragColor = color0;\n}\n");
    addParam(new UniformParam.FloatParam("width", 720.0F));
    addParam(new UniformParam.FloatParam("height", 960.0F));
    addParam(new UniformParam.FloatParam("sharpness", this.sharpness));
  }
  
  public void updateSharpness(float paramFloat)
  {
    this.sharpness = paramFloat;
    addParam(new UniformParam.FloatParam("sharpness", paramFloat));
  }
  
  public void updateSize(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("width", paramFloat1));
    addParam(new UniformParam.FloatParam("height", paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.SharpenFilter
 * JD-Core Version:    0.7.0.1
 */