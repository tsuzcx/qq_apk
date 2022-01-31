package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

final class al
  implements Runnable
{
  al(StatAccount paramStatAccount, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    if ((this.a == null) || (this.a.getAccount().trim().length() == 0))
    {
      StatServiceImpl.f().w("account is null or empty.");
      return;
    }
    StatConfig.setQQ(this.b, this.a.getAccount());
    StatServiceImpl.a(this.b, this.a, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.al
 * JD-Core Version:    0.7.0.1
 */