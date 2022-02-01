package com.tencent.weui.base.preference;

import android.preference.Preference;

public abstract interface IPreferenceScreen
{
  public abstract void addPreference(Preference paramPreference);
  
  public abstract void addPreference(Preference paramPreference, int paramInt);
  
  public abstract void addPreference(Preference paramPreference, boolean paramBoolean);
  
  public abstract void addPreferencesFromResource(int paramInt);
  
  public abstract Preference findPreference(String paramString);
  
  public abstract void hidePreference(String paramString, boolean paramBoolean);
  
  public abstract int indexOf(String paramString);
  
  public abstract int indexOfShow(String paramString);
  
  public abstract void notifyDataSetChanged();
  
  public abstract void removeAll();
  
  public abstract boolean removePreference(Preference paramPreference);
  
  public abstract boolean removePreference(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.IPreferenceScreen
 * JD-Core Version:    0.7.0.1
 */