package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;

public class BubblePopupWindow
  extends PopupWindow
{
  public static float a;
  private Context b;
  private FrameLayout c;
  private View d;
  private BubblePopupWindow.SharpView e;
  private FrameLayout.LayoutParams f;
  private int g;
  private int h;
  private int i = 80;
  private int j = 49;
  
  public BubblePopupWindow(Context paramContext)
  {
    super(-2, -2);
    this.b = paramContext;
    d();
  }
  
  private void d()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.b);
    BubblePopupWindow.SharpView localSharpView = new BubblePopupWindow.SharpView(this, this.b);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    this.e = localSharpView;
    this.c = localFrameLayout;
    this.f = localLayoutParams;
    setBackgroundDrawable(new ColorDrawable(0));
    setTouchable(true);
    setFocusable(false);
    setSoftInputMode(1);
    setInputMethodMode(2);
    a(24, 12);
    a(12);
    c(6);
    b(-1);
  }
  
  private void e()
  {
    this.c.removeAllViews();
    this.f.gravity = this.j;
    BubblePopupWindow.SharpView.a(this.e).setColor(this.g);
    this.c.addView(this.e, this.f);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    int k = this.i;
    localLayoutParams.gravity = k;
    if (k != 3)
    {
      if (k != 5)
      {
        if (k != 48)
        {
          if (k == 80)
          {
            localLayoutParams.topMargin = BubblePopupWindow.SharpView.b(this.e);
            this.e.setRotation(0.0F);
          }
        }
        else
        {
          localLayoutParams.bottomMargin = BubblePopupWindow.SharpView.b(this.e);
          this.e.setRotation(180.0F);
        }
      }
      else
      {
        localLayoutParams.leftMargin = BubblePopupWindow.SharpView.b(this.e);
        this.e.setRotation(270.0F);
      }
    }
    else
    {
      localLayoutParams.rightMargin = BubblePopupWindow.SharpView.b(this.e);
      this.e.setRotation(90.0F);
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.g);
    localGradientDrawable.setCornerRadius(this.h);
    this.d.setBackgroundDrawable(localGradientDrawable);
    this.c.addView(this.d, localLayoutParams);
    super.setContentView(this.c);
  }
  
  public int a()
  {
    View localView = this.d;
    if (localView == null) {
      return 0;
    }
    localView.measure(0, 0);
    return this.d.getMeasuredHeight();
  }
  
  public void a(int paramInt)
  {
    BubblePopupWindow.SharpView.c(this.e, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    BubblePopupWindow.SharpView.a(this.e, paramInt1);
    BubblePopupWindow.SharpView.b(this.e, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = this.f;
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = paramInt2;
    localLayoutParams.topMargin = paramInt3;
    localLayoutParams.bottomMargin = paramInt4;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!isShowing())
    {
      int k = 49;
      if (paramInt1 != 3)
      {
        if (paramInt1 != 5)
        {
          if (paramInt1 == 48) {
            k = 81;
          }
        }
        else {
          k = 19;
        }
      }
      else {
        k = 21;
      }
      this.i = paramInt1;
      d(k);
      showAtLocation(paramView, 0, paramInt2, paramInt3);
      return;
    }
    dismiss();
  }
  
  public int b()
  {
    View localView = this.d;
    if (localView == null) {
      return 0;
    }
    localView.measure(0, 0);
    return this.d.getMeasuredWidth();
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public int c()
  {
    return BubblePopupWindow.SharpView.b(this.e);
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setContentView(View paramView)
  {
    this.d = paramView;
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.i = paramInt3;
    if (this.d != null) {
      e();
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.i = paramInt1;
    if (this.d != null) {
      e();
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */