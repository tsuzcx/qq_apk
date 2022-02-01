package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserGroupInfoReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserGroupInfoRsp;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetUserGroupInfoRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetUserGroupInfo";
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
  
  public static INTERFACE.StGetUserGroupInfoRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetUserGroupInfoRsp();
    try
    {
      ((INTERFACE.StGetUserGroupInfoRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("GetUserGroupInfoRequest", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserGroupInfoRequest
 * JD-Core Version:    0.7.0.1
 */