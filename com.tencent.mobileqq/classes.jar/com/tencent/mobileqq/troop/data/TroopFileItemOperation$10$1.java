package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import bbnr;
import bboe;
import bbog;
import bboh;
import bcjk;
import bdcd;
import bdfq;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(bbog parambbog) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_Bbnr.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_Bboe.a(this.a.jdField_a_of_type_Bbnr, this.a.jdField_a_of_type_Bboe.a.getString(2131698191), this.a.jdField_a_of_type_Bboe.a.getString(2131698192));
      return;
    }
    int i = bboe.a(this.a.jdField_a_of_type_Bboe, false);
    bboh localbboh = new bboh(this);
    if (i == 1) {}
    for (localObject = bboe.a(2131697827, new Object[] { bcjk.a(this.a.jdField_a_of_type_Bbnr.c), this.a.jdField_a_of_type_Bbnr.a() });; localObject = bboe.a(2131698128, new Object[] { bcjk.a(this.a.jdField_a_of_type_Bbnr.c) }))
    {
      bdcd.a(this.a.jdField_a_of_type_Bboe.a, 230, bboe.a(2131698130), (String)localObject, 2131690648, 2131698129, localbboh, localbboh).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */