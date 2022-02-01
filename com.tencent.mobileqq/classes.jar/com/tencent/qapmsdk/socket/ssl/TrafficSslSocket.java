package com.tencent.qapmsdk.socket.ssl;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.socket.TrafficMonitor;
import com.tencent.qapmsdk.socket.TrafficMonitor.a;
import com.tencent.qapmsdk.socket.b;
import com.tencent.qapmsdk.socket.d.d.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.nio.channels.SocketChannel;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class TrafficSslSocket
  extends SSLSocket
{
  private static final String b;
  c a;
  private SSLSocket c;
  private b d;
  private com.tencent.qapmsdk.socket.c e;
  private com.tencent.qapmsdk.socket.c.a f;
  private String g;
  private String h;
  private int i;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.qapmsdk.socket.d.d.a());
    localStringBuilder.append(".OpenSSLSocketImpl");
    b = localStringBuilder.toString();
  }
  
  TrafficSslSocket(Socket paramSocket, String paramString, int paramInt)
  {
    this(paramSocket, paramString, null, paramInt);
  }
  
  private TrafficSslSocket(Socket paramSocket, String paramString, InetAddress paramInetAddress, int paramInt)
  {
    this.c = ((SSLSocket)paramSocket);
    this.f = new com.tencent.qapmsdk.socket.c.a();
    this.g = paramString;
    if (paramInetAddress != null) {
      this.h = paramInetAddress.getHostAddress();
    } else if (paramSocket.getInetAddress() != null) {
      this.h = paramSocket.getInetAddress().getHostAddress();
    } else {
      this.h = "";
    }
    this.i = paramInt;
    a(paramString);
  }
  
  TrafficSslSocket(Socket paramSocket, InetAddress paramInetAddress, int paramInt)
  {
    this(paramSocket, paramInetAddress.getHostName(), paramInetAddress, paramInt);
  }
  
  private String a()
  {
    try
    {
      localObject = (Socket)com.tencent.qapmsdk.socket.d.d.a(b).a("socket").get(this.c);
      localObject = com.tencent.qapmsdk.socket.d.d.a(Socket.class).a("impl").get(localObject);
      localObject = com.tencent.qapmsdk.socket.d.d.a(SocketImpl.class).a("fd").get(localObject);
    }
    catch (Exception localException)
    {
      Object localObject;
      label55:
      break label55;
    }
    localObject = null;
    return com.tencent.qapmsdk.socket.d.d.a(localObject);
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = com.tencent.qapmsdk.socket.d.d.a(this.c.getClass()).a("sslParameters").get(this.c);
        Object localObject3 = com.tencent.qapmsdk.socket.d.d.a(localObject2.getClass());
        if (!AndroidVersion.isL()) {
          break label125;
        }
        localObject1 = "x509TrustManager";
        localObject1 = ((d.a)localObject3).a((String)localObject1);
        localObject3 = ((Field)localObject1).get(localObject2);
        if ((localObject3 instanceof c))
        {
          localObject3 = (c)com.tencent.qapmsdk.socket.d.d.a(Object.class).a("clone", new Class[0]).invoke(localObject3, new Object[0]);
          if (localObject3 != null)
          {
            ((c)localObject3).a(paramString);
            ((Field)localObject1).set(localObject2, localObject3);
            this.a = ((c)localObject3);
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        com.tencent.qapmsdk.socket.d.d.a(paramString);
      }
      return;
      label125:
      Object localObject1 = "trustManager";
    }
  }
  
  private void a(SSLException paramSSLException)
  {
    c localc = this.a;
    if (localc != null) {
      localc.a(paramSSLException);
    }
  }
  
  private int b()
  {
    localObject3 = null;
    try
    {
      localObject1 = (Socket)com.tencent.qapmsdk.socket.d.d.a(b).a("socket").get(this.c);
      Object localObject4 = com.tencent.qapmsdk.socket.d.d.a(Socket.class).a("impl").get(localObject1);
      localObject1 = localObject3;
      if ((localObject4 instanceof com.tencent.qapmsdk.socket.d)) {
        localObject1 = ((com.tencent.qapmsdk.socket.d)localObject4).a();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2 = localObject3;
      }
    }
    if (localObject1 != null) {
      return localObject1.hashCode();
    }
    return 0;
  }
  
  public void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.c.addHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void bind(SocketAddress paramSocketAddress)
  {
    if (TrafficMonitor.a().c())
    {
      this.c.bind(paramSocketAddress);
      return;
    }
    throw new IOException("Disable network by developer!");
  }
  
  public void close()
  {
    try
    {
      this.c.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void connect(SocketAddress paramSocketAddress)
  {
    if (TrafficMonitor.a().c())
    {
      this.c.connect(paramSocketAddress);
      return;
    }
    throw new IOException("Disable network by developer!");
  }
  
  public void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    if (TrafficMonitor.a().c())
    {
      this.c.connect(paramSocketAddress, paramInt);
      return;
    }
    throw new IOException("Disable network by developer!");
  }
  
  @Keep
  public byte[] getAlpnSelectedProtocol()
  {
    try
    {
      byte[] arrayOfByte = (byte[])com.tencent.qapmsdk.socket.d.d.a(b).a("getAlpnSelectedProtocol", new Class[0]).invoke(this.c, new Object[0]);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      com.tencent.qapmsdk.socket.d.d.a(localException);
    }
    return null;
  }
  
  public SocketChannel getChannel()
  {
    return this.c.getChannel();
  }
  
  public boolean getEnableSessionCreation()
  {
    return this.c.getEnableSessionCreation();
  }
  
  public String[] getEnabledCipherSuites()
  {
    return this.c.getEnabledCipherSuites();
  }
  
  public String[] getEnabledProtocols()
  {
    return this.c.getEnabledProtocols();
  }
  
  @TargetApi(24)
  public SSLSession getHandshakeSession()
  {
    return this.c.getHandshakeSession();
  }
  
  public InetAddress getInetAddress()
  {
    return this.c.getInetAddress();
  }
  
  public InputStream getInputStream()
  {
    if (TrafficMonitor.a().c())
    {
      if (this.d == null) {
        this.d = new b(this.c.getInputStream(), this.f);
      }
      return this.d;
    }
    throw new IOException("Disable network by developer!");
  }
  
  public boolean getKeepAlive()
  {
    return this.c.getKeepAlive();
  }
  
  public InetAddress getLocalAddress()
  {
    return this.c.getLocalAddress();
  }
  
  public int getLocalPort()
  {
    return this.c.getLocalPort();
  }
  
  public SocketAddress getLocalSocketAddress()
  {
    return this.c.getLocalSocketAddress();
  }
  
  public boolean getNeedClientAuth()
  {
    return this.c.getNeedClientAuth();
  }
  
  public boolean getOOBInline()
  {
    return this.c.getOOBInline();
  }
  
  public OutputStream getOutputStream()
  {
    if (TrafficMonitor.a().c())
    {
      if (this.e == null)
      {
        this.e = new com.tencent.qapmsdk.socket.c(this.c.getOutputStream(), this.f);
        this.e.a(true, this.g, this.h, this.i, a(), b());
      }
      return this.e;
    }
    throw new IOException("Disable network by developer!");
  }
  
  public int getPort()
  {
    return this.c.getPort();
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int j = this.c.getReceiveBufferSize();
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SocketAddress getRemoteSocketAddress()
  {
    return this.c.getRemoteSocketAddress();
  }
  
  public boolean getReuseAddress()
  {
    return this.c.getReuseAddress();
  }
  
  public SSLParameters getSSLParameters()
  {
    return this.c.getSSLParameters();
  }
  
  public int getSendBufferSize()
  {
    try
    {
      int j = this.c.getSendBufferSize();
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SSLSession getSession()
  {
    return this.c.getSession();
  }
  
  public int getSoLinger()
  {
    return this.c.getSoLinger();
  }
  
  public int getSoTimeout()
  {
    try
    {
      int j = this.c.getSoTimeout();
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String[] getSupportedCipherSuites()
  {
    return this.c.getSupportedCipherSuites();
  }
  
  public String[] getSupportedProtocols()
  {
    return this.c.getSupportedProtocols();
  }
  
  public boolean getTcpNoDelay()
  {
    return this.c.getTcpNoDelay();
  }
  
  public int getTrafficClass()
  {
    return this.c.getTrafficClass();
  }
  
  public boolean getUseClientMode()
  {
    return this.c.getUseClientMode();
  }
  
  public boolean getWantClientAuth()
  {
    return this.c.getWantClientAuth();
  }
  
  public boolean isBound()
  {
    return this.c.isBound();
  }
  
  public boolean isClosed()
  {
    return this.c.isClosed();
  }
  
  public boolean isConnected()
  {
    return this.c.isConnected();
  }
  
  public boolean isInputShutdown()
  {
    return this.c.isInputShutdown();
  }
  
  public boolean isOutputShutdown()
  {
    return this.c.isOutputShutdown();
  }
  
  public void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.c.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void sendUrgentData(int paramInt)
  {
    this.c.sendUrgentData(paramInt);
  }
  
  @Keep
  public void setAlpnProtocols(byte[] paramArrayOfByte)
  {
    try
    {
      com.tencent.qapmsdk.socket.d.d.a(b).a("setAlpnProtocols", new Class[] { [B.class }).invoke(this.c, new Object[] { paramArrayOfByte });
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.qapmsdk.socket.d.d.a(paramArrayOfByte);
    }
  }
  
  public void setEnableSessionCreation(boolean paramBoolean)
  {
    this.c.setEnableSessionCreation(paramBoolean);
  }
  
  public void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    this.c.setEnabledCipherSuites(paramArrayOfString);
  }
  
  public void setEnabledProtocols(String[] paramArrayOfString)
  {
    this.c.setEnabledProtocols(paramArrayOfString);
  }
  
  @Keep
  public void setHostname(String paramString)
  {
    try
    {
      com.tencent.qapmsdk.socket.d.d.a(b).a("setHostname", new Class[] { String.class }).invoke(this.c, new Object[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.qapmsdk.socket.d.d.a(paramString);
    }
  }
  
  public void setKeepAlive(boolean paramBoolean)
  {
    this.c.setKeepAlive(paramBoolean);
  }
  
  public void setNeedClientAuth(boolean paramBoolean)
  {
    this.c.setNeedClientAuth(paramBoolean);
  }
  
  public void setOOBInline(boolean paramBoolean)
  {
    this.c.setOOBInline(paramBoolean);
  }
  
  public void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
  }
  
  public void setReceiveBufferSize(int paramInt)
  {
    try
    {
      this.c.setReceiveBufferSize(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setReuseAddress(boolean paramBoolean)
  {
    this.c.setReuseAddress(paramBoolean);
  }
  
  public void setSSLParameters(SSLParameters paramSSLParameters)
  {
    this.c.setSSLParameters(paramSSLParameters);
  }
  
  public void setSendBufferSize(int paramInt)
  {
    try
    {
      this.c.setSendBufferSize(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setSoLinger(boolean paramBoolean, int paramInt)
  {
    this.c.setSoLinger(paramBoolean, paramInt);
  }
  
  public void setSoTimeout(int paramInt)
  {
    try
    {
      this.c.setSoTimeout(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setTcpNoDelay(boolean paramBoolean)
  {
    this.c.setTcpNoDelay(paramBoolean);
  }
  
  public void setTrafficClass(int paramInt)
  {
    this.c.setTrafficClass(paramInt);
  }
  
  public void setUseClientMode(boolean paramBoolean)
  {
    this.c.setUseClientMode(paramBoolean);
  }
  
  @Keep
  public void setUseSessionTickets(boolean paramBoolean)
  {
    try
    {
      com.tencent.qapmsdk.socket.d.d.a(b).a("setUseSessionTickets", new Class[] { Boolean.TYPE }).invoke(this.c, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      com.tencent.qapmsdk.socket.d.d.a(localException);
    }
  }
  
  public void setWantClientAuth(boolean paramBoolean)
  {
    this.c.setWantClientAuth(paramBoolean);
  }
  
  public void shutdownInput()
  {
    this.c.shutdownInput();
  }
  
  public void shutdownOutput()
  {
    this.c.shutdownOutput();
  }
  
  public void startHandshake()
  {
    long l = SystemClock.elapsedRealtime();
    try
    {
      this.c.startHandshake();
      com.tencent.qapmsdk.socket.a.b(true, this.g, this.i, SystemClock.elapsedRealtime() - l, this.f);
      return;
    }
    catch (SSLException localSSLException)
    {
      com.tencent.qapmsdk.socket.a.b(false, this.g, this.i, SystemClock.elapsedRealtime() - l, this.f);
      a(localSSLException);
      throw localSSLException;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TrafficSslSocket[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.TrafficSslSocket
 * JD-Core Version:    0.7.0.1
 */