package com.tencent.mobileqq.msf.core.net.a;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  public static final String a = "HeratbeatProxy";
  public static byte[] b;
  public static byte[] c;
  public static final String d = "OS.Hello";
  public static boolean e = false;
  private static int f = -1;
  private static boolean g = false;
  
  public static void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("rsp length:");
      localStringBuilder.append(paramArrayOfByte.length);
      QLog.d("HeratbeatProxy", 1, localStringBuilder.toString());
      c = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, c, 0, c.length);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set response byte failed ");
      localStringBuilder.append(paramArrayOfByte.toString());
      QLog.d("HeratbeatProxy", 1, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    try
    {
      com.tencent.mobileqq.msf.core.push.a locala = d();
      if (locala == null)
      {
        QLog.d("HeratbeatProxy", 1, "encap heartbeat proxy failed to get appPushInfo");
        return false;
      }
      localObject = new ToServiceMsg("", locala.k.uin, "OS.Hello");
      ((ToServiceMsg)localObject).setAppId(locala.a);
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.msf_oshello);
      ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      if (!b((ToServiceMsg)localObject))
      {
        QLog.d("HeratbeatProxy", 1, "encap heartbeat failed");
        return false;
      }
      if (!a((ToServiceMsg)localObject))
      {
        QLog.d("HeratbeatProxy", 1, "failed to send heartbeat request");
        return false;
      }
      return true;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("encap heartbeat proxy failed ");
      ((StringBuilder)localObject).append(localException.toString());
      QLog.d("HeratbeatProxy", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private static boolean a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    try
    {
      paramFromServiceMsg.getWupBuffer();
      return true;
    }
    catch (Exception paramFromServiceMsg)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("encap fromservicemsg failed ");
      paramArrayOfByte.append(paramFromServiceMsg.toString());
      QLog.d("HeratbeatProxy", 1, paramArrayOfByte.toString());
    }
    return false;
  }
  
  public static boolean a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      QLog.d("HeratbeatProxy", 1, "send heartbeat os.hello");
      boolean bool = MsfService.core.sender.b.a(MsfService.core.getMsfAppid(), 0, paramToServiceMsg.getServiceCmd(), "", paramToServiceMsg.getMsfCommand(), paramToServiceMsg.getUin(), paramToServiceMsg.getRequestSsoSeq(), b, paramToServiceMsg);
      if (!bool) {
        return false;
      }
      f = paramToServiceMsg.getRequestSsoSeq();
      g = true;
      return true;
    }
    catch (Exception paramToServiceMsg)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to send ok.hello ");
      localStringBuilder.append(paramToServiceMsg.toString());
      QLog.d("HeratbeatProxy", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean b()
  {
    return g;
  }
  
  private static boolean b(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      int i = "OS.Hello".getBytes().length + 13 + 1 + 0 + 4;
      int j = (int)(Long.parseLong(paramToServiceMsg.getUin()) & 0xFFFFFFFF);
      byte b1 = (byte)("OS.Hello".getBytes().length + 1);
      paramToServiceMsg = ByteBuffer.allocate(i);
      paramToServiceMsg.putInt(i).putInt(20140601).putInt(j).put(b1).put("OS.Hello".getBytes()).put((byte)1).putInt(0);
      paramToServiceMsg = paramToServiceMsg.array();
      b = new byte[paramToServiceMsg.length];
      System.arraycopy(paramToServiceMsg, 0, b, 0, paramToServiceMsg.length);
      return true;
    }
    catch (Exception paramToServiceMsg)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("encap toservicemsg failed ");
      localStringBuilder.append(paramToServiceMsg.toString());
      QLog.d("HeratbeatProxy", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean b(byte[] paramArrayOfByte)
  {
    QLog.d("HeratbeatProxy", 1, "recv heartbeat os.hello");
    g = false;
    a(paramArrayOfByte);
    a.l();
    return true;
  }
  
  public static int c()
  {
    return f;
  }
  
  private static com.tencent.mobileqq.msf.core.push.a d()
  {
    Iterator localIterator = MsfService.core.pushManager.i.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mobileqq.msf.core.push.a)MsfService.core.pushManager.i.get(localObject);
      if ((localObject != null) && (((com.tencent.mobileqq.msf.core.push.a)localObject).k != null) && (((com.tencent.mobileqq.msf.core.push.a)localObject).c != 0L)) {
        try
        {
          if ((((com.tencent.mobileqq.msf.core.push.a)localObject).k.uin != null) && (((com.tencent.mobileqq.msf.core.push.a)localObject).c > 0L))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("get pushinfo uin:");
            localStringBuilder.append(((com.tencent.mobileqq.msf.core.push.a)localObject).k.uin);
            localStringBuilder.append(", pushid:");
            localStringBuilder.append(((com.tencent.mobileqq.msf.core.push.a)localObject).c);
            QLog.d("HeratbeatProxy", 1, localStringBuilder.toString());
            return localObject;
          }
        }
        catch (Exception localException)
        {
          QLog.d("HeratbeatProxy", 1, "failed to get pushinfo", localException);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.b
 * JD-Core Version:    0.7.0.1
 */