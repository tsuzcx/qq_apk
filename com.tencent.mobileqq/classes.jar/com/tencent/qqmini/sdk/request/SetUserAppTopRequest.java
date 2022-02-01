package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppTopReq;
import NS_MINI_INTERFACE.INTERFACE.StSetUserAppTopRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONObject;

public class SetUserAppTopRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.SetUserAppTop";
  private INTERFACE.StSetUserAppTopReq req = new INTERFACE.StSetUserAppTopReq();
  
  public SetUserAppTopRequest(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.req.appId.set(paramString);
    this.req.verType.set(paramInt2);
    this.req.putTop.set(paramInt1);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.oldIdx.set(paramInt3);
    this.req.newIdx.set(paramInt4);
    this.req.fromNewDownload.set(paramInt5);
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "SetUserAppTop";
  }
  
  protected String getModule()
  {
    return "mini_app_userapp";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    new INTERFACE.StSetUserAppTopRsp().mergeFrom(paramArrayOfByte);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.SetUserAppTopRequest
 * JD-Core Version:    0.7.0.1
 */