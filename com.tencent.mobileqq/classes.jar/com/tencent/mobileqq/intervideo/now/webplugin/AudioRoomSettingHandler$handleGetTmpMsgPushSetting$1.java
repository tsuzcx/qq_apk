package com.tencent.mobileqq.intervideo.now.webplugin;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.intervideo.now.NowWebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback"}, k=3, mv={1, 1, 16})
final class AudioRoomSettingHandler$handleGetTmpMsgPushSetting$1
  implements TroopMemberApiClient.Callback
{
  AudioRoomSettingHandler$handleGetTmpMsgPushSetting$1(NowWebViewPlugin paramNowWebViewPlugin, String paramString) {}
  
  public final void callback(Bundle paramBundle)
  {
    int i = 1;
    boolean bool = paramBundle.getBoolean("enable");
    QLog.i("AudioRoomSettingHandler", 1, "handleGetTmpMsgPushSetting: nowStatus=" + bool);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowWebViewPlugin;
    String str = this.jdField_a_of_type_JavaLangString;
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("result", "success");
    JSONObject localJSONObject2 = new JSONObject();
    if (bool) {}
    for (;;)
    {
      localJSONObject2.put("pushSwitch", i);
      localJSONObject1.put("data", localJSONObject2);
      paramBundle.callJs(str, new String[] { localJSONObject1.toString() });
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.webplugin.AudioRoomSettingHandler.handleGetTmpMsgPushSetting.1
 * JD-Core Version:    0.7.0.1
 */