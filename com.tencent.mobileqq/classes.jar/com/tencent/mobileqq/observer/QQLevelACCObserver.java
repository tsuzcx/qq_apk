package com.tencent.mobileqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class QQLevelACCObserver
  implements BusinessObserver
{
  private static String a = "QQLevelACCObserver";
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (1 == paramInt)
    {
      paramInt = 0;
      if (paramBundle.containsKey("key_qqlevelacc")) {
        paramInt = paramBundle.getInt("key_qqlevelacc");
      }
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "onReceive:--speed=" + paramInt);
      }
      a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.observer.QQLevelACCObserver
 * JD-Core Version:    0.7.0.1
 */