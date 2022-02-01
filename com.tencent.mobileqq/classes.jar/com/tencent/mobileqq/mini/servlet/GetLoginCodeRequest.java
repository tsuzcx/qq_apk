package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetCodeReq;
import NS_MINI_INTERFACE.INTERFACE.StGetCodeRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetLoginCodeRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_program_auth.GetCode";
  public static final String TAG = "GetLoginCodeRequest";
  private INTERFACE.StGetCodeReq req = new INTERFACE.StGetCodeReq();
  
  public GetLoginCodeRequest(String paramString)
  {
    this.req.appid.set(paramString);
  }
  
  public static INTERFACE.StGetCodeRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      INTERFACE.StGetCodeRsp localStGetCodeRsp = new INTERFACE.StGetCodeRsp();
      try
      {
        localStGetCodeRsp.mergeFrom(decode(paramArrayOfByte));
        return localStGetCodeRsp;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("GetLoginCodeRequest", 2, "onResponse fail." + paramArrayOfByte);
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetLoginCodeRequest
 * JD-Core Version:    0.7.0.1
 */