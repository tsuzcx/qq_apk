import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView;

class snw
  extends GestureDetector.SimpleOnGestureListener
{
  private snw(snn paramsnn) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.a = true;
    snn.b(this.a);
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
    if ((!(snn.a(this.a).getTag() instanceof snu)) || (((snn.a(this.a).getTag() instanceof snu)) && (!snn.a(this.a).a(snn.a(this.a)).booleanValue()))) {
      snn.c(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     snw
 * JD-Core Version:    0.7.0.1
 */