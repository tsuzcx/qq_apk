package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetNewBaseLibReq;
import NS_MINI_INTERFACE.INTERFACE.StGetNewBaseLibRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetNewBaseLibRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetNewBaseLib";
  public static final String unikey = "GetNewBaseLib";
  private INTERFACE.StGetNewBaseLibReq req = new INTERFACE.StGetNewBaseLibReq();
  
  public GetNewBaseLibRequest(long paramLong, String paramString, int paramInt)
  {
    this.req.curVersion.set(paramString);
    this.req.type.set(paramInt);
  }
  
  public static INTERFACE.StGetNewBaseLibRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = new INTERFACE.StGetNewBaseLibRsp();
    try
    {
      ((INTERFACE.StGetNewBaseLibRsp)localObject).mergeFrom(decode(paramArrayOfByte));
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetNewBaseLibRequest
 * JD-Core Version:    0.7.0.1
 */