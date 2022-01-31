import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageView;
import com.tencent.qphone.base.util.QLog;

public class nbo
  implements View.OnTouchListener
{
  public nbo(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (PublicAccountImageCollectionMainActivity.a(this.a))
    {
      this.a.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "current operation is" + paramMotionEvent.getAction());
      }
      if ((paramMotionEvent.getAction() == 1) && (this.a.b[0] < this.a.jdField_a_of_type_ArrayOfFloat[0]))
      {
        PublicAccountImageCollectionMainActivity.a(this.a).setImageMatrix(this.a.c);
        PublicAccountImageCollectionMainActivity.a(this.a).setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      return true;
    }
    this.a.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbo
 * JD-Core Version:    0.7.0.1
 */