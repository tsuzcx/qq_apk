package com.tencent.mobileqq.multicard;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;

class MultiCardCustomLayout$1
  extends GestureDetector.SimpleOnGestureListener
{
  MultiCardCustomLayout$1(MultiCardCustomLayout paramMultiCardCustomLayout) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (MultiCardCustomLayout.a(this.a) != null) {
      MultiCardCustomLayout.a(this.a).onLongClick(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardCustomLayout.1
 * JD-Core Version:    0.7.0.1
 */