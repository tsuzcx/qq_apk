package com.tencent.mobileqq.msf.sdk;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.c.o;
import com.tencent.mobileqq.msf.core.c.o.a;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

class t
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
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getServiceCmd() == null)) {
      return false;
    }
    boolean bool;
    if (u.c.contains(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadSplit", 2, "addServicePushMsg, high priority added, " + paramFromServiceMsg.getServiceCmd());
      }
      paramFromServiceMsg.extraData.putInt(u.a, getQueueSize());
      bool = this.highPriorityMessagePairs.add(new MsfMessagePair(null, paramFromServiceMsg));
    }
    for (;;)
    {
      if (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
        o.a().a(o.a.e, paramFromServiceMsg.getWupBuffer(), 0);
      }
      synchronized (this.syncQueueLock)
      {
        this.syncQueueLock.notify();
        c.a().onRespToApp(null, paramFromServiceMsg);
        return bool;
        bool = this.serviceRespMessagePairs.add(new MsfMessagePair(null, paramFromServiceMsg));
      }
    }
  }
  
  public boolean addServiceRespMsg(MsfMessagePair paramMsfMessagePair)
  {
    boolean bool;
    if ((paramMsfMessagePair.fromServiceMsg != null) && (paramMsfMessagePair.fromServiceMsg.getServiceCmd() != null) && (u.c.contains(paramMsfMessagePair.fromServiceMsg.getServiceCmd())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadSplit", 2, "addServiceRespMsg, high priority added, " + paramMsfMessagePair.fromServiceMsg.getServiceCmd());
      }
      paramMsfMessagePair.fromServiceMsg.extraData.putInt(u.a, getQueueSize());
      paramMsfMessagePair.fromServiceMsg.extraData.putLong(u.b, System.currentTimeMillis());
      bool = this.highPriorityMessagePairs.add(paramMsfMessagePair);
    }
    synchronized (this.syncQueueLock)
    {
      this.syncQueueLock.notify();
      c.a().onRespToApp(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg);
      return bool;
      bool = this.serviceRespMessagePairs.add(paramMsfMessagePair);
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
        label34:
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label34;
    }
  }
  
  public void setBootBroadcastName(String paramString)
  {
    this._bootBroadcastName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.t
 * JD-Core Version:    0.7.0.1
 */