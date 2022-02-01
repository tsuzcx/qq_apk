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
      if (QLog.isColorLevel())
      {
        paramBundle = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive:--speed=");
        localStringBuilder.append(paramInt);
        QLog.d(paramBundle, 2, localStringBuilder.toString());
      }
      a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.observer.QQLevelACCObserver
 * JD-Core Version:    0.7.0.1
 */