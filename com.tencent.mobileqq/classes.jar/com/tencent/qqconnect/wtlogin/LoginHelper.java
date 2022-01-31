package com.tencent.qqconnect.wtlogin;

import com.tencent.common.app.AppInterface;
import mqq.manager.TicketManager;

public class LoginHelper
{
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.LoginHelper
 * JD-Core Version:    0.7.0.1
 */