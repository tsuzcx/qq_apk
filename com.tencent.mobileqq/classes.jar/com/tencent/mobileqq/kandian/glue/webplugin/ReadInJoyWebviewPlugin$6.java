package com.tencent.mobileqq.kandian.glue.webplugin;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebviewPlugin$6
  implements ITroopMemberApiClientApi.Callback
{
  ReadInJoyWebviewPlugin$6(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive readSkinAndSound callback resp:");
    ((StringBuilder)localObject).append(paramBundle.toString());
    QLog.d("ReadInJoyWebviewPlugin", 4, ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      paramBundle = ((JSONObject)localObject).put("retCode", paramBundle.getInt("retCode")).put("skinId", paramBundle.getString("skinId")).put("volumeIsOn", paramBundle.getInt("volumeIsOn"));
      this.b.callJs(this.a, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readSkinAndSound error ");
      ((StringBuilder)localObject).append(paramBundle.toString());
      QLog.w("ReadInJoyWebviewPlugin", 1, ((StringBuilder)localObject).toString());
      this.b.callJs(this.a, new String[] { "{\"retCode\":-1}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin.6
 * JD-Core Version:    0.7.0.1
 */