package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class UiApiPlugin$26$1
  implements Runnable
{
  UiApiPlugin$26$1(UiApiPlugin.26 param26, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = UiApiPlugin.a("0", null, null, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.d);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
      i = 2131697843;
    }
    else
    {
      i = 2131697842;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createShortcut failed, iconUrl is invalide: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.c);
      localObject = UiApiPlugin.a("-3", null, ((StringBuilder)localObject).toString(), this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.d);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.a, i, 0).b(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.a.getResources().getDimensionPixelSize(2131299168));
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.this$0.callJs(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin$26.e, new String[] { localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.26.1
 * JD-Core Version:    0.7.0.1
 */