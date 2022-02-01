package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetAppInfoByLinkRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetAppInfoByLink";
  private static final String unikey = "GetAppInfoByLink";
  private INTERFACE.StGetAppInfoByLinkReq req = new INTERFACE.StGetAppInfoByLinkReq();
  
  public GetAppInfoByLinkRequest(String paramString, int paramInt)
  {
    this.req.link.set(paramString);
    this.req.linkType.set(paramInt);
  }
  
  public static INTERFACE.StGetAppInfoByLinkRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = new INTERFACE.StGetAppInfoByLinkRsp();
    try
    {
      ((INTERFACE.StGetAppInfoByLinkRsp)localObject).mergeFrom(decode(paramArrayOfByte));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetAppInfoByLinkRequest
 * JD-Core Version:    0.7.0.1
 */