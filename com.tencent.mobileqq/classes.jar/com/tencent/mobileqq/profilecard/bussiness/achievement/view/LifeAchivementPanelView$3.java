package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import android.view.ViewParent;

class LifeAchivementPanelView$3
  implements RecyclerView.OnItemTouchListener
{
  private boolean mCheckInterceptTouch;
  private float mLastTouchDownX;
  private float mLastTouchDownY;
  
  LifeAchivementPanelView$3(LifeAchivementPanelView paramLifeAchivementPanelView) {}
  
  private boolean moveHorizontal(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    return Math.abs(this.mLastTouchDownX - f1) > Math.abs(this.mLastTouchDownY - f2);
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
        }
        else
        {
          if (this.mCheckInterceptTouch) {
            break label97;
          }
          this.mCheckInterceptTouch = true;
          if (!moveHorizontal(paramMotionEvent)) {
            break label97;
          }
          this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
          return false;
        }
      }
      this.this$0.getParent().requestDisallowInterceptTouchEvent(false);
      return false;
    }
    else
    {
      this.mLastTouchDownX = paramMotionEvent.getX();
      this.mLastTouchDownY = paramMotionEvent.getY();
      this.mCheckInterceptTouch = false;
    }
    label97:
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView.3
 * JD-Core Version:    0.7.0.1
 */