package com.tencent.mtt.hippy.views.hippylist;

public class NodePositionHelper
{
  private int nodeOffset = 0;
  
  public void decreaseOffset()
  {
    this.nodeOffset -= 1;
  }
  
  public int getNodeOffset()
  {
    return this.nodeOffset;
  }
  
  public int getRenderNodePosition(int paramInt)
  {
    return paramInt - this.nodeOffset;
  }
  
  public void increaseOffset()
  {
    this.nodeOffset += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.NodePositionHelper
 * JD-Core Version:    0.7.0.1
 */