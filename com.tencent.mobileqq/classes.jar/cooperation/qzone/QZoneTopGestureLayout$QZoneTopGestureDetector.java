package cooperation.qzone;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;

class QZoneTopGestureLayout$QZoneTopGestureDetector
  extends TopGestureLayout.TopGestureDetector
{
  public static final float MIN_VELOCITYX = 500.0F;
  
  QZoneTopGestureLayout$QZoneTopGestureDetector(QZoneTopGestureLayout paramQZoneTopGestureLayout, Context paramContext)
  {
    super(paramQZoneTopGestureLayout, paramContext);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return false;
    }
    if (!QZoneTopGestureLayout.access$000()) {
      QZoneTopGestureLayout.access$201(this.this$0, -1);
    }
    if (QZoneTopGestureLayout.access$301(this.this$0)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
    if (QZoneTopGestureLayout.access$401(this.this$0, 1))
    {
      if ((paramFloat2 < 0.0F) && (f < 0.5F) && (this.this$0.mOnFlingGesture != null) && (paramFloat1 > 500.0F))
      {
        QZoneTopGestureLayout.access$501(this.this$0, -1);
        this.this$0.mOnFlingGesture.flingLToR();
        return true;
      }
    }
    else if ((QZoneTopGestureLayout.access$601(this.this$0, 0)) && (paramFloat2 > 0.0F) && (f < 0.5F) && (this.this$0.mOnFlingGesture != null) && (-1.0F * paramFloat1 > 500.0F))
    {
      QZoneTopGestureLayout.access$701(this.this$0, -1);
      this.this$0.mOnFlingGesture.flingRToL();
      return true;
    }
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!QZoneTopGestureLayout.access$000()) {
      QZoneTopGestureLayout.access$101(this.this$0, -1);
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneTopGestureLayout.QZoneTopGestureDetector
 * JD-Core Version:    0.7.0.1
 */