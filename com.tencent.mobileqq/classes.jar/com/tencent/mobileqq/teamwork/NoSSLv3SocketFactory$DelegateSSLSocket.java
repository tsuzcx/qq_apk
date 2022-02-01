package com.tencent.mobileqq.teamwork;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class NoSSLv3SocketFactory$DelegateSSLSocket
  extends SSLSocket
{
  protected final SSLSocket a;
  
  NoSSLv3SocketFactory$DelegateSSLSocket(NoSSLv3SocketFactory paramNoSSLv3SocketFactory, SSLSocket paramSSLSocket)
  {
    this.a = paramSSLSocket;
  }
  
  public void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.a.addHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void bind(SocketAddress paramSocketAddress)
  {
    this.a.bind(paramSocketAddress);
  }
  
  public void close()
  {
    try
    {
      this.a.close();
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
    this.a.connect(paramSocketAddress);
  }
  
  public void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    this.a.connect(paramSocketAddress, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.a.equals(paramObject);
  }
  
  public SocketChannel getChannel()
  {
    return this.a.getChannel();
  }
  
  public boolean getEnableSessionCreation()
  {
    return this.a.getEnableSessionCreation();
  }
  
  public String[] getEnabledCipherSuites()
  {
    return this.a.getEnabledCipherSuites();
  }
  
  public String[] getEnabledProtocols()
  {
    return this.a.getEnabledProtocols();
  }
  
  public InetAddress getInetAddress()
  {
    return this.a.getInetAddress();
  }
  
  public InputStream getInputStream()
  {
    return this.a.getInputStream();
  }
  
  public boolean getKeepAlive()
  {
    return this.a.getKeepAlive();
  }
  
  public InetAddress getLocalAddress()
  {
    return this.a.getLocalAddress();
  }
  
  public int getLocalPort()
  {
    return this.a.getLocalPort();
  }
  
  public SocketAddress getLocalSocketAddress()
  {
    return this.a.getLocalSocketAddress();
  }
  
  public boolean getNeedClientAuth()
  {
    return this.a.getNeedClientAuth();
  }
  
  public boolean getOOBInline()
  {
    return this.a.getOOBInline();
  }
  
  public OutputStream getOutputStream()
  {
    return this.a.getOutputStream();
  }
  
  public int getPort()
  {
    return this.a.getPort();
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = this.a.getReceiveBufferSize();
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
    return this.a.getRemoteSocketAddress();
  }
  
  public boolean getReuseAddress()
  {
    return this.a.getReuseAddress();
  }
  
  public int getSendBufferSize()
  {
    try
    {
      int i = this.a.getSendBufferSize();
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
    return this.a.getSession();
  }
  
  public int getSoLinger()
  {
    return this.a.getSoLinger();
  }
  
  public int getSoTimeout()
  {
    try
    {
      int i = this.a.getSoTimeout();
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
    return this.a.getSupportedCipherSuites();
  }
  
  public String[] getSupportedProtocols()
  {
    return this.a.getSupportedProtocols();
  }
  
  public boolean getTcpNoDelay()
  {
    return this.a.getTcpNoDelay();
  }
  
  public int getTrafficClass()
  {
    return this.a.getTrafficClass();
  }
  
  public boolean getUseClientMode()
  {
    return this.a.getUseClientMode();
  }
  
  public boolean getWantClientAuth()
  {
    return this.a.getWantClientAuth();
  }
  
  public boolean isBound()
  {
    return this.a.isBound();
  }
  
  public boolean isClosed()
  {
    return this.a.isClosed();
  }
  
  public boolean isConnected()
  {
    return this.a.isConnected();
  }
  
  public boolean isInputShutdown()
  {
    return this.a.isInputShutdown();
  }
  
  public boolean isOutputShutdown()
  {
    return this.a.isOutputShutdown();
  }
  
  public void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.a.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void sendUrgentData(int paramInt)
  {
    this.a.sendUrgentData(paramInt);
  }
  
  public void setEnableSessionCreation(boolean paramBoolean)
  {
    this.a.setEnableSessionCreation(paramBoolean);
  }
  
  public void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    this.a.setEnabledCipherSuites(paramArrayOfString);
  }
  
  public void setEnabledProtocols(String[] paramArrayOfString)
  {
    this.a.setEnabledProtocols(paramArrayOfString);
  }
  
  public void setKeepAlive(boolean paramBoolean)
  {
    this.a.setKeepAlive(paramBoolean);
  }
  
  public void setNeedClientAuth(boolean paramBoolean)
  {
    this.a.setNeedClientAuth(paramBoolean);
  }
  
  public void setOOBInline(boolean paramBoolean)
  {
    this.a.setOOBInline(paramBoolean);
  }
  
  public void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
  }
  
  public void setReceiveBufferSize(int paramInt)
  {
    try
    {
      this.a.setReceiveBufferSize(paramInt);
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
    this.a.setReuseAddress(paramBoolean);
  }
  
  public void setSendBufferSize(int paramInt)
  {
    try
    {
      this.a.setSendBufferSize(paramInt);
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
    this.a.setSoLinger(paramBoolean, paramInt);
  }
  
  public void setSoTimeout(int paramInt)
  {
    try
    {
      this.a.setSoTimeout(paramInt);
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
    this.a.setTcpNoDelay(paramBoolean);
  }
  
  public void setTrafficClass(int paramInt)
  {
    this.a.setTrafficClass(paramInt);
  }
  
  public void setUseClientMode(boolean paramBoolean)
  {
    this.a.setUseClientMode(paramBoolean);
  }
  
  public void setWantClientAuth(boolean paramBoolean)
  {
    this.a.setWantClientAuth(paramBoolean);
  }
  
  public void shutdownInput()
  {
    this.a.shutdownInput();
  }
  
  public void shutdownOutput()
  {
    this.a.shutdownOutput();
  }
  
  public void startHandshake()
  {
    this.a.startHandshake();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.NoSSLv3SocketFactory.DelegateSSLSocket
 * JD-Core Version:    0.7.0.1
 */