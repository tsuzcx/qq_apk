package com.tencent.mobileqq.widget.share;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ShareActionSheetV2$AdViewManager
{
  private ViewGroup a;
  private View b;
  
  private void a()
  {
    if (this.a != null)
    {
      View localView = this.b;
      if (localView != null)
      {
        if (localView.getParent() != null) {
          ((ViewGroup)this.b.getParent()).removeView(this.b);
        }
        this.a.addView(this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.AdViewManager
 * JD-Core Version:    0.7.0.1
 */