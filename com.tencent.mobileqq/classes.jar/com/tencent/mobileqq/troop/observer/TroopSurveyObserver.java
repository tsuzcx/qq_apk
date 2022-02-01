package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class TroopSurveyObserver
  implements BusinessObserver
{
  public static final int a;
  private static int b;
  
  static
  {
    int i = b;
    b = i + 1;
    a = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != a) {
      return;
    }
    a(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.TroopSurveyObserver
 * JD-Core Version:    0.7.0.1
 */