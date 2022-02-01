package com.tencent.mobileqq.filemanager.aioitem;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class OfflineFileBubblePauseHandler$1
  implements ActionSheet.OnButtonClickListener
{
  OfflineFileBubblePauseHandler$1(OfflineFileBubblePauseHandler paramOfflineFileBubblePauseHandler, int paramInt, FileManagerEntity paramFileManagerEntity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemOfflineFileBubblePauseHandler.a, "dc00898", "", "", "0X800A7F3", "0X800A7F3", this.jdField_a_of_type_Int, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemOfflineFileBubblePauseHandler.a.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemOfflineFileBubblePauseHandler.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.OfflineFileBubblePauseHandler.1
 * JD-Core Version:    0.7.0.1
 */