package com.tencent.mobileqq.troop.troopsetting.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class TroopSettingObserver
  implements BusinessObserver
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  private static int g;
  
  static
  {
    int i = g;
    g = i + 1;
    a = i;
    i = g;
    g = i + 1;
    b = i;
    i = g;
    g = i + 1;
    c = i;
    i = g;
    g = i + 1;
    d = i;
    i = g;
    g = i + 1;
    e = i;
    i = g;
    g = i + 1;
    f = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != a) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length >= 2) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof Integer)))
      {
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
        a((String)paramObject[0]);
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
      b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("oidb_0x91a_1", 2, paramObject.toString());
      }
    }
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    b(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    a(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != f) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
    }
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString1, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver
 * JD-Core Version:    0.7.0.1
 */