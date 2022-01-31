package com.tencent.mqq.shared_file_accessor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build.VERSION;
import java.util.Map;
import java.util.Set;

final class l
  implements SharedPreferences
{
  public final boolean contains(String paramString)
  {
    throw new NullPointerException();
  }
  
  public final SharedPreferences.Editor edit()
  {
    throw new NullPointerException();
  }
  
  public final Map getAll()
  {
    throw new NullPointerException();
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    throw new NullPointerException();
  }
  
  public final float getFloat(String paramString, float paramFloat)
  {
    throw new NullPointerException();
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    throw new NullPointerException();
  }
  
  public final long getLong(String paramString, long paramLong)
  {
    throw new NullPointerException();
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    throw new NullPointerException();
  }
  
  public final Set getStringSet(String paramString, Set paramSet)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      throw new NullPointerException();
    }
    return null;
  }
  
  public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    throw new NullPointerException();
  }
  
  public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.l
 * JD-Core Version:    0.7.0.1
 */