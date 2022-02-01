package com.tencent.mobileqq.leba.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class LebaSettingObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.observer.LebaSettingObserver
 * JD-Core Version:    0.7.0.1
 */