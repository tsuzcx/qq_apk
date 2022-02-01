package com.tencent.qapmsdk.dns.d;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;

public class a
{
  private static final a.a a = new a.b(null);
  
  static
  {
    if (AndroidVersion.isN())
    {
      a = new a.c(null);
      return;
    }
  }
  
  public static void a()
  {
    try
    {
      a.a();
      b.a().a(true, null);
      Logger.INSTANCE.i(new String[] { "QAPM_DNS_HookUtils", "hook success!" });
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a().a(false, localThrowable);
      Logger.INSTANCE.exception("QAPM_DNS_HookUtils", "hook failed!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.d.a
 * JD-Core Version:    0.7.0.1
 */