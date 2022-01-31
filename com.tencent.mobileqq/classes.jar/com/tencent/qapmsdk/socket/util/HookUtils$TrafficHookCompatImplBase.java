package com.tencent.qapmsdk.socket.util;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.TrafficSocketImplFactory;
import com.tencent.qapmsdk.socket.ssl.TrafficOpenSSLProvider;
import com.tencent.qapmsdk.socket.ssl.TrafficSSLSocketFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImplFactory;
import java.security.Security;
import javax.net.ssl.SSLContext;

class HookUtils$TrafficHookCompatImplBase
  implements HookUtils.TrafficHookCompatImpl
{
  public void hook()
  {
    hookSocketFactoryImpl();
    Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "hook SocketFactoryImpl success" });
    Security.insertProviderAt(new TrafficOpenSSLProvider(), 1);
    Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "insert TrafficOpenSSLProvider success" });
    try
    {
      Security.setProperty("ssl.SocketFactory.provider", TrafficSSLSocketFactory.class.getName());
      Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "set ssl.SocketFactory.provider property success" });
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        try
        {
          SSLContext.setDefault(SSLContext.getInstance("Default"));
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "change default SSLContext success" });
          return;
        }
        catch (Exception localException)
        {
          Logger.INSTANCE.exception("QAPM_Socket_HookUtils", "update default sslcontext failed!", localException);
        }
        localNullPointerException = localNullPointerException;
        Logger.INSTANCE.exception("QAPM_Socket_HookUtils", "set socketfacotry provider failed!", localNullPointerException);
      }
    }
  }
  
  void hookSocketFactoryImpl()
  {
    try
    {
      Socket.setSocketImplFactory(new TrafficSocketImplFactory());
      return;
    }
    catch (IOException localIOException)
    {
      SocketImplFactory localSocketImplFactory;
      do
      {
        localSocketImplFactory = (SocketImplFactory)ReflectionHelper.of(Socket.class).field("factory").get(null);
      } while ((localSocketImplFactory instanceof TrafficSocketImplFactory));
      ReflectionHelper.of(Socket.class).field("factory").set(null, new TrafficSocketImplFactory(localSocketImplFactory));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.HookUtils.TrafficHookCompatImplBase
 * JD-Core Version:    0.7.0.1
 */