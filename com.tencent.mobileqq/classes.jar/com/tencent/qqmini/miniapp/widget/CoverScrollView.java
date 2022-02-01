package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;

public class CoverScrollView
  extends CoverView
{
  private FrameLayout container;
  private ScrollView scrollView;
  
  public CoverScrollView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.scrollView = new ScrollView(paramContext);
    this.container = new FrameLayout(paramContext);
    this.scrollView.addView(this.container);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.scrollView, paramContext);
  }
  
  public void addView(View paramView)
  {
    this.container.addView(paramView);
  }
  
  public void removeView(View paramView)
  {
    this.container.removeView(paramView);
  }
  
  public void setBorder(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt3);
    localGradientDrawable.setCornerRadius(paramFloat * DisplayUtil.getDensity(getContext()));
    if (paramInt1 > 0) {
      localGradientDrawable.setStroke(paramInt1, paramInt2);
    }
    this.scrollView.setBackgroundDrawable(localGradientDrawable);
  }
  
  public void setContainerSize(int paramInt1, int paramInt2)
  {
    if (this.container != null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      this.container.setLayoutParams(localLayoutParams);
    }
  }
  
  public void setScrollTop(int paramInt)
  {
    this.scrollView.setScrollY(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CoverScrollView
 * JD-Core Version:    0.7.0.1
 */