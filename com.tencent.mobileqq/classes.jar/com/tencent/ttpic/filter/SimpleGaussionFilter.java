package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;

public class SimpleGaussionFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/GaussionBlurFragmentShader.dat");
  
  public SimpleGaussionFilter()
  {
    super(FRAGMENT_SHADER);
    initParams();
  }
  
  private void initParams()
  {
    addParam(new Param.FloatParam("stepX", 0.0F));
    addParam(new Param.FloatParam("stepY", 0.0F));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    addParam(new Param.FloatParam("stepX", 1.0F / paramInt2));
    addParam(new Param.FloatParam("stepY", 1.0F / paramInt3));
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.SimpleGaussionFilter
 * JD-Core Version:    0.7.0.1
 */