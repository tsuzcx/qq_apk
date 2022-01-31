import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class qxo
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  qxo(qxn paramqxn, int paramInt, View paramView) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_Qxn.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView.getHeight());
    QLog.d("Q.readinjoy.fast_web", 2, " position : " + this.jdField_a_of_type_Int + "   height:" + this.jdField_a_of_type_AndroidViewView.getHeight());
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxo
 * JD-Core Version:    0.7.0.1
 */