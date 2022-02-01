package com.tencent.weui.base.preference;

import android.preference.Preference;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.ui.f;

class WeUIPreference$3
  implements AdapterView.OnItemLongClickListener
{
  WeUIPreference$3(WeUIPreference paramWeUIPreference) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < WeUIPreference.d(this.a).getHeaderViewsCount()) {
      return false;
    }
    paramInt -= WeUIPreference.d(this.a).getHeaderViewsCount();
    if (paramInt >= WeUIPreference.c(this.a).getCount())
    {
      f.e("MicroMsg.mmui.WeUIPreference", "itemlongclick, outofindex, %d, %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(WeUIPreference.c(this.a).getCount()) });
      return false;
    }
    paramAdapterView = (Preference)WeUIPreference.c(this.a).getItem(paramInt);
    paramView = this.a;
    return paramView.onPreferenceTreeLongClick(WeUIPreference.c(paramView), paramAdapterView, WeUIPreference.d(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference.3
 * JD-Core Version:    0.7.0.1
 */