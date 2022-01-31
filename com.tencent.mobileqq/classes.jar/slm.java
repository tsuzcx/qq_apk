import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class slm
  implements TextWatcher
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  
  public slm(EditActivity paramEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    EditActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityEditActivity, true);
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramEditable = this.jdField_c_of_type_JavaLangString;; paramEditable = "")
    {
      paramEditable = paramEditable + this.jdField_b_of_type_JavaLangString;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityEditActivity.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(paramEditable);
        this.jdField_b_of_type_Boolean = true;
      }
      int i = this.jdField_a_of_type_JavaLangString.length();
      int j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityEditActivity.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i + j);
      this.jdField_a_of_type_ComTencentMobileqqActivityEditActivity.e();
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString().substring(0, paramInt1);
    this.jdField_b_of_type_JavaLangString = paramCharSequence.toString().substring(paramInt1 + paramInt2);
    if (paramInt3 > 0)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramCharSequence.toString().substring(paramInt1, paramInt1 + paramInt3);
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityEditActivity.jdField_a_of_type_Int == 100) && (this.jdField_c_of_type_JavaLangString.contains("\n")))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.replace("\n", "");
      }
      this.jdField_a_of_type_Int = this.jdField_c_of_type_JavaLangString.length();
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slm
 * JD-Core Version:    0.7.0.1
 */