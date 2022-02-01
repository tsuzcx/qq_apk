package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import bebc;
import bebp;
import bebr;
import bebs;
import bfby;
import bfur;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(bebr parambebr) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_Bebc.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_Bebp.a(this.a.jdField_a_of_type_Bebc, this.a.jdField_a_of_type_Bebp.a.getString(2131697235), this.a.jdField_a_of_type_Bebp.a.getString(2131697236));
      return;
    }
    int i = bebp.a(this.a.jdField_a_of_type_Bebp, false);
    bebs localbebs = new bebs(this);
    if (i == 1) {}
    for (localObject = bebp.a(2131696861, new Object[] { bfby.a(this.a.jdField_a_of_type_Bebc.c), this.a.jdField_a_of_type_Bebc.a() });; localObject = bebp.a(2131697168, new Object[] { bfby.a(this.a.jdField_a_of_type_Bebc.c) }))
    {
      bfur.a(this.a.jdField_a_of_type_Bebp.a, 230, bebp.a(2131697170), (String)localObject, 2131690620, 2131697169, localbebs, localbebs).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */