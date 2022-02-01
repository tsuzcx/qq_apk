package com.tencent.mobileqq.pushdialog;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class SafeBlowObserver
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QLog.d("SafeBlowObserver", 1, "onUpdate: isSuccess = " + paramBoolean + ", data = " + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.SafeBlowObserver
 * JD-Core Version:    0.7.0.1
 */