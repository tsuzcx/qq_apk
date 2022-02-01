package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class TTV6SmoothFirstBlurMixFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform lowp float factor;\n uniform mediump float blurStrength;\n void main() { \n   mediump vec4 srcColor = texture2D(inputImageTexture, textureCoordinate);\n   lowp float mask = texture2D(inputImageTexture3, textureCoordinate).b;\n   if(mask > 0.0005) { \n     vec2 skin_map_coord = vec2(0.0, 0.0);\n     skin_map_coord.y = srcColor.r;\n     skin_map_coord.x = srcColor.b;\n     lowp vec4 blurColor = texture2D(inputImageTexture2, textureCoordinate2);\n     lowp float cDistance = distance(vec3(0.0, 0.0, 0.0), max(blurColor.rgb - srcColor.rgb, 0.0)) * factor;\n     if(cDistance > 0.5 && cDistance < 5.0) { \n       vec3 diff_color = clamp((blurColor.rgb - srcColor.rgb), 0.0, 0.3);\n       diff_color = min(srcColor.rgb + diff_color.rgb, 1.0);\n       gl_FragColor = vec4(mix(srcColor.rgb, diff_color, blurStrength * mask), 1.0);\n      } else { \n        gl_FragColor = vec4(srcColor.rgb, 1.0);\n       } \n    } else { \n      gl_FragColor = srcColor;\n    } \n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n void main() { \n   gl_Position = position;\n   textureCoordinate = position.xy * 0.5 + 0.5;\n   textureCoordinate2 = inputTextureCoordinate.xy;\n }\n";
  
  public TTV6SmoothFirstBlurMixFilter()
  {
    super("attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n void main() { \n   gl_Position = position;\n   textureCoordinate = position.xy * 0.5 + 0.5;\n   textureCoordinate2 = inputTextureCoordinate.xy;\n }\n", "precision highp float;\nvarying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform lowp float factor;\n uniform mediump float blurStrength;\n void main() { \n   mediump vec4 srcColor = texture2D(inputImageTexture, textureCoordinate);\n   lowp float mask = texture2D(inputImageTexture3, textureCoordinate).b;\n   if(mask > 0.0005) { \n     vec2 skin_map_coord = vec2(0.0, 0.0);\n     skin_map_coord.y = srcColor.r;\n     skin_map_coord.x = srcColor.b;\n     lowp vec4 blurColor = texture2D(inputImageTexture2, textureCoordinate2);\n     lowp float cDistance = distance(vec3(0.0, 0.0, 0.0), max(blurColor.rgb - srcColor.rgb, 0.0)) * factor;\n     if(cDistance > 0.5 && cDistance < 5.0) { \n       vec3 diff_color = clamp((blurColor.rgb - srcColor.rgb), 0.0, 0.3);\n       diff_color = min(srcColor.rgb + diff_color.rgb, 1.0);\n       gl_FragColor = vec4(mix(srcColor.rgb, diff_color, blurStrength * mask), 1.0);\n      } else { \n        gl_FragColor = vec4(srcColor.rgb, 1.0);\n       } \n    } else { \n      gl_FragColor = srcColor;\n    } \n }\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.FloatParam("factor", 28.86751F));
    addParam(new UniformParam.FloatParam("blurStrength", 1.0F));
  }
  
  public void setBlurStrength(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("blurStrength", paramFloat));
  }
  
  public void setBlurTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void setFaceSkinMaskTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTV6SmoothFirstBlurMixFilter
 * JD-Core Version:    0.7.0.1
 */