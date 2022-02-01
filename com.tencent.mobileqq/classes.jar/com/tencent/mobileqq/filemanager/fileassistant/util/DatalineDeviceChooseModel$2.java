package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DatalineDeviceChooseModel$2
  implements ActionSheet.OnButtonClickListener
{
  DatalineDeviceChooseModel$2(DatalineDeviceChooseModel paramDatalineDeviceChooseModel, DatalineDeviceChooseModel.DeviceChooseInterface paramDeviceChooseInterface, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        this.a.c();
      }
      else
      {
        QFileAssistantUtils.b(1);
        this.a.a();
        if (QLog.isColorLevel()) {
          QLog.d("DatalineDeviceChooseModel<FileAssistant>.ACT", 2, "onClickSend2Pad");
        }
      }
    }
    else
    {
      QFileAssistantUtils.b(0);
      this.a.a();
      if (QLog.isColorLevel()) {
        QLog.d("DatalineDeviceChooseModel<FileAssistant>.ACT", 2, "onClickSend2Pc");
      }
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel.2
 * JD-Core Version:    0.7.0.1
 */