package com.tencent.mobileqq.msf.service;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingQueue;

public class t
  extends Thread
{
  private static String c = "MSF.S.RespHandler";
  public volatile boolean a = true;
  MsfCore b;
  
  public t(MsfCore paramMsfCore)
  {
    this.b = paramMsfCore;
  }
  
  public void run()
  {
    while (this.a) {
      try
      {
        MsfMessagePair localMsfMessagePair = (MsfMessagePair)this.b.getMsfMessagePairs().take();
        if (localMsfMessagePair != null)
        {
          Object localObject;
          String str;
          StringBuilder localStringBuilder;
          if (localMsfMessagePair.toServiceMsg != null)
          {
            localObject = u.b(localMsfMessagePair.toServiceMsg);
            if ((!"LongConn.OffPicUp".equals(localMsfMessagePair.toServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equals(localMsfMessagePair.toServiceMsg.getServiceCmd())))
            {
              if (QLog.isColorLevel())
              {
                str = c;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append((String)localObject);
                localStringBuilder.append(" add resp to queue:");
                localStringBuilder.append(localMsfMessagePair.toServiceMsg.getRequestSsoSeq());
                localStringBuilder.append(" from:");
                localStringBuilder.append(localMsfMessagePair.fromServiceMsg);
                QLog.d(str, 2, localStringBuilder.toString());
              }
              if (localObject == null) {
                "MessageSvc.PbSendMsg".equals(localMsfMessagePair.toServiceMsg.getServiceCmd());
              }
            }
            else
            {
              str = c;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("recv ");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(" req:");
              localStringBuilder.append(localMsfMessagePair.toServiceMsg.getStringForLog());
              localStringBuilder.append("resp:");
              localStringBuilder.append(localMsfMessagePair.fromServiceMsg.getStringForLog());
              QLog.d(str, 1, localStringBuilder.toString());
            }
            e.a((String)localObject, localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
          }
          else if (localMsfMessagePair.fromServiceMsg != null)
          {
            str = localMsfMessagePair.sendProcess;
            localObject = str;
            if (TextUtils.isEmpty(str)) {
              localObject = u.a(localMsfMessagePair.fromServiceMsg);
            }
            if (QLog.isColorLevel())
            {
              str = c;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(" add push to queue: from:");
              localStringBuilder.append(localMsfMessagePair.fromServiceMsg);
              QLog.d(str, 2, localStringBuilder.toString());
            }
            e.a((String)localObject, localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg);
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.t
 * JD-Core Version:    0.7.0.1
 */