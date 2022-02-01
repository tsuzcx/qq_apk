package com.tencent.mobileqq.intervideo.now.webplugin;

import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.intervideo.now.NowWebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioRoomSettingHandler
{
  private static void a(NowWebViewPlugin paramNowWebViewPlugin, JSONObject paramJSONObject, String paramString)
  {
    paramNowWebViewPlugin.a().a((short)-23161, new AudioRoomSettingHandler.1(paramNowWebViewPlugin, paramString));
  }
  
  public static void a(NowWebViewPlugin paramNowWebViewPlugin, String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      String str = paramArrayOfString.optString("callback");
      int i = paramArrayOfString.optInt("act", -1);
      if (i != 1)
      {
        if (i != 2)
        {
          paramNowWebViewPlugin = new StringBuilder();
          paramNowWebViewPlugin.append("unknown action: ");
          paramNowWebViewPlugin.append(i);
          QLog.w("AudioRoomSettingHandler", 1, paramNowWebViewPlugin.toString());
          return;
        }
        b(paramNowWebViewPlugin, paramArrayOfString, str);
        return;
      }
      a(paramNowWebViewPlugin, paramArrayOfString, str);
      return;
    }
    catch (Exception paramNowWebViewPlugin)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("handleRequest catch: ");
      paramArrayOfString.append(paramNowWebViewPlugin.toString());
      QLog.w("AudioRoomSettingHandler", 1, paramArrayOfString.toString());
    }
  }
  
  private static void b(NowWebViewPlugin paramNowWebViewPlugin, JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("pushSwitch", -1);
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("handleSetTmpMsgPushSetting request: toStatus=");
    paramJSONObject.append(i);
    QLog.i("AudioRoomSettingHandler", 1, paramJSONObject.toString());
    boolean bool = false;
    if ((i != 0) && (i != 1)) {
      try
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("result", "fail");
        paramNowWebViewPlugin.callJs(paramString, new String[] { paramJSONObject.toString() });
        return;
      }
      catch (JSONException paramNowWebViewPlugin)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("handleSetTmpMsgPushSetting catch: ");
        paramJSONObject.append(paramNowWebViewPlugin.toString());
        QLog.e("AudioRoomSettingHandler", 2, paramJSONObject.toString());
        return;
      }
    }
    paramJSONObject = paramNowWebViewPlugin.a();
    if (i == 1) {
      bool = true;
    }
    paramJSONObject.a((short)-23161, bool, new AudioRoomSettingHandler.2(i, paramNowWebViewPlugin, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.webplugin.AudioRoomSettingHandler
 * JD-Core Version:    0.7.0.1
 */