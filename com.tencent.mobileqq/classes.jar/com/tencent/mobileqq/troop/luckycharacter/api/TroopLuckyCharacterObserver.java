package com.tencent.mobileqq.troop.luckycharacter.api;

import com.tencent.mobileqq.app.BusinessObserver;

public class TroopLuckyCharacterObserver
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
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 2) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String))) {
        a(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterObserver
 * JD-Core Version:    0.7.0.1
 */