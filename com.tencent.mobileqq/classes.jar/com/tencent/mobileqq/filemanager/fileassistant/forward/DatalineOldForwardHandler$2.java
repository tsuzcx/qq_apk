package com.tencent.mobileqq.filemanager.fileassistant.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;

class DatalineOldForwardHandler$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (DatalineOldForwardHandler.a(this.b).getIntExtra("forward_type", -1) == 11) {
      ReportCenter.a().a(this.b.a.getAccount(), "", String.valueOf(this.a), "1000", "51", "0", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("DatalineOldForwardHandler", 2, "qbShowShareResultDialog back");
    }
    if (DatalineOldForwardHandler.a(this.b).getBooleanExtra("MigSdkShareNotDone", false))
    {
      DatalineOldForwardHandler.a(this.b).putExtra("MigSdkShareNotDone", false);
      ForwardSdkShareOption.a((Activity)this.b.b, true, "sendToMyComputer", this.a);
    }
    else
    {
      ForwardSdkShareOption.a((Activity)this.b.b, true, "shareToQQ", this.a);
    }
    Util.a(this.b.b, 0, "", "");
    DatalineOldForwardHandler.b(this.b).finish();
    if (DatalineOldForwardHandler.a(this.b).getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
      try
      {
        DatalineOldForwardHandler.b(this.b).moveTaskToBack(true);
        return;
      }
      catch (Throwable paramDialogInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DatalineOldForwardHandler", 2, "qbShowShareResultDialog ", paramDialogInterface);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineOldForwardHandler.2
 * JD-Core Version:    0.7.0.1
 */