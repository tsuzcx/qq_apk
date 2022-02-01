package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSImageView;

public class PTSNodeImage$Builder
  implements PTSNodeVirtual.IBuilder
{
  public View buildNativeView(Context paramContext, PTSNodeVirtual paramPTSNodeVirtual)
  {
    return new PTSImageView(paramContext);
  }
  
  public PTSNodeVirtual buildNodeVirtual(PTSAppInstance paramPTSAppInstance)
  {
    return new PTSNodeImage(paramPTSAppInstance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeImage.Builder
 * JD-Core Version:    0.7.0.1
 */