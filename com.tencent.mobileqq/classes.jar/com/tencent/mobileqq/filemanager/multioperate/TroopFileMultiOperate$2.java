package com.tencent.mobileqq.filemanager.multioperate;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

class TroopFileMultiOperate$2
  implements DialogInterface.OnClickListener
{
  TroopFileMultiOperate$2(TroopFileMultiOperate paramTroopFileMultiOperate, List paramList, QFileMultiOperateCallback paramQFileMultiOperateCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.multioperate.TroopFileMultiOperate.2
 * JD-Core Version:    0.7.0.1
 */