package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetTCBTicketReq;
import NS_MINI_INTERFACE.INTERFACE.StGetTCBTicketRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetTcbTicketRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetTcbTicketRequest";
  private INTERFACE.StGetTCBTicketReq req = new INTERFACE.StGetTCBTicketReq();
  
  public GetTcbTicketRequest(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2)
  {
    this.req.appid.set(paramString1);
    this.req.envId.set(paramString2);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetTCBTicket";
  }
  
  protected String getModule()
  {
    return "mini_app_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    INTERFACE.StGetTCBTicketRsp localStGetTCBTicketRsp = new INTERFACE.StGetTCBTicketRsp();
    try
    {
      localStGetTCBTicketRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("ticket", localStGetTCBTicketRsp.ticket.get());
      paramJSONObject.put("createTime", localStGetTCBTicketRsp.createTime.get());
      paramJSONObject.put("period", localStGetTCBTicketRsp.period.get());
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetTcbTicketRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetTcbTicketRequest
 * JD-Core Version:    0.7.0.1
 */