package com.tencent.mobileqq.troop.api.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public class TroopPushObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
    i = a;
    a = i + 1;
    c = i;
    i = a;
    a = i + 1;
    d = i;
    i = a;
    a = i + 1;
    e = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == d)
    {
      if (!paramBoolean) {
        return;
      }
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length >= 2) {
          a((String)paramObject[0], ((Long)paramObject[1]).longValue());
        }
      }
    }
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 2) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof Integer))) {
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      }
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 2) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof Long))) {
        a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue());
      }
    }
  }
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(String paramString, long paramLong) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.observer.TroopPushObserver
 * JD-Core Version:    0.7.0.1
 */