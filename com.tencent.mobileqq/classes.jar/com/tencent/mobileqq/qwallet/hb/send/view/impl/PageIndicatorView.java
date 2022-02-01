package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class PageIndicatorView
  extends LinearLayout
{
  private Context a = null;
  private int b = 8;
  private int c = 4;
  private List<View> d = null;
  
  public PageIndicatorView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PageIndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PageIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(float paramFloat)
  {
    return (int)(paramFloat * this.a.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    setGravity(17);
    setOrientation(0);
    this.b = a(this.b);
    this.c = a(this.c);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      this.d = new ArrayList();
    }
    else
    {
      ((List)localObject).clear();
      removeAllViews();
    }
    int i = this.b;
    localObject = new LinearLayout.LayoutParams(i, i);
    i = this.c;
    ((LinearLayout.LayoutParams)localObject).setMargins(i, i, i, i);
    i = 0;
    while (i < paramInt)
    {
      View localView = new View(this.a);
      localView.setBackgroundResource(2130849144);
      addView(localView, (ViewGroup.LayoutParams)localObject);
      this.d.add(localView);
      i += 1;
    }
    if (this.d.size() > 0) {
      ((View)this.d.get(0)).setBackgroundResource(2130849145);
    }
  }
  
  public void setSelectedPage(int paramInt)
  {
    if (this.d == null) {
      return;
    }
    int i = 0;
    while (i < this.d.size())
    {
      if (i == paramInt) {
        ((View)this.d.get(i)).setBackgroundResource(2130849145);
      } else {
        ((View)this.d.get(i)).setBackgroundResource(2130849144);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.PageIndicatorView
 * JD-Core Version:    0.7.0.1
 */