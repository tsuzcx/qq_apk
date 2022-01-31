package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class UniteSearchActivity$CustomFlingGestureHandler
  extends FlingGestureHandler
{
  boolean a = true;
  
  public UniteSearchActivity$CustomFlingGestureHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (!a()) {
      a();
    }
    if (this.mTopLayout != null) {
      this.mTopLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void flingLToR()
  {
    if (this.a) {
      super.flingLToR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.CustomFlingGestureHandler
 * JD-Core Version:    0.7.0.1
 */