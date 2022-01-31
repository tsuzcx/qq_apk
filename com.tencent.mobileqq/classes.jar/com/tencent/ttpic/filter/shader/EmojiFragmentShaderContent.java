package com.tencent.ttpic.filter.shader;

public abstract interface EmojiFragmentShaderContent
{
  public static final String CONTENT = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform vec4 paintColor;\n\nvoid main()\n{\n    vec4 color = texture2D (inputImageTexture, textureCoordinate);\n    if(paintColor.a > 0.5){\n        gl_FragColor = vec4(paintColor.rgb * color.a, color.a);\n    } else {\n        gl_FragColor = color;\n    }\n}";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.shader.EmojiFragmentShaderContent
 * JD-Core Version:    0.7.0.1
 */