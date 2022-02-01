package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

public final class i
  implements BaseNotifyLayoutAdapter
{
  private Resources a;
  private String b;
  
  public final int getNotificationLayout()
  {
    return this.a.getIdentifier("push_notify", "layout", this.b);
  }
  
  public final int getSuitIconId()
  {
    Resources localResources;
    String str1;
    String str2;
    if (j.g)
    {
      localResources = this.a;
      str1 = this.b;
      str2 = "notify_icon_rom30";
    }
    for (;;)
    {
      return localResources.getIdentifier(str2, "id", str1);
      if (j.f)
      {
        localResources = this.a;
        str1 = this.b;
        str2 = "notify_icon_rom20";
      }
      else
      {
        localResources = this.a;
        str1 = this.b;
        str2 = "notify_icon";
      }
    }
  }
  
  public final int getTitleColor()
  {
    int i;
    try
    {
      i = ((Integer)z.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    if (i > 0) {
      return this.a.getColor(i);
    }
    if (j.g) {
      return -1;
    }
    if (j.f)
    {
      if (j.g) {
        return Color.parseColor("#ff999999");
      }
      return -1;
    }
    return -16777216;
  }
  
  public final void init(Context paramContext)
  {
    this.b = paramContext.getPackageName();
    this.a = paramContext.getResources();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.i
 * JD-Core Version:    0.7.0.1
 */