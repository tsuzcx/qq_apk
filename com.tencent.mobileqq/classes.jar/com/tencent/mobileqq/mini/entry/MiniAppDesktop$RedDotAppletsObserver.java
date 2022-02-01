package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class MiniAppDesktop$RedDotAppletsObserver
  extends AppletsObserver
{
  private WeakReference<MiniAppDesktopLayout> layoutReference;
  
  public MiniAppDesktop$RedDotAppletsObserver(MiniAppDesktopLayout paramMiniAppDesktopLayout)
  {
    this.layoutReference = new WeakReference(paramMiniAppDesktopLayout);
  }
  
  protected void onAppletsSettingSwitchChange(int paramInt)
  {
    updateAppletsSettingSwitchState(paramInt);
  }
  
  protected void updateAppletsSettingSwitchState(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAppletsSettingSwitchState:  switchState: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MiniAppDesktop", 2, ((StringBuilder)localObject).toString());
    }
    if (MiniAppConfProcessor.m())
    {
      localObject = this.layoutReference;
      if (localObject != null)
      {
        localObject = (MiniAppDesktopLayout)((WeakReference)localObject).get();
        if (localObject != null) {
          ((MiniAppDesktopLayout)localObject).onChangeRedDotSwitch(paramInt, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop.RedDotAppletsObserver
 * JD-Core Version:    0.7.0.1
 */