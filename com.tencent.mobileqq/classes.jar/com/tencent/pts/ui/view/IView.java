package com.tencent.pts.ui.view;

import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

public abstract interface IView<T extends PTSNodeVirtual>
{
  public abstract T getNode();
  
  public abstract void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.ui.view.IView
 * JD-Core Version:    0.7.0.1
 */