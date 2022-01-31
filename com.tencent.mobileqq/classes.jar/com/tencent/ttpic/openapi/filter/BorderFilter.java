package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class BorderFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform float borderWidth;\nuniform float width;\nuniform float height;\nuniform vec4 borderColor;\n\nvoid main()\n{\n    float borderX = borderWidth;\n    float borderY = borderWidth;\n    if (width > height) {\n        borderX = borderWidth * height / width;\n    } else {\n        borderY = borderWidth * width / height;\n    }\n    if (textureCoordinate.x < borderX || textureCoordinate.x > 1.0 - borderX || textureCoordinate.y < borderY || textureCoordinate.y > 1.0 - borderY) {\n        gl_FragColor = borderColor;\n    } else {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n}";
  
  public BorderFilter()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform float borderWidth;\nuniform float width;\nuniform float height;\nuniform vec4 borderColor;\n\nvoid main()\n{\n    float borderX = borderWidth;\n    float borderY = borderWidth;\n    if (width > height) {\n        borderX = borderWidth * height / width;\n    } else {\n        borderY = borderWidth * width / height;\n    }\n    if (textureCoordinate.x < borderX || textureCoordinate.x > 1.0 - borderX || textureCoordinate.y < borderY || textureCoordinate.y > 1.0 - borderY) {\n        gl_FragColor = borderColor;\n    } else {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n}");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("borderWidth", 0.025F));
    addParam(new UniformParam.Float4fParam("borderColor", 0.0F, 0.0F, 0.0F, 1.0F));
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("width", paramFloat1));
    addParam(new UniformParam.FloatParam("height", paramFloat2));
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void updateBorderColor(float[] paramArrayOfFloat)
  {
    addParam(new UniformParam.Float4fParam("borderColor", paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]));
  }
  
  public void updateBorderWidth(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("borderWidth", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BorderFilter
 * JD-Core Version:    0.7.0.1
 */