package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetAppInfoByIdRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetAppInfoById";
  public static final String TAG = "GetAppInfoByIdRequest";
  private INTERFACE.StGetAppInfoByIdReq req = new INTERFACE.StGetAppInfoByIdReq();
  
  public GetAppInfoByIdRequest(COMM.StCommonExt paramStCommonExt, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.req.appid.set(paramString1);
    this.req.needVersionInfo.set(paramInt1);
    this.req.checkDevRight.set(paramInt2);
    this.req.firstPath.set(paramString2);
    this.req.envVersion.set(paramString3);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StGetAppInfoByIdRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StGetAppInfoByIdRsp localStGetAppInfoByIdRsp = new INTERFACE.StGetAppInfoByIdRsp();
    try
    {
      localStGetAppInfoByIdRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetAppInfoByIdRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetAppInfoByIdRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetAppInfoByIdRequest
 * JD-Core Version:    0.7.0.1
 */