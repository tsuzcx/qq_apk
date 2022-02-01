package com.tencent.mobileqq.intervideo.now.webplugin;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.now.NowWebViewPlugin;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class AudioRoomSettingHandler$2
  implements ITroopMemberApiClientApi.Callback
{
  AudioRoomSettingHandler$2(int paramInt, NowWebViewPlugin paramNowWebViewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("enable");
    Object localObject = "success";
    boolean bool2 = paramBundle.getBoolean("success");
    paramBundle = new StringBuilder();
    paramBundle.append("handleSetTmpMsgPushSetting: toStatus=");
    paramBundle.append(this.jdField_a_of_type_Int);
    paramBundle.append(" result=$isSucceed nowStatus=");
    paramBundle.append(bool1);
    QLog.i("AudioRoomSettingHandler", 1, paramBundle.toString());
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (bool2)
        {
          paramBundle = (Bundle)localObject;
          localJSONObject.put("result", paramBundle);
          paramBundle = new JSONObject();
          if (!bool1) {
            break label199;
          }
          i = 1;
          paramBundle.put("pushSwitch", i);
          localJSONObject.put("data", paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleSetTmpMsgPushSetting catch: ");
        ((StringBuilder)localObject).append(paramBundle.toString());
        QLog.e("AudioRoomSettingHandler", 2, ((StringBuilder)localObject).toString());
        return;
      }
      paramBundle = "fail";
      continue;
      label199:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.webplugin.AudioRoomSettingHandler.2
 * JD-Core Version:    0.7.0.1
 */