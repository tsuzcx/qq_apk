package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSScrollView;

public class PTSNodeScrollView$Builder
  implements PTSNodeVirtual.IBuilder
{
  public View buildNativeView(Context paramContext, PTSNodeVirtual paramPTSNodeVirtual)
  {
    return new PTSScrollView((PTSNodeScrollView)paramPTSNodeVirtual);
  }
  
  public PTSNodeVirtual buildNodeVirtual(PTSAppInstance paramPTSAppInstance)
  {
    return new PTSNodeScrollView(paramPTSAppInstance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeScrollView.Builder
 * JD-Core Version:    0.7.0.1
 */