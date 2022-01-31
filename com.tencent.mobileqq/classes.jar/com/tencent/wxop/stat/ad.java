package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

final class ad
  implements Runnable
{
  ad(Context paramContext, int paramInt) {}
  
  public final void run()
  {
    try
    {
      StatServiceImpl.flushDataToDB(this.a);
      au.a(this.a).a(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      StatServiceImpl.a(this.a, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.ad
 * JD-Core Version:    0.7.0.1
 */