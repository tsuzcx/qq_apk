package com.tencent.mobileqq.winkpublish.widget;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.OnDoubleTapListener;
import com.tencent.mobileqq.winkpublish.widget.multitouchimg.OnViewTapListener;

class PhotoViewAttacher$3
  implements GestureDetector.OnDoubleTapListener
{
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (PhotoViewAttacher.p(this.a) != null) {
      PhotoViewAttacher.p(this.a).a();
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.a.a();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (PhotoViewAttacher.o(this.a) != null) {
      PhotoViewAttacher.o(this.a).a(PhotoViewAttacher.i(this.a), f1, f2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.PhotoViewAttacher.3
 * JD-Core Version:    0.7.0.1
 */