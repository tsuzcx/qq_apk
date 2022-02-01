package com.tencent.ttpic.openapi.filter;

import com.tencent.filter.BaseFilter;

public class TransformMaskFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n\nvoid main()\n{\n    vec4 clr_tex1=texture2D(inputImageTexture, textureCoordinate);\n    gl_FragColor =vec4(clr_tex1.a,clr_tex1.a,clr_tex1.a,1.0);\n}";
  
  public TransformMaskFilter()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n\nvoid main()\n{\n    vec4 clr_tex1=texture2D(inputImageTexture, textureCoordinate);\n    gl_FragColor =vec4(clr_tex1.a,clr_tex1.a,clr_tex1.a,1.0);\n}");
    initParams();
  }
  
  private void initParams() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TransformMaskFilter
 * JD-Core Version:    0.7.0.1
 */