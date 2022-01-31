import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class sns
  implements View.OnTouchListener
{
  sns(snq paramsnq, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    snq.a(this.jdField_a_of_type_Snq, paramView);
    this.jdField_a_of_type_Snq.d = this.jdField_a_of_type_Int;
    snq.a(this.jdField_a_of_type_Snq).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     sns
 * JD-Core Version:    0.7.0.1
 */