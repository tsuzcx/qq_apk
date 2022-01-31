package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import behp;
import behq;
import bejp;
import bejt;
import bejx;
import bekr;
import bekx;
import betc;
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
  
  private byte[] getSig(String paramString, bejx parambejx)
  {
    oidb_0xd32.XmitInfo localXmitInfo = new oidb_0xd32.XmitInfo();
    localXmitInfo.str_appid.set(paramString);
    localXmitInfo.str_groupid.set(parambejx.c);
    localXmitInfo.str_nonce.set(parambejx.jdField_b_of_type_JavaLangString);
    localXmitInfo.uint32_timestamp.set(parambejx.jdField_a_of_type_Int);
    localXmitInfo.str_signature.set(parambejx.jdField_a_of_type_JavaLangString);
    return localXmitInfo.toByteArray();
  }
  
  private boolean isRoomConfigValid(bejx parambejx)
  {
    return (!TextUtils.isEmpty(parambejx.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(parambejx.c)) && (!TextUtils.isEmpty(parambejx.jdField_a_of_type_JavaLangString)) && (parambejx.jdField_a_of_type_Int > 0);
  }
  
  private bejt parseIdResult(JSONObject paramJSONObject)
  {
    return (bejt)new VoIPJsPlugin.JSONParser().parse(paramJSONObject, bejt.class);
  }
  
  private bejx parseRoomConfig(String paramString)
  {
    return (bejx)new VoIPJsPlugin.JSONParser().parse(paramString, bejx.class);
  }
  
  public String exitVoIPChat(bekr parambekr)
  {
    bejp.a().a();
    JSONObject localJSONObject = new JSONObject();
    parambekr.jdField_a_of_type_Behp.a(parambekr.jdField_b_of_type_Int, bekx.a(parambekr.jdField_a_of_type_JavaLangString, localJSONObject).toString());
    return "";
  }
  
  public String joinVoIPChat(bekr parambekr)
  {
    try
    {
      Object localObject = parseRoomConfig(parambekr.jdField_b_of_type_JavaLangString);
      if (localObject == null)
      {
        parambekr.jdField_a_of_type_Behp.a(parambekr.jdField_b_of_type_Int, bekx.a(parambekr.jdField_a_of_type_JavaLangString, null, "param error").toString());
        return "";
      }
      if (!isRoomConfigValid((bejx)localObject))
      {
        betc.d("[mini] VoIPJsPlugin", "isRoomConfigValid false");
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("errCode", -5);
          parambekr.jdField_a_of_type_Behp.a(parambekr.jdField_b_of_type_Int, bekx.a(parambekr.jdField_a_of_type_JavaLangString, null, "invalid parameters").toString());
          return "";
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            betc.d("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
          }
        }
      }
      try
      {
        JSONObject localJSONObject;
        localJSONObject.put("errCode", -1000);
        parambekr.jdField_a_of_type_Behp.a(parambekr.jdField_b_of_type_Int, bekx.a(parambekr.jdField_a_of_type_JavaLangString, localJSONObject, "internal error").toString());
        for (;;)
        {
          return "";
          String str = localJSONObject.c;
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).transForRoomId(this.mMiniAppContext.a().appId, str, new VoIPJsPlugin.2(this, parambekr, localJSONObject));
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          betc.d("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      betc.d("[mini] VoIPJsPlugin", "joinVoIPChat internal error", localThrowable);
      localJSONObject = new JSONObject();
    }
  }
  
  public void onPause()
  {
    JSONObject localJSONObject;
    if (bejp.a().c()) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("errCode", 2);
      localJSONObject.put("errMsg", "进入后台或关闭");
      sendSubscribeEvent("onVoIPChatInterrupted", localJSONObject.toString());
      bejp.a().a();
      bejp.a().a(null);
      super.onPause();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        betc.d("[mini] VoIPJsPlugin", "JSONException", localJSONException);
      }
    }
  }
  
  public String updateVoIPChatMuteConfig(bekr parambekr)
  {
    bejx localbejx = parseRoomConfig(parambekr.jdField_b_of_type_JavaLangString);
    JSONObject localJSONObject = new JSONObject();
    if ((localbejx != null) && (localbejx.jdField_a_of_type_Bejv != null)) {
      bejp.a().a(localbejx.jdField_a_of_type_Bejv, new VoIPJsPlugin.1(this, localJSONObject, parambekr));
    }
    for (;;)
    {
      return "";
      parambekr.jdField_a_of_type_Behp.a(parambekr.jdField_b_of_type_Int, bekx.a(parambekr.jdField_a_of_type_JavaLangString, localJSONObject, "参数错误").toString());
      betc.d("[mini] VoIPJsPlugin", "参数错误 " + parambekr.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin
 * JD-Core Version:    0.7.0.1
 */