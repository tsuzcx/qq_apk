import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteActivity.9.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class dq
  implements View.OnTouchListener
{
  public dq(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LiteActivity.jdField_a_of_type_JavaLangString, 2, "ontouch--fcc----: " + paramMotionEvent.getAction());
    }
    this.a.q();
    LiteActivity.a(this.a, false);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.postDelayed(new LiteActivity.9.1(this), 200L);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.onTouch(paramView, paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dq
 * JD-Core Version:    0.7.0.1
 */