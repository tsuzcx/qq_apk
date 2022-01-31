import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class mvx
  implements View.OnTouchListener
{
  mvx(mvv parammvv, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    mvv.a(this.jdField_a_of_type_Mvv, paramView);
    this.jdField_a_of_type_Mvv.d = this.jdField_a_of_type_Int;
    mvv.a(this.jdField_a_of_type_Mvv).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvx
 * JD-Core Version:    0.7.0.1
 */