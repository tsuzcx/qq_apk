package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class UiApiPlugin$10
  implements ITroopMemberApiClientApi.Callback
{
  UiApiPlugin$10(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("sayhiinfo");
    Object localObject = new JSONObject();
    try
    {
      boolean bool = TextUtils.isEmpty(paramBundle);
      if (bool)
      {
        ((JSONObject)localObject).put("result", "fail");
      }
      else
      {
        ((JSONObject)localObject).put("result", "success");
        ((JSONObject)localObject).put("data", new JSONObject(paramBundle));
      }
      paramBundle = ((JSONObject)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTribeSayHelloRedInfo callback result = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("UiApiPlugin", 1, ((StringBuilder)localObject).toString());
      this.b.callJs(this.a, new String[] { paramBundle });
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