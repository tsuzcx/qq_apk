package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import org.json.JSONObject;

class TroopEntranceBar$3$1
  implements HttpWebCgiAsyncTask.Callback
{
  TroopEntranceBar$3$1(TroopEntranceBar.3 param3, TroopBindPublicAccountMgr paramTroopBindPublicAccountMgr, int paramInt) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode", -1) == 0)) {
      this.a.a(this.c.b.c.b, 0, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.3.1
 * JD-Core Version:    0.7.0.1
 */