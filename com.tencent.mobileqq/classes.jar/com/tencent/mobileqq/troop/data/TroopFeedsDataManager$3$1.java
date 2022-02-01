package com.tencent.mobileqq.troop.data;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import org.json.JSONObject;

class TroopFeedsDataManager$3$1
  implements Runnable
{
  TroopFeedsDataManager$3$1(TroopFeedsDataManager.3 param3, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_JavaLangLong);
    localObject2 = TroopFeedParserHelper.a((JSONObject)localObject1, ((StringBuilder)localObject2).toString(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject1 = (List)localObject2[0];
    localObject2 = (List)localObject2[1];
    ((List)localObject2).addAll(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_JavaUtilList);
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.a((List)localObject1, (List)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$3.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.1
 * JD-Core Version:    0.7.0.1
 */