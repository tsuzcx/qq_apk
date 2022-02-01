package com.tencent.mobileqq.troop.api.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class TroopModifyObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  
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
    i = a;
    a = i + 1;
    f = i;
    i = a;
    a = i + 1;
    g = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 4) && ((paramObject[0] instanceof Long)) && ((paramObject[1] instanceof String)) && ((paramObject[2] instanceof Integer)) && ((paramObject[3] instanceof String))) {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      }
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    try
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2]);
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopinfo", 2, paramObject.toString());
      }
    }
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    if ((paramObject instanceof String)) {
      a(paramBoolean, (String)paramObject);
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    if (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramObject != null)
    {
      if (paramObject.length >= 4) {
        paramInt = ((Integer)paramObject[3]).intValue();
      } else {
        paramInt = 0;
      }
      a(paramBoolean, (String)paramObject[0], (String)paramObject[1], (String)paramObject[2], paramInt);
    }
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != f) {
      return;
    }
    if (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramObject.length == 0)
    {
      a(false, -1L, "");
      return;
    }
    a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1]);
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != g) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
    e(paramInt, paramBoolean, paramObject);
    f(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.observer.TroopModifyObserver
 * JD-Core Version:    0.7.0.1
 */