package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class ComposeFilter
  extends BaseFilter
{
  public static final String COMPOSE_FRAGMENT = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float offset;\n\nvoid main()\n{\n    vec4 leftColor = texture2D(inputImageTexture, textureCoordinate);\n    vec4 rightColor = texture2D(inputImageTexture2,textureCoordinate);\n\n    if (textureCoordinate.x > offset) {\n        gl_FragColor = rightColor;\n    } else {\n        gl_FragColor = leftColor;\n    }\n}\n";
  
  public ComposeFilter()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float offset;\n\nvoid main()\n{\n    vec4 leftColor = texture2D(inputImageTexture, textureCoordinate);\n    vec4 rightColor = texture2D(inputImageTexture2,textureCoordinate);\n\n    if (textureCoordinate.x > offset) {\n        gl_FragColor = rightColor;\n    } else {\n        gl_FragColor = leftColor;\n    }\n}\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("offset", 0.0F));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public void setOffset(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("offset", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.ComposeFilter
 * JD-Core Version:    0.7.0.1
 */