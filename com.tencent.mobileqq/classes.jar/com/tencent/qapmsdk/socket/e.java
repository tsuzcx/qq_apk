package com.tencent.qapmsdk.socket;

import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.socket.d.d.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class e
  implements SocketImplFactory
{
  private static Constructor<?> a;
  private SocketImplFactory b;
  
  public e()
  {
    Class localClass = com.tencent.qapmsdk.socket.d.d.a(Socket.class).a("impl").get(new Socket()).getClass();
    try
    {
      a = com.tencent.qapmsdk.socket.d.d.a(localClass).a(new Class[0]);
      Logger.INSTANCE.i(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "TrafficSocketImplFactory init success, SocketImpl: ", localClass.toString() });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        if ((localClass == d.class) && (a == null)) {
          if (!AndroidVersion.isN()) {
            a = com.tencent.qapmsdk.socket.d.d.a("java.net.PlainSocketImpl").a(new Class[0]);
          } else {
            a = com.tencent.qapmsdk.socket.d.d.a("java.net.SocksSocketImpl").a(new Class[0]);
          }
        }
      }
    }
  }
  
  public e(SocketImplFactory paramSocketImplFactory)
  {
    Logger.INSTANCE.i(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "TrafficSocketImplFactory init, old SocketImplFactory: ", paramSocketImplFactory.toString() });
    this.b = paramSocketImplFactory;
  }
  
  private static boolean a()
  {
    for (;;)
    {
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length <= 0)) {
          break;
        }
        i = 0;
        if (i >= arrayOfStackTraceElement.length) {
          break;
        }
        if (arrayOfStackTraceElement[i] != null)
        {
          boolean bool = arrayOfStackTraceElement[i].toString().contains("java.net.ServerSocket");
          if (!bool) {}
        }
      }
      catch (Exception localException1)
      {
        int i;
        return false;
      }
      try
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "socket stack contain ServerSocket" });
        return true;
      }
      catch (Exception localException2)
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public SocketImpl createSocketImpl()
  {
    if (this.b != null) {
      return new d(this.b.createSocketImpl());
    }
    try
    {
      if (a()) {
        return (SocketImpl)a.newInstance(new Object[0]);
      }
      d locald = new d((SocketImpl)a.newInstance(new Object[0]));
      return locald;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "create TrafficSocketImpl instance failed:", localThrowable.toString() });
      com.tencent.qapmsdk.socket.d.d.a(localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.e
 * JD-Core Version:    0.7.0.1
 */