package com.tencent.mtt.hippy.uimanager;

public class DiffUtils$CreatePatch
  extends DiffUtils.Patch
{
  RenderNode renderNode;
  
  public DiffUtils$CreatePatch(RenderNode paramRenderNode)
  {
    this.renderNode = paramRenderNode;
  }
  
  public String toString()
  {
    return "CreatePatch id :" + this.renderNode.mId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.DiffUtils.CreatePatch
 * JD-Core Version:    0.7.0.1
 */