package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpReq;
import NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetNativeAppInfoRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetNAppForJump";
  public static final String TAG = "GetAppInfoByIdRequest";
  private INTERFACE.StGetNAppForJumpReq req = new INTERFACE.StGetNAppForJumpReq();
  
  public GetNativeAppInfoRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.req.android_pkg_name.set(paramString3);
    this.req.mini_appid.set(paramString1);
    this.req.native_appid.set(paramString2);
    this.req.scene.set(paramInt);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StGetNAppForJumpRsp onResponse(byte[] paramArrayOfByte)
  {
    Object localObject = new INTERFACE.StGetNAppForJumpRsp();
    try
    {
      ((INTERFACE.StGetNAppForJumpRsp)localObject).mergeFrom(decode(paramArrayOfByte));
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onResponse fail.");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("GetAppInfoByIdRequest", 2, ((StringBuilder)localObject).toString());
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetNativeAppInfoRequest
 * JD-Core Version:    0.7.0.1
 */