package com.tencent.mobileqq.kandian.glue.webplugin;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebviewPlugin$3
  implements ITroopMemberApiClientApi.Callback
{
  ReadInJoyWebviewPlugin$3(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("ALD_CONFIG_RESULT", "");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", paramBundle);
    }
    catch (JSONException localJSONException)
    {
      label28:
      StringBuilder localStringBuilder;
      break label28;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error in value:");
      localStringBuilder.append(paramBundle);
      QLog.e("ReadInJoyWebviewPlugin", 2, localStringBuilder.toString());
    }
    this.b.callJs(this.a, new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin.3
 * JD-Core Version:    0.7.0.1
 */