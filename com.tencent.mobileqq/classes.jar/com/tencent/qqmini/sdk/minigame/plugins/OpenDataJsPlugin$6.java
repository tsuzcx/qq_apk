package com.tencent.qqmini.sdk.minigame.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StUserGameData;
import bgkd;
import bgwc;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class OpenDataJsPlugin$6
  implements AsyncResult
{
  OpenDataJsPlugin$6(OpenDataJsPlugin paramOpenDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("OpenDataJsPlugin", "getPotentialFriendList receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , ret == null");
      bgwc.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , ret == null");
      this.val$req.b();
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
        QMLog.d("OpenDataJsPlugin", "getPotentialFriendList receive retCode= " + i + " errMsg=" + paramJSONObject);
        if ((i != 0) || (localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break label338;
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
        bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error ", paramJSONObject);
        bgwc.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error " + paramJSONObject.getMessage());
        this.val$req.b();
        return;
      }
      this.val$req.a(paramJSONObject);
      return;
      label338:
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , retCode!=0oruserGameDataList is empty");
      bgwc.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , retCode!=0oruserGameDataList is empty");
      this.val$req.b();
      return;
    }
    bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , isSuc false");
    bgwc.a("handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , isSuc false");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */