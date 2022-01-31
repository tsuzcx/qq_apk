package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class n
  implements SharedPreferences
{
  private h a = null;
  private o b = null;
  private Set c = null;
  
  public n(WeakReference paramWeakReference, String paramString, int paramInt)
  {
    if (((paramInt & 0x4) == 4) && (!p.a)) {}
    for (this.a = new f(paramWeakReference, paramString);; this.a = new k((Context)paramWeakReference.get(), paramString, paramInt))
    {
      this.b = new o(this, (byte)0);
      return;
    }
  }
  
  final void a()
  {
    this.a.a();
  }
  
  public final boolean contains(String paramString)
  {
    return ((Boolean)this.a.a(paramString, d.c, Boolean.valueOf(false))).booleanValue();
  }
  
  public final SharedPreferences.Editor edit()
  {
    return this.b;
  }
  
  public final Map getAll()
  {
    return this.a.b();
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return ((Boolean)this.a.a(paramString, d.h, Boolean.valueOf(paramBoolean))).booleanValue();
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    return ((Float)this.a.a(paramString, d.f, Float.valueOf(paramFloat))).floatValue();
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    return ((Integer)this.a.a(paramString, d.d, Integer.valueOf(paramInt))).intValue();
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    return ((Long)this.a.a(paramString, d.e, Long.valueOf(paramLong))).longValue();
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    return (String)this.a.a(paramString1, d.g, paramString2);
  }
  
  public final Set getStringSet(String paramString, Set paramSet)
  {
    paramString = this.a.a(paramString, d.i, paramSet);
    if ((paramString != null) && ((paramString instanceof Set))) {
      return (Set)paramString;
    }
    return null;
  }
  
  public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      if (this.c == null) {
        this.c = new HashSet(2);
      }
      this.c.add(paramOnSharedPreferenceChangeListener);
      return;
    }
    finally {}
  }
  
  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      if (this.c != null) {
        this.c.remove(paramOnSharedPreferenceChangeListener);
      }
      return;
    }
    finally
    {
      paramOnSharedPreferenceChangeListener = finally;
      throw paramOnSharedPreferenceChangeListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.n
 * JD-Core Version:    0.7.0.1
 */