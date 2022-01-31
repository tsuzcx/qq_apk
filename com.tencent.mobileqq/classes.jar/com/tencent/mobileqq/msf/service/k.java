package com.tencent.mobileqq.msf.service;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

public class k
  extends Thread
{
  private static String c = "MSF.S.RespHandler";
  public volatile boolean a = true;
  MsfCore b;
  
  public k(MsfCore paramMsfCore)
  {
    this.b = paramMsfCore;
  }
  
  public void run()
  {
    while (this.a)
    {
      MsfMessagePair localMsfMessagePair;
      for (;;)
      {
        try
        {
          localMsfMessagePair = (MsfMessagePair)this.b.getMsfMessagePairs().take();
          if (localMsfMessagePair == null) {
            break;
          }
          if (localMsfMessagePair.toServiceMsg == null) {
            break label225;
          }
          String str1 = l.b(localMsfMessagePair.toServiceMsg);
          if ((!"LongConn.OffPicUp".equals(localMsfMessagePair.toServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equals(localMsfMessagePair.toServiceMsg.getServiceCmd()))) {
            break label149;
          }
          QLog.d(c, 1, "recv " + str1 + " req:" + localMsfMessagePair.toServiceMsg.getStringForLog() + "resp:" + localMsfMessagePair.fromServiceMsg.getStringForLog());
          d.a(str1, localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        break;
        label149:
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, localInterruptedException + " add resp to queue:" + localMsfMessagePair.toServiceMsg.getRequestSsoSeq() + " from:" + localMsfMessagePair.fromServiceMsg);
        }
        if ((localInterruptedException != null) || (!"MessageSvc.PbSendMsg".equals(localMsfMessagePair.toServiceMsg.getServiceCmd()))) {}
      }
      label225:
      if (localMsfMessagePair.fromServiceMsg != null)
      {
        String str2 = localMsfMessagePair.sendProcess;
        Object localObject = str2;
        if (TextUtils.isEmpty(str2)) {
          localObject = l.a(localMsfMessagePair.fromServiceMsg);
        }
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, (String)localObject + " add push to queue: from:" + localMsfMessagePair.fromServiceMsg);
        }
        d.a((String)localObject, localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.k
 * JD-Core Version:    0.7.0.1
 */