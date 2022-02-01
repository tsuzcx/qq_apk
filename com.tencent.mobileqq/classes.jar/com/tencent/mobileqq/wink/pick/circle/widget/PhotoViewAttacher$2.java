package com.tencent.mobileqq.wink.pick.circle.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;

class PhotoViewAttacher$2
  extends GestureDetector.SimpleOnGestureListener
{
  PhotoViewAttacher$2(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (PhotoViewAttacher.k(this.a) != null) {
      PhotoViewAttacher.k(this.a).onLongClick(PhotoViewAttacher.h(this.a));
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramMotionEvent1 = new StringBuilder();
    paramMotionEvent1.append("onScroll distanceX:");
    paramMotionEvent1.append(paramFloat1);
    paramMotionEvent1.append(" distanceY:");
    paramMotionEvent1.append(paramFloat2);
    QLog.d("PhotoViewAttacher", 4, paramMotionEvent1.toString());
    paramFloat1 = 0.0F - paramFloat1;
    paramFloat2 = 0.0F - paramFloat2;
    if (PhotoViewAttacher.j(this.a) != null) {
      PhotoViewAttacher.j(this.a).a(paramFloat1, paramFloat2);
    }
    return this.a.a(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.PhotoViewAttacher.2
 * JD-Core Version:    0.7.0.1
 */