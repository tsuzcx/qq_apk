package com.tencent.mobileqq.guild.widget;

import android.os.Build.VERSION;

public final class ViewHelper
{
  public static final boolean a;
  
  static
  {
    boolean bool;
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 11) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.ViewHelper
 * JD-Core Version:    0.7.0.1
 */