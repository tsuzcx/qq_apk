package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import bfrs;
import bfsf;
import bfsh;
import bfsi;
import bgsk;
import bhlq;
import bhpc;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(bfsh parambfsh) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_Bfrs.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_Bfsf.a(this.a.jdField_a_of_type_Bfrs, this.a.jdField_a_of_type_Bfsf.a.getString(2131697093), this.a.jdField_a_of_type_Bfsf.a.getString(2131697094));
      return;
    }
    int i = bfsf.a(this.a.jdField_a_of_type_Bfsf, false);
    bfsi localbfsi = new bfsi(this);
    if (i == 1) {}
    for (localObject = bfsf.a(2131696720, new Object[] { bgsk.a(this.a.jdField_a_of_type_Bfrs.c), this.a.jdField_a_of_type_Bfrs.a() });; localObject = bfsf.a(2131697026, new Object[] { bgsk.a(this.a.jdField_a_of_type_Bfrs.c) }))
    {
      bhlq.a(this.a.jdField_a_of_type_Bfsf.a, 230, bfsf.a(2131697028), (String)localObject, 2131690580, 2131697027, localbfsi, localbfsi).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */