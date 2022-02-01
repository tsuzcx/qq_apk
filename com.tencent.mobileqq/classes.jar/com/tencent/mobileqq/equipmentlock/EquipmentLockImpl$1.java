package com.tencent.mobileqq.equipmentlock;

import arhf;
import com.tencent.qphone.base.util.QLog;

public class EquipmentLockImpl$1
  implements Runnable
{
  public EquipmentLockImpl$1(arhf paramarhf) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DevLock", 2, "notification runnable run.");
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipmentLockImpl.1
 * JD-Core Version:    0.7.0.1
 */