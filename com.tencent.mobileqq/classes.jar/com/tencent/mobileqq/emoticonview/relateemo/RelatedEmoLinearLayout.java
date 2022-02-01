package com.tencent.mobileqq.emoticonview.relateemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

public class RelatedEmoLinearLayout
  extends LinearLayout
{
  private boolean mHasPerformedLongPress;
  private RelatedEmoLinearLayout.CheckForLongPress mPendingCheckForLongPress;
  private View mPointView;
  
  public RelatedEmoLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RelatedEmoLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RelatedEmoLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  View findPointChild(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localView.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localView.getTop();
      if ((f1 >= 0.0F) && (f1 <= localView.getWidth()) && (f2 >= 0.0F) && (f2 < localView.getHeight()) && (localView.getVisibility() == 0)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((!this.mHasPerformedLongPress) && (this.mPendingCheckForLongPress != null)) {
        removeCallbacks(this.mPendingCheckForLongPress);
      }
      if (this.mPointView != null) {
        this.mPointView.setAlpha(1.0F);
      }
      if ((this.mPointView != null) && (!this.mHasPerformedLongPress)) {
        this.mPointView.performClick();
      }
      this.mPointView = null;
      continue;
      this.mHasPerformedLongPress = false;
      this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.mPointView != null)
      {
        this.mPointView.setAlpha(0.2F);
        if (this.mPendingCheckForLongPress == null) {
          this.mPendingCheckForLongPress = new RelatedEmoLinearLayout.CheckForLongPress(this, paramMotionEvent);
        }
        this.mPendingCheckForLongPress.rememberWindowAttachCount();
        postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
        continue;
        super.setPressed(false);
        if (this.mPendingCheckForLongPress != null) {
          removeCallbacks(this.mPendingCheckForLongPress);
        }
        if (this.mPointView != null) {
          this.mPointView.setAlpha(1.0F);
        }
        this.mPointView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoLinearLayout
 * JD-Core Version:    0.7.0.1
 */