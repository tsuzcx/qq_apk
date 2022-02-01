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
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      CloudStorage.StSetUserCloudStorageRsp localStSetUserCloudStorageRsp = new CloudStorage.StSetUserCloudStorageRsp();
      try
      {
        localStSetUserCloudStorageRsp.mergeFrom(paramArrayOfByte);
        if (localStSetUserCloudStorageRsp == null)
        {
          QMLog.d("SetCloudStorageRequest", "onResponse fail.rsp = null");
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QMLog.d("SetCloudStorageRequest", "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.SetCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */