import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView;

class snz
  extends GestureDetector.SimpleOnGestureListener
{
  private snz(snq paramsnq) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.a = true;
    snq.b(this.a);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((!(snq.a(this.a).getTag() instanceof snx)) || (((snq.a(this.a).getTag() instanceof snx)) && (!snq.a(this.a).a(snq.a(this.a)).booleanValue()))) {
      snq.c(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     snz
 * JD-Core Version:    0.7.0.1
 */