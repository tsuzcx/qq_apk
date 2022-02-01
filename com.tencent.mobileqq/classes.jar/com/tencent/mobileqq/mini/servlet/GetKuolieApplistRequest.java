package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetExpandAppListReq;
import NS_MINI_INTERFACE.INTERFACE.StGetExpandAppListRsp;
import com.tencent.qphone.base.util.QLog;

public class GetKuolieApplistRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetExpandAppList";
  public static final String TAG = "GetKuolieApplistRequest";
  private INTERFACE.StGetExpandAppListReq req = new INTERFACE.StGetExpandAppListReq();
  
  public GetKuolieApplistRequest(COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StGetExpandAppListRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetExpandAppListRsp();
    try
    {
      ((INTERFACE.StGetExpandAppListRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("GetKuolieApplistRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetKuolieApplistRequest
 * JD-Core Version:    0.7.0.1
 */