package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

@SuppressLint({"ResourceAsColor"})
public class CustomedTabWidget
  extends LinearLayout
{
  CustomedTabWidget.MyHandler a;
  Rect b = new Rect();
  Rect c = new Rect();
  float d;
  int e;
  boolean f = false;
  private ImageView g;
  private Drawable h;
  private Drawable i;
  private Drawable j;
  private Paint k = new Paint();
  private float l;
  private CustomedTabWidget.OnSwitchTabListener m;
  private int n = 0;
  
  public CustomedTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = ((ImageView)inflate(paramContext, 2131629293, null));
    this.h = this.g.getBackground();
    this.i = paramContext.getResources().getDrawable(2130852533);
    this.j = paramContext.getResources().getDrawable(2130852532);
    this.l = paramContext.getResources().getDisplayMetrics().density;
    this.a = new CustomedTabWidget.MyHandler(this);
  }
  
  private void a(View paramView)
  {
    paramView.setOnClickListener(new CustomedTabWidget.1(this));
    paramView.setOnTouchListener(new CustomedTabWidget.2(this));
    if (getChildCount() == 1) {
      paramView.setSelected(true);
    }
  }
  
  private void setFocusTab(int paramInt)
  {
    if (paramInt == this.n) {
      return;
    }
    CustomedTabWidget.OnSwitchTabListener localOnSwitchTabListener = this.m;
    if (localOnSwitchTabListener != null) {
      localOnSwitchTabListener.a(paramInt);
    }
    getChildAt(this.n).setSelected(false);
    this.n = paramInt;
    getChildAt(this.n).setSelected(true);
    getChildAt(this.n).getHitRect(this.b);
    if ((this.b.left != this.c.left) || (this.b.right != this.c.right))
    {
      this.d = ((this.b.left - this.c.left) / 4);
      this.a.sendEmptyMessage(0);
    }
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    super.addView(paramView, paramInt);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    super.addView(paramView, paramInt1, paramInt2);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    a(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramLayoutParams);
    a(paramView);
  }
  
  public int getCurrentTab()
  {
    return this.n;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.j.setBounds(0, getHeight() - 6, getWidth(), getHeight());
    this.j.draw(paramCanvas);
    int i1 = getWidth() / getChildCount();
    int i2 = this.c.centerX() - i1 / 2;
    this.i.setBounds(i2, this.c.bottom - (int)(this.l * 4.0F), i1 + i2, this.c.bottom);
    this.i.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getChildAt(this.n).getHitRect(this.b);
    this.c.set(this.b.left, this.b.top, this.b.right, this.b.bottom);
    setCurrentTab(this.n);
  }
  
  public void setCurrentTab(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount())) {
      setFocusTab(paramInt);
    }
  }
  
  public void setOnSwitchTabListener(CustomedTabWidget.OnSwitchTabListener paramOnSwitchTabListener)
  {
    this.a.removeMessages(0);
    this.m = paramOnSwitchTabListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomedTabWidget
 * JD-Core Version:    0.7.0.1
 */