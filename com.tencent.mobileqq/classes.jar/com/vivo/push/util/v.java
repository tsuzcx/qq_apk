package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings.System;

final class v
  implements d
{
  private ContentResolver a;
  
  public final String a(String paramString1, String paramString2)
  {
    try
    {
      String str = Settings.System.getString(this.a, paramString1);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      o.b("SettingsCache", "getString error by ".concat(String.valueOf(paramString1)));
    }
    return paramString2;
  }
  
  public final boolean a(Context paramContext)
  {
    if (j.b())
    {
      this.a = paramContext.getContentResolver();
      return true;
    }
    return false;
  }
  
  public final void b(String paramString1, String paramString2)
  {
    try
    {
      Settings.System.putString(this.a, paramString1, paramString2);
      return;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      o.b("SettingsCache", "putString error by ".concat(String.valueOf(paramString1)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.v
 * JD-Core Version:    0.7.0.1
 */