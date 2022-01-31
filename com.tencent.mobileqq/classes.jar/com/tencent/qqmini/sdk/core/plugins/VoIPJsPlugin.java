package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bghn;
import bgho;
import bgkd;
import bgki;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.IdResult;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.RoomConfig;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xd32.XmitInfo;

public class VoIPJsPlugin
  extends BaseJsPlugin
{
  private static final String API_EXIT_VOIP_CHAT = "exitVoIPChat";
  private static final String API_JOIN_VOIP_CHAT = "joinVoIPChat";
  private static final String API_ON_VOIP_CHAT_INTERRUPTED = "onVoIPChatInterrupted";
  private static final String API_ON_VOIP_CHAT_MEMBER_CHANGED = "onVoIPChatMembersChanged";
  private static final String API_ON_VOIP_CHAT_SPEAKERS_CHANGED = "onVoIPChatSpeakersChanged";
  private static final String API_UPDATE_VOIP_CHAT_MUTE_CONFIG = "updateVoIPChatMuteConfig";
  public static final String TAG = "[mini] VoIPJsPlugin";
  
  private byte[] getSig(String paramString, VoIPManager.RoomConfig paramRoomConfig)
  {
    oidb_0xd32.XmitInfo localXmitInfo = new oidb_0xd32.XmitInfo();
    localXmitInfo.str_appid.set(paramString);
    localXmitInfo.str_groupid.set(paramRoomConfig.groupId);
    localXmitInfo.str_nonce.set(paramRoomConfig.nonceStr);
    localXmitInfo.uint32_timestamp.set(paramRoomConfig.timeStamp);
    localXmitInfo.str_signature.set(paramRoomConfig.signature);
    return localXmitInfo.toByteArray();
  }
  
  private boolean isRoomConfigValid(VoIPManager.RoomConfig paramRoomConfig)
  {
    return (!TextUtils.isEmpty(paramRoomConfig.nonceStr)) && (!TextUtils.isEmpty(paramRoomConfig.groupId)) && (!TextUtils.isEmpty(paramRoomConfig.signature)) && (paramRoomConfig.timeStamp > 0);
  }
  
  private VoIPManager.IdResult parseIdResult(JSONObject paramJSONObject)
  {
    return (VoIPManager.IdResult)new VoIPJsPlugin.JSONParser().parse(paramJSONObject, VoIPManager.IdResult.class);
  }
  
  private VoIPManager.RoomConfig parseRoomConfig(String paramString)
  {
    return (VoIPManager.RoomConfig)new VoIPJsPlugin.JSONParser().parse(paramString, VoIPManager.RoomConfig.class);
  }
  
  public String exitVoIPChat(bgkd parambgkd)
  {
    VoIPManager.getInstance().exitRoom();
    JSONObject localJSONObject = new JSONObject();
    parambgkd.jdField_a_of_type_Bghn.a(parambgkd.jdField_b_of_type_Int, bgki.a(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject).toString());
    return "";
  }
  
  public String joinVoIPChat(bgkd parambgkd)
  {
    try
    {
      Object localObject = parseRoomConfig(parambgkd.jdField_b_of_type_JavaLangString);
      if (localObject == null)
      {
        parambgkd.jdField_a_of_type_Bghn.a(parambgkd.jdField_b_of_type_Int, bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null, "param error").toString());
        return "";
      }
      if (!isRoomConfigValid((VoIPManager.RoomConfig)localObject))
      {
        QMLog.e("[mini] VoIPJsPlugin", "isRoomConfigValid false");
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("errCode", -5);
          parambgkd.jdField_a_of_type_Bghn.a(parambgkd.jdField_b_of_type_Int, bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null, "invalid parameters").toString());
          return "";
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
          }
        }
      }
      try
      {
        JSONObject localJSONObject;
        localJSONObject.put("errCode", -1000);
        parambgkd.jdField_a_of_type_Bghn.a(parambgkd.jdField_b_of_type_Int, bgki.a(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject, "internal error").toString());
        for (;;)
        {
          return "";
          String str = localJSONObject.groupId;
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).transForRoomId(this.mMiniAppContext.a().appId, str, new VoIPJsPlugin.2(this, parambgkd, localJSONObject));
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] VoIPJsPlugin", "joinVoIPChat internal error", localThrowable);
      localJSONObject = new JSONObject();
    }
  }
  
  public void onPause()
  {
    JSONObject localJSONObject;
    if (VoIPManager.getInstance().isInRoom()) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("errCode", 2);
      localJSONObject.put("errMsg", "进入后台或关闭");
      sendSubscribeEvent("onVoIPChatInterrupted", localJSONObject.toString());
      VoIPManager.getInstance().exitRoom();
      VoIPManager.getInstance().setEventListener(null);
      super.onPause();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException);
      }
    }
  }
  
  public String updateVoIPChatMuteConfig(bgkd parambgkd)
  {
    VoIPManager.RoomConfig localRoomConfig = parseRoomConfig(parambgkd.jdField_b_of_type_JavaLangString);
    JSONObject localJSONObject = new JSONObject();
    if ((localRoomConfig != null) && (localRoomConfig.muteConfig != null)) {
      VoIPManager.getInstance().updateMuteConfig(localRoomConfig.muteConfig, new VoIPJsPlugin.1(this, localJSONObject, parambgkd));
    }
    for (;;)
    {
      return "";
      parambgkd.jdField_a_of_type_Bghn.a(parambgkd.jdField_b_of_type_Int, bgki.a(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject, "参数错误").toString());
      QMLog.e("[mini] VoIPJsPlugin", "参数错误 " + parambgkd.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin
 * JD-Core Version:    0.7.0.1
 */