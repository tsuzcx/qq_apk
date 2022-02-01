import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class mdv
  implements ViewTreeObserver.OnPreDrawListener
{
  mdv(mdu parammdu, TextView paramTextView) {}
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeOnPreDrawListener(this);
    this.jdField_a_of_type_Mdu.a.a().a().av = true;
    mvk.a(this.jdField_a_of_type_Mdu.a);
    QLog.d("qav_face_guide", 1, "onPreDraw");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mdv
 * JD-Core Version:    0.7.0.1
 */