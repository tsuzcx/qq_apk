package com.tencent.qapmsdk.dns.network;

import android.content.Context;
import com.tencent.qapmsdk.common.logger.Logger;

public class NetworkHandler
{
  private static final NetworkHandler.INetworkHandler DEFAULT_NETWORK_HANDLER = new NetworkHandler.DefaultNetworkHandler();
  private static long DELAY = 2000L;
  private static final String TAG = "QAPM_DNS_NetworkHandler";
  private static NetworkHandler.INetworkHandler networkHandler;
  
  static void notifyNetworkChanged(Context paramContext)
  {
    if (networkHandler == null) {
      networkHandler = DEFAULT_NETWORK_HANDLER;
    }
    try
    {
      networkHandler.onNetworkChanged();
      return;
    }
    catch (Throwable paramContext)
    {
      Logger.INSTANCE.exception("QAPM_DNS_NetworkHandler", "onNetworkChanged handle error!!", paramContext);
    }
  }
  
  public static void setNetworkHandler(NetworkHandler.INetworkHandler paramINetworkHandler, long paramLong)
  {
    if ((paramINetworkHandler == null) || (paramLong < 0L)) {
      Logger.INSTANCE.w(new String[] { "QAPM_DNS_NetworkHandler", "Illegal Argument, handler is null or delay less than 0" });
    }
    networkHandler = paramINetworkHandler;
    DELAY = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.network.NetworkHandler
 * JD-Core Version:    0.7.0.1
 */