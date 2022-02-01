package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

class p
  extends Thread
{
  p(n paramn, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      n.a(this.c, false);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start send checkNetConnectBySocket server:");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append(" port:");
        ((StringBuilder)localObject1).append(this.b);
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new Socket();
      localObject2 = new InetSocketAddress(this.a, this.b);
      ((Socket)localObject1).setSoTimeout(10000);
      ((Socket)localObject1).setTcpNoDelay(true);
      ((Socket)localObject1).setKeepAlive(true);
      ((Socket)localObject1).connect((SocketAddress)localObject2, 10000);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkNetConnectBySocket connect server:");
        ((StringBuilder)localObject2).append(this.a);
        ((StringBuilder)localObject2).append(" port:");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append(" success");
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new OutputStreamWriter(((Socket)localObject1).getOutputStream());
      Object localObject3 = new StringBuffer();
      ((StringBuffer)localObject3).append("GET https://3gimg.qq.com/qq_product_operations/nettest/index.html?mType=connCheck HTTP/1.1\r\n");
      ((StringBuffer)localObject3).append("Host: 3gimg.qq.com \r\n");
      ((StringBuffer)localObject3).append("Connection: close\r\n");
      ((StringBuffer)localObject3).append("\r\n");
      ((OutputStreamWriter)localObject2).write(((StringBuffer)localObject3).toString());
      ((OutputStreamWriter)localObject2).flush();
      localObject2 = ((Socket)localObject1).getInputStream();
      localObject1 = null;
      localObject3 = new byte[64];
      if (((InputStream)localObject2).read((byte[])localObject3) != -1) {
        localObject1 = new String((byte[])localObject3, "UTF-8");
      }
      if (((String)localObject1).indexOf("302") != -1) {
        n.a(this.c, true);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("checkNetConnectBySocket get header:");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("checkNetConnectBySocket ");
        ((StringBuilder)localObject3).append(((String)localObject1).hashCode());
        ((StringBuilder)localObject3).append(" len: ");
        ((StringBuilder)localObject3).append(((String)localObject1).length());
        QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject3).toString());
      }
      ((InputStream)localObject2).close();
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkNetConnectBySocket connect server:");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(" port:");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" failed");
      ((StringBuilder)localObject2).append(localException);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString(), localException);
      return;
    }
    catch (IOException localIOException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkNetConnectBySocket connect server IOException:");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(" port:");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" failed");
      ((StringBuilder)localObject2).append(localIOException);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString(), localIOException);
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkNetConnectBySocket connect server UnknownHostException:");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(" port:");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" failed");
      ((StringBuilder)localObject2).append(localUnknownHostException);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString(), localUnknownHostException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.p
 * JD-Core Version:    0.7.0.1
 */