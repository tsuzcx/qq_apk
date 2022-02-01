package com.tencent.mobileqq.webview.swift;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SwiftFloatViewUI$2
  implements View.OnTouchListener
{
  int a;
  int b;
  int c;
  int d;
  int e = 2000;
  int f;
  int g;
  int h;
  boolean i;
  int j;
  
  SwiftFloatViewUI$2(SwiftFloatViewUI paramSwiftFloatViewUI, DisplayMetrics paramDisplayMetrics) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.l.c)
    {
      int m = paramMotionEvent.getAction();
      if (m != 0)
      {
        if (m != 1) {
          if (m != 2)
          {
            if (m != 3) {
              return true;
            }
          }
          else
          {
            if (this.l.d.getVisibility() == 0) {
              return true;
            }
            m = (int)paramMotionEvent.getRawX() - this.a;
            n = (int)paramMotionEvent.getRawY() - this.b;
            this.e = (paramView.getLeft() + m);
            this.f = (paramView.getTop() + n);
            this.g = (paramView.getRight() + m);
            this.h = (paramView.getBottom() + n);
            if (this.e < 0)
            {
              this.e = 0;
              this.g = (this.e + paramView.getWidth());
            }
            else if (this.g > this.l.m)
            {
              this.g = this.l.m;
              this.e = (this.g - paramView.getWidth());
            }
            if (this.f < 0)
            {
              this.f = 0;
              this.h = (this.f + paramView.getHeight());
            }
            else if (this.h > this.l.n)
            {
              this.h = this.l.n;
              this.f = (this.l.n - paramView.getHeight());
            }
            paramView.layout(this.e, this.f, this.g, this.h);
            this.a = ((int)paramMotionEvent.getRawX());
            this.b = ((int)paramMotionEvent.getRawY());
            if ((this.i) || ((Math.abs(paramMotionEvent.getRawX() - this.c) <= this.k.density * 5.0F) && (Math.abs(paramMotionEvent.getRawY() - this.d) <= this.k.density * 5.0F))) {
              break label1059;
            }
            this.l.d.setVisibility(8);
            paramView = this.l;
            paramView.a(paramView.c, true);
            this.l.k.setVisibility(8);
            this.i = true;
            return true;
          }
        }
        paramMotionEvent = this.l;
        paramMotionEvent.a(paramMotionEvent.c, true);
        if (!this.i)
        {
          if (this.l.d.getVisibility() == 0)
          {
            this.l.d.setVisibility(8);
            paramView = this.l;
            paramView.a(paramView.c, true);
            this.l.k.setVisibility(8);
            return true;
          }
          this.l.d.setVisibility(0);
          paramMotionEvent = this.l;
          paramMotionEvent.a(paramMotionEvent.c, false);
          this.l.k.setVisibility(0);
          m = paramView.getTop();
          n = paramView.getWidth() / 2;
          if (this.e + n < this.l.m / 2)
          {
            if (Build.VERSION.SDK_INT >= 11) {
              try
              {
                this.l.c.setRotationY(180.0F);
              }
              catch (Throwable paramView)
              {
                QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", paramView);
              }
            }
            paramView = (FrameLayout.LayoutParams)this.l.d.getLayoutParams();
            paramView.gravity = 3;
            paramView.leftMargin = (this.e + n);
            paramView.topMargin = m;
            this.l.d.setLayoutParams(paramView);
            this.l.d.setPadding((int)(this.k.density * 35.0F), this.l.d.getPaddingTop(), (int)(this.k.density * 20.0F), this.l.d.getPaddingBottom());
          }
          else
          {
            if (Build.VERSION.SDK_INT >= 11) {
              try
              {
                this.l.c.setRotationY(0.0F);
              }
              catch (Throwable paramMotionEvent)
              {
                QLog.e("WebLog_SwiftFloatViewUI", 1, "floatbtn.setrotationy error!", paramMotionEvent);
              }
            }
            paramMotionEvent = (FrameLayout.LayoutParams)this.l.d.getLayoutParams();
            paramMotionEvent.gravity = 5;
            paramMotionEvent.rightMargin = (this.l.m - paramView.getRight() + n);
            paramMotionEvent.topMargin = m;
            this.l.d.setLayoutParams(paramMotionEvent);
            this.l.d.setPadding((int)(this.k.density * 20.0F), this.l.d.getPaddingTop(), (int)(this.k.density * 35.0F), this.l.d.getPaddingBottom());
          }
          paramView = new StringBuilder();
          paramView.append(this.l.b.e);
          paramView.append("");
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_show", 0, 1, 0, paramView.toString(), "", "", "");
          return true;
        }
        this.j = Math.min(this.e, this.l.m - this.g);
        m = this.j;
        int n = this.e;
        if (m == n)
        {
          paramMotionEvent = new TranslateAnimation(0.0F, -n, 0.0F, 0.0F);
          this.e = 0;
          this.g = (this.e + paramView.getWidth());
        }
        else
        {
          paramMotionEvent = new TranslateAnimation(0.0F, m, 0.0F, 0.0F);
          this.g = this.l.m;
          this.e = (this.g - paramView.getWidth());
        }
        paramMotionEvent.setDuration(500L);
        paramView.setVisibility(8);
        paramMotionEvent.setAnimationListener(new SwiftFloatViewUI.2.1(this, paramView));
        paramView.startAnimation(paramMotionEvent);
        return true;
      }
      else
      {
        this.l.e.setVisibility(8);
        m = (int)paramMotionEvent.getRawX();
        this.a = m;
        this.c = m;
        m = (int)paramMotionEvent.getRawY();
        this.b = m;
        this.d = m;
      }
      label1059:
      return true;
    }
    if (paramView == this.l.e)
    {
      this.l.e.setVisibility(8);
      this.l.d.setVisibility(8);
      paramView = this.l;
      paramView.a(paramView.c, true);
      this.l.k.setVisibility(8);
      return true;
    }
    if (paramView == this.l.k)
    {
      this.l.e.setVisibility(8);
      this.l.d.setVisibility(8);
      paramView = this.l;
      paramView.a(paramView.c, true);
      this.l.k.setVisibility(8);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.2
 * JD-Core Version:    0.7.0.1
 */