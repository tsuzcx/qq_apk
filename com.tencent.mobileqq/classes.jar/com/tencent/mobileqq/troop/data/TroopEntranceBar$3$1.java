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
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBindPublicAccountMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopEntranceBar$3.a.a.a, 0, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.3.1
 * JD-Core Version:    0.7.0.1
 */