package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StRejectFrequentlyRecommendsReq;
import NS_MINI_INTERFACE.INTERFACE.StRejectFrequentlyRecommendsRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class RejectFrequentlyRecommendsReq
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.RejectFrequentlyRecommends";
  private static final String TAG = "RejectFrequentlyRecommendsReq";
  private INTERFACE.StRejectFrequentlyRecommendsReq req = new INTERFACE.StRejectFrequentlyRecommendsReq();
  
  public RejectFrequentlyRecommendsReq(String paramString)
  {
    this.req.appID.set(paramString);
  }
  
  public static INTERFACE.StRejectFrequentlyRecommendsRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StRejectFrequentlyRecommendsRsp();
    try
    {
      ((INTERFACE.StRejectFrequentlyRecommendsRsp)localObject).mergeFrom(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("RejectFrequentlyRecommendsReq", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.RejectFrequentlyRecommendsReq
 * JD-Core Version:    0.7.0.1
 */