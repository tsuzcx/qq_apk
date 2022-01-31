import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageView;

public class sci
  extends GestureDetector.SimpleOnGestureListener
{
  private final scj jdField_a_of_type_Scj;
  
  public sci(PublicAccountImageView paramPublicAccountImageView, scj paramscj)
  {
    this.jdField_a_of_type_Scj = paramscj;
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
 * Qualified Name:     sci
 * JD-Core Version:    0.7.0.1
 */