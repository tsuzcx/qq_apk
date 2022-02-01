package com.tencent.ttpic.filter.shader;

public abstract interface UpDownFragmentShaderContent
{
  public static final String CONTENT = "\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp float l;\nuniform highp float r;\n\nvoid main()\n{\n    highp float delta;\n    if (textureCoordinate.x < 0.5) {\n        delta = l;\n    }\n    else {\n        delta = r;\n    }\n\n    highp float v = textureCoordinate.y+delta;\n    if (v > 1.0 || v < 0.0) {\n        gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n    }\n    else {\n        gl_FragColor = texture2D(inputImageTexture, vec2(textureCoordinate.x, v));\n    }\n}\n";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.UpDownFragmentShaderContent
 * JD-Core Version:    0.7.0.1
 */