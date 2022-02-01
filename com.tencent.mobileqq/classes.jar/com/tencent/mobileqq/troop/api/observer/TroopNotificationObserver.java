package com.tencent.mobileqq.troop.api.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.service.troop.TroopSystemNotificationConstants;

public class TroopNotificationObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == TroopSystemNotificationConstants.a)
    {
      a(paramBoolean, paramObject);
      return;
    }
    if (paramInt == TroopSystemNotificationConstants.b) {
      b(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.observer.TroopNotificationObserver
 * JD-Core Version:    0.7.0.1
 */