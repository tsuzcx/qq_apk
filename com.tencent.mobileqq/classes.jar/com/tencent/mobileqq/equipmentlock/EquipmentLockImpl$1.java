package com.tencent.mobileqq.equipmentlock;

import com.tencent.qphone.base.util.QLog;

class EquipmentLockImpl$1
  implements Runnable
{
  EquipmentLockImpl$1(EquipmentLockImpl paramEquipmentLockImpl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DevLock", 2, "notification runnable run.");
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipmentLockImpl.1
 * JD-Core Version:    0.7.0.1
 */