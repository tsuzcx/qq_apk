package com.tencent.mobileqq.troop.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public abstract class GroupAppsObserver
  implements BusinessObserver
{
  protected abstract void a(long paramLong);
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success = [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], [");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onReceive: invoked. ");
      localStringBuilder.append((String)localObject);
      QLog.i("GroupAppsObserver", 2, localStringBuilder.toString());
    }
    if (!paramBoolean) {
      return;
    }
    if (paramInt != 1) {
      return;
    }
    a(paramBundle.getLong("KEY_GROUP_UIN"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.GroupAppsObserver
 * JD-Core Version:    0.7.0.1
 */