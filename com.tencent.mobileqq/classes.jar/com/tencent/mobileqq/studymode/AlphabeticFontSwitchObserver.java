package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.app.BusinessObserver;

public class AlphabeticFontSwitchObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      b(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    a(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.AlphabeticFontSwitchObserver
 * JD-Core Version:    0.7.0.1
 */