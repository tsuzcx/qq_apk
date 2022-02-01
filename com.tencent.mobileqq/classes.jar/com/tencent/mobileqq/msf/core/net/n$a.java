package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.QLog;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class n$a
{
  public String a = "";
  public byte b = 1;
  public String c = "";
  
  public n$a(n paramn) {}
  
  public void a()
  {
    this.b = 1;
    this.c = "";
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    String str = localObject1.split(":")[0].trim();
    int i = Integer.parseInt(localObject1.split(":")[1].trim());
    this.b = 2;
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("start send checkNetConnectByConnectSSO server:");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(" port:");
        ((StringBuilder)localObject1).append(i);
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new Socket();
      localObject2 = new InetSocketAddress(str, i);
      ((Socket)localObject1).setSoTimeout(10000);
      ((Socket)localObject1).setTcpNoDelay(true);
      ((Socket)localObject1).setKeepAlive(true);
      ((Socket)localObject1).connect((SocketAddress)localObject2, 10000);
      this.b = 3;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkNetConnectByConnectSSO connect server:");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" port:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" success");
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString());
      }
      ((Socket)localObject1).close();
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      this.c = localThrowable.toString().toLowerCase();
      if ((this.c.indexOf("timeoutexception") <= -1) && (this.c.indexOf(") after") <= -1)) {
        this.b = 4;
      } else {
        this.b = 5;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkNetConnectByConnectSSO Throwable connect server:");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" port:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" failed");
        ((StringBuilder)localObject2).append(localThrowable);
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString(), localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.n.a
 * JD-Core Version:    0.7.0.1
 */