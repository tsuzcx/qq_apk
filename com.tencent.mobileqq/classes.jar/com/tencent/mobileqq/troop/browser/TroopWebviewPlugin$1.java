package com.tencent.mobileqq.troop.browser;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import org.json.JSONException;
import org.json.JSONObject;

class TroopWebviewPlugin$1
  implements ITroopMemberApiClientApi.Callback
{
  TroopWebviewPlugin$1(TroopWebviewPlugin paramTroopWebviewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    long l = paramBundle.getLong("lastMsgTime");
    paramBundle = paramBundle.getString("lastMsgContent");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("lastMsgTime", l);
      localJSONObject.put("lastMsgContent", paramBundle);
      boolean bool = TextUtils.isEmpty(paramBundle);
      if (!bool)
      {
        localJSONObject.put("ret", 0);
        localJSONObject.put("errorMsg", "");
      }
      else
      {
        localJSONObject.put("ret", -1);
        localJSONObject.put("errorMsg", "lastSpeakMsg is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopBrowserTroopWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopWebviewPlugin.1
 * JD-Core Version:    0.7.0.1
 */