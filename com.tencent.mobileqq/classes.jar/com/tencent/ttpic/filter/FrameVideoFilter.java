package com.tencent.ttpic.filter;

import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;

public class FrameVideoFilter
  extends FrameBaseFilter
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FrameVideoFragmentShader.dat");
  public static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/LeftRightVertexShader.dat");
  
  public FrameVideoFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FrameVideoFilter
 * JD-Core Version:    0.7.0.1
 */