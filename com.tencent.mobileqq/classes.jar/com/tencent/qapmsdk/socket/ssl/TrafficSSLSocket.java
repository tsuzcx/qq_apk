package com.tencent.qapmsdk.socket.ssl;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.socket.TrafficConnectReporter;
import com.tencent.qapmsdk.socket.TrafficInputStream;
import com.tencent.qapmsdk.socket.TrafficMonitor;
import com.tencent.qapmsdk.socket.TrafficMonitor.TrafficConfig;
import com.tencent.qapmsdk.socket.TrafficOutputStream;
import com.tencent.qapmsdk.socket.TrafficSocketImpl;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import com.tencent.qapmsdk.socket.util.ReflectionHelper;
import com.tencent.qapmsdk.socket.util.ReflectionHelper.Cache;
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
public class TrafficSSLSocket
  extends SSLSocket
{
  private static final String CLASSNAME_OPEN_SSL_SOCKET_IMPL = ReflectionHelper.getOpenSSLPackageName() + ".OpenSSLSocketImpl";
  private static final String TAG = "QAPM_Socket_TrafficSSLSocket";
  private SocketInfo socketInfo;
  private SSLSocket sslSocket;
  private String trafficHost;
  private TrafficInputStream trafficInputStream;
  private String trafficIp;
  private TrafficOutputStream trafficOutputStream;
  private int trafficPort;
  TrafficTrustManager trafficTrustManager;
  
  TrafficSSLSocket(Socket paramSocket, String paramString, int paramInt)
  {
    this(paramSocket, paramString, null, paramInt);
  }
  
  private TrafficSSLSocket(Socket paramSocket, String paramString, InetAddress paramInetAddress, int paramInt)
  {
    this.sslSocket = ((SSLSocket)paramSocket);
    this.socketInfo = new SocketInfo();
    this.trafficHost = paramString;
    if (paramInetAddress != null) {
      this.trafficIp = paramInetAddress.getHostAddress();
    }
    for (;;)
    {
      this.trafficPort = paramInt;
      cloneTrafficTrustManager(paramString);
      return;
      if (paramSocket.getInetAddress() != null) {
        this.trafficIp = paramSocket.getInetAddress().getHostAddress();
      } else {
        this.trafficIp = "";
      }
    }
  }
  
  TrafficSSLSocket(Socket paramSocket, InetAddress paramInetAddress, int paramInt)
  {
    this(paramSocket, paramInetAddress.getHostName(), paramInetAddress, paramInt);
  }
  
  private void cloneTrafficTrustManager(String paramString)
  {
    try
    {
      Object localObject2 = ReflectionHelper.of(this.sslSocket.getClass()).field("sslParameters").get(this.sslSocket);
      Object localObject3 = ReflectionHelper.of(localObject2.getClass());
      if (AndroidVersion.isL()) {}
      for (Object localObject1 = "x509TrustManager";; localObject1 = "trustManager")
      {
        localObject1 = ((ReflectionHelper.Cache)localObject3).field((String)localObject1);
        localObject3 = ((Field)localObject1).get(localObject2);
        if (!(localObject3 instanceof TrafficTrustManager)) {
          break;
        }
        localObject3 = (TrafficTrustManager)ReflectionHelper.of(Object.class).method("clone", new Class[0]).invoke(localObject3, new Object[0]);
        if (localObject3 == null) {
          break;
        }
        ((TrafficTrustManager)localObject3).setHost(paramString);
        ((Field)localObject1).set(localObject2, localObject3);
        this.trafficTrustManager = ((TrafficTrustManager)localObject3);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      ReflectionHelper.processException(paramString);
    }
  }
  
  private String getFd()
  {
    try
    {
      Object localObject1 = (Socket)ReflectionHelper.of(CLASSNAME_OPEN_SSL_SOCKET_IMPL).field("socket").get(this.sslSocket);
      localObject1 = ReflectionHelper.of(Socket.class).field("impl").get(localObject1);
      localObject1 = ReflectionHelper.of(SocketImpl.class).field("fd").get(localObject1);
      return ReflectionHelper.printFd(localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private int getImplHashCode()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (Socket)ReflectionHelper.of(CLASSNAME_OPEN_SSL_SOCKET_IMPL).field("socket").get(this.sslSocket);
        localObject1 = ReflectionHelper.of(Socket.class).field("impl").get(localObject1);
        if (!(localObject1 instanceof TrafficSocketImpl)) {
          break label69;
        }
        localObject1 = ((TrafficSocketImpl)localObject1).getOldImpl();
        if (localObject1 != null) {
          return localObject1.hashCode();
        }
      }
      catch (Exception localException)
      {
        localObject2 = null;
        continue;
      }
      return 0;
      label69:
      Object localObject2 = null;
    }
  }
  
  private void onHandshakeFailed(SSLException paramSSLException)
  {
    if (this.trafficTrustManager != null) {
      this.trafficTrustManager.onHandshakeFailed(paramSSLException);
    }
  }
  
  public void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.sslSocket.addHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void bind(SocketAddress paramSocketAddress)
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    this.sslSocket.bind(paramSocketAddress);
  }
  
  public void close()
  {
    try
    {
      this.sslSocket.close();
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
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    this.sslSocket.connect(paramSocketAddress);
  }
  
  public void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    this.sslSocket.connect(paramSocketAddress, paramInt);
  }
  
  @Keep
  public byte[] getAlpnSelectedProtocol()
  {
    try
    {
      byte[] arrayOfByte = (byte[])ReflectionHelper.of(CLASSNAME_OPEN_SSL_SOCKET_IMPL).method("getAlpnSelectedProtocol", new Class[0]).invoke(this.sslSocket, new Object[0]);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
    return null;
  }
  
  public SocketChannel getChannel()
  {
    return this.sslSocket.getChannel();
  }
  
  public boolean getEnableSessionCreation()
  {
    return this.sslSocket.getEnableSessionCreation();
  }
  
  public String[] getEnabledCipherSuites()
  {
    return this.sslSocket.getEnabledCipherSuites();
  }
  
  public String[] getEnabledProtocols()
  {
    return this.sslSocket.getEnabledProtocols();
  }
  
  @TargetApi(24)
  public SSLSession getHandshakeSession()
  {
    return this.sslSocket.getHandshakeSession();
  }
  
  public InetAddress getInetAddress()
  {
    return this.sslSocket.getInetAddress();
  }
  
  public InputStream getInputStream()
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    if (this.trafficInputStream == null) {
      this.trafficInputStream = new TrafficInputStream(this.sslSocket.getInputStream(), this.socketInfo);
    }
    return this.trafficInputStream;
  }
  
  public boolean getKeepAlive()
  {
    return this.sslSocket.getKeepAlive();
  }
  
  public InetAddress getLocalAddress()
  {
    return this.sslSocket.getLocalAddress();
  }
  
  public int getLocalPort()
  {
    return this.sslSocket.getLocalPort();
  }
  
  public SocketAddress getLocalSocketAddress()
  {
    return this.sslSocket.getLocalSocketAddress();
  }
  
  public boolean getNeedClientAuth()
  {
    return this.sslSocket.getNeedClientAuth();
  }
  
  public boolean getOOBInline()
  {
    return this.sslSocket.getOOBInline();
  }
  
  public OutputStream getOutputStream()
  {
    if (!TrafficMonitor.config().isEnableNetwork()) {
      throw new IOException("Disable network by developer!");
    }
    if (this.trafficOutputStream == null)
    {
      this.trafficOutputStream = new TrafficOutputStream(this.sslSocket.getOutputStream(), this.socketInfo);
      this.trafficOutputStream.initData(true, this.trafficHost, this.trafficIp, this.trafficPort, getFd(), getImplHashCode());
    }
    return this.trafficOutputStream;
  }
  
  public int getPort()
  {
    return this.sslSocket.getPort();
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = this.sslSocket.getReceiveBufferSize();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SocketAddress getRemoteSocketAddress()
  {
    return this.sslSocket.getRemoteSocketAddress();
  }
  
  public boolean getReuseAddress()
  {
    return this.sslSocket.getReuseAddress();
  }
  
  public SSLParameters getSSLParameters()
  {
    return this.sslSocket.getSSLParameters();
  }
  
  public int getSendBufferSize()
  {
    try
    {
      int i = this.sslSocket.getSendBufferSize();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SSLSession getSession()
  {
    return this.sslSocket.getSession();
  }
  
  public int getSoLinger()
  {
    return this.sslSocket.getSoLinger();
  }
  
  public int getSoTimeout()
  {
    try
    {
      int i = this.sslSocket.getSoTimeout();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String[] getSupportedCipherSuites()
  {
    return this.sslSocket.getSupportedCipherSuites();
  }
  
  public String[] getSupportedProtocols()
  {
    return this.sslSocket.getSupportedProtocols();
  }
  
  public boolean getTcpNoDelay()
  {
    return this.sslSocket.getTcpNoDelay();
  }
  
  public int getTrafficClass()
  {
    return this.sslSocket.getTrafficClass();
  }
  
  public boolean getUseClientMode()
  {
    return this.sslSocket.getUseClientMode();
  }
  
  public boolean getWantClientAuth()
  {
    return this.sslSocket.getWantClientAuth();
  }
  
  public boolean isBound()
  {
    return this.sslSocket.isBound();
  }
  
  public boolean isClosed()
  {
    return this.sslSocket.isClosed();
  }
  
  public boolean isConnected()
  {
    return this.sslSocket.isConnected();
  }
  
  public boolean isInputShutdown()
  {
    return this.sslSocket.isInputShutdown();
  }
  
  public boolean isOutputShutdown()
  {
    return this.sslSocket.isOutputShutdown();
  }
  
  public void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.sslSocket.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void sendUrgentData(int paramInt)
  {
    this.sslSocket.sendUrgentData(paramInt);
  }
  
  @Keep
  public void setAlpnProtocols(byte[] paramArrayOfByte)
  {
    try
    {
      ReflectionHelper.of(CLASSNAME_OPEN_SSL_SOCKET_IMPL).method("setAlpnProtocols", new Class[] { [B.class }).invoke(this.sslSocket, new Object[] { paramArrayOfByte });
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ReflectionHelper.processException(paramArrayOfByte);
    }
  }
  
  public void setEnableSessionCreation(boolean paramBoolean)
  {
    this.sslSocket.setEnableSessionCreation(paramBoolean);
  }
  
  public void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    this.sslSocket.setEnabledCipherSuites(paramArrayOfString);
  }
  
  public void setEnabledProtocols(String[] paramArrayOfString)
  {
    this.sslSocket.setEnabledProtocols(paramArrayOfString);
  }
  
  @Keep
  public void setHostname(String paramString)
  {
    try
    {
      ReflectionHelper.of(CLASSNAME_OPEN_SSL_SOCKET_IMPL).method("setHostname", new Class[] { String.class }).invoke(this.sslSocket, new Object[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      ReflectionHelper.processException(paramString);
    }
  }
  
  public void setKeepAlive(boolean paramBoolean)
  {
    this.sslSocket.setKeepAlive(paramBoolean);
  }
  
  public void setNeedClientAuth(boolean paramBoolean)
  {
    this.sslSocket.setNeedClientAuth(paramBoolean);
  }
  
  public void setOOBInline(boolean paramBoolean)
  {
    this.sslSocket.setOOBInline(paramBoolean);
  }
  
  public void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    this.sslSocket.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
  }
  
  public void setReceiveBufferSize(int paramInt)
  {
    try
    {
      this.sslSocket.setReceiveBufferSize(paramInt);
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
    this.sslSocket.setReuseAddress(paramBoolean);
  }
  
  public void setSSLParameters(SSLParameters paramSSLParameters)
  {
    this.sslSocket.setSSLParameters(paramSSLParameters);
  }
  
  public void setSendBufferSize(int paramInt)
  {
    try
    {
      this.sslSocket.setSendBufferSize(paramInt);
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
    this.sslSocket.setSoLinger(paramBoolean, paramInt);
  }
  
  public void setSoTimeout(int paramInt)
  {
    try
    {
      this.sslSocket.setSoTimeout(paramInt);
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
    this.sslSocket.setTcpNoDelay(paramBoolean);
  }
  
  public void setTrafficClass(int paramInt)
  {
    this.sslSocket.setTrafficClass(paramInt);
  }
  
  public void setUseClientMode(boolean paramBoolean)
  {
    this.sslSocket.setUseClientMode(paramBoolean);
  }
  
  @Keep
  public void setUseSessionTickets(boolean paramBoolean)
  {
    try
    {
      ReflectionHelper.of(CLASSNAME_OPEN_SSL_SOCKET_IMPL).method("setUseSessionTickets", new Class[] { Boolean.TYPE }).invoke(this.sslSocket, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      ReflectionHelper.processException(localException);
    }
  }
  
  public void setWantClientAuth(boolean paramBoolean)
  {
    this.sslSocket.setWantClientAuth(paramBoolean);
  }
  
  public void shutdownInput()
  {
    this.sslSocket.shutdownInput();
  }
  
  public void shutdownOutput()
  {
    this.sslSocket.shutdownOutput();
  }
  
  public void startHandshake()
  {
    long l = SystemClock.elapsedRealtime();
    try
    {
      this.sslSocket.startHandshake();
      TrafficConnectReporter.onHandshakeCompleted(true, this.trafficHost, this.trafficPort, SystemClock.elapsedRealtime() - l, this.socketInfo);
      return;
    }
    catch (SSLException localSSLException)
    {
      TrafficConnectReporter.onHandshakeCompleted(false, this.trafficHost, this.trafficPort, SystemClock.elapsedRealtime() - l, this.socketInfo);
      onHandshakeFailed(localSSLException);
      throw localSSLException;
    }
  }
  
  public String toString()
  {
    return "TrafficSSLSocket[" + this.sslSocket + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.TrafficSSLSocket
 * JD-Core Version:    0.7.0.1
 */