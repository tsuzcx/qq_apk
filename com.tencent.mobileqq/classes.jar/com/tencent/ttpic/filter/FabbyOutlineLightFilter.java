package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.internal.Frame;

public class FabbyOutlineLightFilter
  extends FabbyStrokeFilterExt
{
  private final float[] DEFAULT_BG_COLOR = { 0.0F, 0.0F, 0.0F, 0.0F };
  
  static
  {
    FabbyStrokeFilter.FRAGMENT_SHADER = "precision lowp float;\n \n varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;//image\n uniform sampler2D inputImageTexture2;//mask\n uniform sampler2D inputImageTexture3;//bg\n \n uniform float transparentBackground;\n uniform float stepX;\n uniform float stepY;\n uniform float strokeGapInPixel;\n uniform float strokeWidthInPixel;\n uniform vec4 strokeColor;\n uniform vec4 bgColor;\n uniform int useBg; \n uniform int useMaskAlpha; \n \n void main()\n {\n     vec4 v1 = texture2D(inputImageTexture, textureCoordinate);\n     vec4 v2 = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 v3 = texture2D(inputImageTexture3, textureCoordinate);\n     vec4 color =strokeColor;\n     \n     float mask = v2.r;\n     if (mask < 0.5) {\n         if(useBg==1){\n           color=vec4(v3.rgb,1.0);           }\n         if(useMaskAlpha==1){\n            if(v3.a<0.3){\n               mask=0.0;\n               }\n           }\n         gl_FragColor = mix(bgColor, color, mask*2.0);\n     }\n     else {\n         //前景\n         gl_FragColor = mix(bgColor, v1, mask);\n     }\n }";
  }
  
  public FabbyOutlineLightFilter()
  {
    super(null);
    addParam(new UniformParam.Float4fParam("bgColor", 0.0F, 0.0F, 0.0F, 0.0F));
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyOutlineLightFilter
 * JD-Core Version:    0.7.0.1
 */