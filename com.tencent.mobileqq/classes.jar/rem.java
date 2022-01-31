import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class rem
  implements View.OnFocusChangeListener
{
  public rem(AddAccountActivity paramAddAccountActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView) {
      if (true == paramBoolean)
      {
        if (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.isPopupShowing()) {
          this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.dismissDropDown();
        }
        if ((this.a.jdField_a_of_type_AndroidWidgetImageView != null) && (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length() > 0)) {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setSelection(this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length());
      }
    }
    while ((paramView != this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText) || (true != paramBoolean))
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_AndroidWidgetImageView == null) || (!this.a.jdField_a_of_type_AndroidWidgetImageView.isShown()));
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rem
 * JD-Core Version:    0.7.0.1
 */