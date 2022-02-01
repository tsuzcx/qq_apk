package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayReq;
import NS_MINI_APP_PAY.MiniAppMidasPay.StGamePayRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class PayRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_pay.GamePay";
  public static final String TAG = "MiniAppPayRequest";
  private MiniAppMidasPay.StGamePayReq req = new MiniAppMidasPay.StGamePayReq();
  
  public PayRequest(String paramString1, COMM.StCommonExt paramStCommonExt, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.appId.set(paramString1);
    this.req.prepayId.set(paramString2);
    this.req.starCurrency.set(paramInt1);
    this.req.balanceAmount.set(paramInt2);
    this.req.topupAmount.set(paramInt3);
    this.req.payChannel.set(paramInt4);
    this.req.sandboxEnv.set(paramInt5);
  }
  
  public static MiniAppMidasPay.StGamePayRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new MiniAppMidasPay.StGamePayRsp();
    try
    {
      ((MiniAppMidasPay.StGamePayRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("MiniAppPayRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.PayRequest
 * JD-Core Version:    0.7.0.1
 */