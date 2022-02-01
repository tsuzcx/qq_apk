package com.tencent.mobileqq.widget.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class AdaptiveKeyboardLayout
  extends FrameLayout
{
  private View a;
  private boolean b;
  private int c;
  private boolean d;
  private int e;
  private int f;
  private AdaptiveKeyboardLayout.KeyboardLayoutListener g;
  private AdaptiveKeyboardLayout.SetChildMarginRunnable h;
  private boolean i;
  private AdaptiveKeyboardLayout.KeyboardChangeListener j;
  private boolean k = true;
  
  public AdaptiveKeyboardLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdaptiveKeyboardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdaptiveKeyboardLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int getMaxCanChangedMargin()
  {
    if ((getChildCount() > 0) && (this.d)) {
      return getHeight() - getChildAt(0).getHeight();
    }
    return getHeight();
  }
  
  private void setChildBottomMargin(int paramInt)
  {
    if (getChildCount() <= 0) {
      return;
    }
    AdaptiveKeyboardLayout.SetChildMarginRunnable localSetChildMarginRunnable = this.h;
    if (localSetChildMarginRunnable != null) {
      removeCallbacks(localSetChildMarginRunnable);
    }
    if (getChildCount() <= 0) {
      return;
    }
    if (this.i)
    {
      this.h = new AdaptiveKeyboardLayout.SetChildMarginRunnable(this, paramInt);
      postDelayed(this.h, 80L);
      return;
    }
    setChildBottomMarginImmediately(paramInt);
  }
  
  private void setChildBottomMarginImmediately(int paramInt)
  {
    if (getChildCount() <= 0) {
      return;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    paramInt += this.c;
    if (localLayoutParams.bottomMargin != paramInt)
    {
      localLayoutParams.bottomMargin = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a()
  {
    setChildBottomMargin(0);
    this.f = 0;
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.a = paramView;
    this.b = paramBoolean;
    if (this.g == null)
    {
      this.g = new AdaptiveKeyboardLayout.KeyboardLayoutListener(this);
      getViewTreeObserver().addOnGlobalLayoutListener(this.g);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLayoutParams;
      localLayoutParams.gravity = 80;
      this.c = localLayoutParams.bottomMargin;
      boolean bool;
      if (localLayoutParams.height != -1) {
        bool = true;
      } else {
        bool = false;
      }
      this.d = bool;
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("AdaptiveKeyboardLayout can host only one direct child");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.g != null)
    {
      getViewTreeObserver().removeOnGlobalLayoutListener(this.g);
      this.g = null;
    }
    removeCallbacks(this.h);
  }
  
  public void setIsSlightMove(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setKeyboardLayoutEnable(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setKeyboardListener(AdaptiveKeyboardLayout.KeyboardChangeListener paramKeyboardChangeListener)
  {
    this.j = paramKeyboardChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.container.AdaptiveKeyboardLayout
 * JD-Core Version:    0.7.0.1
 */