package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.AlgoUtils;

public class GrainFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nuniform float alpha; \n\nvoid main()\n{\n  vec4 grain = texture2D(inputImageTexture2, textureCoordinate2);\n  vec4 origin = texture2D(inputImageTexture, textureCoordinate);\n  float gray = dot(origin.rgb, vec3(0.299,0.587,0.114)); \n  float factor = 1.0;\n  if (gray < 0.2) factor = gray / 0.2;\n  if (gray > 0.8) factor = (1.0 - gray) / 0.2;\n  vec3 result = clamp(origin.rgb + grain.rgb - vec3(0.5), vec3(0.0), vec3(1.0));\n  gl_FragColor = mix(origin, vec4(result, origin.a), alpha * factor);\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = position.xy * 0.5 + 0.5;\n    textureCoordinate2 = inputTextureCoordinate.xy;\n}\n";
  private float mAlpha = 1.0F;
  private BaseFilter mFilter = new BaseFilter("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = position.xy * 0.5 + 0.5;\n    textureCoordinate2 = inputTextureCoordinate.xy;\n}\n", "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nuniform float alpha; \n\nvoid main()\n{\n  vec4 grain = texture2D(inputImageTexture2, textureCoordinate2);\n  vec4 origin = texture2D(inputImageTexture, textureCoordinate);\n  float gray = dot(origin.rgb, vec3(0.299,0.587,0.114)); \n  float factor = 1.0;\n  if (gray < 0.2) factor = gray / 0.2;\n  if (gray > 0.8) factor = (1.0 - gray) / 0.2;\n  vec3 result = clamp(origin.rgb + grain.rgb - vec3(0.5), vec3(0.0), vec3(1.0));\n  gl_FragColor = mix(origin, vec4(result, origin.a), alpha * factor);\n}\n");
  private BaseFilter mPostRotateFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  
  public GrainFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.mFilter.addParam(new TextureResParam("inputImageTexture2", "sh/grain.jpg", 33986));
    this.mFilter.addParam(new UniformParam.FloatParam("alpha", this.mAlpha));
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (isValid()) {
      return;
    }
    if (paramFloat1 > paramFloat2)
    {
      setNextFilter(this.mFilter, null);
      this.mFilter.setNextFilter(this.mPostRotateFilter, null);
      setRotationAndFlip(90, 0, 0);
      this.mFilter.setTexCords(AlgoUtils.calTexCoords(512, 512, paramFloat2 / paramFloat1));
      this.mPostRotateFilter.setRotationAndFlip(-90, 0, 0);
    }
    for (;;)
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
      setNextFilter(this.mFilter, null);
      this.mFilter.setNextFilter(this.mPostRotateFilter, null);
      setRotationAndFlip(0, 0, 0);
      this.mFilter.setTexCords(AlgoUtils.calTexCoords(512, 512, paramFloat1 / paramFloat2));
      this.mPostRotateFilter.setRotationAndFlip(0, 0, 0);
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    LogUtils.v("grainsetalpha", String.valueOf(paramFloat));
    this.mAlpha = paramFloat;
    this.mFilter.addParam(new UniformParam.FloatParam("alpha", this.mAlpha));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GrainFilter
 * JD-Core Version:    0.7.0.1
 */