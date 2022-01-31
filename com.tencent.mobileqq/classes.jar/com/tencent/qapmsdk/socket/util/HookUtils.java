package com.tencent.qapmsdk.socket.util;

import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class HookUtils
{
  private static final HookUtils.TrafficHookCompatImpl HOOK_IMPL = new HookUtils.TrafficHookCompatImplBase(null);
  private static final String TAG = "QAPM_Socket_HookUtils";
  private static AtomicBoolean sInit = new AtomicBoolean();
  
  public static void hook()
  {
    if (sInit.getAndSet(true))
    {
      Logger.INSTANCE.w(new String[] { "QAPM_Socket_HookUtils", "qapm socket traffic monitor has been hooked!" });
      return;
    }
    try
    {
      HOOK_IMPL.hook();
      Logger.INSTANCE.i(new String[] { "QAPM_Socket_HookUtils", "qapm socket traffic hook all success!" });
      return;
    }
    catch (Throwable localThrowable)
    {
      ReflectionHelper.processException(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.HookUtils
 * JD-Core Version:    0.7.0.1
 */