package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;

public abstract interface a
{
  public abstract HippyMap onCreateNode(int paramInt, HippyRootView paramHippyRootView, HippyMap paramHippyMap);
  
  public abstract void onDeleteNode(int paramInt);
  
  public abstract HippyMap onUpdateNode(int paramInt, HippyRootView paramHippyRootView, HippyMap paramHippyMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.a
 * JD-Core Version:    0.7.0.1
 */