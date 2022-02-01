package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetPotentialFriendListRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetPotentialFriendListRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetPotentialFriendListRequest";
  private CloudStorage.StGetPotentialFriendListReq req = new CloudStorage.StGetPotentialFriendListReq();
  
  public GetPotentialFriendListRequest(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    if (paramStCommonExt != null) {
      this.req.ext.set(paramStCommonExt);
    }
    this.req.appid.set(paramString);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetPotentialFriendList";
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
    CloudStorage.StGetPotentialFriendListRsp localStGetPotentialFriendListRsp = new CloudStorage.StGetPotentialFriendListRsp();
    try
    {
      localStGetPotentialFriendListRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("response", localStGetPotentialFriendListRsp);
      paramJSONObject.put("resultCode", 0);
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetPotentialFriendListRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetPotentialFriendListRequest
 * JD-Core Version:    0.7.0.1
 */