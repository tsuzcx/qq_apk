package com.tencent.mobileqq.webview.swift.component;

import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

final class SwiftBrowserCookieMonster$8
  implements WtTicketPromise
{
  SwiftBrowserCookieMonster$8(String paramString, long paramLong) {}
  
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pt4_token response received for ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", cost=");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if (paramTicket != null) {
        paramTicket = "";
      } else {
        paramTicket = ". But result was null!";
      }
      localStringBuilder.append(paramTicket);
      QLog.d("SwiftBrowserCookieMonster", 2, localStringBuilder.toString());
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get pt4_token failed for ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" because ");
      localStringBuilder.append(paramErrMsg);
      localStringBuilder.append(", cost=");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.w("SwiftBrowserCookieMonster", 2, localStringBuilder.toString());
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get pt4_token timeout for ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" because ");
      localStringBuilder.append(paramErrMsg);
      localStringBuilder.append(", cost=");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.w("SwiftBrowserCookieMonster", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.8
 * JD-Core Version:    0.7.0.1
 */