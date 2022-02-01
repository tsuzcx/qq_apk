package com.tencent.mobileqq.uniformdownload.core;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

class UniformDownloadNfn$NotificationStyle
{
  Integer a = null;
  float b = 14.0F;
  Integer c = null;
  float d = 16.0F;
  final String e = "SearchForText";
  final String f = "SearchForTitle";
  DisplayMetrics g = new DisplayMetrics();
  int h = 0;
  
  UniformDownloadNfn$NotificationStyle(UniformDownloadNfn paramUniformDownloadNfn, Context paramContext)
  {
    if (paramContext != null) {
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.g);
    }
  }
  
  public float a()
  {
    return this.b;
  }
  
  public Integer b()
  {
    return this.c;
  }
  
  public float c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadNfn.NotificationStyle
 * JD-Core Version:    0.7.0.1
 */