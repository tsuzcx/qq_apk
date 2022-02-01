package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TroopRewardMgr$1
  implements HttpWebCgiAsyncTask.Callback
{
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    paramJSONObject = TroopRewardMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr, paramJSONObject);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "payReward rewardId:" + this.jdField_a_of_type_JavaLangString + ",troopUin:" + this.b);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr$OnPayRewardListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr$OnPayRewardListener.a(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardMgr.1
 * JD-Core Version:    0.7.0.1
 */