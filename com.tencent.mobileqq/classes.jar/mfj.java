import android.os.SystemClock;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout.CustomClickListener;

public class mfj
  extends GestureDetector.SimpleOnGestureListener
{
  public mfj(VideoFeedsGestureLayout paramVideoFeedsGestureLayout) {}
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (VideoFeedsGestureLayout.a(this.a) != null)
      {
        VideoFeedsGestureLayout.a(this.a, SystemClock.uptimeMillis());
        VideoFeedsGestureLayout.a(this.a).a(this.a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      }
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (VideoFeedsGestureLayout.a(this.a) != null) {
      VideoFeedsGestureLayout.a(this.a).b(this.a);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 1.0F;
    int i = com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.a(VideoFeedsGestureLayout.a(this.a))[0];
    i = com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.a(VideoFeedsGestureLayout.a(this.a))[1];
    paramFloat2 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
    float f = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    if (VideoFeedsGestureLayout.a(this.a) == 0)
    {
      if (Math.abs(f) - Math.abs(paramFloat2) >= 0.0F) {
        break label154;
      }
      if (paramMotionEvent1.getX() >= this.a.getWidth() / 2) {
        break label142;
      }
      VideoFeedsGestureLayout.a(this.a, 2);
    }
    switch (VideoFeedsGestureLayout.a(this.a))
    {
    default: 
    case 1: 
    case 2: 
      label142:
      label154:
      do
      {
        return false;
        VideoFeedsGestureLayout.a(this.a, 1);
        break;
        VideoFeedsGestureLayout.a(this.a, 3);
        break;
      } while (VideoFeedsGestureLayout.a(this.a) == null);
      paramFloat2 /= this.a.getHeight() / 2;
      if (Math.abs(paramFloat2) > 1.0F) {
        if (paramFloat2 <= 1.0F) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      this.a.a(VideoFeedsGestureLayout.a(this.a), paramFloat1);
      return false;
      paramFloat1 = -1.0F;
      continue;
      if (VideoFeedsGestureLayout.a(this.a) == null) {
        break;
      }
      paramFloat2 = f / (this.a.getWidth() / 4 * 3);
      if (Math.abs(paramFloat2) > 1.0F) {
        if (paramFloat2 <= 1.0F) {}
      }
      for (;;)
      {
        this.a.a(VideoFeedsGestureLayout.a(this.a), paramFloat1);
        return false;
        paramFloat1 = -1.0F;
        continue;
        paramFloat1 = paramFloat2;
      }
      paramFloat1 = paramFloat2;
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((VideoFeedsGestureLayout.a(this.a) != null) && (SystemClock.uptimeMillis() - VideoFeedsGestureLayout.a(this.a) > 500L)) {
      VideoFeedsGestureLayout.a(this.a).a(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfj
 * JD-Core Version:    0.7.0.1
 */