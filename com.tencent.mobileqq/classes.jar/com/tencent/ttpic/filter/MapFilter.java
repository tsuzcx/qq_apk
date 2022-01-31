package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.Int1sParam;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;

public class MapFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MapFragmentShader.dat");
  
  public MapFilter()
  {
    super(FRAGMENT_SHADER);
    initParam();
  }
  
  public void initParam()
  {
    addParam(new Param.Int1sParam("map", new int[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.MapFilter
 * JD-Core Version:    0.7.0.1
 */