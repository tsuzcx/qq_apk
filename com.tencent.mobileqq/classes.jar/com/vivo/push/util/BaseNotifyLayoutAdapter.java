package com.vivo.push.util;

import android.content.Context;

public abstract interface BaseNotifyLayoutAdapter
{
  public abstract int getNotificationLayout();
  
  public abstract int getSuitIconId();
  
  public abstract int getTitleColor();
  
  public abstract void init(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.BaseNotifyLayoutAdapter
 * JD-Core Version:    0.7.0.1
 */