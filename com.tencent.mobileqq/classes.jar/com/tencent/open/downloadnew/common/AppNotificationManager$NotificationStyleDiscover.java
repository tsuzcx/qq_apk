package com.tencent.open.downloadnew.common;

import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RemoteViews;
import android.widget.TextView;

public class AppNotificationManager$NotificationStyleDiscover
{
  protected Integer a = null;
  protected float b = 14.0F;
  protected Integer c = null;
  protected float d = 16.0F;
  protected final String e = "SearchForText";
  protected final String f = "SearchForTitle";
  protected DisplayMetrics g = new DisplayMetrics();
  
  AppNotificationManager$NotificationStyleDiscover(AppNotificationManager paramAppNotificationManager, Context paramContext)
  {
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.g);
    a(paramContext);
  }
  
  public Integer a()
  {
    return this.a;
  }
  
  protected void a(Context paramContext)
  {
    if ((this.a != null) && (this.c != null)) {
      return;
    }
    try
    {
      Notification localNotification = new Notification();
      localNotification.setLatestEventInfo(paramContext, "SearchForTitle", "SearchForText", null);
      paramContext = (ViewGroup)localNotification.contentView.apply(paramContext, null);
      a(paramContext);
      b(paramContext);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  protected boolean a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForTitle".equals(localTextView.getText().toString()))
        {
          this.c = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.d = localTextView.getTextSize();
          this.d /= this.g.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (a((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public float b()
  {
    return this.b;
  }
  
  protected boolean b(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForText".equals(localTextView.getText().toString()))
        {
          this.a = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.b = localTextView.getTextSize();
          this.b /= this.g.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (b((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public Integer c()
  {
    return this.c;
  }
  
  public float d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.AppNotificationManager.NotificationStyleDiscover
 * JD-Core Version:    0.7.0.1
 */