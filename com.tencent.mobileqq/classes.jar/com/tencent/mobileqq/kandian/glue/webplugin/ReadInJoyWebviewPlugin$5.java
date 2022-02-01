package com.tencent.mobileqq.kandian.glue.webplugin;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebviewPlugin$5
  implements ITroopMemberApiClientApi.Callback
{
  ReadInJoyWebviewPlugin$5(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (QLog.isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive notifyLoadSkin callback resp:");
      ((StringBuilder)localObject).append(paramBundle.toString());
      QLog.d("ReadInJoyWebviewPlugin", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    try
    {
      localObject = ((JSONObject)localObject).put("retCode", paramBundle.getInt("retCode"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBundle.getString("skinId"));
      paramBundle = ((JSONObject)localObject).put("skinId", localStringBuilder.toString()).put("rate", paramBundle.getInt("rate"));
      this.b.callJs(this.a, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyLoadSkin error ");
      ((StringBuilder)localObject).append(paramBundle.toString());
      QLog.w("ReadInJoyWebviewPlugin", 1, ((StringBuilder)localObject).toString());
      this.b.callJs(this.a, new String[] { "{\"retCode\":-1}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin.5
 * JD-Core Version:    0.7.0.1
 */