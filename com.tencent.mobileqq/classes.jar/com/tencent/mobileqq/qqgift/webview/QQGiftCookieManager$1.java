package com.tencent.mobileqq.qqgift.webview;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class QQGiftCookieManager$1
  implements WtTicketPromise
{
  QQGiftCookieManager$1(QQGiftCookieManager paramQQGiftCookieManager, AppRuntime paramAppRuntime) {}
  
  public void Done(Ticket paramTicket)
  {
    if (paramTicket == null)
    {
      QLog.e("QQGiftCookieManager", 1, "Done, ticket is null");
      return;
    }
    String str = paramTicket.getPSkey("qlive.qq.com");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPsKey Done ticket:");
    localStringBuilder.append(str);
    localStringBuilder.append(", isPsk eyExpired:");
    localStringBuilder.append(Ticket.isPskeyExpired(((Long)paramTicket._pskey_expire.get("qlive.qq.com")).longValue()));
    QLog.d("QQGiftCookieManager", 1, localStringBuilder.toString());
    QQGiftCookieManager.a().a(this.a.getApplicationContext(), str);
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPsKey Failed errMsg:");
    localStringBuilder.append(paramErrMsg);
    QLog.d("QQGiftCookieManager", 1, localStringBuilder.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPsKey Timeout errMsg:");
    localStringBuilder.append(paramErrMsg);
    QLog.d("QQGiftCookieManager", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.webview.QQGiftCookieManager.1
 * JD-Core Version:    0.7.0.1
 */