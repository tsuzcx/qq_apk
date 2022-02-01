package com.tencent.mobileqq.gamecenter.ui;

import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;

public class BubblePopupWindow
  extends PopupWindow
{
  public static float a;
  private FrameLayout b;
  private View c;
  private BubblePopupWindow.SharpView d;
  private FrameLayout.LayoutParams e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  private void a()
  {
    this.b.removeAllViews();
    this.e.gravity = this.i;
    BubblePopupWindow.SharpView.a(this.d).setColor(this.f);
    this.b.addView(this.d, this.e);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    int j = this.h;
    localLayoutParams.gravity = j;
    if (j != 3)
    {
      if (j != 5)
      {
        if (j != 48)
        {
          if (j == 80)
          {
            localLayoutParams.topMargin = BubblePopupWindow.SharpView.b(this.d);
            this.d.setRotation(0.0F);
          }
        }
        else
        {
          localLayoutParams.bottomMargin = BubblePopupWindow.SharpView.b(this.d);
          this.d.setRotation(180.0F);
        }
      }
      else
      {
        localLayoutParams.leftMargin = BubblePopupWindow.SharpView.b(this.d);
        this.d.setRotation(270.0F);
      }
    }
    else
    {
      localLayoutParams.rightMargin = BubblePopupWindow.SharpView.b(this.d);
      this.d.setRotation(90.0F);
    }
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.f);
    localGradientDrawable.setCornerRadius(this.g);
    this.c.setBackgroundDrawable(localGradientDrawable);
    this.b.addView(this.c, localLayoutParams);
    super.setContentView(this.b);
  }
  
  public void setContentView(View paramView)
  {
    this.c = paramView;
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = paramInt3;
    if (this.c != null) {
      a();
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = paramInt1;
    if (this.c != null) {
      a();
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.ui.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */