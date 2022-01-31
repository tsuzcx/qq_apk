package com.tencent.vbox.filter;

import com.tencent.filter.BaseFilter;

public class Yuv24ToRgbFilter
  extends BaseFilter
{
  public Yuv24ToRgbFilter()
  {
    super("precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n const mat4 conversion = mat4(1.0, 0.0, 1.402, -0.701, 1.0, -0.344, -0.714, 0.529, 1.0, 1.772, 0.0, -0.886, 0.0, 0.0, 0.0, 0.0);\n void main()\n {\n     vec4 yuv = texture2D(inputImageTexture, textureCoordinate);\n     vec3 rgba = (yuv * conversion).xyz;\n     gl_FragColor = vec4(rgba, 1.0);\n }\n");
  }
  
  private void initParams() {}
  
  public void apply()
  {
    initParams();
    super.apply();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    initParams();
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.filter.Yuv24ToRgbFilter
 * JD-Core Version:    0.7.0.1
 */