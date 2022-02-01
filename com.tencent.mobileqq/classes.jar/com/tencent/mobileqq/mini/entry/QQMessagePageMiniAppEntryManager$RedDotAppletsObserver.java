package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQMessagePageMiniAppEntryManager$RedDotAppletsObserver
  extends AppletsObserver
{
  private final WeakReference<QQMessagePageMiniAppEntryManager> miniAppEntryManagerWeakReference;
  
  public QQMessagePageMiniAppEntryManager$RedDotAppletsObserver(QQMessagePageMiniAppEntryManager paramQQMessagePageMiniAppEntryManager)
  {
    this.miniAppEntryManagerWeakReference = new WeakReference(paramQQMessagePageMiniAppEntryManager);
  }
  
  protected void onAppletsSettingSwitchChange(int paramInt)
  {
    updateAppletsSettingSwitchState(paramInt);
  }
  
  protected void updateAppletsSettingSwitchState(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAppletsSettingSwitchState:  switchState: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQMessagePageMicroAppEntryManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQMessagePageMiniAppEntryManager)this.miniAppEntryManagerWeakReference.get();
    if (localObject != null)
    {
      ((QQMessagePageMiniAppEntryManager)localObject).onChangeRedDotSwitch(paramInt, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "updateAppletsSettingSwitchState failed! miniAppEntryManager is null! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager.RedDotAppletsObserver
 * JD-Core Version:    0.7.0.1
 */