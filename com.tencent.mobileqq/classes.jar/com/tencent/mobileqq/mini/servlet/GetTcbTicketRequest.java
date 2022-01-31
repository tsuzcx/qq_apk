package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetTCBTicketReq;
import NS_MINI_INTERFACE.INTERFACE.StGetTCBTicketRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class GetTcbTicketRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetTCBTicket";
  public static final String TAG = "GetTcbTicketRequest";
  private INTERFACE.StGetTCBTicketReq req = new INTERFACE.StGetTCBTicketReq();
  
  public GetTcbTicketRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2)
  {
    this.req.appid.set(paramString1);
    this.req.envId.set(paramString2);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StGetTCBTicketRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StGetTCBTicketRsp localStGetTCBTicketRsp = new INTERFACE.StGetTCBTicketRsp();
    try
    {
      localStGetTCBTicketRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetTCBTicketRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetTcbTicketRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetTcbTicketRequest
 * JD-Core Version:    0.7.0.1
 */