package com.tencent.superplayer.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.Set;

class EmptySharedPreferences
  implements SharedPreferences
{
  public boolean contains(String paramString)
  {
    return false;
  }
  
  public SharedPreferences.Editor edit()
  {
    return new EmptySharedPreferences.1(this);
  }
  
  public Map<String, ?> getAll()
  {
    return null;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return paramLong;
  }
  
  @Nullable
  public String getString(String paramString1, @Nullable String paramString2)
  {
    return paramString2;
  }
  
  @Nullable
  public Set<String> getStringSet(String paramString, @Nullable Set<String> paramSet)
  {
    return paramSet;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.config.EmptySharedPreferences
 * JD-Core Version:    0.7.0.1
 */