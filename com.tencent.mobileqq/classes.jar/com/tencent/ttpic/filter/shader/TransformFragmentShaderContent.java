package com.tencent.ttpic.filter.shader;

public abstract interface TransformFragmentShaderContent
{
  public static final String CONTENT = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n void main() {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.TransformFragmentShaderContent
 * JD-Core Version:    0.7.0.1
 */