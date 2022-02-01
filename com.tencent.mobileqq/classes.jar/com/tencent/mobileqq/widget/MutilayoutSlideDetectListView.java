package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class MutilayoutSlideDetectListView
  extends SlideDetectListView
{
  public MutilayoutSlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View a(View paramView)
  {
    if ((paramView instanceof ShaderAnimLayout)) {
      return paramView;
    }
    if ((paramView instanceof RelativeLayout))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          View localView = a(paramView.getChildAt(i));
          if ((localView instanceof ShaderAnimLayout)) {
            return localView;
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public int a(View paramView)
  {
    paramView = (View)paramView.getParent();
    int i = paramView.getTop();
    while (paramView != this.mMotionView)
    {
      paramView = (View)paramView.getParent();
      i += paramView.getTop();
    }
    return i;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector == null)
    {
      this.mGestureDetector = new GestureDetector(getContext(), this.mGestureListener, new Handler(Looper.getMainLooper()));
      this.mGestureDetector.setIsLongpressEnabled(false);
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    label88:
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.mHasDeleteDown == true)
        {
          return false;
          this.mDownY = ((int)paramMotionEvent.getY());
          this.mHasDeleteDown = false;
          i = findMotionViewPosition(this.mDownY);
          if ((this.mMotionView != null) && (findMotionView(i) == this.mMotionView))
          {
            if (paramMotionEvent.getX() < this.mMotionView.getWidth() - this.mDeleteAreaWidth) {
              continue;
            }
            if ((this.mDeleteAreaHeight <= 0) || (this.mMotionView.getHeight() <= 0)) {
              break label372;
            }
            View localView1 = a(this.mMotionView);
            if (localView1 != null)
            {
              View localView2 = (View)localView1.getParent();
              i = a(localView1);
              i = localView2.getHeight() / 2 + i;
              int j = this.mDeleteAreaHeight / 2;
              int k = this.mDeleteAreaHeight / 2;
              if ((this.mDownY <= j + i) && (this.mDownY >= i - k)) {
                break label372;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SlideDetectListView", 2, "accurate in delete:ycenter:" + i + ",motionheight:" + this.mMotionView.getHeight() + "deleareaHeight:" + this.mDeleteAreaHeight);
              }
              i = 0;
            }
          }
        }
      }
    }
    while (i != 0)
    {
      this.mHasDeleteDown = true;
      return false;
      i = 0;
      continue;
      if (this.mHasSlide != true) {
        break;
      }
      return true;
      this.mHasSlideBanner = false;
      break;
      if ((this.mDownY == 0) || (this.mHasSlide == true)) {
        return true;
      }
      if (this.mHasSlideBanner) {
        break label88;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      label372:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MutilayoutSlideDetectListView
 * JD-Core Version:    0.7.0.1
 */