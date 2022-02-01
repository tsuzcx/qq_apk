package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StMiniCheckOfferIdReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StMiniCheckOfferIdRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class CheckOfferIdRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_pay.MiniCheckOfferId";
  public static final String TAG = "CheckOfferIdRequest";
  private MiniAppMidasPay.StMiniCheckOfferIdReq req = new MiniAppMidasPay.StMiniCheckOfferIdReq();
  
  public CheckOfferIdRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2)
  {
    this.req.appId.set(paramString1);
    this.req.offerId.set(paramString2);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static MiniAppMidasPay.StMiniCheckOfferIdRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new MiniAppMidasPay.StMiniCheckOfferIdRsp();
    try
    {
      ((MiniAppMidasPay.StMiniCheckOfferIdRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("CheckOfferIdRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CheckOfferIdRequest
 * JD-Core Version:    0.7.0.1
 */