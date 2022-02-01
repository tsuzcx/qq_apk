package com.tencent.mobileqq.msf.sdk;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.c.o;
import com.tencent.mobileqq.msf.core.c.o.a;
import com.tencent.mobileqq.msf.sdk.b.c;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

class u
{
  private String _bootBroadcastName;
  protected int appid;
  IErrorHandler errorHandler;
  protected final LinkedBlockingQueue highPriorityMessagePairs = new LinkedBlockingQueue();
  protected String msfServiceName;
  protected String processName;
  protected final LinkedBlockingQueue serviceRespMessagePairs = new LinkedBlockingQueue();
  private Object syncQueueLock = new Object();
  
  public boolean addServicePushMsg(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.getServiceCmd() == null) {
        return false;
      }
      boolean bool;
      if (v.c.contains(paramFromServiceMsg.getServiceCmd()))
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("addServicePushMsg, high priority added, ");
          ((StringBuilder)???).append(paramFromServiceMsg.getServiceCmd());
          QLog.d("ThreadSplit", 2, ((StringBuilder)???).toString());
        }
        paramFromServiceMsg.extraData.putInt(v.a, getQueueSize());
        bool = this.highPriorityMessagePairs.add(new MsfMessagePair(null, paramFromServiceMsg));
      }
      else
      {
        bool = this.serviceRespMessagePairs.add(new MsfMessagePair(null, paramFromServiceMsg));
      }
      if (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
        o.a().a(o.a.e, paramFromServiceMsg.getWupBuffer(), 0);
      }
      synchronized (this.syncQueueLock)
      {
        this.syncQueueLock.notify();
        c.a().onRespToApp(null, paramFromServiceMsg);
        return bool;
      }
    }
    return false;
  }
  
  public boolean addServiceRespMsg(MsfMessagePair paramMsfMessagePair)
  {
    boolean bool;
    if ((paramMsfMessagePair.fromServiceMsg != null) && (paramMsfMessagePair.fromServiceMsg.getServiceCmd() != null) && (v.c.contains(paramMsfMessagePair.fromServiceMsg.getServiceCmd())))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("addServiceRespMsg, high priority added, ");
        ((StringBuilder)???).append(paramMsfMessagePair.fromServiceMsg.getServiceCmd());
        QLog.d("ThreadSplit", 2, ((StringBuilder)???).toString());
      }
      paramMsfMessagePair.fromServiceMsg.extraData.putInt(v.a, getQueueSize());
      paramMsfMessagePair.fromServiceMsg.extraData.putLong(v.b, System.currentTimeMillis());
      bool = this.highPriorityMessagePairs.add(paramMsfMessagePair);
    }
    else
    {
      bool = this.serviceRespMessagePairs.add(paramMsfMessagePair);
    }
    synchronized (this.syncQueueLock)
    {
      this.syncQueueLock.notify();
      c.a().onRespToApp(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg);
      return bool;
    }
  }
  
  public String getBootBroadcastName()
  {
    return this._bootBroadcastName;
  }
  
  public IErrorHandler getErrorHandler()
  {
    return this.errorHandler;
  }
  
  public int getQueueSize()
  {
    return this.serviceRespMessagePairs.size() + this.highPriorityMessagePairs.size();
  }
  
  public LinkedBlockingQueue getRespMsgQueue()
  {
    if (this.highPriorityMessagePairs.size() > 0) {
      return this.highPriorityMessagePairs;
    }
    return this.serviceRespMessagePairs;
  }
  
  public MsfMessagePair getServiceRespMsg()
  {
    if (this.highPriorityMessagePairs.size() > 0) {
      return (MsfMessagePair)this.highPriorityMessagePairs.poll();
    }
    return (MsfMessagePair)this.serviceRespMessagePairs.poll();
  }
  
  public void initSub(String paramString1, int paramInt, String paramString2, String paramString3, IErrorHandler paramIErrorHandler)
  {
    this.appid = paramInt;
    this.msfServiceName = paramString2;
    setBootBroadcastName(paramString3);
    this.processName = paramString1;
    this.errorHandler = paramIErrorHandler;
  }
  
  public void queueWait()
  {
    try
    {
      synchronized (this.syncQueueLock)
      {
        if ((this.serviceRespMessagePairs.size() == 0) && (this.highPriorityMessagePairs.size() == 0)) {
          this.syncQueueLock.wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label41:
      break label41;
    }
    return;
    throw localObject2;
  }
  
  public void setBootBroadcastName(String paramString)
  {
    this._bootBroadcastName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.u
 * JD-Core Version:    0.7.0.1
 */