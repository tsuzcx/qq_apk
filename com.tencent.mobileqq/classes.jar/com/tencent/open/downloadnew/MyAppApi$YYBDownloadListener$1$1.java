package com.tencent.open.downloadnew;

import alud;
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
import bfbm;
import bflp;
import bflz;

class MyAppApi$YYBDownloadListener$1$1
  implements Runnable
{
  MyAppApi$YYBDownloadListener$1$1(MyAppApi.YYBDownloadListener.1 param1) {}
  
  public void run()
  {
    if (bfbm.a().a() != null)
    {
      Object localObject1 = new DisplayMetrics();
      ((WindowManager)bfbm.a().a().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      int i = ((DisplayMetrics)localObject1).widthPixels;
      float f = ((DisplayMetrics)localObject1).density;
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      localObject1 = new RelativeLayout(bfbm.a().a());
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).setBackgroundColor(-855638017);
      ((RelativeLayout)localObject1).setGravity(17);
      ((RelativeLayout)localObject1).setPadding((int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F));
      localObject2 = new TextView(bfbm.a().a());
      ((TextView)localObject2).setWidth((int)(i * 0.9D));
      ((TextView)localObject2).setHeight((int)(96.0F * f + 0.5F));
      ((TextView)localObject2).setBackgroundColor(bfbm.a().a().getResources().getColor(2131167140));
      ((TextView)localObject2).setText(2131720892);
      ((TextView)localObject2).setTextColor(bfbm.a().a().getResources().getColor(2131165307));
      ((TextView)localObject2).setSingleLine();
      ((TextView)localObject2).setGravity(17);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      bflz.a().a((View)localObject1, 1);
      bflp.c("MyAppApi", alud.a(2131707440) + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1.1
 * JD-Core Version:    0.7.0.1
 */