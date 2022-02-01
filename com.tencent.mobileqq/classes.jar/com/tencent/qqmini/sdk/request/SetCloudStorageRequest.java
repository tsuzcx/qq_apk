package com.tencent.qqmini.sdk.request;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StSetUserCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StSetUserCloudStorageRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class SetCloudStorageRequest
  extends ProtoBufRequest
{
  private static final String TAG = "SetCloudStorageRequest";
  private CloudStorage.StSetUserCloudStorageReq req = new CloudStorage.StSetUserCloudStorageReq();
  
  public SetCloudStorageRequest(HashMap<String, String> paramHashMap, String paramString)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      CloudStorage.StKVData localStKVData = new CloudStorage.StKVData();
      localStKVData.key.set((String)localEntry.getKey());
      localStKVData.value.set((String)localEntry.getValue());
      this.req.KVDataList.add(localStKVData);
    }
    this.req.appid.set(paramString);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "SetUserCloudStorage";
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
    CloudStorage.StSetUserCloudStorageRsp localStSetUserCloudStorageRsp = new CloudStorage.StSetUserCloudStorageRsp();
    try
    {
      localStSetUserCloudStorageRsp.mergeFrom(paramArrayOfByte);
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("SetCloudStorageRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.SetCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */