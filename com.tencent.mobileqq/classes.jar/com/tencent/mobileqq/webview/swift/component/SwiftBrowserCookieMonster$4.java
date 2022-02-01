package com.tencent.mobileqq.webview.swift.component;

import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

final class SwiftBrowserCookieMonster$4
  implements WtTicketPromise
{
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserCookieMonster", 2, "preGetKeyInPreloadService : Done");
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preGetKeyInPreloadService failed ");
      localStringBuilder.append(paramErrMsg);
      QLog.i("SwiftBrowserCookieMonster", 2, localStringBuilder.toString());
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preGetKeyInPreloadService timeout!");
      localStringBuilder.append(paramErrMsg);
      QLog.i("SwiftBrowserCookieMonster", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.4
 * JD-Core Version:    0.7.0.1
 */