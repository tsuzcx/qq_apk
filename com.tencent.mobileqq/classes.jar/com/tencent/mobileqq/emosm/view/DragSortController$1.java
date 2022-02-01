package com.tencent.mobileqq.emosm.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class DragSortController$1
  extends GestureDetector.SimpleOnGestureListener
{
  DragSortController$1(DragSortController paramDragSortController) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b()) && (this.a.d != -1)) {
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setTapPos(this.a.d);
    }
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b()) && (Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (!this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c()) && (!this.a.c) && (Math.abs(paramFloat1) > this.a.jdField_a_of_type_Float))
    {
      if ((paramFloat1 < 0.0F) && (this.a.jdField_a_of_type_Int == 2)) {
        return false;
      }
      if ((paramFloat1 > 0.0F) && (this.a.jdField_a_of_type_Int == 1)) {
        return false;
      }
      int i = this.a.d;
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setSrcPos(i);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortController.1
 * JD-Core Version:    0.7.0.1
 */