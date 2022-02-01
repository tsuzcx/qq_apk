package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetSwitchListReq;
import NS_MINI_INTERFACE.INTERFACE.StGetSwitchListRsp;
import com.tencent.qphone.base.util.QLog;

public class MiniAppGetSwitchListRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetSwitchList";
  public static final String TAG = "MiniAppGetSwitchListRequest";
  private static final String unikey = "MiniAppGetSwitchListRequest";
  private INTERFACE.StGetSwitchListReq req = new INTERFACE.StGetSwitchListReq();
  
  public MiniAppGetSwitchListRequest(COMM.StCommonExt paramStCommonExt)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StGetSwitchListRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StGetSwitchListRsp localStGetSwitchListRsp = new INTERFACE.StGetSwitchListRsp();
    try
    {
      localStGetSwitchListRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetSwitchListRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppGetSwitchListRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetSwitchListRequest
 * JD-Core Version:    0.7.0.1
 */