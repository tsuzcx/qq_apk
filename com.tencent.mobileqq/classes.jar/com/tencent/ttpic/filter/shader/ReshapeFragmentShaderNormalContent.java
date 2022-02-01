package com.tencent.ttpic.filter.shader;

public abstract interface ReshapeFragmentShaderNormalContent
{
  public static final String CONTENT = "#ifdef GL_FRAGMENT_PRECISION_HIGH\n    precision highp float; //支持高精度，限定浮点型为高精度\n#else\n    precision mediump float; //不支持高精度，限定浮点型为中精度\n#endif\n\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n    //gl_FragColor = vec4(inputTextureCoordinate.xy, vec2(0.0, 1.0));\n\n    //vec4 color = vec4(textureCoordinate.x*8.0+0.5, textureCoordinate.y*8.0+0.5, 0.5, 1.0);\n    //gl_FragColor = color;\n\n    //gl_FragColor = vec4(textureCoordinate, textureCoordinate.x, 1.0);\n\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.ReshapeFragmentShaderNormalContent
 * JD-Core Version:    0.7.0.1
 */