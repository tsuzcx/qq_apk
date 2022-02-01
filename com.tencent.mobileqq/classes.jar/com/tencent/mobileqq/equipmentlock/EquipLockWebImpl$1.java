package com.tencent.mobileqq.equipmentlock;

import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class EquipLockWebImpl$1
  extends FriendListObserver
{
  EquipLockWebImpl$1(EquipLockWebImpl paramEquipLockWebImpl) {}
  
  public void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<DeviceLockItemInfo> paramArrayList)
  {
    if (paramBoolean) {
      EquipmentLockImpl.a().a(paramArrayList);
    }
    for (;;)
    {
      EquipLockWebImpl.a(this.a, false);
      EquipLockWebImpl.b(this.a, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipLockWebImpl.1
 * JD-Core Version:    0.7.0.1
 */