package com.tencent.tvkbeacon.core.strategy;

import com.tencent.tvkbeacon.core.c.c;
import java.util.Map;
import java.util.Set;

public final class a
{
  public String a = "";
  private final int b;
  private boolean c = false;
  private Map<String, String> d = null;
  private Set<String> e = null;
  private Set<String> f = null;
  private Object g = null;
  
  public a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(Object paramObject)
  {
    this.g = paramObject;
  }
  
  public final void a(String paramString)
  {
    if ((this.b == 1) && (b.a().a))
    {
      c.c("[strategy] user event url has defined by api, don't change.", new Object[0]);
      return;
    }
    this.a = paramString;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  public final void a(Set<String> paramSet)
  {
    this.e = paramSet;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  public final Map<String, String> b()
  {
    return this.d;
  }
  
  public final void b(Set<String> paramSet)
  {
    this.f = paramSet;
  }
  
  public final Set<String> c()
  {
    return this.e;
  }
  
  public final int d()
  {
    return this.b;
  }
  
  public final Set<String> e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.strategy.a
 * JD-Core Version:    0.7.0.1
 */