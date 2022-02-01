package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;

public abstract interface PTSNodeVirtual$IBuilder
{
  public abstract View buildNativeView(Context paramContext, PTSNodeVirtual paramPTSNodeVirtual);
  
  public abstract PTSNodeVirtual buildNodeVirtual(PTSAppInstance paramPTSAppInstance);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeVirtual.IBuilder
 * JD-Core Version:    0.7.0.1
 */