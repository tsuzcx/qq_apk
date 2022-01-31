package com.tencent.pts.ui.vnode;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSContainerView;

public class PTSNodeContainer
  extends PTSNodeVirtual<PTSContainerView>
{
  private PTSNodeContainer(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public PTSContainerView initView()
  {
    return new PTSContainerView(this);
  }
  
  public void resetAll() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeContainer
 * JD-Core Version:    0.7.0.1
 */