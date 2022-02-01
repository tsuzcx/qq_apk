package com.tencent.widget.immersive;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class SoftInputResizeLayout
{
  private FrameLayout.LayoutParams frameLayoutParams;
  Activity mAactivity;
  private View mChildOfContent;
  private int usableHeightPrevious;
  
  private SoftInputResizeLayout(Activity paramActivity)
  {
    this.mChildOfContent = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.mAactivity = paramActivity;
    this.mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new SoftInputResizeLayout.1(this));
    this.frameLayoutParams = ((FrameLayout.LayoutParams)this.mChildOfContent.getLayoutParams());
  }
  
  public static void assistActivity(Activity paramActivity)
  {
    new SoftInputResizeLayout(paramActivity);
  }
  
  private int computeUsableHeight()
  {
    Rect localRect = new Rect();
    this.mChildOfContent.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  private void possiblyResizeChildOfContent()
  {
    int i = computeUsableHeight();
    if (i != this.usableHeightPrevious)
    {
      int j = this.mChildOfContent.getRootView().getHeight();
      int k = j - i;
      if (k > j / 4) {
        this.frameLayoutParams.height = (j - k + ImmersiveUtils.getStatusBarHeight(this.mAactivity));
      } else {
        this.frameLayoutParams.height = j;
      }
      this.mChildOfContent.requestLayout();
      this.usableHeightPrevious = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.immersive.SoftInputResizeLayout
 * JD-Core Version:    0.7.0.1
 */