package com.tencent.plato.sdk.render;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.dom.CanvasModule;
import com.tencent.plato.sdk.render.data.ElementItem;

public class PCanvasView
  extends PView
{
  SurfaceHolder mSurfaceHolder;
  
  public void init(IPlatoRuntime paramIPlatoRuntime, IPView paramIPView, ElementItem paramElementItem)
  {
    super.init(paramIPlatoRuntime, paramIPView, paramElementItem);
    paramIPlatoRuntime = new SurfaceView(paramIPlatoRuntime.getContext());
    this.view = paramIPlatoRuntime;
    this.id = paramElementItem.getElementId();
    CanvasModule.setSurfaceView(paramIPlatoRuntime);
    PLog.d("init sufaceview");
  }
  
  public void setStyles(IReadableMap paramIReadableMap)
  {
    super.setStyles(paramIReadableMap);
    if (this.view == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.render.PCanvasView
 * JD-Core Version:    0.7.0.1
 */