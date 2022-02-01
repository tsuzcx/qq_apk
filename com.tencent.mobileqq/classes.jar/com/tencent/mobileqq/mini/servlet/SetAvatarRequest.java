package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAvatarReq;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAvatarRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class SetAvatarRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.SetUserAvatar";
  public static final String TAG = "SetAvatarRequest";
  private INTERFACE.StSetUserAvatarReq req = new INTERFACE.StSetUserAvatarReq();
  
  public SetAvatarRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.req.appid.set(paramString1);
    this.req.uin.set(paramString2);
    this.req.set_type.set(paramInt);
    this.req.item_id.set(paramString3);
    this.req.busi_info.set(paramString4);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StSetUserAvatarRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StSetUserAvatarRsp localStSetUserAvatarRsp = new INTERFACE.StSetUserAvatarRsp();
    try
    {
      localStSetUserAvatarRsp.mergeFrom(decode(paramArrayOfByte));
      return localStSetUserAvatarRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetAvatarRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.SetAvatarRequest
 * JD-Core Version:    0.7.0.1
 */