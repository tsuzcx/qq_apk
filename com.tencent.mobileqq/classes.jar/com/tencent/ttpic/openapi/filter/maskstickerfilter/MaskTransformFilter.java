package com.tencent.ttpic.openapi.filter.maskstickerfilter;

import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class MaskTransformFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n void main() {\n   gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    gl_PointSize = 1.0;\n    textureCoordinate = inputTextureCoordinate.xy;\n}\n";
  
  public MaskTransformFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    gl_PointSize = 1.0;\n    textureCoordinate = inputTextureCoordinate.xy;\n}\n", "precision highp float;\n uniform sampler2D inputImageTexture;\n varying highp vec2 textureCoordinate;\n void main() {\n   gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }");
    initParams();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
  }
  
  public void initParams() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.maskstickerfilter.MaskTransformFilter
 * JD-Core Version:    0.7.0.1
 */