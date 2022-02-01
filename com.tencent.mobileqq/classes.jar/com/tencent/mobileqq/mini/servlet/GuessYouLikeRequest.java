package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StGetGuessYouLikeReq;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StGetGuessYouLikeRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;

public class GuessYouLikeRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.store_app_search.GetGuessYouLike";
  private static final String TAG = "GuessYouLikeRequest";
  private STORE_APP_CLIENT.StGetGuessYouLikeReq req = new STORE_APP_CLIENT.StGetGuessYouLikeReq();
  
  public GuessYouLikeRequest(COMM.StCommonExt paramStCommonExt, int paramInt)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.count.set(paramInt);
  }
  
  public static STORE_APP_CLIENT.StGetGuessYouLikeRsp onResponse(byte[] paramArrayOfByte)
  {
    STORE_APP_CLIENT.StGetGuessYouLikeRsp localStGetGuessYouLikeRsp = new STORE_APP_CLIENT.StGetGuessYouLikeRsp();
    try
    {
      localStGetGuessYouLikeRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetGuessYouLikeRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.e("GuessYouLikeRequest", 2, "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GuessYouLikeRequest
 * JD-Core Version:    0.7.0.1
 */