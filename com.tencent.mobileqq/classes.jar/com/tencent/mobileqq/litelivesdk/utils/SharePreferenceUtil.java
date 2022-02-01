package com.tencent.mobileqq.litelivesdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class SharePreferenceUtil
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  
  public SharePreferenceUtil(Context paramContext, String paramString)
  {
    this.a = paramContext.getSharedPreferences(paramString, 0);
    this.b = this.a.edit();
  }
  
  public SharedPreferences a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.SharePreferenceUtil
 * JD-Core Version:    0.7.0.1
 */