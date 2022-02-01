import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

class max
  extends mav
{
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  max(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131373623));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLinearLayout.findViewById(2131373341));
  }
  
  Resources a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView.getResources();
  }
  
  void a()
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView != null;
  }
  
  boolean a(may parammay)
  {
    a();
    if ((parammay.a != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      mat.a(this.jdField_a_of_type_AndroidWidgetTextView, parammay);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     max
 * JD-Core Version:    0.7.0.1
 */