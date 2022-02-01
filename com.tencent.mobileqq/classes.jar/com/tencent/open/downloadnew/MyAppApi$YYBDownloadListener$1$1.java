package com.tencent.open.downloadnew;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;

class MyAppApi$YYBDownloadListener$1$1
  implements Runnable
{
  MyAppApi$YYBDownloadListener$1$1(MyAppApi.YYBDownloadListener.1 param1) {}
  
  public void run()
  {
    if (CommonDataAdapter.a().a() != null)
    {
      Object localObject1 = new DisplayMetrics();
      ((WindowManager)CommonDataAdapter.a().a().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      int i = ((DisplayMetrics)localObject1).widthPixels;
      float f = ((DisplayMetrics)localObject1).density;
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      localObject1 = new RelativeLayout(CommonDataAdapter.a().a());
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).setBackgroundColor(-855638017);
      ((RelativeLayout)localObject1).setGravity(17);
      int j = (int)(10.0F * f + 0.5F);
      ((RelativeLayout)localObject1).setPadding(j, j, j, j);
      localObject2 = new TextView(CommonDataAdapter.a().a());
      double d = i;
      Double.isNaN(d);
      ((TextView)localObject2).setWidth((int)(d * 0.9D));
      ((TextView)localObject2).setHeight((int)(f * 96.0F + 0.5F));
      ((TextView)localObject2).setBackgroundColor(CommonDataAdapter.a().a().getResources().getColor(2131167333));
      ((TextView)localObject2).setText(2131719714);
      ((TextView)localObject2).setTextColor(CommonDataAdapter.a().a().getResources().getColor(2131165327));
      ((TextView)localObject2).setSingleLine();
      ((TextView)localObject2).setGravity(17);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      ToastUtil.a().a((View)localObject1, 1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707083));
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      LogUtility.c("MyAppApi", ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1.1
 * JD-Core Version:    0.7.0.1
 */