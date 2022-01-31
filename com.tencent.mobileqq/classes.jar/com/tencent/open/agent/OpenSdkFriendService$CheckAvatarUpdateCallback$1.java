package com.tencent.open.agent;

import bdcj;
import bdck;
import bddz;
import bdec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkFriendService$CheckAvatarUpdateCallback$1
  implements Runnable
{
  public OpenSdkFriendService$CheckAvatarUpdateCallback$1(bdck parambdck, int paramInt, JSONArray paramJSONArray) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_Int) {
        try
        {
          String str = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i).getString("openid");
          str = bdec.a(this.jdField_a_of_type_Bdck.a.a, str);
          bddz.a().a(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback.1
 * JD-Core Version:    0.7.0.1
 */