package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetUserInteractiveStorageRequest
  extends ProtoBufRequest
{
  public static final String TAG = "GetUserInteractiveStorageRequest";
  private CloudStorage.StGetUserInteractiveStorageReq req = new CloudStorage.StGetUserInteractiveStorageReq();
  
  public GetUserInteractiveStorageRequest(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString)
  {
    if (paramStCommonExt != null) {
      this.req.ext.set(paramStCommonExt);
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramStCommonExt = paramArrayOfString[i];
      this.req.keyList.add(paramStCommonExt);
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
    return "GetUserInteractiveStorage";
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
    CloudStorage.StGetUserInteractiveStorageRsp localStGetUserInteractiveStorageRsp = new CloudStorage.StGetUserInteractiveStorageRsp();
    try
    {
      localStGetUserInteractiveStorageRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("response", localStGetUserInteractiveStorageRsp);
      paramJSONObject.put("resultCode", 0);
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetUserInteractiveStorageRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetUserInteractiveStorageRequest
 * JD-Core Version:    0.7.0.1
 */