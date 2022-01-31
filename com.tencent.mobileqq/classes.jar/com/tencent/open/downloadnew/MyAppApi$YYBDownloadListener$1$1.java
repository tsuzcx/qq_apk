package com.tencent.open.downloadnew;

import ajyc;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bcxm;
import bdht;
import bdid;

class MyAppApi$YYBDownloadListener$1$1
  implements Runnable
{
  MyAppApi$YYBDownloadListener$1$1(MyAppApi.YYBDownloadListener.1 param1) {}
  
  public void run()
  {
    if (bcxm.a().a() != null)
    {
      Object localObject1 = new DisplayMetrics();
      ((WindowManager)bcxm.a().a().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      int i = ((DisplayMetrics)localObject1).widthPixels;
      float f = ((DisplayMetrics)localObject1).density;
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      localObject1 = new RelativeLayout(bcxm.a().a());
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).setBackgroundColor(-855638017);
      ((RelativeLayout)localObject1).setGravity(17);
      ((RelativeLayout)localObject1).setPadding((int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F));
      localObject2 = new TextView(bcxm.a().a());
      ((TextView)localObject2).setWidth((int)(i * 0.9D));
      ((TextView)localObject2).setHeight((int)(96.0F * f + 0.5F));
      ((TextView)localObject2).setBackgroundColor(bcxm.a().a().getResources().getColor(2131167087));
      ((TextView)localObject2).setText(2131720333);
      ((TextView)localObject2).setTextColor(bcxm.a().a().getResources().getColor(2131165275));
      ((TextView)localObject2).setSingleLine();
      ((TextView)localObject2).setGravity(17);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      bdid.a().a((View)localObject1, 1);
      bdht.c("MyAppApi", ajyc.a(2131707045) + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1.1
 * JD-Core Version:    0.7.0.1
 */