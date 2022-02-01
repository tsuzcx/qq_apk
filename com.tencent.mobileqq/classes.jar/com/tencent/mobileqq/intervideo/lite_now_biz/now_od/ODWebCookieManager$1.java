package com.tencent.mobileqq.intervideo.lite_now_biz.now_od;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class ODWebCookieManager$1
  implements WtTicketPromise
{
  ODWebCookieManager$1(ODWebCookieManager paramODWebCookieManager) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebComponentManager", 2, "--- pskey invalid retry ---  ");
    }
    if (paramTicket == null) {
      return;
    }
    ODWebCookieManager.a(this.a, new String((byte[])paramTicket._pskey_map.get("now.qq.com")));
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WebComponentManager", 2, "--- get pskey failed ---  " + paramErrMsg.getMessage());
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WebComponentManager", 2, "--- get pskey timeout ---  " + paramErrMsg.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.ODWebCookieManager.1
 * JD-Core Version:    0.7.0.1
 */