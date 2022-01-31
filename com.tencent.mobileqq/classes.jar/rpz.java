import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class rpz
  implements View.OnTouchListener
{
  rpz(rpw paramrpw, rpv paramrpv, boolean paramBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_Rpw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.a.getResources().getColor(2131100389));
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Rpw.c.setBackgroundResource(2130842542);
        return false;
      }
      this.jdField_a_of_type_Rpw.c.setBackgroundResource(2130842543);
      return false;
    }
    this.jdField_a_of_type_Rpw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Rpw.jdField_a_of_type_Rpv.a.getResources().getColor(2131100388));
    this.jdField_a_of_type_Rpw.c.setBackgroundResource(2130842551);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpz
 * JD-Core Version:    0.7.0.1
 */