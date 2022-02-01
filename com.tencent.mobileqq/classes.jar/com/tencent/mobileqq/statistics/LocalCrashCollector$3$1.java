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
      if (LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0) > 0) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1) {
          LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).a().getFileManagerEngine().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
        } else {
          LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).a().getFileManagerEngine().a("/data/data/com.tencent.mobileqq/files/crashinfo/CrashInfoSummary.txt", this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int, true);
        }
      }
      LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).a().a().a().a("");
      LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).delete(0, LocalCrashCollector.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsLocalCrashCollector$3.this$0).length());
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.3.1
 * JD-Core Version:    0.7.0.1
 */