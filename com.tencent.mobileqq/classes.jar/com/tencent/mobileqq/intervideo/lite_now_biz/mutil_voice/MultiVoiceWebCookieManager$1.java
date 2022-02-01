package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class MultiVoiceWebCookieManager$1
  implements WtTicketPromise
{
  MultiVoiceWebCookieManager$1(MultiVoiceWebCookieManager paramMultiVoiceWebCookieManager) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebComponentManager", 2, "--- pskey invalid retry ---  ");
    }
    if (paramTicket == null) {
      return;
    }
    MultiVoiceWebCookieManager.a(this.a, new String((byte[])paramTicket._pskey_map.get("now.qq.com")));
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--- get pskey failed ---  ");
      localStringBuilder.append(paramErrMsg.getMessage());
      QLog.e("WebComponentManager", 2, localStringBuilder.toString());
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--- get pskey timeout ---  ");
      localStringBuilder.append(paramErrMsg.getMessage());
      QLog.e("WebComponentManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceWebCookieManager.1
 * JD-Core Version:    0.7.0.1
 */