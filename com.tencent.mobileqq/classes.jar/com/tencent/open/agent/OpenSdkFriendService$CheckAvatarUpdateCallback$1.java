package com.tencent.open.agent;

import bjet;
import bjeu;
import bjgt;
import bjgw;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkFriendService$CheckAvatarUpdateCallback$1
  implements Runnable
{
  public OpenSdkFriendService$CheckAvatarUpdateCallback$1(bjeu parambjeu, int paramInt, JSONArray paramJSONArray) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_Int) {
        try
        {
          String str = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i).getString("openid");
          str = bjgw.a(this.jdField_a_of_type_Bjeu.a.a, str);
          bjgt.a().a(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback.1
 * JD-Core Version:    0.7.0.1
 */