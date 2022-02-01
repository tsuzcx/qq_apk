package com.tencent.qqmini.sdk.request;

import NS_MINI_APP_MISC.MISC.StTrans4RoomidReq;
import NS_MINI_APP_MISC.MISC.StTrans4RoomidRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetTransRoomIdRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetTransRoomIdRequest";
  private MISC.StTrans4RoomidReq req = new MISC.StTrans4RoomidReq();
  
  public GetTransRoomIdRequest(String paramString1, String paramString2)
  {
    this.req.appid.set(paramString1);
    this.req.groupid.set(paramString2);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "Trans4Roomid";
  }
  
  protected String getModule()
  {
    return "mini_app_misc";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MISC.StTrans4RoomidRsp localStTrans4RoomidRsp = new MISC.StTrans4RoomidRsp();
    try
    {
      localStTrans4RoomidRsp.mergeFrom(paramArrayOfByte);
      paramJSONObject.put("openId", localStTrans4RoomidRsp.openid.get());
      paramJSONObject.put("tinyId", localStTrans4RoomidRsp.tinyid.get());
      paramJSONObject.put("roomId", localStTrans4RoomidRsp.roomid.get());
      return paramJSONObject;
    }
    catch (Exception paramArrayOfByte)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("onResponse fail.");
      paramJSONObject.append(paramArrayOfByte);
      QMLog.d("GetTransRoomIdRequest", paramJSONObject.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetTransRoomIdRequest
 * JD-Core Version:    0.7.0.1
 */