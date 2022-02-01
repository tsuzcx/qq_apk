package com.tencent.mobileqq.richstatus;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import com.tencent.mobileqq.text.ClickableImageSpan;

class RichStatusEditText$1
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  RichStatusEditText$1(RichStatusEditText paramRichStatusEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      paramEditable = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText;
      paramEditable.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      paramEditable = paramEditable.getText();
      int i = this.jdField_a_of_type_Int;
      paramEditable.replace(i, this.jdField_b_of_type_Int + i, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setSelection(this.jdField_a_of_type_Int + this.jdField_a_of_type_JavaLangString.length());
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt3 > 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt3;
      RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setCursorVisible(true);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    paramCharSequence = RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText, paramInt1, false, false);
    if (paramCharSequence != null)
    {
      paramInt3 = RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText).getSpanStart(paramCharSequence);
      if (paramInt3 != paramInt1)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Int = paramInt3;
        this.jdField_b_of_type_Int = (paramInt1 - paramInt3);
        this.jdField_a_of_type_JavaLangString = "";
      }
    }
    RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText, paramInt1, paramInt2);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText;
      paramInt2 = paramInt3 + paramInt1;
      localObject = RichStatusEditText.a((RichStatusEditText)localObject, paramInt2, true, false);
      if ((localObject != null) && (RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText) != null) && (!RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText).a((ClickableImageSpan)localObject)))
      {
        this.jdField_a_of_type_JavaLangString = "";
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramCharSequence.subSequence(paramInt1, paramInt2).toString();
      if (this.jdField_a_of_type_JavaLangString.contains("\n"))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replace("\n", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatusEditText.1
 * JD-Core Version:    0.7.0.1
 */