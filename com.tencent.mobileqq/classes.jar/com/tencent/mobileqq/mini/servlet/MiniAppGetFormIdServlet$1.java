package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StGetFormIdReq;
import com.tencent.mobileqq.pb.PBStringField;

class MiniAppGetFormIdServlet$1
  extends ProtoBufRequest
{
  MiniAppGetFormIdServlet$1(MiniAppGetFormIdServlet paramMiniAppGetFormIdServlet, String paramString) {}
  
  public byte[] getBusiBuf()
  {
    INTERFACE.StGetFormIdReq localStGetFormIdReq = new INTERFACE.StGetFormIdReq();
    localStGetFormIdReq.appid.set(this.val$appId);
    return localStGetFormIdReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppGetFormIdServlet.1
 * JD-Core Version:    0.7.0.1
 */