package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TroopRewardMgr$3
  implements HttpWebCgiAsyncTask.Callback
{
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "createReward result:" + paramJSONObject);
    }
    TroopRewardMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr, paramJSONObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr$OnCreateRewardListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr$OnCreateRewardListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardMgr.3
 * JD-Core Version:    0.7.0.1
 */