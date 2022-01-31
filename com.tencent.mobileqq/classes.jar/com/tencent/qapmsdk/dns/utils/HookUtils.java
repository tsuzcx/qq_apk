package com.tencent.qapmsdk.dns.utils;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.dns.HttpDns.Callback;

public class HookUtils
{
  private static final HookUtils.DnsHookCompatImpl HOOK_IMPL = new HookUtils.DNSHookCompatImplBase(null);
  private static final String TAG = "QAPM_DNS_HookUtils";
  
  static
  {
    if (AndroidVersion.isN())
    {
      HOOK_IMPL = new HookUtils.DNSHookCompatImplV24(null);
      return;
    }
  }
  
  public static void hook()
  {
    try
    {
      HOOK_IMPL.hook();
      Utils.getAsyncCallbackWrapper().onHook(true, null);
      Logger.INSTANCE.i(new String[] { "QAPM_DNS_HookUtils", "hook success!" });
      return;
    }
    catch (Throwable localThrowable)
    {
      Utils.getAsyncCallbackWrapper().onHook(false, localThrowable);
      Logger.INSTANCE.exception("QAPM_DNS_HookUtils", "hook failed!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.utils.HookUtils
 * JD-Core Version:    0.7.0.1
 */