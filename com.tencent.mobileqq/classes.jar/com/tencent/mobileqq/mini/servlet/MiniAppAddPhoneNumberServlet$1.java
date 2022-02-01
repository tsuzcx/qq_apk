package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StAddPhoneNumberReq;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

class MiniAppAddPhoneNumberServlet$1
  extends ProtoBufRequest
{
  MiniAppAddPhoneNumberServlet$1(MiniAppAddPhoneNumberServlet paramMiniAppAddPhoneNumberServlet, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public byte[] getBusiBuf()
  {
    INTERFACE.StAddPhoneNumberReq localStAddPhoneNumberReq = new INTERFACE.StAddPhoneNumberReq();
    localStAddPhoneNumberReq.appId.set(this.val$appId);
    localStAddPhoneNumberReq.purePhoneNumber.set(this.val$purePhoneNumber);
    localStAddPhoneNumberReq.countryCode.set(this.val$countryCode);
    localStAddPhoneNumberReq.isSave.set(this.val$isSave);
    return localStAddPhoneNumberReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppAddPhoneNumberServlet.1
 * JD-Core Version:    0.7.0.1
 */