package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.f;

final class am
  implements Runnable
{
  am(StatGameUser paramStatGameUser, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    if (this.a == null)
    {
      StatServiceImpl.f().error("The gameUser of StatService.reportGameUser() can not be null!");
      return;
    }
    if ((this.a.getAccount() == null) || (this.a.getAccount().length() == 0))
    {
      StatServiceImpl.f().error("The account of gameUser on StatService.reportGameUser() can not be null or empty!");
      return;
    }
    try
    {
      new aq(new f(this.b, StatServiceImpl.a(this.b, false, this.c), this.a, this.c)).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      StatServiceImpl.a(this.b, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.am
 * JD-Core Version:    0.7.0.1
 */