package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopFileItemOperation$10$1
  implements Runnable
{
  TroopFileItemOperation$10$1(TroopFileItemOperation.10 param10) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a.getString(2131697772), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a.getString(2131697773));
      return;
    }
    int i = TroopFileItemOperation.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation, false);
    TroopFileItemOperation.10.1.1 local1 = new TroopFileItemOperation.10.1.1(this);
    if (i == 1) {
      localObject = TroopFileItemOperation.a(2131697402, new Object[] { TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c), this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a() });
    } else {
      localObject = TroopFileItemOperation.a(2131697705, new Object[] { TroopFileUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.c) });
    }
    DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a, 230, TroopFileItemOperation.a(2131697707), (String)localObject, 2131690728, 2131697706, local1, local1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */