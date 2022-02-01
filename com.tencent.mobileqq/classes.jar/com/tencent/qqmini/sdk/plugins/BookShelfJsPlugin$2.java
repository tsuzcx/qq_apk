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
    if (localMiniAppInfo != null) {}
    for (paramDialogInterface = "" + localMiniAppInfo.getReportType();; paramDialogInterface = "0")
    {
      SDKMiniProgramLpReportDC04239.reportForSDK(localMiniAppInfo, paramDialogInterface, null, "bookshelf_enter", "toast_enter", "click", "");
      BookShelfJsPlugin.access$200(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */