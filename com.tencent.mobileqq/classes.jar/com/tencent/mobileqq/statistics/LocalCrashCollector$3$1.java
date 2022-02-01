package com.tencent.mobileqq.statistics;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;

class LocalCrashCollector$3$1
  implements DialogInterface.OnClickListener
{
  LocalCrashCollector$3$1(LocalCrashCollector.3 param3, BaseSessionInfo paramBaseSessionInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (LocalCrashCollector.b(this.b.this$0) > 0) {
        if (this.a.a == 1) {
          LocalCrashCollector.a(this.b.this$0).a().getFileManagerEngine().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.a.b);
        } else {
          LocalCrashCollector.a(this.b.this$0).a().getFileManagerEngine().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.a.c, this.a.b, this.a.a, true);
        }
      }
      LocalCrashCollector.a(this.b.this$0).p().d().f().a("");
      LocalCrashCollector.c(this.b.this$0).delete(0, LocalCrashCollector.c(this.b.this$0).length());
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.3.1
 * JD-Core Version:    0.7.0.1
 */