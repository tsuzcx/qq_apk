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
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label45:
      break label45;
    }
    if ((localClass == d.class) && (a == null)) {
      if (!AndroidVersion.isN()) {
        a = com.tencent.qapmsdk.socket.d.d.a("java.net.PlainSocketImpl").a(new Class[0]);
      } else {
        a = com.tencent.qapmsdk.socket.d.d.a("java.net.SocksSocketImpl").a(new Class[0]);
      }
    }
    Logger.INSTANCE.i(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "TrafficSocketImplFactory init success, SocketImpl: ", localClass.toString() });
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
        if ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length > 0))
        {
          i = 0;
          if (i < arrayOfStackTraceElement.length) {
            if (arrayOfStackTraceElement[i] != null)
            {
              boolean bool = arrayOfStackTraceElement[i].toString().contains("java.net.ServerSocket");
              if (!bool) {}
            }
          }
        }
      }
      catch (Exception localException1)
      {
        int i;
        continue;
      }
      try
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "socket stack contain ServerSocket" });
        return true;
      }
      catch (Exception localException2) {}
      i += 1;
      continue;
      return false;
    }
    return true;
  }
  
  public SocketImpl createSocketImpl()
  {
    Object localObject = this.b;
    if (localObject != null) {
      return new d(((SocketImplFactory)localObject).createSocketImpl());
    }
    try
    {
      if (a()) {
        return (SocketImpl)a.newInstance(new Object[0]);
      }
      localObject = new d((SocketImpl)a.newInstance(new Object[0]));
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficSocketImplFactory", "create TrafficSocketImpl instance failed:", localThrowable.toString() });
      com.tencent.qapmsdk.socket.d.d.a(localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.e
 * JD-Core Version:    0.7.0.1
 */