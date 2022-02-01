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
    while (i < this.a)
    {
      try
      {
        String str = this.b.getJSONObject(i).getString("openid");
        str = QZonePortraitData.a(this.c.a.e, str);
        ImageLoader.a().b(str);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback.1
 * JD-Core Version:    0.7.0.1
 */