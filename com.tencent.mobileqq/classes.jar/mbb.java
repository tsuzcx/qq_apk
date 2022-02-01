import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

class mbb
  extends maz
{
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  mbb(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131373752));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLinearLayout.findViewById(2131373470));
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
  
  boolean a(mbc parammbc)
  {
    a();
    if ((parammbc.a != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      max.a(this.jdField_a_of_type_AndroidWidgetTextView, parammbc);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mbb
 * JD-Core Version:    0.7.0.1
 */