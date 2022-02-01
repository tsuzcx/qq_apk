package com.tencent.mtt.hippy.uimanager;

public class DiffUtils$CreatePatch
  extends DiffUtils.Patch
{
  final RenderNode renderNode;
  
  public DiffUtils$CreatePatch(RenderNode paramRenderNode)
  {
    this.renderNode = paramRenderNode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CreatePatch id :");
    localStringBuilder.append(this.renderNode.mId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils.CreatePatch
 * JD-Core Version:    0.7.0.1
 */