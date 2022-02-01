package com.tencent.mobileqq.filemanager.fileassistant.util;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnDismissListener;

class DatalineDeviceChooseModel$1
  implements ActionSheet.OnDismissListener
{
  DatalineDeviceChooseModel$1(DatalineDeviceChooseModel paramDatalineDeviceChooseModel, DatalineDeviceChooseModel.DeviceChooseInterface paramDeviceChooseInterface) {}
  
  public void onDismiss()
  {
    this.a.c();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineDeviceChooseModel<FileAssistant>.ACT", 2, "dismiss");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel.1
 * JD-Core Version:    0.7.0.1
 */