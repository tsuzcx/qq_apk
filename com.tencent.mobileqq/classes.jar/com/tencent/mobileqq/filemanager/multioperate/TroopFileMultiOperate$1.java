package com.tencent.mobileqq.filemanager.multioperate;

import com.tencent.mobileqq.wifi.FreeWifiHelper.FreeWifiDialogListener;
import java.util.List;

class TroopFileMultiOperate$1
  implements FreeWifiHelper.FreeWifiDialogListener
{
  TroopFileMultiOperate$1(TroopFileMultiOperate paramTroopFileMultiOperate, List paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void a(int paramInt)
  {
    QFileMultiOperateCallback localQFileMultiOperateCallback;
    if (paramInt == 2)
    {
      TroopFileMultiOperate.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate, this.jdField_a_of_type_JavaUtilList);
      localQFileMultiOperateCallback = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback;
      if (localQFileMultiOperateCallback != null) {
        localQFileMultiOperateCallback.a(1, 0);
      }
    }
    else
    {
      localQFileMultiOperateCallback = this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateQFileMultiOperateCallback;
      if (localQFileMultiOperateCallback != null) {
        localQFileMultiOperateCallback.a(1, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.TroopFileMultiOperate.1
 * JD-Core Version:    0.7.0.1
 */