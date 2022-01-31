import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class mxe
  implements View.OnTouchListener
{
  mxe(mxc parammxc, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    mxc.a(this.jdField_a_of_type_Mxc, paramView);
    this.jdField_a_of_type_Mxc.d = this.jdField_a_of_type_Int;
    mxc.a(this.jdField_a_of_type_Mxc).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxe
 * JD-Core Version:    0.7.0.1
 */