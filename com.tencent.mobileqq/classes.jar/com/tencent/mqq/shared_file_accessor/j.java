package com.tencent.mqq.shared_file_accessor;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class j
  implements SharedPreferences.Editor, Runnable
{
  protected final Map a = new ConcurrentHashMap();
  
  j(i parami) {}
  
  private void a()
  {
    SharedPreferencesProxyManager.getInstance();
    Object localObject;
    if (SharedPreferencesProxyManager.a())
    {
      localObject = k.a();
      localObject = ((l)localObject).a + '|' + ((l)localObject).b + '|' + ((l)localObject).c;
      if (k.b)
      {
        SharedPreferencesProxyManager.getInstance();
        SharedPreferencesProxyManager.a(i.e(this.b), k.a, localObject);
      }
    }
    else
    {
      return;
    }
    if (i.f(this.b) == null) {
      i.a(this.b, new e(i.g(this.b), i.e(this.b)));
    }
    i.f(this.b).a((String)localObject);
  }
  
  private void a(String paramString)
  {
    synchronized (this.b)
    {
      if (i.c(this.b) != null)
      {
        Iterator localIterator = i.c(this.b).iterator();
        if (localIterator.hasNext()) {
          ((SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next()).onSharedPreferenceChanged(this.b, paramString);
        }
      }
    }
  }
  
  final void a(boolean paramBoolean)
  {
    if (i.a(this.b) != null)
    {
      i.a(this.b).b();
      if ((i.d(this.b)) && (paramBoolean)) {
        a();
      }
    }
    for (;;)
    {
      return;
      if ((Looper.getMainLooper() != Looper.myLooper()) || (SharedPreferencesProxyManager.b)) {
        i.b(this.b).commit();
      }
      while (paramBoolean)
      {
        a();
        return;
        g.a.a(this);
      }
    }
  }
  
  public final void apply()
  {
    a(true);
  }
  
  public final SharedPreferences.Editor clear()
  {
    if (i.a(this.b) != null)
    {
      i.a(this.b).a();
      return this;
    }
    this.a.clear();
    i.b(this.b).clear();
    return this;
  }
  
  public final boolean commit()
  {
    a(true);
    return true;
  }
  
  public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    if (i.a(this.b) != null)
    {
      b localb = i.a(this.b);
      c localc = a.f;
      localb.a(paramString, Boolean.valueOf(paramBoolean));
    }
    for (;;)
    {
      a(paramString);
      return this;
      if (paramString != null) {
        this.a.put(paramString, Boolean.valueOf(paramBoolean));
      }
      i.b(this.b).putBoolean(paramString, paramBoolean);
    }
  }
  
  public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    if (i.a(this.b) != null)
    {
      b localb = i.a(this.b);
      c localc = a.d;
      localb.a(paramString, Float.valueOf(paramFloat));
    }
    for (;;)
    {
      a(paramString);
      return this;
      if (paramString != null) {
        this.a.put(paramString, Float.valueOf(paramFloat));
      }
      i.b(this.b).putFloat(paramString, paramFloat);
    }
  }
  
  public final SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    if (i.a(this.b) != null)
    {
      b localb = i.a(this.b);
      c localc = a.b;
      localb.a(paramString, Integer.valueOf(paramInt));
    }
    for (;;)
    {
      a(paramString);
      return this;
      if (paramString != null) {
        this.a.put(paramString, Integer.valueOf(paramInt));
      }
      i.b(this.b).putInt(paramString, paramInt);
    }
  }
  
  public final SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    if (i.a(this.b) != null)
    {
      b localb = i.a(this.b);
      c localc = a.c;
      localb.a(paramString, Long.valueOf(paramLong));
    }
    for (;;)
    {
      a(paramString);
      return this;
      if (paramString != null) {
        this.a.put(paramString, Long.valueOf(paramLong));
      }
      i.b(this.b).putLong(paramString, paramLong);
    }
  }
  
  public final SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    if (i.a(this.b) != null)
    {
      b localb = i.a(this.b);
      c localc = a.e;
      localb.a(paramString1, paramString2);
      a(paramString1);
      return this;
    }
    if (paramString1 != null)
    {
      if (paramString2 != null) {
        break label74;
      }
      this.a.put(paramString1, this);
    }
    for (;;)
    {
      i.b(this.b).putString(paramString1, paramString2);
      break;
      label74:
      this.a.put(paramString1, paramString2);
    }
  }
  
  public final SharedPreferences.Editor putStringSet(String paramString, Set paramSet)
  {
    if (i.a(this.b) != null)
    {
      b localb = i.a(this.b);
      c localc = a.g;
      localb.a(paramString, paramSet);
      a(paramString);
      return this;
    }
    if (paramString != null)
    {
      if (paramSet != null) {
        break label74;
      }
      this.a.put(paramString, this);
    }
    for (;;)
    {
      i.b(this.b).putStringSet(paramString, paramSet);
      break;
      label74:
      this.a.put(paramString, new HashSet(paramSet));
    }
  }
  
  public final SharedPreferences.Editor remove(String paramString)
  {
    if (i.a(this.b) != null) {
      i.a(this.b).a(paramString);
    }
    for (;;)
    {
      a(paramString);
      return this;
      if (paramString != null) {
        this.a.put(paramString, this);
      }
      i.b(this.b).remove(paramString);
    }
  }
  
  public final void run()
  {
    i.b(this.b).commit();
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.j
 * JD-Core Version:    0.7.0.1
 */