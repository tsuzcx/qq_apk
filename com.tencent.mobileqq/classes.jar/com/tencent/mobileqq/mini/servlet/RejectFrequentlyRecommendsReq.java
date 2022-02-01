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
    INTERFACE.StRejectFrequentlyRecommendsRsp localStRejectFrequentlyRecommendsRsp = new INTERFACE.StRejectFrequentlyRecommendsRsp();
    try
    {
      localStRejectFrequentlyRecommendsRsp.mergeFrom(paramArrayOfByte);
      return localStRejectFrequentlyRecommendsRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RejectFrequentlyRecommendsReq", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.RejectFrequentlyRecommendsReq
 * JD-Core Version:    0.7.0.1
 */