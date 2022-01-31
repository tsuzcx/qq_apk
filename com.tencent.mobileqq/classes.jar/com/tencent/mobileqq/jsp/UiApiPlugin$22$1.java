package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.res.Resources;
import awqx;
import bbmy;

class UiApiPlugin$22$1
  implements Runnable
{
  UiApiPlugin$22$1(UiApiPlugin.22 param22, boolean paramBoolean) {}
  
  public void run()
  {
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      str = UiApiPlugin.a("0", null, null, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$22.d);
      awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
    }
    for (int i = 2131632349;; i = 2131632348)
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$22.a, i, 0).b(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$22.a.getResources().getDimensionPixelSize(2131167766));
      awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$22.this$0.callJs(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$22.e, new String[] { str });
      return;
      str = UiApiPlugin.a("-3", null, "createShortcut failed, iconUrl is invalide: " + this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$22.c, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$22.d);
      awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.22.1
 * JD-Core Version:    0.7.0.1
 */