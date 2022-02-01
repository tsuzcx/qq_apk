package com.tencent.mobileqq.filemanager.multioperate;

import com.tencent.mobileqq.wifi.FreeWifiDialogListener;
import java.util.List;

class TroopFileMultiOperate$1
  implements FreeWifiDialogListener
{
  TroopFileMultiOperate$1(TroopFileMultiOperate paramTroopFileMultiOperate, List paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      TroopFileMultiOperate.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate, this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback.a(1, 0);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback.a(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.TroopFileMultiOperate.1
 * JD-Core Version:    0.7.0.1
 */