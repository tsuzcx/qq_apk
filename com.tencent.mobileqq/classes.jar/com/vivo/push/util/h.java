package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

public final class h
  implements BaseNotifyDataAdapter
{
  private static int e;
  private static int f;
  private Resources a;
  private String b;
  private String c;
  private String d;
  
  private int a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return -1;
      }
      String[] arrayOfString = paramString1.split("\\.");
      String str = paramString1;
      if (arrayOfString != null)
      {
        str = paramString1;
        if (arrayOfString.length > 0) {
          str = arrayOfString[0];
        }
      }
      try
      {
        int i = Integer.parseInt(str);
        while (i > 0)
        {
          paramString1 = new StringBuilder("vivo_push_ard");
          paramString1.append(i);
          paramString1.append(paramString2);
          paramString1 = paramString1.toString();
          o.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(paramString1)));
          int j = this.a.getIdentifier(paramString1, "drawable", this.b);
          if (j > 0)
          {
            o.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(paramString1)));
            return j;
          }
          i -= 1;
        }
        return -1;
      }
      catch (Exception paramString1)
      {
        o.a("DefaultNotifyDataAdapter", paramString1);
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt != -1) && (paramInt != 0);
  }
  
  private static boolean a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return false;
    }
    if (TextUtils.isEmpty(paramString))
    {
      o.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
      return false;
    }
    return true;
  }
  
  public final int getDefaultNotifyIcon()
  {
    if (a(e)) {
      return e;
    }
    String str = this.d;
    int i;
    if (!a(str)) {
      i = -1;
    } else {
      i = a(str, "_notifyicon");
    }
    e = i;
    if (a(i)) {
      return e;
    }
    for (str = this.c;; str = str.substring(0, str.length() - 1))
    {
      if (TextUtils.isEmpty(str)) {
        return this.a.getIdentifier("vivo_push_notifyicon", "drawable", this.b);
      }
      Resources localResources = this.a;
      StringBuilder localStringBuilder = new StringBuilder("vivo_push_rom");
      localStringBuilder.append(str);
      localStringBuilder.append("_notifyicon");
      i = localResources.getIdentifier(localStringBuilder.toString(), "drawable", this.b);
      if (i > 0) {
        return i;
      }
    }
  }
  
  public final int getDefaultSmallIconId()
  {
    if (a(f)) {
      return f;
    }
    String str = this.d;
    int i;
    if (!a(str)) {
      i = -1;
    } else {
      i = a(str, "_icon");
    }
    f = i;
    if (a(i)) {
      return f;
    }
    for (str = this.c;; str = str.substring(0, str.length() - 1))
    {
      if (TextUtils.isEmpty(str)) {
        return this.a.getIdentifier("vivo_push_icon", "drawable", this.b);
      }
      Resources localResources = this.a;
      StringBuilder localStringBuilder = new StringBuilder("vivo_push_rom");
      localStringBuilder.append(str);
      localStringBuilder.append("_icon");
      i = localResources.getIdentifier(localStringBuilder.toString(), "drawable", this.b);
      if (i > 0) {
        return i;
      }
    }
  }
  
  public final int getNotifyMode(InsideNotificationItem paramInsideNotificationItem)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return 2;
    }
    return 1;
  }
  
  public final void init(Context paramContext)
  {
    this.b = paramContext.getPackageName();
    this.a = paramContext.getResources();
    this.c = j.a();
    this.d = Build.VERSION.RELEASE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.h
 * JD-Core Version:    0.7.0.1
 */