package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppInfoReq;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppInfoRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GetUserAppInfoRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetUserAppInfo";
  public static final String TAG = "GetUserAppInfoRequest";
  private INTERFACE.StGetUserAppInfoReq req = new INTERFACE.StGetUserAppInfoReq();
  
  public GetUserAppInfoRequest(COMM.StCommonExt paramStCommonExt, List<String> paramList)
  {
    this.req.appIds.set(paramList);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StGetUserAppInfoRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetUserAppInfoRsp();
    try
    {
      ((INTERFACE.StGetUserAppInfoRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("GetUserAppInfoRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserAppInfoRequest
 * JD-Core Version:    0.7.0.1
 */