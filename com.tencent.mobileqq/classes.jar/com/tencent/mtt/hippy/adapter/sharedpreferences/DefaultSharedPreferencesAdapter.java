package com.tencent.mtt.hippy.adapter.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class DefaultSharedPreferencesAdapter
  implements HippySharedPreferencesAdapter
{
  private Context mContext;
  
  public DefaultSharedPreferencesAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public SharedPreferences getSharedPreferences()
  {
    return this.mContext.getSharedPreferences("hippy_sdk_configs", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.sharedpreferences.DefaultSharedPreferencesAdapter
 * JD-Core Version:    0.7.0.1
 */