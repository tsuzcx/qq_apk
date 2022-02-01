package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class UiApiPlugin$10
  implements TroopMemberApiClient.Callback
{
  UiApiPlugin$10(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("sayhiinfo");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (TextUtils.isEmpty(paramBundle)) {
        localJSONObject.put("result", "fail");
      }
      for (;;)
      {
        paramBundle = localJSONObject.toString();
        QLog.i("UiApiPlugin", 1, "getTribeSayHelloRedInfo callback result = " + paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
        return;
        localJSONObject.put("result", "success");
        localJSONObject.put("data", new JSONObject(paramBundle));
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      QLog.e("UiApiPlugin", 1, "getTribeSayHelloRedInfo callback Exception:", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.10
 * JD-Core Version:    0.7.0.1
 */