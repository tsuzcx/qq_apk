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
    if (this.a)
    {
      localObject = UiApiPlugin.a("0", null, null, this.b.e);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
      i = 2131895616;
    }
    else
    {
      i = 2131895615;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createShortcut failed, iconUrl is invalide: ");
      ((StringBuilder)localObject).append(this.b.d);
      localObject = UiApiPlugin.a("-3", null, ((StringBuilder)localObject).toString(), this.b.e);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
    }
    QQToast.makeText(this.b.a, i, 0).show(this.b.a.getResources().getDimensionPixelSize(2131299920));
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
    this.b.this$0.callJs(this.b.f, new String[] { localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.26.1
 * JD-Core Version:    0.7.0.1
 */