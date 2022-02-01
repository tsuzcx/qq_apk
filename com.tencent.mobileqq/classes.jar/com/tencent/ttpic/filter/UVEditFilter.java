package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

public class UVEditFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying  vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;uniform highp float u_value;\nuniform highp float v_value;\n\nhighp vec3 yuv2RGB(highp vec3 c){\nhighp float R = c.r + 1.14*c.b;\nhighp float G = c.r - 0.39*c.g - 0.58*c.b;\nhighp float B = c.r + 2.03*c.g;return vec3(R,G,B);}\nhighp vec3 rgb2yuv(highp vec3 c){\nhighp float Y = 0.299*c.r + 0.587*c.g + 0.114*c.b;\nhighp float U = -0.147*c.r - 0.289*c.g + 0.436*c.b;\nhighp float V = 0.615*c.r - 0.515*c.g - 0.100*c.b;return vec3(Y,U,V);\n}\n\n\nvoid main() {\n    highp vec4 rgba = texture2D(inputImageTexture,textureCoordinate);\n    highp vec3 yuv = rgb2yuv(rgba.xyz);\n    yuv.y = u_value;\n    yuv.z = v_value;\n    vec3 rgb = yuv2RGB(yuv);    gl_FragColor = vec4(rgb,rgba.w);\n}";
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n  gl_Position = position;\n  textureCoordinate = inputTextureCoordinate;\n}";
  
  public UVEditFilter()
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n  gl_Position = position;\n  textureCoordinate = inputTextureCoordinate;\n}", "precision highp float;\nvarying  vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;uniform highp float u_value;\nuniform highp float v_value;\n\nhighp vec3 yuv2RGB(highp vec3 c){\nhighp float R = c.r + 1.14*c.b;\nhighp float G = c.r - 0.39*c.g - 0.58*c.b;\nhighp float B = c.r + 2.03*c.g;return vec3(R,G,B);}\nhighp vec3 rgb2yuv(highp vec3 c){\nhighp float Y = 0.299*c.r + 0.587*c.g + 0.114*c.b;\nhighp float U = -0.147*c.r - 0.289*c.g + 0.436*c.b;\nhighp float V = 0.615*c.r - 0.515*c.g - 0.100*c.b;return vec3(Y,U,V);\n}\n\n\nvoid main() {\n    highp vec4 rgba = texture2D(inputImageTexture,textureCoordinate);\n    highp vec3 yuv = rgb2yuv(rgba.xyz);\n    yuv.y = u_value;\n    yuv.z = v_value;\n    vec3 rgb = yuv2RGB(yuv);    gl_FragColor = vec4(rgb,rgba.w);\n}");
    addParam(new UniformParam.FloatParam("u_value", 0.0F));
    addParam(new UniformParam.FloatParam("v_value", 0.0F));
  }
  
  private float normalizeFromPiexlValue(float paramFloat)
  {
    return (paramFloat - 128.0F) / 128.0F;
  }
  
  public void setUVValue(String paramString, float paramFloat)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (paramString.equals("v"))
        {
          i = 0;
          continue;
          if (paramString.equals("u")) {
            i = 1;
          }
        }
        break;
      }
    }
    addParam(new UniformParam.FloatParam("v_value", normalizeFromPiexlValue(paramFloat)));
    return;
    addParam(new UniformParam.FloatParam("u_value", normalizeFromPiexlValue(paramFloat)));
  }
  
  public void setUVValue(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 2)) {
      return;
    }
    addParam(new UniformParam.FloatParam("v_value", normalizeFromPiexlValue(paramArrayOfFloat[1])));
    addParam(new UniformParam.FloatParam("u_value", normalizeFromPiexlValue(paramArrayOfFloat[0])));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.UVEditFilter
 * JD-Core Version:    0.7.0.1
 */