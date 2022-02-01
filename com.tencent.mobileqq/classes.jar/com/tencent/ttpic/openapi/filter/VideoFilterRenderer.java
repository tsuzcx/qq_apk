package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import java.util.HashMap;

public class VideoFilterRenderer
  implements Renderer
{
  private VideoFilterBase filter;
  
  public VideoFilterRenderer(VideoFilterBase paramVideoFilterBase)
  {
    this.filter = paramVideoFilterBase;
  }
  
  public void addParams(HashMap<String, String> paramHashMap) {}
  
  public Frame process(Frame paramFrame)
  {
    Frame localFrame = this.filter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    paramFrame.unlock();
    return localFrame;
  }
  
  public void release()
  {
    this.filter.clearGLSLSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VideoFilterRenderer
 * JD-Core Version:    0.7.0.1
 */