package com.tencent.qapmsdk.socket.d;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.e;
import com.tencent.qapmsdk.socket.ssl.TrafficSSLSocketFactory;
import com.tencent.qapmsdk.socket.ssl.a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImplFactory;
import java.security.Security;
import javax.net.ssl.SSLContext;

class b$b
  implements b.a
{
  public void a()
  {
    b();
    Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "hook SocketFactoryImpl success" });
    Security.insertProviderAt(new a(), 1);
    Logger.INSTANCE.d(new String[] { "QAPM_Socket_HookUtils", "insert TrafficOpenSslProvider success" });
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
  
  void b()
  {
    try
    {
      Socket.setSocketImplFactory(new e());
      return;
    }
    catch (IOException localIOException)
    {
      SocketImplFactory localSocketImplFactory;
      do
      {
        localSocketImplFactory = (SocketImplFactory)d.a(Socket.class).a("factory").get(null);
      } while ((localSocketImplFactory instanceof e));
      d.a(Socket.class).a("factory").set(null, new e(localSocketImplFactory));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.b.b
 * JD-Core Version:    0.7.0.1
 */