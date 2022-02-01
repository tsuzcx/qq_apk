package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;
import java.util.List;

public class VideoFrameItem
{
  @Expose
  private int frameID;
  @Expose
  private int nodeGroupID;
  @Expose
  private List<FrameNodeItem> nodeList;
  
  public int getFrameID()
  {
    return this.frameID;
  }
  
  public int getNodeGroupID()
  {
    return this.nodeGroupID;
  }
  
  public List<FrameNodeItem> getNodeList()
  {
    return this.nodeList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.template.VideoFrameItem
 * JD-Core Version:    0.7.0.1
 */