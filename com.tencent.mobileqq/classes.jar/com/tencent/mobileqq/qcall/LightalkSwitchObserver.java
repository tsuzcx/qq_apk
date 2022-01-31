package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessObserver;

public abstract class LightalkSwitchObserver
  implements BusinessObserver
{
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.LightalkSwitchObserver
 * JD-Core Version:    0.7.0.1
 */