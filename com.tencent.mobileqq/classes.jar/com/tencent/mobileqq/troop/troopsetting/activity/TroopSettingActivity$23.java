package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopSettingActivity$23
  implements Runnable
{
  TroopSettingActivity$23(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null)
    {
      if (this.this$0.jdField_a_of_type_AndroidOsHandler == null) {
        return;
      }
      Object localObject1 = null;
      Object localObject2 = TroopSettingActivity.a(this.this$0).getEntityManagerFactory().createEntityManager();
      if (localObject2 != null)
      {
        localObject1 = ((EntityManager)localObject2).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin }, null, null, null, null);
        ((EntityManager)localObject2).close();
      }
      if (localObject1 != null)
      {
        localObject2 = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject1).next();
          if (Utils.d(localTroopMemberInfo.memberuin)) {
            ((ArrayList)localObject2).add(localTroopMemberInfo.memberuin);
          }
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.post(new TroopSettingActivity.23.1(this, (ArrayList)localObject2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.23
 * JD-Core Version:    0.7.0.1
 */