package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppLikeReq;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppLikeRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class SetUserAppLikeRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.SetUserAppLike";
  public static final String TAG = "SetUserAppLikeRequest";
  private INTERFACE.StSetUserAppLikeReq req = new INTERFACE.StSetUserAppLikeReq();
  
  public SetUserAppLikeRequest(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt)
  {
    this.req.appId.set(paramString);
    this.req.doLike.set(paramInt);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StSetUserAppLikeRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StSetUserAppLikeRsp();
    try
    {
      ((INTERFACE.StSetUserAppLikeRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("SetUserAppLikeRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.SetUserAppLikeRequest
 * JD-Core Version:    0.7.0.1
 */