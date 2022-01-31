package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.QLog;
import java.net.InetSocketAddress;
import java.net.Socket;

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
    Object localObject = this.a;
    if (localObject == null) {}
    for (;;)
    {
      return;
      String str = localObject.split(":")[0].trim();
      int i = Integer.parseInt(localObject.split(":")[1].trim());
      this.b = 2;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "start send checkNetConnectByConnectSSO server:" + str + " port:" + i);
        }
        localObject = new Socket();
        InetSocketAddress localInetSocketAddress = new InetSocketAddress(str, i);
        ((Socket)localObject).setSoTimeout(10000);
        ((Socket)localObject).setTcpNoDelay(true);
        ((Socket)localObject).setKeepAlive(true);
        ((Socket)localObject).connect(localInetSocketAddress, 10000);
        this.b = 3;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO connect server:" + str + " port:" + i + " success");
        }
        ((Socket)localObject).close();
        return;
      }
      catch (Throwable localThrowable)
      {
        if (localThrowable != null) {
          this.c = localThrowable.toString().toLowerCase();
        }
        if (this.c.indexOf("timeoutexception") > -1) {
          break label235;
        }
      }
      if (this.c.indexOf(") after") > -1) {}
      label235:
      for (this.b = 5; QLog.isColorLevel(); this.b = 4)
      {
        QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO Throwable connect server:" + str + " port:" + i + " failed" + localThrowable, localThrowable);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.n.a
 * JD-Core Version:    0.7.0.1
 */