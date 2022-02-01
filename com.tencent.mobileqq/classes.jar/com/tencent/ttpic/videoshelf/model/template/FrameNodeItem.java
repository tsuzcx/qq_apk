package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;
import java.util.List;

public class FrameNodeItem
{
  @Expose
  private int blendMode;
  @Expose
  private List<MaskBlock> maskBlockList;
  @Expose
  private int nodeID;
  @Expose
  private int zIndex;
  
  public int getBlendMode()
  {
    return this.blendMode;
  }
  
  public List<MaskBlock> getMaskBlockList()
  {
    return this.maskBlockList;
  }
  
  public int getNodeID()
  {
    return this.nodeID;
  }
  
  public int getZIndex()
  {
    return this.zIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.template.FrameNodeItem
 * JD-Core Version:    0.7.0.1
 */