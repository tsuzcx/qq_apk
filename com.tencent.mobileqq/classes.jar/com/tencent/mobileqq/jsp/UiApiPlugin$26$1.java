package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.res.Resources;
import azmj;
import com.tencent.mobileqq.widget.QQToast;

class UiApiPlugin$26$1
  implements Runnable
{
  UiApiPlugin$26$1(UiApiPlugin.26 param26, boolean paramBoolean) {}
  
  public void run()
  {
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      str = UiApiPlugin.a("0", null, null, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.d);
      azmj.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
    }
    for (int i = 2131698262;; i = 2131698261)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.a, i, 0).b(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.a.getResources().getDimensionPixelSize(2131298914));
      azmj.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.this$0.callJs(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.e, new String[] { str });
      return;
      str = UiApiPlugin.a("-3", null, "createShortcut failed, iconUrl is invalide: " + this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.c, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.d);
      azmj.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.26.1
 * JD-Core Version:    0.7.0.1
 */