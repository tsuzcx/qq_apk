package com.tencent.mobileqq.nearby.gameroom;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class GameRoomInviteActivity$21
  implements HttpWebCgiAsyncTask.Callback
{
  GameRoomInviteActivity$21(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      paramInt = paramJSONObject.optInt("retcode", -1);
      paramBundle = new ArrayList();
      if (paramInt == 0)
      {
        paramJSONObject = paramJSONObject.optJSONObject("data");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optJSONArray("rpt_board_items");
          if (paramJSONObject != null)
          {
            paramInt = 0;
            while (paramInt < paramJSONObject.length())
            {
              paramBundle.add(paramJSONObject.optJSONObject(paramInt).optString("uint64_uin"));
              paramInt += 1;
            }
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomWerewolvesDataManager.a(this.a.b, "" + this.a.jdField_a_of_type_Long, paramBundle, new GameRoomInviteActivity.21.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.21
 * JD-Core Version:    0.7.0.1
 */