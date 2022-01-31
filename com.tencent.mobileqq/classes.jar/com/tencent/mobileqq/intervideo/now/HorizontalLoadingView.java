package com.tencent.mobileqq.intervideo.now;

import adkr;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class HorizontalLoadingView
  extends FrameLayout
{
  private ValueAnimator a;
  
  public HorizontalLoadingView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public HorizontalLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public HorizontalLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    getViewTreeObserver().addOnGlobalLayoutListener(new adkr(this));
  }
  
  @TargetApi(11)
  protected void onDetachedFromWindow()
  {
    if (this.a != null) {
      this.a.cancel();
    }
    super.onDetachedFromWindow();
  }
  
  @TargetApi(11)
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramView != this) || (this.a == null)) {
      return;
    }
    if (paramInt == 0)
    {
      this.a.start();
      return;
    }
    this.a.cancel();
  }
  
  @TargetApi(11)
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (this.a == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.a.start();
      return;
    }
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.HorizontalLoadingView
 * JD-Core Version:    0.7.0.1
 */