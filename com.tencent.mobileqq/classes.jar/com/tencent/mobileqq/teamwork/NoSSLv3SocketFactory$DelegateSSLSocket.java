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
  public final SSLSocket a;
  
  public NoSSLv3SocketFactory$DelegateSSLSocket(NoSSLv3SocketFactory paramNoSSLv3SocketFactory, SSLSocket paramSSLSocket)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket = paramSSLSocket;
  }
  
  public void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.addHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void bind(SocketAddress paramSocketAddress)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.bind(paramSocketAddress);
  }
  
  public void close()
  {
    try
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.close();
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
    this.jdField_a_of_type_JavaxNetSslSSLSocket.connect(paramSocketAddress);
  }
  
  public void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.connect(paramSocketAddress, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.equals(paramObject);
  }
  
  public SocketChannel getChannel()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getChannel();
  }
  
  public boolean getEnableSessionCreation()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getEnableSessionCreation();
  }
  
  public String[] getEnabledCipherSuites()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getEnabledCipherSuites();
  }
  
  public String[] getEnabledProtocols()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getEnabledProtocols();
  }
  
  public InetAddress getInetAddress()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getInetAddress();
  }
  
  public InputStream getInputStream()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getInputStream();
  }
  
  public boolean getKeepAlive()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getKeepAlive();
  }
  
  public InetAddress getLocalAddress()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getLocalAddress();
  }
  
  public int getLocalPort()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getLocalPort();
  }
  
  public SocketAddress getLocalSocketAddress()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getLocalSocketAddress();
  }
  
  public boolean getNeedClientAuth()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getNeedClientAuth();
  }
  
  public boolean getOOBInline()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getOOBInline();
  }
  
  public OutputStream getOutputStream()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getOutputStream();
  }
  
  public int getPort()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getPort();
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaxNetSslSSLSocket.getReceiveBufferSize();
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
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getRemoteSocketAddress();
  }
  
  public boolean getReuseAddress()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getReuseAddress();
  }
  
  public int getSendBufferSize()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaxNetSslSSLSocket.getSendBufferSize();
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
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getSession();
  }
  
  public int getSoLinger()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getSoLinger();
  }
  
  public int getSoTimeout()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaxNetSslSSLSocket.getSoTimeout();
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
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getSupportedCipherSuites();
  }
  
  public String[] getSupportedProtocols()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getSupportedProtocols();
  }
  
  public boolean getTcpNoDelay()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getTcpNoDelay();
  }
  
  public int getTrafficClass()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getTrafficClass();
  }
  
  public boolean getUseClientMode()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getUseClientMode();
  }
  
  public boolean getWantClientAuth()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.getWantClientAuth();
  }
  
  public boolean isBound()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.isBound();
  }
  
  public boolean isClosed()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.isClosed();
  }
  
  public boolean isConnected()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.isConnected();
  }
  
  public boolean isInputShutdown()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.isInputShutdown();
  }
  
  public boolean isOutputShutdown()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.isOutputShutdown();
  }
  
  public void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void sendUrgentData(int paramInt)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.sendUrgentData(paramInt);
  }
  
  public void setEnableSessionCreation(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setEnableSessionCreation(paramBoolean);
  }
  
  public void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setEnabledCipherSuites(paramArrayOfString);
  }
  
  public void setEnabledProtocols(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setEnabledProtocols(paramArrayOfString);
  }
  
  public void setKeepAlive(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setKeepAlive(paramBoolean);
  }
  
  public void setNeedClientAuth(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setNeedClientAuth(paramBoolean);
  }
  
  public void setOOBInline(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setOOBInline(paramBoolean);
  }
  
  public void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
  }
  
  public void setReceiveBufferSize(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setReceiveBufferSize(paramInt);
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
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setReuseAddress(paramBoolean);
  }
  
  public void setSendBufferSize(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setSendBufferSize(paramInt);
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
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setSoLinger(paramBoolean, paramInt);
  }
  
  public void setSoTimeout(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaxNetSslSSLSocket.setSoTimeout(paramInt);
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
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setTcpNoDelay(paramBoolean);
  }
  
  public void setTrafficClass(int paramInt)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setTrafficClass(paramInt);
  }
  
  public void setUseClientMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setUseClientMode(paramBoolean);
  }
  
  public void setWantClientAuth(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.setWantClientAuth(paramBoolean);
  }
  
  public void shutdownInput()
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.shutdownInput();
  }
  
  public void shutdownOutput()
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.shutdownOutput();
  }
  
  public void startHandshake()
  {
    this.jdField_a_of_type_JavaxNetSslSSLSocket.startHandshake();
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaxNetSslSSLSocket.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.NoSSLv3SocketFactory.DelegateSSLSocket
 * JD-Core Version:    0.7.0.1
 */