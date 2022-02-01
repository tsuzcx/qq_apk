package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserGroupInfoReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserGroupInfoRsp;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetUserGroupInfoRequest
  extends ProtoBufRequest
{
  public static final String TAG = "GetUserGroupInfoRequest";
  private INTERFACE.StGetUserGroupInfoReq req = new INTERFACE.StGetUserGroupInfoReq();
  
  public GetUserGroupInfoRequest(String paramString1, String paramString2, long paramLong, COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    if (paramString1 != null) {
      this.req.appid.set(paramString1);
    }
    if (paramString2 != null) {
      this.req.groupId.set(paramString2);
    }
    this.req.groupClass.set(paramLong);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetUserHealthData";
  }
  
  protected String getModule()
  {
    return "mini_user_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetUserGroupInfoRsp localStGetUserGroupInfoRsp = new INTERFACE.StGetUserGroupInfoRsp();
    try
    {
      localStGetUserGroupInfoRsp.mergeFrom(decode(paramArrayOfByte));
      if (localStGetUserGroupInfoRsp != null)
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("extra_json_data", localStGetUserGroupInfoRsp.userGroupInfo.get());
        return paramArrayOfByte;
      }
      QMLog.d("GetUserGroupInfoRequest", "onResponse fail.rsp = null");
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetUserGroupInfoRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetUserGroupInfoRequest
 * JD-Core Version:    0.7.0.1
 */