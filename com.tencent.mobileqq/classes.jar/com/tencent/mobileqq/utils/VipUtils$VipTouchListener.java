package com.tencent.mobileqq.utils;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class VipUtils$VipTouchListener
  implements View.OnTouchListener
{
  private QQAppInterface a;
  private boolean b;
  private ImageView c;
  private String d;
  private int e;
  private boolean f;
  
  public VipUtils$VipTouchListener(QQAppInterface paramQQAppInterface, boolean paramBoolean1, ImageView paramImageView, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a = paramQQAppInterface;
    this.b = paramBoolean1;
    this.c = paramImageView;
    this.d = paramString;
    this.e = paramInt;
    this.f = paramBoolean2;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.b) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.c.setImageAlpha(255);
          return true;
        }
        this.c.setAlpha(255);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 16) {
        this.c.setImageAlpha(255);
      } else {
        this.c.setAlpha(255);
      }
      if (this.f)
      {
        VipUtils.b(paramView, this.e, this.d);
        ReportController.b(this.a, "dc00898", "", "", "0X8009F0D", "0X8009F0D", 0, 0, "", "", "", "");
        return true;
      }
      VipUtils.a(paramView, this.e, this.d);
      return true;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.c.setImageAlpha(127);
      return true;
    }
    this.c.setAlpha(127);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.VipTouchListener
 * JD-Core Version:    0.7.0.1
 */