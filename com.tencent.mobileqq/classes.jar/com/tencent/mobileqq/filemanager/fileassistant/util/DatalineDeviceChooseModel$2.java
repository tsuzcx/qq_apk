package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DatalineDeviceChooseModel$2
  implements ActionSheet.OnButtonClickListener
{
  DatalineDeviceChooseModel$2(DatalineDeviceChooseModel paramDatalineDeviceChooseModel, DatalineDeviceChooseModel.DeviceChooseInterface paramDeviceChooseInterface, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantUtilDatalineDeviceChooseModel$DeviceChooseInterface.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      QFileAssistantUtils.a(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantUtilDatalineDeviceChooseModel$DeviceChooseInterface.a();
      if (QLog.isColorLevel())
      {
        QLog.d("DatalineDeviceChooseModel<FileAssistant>.ACT", 2, "onClickSend2Pc");
        continue;
        QFileAssistantUtils.a(1);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantUtilDatalineDeviceChooseModel$DeviceChooseInterface.a();
        if (QLog.isColorLevel()) {
          QLog.d("DatalineDeviceChooseModel<FileAssistant>.ACT", 2, "onClickSend2Pad");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel.2
 * JD-Core Version:    0.7.0.1
 */