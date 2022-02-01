package com.tencent.mobileqq.inputstatus;

import com.tencent.mobileqq.app.BusinessObserver;

public class InputStatusObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        b(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusObserver
 * JD-Core Version:    0.7.0.1
 */