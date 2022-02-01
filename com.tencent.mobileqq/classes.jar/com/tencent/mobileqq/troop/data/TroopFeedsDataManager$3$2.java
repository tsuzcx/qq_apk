package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

class TroopFeedsDataManager$3$2
  implements Runnable
{
  TroopFeedsDataManager$3$2(TroopFeedsDataManager.3 param3, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_JavaLangLong);
    localObject2 = TroopFeedParserHelper.a((JSONObject)localObject1, ((StringBuilder)localObject2).toString(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject1 = (List)localObject2[0];
    localObject2 = (List)localObject2[1];
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return;
      }
      Object localObject3 = localObject1.toString();
      int i = ((List)localObject1).size() - 1;
      Object localObject4;
      while (i >= 0)
      {
        localObject4 = (String)((List)localObject1).get(i);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject4)) {
          ((List)localObject1).remove(localObject4);
        }
        i -= 1;
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("cgi callback ids, beforeFilter:");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append("|afterFilter ids:");
        ((StringBuilder)localObject4).append(localObject1.toString());
        QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, ((StringBuilder)localObject4).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
      ((Message)localObject3).obj = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.a((List)localObject1, (List)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.2
 * JD-Core Version:    0.7.0.1
 */