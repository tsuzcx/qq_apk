package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import bbsa;
import bbsn;
import bbsp;
import bbsq;
import bcnt;
import bdgm;
import bdjz;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(bbsp parambbsp) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_Bbsa.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_Bbsn.a(this.a.jdField_a_of_type_Bbsa, this.a.jdField_a_of_type_Bbsn.a.getString(2131698193), this.a.jdField_a_of_type_Bbsn.a.getString(2131698194));
      return;
    }
    int i = bbsn.a(this.a.jdField_a_of_type_Bbsn, false);
    bbsq localbbsq = new bbsq(this);
    if (i == 1) {}
    for (localObject = bbsn.a(2131697829, new Object[] { bcnt.a(this.a.jdField_a_of_type_Bbsa.c), this.a.jdField_a_of_type_Bbsa.a() });; localObject = bbsn.a(2131698130, new Object[] { bcnt.a(this.a.jdField_a_of_type_Bbsa.c) }))
    {
      bdgm.a(this.a.jdField_a_of_type_Bbsn.a, 230, bbsn.a(2131698132), (String)localObject, 2131690648, 2131698131, localbbsq, localbbsq).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */