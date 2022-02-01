package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ShareActionSheetBuilder$AdViewManager
{
  private ViewGroup a;
  private View b;
  
  private void a()
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null)
    {
      View localView = this.b;
      if (localView != null) {
        localViewGroup.addView(localView);
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getParent();
      if ((paramView != null) && ((paramView instanceof ViewGroup))) {
        a((ViewGroup)paramView);
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      paramViewGroup.removeAllViews();
    }
  }
  
  void a(int paramInt)
  {
    ViewGroup localViewGroup = this.a;
    if (localViewGroup != null) {
      localViewGroup.setBackgroundColor(paramInt);
    }
  }
  
  void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    a(this.b);
    a(paramView);
    if (paramView != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    this.b = paramView;
    a();
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    a(this.a);
    a(paramRelativeLayout);
    this.a = paramRelativeLayout;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.AdViewManager
 * JD-Core Version:    0.7.0.1
 */