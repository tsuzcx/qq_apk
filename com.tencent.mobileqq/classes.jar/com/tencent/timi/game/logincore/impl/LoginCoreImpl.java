package com.tencent.timi.game.logincore.impl;

import android.content.Context;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.utils.Logger;
import mqq.app.MobileQQ;

public class LoginCoreImpl
  implements ILoginCoreService
{
  public long a()
  {
    String str = b();
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Logger.a("LoginCoreImpl", "convert uid to long error", localNumberFormatException);
    }
    return 0L;
  }
  
  public String a(long paramLong)
  {
    return String.valueOf(paramLong);
  }
  
  public void a(Context paramContext) {}
  
  public String b()
  {
    SimpleAccount localSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
    if (localSimpleAccount != null) {
      return localSimpleAccount.getUin();
    }
    return "";
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.logincore.impl.LoginCoreImpl
 * JD-Core Version:    0.7.0.1
 */