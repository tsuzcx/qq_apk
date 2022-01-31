package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessObserver;

public class LightalkShieldObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, ((Integer)paramObject).intValue());
      return;
    case 2: 
      b(paramBoolean, ((Integer)paramObject).intValue());
      return;
    case 3: 
      if (paramBoolean)
      {
        a(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
      a(paramBoolean, false);
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.LightalkShieldObserver
 * JD-Core Version:    0.7.0.1
 */