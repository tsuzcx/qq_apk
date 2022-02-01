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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Contact changed selfChange=");
      localStringBuilder.append(paramBoolean);
      QLog.d("BusinessCard_EditActivity", 2, localStringBuilder.toString());
    }
    if (BusinessCardEditActivity.a(this.a))
    {
      this.a.a(2131698680, 2);
      BusinessCardEditActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.16
 * JD-Core Version:    0.7.0.1
 */