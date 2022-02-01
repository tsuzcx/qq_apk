package com.tencent.mobileqq.intervideo.now.webplugin;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.intervideo.now.NowWebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback"}, k=3, mv={1, 1, 16})
final class AudioRoomSettingHandler$handleSetTmpMsgPushSetting$2
  implements TroopMemberApiClient.Callback
{
  AudioRoomSettingHandler$handleSetTmpMsgPushSetting$2(int paramInt, NowWebViewPlugin paramNowWebViewPlugin, String paramString) {}
  
  public final void callback(Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("enable");
    boolean bool2 = paramBundle.getBoolean("success");
    QLog.i("AudioRoomSettingHandler", 1, "handleSetTmpMsgPushSetting: toStatus=" + this.jdField_a_of_type_Int + " result=" + bool2 + " nowStatus=" + bool1);
    NowWebViewPlugin localNowWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowWebViewPlugin;
    String str = this.jdField_a_of_type_JavaLangString;
    JSONObject localJSONObject = new JSONObject();
    if (bool2)
    {
      paramBundle = "success";
      localJSONObject.put("result", paramBundle);
      paramBundle = new JSONObject();
      if (!bool1) {
        break label157;
      }
    }
    label157:
    for (int i = 1;; i = 0)
    {
      paramBundle.put("pushSwitch", i);
      localJSONObject.put("data", paramBundle);
      localNowWebViewPlugin.callJs(str, new String[] { localJSONObject.toString() });
      return;
      paramBundle = "fail";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.webplugin.AudioRoomSettingHandler.handleSetTmpMsgPushSetting.2
 * JD-Core Version:    0.7.0.1
 */