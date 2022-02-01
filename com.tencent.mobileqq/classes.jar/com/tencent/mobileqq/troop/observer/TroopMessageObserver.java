package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class TroopMessageObserver
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
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      String str1 = (String)paramObject[0];
      boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
      String str2 = (String)paramObject[2];
      String str3 = (String)paramObject[3];
      boolean bool1;
      if (paramObject.length >= 5) {
        bool1 = ((Boolean)paramObject[4]).booleanValue();
      } else {
        bool1 = false;
      }
      a(paramBoolean, str1, bool2, str2, str3, bool1);
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.TroopMessageObserver
 * JD-Core Version:    0.7.0.1
 */