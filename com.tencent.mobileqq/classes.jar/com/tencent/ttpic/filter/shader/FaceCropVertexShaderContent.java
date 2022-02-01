package com.tencent.ttpic.filter.shader;

public abstract interface FaceCropVertexShaderContent
{
  public static final String CONTENT = "precision highp float;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(void) {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.FaceCropVertexShaderContent
 * JD-Core Version:    0.7.0.1
 */