import android.app.Activity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class mhc
{
  public Button a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public TextView a;
  public Button b;
  public TextView b;
  
  public mhc()
  {
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(paramInt);
    }
    if ((this.jdField_b_of_type_AndroidWidgetButton != null) && (paramInt != 0)) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(paramInt);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramActivity.findViewById(2131373527));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131373361));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131373360));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramActivity.findViewById(2131373391));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramActivity.findViewById(2131373384));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramActivity.findViewById(2131373389));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhc
 * JD-Core Version:    0.7.0.1
 */