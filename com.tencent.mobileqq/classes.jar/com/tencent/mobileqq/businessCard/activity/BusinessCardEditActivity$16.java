package com.tencent.mobileqq.businessCard.activity;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class BusinessCardEditActivity$16
  extends ContentObserver
{
  BusinessCardEditActivity$16(BusinessCardEditActivity paramBusinessCardEditActivity, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_EditActivity", 2, "Contact changed selfChange=" + paramBoolean);
    }
    if (BusinessCardEditActivity.a(this.a))
    {
      this.a.a(2131698614, 2);
      BusinessCardEditActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.16
 * JD-Core Version:    0.7.0.1
 */