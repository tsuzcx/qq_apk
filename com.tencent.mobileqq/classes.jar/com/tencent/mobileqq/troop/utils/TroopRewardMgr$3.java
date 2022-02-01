package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class TroopRewardMgr$3
  implements HttpWebCgiAsyncTask.Callback
{
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("createReward result:");
      paramBundle.append(paramJSONObject);
      QLog.d(".troop.troop_reward", 2, paramBundle.toString());
    }
    TroopRewardMgr.a(this.c, paramJSONObject, this.a);
    paramJSONObject = this.b;
    if (paramJSONObject != null) {
      paramJSONObject.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardMgr.3
 * JD-Core Version:    0.7.0.1
 */