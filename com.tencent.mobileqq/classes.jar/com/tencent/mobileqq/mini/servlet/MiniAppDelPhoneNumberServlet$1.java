package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StDelPhoneNumbersReq;
import com.tencent.mobileqq.pb.PBStringField;

class MiniAppDelPhoneNumberServlet$1
  extends ProtoBufRequest
{
  MiniAppDelPhoneNumberServlet$1(MiniAppDelPhoneNumberServlet paramMiniAppDelPhoneNumberServlet, String paramString1, String paramString2) {}
  
  public byte[] getBusiBuf()
  {
    INTERFACE.StDelPhoneNumbersReq localStDelPhoneNumbersReq = new INTERFACE.StDelPhoneNumbersReq();
    localStDelPhoneNumbersReq.appId.set(this.val$appId);
    localStDelPhoneNumbersReq.purePhoneNumber.set(this.val$purePhoneNumber);
    return localStDelPhoneNumbersReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppDelPhoneNumberServlet.1
 * JD-Core Version:    0.7.0.1
 */