package com.tencent.mobileqq.minigame.jsapi.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StUserGameData;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class OpenDataPlugin$3
  implements MiniAppCmdInterface
{
  OpenDataPlugin$3(OpenDataPlugin paramOpenDataPlugin, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("OpenDataPlugin", 1, "getPotentialFriendList receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , ret == null");
      GameLog.vconsoleLog("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , ret == null");
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getPotentialFriendList", null, this.val$callbackId);
      return;
    }
    if (paramBoolean)
    {
      try
      {
        Object localObject1 = (CloudStorage.StGetPotentialFriendListRsp)paramJSONObject.get("response");
        int i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        Object localObject2 = ((CloudStorage.StGetPotentialFriendListRsp)localObject1).data.get();
        QLog.d("OpenDataPlugin", 1, "getPotentialFriendList receive retCode= " + i + " errMsg=" + paramJSONObject);
        if ((i != 0) || (localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label378;
        }
        paramJSONObject = new JSONObject();
        localObject1 = new JSONArray();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          CloudStorage.StUserGameData localStUserGameData = (CloudStorage.StUserGameData)((Iterator)localObject2).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("avatarUrl", localStUserGameData.avatarUrl.get());
          localJSONObject.put("nickname", localStUserGameData.nickname.get());
          localJSONObject.put("openid", localStUserGameData.openid.get());
          ((JSONArray)localObject1).put(localJSONObject);
        }
        paramJSONObject.put("list", localObject1);
      }
      catch (Exception paramJSONObject)
      {
        GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error ", paramJSONObject);
        GameLog.vconsoleLog("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + paramJSONObject.getMessage());
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getPotentialFriendList", null, this.val$callbackId);
        return;
      }
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, "getPotentialFriendList", paramJSONObject, this.val$callbackId);
      return;
      label378:
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , retCode!=0oruserGameDataList is empty");
      GameLog.vconsoleLog("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , retCode!=0oruserGameDataList is empty");
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getPotentialFriendList", null, this.val$callbackId);
      return;
    }
    GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , isSuc false");
    GameLog.vconsoleLog("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , isSuc false");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "getPotentialFriendList", null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.3
 * JD-Core Version:    0.7.0.1
 */