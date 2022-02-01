package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetProfileReq;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileRsp;
import com.tencent.qphone.base.util.QLog;

public class GetProfileRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetProfile";
  private static final String unikey = "GetProfile";
  private INTERFACE.StGetProfileReq req;
  
  public GetProfileRequest(String paramString1, boolean paramBoolean, String paramString2) {}
  
  public static INTERFACE.StGetProfileRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetProfileRsp();
    try
    {
      ((INTERFACE.StGetProfileRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("ProtoBufRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetProfileRequest
 * JD-Core Version:    0.7.0.1
 */