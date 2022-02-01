package com.tencent.mobileqq.relationx.batchAdd;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopAddFrd.Scene;
import mqq.app.AppRuntime;

final class BatchAddFriendData$1
  implements Runnable
{
  BatchAddFriendData$1(int paramInt, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    String str1 = Scene.a(false, this.jdField_a_of_type_Int);
    Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject1 = ((TroopManager)localObject2).b(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        ((TroopInfo)localObject1).wClickBAFTipCount += 1;
        ((TroopManager)localObject2).b((TroopInfo)localObject1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str2 = this.jdField_a_of_type_JavaLangString;
        if (((TroopInfo)localObject1).wInsertBAFTipCount == 1) {
          localObject1 = "0";
        } else {
          localObject1 = "1";
        }
        ReportController.b((AppRuntime)localObject2, "dc00899", "Grp_addFrd", "", "Grp_AIO", str1, 0, 0, str2, (String)localObject1, "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", str1, 0, 0, this.jdField_a_of_type_JavaLangString, "0", Integer.toString(((TroopInfo)localObject1).wMemberNum), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData.1
 * JD-Core Version:    0.7.0.1
 */