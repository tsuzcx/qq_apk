package com.tencent.mobileqq.mini.entry;

import apaq;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQMessagePageMiniAppEntryManager$RedDotAppletsObserver
  extends apaq
{
  private final WeakReference<QQMessagePageMiniAppEntryManager> miniAppEntryManagerWeakReference;
  
  public QQMessagePageMiniAppEntryManager$RedDotAppletsObserver(QQMessagePageMiniAppEntryManager paramQQMessagePageMiniAppEntryManager)
  {
    this.miniAppEntryManagerWeakReference = new WeakReference(paramQQMessagePageMiniAppEntryManager);
  }
  
  public void onAppletsSettingSwitchChange(int paramInt)
  {
    updateAppletsSettingSwitchState(paramInt);
  }
  
  protected void updateAppletsSettingSwitchState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMessagePageMicroAppEntryManager", 2, "updateAppletsSettingSwitchState:  switchState: " + paramInt);
    }
    QQMessagePageMiniAppEntryManager localQQMessagePageMiniAppEntryManager = (QQMessagePageMiniAppEntryManager)this.miniAppEntryManagerWeakReference.get();
    if (localQQMessagePageMiniAppEntryManager != null) {
      localQQMessagePageMiniAppEntryManager.onChangeRedDotSwitch(paramInt, false);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QQMessagePageMicroAppEntryManager", 2, "updateAppletsSettingSwitchState failed! miniAppEntryManager is null! ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager.RedDotAppletsObserver
 * JD-Core Version:    0.7.0.1
 */