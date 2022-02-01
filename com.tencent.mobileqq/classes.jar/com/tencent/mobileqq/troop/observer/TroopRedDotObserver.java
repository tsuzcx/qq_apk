package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import java.util.List;

public class TroopRedDotObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  
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
    i = a;
    a = i + 1;
    h = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject instanceof Object[])) {
      a(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2) {
        a((String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
      }
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 1) {
        c(paramBoolean, (String)paramObject[0]);
      }
    }
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != f) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1], ((Integer)paramObject[2]).intValue());
    }
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != g) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue());
    }
  }
  
  private void g(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != h) {
      return;
    }
    if ((paramObject instanceof Object[])) {
      b(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<TroopUnreadMsgInfo> paramList, int paramInt) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void c(boolean paramBoolean, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
    e(paramInt, paramBoolean, paramObject);
    f(paramInt, paramBoolean, paramObject);
    g(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.observer.TroopRedDotObserver
 * JD-Core Version:    0.7.0.1
 */