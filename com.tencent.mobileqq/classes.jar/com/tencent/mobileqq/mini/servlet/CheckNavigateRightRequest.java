package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightReq;
import com.tencent.mobileqq.pb.PBStringField;

public class CheckNavigateRightRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_info.CheckNavigateRight";
  private INTERFACE.StCheckNavigateRightReq req = new INTERFACE.StCheckNavigateRightReq();
  
  public CheckNavigateRightRequest(String paramString1, String paramString2)
  {
    this.req.appId.set(paramString1);
    this.req.targetAppId.set(paramString2);
  }
  
  public CheckNavigateRightRequest(String paramString1, String paramString2, COMM.StCommonExt paramStCommonExt)
  {
    this.req.appId.set(paramString1);
    this.req.targetAppId.set(paramString2);
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CheckNavigateRightRequest
 * JD-Core Version:    0.7.0.1
 */