package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class AvgColorFilter
  extends BaseFilter
{
  public static final String AVG_FRAGMENT = "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nuniform lowp float width;\nuniform lowp float height;\nhighp vec3 avg_color()\n{\n    highp float dx = 1.0 / width; \n    highp float dy = 1.0 / height; \n      highp vec3 sumColor = vec3(0.0);\n      for (int i = -1; i <= 1 ; i++) {\n        for (int j = -1; j <= 1; j++) {\n            highp float x = textureCoordinate.x + float(i) * dx;\n            highp float y = textureCoordinate.y + float(i) * dy;\n            highp vec3 deltaColor = texture2D(inputImageTexture, vec2(x, y)).rgb;\n            sumColor = sumColor + deltaColor;        }\n      }\n    return sumColor * 0.1111;\n}\nvoid main()\n{\n    highp vec4 outputColor = texture2D(inputImageTexture, textureCoordinate);\n    highp vec3 avgColor = avg_color();\n    gl_FragColor = vec4(avgColor, outputColor.a);\n}\n";
  public static final String RUST_FRAGMENT = "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nuniform lowp float width;\nuniform lowp float height;\nhighp vec3 brightness = vec3(0.2125, 0.7154, 0.0721);\nhighp float rgb2gray(highp vec4 color) {\n    return dot(color.rgb,brightness);\n}\nvoid main()\n{\n    highp float w_delta = 1.0/width;\n    highp float h_delta = 1.0/height;\n    highp vec4 outputColor = texture2D(inputImageTexture, textureCoordinate);\n    highp float curGray= rgb2gray(outputColor);\n    if(curGray < 0.001) {\n       for (int i = -1; i <= 1 ; i++) {\n          for (int j = -1; j <= 1; j++) {\n              if (i+j ==1 || i+j == -1) continue;\n              highp float x = textureCoordinate.x + float(i) * w_delta;\n              highp float y = textureCoordinate.y + float(i) * h_delta;\n              if (rgb2gray(texture2D(inputImageTexture, vec2(x, y))) > 0.1) { \n                  outputColor = texture2D(inputImageTexture, vec2(x, y));break;\n              }\n          }\n      }\n    }\n    gl_FragColor = outputColor;\n}\n";
  
  public AvgColorFilter()
  {
    super("precision highp float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nuniform lowp float width;\nuniform lowp float height;\nhighp vec3 avg_color()\n{\n    highp float dx = 1.0 / width; \n    highp float dy = 1.0 / height; \n      highp vec3 sumColor = vec3(0.0);\n      for (int i = -1; i <= 1 ; i++) {\n        for (int j = -1; j <= 1; j++) {\n            highp float x = textureCoordinate.x + float(i) * dx;\n            highp float y = textureCoordinate.y + float(i) * dy;\n            highp vec3 deltaColor = texture2D(inputImageTexture, vec2(x, y)).rgb;\n            sumColor = sumColor + deltaColor;        }\n      }\n    return sumColor * 0.1111;\n}\nvoid main()\n{\n    highp vec4 outputColor = texture2D(inputImageTexture, textureCoordinate);\n    highp vec3 avgColor = avg_color();\n    gl_FragColor = vec4(avgColor, outputColor.a);\n}\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("width", 540.0F));
    addParam(new UniformParam.FloatParam("height", 960.0F));
  }
  
  public void setAdjustParam(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.FloatParam("width", paramInt1));
    addParam(new UniformParam.FloatParam("height", paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.AvgColorFilter
 * JD-Core Version:    0.7.0.1
 */