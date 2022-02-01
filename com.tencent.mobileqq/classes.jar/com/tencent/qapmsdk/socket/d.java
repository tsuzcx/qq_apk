package com.tencent.qapmsdk.socket;

import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.system.ErrnoException;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.socket.d.d.a;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class d
  extends SocketImpl
{
  private static final Map<String, Object> a = new ConcurrentHashMap();
  private static final Object b = new Object();
  private SocketImpl c;
  private String d;
  private String e;
  private int f;
  private com.tencent.qapmsdk.socket.c.a g = new com.tencent.qapmsdk.socket.c.a();
  private b h;
  private c i;
  
  d(SocketImpl paramSocketImpl)
  {
    this.c = paramSocketImpl;
    b();
  }
  
  private Object a(String paramString)
  {
    Object localObject3 = a.get(paramString);
    Object localObject1 = localObject3;
    Object localObject2;
    if (localObject3 == null)
    {
      try
      {
        localObject1 = com.tencent.qapmsdk.socket.d.d.a(SocketImpl.class).a(paramString);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficSocketImpl", "get field ", paramString, " error: ", localNoSuchFieldException.toString() });
        localObject2 = b;
      }
      a.put(paramString, localObject2);
    }
    return localObject2;
  }
  
  private void a(String paramString, Object paramObject1, Object paramObject2)
  {
    Object localObject = a(paramString);
    if ((localObject instanceof Field))
    {
      localObject = (Field)localObject;
      try
      {
        ((Field)localObject).set(paramObject2, ((Field)localObject).get(paramObject1));
        return;
      }
      catch (IllegalAccessException paramObject1)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficSocketImpl", "set field ", paramString, "error: ", paramObject1.toString() });
      }
    }
  }
  
  private void b()
  {
    a("fd", this.c, this);
    a("address", this.c, this);
    a("port", this.c, this);
    a("localport", this.c, this);
    a("socket", this, this.c);
    a("serverSocket", this, this.c);
  }
  
  private String c()
  {
    try
    {
      localObject = com.tencent.qapmsdk.socket.d.d.a(SocketImpl.class).a("fd").get(this);
    }
    catch (Exception localException)
    {
      Object localObject;
      label18:
      break label18;
    }
    localObject = null;
    return com.tencent.qapmsdk.socket.d.d.a(localObject);
  }
  
  private int d()
  {
    SocketImpl localSocketImpl = this.c;
    if (localSocketImpl != null) {
      return localSocketImpl.hashCode();
    }
    return 0;
  }
  
  public SocketImpl a()
  {
    return this.c;
  }
  
  protected void accept(SocketImpl paramSocketImpl)
  {
    if (TrafficMonitor.a().c()) {
      try
      {
        com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("accept", new Class[] { SocketImpl.class }).invoke(this.c, new Object[] { paramSocketImpl });
        b();
        return;
      }
      catch (Exception paramSocketImpl)
      {
        if (((paramSocketImpl instanceof InvocationTargetException)) && ((paramSocketImpl.getCause() instanceof IOException))) {
          throw ((IOException)paramSocketImpl.getCause());
        }
        com.tencent.qapmsdk.socket.d.d.a(paramSocketImpl);
        throw new IOException(paramSocketImpl);
      }
    }
    throw new IOException("Disable network by developer!");
  }
  
  protected int available()
  {
    try
    {
      Object localObject = com.tencent.qapmsdk.socket.d.d.a(this.c.getClass());
      int j = 0;
      localObject = ((d.a)localObject).a("available", new Class[0]).invoke(this.c, new Object[0]);
      if (localObject != null) {
        j = ((Integer)localObject).intValue();
      }
      return j;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      com.tencent.qapmsdk.socket.d.d.a(localException);
      throw new IOException(localException);
    }
  }
  
  protected void bind(InetAddress paramInetAddress, int paramInt)
  {
    if (TrafficMonitor.a().c()) {
      try
      {
        com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("bind", new Class[] { InetAddress.class, Integer.TYPE }).invoke(this.c, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
        b();
        return;
      }
      catch (Exception paramInetAddress)
      {
        if (((paramInetAddress instanceof InvocationTargetException)) && ((paramInetAddress.getCause() instanceof IOException))) {
          throw ((IOException)paramInetAddress.getCause());
        }
        com.tencent.qapmsdk.socket.d.d.a(paramInetAddress);
        throw new IOException(paramInetAddress);
      }
    }
    throw new IOException("Disable network by developer!");
  }
  
  protected void close()
  {
    try
    {
      com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("close", new Class[0]).invoke(this.c, new Object[0]);
      com.tencent.qapmsdk.impl.e.c.a().d();
      b();
      return;
    }
    catch (Exception localException)
    {
      if ((localException instanceof InvocationTargetException)) {
        if (!(localException.getCause() instanceof IOException))
        {
          if ((localException.getCause() instanceof NullPointerException)) {
            throw new IOException(localException);
          }
        }
        else {
          throw ((IOException)localException.getCause());
        }
      }
      com.tencent.qapmsdk.socket.d.d.a(localException);
      throw new IOException(localException);
    }
  }
  
  protected void connect(String paramString, int paramInt)
  {
    if (TrafficMonitor.a().c())
    {
      this.d = paramString;
      this.e = "";
      this.f = paramInt;
      long l = SystemClock.elapsedRealtime();
      try
      {
        com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("connect", new Class[] { String.class, Integer.TYPE }).invoke(this.c, new Object[] { paramString, Integer.valueOf(paramInt) });
        a.a(true, this.d, this.f, SystemClock.elapsedRealtime() - l, this.g);
        b();
        return;
      }
      catch (Exception paramString)
      {
        this.g.E = paramString;
        a.a(false, this.d, this.f, SystemClock.elapsedRealtime() - l, this.g);
        if (((paramString instanceof InvocationTargetException)) && ((paramString.getCause() instanceof IOException))) {
          throw ((IOException)paramString.getCause());
        }
        com.tencent.qapmsdk.socket.d.d.a(paramString);
        throw new IOException(paramString);
      }
    }
    throw new IOException("Disable network by developer!");
  }
  
  protected void connect(InetAddress paramInetAddress, int paramInt)
  {
    if (TrafficMonitor.a().c())
    {
      this.d = paramInetAddress.getHostName();
      this.e = paramInetAddress.getHostAddress();
      this.f = paramInt;
      long l = SystemClock.elapsedRealtime();
      try
      {
        com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("connect", new Class[] { InetAddress.class, Integer.TYPE }).invoke(this.c, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
        a.a(true, this.d, this.f, SystemClock.elapsedRealtime() - l, this.g);
        b();
        return;
      }
      catch (Exception paramInetAddress)
      {
        this.g.E = paramInetAddress;
        a.a(false, this.d, this.f, SystemClock.elapsedRealtime() - l, this.g);
        if (((paramInetAddress instanceof InvocationTargetException)) && ((paramInetAddress.getCause() instanceof IOException))) {
          throw ((IOException)paramInetAddress.getCause());
        }
        com.tencent.qapmsdk.socket.d.d.a(paramInetAddress);
        throw new IOException(paramInetAddress);
      }
    }
    throw new IOException("Disable network by developer!");
  }
  
  protected void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    if (TrafficMonitor.a().c())
    {
      Object localObject;
      if ((paramSocketAddress instanceof InetSocketAddress))
      {
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramSocketAddress;
        if (AndroidVersion.isKitKat()) {
          this.d = localInetSocketAddress.getHostString();
        } else {
          this.d = localInetSocketAddress.getHostName();
        }
        if (this.d != null)
        {
          if (localInetSocketAddress.isUnresolved()) {
            localObject = "";
          } else {
            localObject = localInetSocketAddress.getAddress().getHostAddress();
          }
          this.e = ((String)localObject);
          if (this.d.equals(this.e)) {
            this.d = com.tencent.qapmsdk.dns.b.b.c(this.e);
          }
          this.f = localInetSocketAddress.getPort();
        }
        else
        {
          throw new IOException("Can't find host");
        }
      }
      long l = SystemClock.elapsedRealtime();
      try
      {
        com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("connect", new Class[] { SocketAddress.class, Integer.TYPE }).invoke(this.c, new Object[] { paramSocketAddress, Integer.valueOf(paramInt) });
        a.a(true, this.d, this.f, SystemClock.elapsedRealtime() - l, this.g);
        b();
        return;
      }
      catch (Exception paramSocketAddress)
      {
        this.g.E = paramSocketAddress;
        a.a(false, this.d, this.f, SystemClock.elapsedRealtime() - l, this.g);
        if ((paramSocketAddress instanceof InvocationTargetException))
        {
          boolean bool = AndroidVersion.isL();
          localObject = paramSocketAddress.getCause();
          if (!(localObject instanceof IOException))
          {
            if (!(localObject instanceof ClassCastException))
            {
              if ((bool) && ((localObject instanceof ErrnoException)) && (((Throwable)localObject).getMessage().contains("EBADF"))) {
                throw new IOException(paramSocketAddress);
              }
              if ((bool) && ((localObject instanceof ErrnoException)) && (((Throwable)localObject).getMessage().contains("EACCES"))) {
                throw new IOException(paramSocketAddress);
              }
              if ((bool) && ((localObject instanceof ErrnoException)) && (((Throwable)localObject).getMessage().contains("ENOTSOCK"))) {
                throw new IOException(paramSocketAddress);
              }
              if ((bool) && ((localObject instanceof ErrnoException)) && (((Throwable)localObject).getMessage().contains("ENETUNREACH"))) {
                throw new IOException(paramSocketAddress);
              }
            }
            else
            {
              throw new IOException(paramSocketAddress);
            }
          }
          else {
            throw ((IOException)localObject);
          }
        }
        com.tencent.qapmsdk.socket.d.d.a(paramSocketAddress);
        throw new IOException(paramSocketAddress);
      }
    }
    throw new IOException("Disable network by developer!");
  }
  
  protected void create(boolean paramBoolean)
  {
    try
    {
      com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("create", new Class[] { Boolean.TYPE }).invoke(this.c, new Object[] { Boolean.valueOf(paramBoolean) });
      b();
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      com.tencent.qapmsdk.socket.d.d.a(localException);
      throw new IOException(localException);
    }
  }
  
  protected FileDescriptor getFileDescriptor()
  {
    try
    {
      Object localObject = com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("getFileDescriptor", new Class[0]).invoke(this.c, new Object[0]);
      if (localObject != null)
      {
        localObject = (FileDescriptor)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      com.tencent.qapmsdk.socket.d.d.a(localException);
    }
    return super.getFileDescriptor();
  }
  
  protected InetAddress getInetAddress()
  {
    try
    {
      Object localObject = com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("getInetAddress", new Class[0]).invoke(this.c, new Object[0]);
      if (localObject != null)
      {
        localObject = (InetAddress)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      com.tencent.qapmsdk.socket.d.d.a(localException);
    }
    return super.getInetAddress();
  }
  
  protected InputStream getInputStream()
  {
    if (TrafficMonitor.a().c())
    {
      if (this.h == null) {
        try
        {
          this.h = new b((InputStream)com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("getInputStream", new Class[0]).invoke(this.c, new Object[0]), this.g);
        }
        catch (Exception localException)
        {
          if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
            throw ((IOException)localException.getCause());
          }
          com.tencent.qapmsdk.socket.d.d.a(localException);
          throw new IOException(localException);
        }
      }
      this.g.F = false;
      return this.h;
    }
    throw new IOException("Disable network by developer!");
  }
  
  protected int getLocalPort()
  {
    try
    {
      Object localObject = com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("getLocalPort", new Class[0]).invoke(this.c, new Object[0]);
      if (localObject != null)
      {
        int j = ((Integer)localObject).intValue();
        return j;
      }
    }
    catch (Exception localException)
    {
      com.tencent.qapmsdk.socket.d.d.a(localException);
    }
    return super.getLocalPort();
  }
  
  public Object getOption(int paramInt)
  {
    return this.c.getOption(paramInt);
  }
  
  protected OutputStream getOutputStream()
  {
    if (TrafficMonitor.a().c())
    {
      if (this.i == null) {
        try
        {
          this.i = new c((OutputStream)com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("getOutputStream", new Class[0]).invoke(this.c, new Object[0]), this.g);
          this.i.a(false, this.d, this.e, this.f, c(), d());
        }
        catch (Exception localException)
        {
          if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
            throw ((IOException)localException.getCause());
          }
          com.tencent.qapmsdk.socket.d.d.a(localException);
          throw new IOException(localException);
        }
      }
      return this.i;
    }
    throw new IOException("Disable network by developer!");
  }
  
  protected int getPort()
  {
    try
    {
      Object localObject = com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("getPort", new Class[0]).invoke(this.c, new Object[0]);
      if (localObject != null)
      {
        int j = ((Integer)localObject).intValue();
        return j;
      }
    }
    catch (Exception localException)
    {
      com.tencent.qapmsdk.socket.d.d.a(localException);
    }
    return super.getPort();
  }
  
  protected void listen(int paramInt)
  {
    if (TrafficMonitor.a().c()) {
      try
      {
        com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("listen", new Class[] { Integer.TYPE }).invoke(this.c, new Object[] { Integer.valueOf(this.port) });
        b();
        return;
      }
      catch (Exception localException)
      {
        if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
          throw ((IOException)localException.getCause());
        }
        com.tencent.qapmsdk.socket.d.d.a(localException);
        throw new IOException(localException);
      }
    }
    throw new IOException("Disable network by developer!");
  }
  
  protected void sendUrgentData(int paramInt)
  {
    try
    {
      com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("sendUrgentData", new Class[] { Integer.TYPE }).invoke(this.c, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      com.tencent.qapmsdk.socket.d.d.a(localException);
      throw new IOException(localException);
    }
  }
  
  public void setOption(int paramInt, Object paramObject)
  {
    this.c.setOption(paramInt, paramObject);
  }
  
  protected void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("setPerformancePreferences", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }).invoke(this.c, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    catch (Exception localException)
    {
      com.tencent.qapmsdk.socket.d.d.a(localException);
    }
    super.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
  }
  
  protected void shutdownInput()
  {
    try
    {
      com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("shutdownInput", new Class[0]).invoke(this.c, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      com.tencent.qapmsdk.socket.d.d.a(localException);
      throw new IOException(localException);
    }
  }
  
  protected void shutdownOutput()
  {
    try
    {
      com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("shutdownOutput", new Class[0]).invoke(this.c, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      com.tencent.qapmsdk.socket.d.d.a(localException);
      throw new IOException(localException);
    }
  }
  
  protected boolean supportsUrgentData()
  {
    try
    {
      Object localObject = com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("supportsUrgentData", new Class[0]).invoke(this.c, new Object[0]);
      if (localObject != null)
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Exception localException)
    {
      com.tencent.qapmsdk.socket.d.d.a(localException);
    }
    return super.supportsUrgentData();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TrafficSocketImpl[");
    try
    {
      localStringBuilder.append(com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("toString", new Class[0]).invoke(this.c, new Object[0]));
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    localStringBuilder.append(super.toString());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d
 * JD-Core Version:    0.7.0.1
 */