package com.tencent.mobileqq.troop.onlinemember.api;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;

public class TroopOnlineMemberObserver
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
    if (paramInt != b) {
      return;
    }
    paramObject = (Object[])paramObject;
    b(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    paramObject = (Object[])paramObject;
    b(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != f) {
      return;
    }
    paramObject = (Object[])paramObject;
    b(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != g) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != h) {
      return;
    }
    paramObject = (Object[])paramObject;
    c(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void g(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString, List<String> paramList) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void b(boolean paramBoolean, String paramString, List<String> paramList) {}
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void c(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver
 * JD-Core Version:    0.7.0.1
 */