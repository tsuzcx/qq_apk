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
    if (localObject3 == null) {}
    try
    {
      localObject1 = com.tencent.qapmsdk.socket.d.d.a(SocketImpl.class).a(paramString);
      a.put(paramString, localObject1);
      return localObject1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_Socket_TrafficSocketImpl", "get field ", paramString, " error: ", localNoSuchFieldException.toString() });
        Object localObject2 = b;
      }
    }
  }
  
  private void a(String paramString, Object paramObject1, Object paramObject2)
  {
    Object localObject = a(paramString);
    if ((localObject instanceof Field)) {
      localObject = (Field)localObject;
    }
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
    Object localObject1 = null;
    try
    {
      Object localObject2 = com.tencent.qapmsdk.socket.d.d.a(SocketImpl.class).a("fd").get(this);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label19:
      break label19;
    }
    return com.tencent.qapmsdk.socket.d.d.a(localObject1);
  }
  
  private int d()
  {
    if (this.c != null) {
      return this.c.hashCode();
    }
    return 0;
  }
  
  public SocketImpl a()
  {
    return this.c;
  }
  
  protected void accept(SocketImpl paramSocketImpl)
  {
    if (!TrafficMonitor.a().c()) {
      throw new IOException("Disable network by developer!");
    }
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
  
  protected int available()
  {
    try
    {
      Object localObject = com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("available", new Class[0]).invoke(this.c, new Object[0]);
      if (localObject != null)
      {
        int j = ((Integer)localObject).intValue();
        return j;
      }
    }
    catch (Exception localException)
    {
      if (((localException instanceof InvocationTargetException)) && ((localException.getCause() instanceof IOException))) {
        throw ((IOException)localException.getCause());
      }
      com.tencent.qapmsdk.socket.d.d.a(localException);
      throw new IOException(localException);
    }
    return 0;
  }
  
  protected void bind(InetAddress paramInetAddress, int paramInt)
  {
    if (!TrafficMonitor.a().c()) {
      throw new IOException("Disable network by developer!");
    }
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
      if ((localException instanceof InvocationTargetException))
      {
        if ((localException.getCause() instanceof IOException)) {
          throw ((IOException)localException.getCause());
        }
        if ((localException.getCause() instanceof NullPointerException)) {
          throw new IOException(localException);
        }
      }
      com.tencent.qapmsdk.socket.d.d.a(localException);
      throw new IOException(localException);
    }
  }
  
  protected void connect(String paramString, int paramInt)
  {
    if (!TrafficMonitor.a().c()) {
      throw new IOException("Disable network by developer!");
    }
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
  
  protected void connect(InetAddress paramInetAddress, int paramInt)
  {
    if (!TrafficMonitor.a().c()) {
      throw new IOException("Disable network by developer!");
    }
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
  
  protected void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    if (!TrafficMonitor.a().c()) {
      throw new IOException("Disable network by developer!");
    }
    InetSocketAddress localInetSocketAddress;
    if ((paramSocketAddress instanceof InetSocketAddress))
    {
      localInetSocketAddress = (InetSocketAddress)paramSocketAddress;
      if (AndroidVersion.isKitKat()) {}
      for (this.d = localInetSocketAddress.getHostString(); this.d == null; this.d = localInetSocketAddress.getHostName()) {
        throw new IOException("Can't find host");
      }
      if (!localInetSocketAddress.isUnresolved()) {
        break label213;
      }
    }
    for (localObject = "";; localObject = localInetSocketAddress.getAddress().getHostAddress())
    {
      this.e = ((String)localObject);
      if (this.d.equals(this.e)) {
        this.d = com.tencent.qapmsdk.dns.b.b.c(this.e);
      }
      this.f = localInetSocketAddress.getPort();
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
        label213:
        this.g.E = paramSocketAddress;
        a.a(false, this.d, this.f, SystemClock.elapsedRealtime() - l, this.g);
        if (!(paramSocketAddress instanceof InvocationTargetException)) {
          break label449;
        }
        boolean bool = AndroidVersion.isL();
        localObject = paramSocketAddress.getCause();
        if (!(localObject instanceof IOException)) {
          break;
        }
        throw ((IOException)localObject);
        if (!(localObject instanceof ClassCastException)) {
          break label305;
        }
        throw new IOException(paramSocketAddress);
        if ((!bool) || (!(localObject instanceof ErrnoException)) || (!((Throwable)localObject).getMessage().contains("EBADF"))) {
          break label341;
        }
        throw new IOException(paramSocketAddress);
        if ((!bool) || (!(localObject instanceof ErrnoException)) || (!((Throwable)localObject).getMessage().contains("EACCES"))) {
          break label377;
        }
        throw new IOException(paramSocketAddress);
        if ((!bool) || (!(localObject instanceof ErrnoException)) || (!((Throwable)localObject).getMessage().contains("ENOTSOCK"))) {
          break label413;
        }
        throw new IOException(paramSocketAddress);
        if ((!bool) || (!(localObject instanceof ErrnoException)) || (!((Throwable)localObject).getMessage().contains("ENETUNREACH"))) {
          break label449;
        }
        throw new IOException(paramSocketAddress);
        com.tencent.qapmsdk.socket.d.d.a(paramSocketAddress);
        throw new IOException(paramSocketAddress);
      }
    }
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
    if (!TrafficMonitor.a().c()) {
      throw new IOException("Disable network by developer!");
    }
    if (this.h == null) {}
    try
    {
      this.h = new b((InputStream)com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("getInputStream", new Class[0]).invoke(this.c, new Object[0]), this.g);
      this.g.F = false;
      return this.h;
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
    if (!TrafficMonitor.a().c()) {
      throw new IOException("Disable network by developer!");
    }
    if (this.i == null) {}
    try
    {
      this.i = new c((OutputStream)com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("getOutputStream", new Class[0]).invoke(this.c, new Object[0]), this.g);
      this.i.a(false, this.d, this.e, this.f, c(), d());
      return this.i;
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
    if (!TrafficMonitor.a().c()) {
      throw new IOException("Disable network by developer!");
    }
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
      super.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.qapmsdk.socket.d.d.a(localException);
      }
    }
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
      return "]";
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localStringBuilder.append(super.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d
 * JD-Core Version:    0.7.0.1
 */