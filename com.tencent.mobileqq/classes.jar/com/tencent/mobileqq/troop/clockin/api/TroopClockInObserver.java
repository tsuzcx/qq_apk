package com.tencent.mobileqq.troop.clockin.api;

import com.tencent.mobileqq.app.BusinessObserver;

public class TroopClockInObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
    i = a;
    a = i + 1;
    c = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 4) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String)) && ((paramObject[3] instanceof Integer)))
      {
        a(paramBoolean, (String)paramObject[0], (String)paramObject[1], paramObject[2], ((Integer)paramObject[3]).intValue());
        return;
      }
      a(false, "", "", null, -1);
      return;
    }
    a(false, "", "", null, -1);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 3) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String)))
      {
        a(paramBoolean, (String)paramObject[0], (String)paramObject[1], paramObject[2]);
        return;
      }
      a(false, "", "", null);
      return;
    }
    a(false, "", "", null);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, Object paramObject, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.clockin.api.TroopClockInObserver
 * JD-Core Version:    0.7.0.1
 */