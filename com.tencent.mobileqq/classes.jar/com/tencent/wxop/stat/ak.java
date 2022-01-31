package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

final class ak
  implements Runnable
{
  ak(String paramString, Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    if ((this.a == null) || (this.a.trim().length() == 0))
    {
      StatServiceImpl.f().w("qq num is null or empty.");
      return;
    }
    StatConfig.f = this.a;
    StatServiceImpl.a(this.b, new StatAccount(this.a), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.ak
 * JD-Core Version:    0.7.0.1
 */