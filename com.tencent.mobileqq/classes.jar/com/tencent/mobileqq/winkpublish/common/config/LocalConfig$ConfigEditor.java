package com.tencent.mobileqq.winkpublish.common.config;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.util.Set;

class LocalConfig$ConfigEditor
  implements SharedPreferences.Editor
{
  private SharedPreferences.Editor a;
  
  public LocalConfig$ConfigEditor(SharedPreferences.Editor paramEditor)
  {
    this.a = paramEditor;
  }
  
  public void apply()
  {
    commit();
  }
  
  public SharedPreferences.Editor clear()
  {
    this.a.clear();
    return this;
  }
  
  @SuppressLint({"NewApi"})
  public boolean commit()
  {
    if (Build.VERSION.SDK_INT < 9) {
      return this.a.commit();
    }
    this.a.apply();
    return true;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    this.a.putBoolean(paramString, paramBoolean);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    this.a.putFloat(paramString, paramFloat);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    this.a.putInt(paramString, paramInt);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    this.a.putLong(paramString, paramLong);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    this.a.putString(paramString1, paramString2);
    return this;
  }
  
  @SuppressLint({"NewApi"})
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      this.a.putStringSet(paramString, paramSet);
    }
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    this.a.remove(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.common.config.LocalConfig.ConfigEditor
 * JD-Core Version:    0.7.0.1
 */