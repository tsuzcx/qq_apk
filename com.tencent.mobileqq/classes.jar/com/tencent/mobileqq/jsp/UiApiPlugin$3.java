package com.tencent.mobileqq.jsp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class UiApiPlugin$3
  implements DialogInterface.OnCancelListener
{
  UiApiPlugin$3(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("({button: -1})");
    paramDialogInterface.callJs(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */