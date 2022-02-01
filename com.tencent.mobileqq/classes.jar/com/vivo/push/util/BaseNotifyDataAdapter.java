package com.vivo.push.util;

import android.content.Context;
import com.vivo.push.model.InsideNotificationItem;

public abstract interface BaseNotifyDataAdapter
{
  public abstract int getDefaultNotifyIcon();
  
  public abstract int getDefaultSmallIconId();
  
  public abstract int getNotifyMode(InsideNotificationItem paramInsideNotificationItem);
  
  public abstract void init(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.BaseNotifyDataAdapter
 * JD-Core Version:    0.7.0.1
 */