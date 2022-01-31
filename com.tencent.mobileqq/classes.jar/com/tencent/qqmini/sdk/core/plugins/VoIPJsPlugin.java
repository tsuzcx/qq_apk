package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import begy;
import begz;
import beiy;
import bejc;
import bejg;
import beka;
import bekg;
import besl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
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
  
  private byte[] getSig(String paramString, bejg parambejg)
  {
    oidb_0xd32.XmitInfo localXmitInfo = new oidb_0xd32.XmitInfo();
    localXmitInfo.str_appid.set(paramString);
    localXmitInfo.str_groupid.set(parambejg.c);
    localXmitInfo.str_nonce.set(parambejg.jdField_b_of_type_JavaLangString);
    localXmitInfo.uint32_timestamp.set(parambejg.jdField_a_of_type_Int);
    localXmitInfo.str_signature.set(parambejg.jdField_a_of_type_JavaLangString);
    return localXmitInfo.toByteArray();
  }
  
  private boolean isRoomConfigValid(bejg parambejg)
  {
    return (!TextUtils.isEmpty(parambejg.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambejg.c)) && (!TextUtils.isEmpty(parambejg.jdField_a_of_type_JavaLangString)) && (parambejg.jdField_a_of_type_Int > 0);
  }
  
  private bejc parseIdResult(JSONObject paramJSONObject)
  {
    return (bejc)new VoIPJsPlugin.JSONParser().parse(paramJSONObject, bejc.class);
  }
  
  private bejg parseRoomConfig(String paramString)
  {
    return (bejg)new VoIPJsPlugin.JSONParser().parse(paramString, bejg.class);
  }
  
  public String exitVoIPChat(beka parambeka)
  {
    beiy.a().a();
    JSONObject localJSONObject = new JSONObject();
    parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, bekg.a(parambeka.jdField_a_of_type_JavaLangString, localJSONObject).toString());
    return "";
  }
  
  public String joinVoIPChat(beka parambeka)
  {
    try
    {
      Object localObject = parseRoomConfig(parambeka.jdField_b_of_type_JavaLangString);
      if (localObject == null)
      {
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "param error").toString());
        return "";
      }
      if (!isRoomConfigValid((bejg)localObject))
      {
        besl.d("[mini] VoIPJsPlugin", "isRoomConfigValid false");
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("errCode", -5);
          parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "invalid parameters").toString());
          return "";
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            besl.d("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
          }
        }
      }
      try
      {
        JSONObject localJSONObject;
        localJSONObject.put("errCode", -1000);
        parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, bekg.a(parambeka.jdField_a_of_type_JavaLangString, localJSONObject, "internal error").toString());
        for (;;)
        {
          return "";
          String str = localJSONObject.c;
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).transForRoomId(this.mMiniAppContext.a().appId, str, new VoIPJsPlugin.2(this, parambeka, localJSONObject));
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          besl.d("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      besl.d("[mini] VoIPJsPlugin", "joinVoIPChat internal error", localThrowable);
      localJSONObject = new JSONObject();
    }
  }
  
  public void onPause()
  {
    JSONObject localJSONObject;
    if (beiy.a().c()) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("errCode", 2);
      localJSONObject.put("errMsg", "进入后台或关闭");
      sendSubscribeEvent("onVoIPChatInterrupted", localJSONObject.toString());
      beiy.a().a();
      beiy.a().a(null);
      super.onPause();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        besl.d("[mini] VoIPJsPlugin", "JSONException", localJSONException);
      }
    }
  }
  
  public String updateVoIPChatMuteConfig(beka parambeka)
  {
    bejg localbejg = parseRoomConfig(parambeka.jdField_b_of_type_JavaLangString);
    JSONObject localJSONObject = new JSONObject();
    if ((localbejg != null) && (localbejg.jdField_a_of_type_Beje != null)) {
      beiy.a().a(localbejg.jdField_a_of_type_Beje, new VoIPJsPlugin.1(this, localJSONObject, parambeka));
    }
    for (;;)
    {
      return "";
      parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, bekg.a(parambeka.jdField_a_of_type_JavaLangString, localJSONObject, "参数错误").toString());
      besl.d("[mini] VoIPJsPlugin", "参数错误 " + parambeka.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin
 * JD-Core Version:    0.7.0.1
 */