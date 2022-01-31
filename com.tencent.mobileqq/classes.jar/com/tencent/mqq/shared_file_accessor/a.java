package com.tencent.mqq.shared_file_accessor;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class a
  implements h
{
  protected volatile boolean a = false;
  protected boolean b = true;
  protected String c = null;
  private Handler d = null;
  private List e = new ArrayList();
  private volatile boolean f = false;
  private Map g = new HashMap();
  private Map h = null;
  private volatile boolean i = false;
  private int j = 300;
  
  private void c()
  {
    if (this.d.hasMessages(0)) {
      if (this.e.size() <= 1000) {}
    }
    while (this.d.sendEmptyMessageDelayed(0, this.j))
    {
      return;
      this.d.removeMessages(0);
    }
    this.d = new c(this, SharedPreferencesProxyManager.getInstance().b());
    this.d.sendEmptyMessageDelayed(0, this.j);
  }
  
  public final Object a(String paramString, e parame, Object paramObject)
  {
    for (;;)
    {
      try
      {
        Object localObject2;
        if (!this.b)
        {
          localObject2 = b(paramString, parame, paramObject);
          return localObject2;
        }
        Object localObject1 = (i)this.g.get(paramString);
        if (localObject1 != null) {
          localObject2 = paramObject;
        }
        switch (((i)localObject1).a)
        {
        case 2: 
        case 0: 
          localObject2 = b(paramString, parame, paramObject);
          continue;
          if (this.f)
          {
            localObject1 = d.a;
          }
          else
          {
            if (this.a)
            {
              localObject2 = (i)this.h.get(paramString);
              localObject1 = localObject2;
              if (localObject2 != null) {
                continue;
              }
              if (this.i)
              {
                localObject1 = d.a;
                continue;
              }
            }
            localObject1 = d.b;
          }
          break;
        case 1: 
          if (((i)localObject1).b.getClass().getName().equals(parame.b))
          {
            localObject2 = ((i)localObject1).b;
          }
          else
          {
            localObject2 = paramObject;
            if (parame.a == 0) {
              localObject2 = Boolean.valueOf(true);
            }
          }
          break;
        default: 
          localObject2 = paramObject;
        }
      }
      finally {}
    }
  }
  
  public final void a()
  {
    try
    {
      a(this.e);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      if (this.b)
      {
        this.e.add(new b(1, paramString, null, d.c));
        this.g.put(paramString, d.a);
      }
      c();
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, Object paramObject, e parame)
  {
    if (paramObject == null) {}
    for (;;)
    {
      try
      {
        a(paramString);
        return;
      }
      finally {}
      if (this.b)
      {
        this.e.add(new b(0, paramString, paramObject, parame));
        this.g.put(paramString, new i(1, paramObject));
      }
      c();
    }
  }
  
  protected abstract void a(List paramList);
  
  protected abstract Object b(String paramString, e parame, Object paramObject);
  
  public final void b(String paramString)
  {
    try
    {
      if (this.b)
      {
        this.f = true;
        this.e.clear();
        this.e.add(new b(2, null, null, d.c));
        this.g.clear();
        if (this.a)
        {
          this.i = true;
          this.h.clear();
        }
      }
      c();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.a
 * JD-Core Version:    0.7.0.1
 */