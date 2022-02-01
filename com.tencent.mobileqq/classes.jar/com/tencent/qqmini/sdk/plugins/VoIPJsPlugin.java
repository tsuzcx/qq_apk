package com.tencent.qqmini.sdk.plugins;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.IdResult;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.RoomConfig;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xd32.XmitInfo;

@JsPlugin
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
  
  private void joinRoom(VoIPManager.IdResult paramIdResult, VoIPManager.RoomConfig paramRoomConfig, RequestEvent paramRequestEvent)
  {
    VoIPManager.getInstance().joinRoom(paramIdResult, paramRoomConfig.muteConfig, getSig(this.mMiniAppContext.getMiniAppInfo().appId, paramRoomConfig), new VoIPJsPlugin.3(this, paramRequestEvent));
  }
  
  private VoIPManager.IdResult parseIdResult(JSONObject paramJSONObject)
  {
    return (VoIPManager.IdResult)new VoIPJsPlugin.JSONParser().parse(paramJSONObject, VoIPManager.IdResult.class);
  }
  
  private VoIPManager.RoomConfig parseRoomConfig(String paramString)
  {
    return (VoIPManager.RoomConfig)new VoIPJsPlugin.JSONParser().parse(paramString, VoIPManager.RoomConfig.class);
  }
  
  private void transForRoodId(RequestEvent paramRequestEvent, VoIPManager.RoomConfig paramRoomConfig, String paramString)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).transForRoomId(this.mMiniAppContext.getMiniAppInfo().appId, paramString, new VoIPJsPlugin.2(this, paramRequestEvent, paramRoomConfig));
  }
  
  @JsEvent({"exitVoIPChat"})
  public String exitVoIPChat(RequestEvent paramRequestEvent)
  {
    VoIPManager.getInstance().exitRoom();
    JSONObject localJSONObject = new JSONObject();
    paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString());
    return "";
  }
  
  @JsEvent({"joinVoIPChat"})
  public String joinVoIPChat(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = parseRoomConfig(paramRequestEvent.jsonParams);
      if (localObject == null)
      {
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "param error").toString());
        return "";
      }
      if (!isRoomConfigValid((VoIPManager.RoomConfig)localObject))
      {
        QMLog.e("[mini] VoIPJsPlugin", "isRoomConfigValid false");
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("errCode", -5);
        }
        catch (JSONException localJSONException1)
        {
          QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
        }
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "invalid parameters").toString());
        return "";
      }
      transForRoodId(paramRequestEvent, localJSONException1, localJSONException1.groupId);
      return "";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] VoIPJsPlugin", "joinVoIPChat internal error", localThrowable);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", -1000);
      }
      catch (JSONException localJSONException2)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
      }
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject, "internal error").toString());
    }
    return "";
  }
  
  public void onPause()
  {
    if (VoIPManager.getInstance().isInRoom())
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", 2);
        localJSONObject.put("errMsg", "进入后台或关闭");
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException);
      }
      sendSubscribeEvent("onVoIPChatInterrupted", localJSONObject.toString());
    }
    ThreadManager.getSubThreadHandler().post(new VoIPJsPlugin.4(this));
    super.onPause();
  }
  
  @JsEvent({"updateVoIPChatMuteConfig"})
  public String updateVoIPChatMuteConfig(RequestEvent paramRequestEvent)
  {
    Object localObject = parseRoomConfig(paramRequestEvent.jsonParams);
    JSONObject localJSONObject = new JSONObject();
    if ((localObject != null) && (((VoIPManager.RoomConfig)localObject).muteConfig != null))
    {
      VoIPManager.getInstance().updateMuteConfig(((VoIPManager.RoomConfig)localObject).muteConfig, new VoIPJsPlugin.1(this, localJSONObject, paramRequestEvent));
    }
    else
    {
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject, "参数错误").toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("参数错误 ");
      ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
      QMLog.e("[mini] VoIPJsPlugin", ((StringBuilder)localObject).toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin
 * JD-Core Version:    0.7.0.1
 */