import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageView.MatrixTouchListener;

public class myc
  extends GestureDetector.SimpleOnGestureListener
{
  private final PublicAccountImageView.MatrixTouchListener jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView$MatrixTouchListener;
  
  public myc(PublicAccountImageView paramPublicAccountImageView, PublicAccountImageView.MatrixTouchListener paramMatrixTouchListener)
  {
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView$MatrixTouchListener = paramMatrixTouchListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myc
 * JD-Core Version:    0.7.0.1
 */