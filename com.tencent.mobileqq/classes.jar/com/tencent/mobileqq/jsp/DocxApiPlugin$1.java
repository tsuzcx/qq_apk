package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.mobileqq.doc.TencentDocGuideDialog;
import com.tencent.mobileqq.doc.TencentDocGuideDialog.Callback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class DocxApiPlugin$1
  implements TencentDocGuideDialog.Callback
{
  DocxApiPlugin$1(DocxApiPlugin paramDocxApiPlugin) {}
  
  public void a(TencentDocGuideDialog paramTencentDocGuideDialog)
  {
    try
    {
      paramTencentDocGuideDialog.dismiss();
    }
    catch (Throwable paramTencentDocGuideDialog)
    {
      QLog.e("DocxApiPlugin", 1, "handleEvent", paramTencentDocGuideDialog);
    }
    this.a.mRuntime.a().finish();
    ReportController.b(null, "CliOper", "", "", "0X80094EB", "0X80094EB", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */