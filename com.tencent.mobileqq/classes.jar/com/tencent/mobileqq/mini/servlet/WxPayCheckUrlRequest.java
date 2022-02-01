package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_PAY.MiniAppMidasPay.StWxpayCheckMWebURLReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StWxpayCheckMWebURLRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class WxPayCheckUrlRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_pay.WxpayCheckMWebURL";
  public static final String TAG = "WxPayCheckUrlRequest";
  private MiniAppMidasPay.StWxpayCheckMWebURLReq req = new MiniAppMidasPay.StWxpayCheckMWebURLReq();
  
  public WxPayCheckUrlRequest(String paramString1, String paramString2)
  {
    this.req.appid.set(paramString1);
    this.req.mweb_url.set(paramString2);
  }
  
  public static MiniAppMidasPay.StWxpayCheckMWebURLRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new MiniAppMidasPay.StWxpayCheckMWebURLRsp();
    try
    {
      ((MiniAppMidasPay.StWxpayCheckMWebURLRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("WxPayCheckUrlRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.WxPayCheckUrlRequest
 * JD-Core Version:    0.7.0.1
 */