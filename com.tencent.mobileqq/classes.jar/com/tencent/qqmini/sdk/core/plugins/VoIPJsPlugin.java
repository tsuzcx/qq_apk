package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdcy;
import bdcz;
import bdey;
import bdfc;
import bdfg;
import bdfz;
import bdgg;
import bdnw;
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
  
  private byte[] getSig(String paramString, bdfg parambdfg)
  {
    oidb_0xd32.XmitInfo localXmitInfo = new oidb_0xd32.XmitInfo();
    localXmitInfo.str_appid.set(paramString);
    localXmitInfo.str_groupid.set(parambdfg.c);
    localXmitInfo.str_nonce.set(parambdfg.jdField_b_of_type_JavaLangString);
    localXmitInfo.uint32_timestamp.set(parambdfg.jdField_a_of_type_Int);
    localXmitInfo.str_signature.set(parambdfg.jdField_a_of_type_JavaLangString);
    return localXmitInfo.toByteArray();
  }
  
  private boolean isRoomConfigValid(bdfg parambdfg)
  {
    return (!TextUtils.isEmpty(parambdfg.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambdfg.c)) && (!TextUtils.isEmpty(parambdfg.jdField_a_of_type_JavaLangString)) && (parambdfg.jdField_a_of_type_Int > 0);
  }
  
  private bdfc parseIdResult(JSONObject paramJSONObject)
  {
    return (bdfc)new VoIPJsPlugin.JSONParser().parse(paramJSONObject, bdfc.class);
  }
  
  private bdfg parseRoomConfig(String paramString)
  {
    return (bdfg)new VoIPJsPlugin.JSONParser().parse(paramString, bdfg.class);
  }
  
  public String exitVoIPChat(bdfz parambdfz)
  {
    bdey.a().a();
    JSONObject localJSONObject = new JSONObject();
    parambdfz.jdField_a_of_type_Bdcy.a(parambdfz.jdField_b_of_type_Int, bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, localJSONObject).toString());
    return "";
  }
  
  public String joinVoIPChat(bdfz parambdfz)
  {
    try
    {
      Object localObject = parseRoomConfig(parambdfz.jdField_b_of_type_JavaLangString);
      if (localObject == null)
      {
        parambdfz.jdField_a_of_type_Bdcy.a(parambdfz.jdField_b_of_type_Int, bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "param error").toString());
        return "";
      }
      if (!isRoomConfigValid((bdfg)localObject))
      {
        bdnw.d("[mini] VoIPJsPlugin", "isRoomConfigValid false");
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("errCode", -5);
          parambdfz.jdField_a_of_type_Bdcy.a(parambdfz.jdField_b_of_type_Int, bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "invalid parameters").toString());
          return "";
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            bdnw.d("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
          }
        }
      }
      try
      {
        JSONObject localJSONObject;
        localJSONObject.put("errCode", -1000);
        parambdfz.jdField_a_of_type_Bdcy.a(parambdfz.jdField_b_of_type_Int, bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, localJSONObject, "internal error").toString());
        for (;;)
        {
          return "";
          String str = localJSONObject.c;
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).transForRoomId(this.mMiniAppContext.a().appId, str, new VoIPJsPlugin.2(this, parambdfz, localJSONObject));
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          bdnw.d("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("[mini] VoIPJsPlugin", "joinVoIPChat internal error", localThrowable);
      localJSONObject = new JSONObject();
    }
  }
  
  public void onPause()
  {
    JSONObject localJSONObject;
    if (bdey.a().c()) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("errCode", 2);
      localJSONObject.put("errMsg", "进入后台或关闭");
      sendSubscribeEvent("onVoIPChatInterrupted", localJSONObject.toString());
      bdey.a().a();
      bdey.a().a(null);
      super.onPause();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bdnw.d("[mini] VoIPJsPlugin", "JSONException", localJSONException);
      }
    }
  }
  
  public String updateVoIPChatMuteConfig(bdfz parambdfz)
  {
    bdfg localbdfg = parseRoomConfig(parambdfz.jdField_b_of_type_JavaLangString);
    JSONObject localJSONObject = new JSONObject();
    if ((localbdfg != null) && (localbdfg.jdField_a_of_type_Bdfe != null)) {
      bdey.a().a(localbdfg.jdField_a_of_type_Bdfe, new VoIPJsPlugin.1(this, localJSONObject, parambdfz));
    }
    for (;;)
    {
      return "";
      parambdfz.jdField_a_of_type_Bdcy.a(parambdfz.jdField_b_of_type_Int, bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, localJSONObject, "参数错误").toString());
      bdnw.d("[mini] VoIPJsPlugin", "参数错误 " + parambdfz.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin
 * JD-Core Version:    0.7.0.1
 */