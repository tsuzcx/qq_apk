package com.tencent.mobileqq.multiaio;

import android.support.v4.app.Fragment;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MultiAIOItemFragment$1
  extends GestureDetector.SimpleOnGestureListener
{
  MultiAIOItemFragment$1(MultiAIOItemFragment paramMultiAIOItemFragment) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    Fragment localFragment = this.a.getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiAIOFragment))) {
      ((MultiAIOFragment)localFragment).a(this.a.getView(), paramMotionEvent);
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOItemFragment.1
 * JD-Core Version:    0.7.0.1
 */