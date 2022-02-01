package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StCheckBindingStateReq;
import NS_MINI_INTERFACE.INTERFACE.StCheckBindingStateRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class CheckBindingStateRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.CheckBindingState";
  private static final String TAG = "CheckBindingStateRequest";
  private INTERFACE.StCheckBindingStateReq req = new INTERFACE.StCheckBindingStateReq();
  
  public CheckBindingStateRequest(String paramString1, String paramString2, int paramInt)
  {
    this.req.appId.set(paramString1);
    this.req.uid.set(paramString2);
    this.req.bindType.set(paramInt);
  }
  
  public static INTERFACE.StCheckBindingStateRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StCheckBindingStateRsp localStCheckBindingStateRsp = new INTERFACE.StCheckBindingStateRsp();
    try
    {
      localStCheckBindingStateRsp.mergeFrom(paramArrayOfByte);
      return localStCheckBindingStateRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CheckBindingStateRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CheckBindingStateRequest
 * JD-Core Version:    0.7.0.1
 */