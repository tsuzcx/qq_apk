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
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
        super.setPressed(false);
        paramMotionEvent = this.mPendingCheckForLongPress;
        if (paramMotionEvent != null) {
          removeCallbacks(paramMotionEvent);
        }
        paramMotionEvent = this.mPointView;
        if (paramMotionEvent != null) {
          paramMotionEvent.setAlpha(1.0F);
        }
        this.mPointView = null;
        return true;
      }
      if (!this.mHasPerformedLongPress)
      {
        paramMotionEvent = this.mPendingCheckForLongPress;
        if (paramMotionEvent != null) {
          removeCallbacks(paramMotionEvent);
        }
      }
      paramMotionEvent = this.mPointView;
      if (paramMotionEvent != null) {
        paramMotionEvent.setAlpha(1.0F);
      }
      paramMotionEvent = this.mPointView;
      if ((paramMotionEvent != null) && (!this.mHasPerformedLongPress)) {
        paramMotionEvent.performClick();
      }
      this.mPointView = null;
      return true;
    }
    this.mHasPerformedLongPress = false;
    this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
    View localView = this.mPointView;
    if (localView != null)
    {
      localView.setAlpha(0.2F);
      if (this.mPendingCheckForLongPress == null) {
        this.mPendingCheckForLongPress = new RelatedEmoLinearLayout.CheckForLongPress(this, paramMotionEvent);
      }
      this.mPendingCheckForLongPress.rememberWindowAttachCount();
      postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoLinearLayout
 * JD-Core Version:    0.7.0.1
 */