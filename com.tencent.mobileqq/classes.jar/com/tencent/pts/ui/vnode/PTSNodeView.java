package com.tencent.pts.ui.vnode;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSBoringView;

public class PTSNodeView
  extends PTSNodeVirtual<PTSBoringView>
{
  private PTSNodeView(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public PTSBoringView initView()
  {
    return new PTSBoringView(this);
  }
  
  public void resetAll() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeView
 * JD-Core Version:    0.7.0.1
 */