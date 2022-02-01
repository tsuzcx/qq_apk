package com.tencent.mobileqq.intervideo.now.webplugin;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.now.NowWebViewPlugin;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class AudioRoomSettingHandler$1
  implements ITroopMemberApiClientApi.Callback
{
  AudioRoomSettingHandler$1(NowWebViewPlugin paramNowWebViewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("enable");
    paramBundle = new StringBuilder();
    paramBundle.append("handleGetTmpMsgPushSetting: nowStatus=");
    paramBundle.append(bool);
    QLog.i("AudioRoomSettingHandler", 1, paramBundle.toString());
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject();
        paramBundle.put("result", "success");
        localObject = new JSONObject();
        if (bool)
        {
          i = 1;
          ((JSONObject)localObject).put("pushSwitch", i);
          paramBundle.put("data", localObject);
          this.a.callJs(this.b, new String[] { paramBundle.toString() });
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetTmpMsgPushSetting catch: ");
        ((StringBuilder)localObject).append(paramBundle.toString());
        QLog.e("AudioRoomSettingHandler", 2, ((StringBuilder)localObject).toString());
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.webplugin.AudioRoomSettingHandler.1
 * JD-Core Version:    0.7.0.1
 */