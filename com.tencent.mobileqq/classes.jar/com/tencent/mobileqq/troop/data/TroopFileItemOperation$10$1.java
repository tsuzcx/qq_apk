package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import bfif;
import bfis;
import bfiu;
import bfiv;
import bgke;
import bhdj;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class TroopFileItemOperation$10$1
  implements Runnable
{
  public TroopFileItemOperation$10$1(bfiu parambfiu) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.a.jdField_a_of_type_Bfif.a);
    if ((localObject != null) && (((TroopFileTransferManager.Item)localObject).ErrorCode == -136))
    {
      this.a.jdField_a_of_type_Bfis.a(this.a.jdField_a_of_type_Bfif, this.a.jdField_a_of_type_Bfis.a.getString(2131697512), this.a.jdField_a_of_type_Bfis.a.getString(2131697513));
      return;
    }
    int i = bfis.a(this.a.jdField_a_of_type_Bfis, false);
    bfiv localbfiv = new bfiv(this);
    if (i == 1) {}
    for (localObject = bfis.a(2131697129, new Object[] { bgke.a(this.a.jdField_a_of_type_Bfif.c), this.a.jdField_a_of_type_Bfif.a() });; localObject = bfis.a(2131697445, new Object[] { bgke.a(this.a.jdField_a_of_type_Bfif.c) }))
    {
      bhdj.a(this.a.jdField_a_of_type_Bfis.a, 230, bfis.a(2131697447), (String)localObject, 2131690697, 2131697446, localbfiv, localbfiv).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.10.1
 * JD-Core Version:    0.7.0.1
 */