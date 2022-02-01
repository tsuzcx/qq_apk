package com.tencent.mobileqq.kandian.glue.webplugin;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebviewPlugin$1
  implements ITroopMemberApiClientApi.Callback
{
  ReadInJoyWebviewPlugin$1(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    String str = paramBundle.getString("key_emotion_data", "");
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("emotionData", str);
    }
    catch (JSONException localJSONException)
    {
      QLog.w("ReadInJoyWebviewPlugin", 4, localJSONException.getMessage());
    }
    this.b.callJs(this.a, new String[] { paramBundle.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin.1
 * JD-Core Version:    0.7.0.1
 */