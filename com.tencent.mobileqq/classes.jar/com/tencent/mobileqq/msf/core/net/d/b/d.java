package com.tencent.mobileqq.msf.core.net.d.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.i;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class d
{
  private static final String a = "EndpointChannel";
  private static int b;
  private final int c;
  private final HandlerThread d;
  private final Handler e;
  private final com.tencent.mobileqq.msf.core.d f;
  private j g;
  
  public d(com.tencent.mobileqq.msf.core.d paramd)
  {
    int i = b;
    b = i + 1;
    this.c = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EndpointChannel_");
    localStringBuilder.append(this.c);
    this.d = new HandlerThread(localStringBuilder.toString());
    this.d.start();
    this.e = new Handler(this.d.getLooper());
    this.f = paramd;
  }
  
  public boolean a(com.tencent.mobileqq.msf.core.d paramd)
  {
    return this.f.equals(paramd);
  }
  
  public boolean a(e parame)
  {
    j localj = this.g;
    boolean bool2 = false;
    if (localj == null)
    {
      try
      {
        this.g = new j(this.f);
        this.g.connect(InetAddress.getByName(this.f.c()), this.f.f());
        this.g.setSoTimeout(i.a().c() * 1000);
      }
      catch (Exception localException)
      {
        QLog.e("EndpointChannel", 1, "[post] unknown exception. ", localException);
      }
      catch (UnknownHostException localUnknownHostException)
      {
        QLog.e("EndpointChannel", 1, "[post] endpoint unknown. ", localUnknownHostException);
      }
      catch (SocketException localSocketException)
      {
        QLog.e("EndpointChannel", 1, "[post] create socket error. ", localSocketException);
      }
      i = 0;
      break label122;
    }
    int i = 1;
    label122:
    if (i != 0) {
      parame.a(this.g);
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (this.e.post(parame)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.b.d
 * JD-Core Version:    0.7.0.1
 */