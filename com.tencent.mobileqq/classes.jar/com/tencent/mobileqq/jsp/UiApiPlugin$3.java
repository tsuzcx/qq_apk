package com.tencent.mobileqq.jsp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class UiApiPlugin$3
  implements DialogInterface.OnCancelListener
{
  UiApiPlugin$3(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString + "({button: -1})");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */