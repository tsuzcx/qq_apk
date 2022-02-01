package com.tencent.qapmsdk.socket.d;

import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class b
{
  private static final b.a a = new b.b(null);
  private static AtomicBoolean b = new AtomicBoolean();
  
  public static void a()
  {
    if (b.getAndSet(true))
    {
      Logger.INSTANCE.w(new String[] { "QAPM_Socket_HookUtils", "qapm socket traffic monitor has been hooked!" });
      return;
    }
    try
    {
      a.a();
      Logger.INSTANCE.i(new String[] { "QAPM_Socket_HookUtils", "qapm socket traffic hook all success!" });
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.b
 * JD-Core Version:    0.7.0.1
 */