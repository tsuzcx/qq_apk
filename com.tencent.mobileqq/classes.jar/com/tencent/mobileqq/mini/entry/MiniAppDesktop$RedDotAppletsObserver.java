package com.tencent.mobileqq.mini.entry;

import amrv;
import aoom;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class MiniAppDesktop$RedDotAppletsObserver
  extends amrv
{
  private WeakReference<MiniAppDesktopLayout> layoutReference;
  
  public MiniAppDesktop$RedDotAppletsObserver(MiniAppDesktopLayout paramMiniAppDesktopLayout)
  {
    this.layoutReference = new WeakReference(paramMiniAppDesktopLayout);
  }
  
  public void onAppletsSettingSwitchChange(int paramInt)
  {
    updateAppletsSettingSwitchState(paramInt);
  }
  
  protected void updateAppletsSettingSwitchState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppDesktop", 2, "updateAppletsSettingSwitchState:  switchState: " + paramInt);
    }
    if ((aoom.l()) && (this.layoutReference != null))
    {
      MiniAppDesktopLayout localMiniAppDesktopLayout = (MiniAppDesktopLayout)this.layoutReference.get();
      if (localMiniAppDesktopLayout != null) {
        localMiniAppDesktopLayout.onChangeRedDotSwitch(paramInt, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop.RedDotAppletsObserver
 * JD-Core Version:    0.7.0.1
 */