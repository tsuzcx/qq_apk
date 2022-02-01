package com.tencent.mobileqq.profilecommon.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class ProfileCommonObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      b(paramBoolean, ((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 2)
    {
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    if (paramInt == 3) {
      a(paramBoolean, ((Integer)paramObject).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver
 * JD-Core Version:    0.7.0.1
 */