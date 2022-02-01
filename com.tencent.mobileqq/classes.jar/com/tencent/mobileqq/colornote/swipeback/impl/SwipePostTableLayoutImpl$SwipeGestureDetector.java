package com.tencent.mobileqq.colornote.swipeback.impl;

import android.app.Activity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.swipe.OnPageSwipeListener;
import com.tencent.mobileqq.swipe.SwipeBackLayout.SwipeLayoutHandler;
import com.tencent.mobileqq.utils.TranslucentConvertor;

public class SwipePostTableLayoutImpl$SwipeGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  protected SwipePostTableLayoutImpl$SwipeGestureDetector(SwipePostTableLayoutImpl paramSwipePostTableLayoutImpl) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      Object localObject = SwipePostTableLayoutImpl.access$000(this.a);
      int i = 0;
      boolean bool;
      if ((localObject != null) && (SwipePostTableLayoutImpl.access$000(this.a).getColorNote() != null))
      {
        localObject = SwipePostTableLayoutImpl.access$000(this.a).getColorNote();
        bool = SwipePostTableLayoutImpl.access$100(this.a).a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType());
      }
      else
      {
        bool = false;
      }
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = paramMotionEvent1.getY();
      float f3 = paramMotionEvent2.getY();
      if ((f1 != 0.0F) && (SwipePostTableLayoutImpl.access$200(this.a)) && (paramFloat1 >= 200.0F))
      {
        f2 = Math.abs((f2 - f3) / f1);
        if ((SwipePostTableLayoutImpl.access$300(this.a) == null) || (SwipePostTableLayoutImpl.access$300(this.a).a())) {
          i = 1;
        }
        if ((f1 < 0.0F) && (f2 < 0.5F)) {
          if (bool)
          {
            if (i != 0)
            {
              SwipePostTableLayoutImpl.access$400(this.a).sendEmptyMessage(1);
            }
            else
            {
              SwipePostTableLayoutImpl.access$502(this.a, true);
              SwipePostTableLayoutImpl.access$300(this.a).a();
            }
            this.a.postInvalidate();
          }
          else if ((SwipePostTableLayoutImpl.access$600(this.a) instanceof Activity))
          {
            SwipePostTableLayoutImpl.access$702(this.a, true);
            if (i != 0)
            {
              SwipePostTableLayoutImpl.access$800(this.a);
            }
            else
            {
              SwipePostTableLayoutImpl.access$902(this.a, true);
              SwipePostTableLayoutImpl.access$300(this.a).a();
            }
          }
          else if (i != 0)
          {
            SwipePostTableLayoutImpl.access$1000(this.a);
          }
          else
          {
            SwipePostTableLayoutImpl.access$902(this.a, true);
            SwipePostTableLayoutImpl.access$300(this.a).a();
          }
        }
        if (SwipePostTableLayoutImpl.access$1100(this.a) != null) {
          SwipePostTableLayoutImpl.access$1200(this.a).a();
        }
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.impl.SwipePostTableLayoutImpl.SwipeGestureDetector
 * JD-Core Version:    0.7.0.1
 */