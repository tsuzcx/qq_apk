package com.tencent.open.sdk.checker;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class AccountChecker
  extends BaseAccountChecker
{
  private QQAppInterface a;
  
  public AccountChecker(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(long paramLong, String paramString, BaseAccountChecker.IAccountCheckCallback paramIAccountCheckCallback)
  {
    OpenID localOpenID = this.a.getMsgHandler().a(String.valueOf(paramLong));
    if (localOpenID != null)
    {
      boolean bool = TextUtils.equals(paramString, localOpenID.openID);
      paramIAccountCheckCallback.a(bool);
      paramString = new StringBuilder();
      paramString.append("check: use cache, account is same? ");
      paramString.append(bool);
      QLog.d("AccountChecker", 1, paramString.toString());
      return;
    }
    try
    {
      long l = Long.parseLong(this.a.getCurrentAccountUin());
      this.a.getMsgHandler().a(l, paramString, paramLong, new AccountChecker.1(this, paramIAccountCheckCallback));
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("AccountChecker", 1, "check: NumberFormatException");
      paramIAccountCheckCallback.a(-1, paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.sdk.checker.AccountChecker
 * JD-Core Version:    0.7.0.1
 */