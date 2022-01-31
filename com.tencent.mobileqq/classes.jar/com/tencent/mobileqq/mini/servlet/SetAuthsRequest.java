package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StSetAuthsReq;
import NS_MINI_INTERFACE.INTERFACE.StSetAuthsRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class SetAuthsRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_user_info.SetAuths";
  private INTERFACE.StSetAuthsReq req = new INTERFACE.StSetAuthsReq();
  
  public SetAuthsRequest(COMM.StCommonExt paramStCommonExt, String paramString, INTERFACE.StUserAuthInfo paramStUserAuthInfo)
  {
    this.req.appid.set(paramString);
    if (paramStUserAuthInfo != null)
    {
      paramString = new ArrayList();
      paramString.add(paramStUserAuthInfo);
      this.req.auths.set(paramString);
    }
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public static INTERFACE.StSetAuthsRsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      INTERFACE.StSetAuthsRsp localStSetAuthsRsp = new INTERFACE.StSetAuthsRsp();
      try
      {
        localStSetAuthsRsp.mergeFrom(decode(paramArrayOfByte));
        return localStSetAuthsRsp;
      }
      catch (Exception paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("ProtoBufRequest", 2, "onResponse fail." + paramArrayOfByte);
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.SetAuthsRequest
 * JD-Core Version:    0.7.0.1
 */