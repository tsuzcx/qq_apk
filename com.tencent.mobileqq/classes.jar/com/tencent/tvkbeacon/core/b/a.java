package com.tencent.tvkbeacon.core.b;

import android.content.Context;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.protocol.common.RequestPackage;
import com.tencent.tvkbeacon.core.strategy.d;

public abstract class a
{
  protected final int a;
  protected final int b;
  protected Context c;
  protected String d;
  protected int e;
  protected String f;
  private a.a g;
  
  public a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    this.c = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
    this.f = paramString;
  }
  
  public a(Context paramContext, String paramString)
  {
    this.c = paramContext;
    this.a = 102;
    this.b = 0;
    this.f = paramString;
    this.g = null;
  }
  
  public abstract RequestPackage a();
  
  public void b()
  {
    c.c("[db] encode failed, clear db data", new Object[0]);
  }
  
  public abstract void b(boolean paramBoolean);
  
  public final int c()
  {
    return this.a;
  }
  
  public final String d()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    return d.a(this.c).a(this.b);
  }
  
  public final int f()
  {
    try
    {
      int i = this.e;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.b.a
 * JD-Core Version:    0.7.0.1
 */