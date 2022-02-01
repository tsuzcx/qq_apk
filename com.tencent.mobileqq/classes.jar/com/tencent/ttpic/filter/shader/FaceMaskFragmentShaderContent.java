package com.tencent.ttpic.filter.shader;

public abstract interface FaceMaskFragmentShaderContent
{
  public static final String CONTENT = " precision highp float;\n varying vec2 grayTextureCoordinate;\n uniform sampler2D inputImageTexture2;\n void main(void) {\n    vec4 graycolor= texture2D(inputImageTexture2, grayTextureCoordinate);\n    float grayColorR=1.0-graycolor.r;\n    if(graycolor.r<0.981){\n        gl_FragColor = vec4(grayColorR,grayColorR,grayColorR,1.0);\n    }\n\n }";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.FaceMaskFragmentShaderContent
 * JD-Core Version:    0.7.0.1
 */