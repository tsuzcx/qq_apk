package com.tencent.ttpic.videoshelf.filter;

import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class VideoShelfAlphaFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\nuniform int videoTemplateType;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n    highp vec2 scaleOffset = vec2(0.5, 1);\n    if (videoTemplateType != 0) {\n        scaleOffset = vec2(1, 0.5);\n    }\n    highp vec2 textureCoordinateReal = vec2(textureCoordinate);\n    //textureCoordinateReal.x = textureCoordinate.x * 0.5;\n    textureCoordinateReal = textureCoordinate * scaleOffset;\n    highp vec4 sourceColor = texture2D(inputImageTexture, textureCoordinateReal);\n    scaleOffset = vec2(0.5, 0);\n    if (videoTemplateType != 0) {\n        scaleOffset = vec2(0, 0.5);\n    }\n    highp vec2 textureCoordinateMask = vec2(textureCoordinateReal);\n    textureCoordinateMask = textureCoordinateMask + scaleOffset;\n    //textureCoordinateMask.x += 0.5;\n    highp vec4 maskColor = texture2D(inputImageTexture, textureCoordinateMask);\n    highp float a = maskColor.r;\n    highp vec4 outputColor = vec4(sourceColor);\n    outputColor.a = a;\n    if (a == 1.0) {\n        //    outputColor = vec4(1.0, 0, 0, 1.0); //test\n    }\n    gl_FragColor = outputColor;\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  
  public VideoShelfAlphaFilter()
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "varying highp vec2 textureCoordinate;\nuniform int videoTemplateType;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n    highp vec2 scaleOffset = vec2(0.5, 1);\n    if (videoTemplateType != 0) {\n        scaleOffset = vec2(1, 0.5);\n    }\n    highp vec2 textureCoordinateReal = vec2(textureCoordinate);\n    //textureCoordinateReal.x = textureCoordinate.x * 0.5;\n    textureCoordinateReal = textureCoordinate * scaleOffset;\n    highp vec4 sourceColor = texture2D(inputImageTexture, textureCoordinateReal);\n    scaleOffset = vec2(0.5, 0);\n    if (videoTemplateType != 0) {\n        scaleOffset = vec2(0, 0.5);\n    }\n    highp vec2 textureCoordinateMask = vec2(textureCoordinateReal);\n    textureCoordinateMask = textureCoordinateMask + scaleOffset;\n    //textureCoordinateMask.x += 0.5;\n    highp vec4 maskColor = texture2D(inputImageTexture, textureCoordinateMask);\n    highp float a = maskColor.r;\n    highp vec4 outputColor = vec4(sourceColor);\n    outputColor.a = a;\n    if (a == 1.0) {\n        //    outputColor = vec4(1.0, 0, 0, 1.0); //test\n    }\n    gl_FragColor = outputColor;\n}\n");
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("videoTemplateType", 0));
  }
  
  public void updateVideoTemplateType(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = 0;; paramInt = 1)
    {
      addParam(new UniformParam.IntParam("videoTemplateType", paramInt));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.filter.VideoShelfAlphaFilter
 * JD-Core Version:    0.7.0.1
 */