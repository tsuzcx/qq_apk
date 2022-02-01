import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class ort
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ort(ors paramors, int paramInt, View paramView) {}
  
  public void onGlobalLayout()
  {
    ors.a(this.jdField_a_of_type_Ors, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView.getHeight());
    QLog.d("Q.readinjoy.fast_web", 2, " position : " + this.jdField_a_of_type_Int + "   height:" + this.jdField_a_of_type_AndroidViewView.getHeight());
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ort
 * JD-Core Version:    0.7.0.1
 */