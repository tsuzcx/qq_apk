package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class StarOverlayFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n    \nuniform sampler2D   inputImageTexture;\nuniform sampler2D   inputImageTexture2;\nvarying vec2        textureCoordinate;\nvoid main() \n{\n  lowp vec4 base = texture2D(inputImageTexture2, textureCoordinate); \n  lowp vec4 overlay = texture2D(inputImageTexture, textureCoordinate);     \n  mediump float r; \n  if (overlay.r * base.a + base.r * overlay.a >= overlay.a * base.a) { \n    r = overlay.a * base.a + overlay.r * (1.0 - base.a) + base.r * (1.0 - overlay.a); \n  } else { \n    r = overlay.r + base.r; \n  } \n  mediump float g; \n  if (overlay.g * base.a + base.g * overlay.a >= overlay.a * base.a) { \n    g = overlay.a * base.a + overlay.g * (1.0 - base.a) + base.g * (1.0 - overlay.a); \n  } else { \n    g = overlay.g + base.g; \n  } \n  mediump float b; \n  if (overlay.b * base.a + base.b * overlay.a >= overlay.a * base.a) { \n    b = overlay.a * base.a + overlay.b * (1.0 - base.a) + base.b * (1.0 - overlay.a); \n  } else { \n    b = overlay.b + base.b; \n  } \n  mediump float a = overlay.a + base.a - overlay.a * base.a;   \n  gl_FragColor = vec4(r, g, b, a); \n}\n";
  
  public StarOverlayFilter()
  {
    super("precision highp float;\n    \nuniform sampler2D   inputImageTexture;\nuniform sampler2D   inputImageTexture2;\nvarying vec2        textureCoordinate;\nvoid main() \n{\n  lowp vec4 base = texture2D(inputImageTexture2, textureCoordinate); \n  lowp vec4 overlay = texture2D(inputImageTexture, textureCoordinate);     \n  mediump float r; \n  if (overlay.r * base.a + base.r * overlay.a >= overlay.a * base.a) { \n    r = overlay.a * base.a + overlay.r * (1.0 - base.a) + base.r * (1.0 - overlay.a); \n  } else { \n    r = overlay.r + base.r; \n  } \n  mediump float g; \n  if (overlay.g * base.a + base.g * overlay.a >= overlay.a * base.a) { \n    g = overlay.a * base.a + overlay.g * (1.0 - base.a) + base.g * (1.0 - overlay.a); \n  } else { \n    g = overlay.g + base.g; \n  } \n  mediump float b; \n  if (overlay.b * base.a + base.b * overlay.a >= overlay.a * base.a) { \n    b = overlay.a * base.a + overlay.b * (1.0 - base.a) + base.b * (1.0 - overlay.a); \n  } else { \n    b = overlay.b + base.b; \n  } \n  mediump float a = overlay.a + base.a - overlay.a * base.a;   \n  gl_FragColor = vec4(r, g, b, a); \n}\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.StarOverlayFilter
 * JD-Core Version:    0.7.0.1
 */