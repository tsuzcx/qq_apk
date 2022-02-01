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
import java.net.SocketAddress;
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
    if (paramMsfCommand != MsfCommand.openConn) {
      try
      {
        this.i.write(paramArrayOfByte);
        this.i.flush();
        paramMsfCommand = new StringBuilder();
        paramMsfCommand.append(this.r);
        paramMsfCommand.append(" send ");
        paramMsfCommand.append(paramString);
        QLog.d("ReqAllFailSocket", 1, paramMsfCommand.toString());
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        d();
      }
    }
    return paramArrayOfByte.length;
  }
  
  private boolean c()
  {
    Object localObject = new InetSocketAddress(this.m.c(), this.m.f());
    try
    {
      this.h = new Socket();
      this.h.setTcpNoDelay(true);
      this.h.setKeepAlive(true);
      this.h.connect((SocketAddress)localObject, this.m.g());
      this.i = this.h.getOutputStream();
      this.j = this.h.getInputStream();
      this.k.set(true);
      this.c = true;
      this.o = SystemClock.elapsedRealtime();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append(" conn ");
      ((StringBuilder)localObject).append(this.m.c());
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(this.m.f());
      ((StringBuilder)localObject).append(" succ");
      QLog.d("ReqAllFailSocket", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.p = "connFail";
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.r);
      localStringBuilder.append(" conn ");
      localStringBuilder.append(this.m.c());
      localStringBuilder.append(":");
      localStringBuilder.append(this.m.f());
      localStringBuilder.append(" fail");
      QLog.d("ReqAllFailSocket", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: new 105	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 79	com/tencent/mobileqq/msf/core/net/b/f:r	I
    //   13: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_1
    //   18: ldc 195
    //   20: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 8
    //   26: iconst_1
    //   27: aload_1
    //   28: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 150	com/tencent/mobileqq/msf/core/net/b/f:h	Ljava/net/Socket;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +48 -> 88
    //   43: aload_1
    //   44: invokevirtual 198	java/net/Socket:close	()V
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 150	com/tencent/mobileqq/msf/core/net/b/f:h	Ljava/net/Socket;
    //   52: aload_0
    //   53: getfield 48	com/tencent/mobileqq/msf/core/net/b/f:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: iconst_0
    //   57: invokevirtual 175	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   60: return
    //   61: astore_1
    //   62: goto +11 -> 73
    //   65: astore_1
    //   66: aload_1
    //   67: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   70: goto -23 -> 47
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 150	com/tencent/mobileqq/msf/core/net/b/f:h	Ljava/net/Socket;
    //   78: aload_0
    //   79: getfield 48	com/tencent/mobileqq/msf/core/net/b/f:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   82: iconst_0
    //   83: invokevirtual 175	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   86: aload_1
    //   87: athrow
    //   88: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	f
    //   7	37	1	localObject1	Object
    //   61	1	1	localObject2	Object
    //   65	22	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   43	47	61	finally
    //   66	70	61	finally
    //   43	47	65	java/lang/Exception
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.m.c());
    localStringBuilder.append("|");
    localStringBuilder.append(this.m.f());
    localStringBuilder.append("|");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.p);
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.f
 * JD-Core Version:    0.7.0.1
 */