package com.tencent.mobileqq.model;

import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.qphone.base.util.QLog;

class EmoticonManager$24
  extends SVIPObserver
{
  EmoticonManager$24(EmoticonManager paramEmoticonManager) {}
  
  public void onVipStatusChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "mVipStatusObserver vip change");
    }
    super.onVipStatusChanged();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.24
 * JD-Core Version:    0.7.0.1
 */