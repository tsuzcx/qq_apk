package com.tencent.mobileqq.profilecommon.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class ProfileCommonObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      a(paramBoolean, ((Integer)paramObject).intValue());
    }
    while (paramInt != 2) {
      return;
    }
    a(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver
 * JD-Core Version:    0.7.0.1
 */