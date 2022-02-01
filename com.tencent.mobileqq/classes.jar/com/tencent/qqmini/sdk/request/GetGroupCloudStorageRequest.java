package com.tencent.qqmini.sdk.request;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetGroupCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetGroupCloudStorageRsp;
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

public class GetGroupCloudStorageRequest
  extends ProtoBufRequest
{
  private CloudStorage.StGetGroupCloudStorageReq req = new CloudStorage.StGetGroupCloudStorageReq();
  
  public GetGroupCloudStorageRequest(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      this.req.keyList.add(str);
      i += 1;
    }
    this.req.appid.set(paramString2);
    this.req.shareTicket.set(paramString1);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetGroupCloudStorage";
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
    Object localObject1 = new CloudStorage.StGetGroupCloudStorageRsp();
    try
    {
      ((CloudStorage.StGetGroupCloudStorageRsp)localObject1).mergeFrom(paramArrayOfByte);
      localObject1 = ((CloudStorage.StGetGroupCloudStorageRsp)localObject1).data.get();
      if (localObject1 != null)
      {
        if (((List)localObject1).isEmpty()) {
          return null;
        }
        paramArrayOfByte = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (CloudStorage.StUserGameData)((Iterator)localObject1).next();
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("avatarUrl", ((CloudStorage.StUserGameData)localObject2).avatarUrl.get());
          localJSONObject1.put("nickname", ((CloudStorage.StUserGameData)localObject2).nickname.get());
          localJSONObject1.put("openid", ((CloudStorage.StUserGameData)localObject2).openid.get());
          if ((((CloudStorage.StUserGameData)localObject2).KVDataList != null) && (((CloudStorage.StUserGameData)localObject2).KVDataList.size() > 0))
          {
            Object localObject3 = ((CloudStorage.StUserGameData)localObject2).KVDataList.get();
            localObject2 = new JSONArray();
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              CloudStorage.StKVData localStKVData = (CloudStorage.StKVData)((Iterator)localObject3).next();
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("key", localStKVData.key.get());
              localJSONObject2.put("value", localStKVData.value.get());
              ((JSONArray)localObject2).put(localJSONObject2);
            }
            localJSONObject1.put("KVDataList", localObject2);
          }
          paramArrayOfByte.put(localJSONObject1);
        }
        paramJSONObject.put("data", paramArrayOfByte);
        return paramJSONObject;
      }
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("ProtoBufRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetGroupCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */