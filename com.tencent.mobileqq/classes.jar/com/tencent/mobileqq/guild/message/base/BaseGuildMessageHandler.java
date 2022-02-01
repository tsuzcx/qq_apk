package com.tencent.mobileqq.guild.message.base;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class BaseGuildMessageHandler
  extends BusinessHandler
{
  protected static final int MAX_RETRY_LIMIT = 9;
  protected static final int PERIODICAL_RETRY_LIMIT = 3;
  public static final int SEND_MESSAGE_TIMEOUT_MAX = 480000;
  public static final int SEND_MESSAGE_TIMEOUT_MAX_SECOND = 480;
  public static final String TAG = "BaseGuildMessageHandler";
  private final int sendMessageNonPeriodicalRetryElapseTimeLimit = 450000;
  protected final HashMap<Long, SendMessageHandler> sendQueue = new HashMap();
  
  protected BaseGuildMessageHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  static String[] getTimeConsume(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      String[] arrayOfString = new String[7];
      long l2 = paramToServiceMsg.extraData.getLong("startTime", 0L);
      long l7 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atAppSite", 0L);
      long l6 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atMsfSite", 0L);
      long l9 = paramFromServiceMsg.extraData.getLong("timestamp_msf2net_atMsfSite", 0L);
      long l4 = paramFromServiceMsg.extraData.getLong("timestamp_net2msf_atMsfSite", 0L);
      long l5 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atMsfSite", 0L);
      long l3 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atAppSite", 0L);
      long l8 = System.currentTimeMillis();
      arrayOfString[1] = String.valueOf(l8 - l2);
      arrayOfString[2] = String.valueOf(l4 - l9);
      arrayOfString[3] = String.valueOf(l9 - l2);
      arrayOfString[4] = String.valueOf(l8 - l4);
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handler");
      long l1 = l2;
      if (l7 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l7 - l2));
        paramToServiceMsg.append("|app");
        l1 = l7;
      }
      l2 = l1;
      if (l6 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l6 - l1));
        paramToServiceMsg.append("|msf");
        l2 = l6;
      }
      if (l9 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l9 - l2));
        paramToServiceMsg.append("|net");
      }
      arrayOfString[5] = paramToServiceMsg.toString();
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("net");
      if (l5 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l5 - l4));
        paramToServiceMsg.append("|msf");
        l1 = l5;
      }
      else
      {
        l1 = l4;
      }
      l2 = l1;
      if (l3 != 0L)
      {
        paramToServiceMsg.append("|");
        paramToServiceMsg.append(String.valueOf(l3 - l1));
        paramToServiceMsg.append("|app");
        l2 = l3;
      }
      paramToServiceMsg.append("|");
      paramToServiceMsg.append(String.valueOf(l8 - l2));
      paramToServiceMsg.append("|handler");
      arrayOfString[6] = paramToServiceMsg.toString();
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("{");
      paramToServiceMsg.append("total:");
      paramToServiceMsg.append(arrayOfString[1]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("net:");
      paramToServiceMsg.append(arrayOfString[2]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("send:");
      paramToServiceMsg.append(arrayOfString[3]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("recv:");
      paramToServiceMsg.append(arrayOfString[4]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("sendDetail:");
      paramToServiceMsg.append(arrayOfString[5]);
      paramToServiceMsg.append(",");
      paramToServiceMsg.append("recvDetail:");
      paramToServiceMsg.append(arrayOfString[6]);
      paramToServiceMsg.append("}");
      arrayOfString[0] = paramToServiceMsg.toString();
      return arrayOfString;
    }
    return null;
  }
  
  private boolean notRetry(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, BaseGuildMessageHandler.RequestBuilder paramRequestBuilder, long paramLong)
  {
    if (!paramBoolean1)
    {
      paramRequestBuilder = paramRequestBuilder.a();
      if (paramRequestBuilder == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processRequest cmd=");
        localStringBuilder.append(paramRequestBuilder.getServiceCmd());
        localStringBuilder.append(",reqSeq=");
        localStringBuilder.append(paramLong);
        QLog.d("BaseGuildMessageHandler", 2, localStringBuilder.toString());
      }
      sendRequest(paramRequestBuilder, paramLong, paramBoolean2, paramBoolean3);
      return true;
    }
    return false;
  }
  
  private void prepareRetryRunnable(boolean paramBoolean1, boolean paramBoolean2, BaseGuildMessageHandler.RequestBuilder paramRequestBuilder, long paramLong1, long paramLong2, SendMessageHandler paramSendMessageHandler)
  {
    int i = 0;
    while (i < 9)
    {
      paramSendMessageHandler.a(new BaseGuildMessageHandler.1(this, paramRequestBuilder, paramLong1, paramLong2, paramBoolean1, paramBoolean2));
      i += 1;
    }
  }
  
  private void scheduleRetry(SendMessageHandler paramSendMessageHandler)
  {
    int i = 0;
    while (i < 3)
    {
      long l;
      if (i == 0) {
        l = 480000L;
      } else {
        l = (3 - i) * 480000 / 3 - i * 2000;
      }
      paramSendMessageHandler.a(480000 * i / 3, l, "period");
      i += 1;
    }
  }
  
  public boolean addToQueue(long paramLong, SendMessageHandler paramSendMessageHandler)
  {
    synchronized (this.sendQueue)
    {
      if (!this.sendQueue.containsKey(Long.valueOf(paramLong)))
      {
        this.sendQueue.put(Long.valueOf(paramLong), paramSendMessageHandler);
        paramSendMessageHandler.a = paramLong;
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramSendMessageHandler = new StringBuilder();
        paramSendMessageHandler.append("sendQueue alread has msgSeq[");
        paramSendMessageHandler.append(paramLong);
        paramSendMessageHandler.append("]");
        QLog.e("BaseGuildMessageHandler", 2, paramSendMessageHandler.toString());
      }
      return false;
    }
  }
  
  protected void destroySendQueue()
  {
    synchronized (this.sendQueue)
    {
      Iterator localIterator = this.sendQueue.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() != null) {
          ((SendMessageHandler)localEntry.getValue()).a();
        }
      }
      this.sendQueue.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public SendMessageHandler getHandlerFromQueue(long paramLong)
  {
    return (SendMessageHandler)this.sendQueue.get(Long.valueOf(paramLong));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GuildMessageObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  protected void processRequest(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, BaseGuildMessageHandler.RequestBuilder paramRequestBuilder)
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      int i = MobileQQService.seq;
      MobileQQService.seq = i + 1;
      l = i;
    }
    paramLong = System.currentTimeMillis();
    if (notRetry(paramBoolean1, paramBoolean2, paramBoolean3, paramRequestBuilder, l)) {
      return;
    }
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    addToQueue(l, localSendMessageHandler);
    prepareRetryRunnable(paramBoolean2, paramBoolean3, paramRequestBuilder, l, paramLong, localSendMessageHandler);
    scheduleRetry(localSendMessageHandler);
  }
  
  public void recordSendMessageRetryResult(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (!paramToServiceMsg.extraData.containsKey("msgSeq"))
      {
        QLog.e("BaseGuildMessageHandler", 1, "no msgSeq");
        return;
      }
      long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
      int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      long l2 = paramFromServiceMsg.getResultCode();
      long l3 = paramFromServiceMsg.extraData.getLong("ServerReplyCode", 9223372036854775807L);
      SendMessageHandler localSendMessageHandler = getHandlerFromQueue(l1);
      if (localSendMessageHandler != null)
      {
        paramFromServiceMsg = getTimeConsume(paramToServiceMsg, paramFromServiceMsg);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("<---TimeConsume---> cmd[");
          localStringBuilder.append(paramToServiceMsg.getServiceCmd());
          localStringBuilder.append("] seq[");
          localStringBuilder.append(l1);
          localStringBuilder.append("] retryIndex[");
          localStringBuilder.append(i);
          localStringBuilder.append("] ");
          localStringBuilder.append(paramFromServiceMsg[0]);
          localStringBuilder.append("");
          QLog.d("BaseGuildMessageHandler", 2, localStringBuilder.toString());
        }
        localSendMessageHandler.a(i, l2, l3, paramFromServiceMsg);
        return;
      }
      QLog.e("BaseGuildMessageHandler", 1, "can not found handler");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuildMessageHandler", 2, "req or resp is null");
    }
  }
  
  protected boolean removeFromQueue(long paramLong)
  {
    synchronized (this.sendQueue)
    {
      if (this.sendQueue.containsKey(Long.valueOf(paramLong)))
      {
        this.sendQueue.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
  }
  
  public void removeSendMessageHandler(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeSendMessageHandler msgseq=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("BaseGuildMessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getHandlerFromQueue(paramLong);
    if (localObject != null)
    {
      ((SendMessageHandler)localObject).a();
      removeFromQueue(paramLong);
    }
  }
  
  public boolean retrySendMessage(SendMessageHandler paramSendMessageHandler, String paramString)
  {
    long l = paramSendMessageHandler.a(System.currentTimeMillis());
    boolean bool1;
    if (l < 450000L)
    {
      l = 480000L - l - 5000L;
      boolean bool2 = paramSendMessageHandler.a(0L, l, paramString);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<<<---retrySendMessage scheduleSuccess[");
        localStringBuilder.append(bool2);
        localStringBuilder.append("] msgSeq[");
        localStringBuilder.append(paramSendMessageHandler.a);
        localStringBuilder.append("] timeout[");
        localStringBuilder.append(l);
        localStringBuilder.append("] reason[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.d("BaseGuildMessageHandler", 2, localStringBuilder.toString());
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if ((!bool1) && (paramSendMessageHandler.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseGuildMessageHandler", 2, "<<<---retrySendMessage No unfinished retry attampt.");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuildMessageHandler", 2, "<<<---retrySendMessage Wait SendMessage Retry");
    }
    return true;
  }
  
  protected void sendRequest(ToServiceMsg paramToServiceMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramToServiceMsg.extraData.putLong("msgSeq", paramLong);
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        paramToServiceMsg.setNeedRemindSlowNetwork(true);
      }
      sendPbReq(paramToServiceMsg);
      return;
    }
    send(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler
 * JD-Core Version:    0.7.0.1
 */