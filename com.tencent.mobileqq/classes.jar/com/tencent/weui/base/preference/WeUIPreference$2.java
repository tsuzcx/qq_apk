package com.tencent.weui.base.preference;

import android.preference.Preference;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WeUIPreference$2
  implements AdapterView.OnItemClickListener
{
  WeUIPreference$2(WeUIPreference paramWeUIPreference) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Preference localPreference = (Preference)paramAdapterView.getAdapter().getItem(paramInt);
    if ((localPreference != null) && (localPreference.isEnabled()) && (localPreference.isSelectable()) && (!(localPreference instanceof CheckBoxPreference)) && (localPreference.getKey() != null))
    {
      WeUIPreference localWeUIPreference = this.a;
      localWeUIPreference.onPreferenceTreeClick(WeUIPreference.c(localWeUIPreference), localPreference);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.2
 * JD-Core Version:    0.7.0.1
 */