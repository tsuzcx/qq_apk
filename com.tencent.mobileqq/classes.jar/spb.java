import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageView;

public class spb
  extends GestureDetector.SimpleOnGestureListener
{
  private final spc jdField_a_of_type_Spc;
  
  public spb(PublicAccountImageView paramPublicAccountImageView, spc paramspc)
  {
    this.jdField_a_of_type_Spc = paramspc;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView);
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     spb
 * JD-Core Version:    0.7.0.1
 */