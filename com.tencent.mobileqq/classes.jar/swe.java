import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class swe
  extends GestureDetector.SimpleOnGestureListener
{
  swe(swd paramswd) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((swd.a(this.a) != null) && (swd.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout != null)) {
      this.a.a.a(swd.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((swd.a(this.a) != null) && (swd.a(this.a).jdField_a_of_type_AndroidViewView != null)) {
      this.a.a.onClick(swd.a(this.a).jdField_a_of_type_AndroidViewView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swe
 * JD-Core Version:    0.7.0.1
 */