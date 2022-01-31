package com.tencent.ttpic.filter.shader;

public abstract interface FaceCropFragmentShaderContent
{
  public static final String CONTENT = "precision mediump float;\nvarying lowp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n\nvoid main(void) {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.FaceCropFragmentShaderContent
 * JD-Core Version:    0.7.0.1
 */