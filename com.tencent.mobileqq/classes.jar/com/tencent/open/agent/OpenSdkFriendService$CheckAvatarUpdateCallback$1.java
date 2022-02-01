package com.tencent.open.agent;

import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OpenSdkFriendService$CheckAvatarUpdateCallback$1
  implements Runnable
{
  OpenSdkFriendService$CheckAvatarUpdateCallback$1(OpenSdkFriendService.CheckAvatarUpdateCallback paramCheckAvatarUpdateCallback, int paramInt, JSONArray paramJSONArray) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_Int) {
        try
        {
          String str = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i).getString("openid");
          str = QZonePortraitData.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$CheckAvatarUpdateCallback.a.a, str);
          ImageLoader.a().a(str);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback.1
 * JD-Core Version:    0.7.0.1
 */