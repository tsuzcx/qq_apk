package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import android.view.ViewParent;

class ProfileTroopFansInfoComponent$2
  implements RecyclerView.OnItemTouchListener
{
  private boolean mCheckInterceptTouch;
  private float mLastTouchDownX;
  private float mLastTouchDownY;
  
  ProfileTroopFansInfoComponent$2(ProfileTroopFansInfoComponent paramProfileTroopFansInfoComponent) {}
  
  private boolean moveHorizontal(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    return Math.abs(this.mLastTouchDownX - f1) > Math.abs(this.mLastTouchDownY - f2);
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          return false;
          this.mLastTouchDownX = paramMotionEvent.getX();
          this.mLastTouchDownY = paramMotionEvent.getY();
          this.mCheckInterceptTouch = false;
          return false;
        } while (this.mCheckInterceptTouch);
        this.mCheckInterceptTouch = true;
      } while ((!moveHorizontal(paramMotionEvent)) || (paramRecyclerView.getParent() == null));
      paramRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    } while (paramRecyclerView.getParent() == null);
    paramRecyclerView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent.2
 * JD-Core Version:    0.7.0.1
 */