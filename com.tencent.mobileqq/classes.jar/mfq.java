import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class mfq
  implements ViewTreeObserver.OnPreDrawListener
{
  mfq(mfp parammfp, TextView paramTextView) {}
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeOnPreDrawListener(this);
    this.jdField_a_of_type_Mfp.a.a().a().au = true;
    mww.a(this.jdField_a_of_type_Mfp.a);
    QLog.d("qav_face_guide", 1, "onPreDraw");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mfq
 * JD-Core Version:    0.7.0.1
 */