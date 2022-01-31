package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import azpg;
import azpt;
import azpv;
import azpw;
import bakj;
import bbcv;
import bbgg;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(azpv paramazpv) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_Azpg.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_Azpt.a(this.a.jdField_a_of_type_Azpg, this.a.jdField_a_of_type_Azpt.a.getString(2131698004), this.a.jdField_a_of_type_Azpt.a.getString(2131698005));
      return;
    }
    int i = azpt.a(this.a.jdField_a_of_type_Azpt, false);
    azpw localazpw = new azpw(this);
    if (i == 1) {}
    for (localObject = azpt.a(2131697651, new Object[] { bakj.a(this.a.jdField_a_of_type_Azpg.c), this.a.jdField_a_of_type_Azpg.a() });; localObject = azpt.a(2131697941, new Object[] { bakj.a(this.a.jdField_a_of_type_Azpg.c) }))
    {
      bbcv.a(this.a.jdField_a_of_type_Azpt.a, 230, azpt.a(2131697943), (String)localObject, 2131690596, 2131697942, localazpw, localazpw).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */