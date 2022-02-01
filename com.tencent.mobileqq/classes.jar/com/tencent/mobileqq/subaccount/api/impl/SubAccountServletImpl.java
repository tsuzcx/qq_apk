package com.tencent.mobileqq.subaccount.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.SubAccountServlet;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import mqq.app.NewIntent;

public class SubAccountServletImpl
  implements ISubAccountServlet
{
  public NewIntent fetchOneTroopNewMsg(AppInterface paramAppInterface, String paramString)
  {
    return SubAccountServlet.a(paramAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountServletImpl
 * JD-Core Version:    0.7.0.1
 */