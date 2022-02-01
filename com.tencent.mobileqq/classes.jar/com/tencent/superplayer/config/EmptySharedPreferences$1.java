package com.tencent.superplayer.config;

import android.content.SharedPreferences.Editor;
import android.support.annotation.Nullable;
import java.util.Set;

class EmptySharedPreferences$1
  implements SharedPreferences.Editor
{
  EmptySharedPreferences$1(EmptySharedPreferences paramEmptySharedPreferences) {}
  
  public void apply() {}
  
  public SharedPreferences.Editor clear()
  {
    return this;
  }
  
  public boolean commit()
  {
    return false;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, @Nullable String paramString2)
  {
    return this;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, @Nullable Set<String> paramSet)
  {
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.config.EmptySharedPreferences.1
 * JD-Core Version:    0.7.0.1
 */