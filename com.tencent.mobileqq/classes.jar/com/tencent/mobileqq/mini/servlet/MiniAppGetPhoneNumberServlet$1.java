package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetPhoneNumberReq;
import com.tencent.mobileqq.pb.PBStringField;

class MiniAppGetPhoneNumberServlet$1
  extends ProtoBufRequest
{
  MiniAppGetPhoneNumberServlet$1(MiniAppGetPhoneNumberServlet paramMiniAppGetPhoneNumberServlet, String paramString) {}
  
  public byte[] getBusiBuf()
  {
    INTERFACE.StGetPhoneNumberReq localStGetPhoneNumberReq = new INTERFACE.StGetPhoneNumberReq();
    localStGetPhoneNumberReq.appId.set(this.val$appId);
    return localStGetPhoneNumberReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetPhoneNumberServlet.1
 * JD-Core Version:    0.7.0.1
 */