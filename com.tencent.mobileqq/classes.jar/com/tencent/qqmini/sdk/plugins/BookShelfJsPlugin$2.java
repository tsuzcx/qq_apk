package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

class BookShelfJsPlugin$2
  implements DialogInterface.OnClickListener
{
  BookShelfJsPlugin$2(BookShelfJsPlugin paramBookShelfJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MiniAppInfo localMiniAppInfo = BookShelfJsPlugin.access$100(this.this$0).getMiniAppInfo();
    if (localMiniAppInfo != null)
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("");
      paramDialogInterface.append(localMiniAppInfo.getReportType());
      paramDialogInterface = paramDialogInterface.toString();
    }
    else
    {
      paramDialogInterface = "0";
    }
    SDKMiniProgramLpReportDC04239.reportForSDK(localMiniAppInfo, paramDialogInterface, null, "bookshelf_enter", "toast_enter", "click", "");
    BookShelfJsPlugin.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */