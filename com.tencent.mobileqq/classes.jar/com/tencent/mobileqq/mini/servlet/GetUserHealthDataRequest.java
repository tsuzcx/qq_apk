package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserHealthDataReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserHealthDataRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetUserHealthDataRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetUserHealthData";
  public static final String TAG = "GetUserHealthDataRequest";
  private INTERFACE.StGetUserHealthDataReq req = new INTERFACE.StGetUserHealthDataReq();
  
  public GetUserHealthDataRequest(COMM.StCommonExt paramStCommonExt, String paramString)
  {
    this.req.appid.set(paramString);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StGetUserHealthDataRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetUserHealthDataRsp();
    try
    {
      ((INTERFACE.StGetUserHealthDataRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("GetUserHealthDataRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserHealthDataRequest
 * JD-Core Version:    0.7.0.1
 */