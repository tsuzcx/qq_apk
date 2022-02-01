package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import besl;
import besy;
import beta;
import betb;
import bfsj;
import bglp;
import bgpa;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(beta parambeta) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_Besl.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_Besy.a(this.a.jdField_a_of_type_Besl, this.a.jdField_a_of_type_Besy.a.getString(2131697044), this.a.jdField_a_of_type_Besy.a.getString(2131697045));
      return;
    }
    int i = besy.a(this.a.jdField_a_of_type_Besy, false);
    betb localbetb = new betb(this);
    if (i == 1) {}
    for (localObject = besy.a(2131696671, new Object[] { bfsj.a(this.a.jdField_a_of_type_Besl.c), this.a.jdField_a_of_type_Besl.a() });; localObject = besy.a(2131696977, new Object[] { bfsj.a(this.a.jdField_a_of_type_Besl.c) }))
    {
      bglp.a(this.a.jdField_a_of_type_Besy.a, 230, besy.a(2131696979), (String)localObject, 2131690582, 2131696978, localbetb, localbetb).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */