package com.tencent.pts.ui.vnode;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSBoringView;

public class PTSNodeView
  extends PTSNodeVirtual
{
  public PTSNodeView(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance, "boring", null);
  }
  
  public void setNodeVirtualKey(String paramString)
  {
    if ((getView() instanceof PTSBoringView)) {
      ((PTSBoringView)getView()).setNodeKey(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeView
 * JD-Core Version:    0.7.0.1
 */