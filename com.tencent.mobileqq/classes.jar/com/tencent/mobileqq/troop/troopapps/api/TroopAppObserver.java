package com.tencent.mobileqq.troop.troopapps.api;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.Result;

public class TroopAppObserver
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
    if (paramInt != d) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(Boolean.valueOf(paramBoolean), (ArrayList)paramObject[0], (List)paramObject[1]);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    paramObject = (Object[])paramObject;
    a((oidb_0xe83.RspBody)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    a(Boolean.valueOf(paramBoolean));
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    b(Boolean.valueOf(paramBoolean));
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != f) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        a(paramBoolean, paramObject[0], paramObject[1], ((Integer)paramObject[2]).intValue());
        return;
      }
      a(false, null, null, -1);
      return;
    }
    a(false, null, null, -1);
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != g) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        a(paramBoolean, ((Long)paramObject[0]).longValue(), paramObject[1], ((Integer)paramObject[2]).intValue());
        return;
      }
      a(false, 0L, null, -1);
      return;
    }
    a(false, 0L, null, -1);
  }
  
  protected void a(Boolean paramBoolean) {}
  
  protected void a(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList) {}
  
  protected void a(oidb_0xe83.RspBody paramRspBody, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong, Object paramObject, int paramInt) {}
  
  public void a(boolean paramBoolean, Object paramObject1, Object paramObject2, int paramInt) {}
  
  protected void b(Boolean paramBoolean) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver
 * JD-Core Version:    0.7.0.1
 */