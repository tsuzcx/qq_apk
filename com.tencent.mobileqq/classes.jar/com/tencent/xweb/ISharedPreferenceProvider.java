package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;

public abstract interface ISharedPreferenceProvider
{
  public abstract SharedPreferences a(Context paramContext, String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.ISharedPreferenceProvider
 * JD-Core Version:    0.7.0.1
 */