package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class TroopSurveyObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.TroopSurveyObserver
 * JD-Core Version:    0.7.0.1
 */