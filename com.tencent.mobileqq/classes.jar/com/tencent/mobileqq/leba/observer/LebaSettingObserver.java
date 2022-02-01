package com.tencent.mobileqq.leba.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class LebaSettingObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, paramObject);
      return;
    }
    a(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.observer.LebaSettingObserver
 * JD-Core Version:    0.7.0.1
 */