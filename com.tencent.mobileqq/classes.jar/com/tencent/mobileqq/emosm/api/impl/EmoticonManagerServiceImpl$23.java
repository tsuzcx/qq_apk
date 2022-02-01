package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.qphone.base.util.QLog;

class EmoticonManagerServiceImpl$23
  extends SVIPObserver
{
  EmoticonManagerServiceImpl$23(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl) {}
  
  public void onVipStatusChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "mVipStatusObserver vip change");
    }
    super.onVipStatusChanged();
    this.a.parseCloudKeywordsJson();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.23
 * JD-Core Version:    0.7.0.1
 */