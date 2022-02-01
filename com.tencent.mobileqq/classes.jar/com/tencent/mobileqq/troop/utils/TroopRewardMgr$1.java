package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TroopRewardMgr$1
  implements HttpWebCgiAsyncTask.Callback
{
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    paramJSONObject = TroopRewardMgr.a(this.d, paramJSONObject);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("payReward rewardId:");
      paramBundle.append(this.a);
      paramBundle.append(",troopUin:");
      paramBundle.append(this.b);
      QLog.d(".troop.troop_reward", 2, paramBundle.toString());
    }
    paramBundle = this.c;
    if (paramBundle != null) {
      paramBundle.a(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardMgr.1
 * JD-Core Version:    0.7.0.1
 */