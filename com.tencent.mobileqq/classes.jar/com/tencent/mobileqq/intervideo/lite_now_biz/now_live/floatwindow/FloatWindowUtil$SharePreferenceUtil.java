package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.floatwindow;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class FloatWindowUtil$SharePreferenceUtil
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  
  public FloatWindowUtil$SharePreferenceUtil(Context paramContext, String paramString)
  {
    this.a = paramContext.getSharedPreferences(paramString, 0);
    this.b = this.a.edit();
  }
  
  public SharedPreferences a()
  {
    return this.a;
  }
  
  public SharedPreferences.Editor b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.floatwindow.FloatWindowUtil.SharePreferenceUtil
 * JD-Core Version:    0.7.0.1
 */