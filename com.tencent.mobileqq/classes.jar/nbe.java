import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView;

class nbe
  extends GestureDetector.SimpleOnGestureListener
{
  private nbe(naw paramnaw) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.a = true;
    naw.b(this.a);
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
    if ((!(naw.a(this.a).getTag() instanceof nbc)) || (((naw.a(this.a).getTag() instanceof nbc)) && (!naw.a(this.a).a(naw.a(this.a)).booleanValue()))) {
      naw.c(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbe
 * JD-Core Version:    0.7.0.1
 */