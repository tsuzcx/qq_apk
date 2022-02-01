package com.tencent.mobileqq.troop.api.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;

public class TroopMngObserver
  implements BusinessObserver
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  public static final int i;
  public static final int j;
  public static final int k;
  public static final int l;
  private static int m;
  
  static
  {
    int n = m;
    m = n + 1;
    a = n;
    n = m;
    m = n + 1;
    b = n;
    n = m;
    m = n + 1;
    c = n;
    n = m;
    m = n + 1;
    d = n;
    n = m;
    m = n + 1;
    e = n;
    n = m;
    m = n + 1;
    f = n;
    n = m;
    m = n + 1;
    g = n;
    n = m;
    m = n + 1;
    h = n;
    n = m;
    m = n + 1;
    i = n;
    n = m;
    m = n + 1;
    j = n;
    n = m;
    m = n + 1;
    k = n;
    n = m;
    m = n + 1;
    l = n;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != a) {
      return;
    }
    a(paramBoolean, paramObject);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject[1] instanceof Integer)) {
      paramInt = ((Integer)paramObject[1]).intValue();
    } else {
      paramInt = ((Byte)paramObject[1]).byteValue();
    }
    if (paramBoolean)
    {
      a(((Integer)paramObject[0]).intValue(), paramInt, (String)paramObject[2]);
      return;
    }
    a(((Integer)paramObject[0]).intValue(), paramInt);
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 3) {
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
      }
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    byte b1 = ((Byte)arrayOfObject[0]).byteValue();
    if (arrayOfObject[1] != null) {
      paramObject = (TroopInfo)arrayOfObject[1];
    } else {
      paramObject = null;
    }
    a(true, b1, paramObject, ((Boolean)arrayOfObject[2]).booleanValue());
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != g) {
      return;
    }
    if ((paramObject instanceof String))
    {
      a((String)paramObject);
      return;
    }
    a(null);
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
  }
  
  private void g(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != f) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2]);
  }
  
  private void h(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != h) {
      return;
    }
    if ((paramObject instanceof Object[])) {
      c((String)((Object[])(Object[])paramObject)[0]);
    }
  }
  
  private void i(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != i) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 1) {
        paramInt = ((Integer)paramObject[0]).intValue();
      } else {
        paramInt = 0;
      }
      if ((paramBoolean) && (paramObject.length >= 4))
      {
        a(paramBoolean, paramInt, (String)paramObject[1], (String)paramObject[2], (Boolean)paramObject[3]);
        return;
      }
      a(paramBoolean, paramInt, null, null, Boolean.valueOf(true));
    }
  }
  
  private void j(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != j) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 5)
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue());
        return;
      }
      if (paramObject.length == 2) {
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      }
    }
  }
  
  private void k(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != k) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (ArrayList)paramObject[3], ((Integer)paramObject[4]).intValue());
      return;
    }
    a(false, -1, 0, 0, null, 0);
  }
  
  private void l(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != l) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof String))) {
      b((String)paramObject);
    }
  }
  
  protected void a(int paramInt1, int paramInt2) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(String paramString) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long paramLong) {}
  
  protected void b(String paramString) {}
  
  protected void c(String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
    e(paramInt, paramBoolean, paramObject);
    f(paramInt, paramBoolean, paramObject);
    a(paramInt, paramBoolean, paramObject);
    g(paramInt, paramBoolean, paramObject);
    h(paramInt, paramBoolean, paramObject);
    i(paramInt, paramBoolean, paramObject);
    j(paramInt, paramBoolean, paramObject);
    k(paramInt, paramBoolean, paramObject);
    l(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.observer.TroopMngObserver
 * JD-Core Version:    0.7.0.1
 */