package com.tencent.mobileqq.hiboom;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class HiBoomTextView$1
  extends GestureDetector.SimpleOnGestureListener
{
  HiBoomTextView$1(HiBoomTextView paramHiBoomTextView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$OnDoubleClick.a(this.a);
      return true;
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    HiBoomFontDrawer localHiBoomFontDrawer = HiBoomFont.a().a(this.a.jdField_a_of_type_Int, this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFont$HiBoomFontDownloader);
    if (this.a.b())
    {
      localHiBoomFontDrawer.a(true);
      this.a.invalidate();
      return true;
    }
    if (HiBoomTextView.a(this.a)) {
      this.a.a();
    }
    for (;;)
    {
      return super.onSingleTapConfirmed(paramMotionEvent);
      if (localHiBoomFontDrawer.jdField_a_of_type_Int == 3)
      {
        this.a.a(true);
      }
      else if (localHiBoomFontDrawer.jdField_a_of_type_Int == 4)
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomTextView.1
 * JD-Core Version:    0.7.0.1
 */