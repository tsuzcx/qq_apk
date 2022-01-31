import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class sco
  implements View.OnTouchListener
{
  sco(scl paramscl, sck paramsck, boolean paramBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_Scl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Scl.jdField_a_of_type_Sck.a.getResources().getColor(2131165979));
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Scl.c.setBackgroundResource(2130842626);
        return false;
      }
      this.jdField_a_of_type_Scl.c.setBackgroundResource(2130842627);
      return false;
    }
    this.jdField_a_of_type_Scl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Scl.jdField_a_of_type_Sck.a.getResources().getColor(2131165978));
    this.jdField_a_of_type_Scl.c.setBackgroundResource(2130842635);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sco
 * JD-Core Version:    0.7.0.1
 */