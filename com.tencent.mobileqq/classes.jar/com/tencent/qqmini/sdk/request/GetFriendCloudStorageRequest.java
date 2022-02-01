package com.tencent.qqmini.sdk.request;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetFriendCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetFriendCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StUserGameData;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetFriendCloudStorageRequest
  extends ProtoBufRequest
{
  private CloudStorage.StGetFriendCloudStorageReq req = new CloudStorage.StGetFriendCloudStorageReq();
  
  public GetFriendCloudStorageRequest(String[] paramArrayOfString, String paramString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      this.req.keyList.add(str);
      i += 1;
    }
    this.req.appid.set(paramString);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetFriendCloudStorage";
  }
  
  protected String getModule()
  {
    return "mini_app_cloudstorage";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject1 = new CloudStorage.StGetFriendCloudStorageRsp();
    for (;;)
    {
      JSONObject localJSONObject1;
      try
      {
        ((CloudStorage.StGetFriendCloudStorageRsp)localObject1).mergeFrom(paramArrayOfByte);
        if (localObject1 == null) {
          break label318;
        }
        localObject1 = ((CloudStorage.StGetFriendCloudStorageRsp)localObject1).data.get();
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label327;
        }
        paramArrayOfByte = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = (CloudStorage.StUserGameData)((Iterator)localObject1).next();
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("avatarUrl", ((CloudStorage.StUserGameData)localObject2).avatarUrl.get());
        localJSONObject1.put("nickname", ((CloudStorage.StUserGameData)localObject2).nickname.get());
        localJSONObject1.put("openid", ((CloudStorage.StUserGameData)localObject2).openid.get());
        if ((((CloudStorage.StUserGameData)localObject2).KVDataList != null) && (((CloudStorage.StUserGameData)localObject2).KVDataList.size() > 0))
        {
          Object localObject3 = ((CloudStorage.StUserGameData)localObject2).KVDataList.get();
          localObject2 = new JSONArray();
          localObject3 = ((List)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            CloudStorage.StKVData localStKVData = (CloudStorage.StKVData)((Iterator)localObject3).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("key", localStKVData.key.get());
            localJSONObject2.put("value", localStKVData.value.get());
            ((JSONArray)localObject2).put(localJSONObject2);
            continue;
          }
          localJSONObject1.put("KVDataList", localObject2);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
        return null;
      }
      paramArrayOfByte.put(localJSONObject1);
    }
    paramJSONObject.put("data", paramArrayOfByte);
    return paramJSONObject;
    label318:
    QMLog.d("ProtoBufRequest", "onResponse fail.rsp = null");
    return null;
    label327:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetFriendCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */