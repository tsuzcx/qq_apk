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
    INTERFACE.StGetUserAppInfoRsp localStGetUserAppInfoRsp = new INTERFACE.StGetUserAppInfoRsp();
    try
    {
      localStGetUserAppInfoRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetUserAppInfoRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetUserAppInfoRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserAppInfoRequest
 * JD-Core Version:    0.7.0.1
 */