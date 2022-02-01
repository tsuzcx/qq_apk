package com.tencent.mtt.hippy.uimanager;

import java.util.Comparator;

class RenderNode$1
  implements Comparator<RenderNode>
{
  RenderNode$1(RenderNode paramRenderNode) {}
  
  public int a(RenderNode paramRenderNode1, RenderNode paramRenderNode2)
  {
    if (paramRenderNode1.indexFromParent() < paramRenderNode2.indexFromParent()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.RenderNode.1
 * JD-Core Version:    0.7.0.1
 */