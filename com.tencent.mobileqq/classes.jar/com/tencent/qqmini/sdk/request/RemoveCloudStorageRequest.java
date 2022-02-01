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
      return null;
    }
    CloudStorage.StRemoveUserCloudStorageRsp localStRemoveUserCloudStorageRsp = new CloudStorage.StRemoveUserCloudStorageRsp();
    try
    {
      localStRemoveUserCloudStorageRsp.mergeFrom(paramArrayOfByte);
      return paramJSONObject;
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
 * Qualified Name:     com.tencent.qqmini.sdk.request.RemoveCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */