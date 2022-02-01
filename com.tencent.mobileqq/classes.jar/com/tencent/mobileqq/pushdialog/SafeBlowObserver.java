package com.tencent.mobileqq.pushdialog;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class SafeBlowObserver
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 3838) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdate: isSuccess = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", data = ");
    localStringBuilder.append(paramObject);
    QLog.d("SafeBlowObserver", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.SafeBlowObserver
 * JD-Core Version:    0.7.0.1
 */