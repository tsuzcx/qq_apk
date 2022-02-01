package com.tencent.qqmini.sdk.request;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StRemoveUserCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StRemoveUserCloudStorageRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class RemoveCloudStorageRequest
  extends ProtoBufRequest
{
  private CloudStorage.StRemoveUserCloudStorageReq req = new CloudStorage.StRemoveUserCloudStorageReq();
  
  public RemoveCloudStorageRequest(String[] paramArrayOfString, String paramString)
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
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "RemoveUserCloudStorage";
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
      CloudStorage.StRemoveUserCloudStorageRsp localStRemoveUserCloudStorageRsp = new CloudStorage.StRemoveUserCloudStorageRsp();
      try
      {
        localStRemoveUserCloudStorageRsp.mergeFrom(paramArrayOfByte);
        if (localStRemoveUserCloudStorageRsp == null)
        {
          QMLog.d("ProtoBufRequest", "onResponse fail.rsp = null");
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.RemoveCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */