package com.tencent.qqmini.sdk.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StUserGameData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$11
  implements AsyncResult
{
  OpenDataCommonJsPlugin$11(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getPotentialFriendList receive isSuc= ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(" ret=");
    ((StringBuilder)localObject1).append(String.valueOf(paramJSONObject));
    QMLog.d("OpenDataCommonJsPlugin", ((StringBuilder)localObject1).toString());
    if (paramJSONObject == null)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , ret == null");
      this.val$req.fail();
      return;
    }
    if (paramBoolean) {
      try
      {
        Object localObject2 = (CloudStorage.StGetPotentialFriendListRsp)paramJSONObject.get("response");
        int i = paramJSONObject.getInt("retCode");
        localObject1 = paramJSONObject.getString("errMsg");
        localObject2 = ((CloudStorage.StGetPotentialFriendListRsp)localObject2).data.get();
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("getPotentialFriendList receive retCode= ");
        paramJSONObject.append(i);
        paramJSONObject.append(" errMsg=");
        paramJSONObject.append((String)localObject1);
        QMLog.d("OpenDataCommonJsPlugin", paramJSONObject.toString());
        paramJSONObject = new JSONObject();
        if ((i == 0) && (localObject2 != null) && (((List)localObject2).size() > 0))
        {
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
          this.val$req.ok(paramJSONObject);
          return;
        }
        paramJSONObject.put("retErrMsg", localObject1);
        paramJSONObject.put("errCode", i);
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , retCode!=0 or userGameDataList is empty");
        this.val$req.fail(paramJSONObject, "retCode!=0 or userGameDataList is empty");
        return;
      }
      catch (Exception paramJSONObject)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error ", paramJSONObject);
        this.val$req.fail(paramJSONObject.getMessage());
        return;
      }
    }
    QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_POTENTIAL_FRIEND_LIST error , isSuc false");
    this.val$req.fail("getPotentialFriendList failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */