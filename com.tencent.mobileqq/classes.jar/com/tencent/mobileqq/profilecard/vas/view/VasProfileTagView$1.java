package com.tencent.mobileqq.profilecard.vas.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll distance = " + paramFloat1);
    }
    if (Math.abs(paramFloat1) > VasProfileTagView.access$100(this.this$0))
    {
      if ((paramFloat1 > 0.0F) && (this.this$0.isFullScreen)) {
        if (this.this$0.switchScreenMode())
        {
          this.this$0.tagsGather();
          VasProfileTagView.access$200(this.this$0).b(null);
        }
      }
      while ((paramFloat1 >= 0.0F) || (this.this$0.isFullScreen)) {
        return true;
      }
      this.this$0.switchScreenMode();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.1
 * JD-Core Version:    0.7.0.1
 */