package com.tencent.mobileqq.jsp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;

class UiApiPlugin$2
  implements DialogInterface.OnClickListener
{
  UiApiPlugin$2(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString + "({button: 1})");
      }
    }
    while (paramInt != 1)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs4OpenApiIfNeeded("showDialog", 0, "({button: 1})");
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString + "({button: 0})");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs4OpenApiIfNeeded("showDialog", 0, "({button: 0})");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */