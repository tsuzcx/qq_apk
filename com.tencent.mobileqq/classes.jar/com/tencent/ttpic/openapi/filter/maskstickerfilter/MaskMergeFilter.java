package com.tencent.ttpic.openapi.filter.maskstickerfilter;

import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class MaskMergeFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n varying highp vec2 textureCoordinate;\n uniform int mergeType;\n void main() {\n    vec4 canvasColor= texture2D(inputImageTexture2, textureCoordinate);\n    vec4 texColor= texture2D(inputImageTexture, textureCoordinate);\n   vec3 resultFore = texColor.rgb;\n   float maskAlpha = canvasColor.r;\n     if (mergeType == 1) {\n          resultFore = resultFore * maskAlpha;\n          texColor.a = maskAlpha * texColor.a;\n     } else if (mergeType == 2) {\n          resultFore = resultFore * (1.0 - maskAlpha);\n          texColor.a = (1.0 - maskAlpha)* texColor.a;\n     } else {\n          resultFore = resultFore * maskAlpha;\n          texColor.a = maskAlpha* texColor.a;\n     }\n         gl_FragColor = vec4(resultFore, texColor.a);\n }";
  private int mMergeType = 1;
  
  public MaskMergeFilter()
  {
    super("precision highp float;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n varying highp vec2 textureCoordinate;\n uniform int mergeType;\n void main() {\n    vec4 canvasColor= texture2D(inputImageTexture2, textureCoordinate);\n    vec4 texColor= texture2D(inputImageTexture, textureCoordinate);\n   vec3 resultFore = texColor.rgb;\n   float maskAlpha = canvasColor.r;\n     if (mergeType == 1) {\n          resultFore = resultFore * maskAlpha;\n          texColor.a = maskAlpha * texColor.a;\n     } else if (mergeType == 2) {\n          resultFore = resultFore * (1.0 - maskAlpha);\n          texColor.a = (1.0 - maskAlpha)* texColor.a;\n     } else {\n          resultFore = resultFore * maskAlpha;\n          texColor.a = maskAlpha* texColor.a;\n     }\n         gl_FragColor = vec4(resultFore, texColor.a);\n }");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.IntParam("mergeType", this.mMergeType));
  }
  
  public void setMergeType(int paramInt)
  {
    this.mMergeType = paramInt;
    addParam(new UniformParam.IntParam("mergeType", this.mMergeType));
  }
  
  public void updateTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.maskstickerfilter.MaskMergeFilter
 * JD-Core Version:    0.7.0.1
 */