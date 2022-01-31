package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserInfoExtraReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserInfoExtraRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetUserInfoExtraRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetUserInfoExtra";
  public static final String TAG = "GetUserInfoExtra";
  private INTERFACE.StGetUserInfoExtraReq req = new INTERFACE.StGetUserInfoExtraReq();
  
  public GetUserInfoExtraRequest(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    this.req.appid.set(paramString);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StGetUserInfoExtraRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StGetUserInfoExtraRsp localStGetUserInfoExtraRsp = new INTERFACE.StGetUserInfoExtraRsp();
    try
    {
      localStGetUserInfoExtraRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetUserInfoExtraRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetUserInfoExtra", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserInfoExtraRequest
 * JD-Core Version:    0.7.0.1
 */