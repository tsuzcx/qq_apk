package com.tencent.weui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

class WeUIPreference$1
  implements Preference.OnPreferenceChangeListener
{
  WeUIPreference$1(WeUIPreference paramWeUIPreference) {}
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if ((!WeUIPreference.a(this.a)) && (paramPreference.isEnabled()) && (paramPreference.isSelectable()))
    {
      WeUIPreference.a(this.a, true);
      int i;
      if ((paramPreference instanceof CheckBoxPreference))
      {
        paramObject = (CheckBoxPreference)paramPreference;
        paramObject.setChecked(paramObject.isChecked());
        if (paramObject.isPersistent()) {
          WeUIPreference.b(this.a).edit().putBoolean(paramPreference.getKey(), paramObject.isChecked()).commit();
        }
        WeUIPreference.b(this.a, true);
        i = 1;
      }
      else
      {
        i = 0;
      }
      if (paramPreference.getKey() != null)
      {
        paramObject = this.a;
        paramObject.onPreferenceTreeClick(WeUIPreference.c(paramObject), paramPreference);
      }
      if (i != 0) {
        WeUIPreference.c(this.a).notifyDataSetChanged();
      }
      WeUIPreference.a(this.a, false);
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.1
 * JD-Core Version:    0.7.0.1
 */