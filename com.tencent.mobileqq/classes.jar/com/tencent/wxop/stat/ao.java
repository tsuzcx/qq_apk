package com.tencent.wxop.stat;

import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.d;

class ao
  implements Thread.UncaughtExceptionHandler
{
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((!StatConfig.isEnableStatService()) || (StatServiceImpl.e() == null)) {}
    do
    {
      do
      {
        return;
        if (StatConfig.isAutoExceptionCaught())
        {
          au.a(StatServiceImpl.e()).a(new d(StatServiceImpl.e(), StatServiceImpl.a(StatServiceImpl.e(), false, null), 2, paramThrowable, paramThread, null), null, false, true);
          StatServiceImpl.f().debug("MTA has caught the following uncaught exception:");
          StatServiceImpl.f().error(paramThrowable);
        }
        StatServiceImpl.flushDataToDB(StatServiceImpl.e());
      } while (StatServiceImpl.g() == null);
      StatServiceImpl.f().d("Call the original uncaught exception handler.");
    } while ((StatServiceImpl.g() instanceof ao));
    StatServiceImpl.g().uncaughtException(paramThread, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.ao
 * JD-Core Version:    0.7.0.1
 */