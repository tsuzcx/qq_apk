package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.filter.BaseFilter;

public class RealTimeBorderBlurFilterV3
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform highp vec2 pixelOffset;\n \n void main() {\n     lowp vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     highp vec4 meanColor = iColor;\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y-pixelOffset.y*2.0));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x, textureCoordinate.y-pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y-pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x, textureCoordinate.y-pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x*2.0, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x*2.0, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x, textureCoordinate.y+pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y+pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x, textureCoordinate.y+pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y+pixelOffset.y*2.0));\n     meanColor /= 13.0;\n     gl_FragColor = vec4(meanColor.rg, iColor.ba);\n }\n";
  private static final String VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
  private BaseFilter veticalFilter = new BaseFilter("precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform highp vec2 pixelOffset;\n \n void main() {\n     lowp vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     highp vec4 meanColor = iColor;\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y-pixelOffset.y*2.0));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x, textureCoordinate.y-pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y-pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x, textureCoordinate.y-pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x*2.0, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x*2.0, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x, textureCoordinate.y+pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y+pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x, textureCoordinate.y+pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y+pixelOffset.y*2.0));\n     meanColor /= 13.0;\n     gl_FragColor = vec4(meanColor.rg, iColor.ba);\n }\n");
  
  public RealTimeBorderBlurFilterV3()
  {
    super("precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform highp vec2 pixelOffset;\n \n void main() {\n     lowp vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     highp vec4 meanColor = iColor;\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y-pixelOffset.y*2.0));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x, textureCoordinate.y-pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y-pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x, textureCoordinate.y-pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x*2.0, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x*2.0, textureCoordinate.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x-pixelOffset.x, textureCoordinate.y+pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y+pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x+pixelOffset.x, textureCoordinate.y+pixelOffset.y));\n     meanColor += texture2D(inputImageTexture, vec2(textureCoordinate.x, textureCoordinate.y+pixelOffset.y*2.0));\n     meanColor /= 13.0;\n     gl_FragColor = vec4(meanColor.rg, iColor.ba);\n }\n");
    initParams();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    setNextFilter(this.veticalFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.Float2fParam("pixelOffset", 0.004166667F, 0.0F));
    this.veticalFilter.addParam(new UniformParam.Float2fParam("pixelOffset", 0.0F, 0.003125F));
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    this.veticalFilter.setPositions(paramArrayOfFloat);
    return super.setPositions(paramArrayOfFloat);
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    this.veticalFilter.setTexCords(paramArrayOfFloat);
    return super.setTexCords(paramArrayOfFloat);
  }
  
  public void updateParam(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.Float2fParam("pixelOffset", 1.5F / paramFloat1, 0.0F));
    this.veticalFilter.addParam(new UniformParam.Float2fParam("pixelOffset", 0.0F, 1.5F / paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.RealTimeBorderBlurFilterV3
 * JD-Core Version:    0.7.0.1
 */