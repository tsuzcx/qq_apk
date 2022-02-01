package com.tencent.mobileqq.kandian.biz.pts.ui;

import android.content.Context;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.ui.vnode.PTSNodeVirtual.IBuilder;

public class PTSNodeRichText$Builder
  implements PTSNodeVirtual.IBuilder
{
  public View buildNativeView(Context paramContext, PTSNodeVirtual paramPTSNodeVirtual)
  {
    return new PTSRichTextNativeView(paramContext);
  }
  
  public PTSNodeVirtual buildNodeVirtual(PTSAppInstance paramPTSAppInstance)
  {
    return new PTSNodeRichText(paramPTSAppInstance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeRichText.Builder
 * JD-Core Version:    0.7.0.1
 */