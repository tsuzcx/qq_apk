package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ShareActionSheetBuilder$AdViewManager
{
  private ViewGroup mAdContainer;
  private View mAdView;
  
  private void bind()
  {
    if ((this.mAdContainer != null) && (this.mAdView != null)) {
      this.mAdContainer.addView(this.mAdView);
    }
  }
  
  private void clearParentOf(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getParent();
      if ((paramView != null) && ((paramView instanceof ViewGroup))) {
        removeAllViews((ViewGroup)paramView);
      }
    }
  }
  
  private void removeAllViews(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      paramViewGroup.removeAllViews();
    }
  }
  
  public void setAdContainer(RelativeLayout paramRelativeLayout)
  {
    removeAllViews(this.mAdContainer);
    removeAllViews(paramRelativeLayout);
    this.mAdContainer = paramRelativeLayout;
    bind();
  }
  
  void setAdView(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    clearParentOf(this.mAdView);
    clearParentOf(paramView);
    if (paramView != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    this.mAdView = paramView;
    bind();
  }
  
  void setBgColor(int paramInt)
  {
    if (this.mAdContainer != null) {
      this.mAdContainer.setBackgroundColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.AdViewManager
 * JD-Core Version:    0.7.0.1
 */