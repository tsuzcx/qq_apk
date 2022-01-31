package com.tencent.mobileqq.msf.core.net.b;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
  extends Thread
{
  private static final String f = "ReqAllFailSocket";
  private static final int g = 10000;
  protected boolean a = false;
  protected boolean b = false;
  protected boolean c = false;
  protected long d = 0L;
  protected long e = 0L;
  private Socket h;
  private OutputStream i;
  private InputStream j;
  private AtomicBoolean k = new AtomicBoolean(false);
  private AtomicBoolean l = new AtomicBoolean(false);
  private d m;
  private LinkedBlockingDeque n = new LinkedBlockingDeque(1000);
  private long o = 0L;
  private String p = "";
  private MsfCore q;
  private int r;
  
  public f(MsfCore paramMsfCore, d paramd, int paramInt)
  {
    this.q = paramMsfCore;
    this.m = paramd;
    this.r = paramInt;
  }
  
  private int a(String paramString, MsfCommand paramMsfCommand, byte[] paramArrayOfByte)
  {
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      try
      {
        this.i.write(paramArrayOfByte);
        this.i.flush();
        QLog.d("ReqAllFailSocket", 1, this.r + " send " + paramString);
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        d();
      }
    }
  }
  
  private boolean c()
  {
    InetSocketAddress localInetSocketAddress = new InetSocketAddress(this.m.c(), this.m.f());
    try
    {
      this.h = new Socket();
      this.h.setTcpNoDelay(true);
      this.h.setKeepAlive(true);
      this.h.connect(localInetSocketAddress, this.m.g());
      this.i = this.h.getOutputStream();
      this.j = this.h.getInputStream();
      this.k.set(true);
      this.c = true;
      this.o = SystemClock.elapsedRealtime();
      QLog.d("ReqAllFailSocket", 1, this.r + " conn " + this.m.c() + ":" + this.m.f() + " succ");
      return true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.p = "connFail";
      QLog.d("ReqAllFailSocket", 1, this.r + " conn " + this.m.c() + ":" + this.m.f() + " fail");
    }
    return false;
  }
  
  private void d()
  {
    QLog.d("ReqAllFailSocket", 1, this.r + " closeConn");
    if (this.h != null) {}
    try
    {
      this.h.close();
      this.h = null;
      localAtomicBoolean1 = this.k;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AtomicBoolean localAtomicBoolean1;
        localException.printStackTrace();
        this.h = null;
        AtomicBoolean localAtomicBoolean2 = this.k;
      }
    }
    finally
    {
      this.h = null;
      this.k.set(false);
    }
    localAtomicBoolean1.set(false);
  }
  
  private void e()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
    localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
    localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    localToServiceMsg.setAppId(this.q.getMsfAppid());
    localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
    a(localToServiceMsg);
  }
  
  private void f()
  {
    int i1 = "MSF".getBytes().length + 13 + 1 + 0 + 4;
    byte b1 = (byte)"MSF".getBytes().length;
    Object localObject = ByteBuffer.allocate(i1);
    ((ByteBuffer)localObject).putInt(i1).putInt(20140601).putInt(0).put(b1).put("MSF".getBytes()).put((byte)0).putInt(0);
    localObject = ((ByteBuffer)localObject).array();
    try
    {
      a("MSF", MsfCommand.msf_ssoping, (byte[])localObject);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a()
  {
    d();
    this.l.set(true);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      this.n.add(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      QLog.d("ReqAllFailSocket", 1, "addSendQueu fail,", paramToServiceMsg);
    }
  }
  
  public String b()
  {
    return this.m.c() + "|" + this.m.f() + "|" + this.a + "|" + this.b + "|" + this.p + "|" + this.c + "|" + this.d + "|" + this.e;
  }
  
  public void run()
  {
    if (c())
    {
      new f.b(this, null).start();
      new f.a(this, null).start();
      f();
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.f
 * JD-Core Version:    0.7.0.1
 */