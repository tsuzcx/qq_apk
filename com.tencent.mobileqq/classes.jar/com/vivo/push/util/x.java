package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class x
  implements d
{
  private static String a = "SpCache";
  private static String b = "com.vivo.push.cache";
  private SharedPreferences c;
  
  public final String a(String paramString1, String paramString2)
  {
    paramString2 = this.c.getString(paramString1, paramString2);
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder("getString ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" is ");
    localStringBuilder.append(paramString2);
    o.d(str, localStringBuilder.toString());
    return paramString2;
  }
  
  public final void a()
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    if (localEditor != null)
    {
      localEditor.clear();
      b.a(localEditor);
    }
    o.d(a, "system cache is cleared");
  }
  
  public final boolean a(Context paramContext)
  {
    if (this.c == null) {
      this.c = paramContext.getSharedPreferences(b, 0);
    }
    return true;
  }
  
  public final void b(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    if (localEditor != null)
    {
      localEditor.putString(paramString1, paramString2);
      b.a(localEditor);
      o.d(a, "putString by ".concat(String.valueOf(paramString1)));
      return;
    }
    o.b(a, "putString error by ".concat(String.valueOf(paramString1)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.x
 * JD-Core Version:    0.7.0.1
 */