package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.SocketTimeoutException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class c
  extends SocketImpl
{
  public static String k = "notfound";
  public static short l = 0;
  public static short m = 1;
  static ConcurrentHashMap n = new ConcurrentHashMap();
  static ConcurrentHashMap o = new ConcurrentHashMap();
  private static final int s = 30000;
  private static HandlerThread t = new HandlerThread("MsfSocketTimeoutChecker");
  private static Handler u;
  private static int v = 0;
  private static long w = 0L;
  private static long x = 0L;
  private static CopyOnWriteArrayList y = new CopyOnWriteArrayList();
  public String a = "";
  public String b = "";
  public int c;
  public String d;
  public String e = "";
  public String f = "";
  public MonitorHttpInfo g;
  MonitorSocketInputStream h;
  MonitorSocketOutputStream i;
  String j;
  public Context p;
  private SocketImpl q;
  private Class r;
  
  public c(Class paramClass, Context paramContext)
  {
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      localConstructor.setAccessible(true);
      this.q = ((SocketImpl)localConstructor.newInstance(new Object[0]));
      this.p = paramContext;
      this.r = paramClass;
      e();
      b();
      BaseApplication.httpMonitorBan = paramContext.getSharedPreferences("StepUpdate", 4).getBoolean("httpMonitorBan", false);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    try
    {
      a(paramClass, "wait", new Class[0]);
      return;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
  }
  
  public static Method a(Class paramClass, String paramString, Class... paramVarArgs)
  {
    new StringBuilder();
    try
    {
      Method localMethod = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      return localMethod;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    paramClass = paramClass.getSuperclass();
    if (paramClass == null) {
      return null;
    }
    return a(paramClass, paramString, paramVarArgs);
  }
  
  private void a(b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.MonitorSocket", 2, paramb.toString());
    } else if (paramb.f > 500000L) {
      QLog.d("MSF.D.MonitorSocket", 1, paramb.toString());
    }
    v += 1;
    w += paramb.f;
    y.addIfAbsent(paramb.h);
    long l1 = System.currentTimeMillis();
    if (l1 - x > 60000L)
    {
      if ((v > 1000) || (w > 100000000L))
      {
        paramb = new StringBuilder();
        paramb.append("netflowSize:");
        paramb.append(w);
        paramb.append(" ,netflowCount:");
        paramb.append(v);
        paramb.append(" ,mType:");
        paramb.append(y.toString());
        QLog.i("MSF.D.MonitorSocket", 1, paramb.toString());
      }
      v = 0;
      w = 0L;
      x = l1;
      y.clear();
    }
  }
  
  private void e()
  {
    try
    {
      Object localObject = Socket.class.getClassLoader().loadClass("java.net.SocketImpl").getDeclaredMethod("getFileDescriptor", new Class[0]);
      ((Method)localObject).setAccessible(true);
      this.fd = ((FileDescriptor)((Method)localObject).invoke(this.q, new Object[0]));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.fd.hashCode());
      ((StringBuilder)localObject).append(" ");
      this.e = ((StringBuilder)localObject).toString();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      try
      {
        Field localField = SocketImpl.class.getDeclaredField("fd");
        localField.setAccessible(true);
        localField.set(this.q, this.fd);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private int g()
  {
    if (this.fd == null) {
      return -1;
    }
    try
    {
      Field localField = FileDescriptor.class.getDeclaredField("descriptor");
      localField.setAccessible(true);
      int i1 = ((Integer)localField.get(this.fd)).intValue();
      return i1;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, localThrowable.getMessage());
      }
    }
    return -1;
  }
  
  private boolean h()
  {
    if (this.fd == null) {
      return false;
    }
    Object localObject;
    if (Build.VERSION.SDK_INT >= 23) {
      localObject = "isSocket$";
    } else {
      localObject = "isSocket";
    }
    try
    {
      localObject = FileDescriptor.class.getClassLoader().loadClass("java.io.FileDescriptor").getDeclaredMethod((String)localObject, new Class[0]);
      ((Method)localObject).setAccessible(true);
      boolean bool = ((Boolean)((Method)localObject).invoke(this.fd, new Object[0])).booleanValue();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, localThrowable.getMessage());
      }
    }
    return false;
  }
  
  private void i()
  {
    Object localObject = new StringWriter();
    new PrintWriter((Writer)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((StringWriter)localObject).toString());
    localStringBuilder.append("_");
    this.f = localStringBuilder.toString();
    int i2 = this.f.lastIndexOf("com.tencent");
    int i1 = i2;
    if (i2 <= 0) {
      i1 = this.f.lastIndexOf("qq");
    }
    i2 = i1;
    if (i1 <= 0) {
      i2 = this.f.lastIndexOf("qzone");
    }
    if (i2 > 0)
    {
      i1 = this.f.indexOf(")", i2);
      if ((i1 > 0) && (i1 > i2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.f.substring(i2, i1 + 1));
        ((StringBuilder)localObject).append("_");
        this.f = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.f.substring(i2));
        ((StringBuilder)localObject).append("_");
        this.f = ((StringBuilder)localObject).toString();
      }
    }
    if (this.fd != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.fd.hashCode());
      ((StringBuilder)localObject).append(" ");
      this.e = ((StringBuilder)localObject).toString();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("_ ");
    this.e = ((StringBuilder)localObject).toString();
  }
  
  private void j()
  {
    for (;;)
    {
      try
      {
        if ((!BaseApplication.httpMonitorBan) && (this.g != null))
        {
          String str1;
          if (BaseApplication.networkMonitorCallback != null)
          {
            if ((this.g.getFileType() == 1) || (this.g.getFileType() == 2))
            {
              q.b().post(new d(this));
              if (QLog.isColorLevel())
              {
                str3 = this.g.toString();
                if (this.d == null) {
                  break label228;
                }
                str1 = this.d;
                QLog.d("MSF.D.MonitorSocket", 2, new Object[] { str3, " ProcessName=", str1 });
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            str3 = this.g.toString();
            if (this.d == null) {
              break label234;
            }
            str1 = this.d;
            QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "report failed ", str3, " ProcessName=", str1 });
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        String str3;
        if (QLog.isColorLevel())
        {
          str3 = localThrowable.toString();
          str2 = this.d;
          if (str2 == null) {
            str2 = "";
          }
          QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "report failed ", str3, " ProcessName=", str2 });
        }
      }
      return;
      label228:
      String str2 = "";
      continue;
      label234:
      str2 = "";
    }
  }
  
  public Handler a()
  {
    return u;
  }
  
  public Runnable a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "addSocketTimeoutCheck keyHashCode is 0.");
      }
      return null;
    }
    b localb;
    if (l == paramInt2) {
      localb = (b)o.get(Integer.valueOf(paramInt1));
    } else if (m == paramInt2) {
      localb = (b)n.get(Integer.valueOf(paramInt1));
    } else {
      localb = null;
    }
    if (localb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "addSocketTimeoutCheck dataFlowItem is null.");
      }
      return null;
    }
    c.a locala = new c.a(this, paramInt1, paramInt2);
    localb.l = locala;
    u.postDelayed(locala, 30000L);
    return locala;
  }
  
  protected void accept(SocketImpl paramSocketImpl) {}
  
  protected int available()
  {
    try
    {
      Method localMethod = a(this.r, "available", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.q, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void b()
  {
    this.d = MsfSdkUtils.getProcessName(this.p);
    try
    {
      if (u == null) {
        synchronized (t)
        {
          if (u == null)
          {
            if (!t.isAlive())
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder1 = new StringBuilder();
                localStringBuilder1.append("initSocketTimeoutChecker PID=");
                localStringBuilder1.append(Process.myPid());
                localStringBuilder1.append(" TID=");
                localStringBuilder1.append(t.getId());
                QLog.d("MSF.D.MonitorSocket", 2, localStringBuilder1.toString());
              }
              t.start();
            }
            u = new Handler(t.getLooper());
          }
          return;
        }
      }
      StringBuilder localStringBuilder2;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("initHandler exception ");
      localStringBuilder2.append(localException.toString());
      QLog.d("MSF.D.MonitorSocket", 1, localStringBuilder2.toString());
    }
  }
  
  protected void bind(InetAddress paramInetAddress, int paramInt)
  {
    try
    {
      Method localMethod = a(this.r, "bind", new Class[] { InetAddress.class, Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.q, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramInetAddress)
    {
      paramInetAddress.printStackTrace();
    }
  }
  
  public void c()
  {
    try
    {
      if ((this.d != null) && (this.d.endsWith(":MSF")) && (MsfCore.sCore.statReporter != null))
      {
        MsfCore.sCore.statReporter.b(this.r.getName());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void close()
  {
    Object localObject;
    try
    {
      localObject = a(this.r, "close", new Class[0]);
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(this.q, new Object[0]);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" close MonitorSocket succ.");
        QLog.d("MSF.D.MonitorSocket", 2, ((StringBuilder)localObject).toString());
      }
      localObject = null;
    }
    catch (Exception localException)
    {
      localObject = localException;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append("close MonitorSocket failed.");
        QLog.d("MSF.D.MonitorSocket", 2, ((StringBuilder)localObject).toString(), localException);
        localObject = localException;
      }
    }
    try
    {
      j();
      boolean bool = n.isEmpty();
      b localb;
      if (!bool)
      {
        localb = (b)n.remove(Integer.valueOf(this.e.hashCode()));
        if ((localb != null) && (!TextUtils.isEmpty(this.f)))
        {
          if ((TextUtils.isEmpty(localb.h)) || (localb.h.equals(k))) {
            localb.h = this.f.substring(0, this.f.indexOf("_"));
          }
          BaseApplication.monitor.insertData(localb);
          if (localb.l != null)
          {
            u.removeCallbacks(localb.l);
            localb.l = null;
          }
          a(localb);
        }
      }
      if (!o.isEmpty())
      {
        localb = (b)o.remove(Integer.valueOf(this.e.hashCode()));
        if ((localb != null) && (!TextUtils.isEmpty(this.f)))
        {
          if ((TextUtils.isEmpty(localb.h)) || (localb.h.equals(k))) {
            localb.h = this.f.substring(0, this.f.indexOf("_"));
          }
          BaseApplication.monitor.insertData(localb);
          if (localb.l != null)
          {
            u.removeCallbacks(localb.l);
            localb.l = null;
          }
          a(localb);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.D.MonitorSocket", 2, localThrowable.getMessage(), localThrowable);
      }
    }
    if (localObject == null) {
      return;
    }
    throw new IOException(((Exception)localObject).toString());
  }
  
  protected void connect(String paramString, int paramInt)
  {
    this.b = paramString;
    this.c = paramInt;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("connect to host 1 ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" fd=");
      ((StringBuilder)localObject).append(g());
      ((StringBuilder)localObject).append(" isSocket=");
      ((StringBuilder)localObject).append(h());
      QLog.d("MSF.D.MonitorSocket", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      e();
      localObject = a(this.r, "connect", new Class[] { String.class, Integer.TYPE });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(this.q, new Object[] { paramString, Integer.valueOf(paramInt) });
      e();
      i();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append("connect to host 1 ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" succ.");
        QLog.d("MSF.D.MonitorSocket", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    catch (Exception paramString)
    {
      if ((paramString instanceof InvocationTargetException)) {
        throw new IOException(((InvocationTargetException)paramString).getTargetException().toString());
      }
      throw new IOException(paramString.toString());
    }
  }
  
  protected void connect(InetAddress paramInetAddress, int paramInt)
  {
    try
    {
      this.b = paramInetAddress.getHostName();
      this.c = paramInt;
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append("connect to host 2 ");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(" fd=");
        ((StringBuilder)localObject).append(g());
        ((StringBuilder)localObject).append(" isSocket=");
        ((StringBuilder)localObject).append(h());
        QLog.d("MSF.D.MonitorSocket", 2, ((StringBuilder)localObject).toString());
      }
      e();
      Object localObject = a(this.r, "connect", new Class[] { InetAddress.class, Integer.TYPE });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(this.q, new Object[] { paramInetAddress, Integer.valueOf(paramInt) });
      e();
      i();
      if (QLog.isColorLevel())
      {
        paramInetAddress = new StringBuilder();
        paramInetAddress.append(this.e);
        paramInetAddress.append("connect to host 2 ");
        paramInetAddress.append(this.b);
        paramInetAddress.append(" succ.");
        QLog.d("MSF.D.MonitorSocket", 2, paramInetAddress.toString());
      }
      return;
    }
    catch (Exception paramInetAddress)
    {
      if ((paramInetAddress instanceof InvocationTargetException)) {
        throw new IOException(((InvocationTargetException)paramInetAddress).getTargetException().toString());
      }
      throw new IOException(paramInetAddress.toString());
    }
  }
  
  public void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    try
    {
      localObject = ((InetSocketAddress)paramSocketAddress).getAddress();
      if (localObject == null)
      {
        l1 = l2;
        this.b = ((InetSocketAddress)paramSocketAddress).getHostName();
      }
      else
      {
        l1 = l2;
        this.b = ((InetAddress)localObject).getHostAddress();
      }
      l1 = l2;
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        l1 = l2;
        localObject = new StringBuilder();
        l1 = l2;
        ((StringBuilder)localObject).append(this.e);
        l1 = l2;
        ((StringBuilder)localObject).append("connect to host 3 ");
        l1 = l2;
        ((StringBuilder)localObject).append(this.b);
        l1 = l2;
        ((StringBuilder)localObject).append(" fd=");
        l1 = l2;
        ((StringBuilder)localObject).append(g());
        l1 = l2;
        ((StringBuilder)localObject).append(" isSocket=");
        l1 = l2;
        ((StringBuilder)localObject).append(h());
        l1 = l2;
        QLog.d("MSF.D.MonitorSocket", 1, ((StringBuilder)localObject).toString());
      }
      l1 = l2;
      e();
      l1 = l2;
      localObject = a(this.r, "connect", new Class[] { SocketAddress.class, Integer.TYPE });
      l1 = l2;
      ((Method)localObject).setAccessible(true);
      l1 = l2;
      l2 = System.currentTimeMillis();
      l1 = l2;
      ((Method)localObject).invoke(this.q, new Object[] { paramSocketAddress, Integer.valueOf(paramInt) });
      l1 = l2;
      e();
      l1 = l2;
      i();
      l1 = l2;
      if (QLog.isColorLevel())
      {
        l1 = l2;
        paramSocketAddress = new StringBuilder();
        l1 = l2;
        paramSocketAddress.append(this.e);
        l1 = l2;
        paramSocketAddress.append("connect to host 3 ");
        l1 = l2;
        paramSocketAddress.append(this.b);
        l1 = l2;
        paramSocketAddress.append(" succ. impl:");
        l1 = l2;
        paramSocketAddress.append(toString());
        l1 = l2;
        QLog.d("MSF.D.MonitorSocket", 1, paramSocketAddress.toString());
      }
      return;
    }
    catch (Exception paramSocketAddress)
    {
      if (System.currentTimeMillis() - l1 < paramInt)
      {
        if ((paramSocketAddress instanceof InvocationTargetException)) {
          throw new IOException(((InvocationTargetException)paramSocketAddress).getTargetException().toString());
        }
        throw new IOException(paramSocketAddress.toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("timeoutexception ");
      ((StringBuilder)localObject).append(paramSocketAddress.toString());
      throw new SocketTimeoutException(((StringBuilder)localObject).toString());
    }
  }
  
  protected void create(boolean paramBoolean)
  {
    try
    {
      Method localMethod = a(this.r, "create", new Class[] { Boolean.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.q, new Object[] { Boolean.valueOf(paramBoolean) });
      e();
      return;
    }
    catch (Exception localException)
    {
      throw new IOException(localException.toString());
    }
  }
  
  protected InetAddress getInetAddress()
  {
    try
    {
      Object localObject = a(this.r, "getInetAddress", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (InetAddress)((Method)localObject).invoke(this.q, new Object[0]);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  protected InputStream getInputStream()
  {
    try
    {
      f();
      Object localObject = a(this.r, "getInputStream", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = new MonitorSocketInputStream((InputStream)((Method)localObject).invoke(this.q, new Object[0]), this, this.p);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new IOException(localException.toString());
    }
  }
  
  public Object getOption(int paramInt)
  {
    return this.q.getOption(paramInt);
  }
  
  protected OutputStream getOutputStream()
  {
    try
    {
      f();
      Object localObject = a(this.r, "getOutputStream", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = new MonitorSocketOutputStream((OutputStream)((Method)localObject).invoke(this.q, new Object[0]), this, this.p);
      this.i = ((MonitorSocketOutputStream)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new IOException(localException.toString());
    }
  }
  
  protected int getPort()
  {
    try
    {
      Method localMethod = a(this.r, "getPort", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.q, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  protected void listen(int paramInt) {}
  
  protected void sendUrgentData(int paramInt)
  {
    try
    {
      Method localMethod = a(this.r, "sendUrgentData", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.q, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      throw new IOException(localException.toString());
    }
  }
  
  public void setOption(int paramInt, Object paramObject)
  {
    SocketImpl localSocketImpl = this.q;
    if (localSocketImpl != null) {
      localSocketImpl.setOption(paramInt, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.c
 * JD-Core Version:    0.7.0.1
 */