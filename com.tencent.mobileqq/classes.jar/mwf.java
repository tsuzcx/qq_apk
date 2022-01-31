import android.content.Context;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;

public class mwf
  extends TopGestureLayout.TopGestureDetector
{
  public mwf(ReadInJoyNewFeedsTopGestureLayout paramReadInJoyNewFeedsTopGestureLayout, Context paramContext)
  {
    super(paramReadInJoyNewFeedsTopGestureLayout, paramContext);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.a.isGestureIdle()) || (this.a.isGestureEnd())) {
      return false;
    }
    paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    int i;
    if (this.a.hasGestureFlag(1)) {
      if (paramMotionEvent1.getX() <= 0.2133333333333334D * babp.i())
      {
        i = 1;
        if ((i != 0) && (paramFloat1 < 0.0F) && (paramFloat2 < 0.5F) && (this.a.mOnFlingGesture != null))
        {
          this.a.setGestureFlag(-1);
          if (!ReadInJoyNewFeedsTopGestureLayout.a(this.a)) {
            this.a.mOnFlingGesture.flingLToR();
          }
        }
      }
    }
    for (;;)
    {
      return false;
      i = 0;
      break;
      if ((this.a.hasGestureFlag(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F) && (this.a.mOnFlingGesture != null))
      {
        this.a.setGestureFlag(-1);
        if (!ReadInJoyNewFeedsTopGestureLayout.b(this.a)) {
          this.a.mOnFlingGesture.flingRToL();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwf
 * JD-Core Version:    0.7.0.1
 */