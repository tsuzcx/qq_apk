package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class i
  implements SharedPreferences
{
  private static String j = null;
  private WeakReference a = null;
  private b b = null;
  private SharedPreferences c = null;
  private SharedPreferences.Editor d = null;
  private String e = null;
  private j f = null;
  private boolean g = false;
  private e h = null;
  private Set i = null;
  
  public i(WeakReference paramWeakReference, String paramString, int paramInt, boolean paramBoolean)
  {
    this.a = paramWeakReference;
    boolean bool;
    if (paramInt != 4)
    {
      bool = true;
      this.g = bool;
      if (j == null) {
        j = ((Context)paramWeakReference.get()).getPackageName() + "_preferences";
      }
      int k = paramInt;
      if (j.equals(paramString))
      {
        k = paramInt;
        if (paramInt != 4)
        {
          k = paramInt;
          if (paramBoolean) {
            k = 4;
          }
        }
      }
      if (((k & 0x4) != 4) || (k.b)) {
        break label188;
      }
      this.b = new b(paramWeakReference, paramString);
    }
    for (;;)
    {
      this.e = paramString;
      this.f = new j(this);
      return;
      bool = false;
      break;
      label188:
      this.c = k.a((Context)paramWeakReference.get(), paramString, 0);
      this.d = this.c.edit();
    }
  }
  
  public final boolean contains(String paramString)
  {
    boolean bool = false;
    if (this.b != null)
    {
      bool = ((Boolean)this.b.a(paramString, a.a, Boolean.valueOf(false))).booleanValue();
      return bool;
    }
    if (paramString != null) {}
    for (Object localObject = this.f.a.get(paramString);; localObject = null)
    {
      if (localObject == null) {
        break label73;
      }
      if (localObject.equals(this.f)) {
        break;
      }
      return true;
    }
    label73:
    return this.c.contains(paramString);
  }
  
  public final SharedPreferences.Editor edit()
  {
    return this.f;
  }
  
  public final Map getAll()
  {
    Object localObject2;
    if (this.b != null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = this.c.getAll();
    if (localObject1 != null)
    {
      localObject1 = new HashMap((Map)localObject1);
      ((Map)localObject1).putAll(this.f.a);
    }
    for (;;)
    {
      Iterator localIterator = this.f.a.entrySet().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator.next();
        if (this.f.equals(((Map.Entry)localObject2).getValue())) {
          ((Map)localObject1).remove(((Map.Entry)localObject2).getKey());
        }
      }
      localObject1 = new HashMap(this.f.a);
    }
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.b != null) {
          return ((Boolean)this.b.a(paramString, a.f, Boolean.valueOf(paramBoolean))).booleanValue();
        }
        if (paramString == null) {
          break label110;
        }
        localObject = this.f.a.get(paramString);
        if (localObject != null)
        {
          if (!localObject.equals(this.f)) {
            return ((Boolean)localObject).booleanValue();
          }
        }
        else
        {
          boolean bool = this.c.getBoolean(paramString, paramBoolean);
          return bool;
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (SharedPreferencesProxyManager.a) {
          throw new RuntimeException(paramString);
        }
      }
      return paramBoolean;
      label110:
      Object localObject = null;
    }
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    for (;;)
    {
      try
      {
        if (this.b != null) {
          return ((Float)this.b.a(paramString, a.d, Float.valueOf(paramFloat))).floatValue();
        }
        if (paramString == null) {
          break label110;
        }
        localObject = this.f.a.get(paramString);
        if (localObject != null)
        {
          if (!localObject.equals(this.f)) {
            return ((Float)localObject).floatValue();
          }
        }
        else
        {
          float f1 = this.c.getFloat(paramString, paramFloat);
          return f1;
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (SharedPreferencesProxyManager.a) {
          throw new RuntimeException(paramString);
        }
      }
      return paramFloat;
      label110:
      Object localObject = null;
    }
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.b != null) {
          return ((Integer)this.b.a(paramString, a.b, Integer.valueOf(paramInt))).intValue();
        }
        if (paramString == null) {
          break label110;
        }
        localObject = this.f.a.get(paramString);
        if (localObject != null)
        {
          if (!localObject.equals(this.f)) {
            return ((Integer)localObject).intValue();
          }
        }
        else
        {
          int k = this.c.getInt(paramString, paramInt);
          return k;
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (SharedPreferencesProxyManager.a) {
          throw new RuntimeException(paramString);
        }
      }
      return paramInt;
      label110:
      Object localObject = null;
    }
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.b != null) {
          return ((Long)this.b.a(paramString, a.c, Long.valueOf(paramLong))).longValue();
        }
        if (paramString == null) {
          break label112;
        }
        localObject = this.f.a.get(paramString);
        if (localObject != null)
        {
          if (!localObject.equals(this.f)) {
            return ((Long)localObject).longValue();
          }
        }
        else
        {
          long l = this.c.getLong(paramString, paramLong);
          return l;
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (SharedPreferencesProxyManager.a) {
          throw new RuntimeException(paramString);
        }
      }
      return paramLong;
      label112:
      Object localObject = null;
    }
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (this.b != null) {
          return (String)this.b.a(paramString1, a.e, paramString2);
        }
        if (paramString1 != null)
        {
          localObject = this.f.a.get(paramString1);
          if (localObject != null)
          {
            if (localObject.equals(this.f)) {
              return paramString2;
            }
            return (String)localObject;
          }
          paramString1 = this.c.getString(paramString1, paramString2);
          return paramString1;
        }
      }
      catch (ClassCastException paramString1)
      {
        paramString1.printStackTrace();
        if (SharedPreferencesProxyManager.a) {
          throw new RuntimeException(paramString1);
        }
        return paramString2;
      }
      Object localObject = null;
    }
  }
  
  public final Set getStringSet(String paramString, Set paramSet)
  {
    for (;;)
    {
      try
      {
        if (this.b == null) {
          continue;
        }
        localObject = this.b.a(paramString, a.g, null);
        paramString = localObject;
        if (localObject == null) {
          paramString = paramSet;
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (!SharedPreferencesProxyManager.a) {
          continue;
        }
        throw new RuntimeException(paramString);
        return null;
        paramString = paramSet;
        continue;
        Object localObject = null;
        continue;
      }
      if ((paramString == null) || (!(paramString instanceof Set))) {
        continue;
      }
      return (Set)paramString;
      if (paramString == null) {
        continue;
      }
      localObject = this.f.a.get(paramString);
      if (localObject != null)
      {
        if (localObject.equals(this.f)) {
          paramString = paramSet;
        } else {
          paramString = (Set)localObject;
        }
      }
      else {
        paramString = this.c.getStringSet(paramString, paramSet);
      }
    }
  }
  
  public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      if (this.i == null) {
        this.i = new HashSet(2);
      }
      this.i.add(paramOnSharedPreferenceChangeListener);
      return;
    }
    finally {}
  }
  
  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      if (this.i != null) {
        this.i.remove(paramOnSharedPreferenceChangeListener);
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
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.i
 * JD-Core Version:    0.7.0.1
 */