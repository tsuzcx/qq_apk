package com.tencent.mobileqq.filemanager.aioitem;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopFileBubblePauseHandler$1
  implements ActionSheet.OnButtonClickListener
{
  TroopFileBubblePauseHandler$1(TroopFileBubblePauseHandler paramTroopFileBubblePauseHandler, String paramString, TroopFileStatusInfo paramTroopFileStatusInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemTroopFileBubblePauseHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A7F3", "0X800A7F3", 2, 0, "", "", "", "");
    new TroopFileItemOperation(Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemTroopFileBubblePauseHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemTroopFileBubblePauseHandler.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemTroopFileBubblePauseHandler.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.TroopFileBubblePauseHandler.1
 * JD-Core Version:    0.7.0.1
 */