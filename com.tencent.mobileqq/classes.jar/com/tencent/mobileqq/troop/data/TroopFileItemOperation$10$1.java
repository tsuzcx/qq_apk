package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import ayoq;
import aypd;
import aypf;
import aypg;
import azjg;
import babr;
import bafb;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(aypf paramaypf) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_Ayoq.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_Aypd.a(this.a.jdField_a_of_type_Ayoq, this.a.jdField_a_of_type_Aypd.a.getString(2131632279), this.a.jdField_a_of_type_Aypd.a.getString(2131632280));
      return;
    }
    int i = aypd.a(this.a.jdField_a_of_type_Aypd, false);
    aypg localaypg = new aypg(this);
    if (i == 1) {}
    for (localObject = aypd.a(2131631937, new Object[] { azjg.a(this.a.jdField_a_of_type_Ayoq.c), this.a.jdField_a_of_type_Ayoq.a() });; localObject = aypd.a(2131632216, new Object[] { azjg.a(this.a.jdField_a_of_type_Ayoq.c) }))
    {
      babr.a(this.a.jdField_a_of_type_Aypd.a, 230, aypd.a(2131632218), (String)localObject, 2131625035, 2131632217, localaypg, localaypg).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */