package com.tencent.mobileqq.profilecard.vas.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

class VasProfileTagView$1
  extends GestureDetector.SimpleOnGestureListener
{
  VasProfileTagView$1(VasProfileTagView paramVasProfileTagView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll invoked");
    }
    VasProfileTagView.access$002(this.this$0, true);
    paramFloat1 = paramFloat2;
    if (paramMotionEvent1 != null)
    {
      paramFloat1 = paramFloat2;
      if (paramMotionEvent2 != null) {
        paramFloat1 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
      }
    }
    if (QLog.isColorLevel())
    {
      paramMotionEvent1 = new StringBuilder();
      paramMotionEvent1.append("onScroll distance = ");
      paramMotionEvent1.append(paramFloat1);
      QLog.d("Q.profilecard.FrdProfileCard", 2, paramMotionEvent1.toString());
    }
    return this.this$0.scrollAnimation(paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.1
 * JD-Core Version:    0.7.0.1
 */