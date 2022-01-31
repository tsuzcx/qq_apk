package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import azpi;
import azpv;
import azpx;
import azpy;
import bakx;
import bbdj;
import bbgu;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(azpx paramazpx) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_Azpi.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_Azpv.a(this.a.jdField_a_of_type_Azpi, this.a.jdField_a_of_type_Azpv.a.getString(2131698014), this.a.jdField_a_of_type_Azpv.a.getString(2131698015));
      return;
    }
    int i = azpv.a(this.a.jdField_a_of_type_Azpv, false);
    azpy localazpy = new azpy(this);
    if (i == 1) {}
    for (localObject = azpv.a(2131697652, new Object[] { bakx.a(this.a.jdField_a_of_type_Azpi.c), this.a.jdField_a_of_type_Azpi.a() });; localObject = azpv.a(2131697951, new Object[] { bakx.a(this.a.jdField_a_of_type_Azpi.c) }))
    {
      bbdj.a(this.a.jdField_a_of_type_Azpv.a, 230, azpv.a(2131697953), (String)localObject, 2131690596, 2131697952, localazpy, localazpy).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */