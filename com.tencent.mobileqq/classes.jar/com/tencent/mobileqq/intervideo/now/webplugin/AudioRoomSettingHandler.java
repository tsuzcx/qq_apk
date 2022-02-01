package com.tencent.mobileqq.intervideo.now.webplugin;

import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.intervideo.now.NowWebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/intervideo/now/webplugin/AudioRoomSettingHandler;", "", "()V", "ACT_GET_TMP_MSG_PUSH_SETTING", "", "ACT_SET_TMP_MSG_PUSH_SETTING", "TAG", "", "handleGetTmpMsgPushSetting", "", "plugin", "Lcom/tencent/mobileqq/intervideo/now/NowWebViewPlugin;", "reqJson", "Lorg/json/JSONObject;", "callback", "handleRequest", "args", "", "(Lcom/tencent/mobileqq/intervideo/now/NowWebViewPlugin;[Ljava/lang/String;)V", "handleSetTmpMsgPushSetting", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AudioRoomSettingHandler
{
  public static final AudioRoomSettingHandler a = new AudioRoomSettingHandler();
  
  private final void a(NowWebViewPlugin paramNowWebViewPlugin, JSONObject paramJSONObject, String paramString)
  {
    paramNowWebViewPlugin.a().a((short)-23161, (TroopMemberApiClient.Callback)new AudioRoomSettingHandler.handleGetTmpMsgPushSetting.1(paramNowWebViewPlugin, paramString));
  }
  
  @JvmStatic
  public static final void a(@NotNull NowWebViewPlugin paramNowWebViewPlugin, @NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramNowWebViewPlugin, "plugin");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "args");
    for (;;)
    {
      String str;
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        str = paramArrayOfString.optString("callback");
        int i = paramArrayOfString.optInt("act", -1);
        switch (i)
        {
        case 1: 
          QLog.w("AudioRoomSettingHandler", 1, "unknown action: " + i);
          return;
        }
      }
      catch (Exception paramNowWebViewPlugin)
      {
        QLog.w("AudioRoomSettingHandler", 1, "handleRequest catch: " + paramNowWebViewPlugin);
        return;
      }
      AudioRoomSettingHandler localAudioRoomSettingHandler = a;
      Intrinsics.checkExpressionValueIsNotNull(str, "callback");
      localAudioRoomSettingHandler.a(paramNowWebViewPlugin, paramArrayOfString, str);
      return;
      localAudioRoomSettingHandler = a;
      Intrinsics.checkExpressionValueIsNotNull(str, "callback");
      localAudioRoomSettingHandler.b(paramNowWebViewPlugin, paramArrayOfString, str);
      return;
    }
  }
  
  private final void b(NowWebViewPlugin paramNowWebViewPlugin, JSONObject paramJSONObject, String paramString)
  {
    boolean bool = false;
    int i = paramJSONObject.optInt("pushSwitch", -1);
    QLog.i("AudioRoomSettingHandler", 1, "handleSetTmpMsgPushSetting request: toStatus=" + i);
    if ((i != 0) && (i != 1))
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", "fail");
      paramNowWebViewPlugin.callJs(paramString, new String[] { paramJSONObject.toString() });
      return;
    }
    paramJSONObject = paramNowWebViewPlugin.a();
    if (i == 1) {
      bool = true;
    }
    paramJSONObject.a((short)-23161, bool, (TroopMemberApiClient.Callback)new AudioRoomSettingHandler.handleSetTmpMsgPushSetting.2(i, paramNowWebViewPlugin, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.webplugin.AudioRoomSettingHandler
 * JD-Core Version:    0.7.0.1
 */