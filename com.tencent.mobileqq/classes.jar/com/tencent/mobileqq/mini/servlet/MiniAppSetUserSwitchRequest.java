package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserSwitchReq;
import NS_MINI_INTERFACE.INTERFACE.StSetUserSwitchRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class MiniAppSetUserSwitchRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.SetUserSwitch";
  public static final String TAG = "MiniAppSetUserSwitchRequest";
  private static final String unikey = "MiniAppSetUserSwitchRequest";
  private INTERFACE.StSetUserSwitchReq req = new INTERFACE.StSetUserSwitchReq();
  
  public MiniAppSetUserSwitchRequest(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.key.set(paramString);
    this.req.value.set(paramInt);
  }
  
  public static INTERFACE.StSetUserSwitchRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StSetUserSwitchRsp localStSetUserSwitchRsp = new INTERFACE.StSetUserSwitchRsp();
    try
    {
      localStSetUserSwitchRsp.mergeFrom(decode(paramArrayOfByte));
      return localStSetUserSwitchRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppSetUserSwitchRequest", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSetUserSwitchRequest
 * JD-Core Version:    0.7.0.1
 */