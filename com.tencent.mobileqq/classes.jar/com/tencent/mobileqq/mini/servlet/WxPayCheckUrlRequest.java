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
    MiniAppMidasPay.StWxpayCheckMWebURLRsp localStWxpayCheckMWebURLRsp = new MiniAppMidasPay.StWxpayCheckMWebURLRsp();
    try
    {
      localStWxpayCheckMWebURLRsp.mergeFrom(decode(paramArrayOfByte));
      return localStWxpayCheckMWebURLRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WxPayCheckUrlRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.WxPayCheckUrlRequest
 * JD-Core Version:    0.7.0.1
 */