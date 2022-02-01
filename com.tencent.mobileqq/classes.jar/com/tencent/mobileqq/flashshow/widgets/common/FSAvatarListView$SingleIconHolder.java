package com.tencent.mobileqq.flashshow.widgets.common;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.flashshow.view.RoundCornerImageView;

class FSAvatarListView$SingleIconHolder
{
  private FrameLayout a;
  private RoundCornerImageView b;
  private RoundCornerImageView c;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private int i;
  private boolean j;
  private int k;
  private int l;
  
  private void b(Context paramContext)
  {
    this.b = new RoundCornerImageView(paramContext);
    int m = this.d;
    int n = this.g;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(m + n * 2, this.e + n * 2, 17);
    this.b.setLayoutParams(localLayoutParams);
    if (this.h) {
      this.b.setBackgroundColor(paramContext.getResources().getColor(this.i));
    }
    this.a.addView(this.b);
  }
  
  private void c(Context paramContext)
  {
    this.c = new RoundCornerImageView(paramContext);
    Object localObject = new FrameLayout.LayoutParams(this.d, this.e, 17);
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.c;
    int m = this.f;
    ((RoundCornerImageView)localObject).setCorner(m, m, m, m);
    this.c.setBackgroundColor(paramContext.getResources().getColor(2131166084));
    boolean bool = this.j;
    if (bool)
    {
      this.c.setBorder(bool);
      this.c.setBorderWidth(this.l);
      this.c.setColor(this.k);
    }
    this.a.addView(this.c);
  }
  
  public FrameLayout a()
  {
    return this.a;
  }
  
  public SingleIconHolder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public SingleIconHolder a(Context paramContext)
  {
    this.a = new FrameLayout(paramContext);
    int m = this.d;
    int n = this.g;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(m + n * 2, this.e + n * 2);
    this.a.setLayoutParams(localLayoutParams);
    b(paramContext);
    c(paramContext);
    this.a.setVisibility(8);
    return this;
  }
  
  public SingleIconHolder a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public SingleIconHolder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public SingleIconHolder b(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public SingleIconHolder c(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public SingleIconHolder d(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public SingleIconHolder e(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public SingleIconHolder f(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public SingleIconHolder g(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.common.FSAvatarListView.SingleIconHolder
 * JD-Core Version:    0.7.0.1
 */