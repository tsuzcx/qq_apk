package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class FeedBannerItemGradientLinearLayout
  extends LinearLayout
{
  private View a;
  private View b;
  
  public FeedBannerItemGradientLinearLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FeedBannerItemGradientLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public FeedBannerItemGradientLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new View(getContext());
    this.b = new View(getContext());
    setOrientation(1);
    addView(this.a, new LinearLayout.LayoutParams(-1, -2));
    addView(this.b, new LinearLayout.LayoutParams(-1, -1));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.getLayoutParams().height = paramInt1;
    this.a.setBackgroundColor(paramInt2);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setGradientType(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localGradientDrawable.setColors(new int[] { paramInt2, paramInt3 });
    } else {
      localGradientDrawable.setColor(paramInt2);
    }
    this.b.setBackgroundDrawable(localGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.FeedBannerItemGradientLinearLayout
 * JD-Core Version:    0.7.0.1
 */