package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class MoscoFilter
  extends BaseFilter
{
  private BaseFilter mAlphaFilter = new AlphaAdjustFilter();
  
  public MoscoFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(BaseFilter.getFragmentShader(63));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("color2", new float[] { 0.9333333F, 0.6705883F, 0.8941177F, 1.0F }));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatParam("transparency", 0.3F));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new BaseFilter(BaseFilter.getFragmentShader(128));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("color2", new float[] { 0.8941177F, 0.6352941F, 0.2235294F, 1.0F }));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("transparency", 0.1F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(0.0F, 5.0F, 1.0F, 310.0F, 340.0F, 10.0F, 40.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(0.0F, -22.0F, 15.0F, 355.0F, 18.0F, 58.0F, 79.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(BaseFilter.getFragmentShader(57));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { -0.02745098F, -0.05490196F, 0.0F }));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    ((BaseFilter)localObject2).addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.0F, -0.04705882F, -0.04705882F }));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject1).addParam(new TextureResParam("inputImageTexture2", "sh/maplered_curve.png", 33986));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = this.mAlphaFilter;
    this.mAlphaFilter.setAdjustParam(0.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, new int[] { 0 });
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.mAlphaFilter.setAdjustParam(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.MoscoFilter
 * JD-Core Version:    0.7.0.1
 */