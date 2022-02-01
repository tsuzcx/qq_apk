package com.tencent.mobileqq.servlet;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;

class QZoneManagerImp$1
  extends ContentObserver
{
  QZoneManagerImp$1(QZoneManagerImp paramQZoneManagerImp, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    ThreadManager.post(new QZoneManagerImp.1.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.1
 * JD-Core Version:    0.7.0.1
 */