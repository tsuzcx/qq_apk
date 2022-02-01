package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetWeixinSDKAppInfoReq;
import NS_MINI_INTERFACE.INTERFACE.StGetWeixinSDKAppInfoRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetWeixinSDKAppInfoRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_weixin_sdk_qrcode.GetWeixinSDKAppInfo";
  public static final String TAG = "GetWeixinSDKAppInfoRequest";
  private INTERFACE.StGetWeixinSDKAppInfoReq req = new INTERFACE.StGetWeixinSDKAppInfoReq();
  
  public GetWeixinSDKAppInfoRequest(String paramString)
  {
    this.req.code.set(paramString);
  }
  
  public static INTERFACE.StGetWeixinSDKAppInfoRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetWeixinSDKAppInfoRsp();
    try
    {
      ((INTERFACE.StGetWeixinSDKAppInfoRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse fail.");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("GetWeixinSDKAppInfoRequest", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetWeixinSDKAppInfoRequest
 * JD-Core Version:    0.7.0.1
 */