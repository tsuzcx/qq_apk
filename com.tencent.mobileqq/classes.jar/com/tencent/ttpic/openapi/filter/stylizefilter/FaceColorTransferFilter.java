package com.tencent.ttpic.openapi.filter.stylizefilter;

import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class FaceColorTransferFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = " precision highp float;\n \n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform highp vec3 originAverageFaceColor;\n uniform highp vec3 cartoonAverageFaceColor;\n \n float faceColorMixColor(vec3 originColor, vec3 originSkin)\n {\n    float distance = sqrt(pow((originColor.x - originSkin.x), 2.0) + pow((originColor.y - originSkin.y), 2.0) + pow((originColor.z - originSkin.z), 2.0));\n    float mixAlpha = distance * 5.0;\n     \n    return min(mixAlpha, 1.0);\n }\n \n void main (void)\n {\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    \n    if (textureColor.a > 0.0001) {\n        lowp float mixAlpha = faceColorMixColor(textureColor.rgb, cartoonAverageFaceColor);\n\n        //    gl_FragColor = textureColor;\n        //    gl_FragColor = vec4(textureColor.rgb * 0.5, 1.0);\n        gl_FragColor = vec4(mix(originAverageFaceColor, textureColor.rgb, mixAlpha), textureColor.a);\n    } else {\n        gl_FragColor = textureColor;\n    }\n    \n    //gl_FragColor = textureColor;\n }\n";
  private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n\n varying vec2 textureCoordinate;\n\n void main() {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  
  public FaceColorTransferFilter()
  {
    super(" attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n\n varying vec2 textureCoordinate;\n\n void main() {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", " precision highp float;\n \n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform highp vec3 originAverageFaceColor;\n uniform highp vec3 cartoonAverageFaceColor;\n \n float faceColorMixColor(vec3 originColor, vec3 originSkin)\n {\n    float distance = sqrt(pow((originColor.x - originSkin.x), 2.0) + pow((originColor.y - originSkin.y), 2.0) + pow((originColor.z - originSkin.z), 2.0));\n    float mixAlpha = distance * 5.0;\n     \n    return min(mixAlpha, 1.0);\n }\n \n void main (void)\n {\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    \n    if (textureColor.a > 0.0001) {\n        lowp float mixAlpha = faceColorMixColor(textureColor.rgb, cartoonAverageFaceColor);\n\n        //    gl_FragColor = textureColor;\n        //    gl_FragColor = vec4(textureColor.rgb * 0.5, 1.0);\n        gl_FragColor = vec4(mix(originAverageFaceColor, textureColor.rgb, mixAlpha), textureColor.a);\n    } else {\n        gl_FragColor = textureColor;\n    }\n    \n    //gl_FragColor = textureColor;\n }\n");
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.Float3fParam("originAverageFaceColor", 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.Float3fParam("cartoonAverageFaceColor", 0.0F, 0.0F, 0.0F));
  }
  
  public void updateParams(float[] paramArrayOfFloat)
  {
    float f2 = paramArrayOfFloat[0];
    float f3 = paramArrayOfFloat[1];
    float f4 = paramArrayOfFloat[2];
    float f1 = paramArrayOfFloat[3];
    f1 = 0.21F * f2 + 0.72F * f3 + 0.07F * f4;
    if (f1 > 0.75F) {
      f1 = 1.0F;
    } else if (f1 < 0.5F) {
      f1 = 1.15F;
    } else {
      f1 = Math.abs(0.75F - f1) * 0.15F / 0.25F + 1.0F;
    }
    addParam(new UniformParam.Float3fParam("originAverageFaceColor", Math.min(f2 * f1, 1.0F), Math.min(f3 * f1, 1.0F), Math.min(f4 * f1, 1.0F)));
    addParam(new UniformParam.Float3fParam("cartoonAverageFaceColor", 0.9490196F, 0.827451F, 0.7058824F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.FaceColorTransferFilter
 * JD-Core Version:    0.7.0.1
 */