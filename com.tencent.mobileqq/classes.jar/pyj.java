import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

class pyj
  implements View.OnTouchListener
{
  pyj(pyg parampyg, LinearLayout paramLinearLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setDuplicateParentStateEnabled(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pyj
 * JD-Core Version:    0.7.0.1
 */