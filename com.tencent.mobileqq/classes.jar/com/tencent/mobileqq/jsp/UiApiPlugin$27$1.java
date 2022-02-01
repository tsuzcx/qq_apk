package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.res.Resources;
import bcst;
import com.tencent.mobileqq.widget.QQToast;

class UiApiPlugin$27$1
  implements Runnable
{
  UiApiPlugin$27$1(UiApiPlugin.27 param27, boolean paramBoolean) {}
  
  public void run()
  {
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      str = UiApiPlugin.a("0", null, null, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$27.d);
      bcst.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
    }
    for (int i = 2131697115;; i = 2131697114)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$27.a, i, 0).b(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$27.a.getResources().getDimensionPixelSize(2131298998));
      bcst.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$27.this$0.callJs(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$27.e, new String[] { str });
      return;
      str = UiApiPlugin.a("-3", null, "createShortcut failed, iconUrl is invalide: " + this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$27.c, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$27.d);
      bcst.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.27.1
 * JD-Core Version:    0.7.0.1
 */