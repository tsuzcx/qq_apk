package com.tencent.mobileqq.simpleui.api.impl;

import android.view.Window;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.api.ISimpleUIUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.SystemBarCompact;

public class SimpleUIUtilImpl
  implements ISimpleUIUtil
{
  public void adjustSimpleStatusBar(ImmersiveTitleBar2 paramImmersiveTitleBar2, Window paramWindow)
  {
    SimpleUIUtil.a(paramImmersiveTitleBar2, paramWindow);
  }
  
  public void adjustSimpleStatusBar(SystemBarCompact paramSystemBarCompact, Window paramWindow)
  {
    SimpleUIUtil.a(paramSystemBarCompact, paramWindow);
  }
  
  public boolean getSimpleUISwitch()
  {
    return SimpleUIUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.api.impl.SimpleUIUtilImpl
 * JD-Core Version:    0.7.0.1
 */