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
    if (DatalineOldForwardHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler).getIntExtra("forward_type", -1) == 11) {
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", String.valueOf(this.jdField_a_of_type_Long), "1000", "51", "0", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("DatalineOldForwardHandler", 2, "qbShowShareResultDialog back");
    }
    if (DatalineOldForwardHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler).getBooleanExtra("MigSdkShareNotDone", false))
    {
      DatalineOldForwardHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler).putExtra("MigSdkShareNotDone", false);
      ForwardSdkShareOption.a((Activity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler.jdField_a_of_type_AndroidContentContext, true, "sendToMyComputer", this.jdField_a_of_type_Long);
    }
    else
    {
      ForwardSdkShareOption.a((Activity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler.jdField_a_of_type_AndroidContentContext, true, "shareToQQ", this.jdField_a_of_type_Long);
    }
    Util.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler.jdField_a_of_type_AndroidContentContext, 0, "", "");
    DatalineOldForwardHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler).finish();
    if (DatalineOldForwardHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler).getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
      try
      {
        DatalineOldForwardHandler.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantForwardDatalineOldForwardHandler).moveTaskToBack(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.DatalineOldForwardHandler.2
 * JD-Core Version:    0.7.0.1
 */