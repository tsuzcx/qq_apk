package com.tencent.mobileqq.simpleui.api;

import android.view.Window;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.SystemBarCompact;

@QAPI(process={"all"})
public abstract interface ISimpleUIUtil
  extends QRouteApi
{
  public abstract void adjustSimpleStatusBar(ImmersiveTitleBar2 paramImmersiveTitleBar2, Window paramWindow);
  
  public abstract void adjustSimpleStatusBar(SystemBarCompact paramSystemBarCompact, Window paramWindow);
  
  public abstract boolean getSimpleUISwitch();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.api.ISimpleUIUtil
 * JD-Core Version:    0.7.0.1
 */