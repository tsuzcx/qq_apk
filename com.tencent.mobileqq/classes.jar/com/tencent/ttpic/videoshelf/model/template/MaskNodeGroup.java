package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;
import java.util.List;

public class MaskNodeGroup
{
  @Expose
  private String nodeGroupCoverImage;
  @Expose
  private int nodeGroupID;
  @Expose
  private String nodeGroupMaskImage;
  @Expose
  private List<MaskNodeItem> nodeList;
  
  public String getNodeGroupCoverImage()
  {
    return this.nodeGroupCoverImage;
  }
  
  public int getNodeGroupID()
  {
    return this.nodeGroupID;
  }
  
  public String getNodeGroupMaskImage()
  {
    return this.nodeGroupMaskImage;
  }
  
  public List<MaskNodeItem> getNodeList()
  {
    return this.nodeList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup
 * JD-Core Version:    0.7.0.1
 */