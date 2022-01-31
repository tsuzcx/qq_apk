package com.tencent.tvkbeacon.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c
{
  private static c a;
  private Context b;
  private SharedPreferences c;
  private SharedPreferences.Editor d;
  private Lock e = new ReentrantLock();
  private Runnable f = new c.1(this);
  
  private c(Context paramContext)
  {
    if (paramContext != null)
    {
      this.b = paramContext;
      this.c = paramContext.getSharedPreferences("tvkbeacon_DENGTA_META", 0);
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new c(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void d()
  {
    if (this.e.tryLock())
    {
      this.d.commit();
      this.e.unlock();
    }
  }
  
  public final int a(String paramString)
  {
    try
    {
      int i = this.c.getInt(paramString, 0);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final c a()
  {
    try
    {
      if ((this.c != null) && (this.d == null)) {
        this.d = this.c.edit();
      }
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final c a(String paramString, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if ((this.c == null) || (this.d == null))
        {
          com.tencent.tvkbeacon.core.c.c.d("[sp] create failed or edit() has not called.", new Object[0]);
          return this;
        }
        if ((paramObject instanceof String)) {
          this.d.putString(paramString, (String)paramObject);
        } else if ((paramObject instanceof Boolean)) {
          this.d.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        }
      }
      finally {}
      if ((paramObject instanceof Integer)) {
        this.d.putInt(paramString, ((Integer)paramObject).intValue());
      } else if ((paramObject instanceof Long)) {
        this.d.putLong(paramString, ((Long)paramObject).longValue());
      }
    }
  }
  
  public final String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.c.getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final long b(String paramString)
  {
    try
    {
      long l = this.c.getLong(paramString, 0L);
      return l;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b()
  {
    if ((this.c != null) && (this.d != null))
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        b.d().a(this.f);
      }
    }
    else {
      return;
    }
    d();
  }
  
  public final SharedPreferences c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.c
 * JD-Core Version:    0.7.0.1
 */