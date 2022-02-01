package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

public class k
{
  public static final String a = "MSF.C.NetExceptionStat";
  private static LinkedBlockingDeque b = new LinkedBlockingDeque(100);
  private static long c = System.currentTimeMillis() - 180000L;
  
  public static void a(k.b paramb)
  {
    if (!NetConnInfoCenter.isNetSupport()) {
      return;
    }
    if (b.size() >= 100)
    {
      paramb = new StringBuilder();
      paramb.append("addNetException NetExceptionEvent count = ");
      paramb.append(b.size());
      paramb.append("too much drop");
      QLog.d("MSF.C.NetExceptionStat", 2, paramb.toString());
      return;
    }
    k.a locala = new k.a();
    locala.a = paramb;
    long l = System.currentTimeMillis();
    locala.b = l;
    try
    {
      b.addLast(locala);
      paramb = new StringBuilder();
      paramb.append("addNetException NetExceptionEvent count = ");
      paramb.append(b.size());
      paramb.append("");
      QLog.d("MSF.C.NetExceptionStat", 2, paramb.toString());
      for (;;)
      {
        try
        {
          paramb = (k.a)b.peek();
          if ((paramb != null) && (l - paramb.b >= a.U()))
          {
            b.removeFirst();
          }
          else
          {
            paramb = new StringBuilder();
            paramb.append("addNetException after remove expire event NetExceptionEvent count = ");
            paramb.append(b.size());
            QLog.d("MSF.C.NetExceptionStat", 2, paramb.toString());
            if ((l - c > a.U()) && (b.size() >= a.W()))
            {
              paramb = new StringBuilder();
              paramb.append("NetExceptionEvent count = ");
              paramb.append(b.size());
              paramb.append(" report to ui now");
              QLog.d("MSF.C.NetExceptionStat", 2, paramb.toString());
              paramb = new FromServiceMsg(NetConnInfoCenter.msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_connWeakNet");
              paramb.setMsgSuccess();
              paramb.setMsfCommand(MsfCommand.onConnWeakNet);
              MsfSdkUtils.addFromMsgProcessName("*", paramb);
              NetConnInfoCenter.msfCore.addRespToQuque(null, paramb);
              c = l;
            }
            return;
          }
        }
        catch (Exception paramb)
        {
          paramb.printStackTrace();
        }
      }
      return;
    }
    catch (Exception paramb)
    {
      paramb.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.k
 * JD-Core Version:    0.7.0.1
 */