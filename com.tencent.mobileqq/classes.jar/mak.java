import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

class mak
  extends mai
{
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  mak(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131372502));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLinearLayout.findViewById(2131372221));
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
  
  boolean a(mal parammal)
  {
    a();
    if ((parammal.a != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      mag.a(this.jdField_a_of_type_AndroidWidgetTextView, parammal);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mak
 * JD-Core Version:    0.7.0.1
 */