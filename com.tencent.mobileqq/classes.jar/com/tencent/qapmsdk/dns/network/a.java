package com.tencent.qapmsdk.dns.network;

import android.content.Context;
import com.tencent.qapmsdk.common.logger.Logger;

public class a
{
  private static a.b a;
  private static long b = 2000L;
  private static final a.b c = new a.a();
  
  static void a(Context paramContext)
  {
    if (a == null) {
      a = c;
    }
    try
    {
      a.a();
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.INSTANCE.exception("QAPM_DNS_NetworkHandler", "onNetworkChanged handle error!!", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.a
 * JD-Core Version:    0.7.0.1
 */