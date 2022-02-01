package com.tencent.mobileqq.guild.message.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;
import com.tencent.mobileqq.guild.message.api.IGuildRoamMessageHandler;
import com.tencent.mobileqq.guild.message.api.impl.pullroammsg.BasePullRoamMsgLogic;
import com.tencent.mobileqq.guild.message.api.impl.pullroammsg.PullRoamMsgLogicCommon;
import com.tencent.mobileqq.guild.message.api.impl.pullroammsg.PullRoamMsgLogicEventFlow;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class GuildRoamMessageHandler
  extends BaseGuildMessageHandler
  implements IGuildRoamMessageHandler
{
  public static final int PULLROAMMSG_COMMON = 1;
  public static final int PULLROAMMSG_EVENTFLOW = 2;
  public static final String TAG = "BaseGuildMessageHandler.GuildRoamMessageHandler";
  private volatile boolean isDestroyed = false;
  private ConcurrentHashMap<Long, BasePullRoamMsgLogic> logicMaps = new ConcurrentHashMap();
  IMessageFacade messageFacade;
  private AtomicLong pullSeq = new AtomicLong(1L);
  
  protected GuildRoamMessageHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.messageFacade = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, ""));
  }
  
  private BasePullRoamMsgLogic createPullRoamMsgLogicByType(int paramInt)
  {
    if (paramInt == 1) {
      return new PullRoamMsgLogicCommon(this.appRuntime, this);
    }
    if (paramInt == 2) {
      return new PullRoamMsgLogicEventFlow(this.appRuntime, this);
    }
    return null;
  }
  
  private BasePullRoamMsgLogic getPullRoamMsgLogic(Bundle paramBundle)
  {
    long l = paramBundle.getLong("pullSeq");
    if (!this.logicMaps.containsKey(Long.valueOf(l))) {
      this.logicMaps.put(Long.valueOf(l), createPullRoamMsgLogicByType(getPullRoamMsgType(paramBundle)));
    }
    return (BasePullRoamMsgLogic)this.logicMaps.get(Long.valueOf(l));
  }
  
  private BasePullRoamMsgLogic getPullRoamMsgLogic(ToServiceMsg paramToServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getBundle("context").getLong("pullSeq");
    return (BasePullRoamMsgLogic)this.logicMaps.get(Long.valueOf(l));
  }
  
  private int getPullRoamMsgType(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return 1;
    }
    if (paramBundle.getBoolean("pull_roammsg_from_eventflow", false)) {
      return 2;
    }
    return 1;
  }
  
  private boolean onReceiveFailed(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString)
  {
    if (msgCmdFilter(paramString))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramString);
        QLog.d("BaseGuildMessageHandler.GuildRoamMessageHandler", 2, paramToServiceMsg.toString());
      }
      return true;
    }
    if ("trpc.group_pro.synclogic.SyncLogic.GetChannelMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      if ((paramFromServiceMsg.getResultCode() != 1002) && (paramFromServiceMsg.getResultCode() != 1013))
      {
        if (paramFromServiceMsg.getResultCode() != 1000)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BaseGuildMessageHandler.GuildRoamMessageHandler", 2, String.format("handleError cmd=[%s]", new Object[] { paramToServiceMsg.getServiceCmd() }));
          }
          if (getPullRoamMsgLogic(paramToServiceMsg) != null) {
            getPullRoamMsgLogic(paramToServiceMsg).b(paramToServiceMsg, paramFromServiceMsg);
          }
          return true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("BaseGuildMessageHandler.GuildRoamMessageHandler", 2, String.format("handleTimeOut cmd=[%s]", new Object[] { paramToServiceMsg.getServiceCmd() }));
        }
        if (getPullRoamMsgLogic(paramToServiceMsg) != null) {
          getPullRoamMsgLogic(paramToServiceMsg).a(paramToServiceMsg, paramFromServiceMsg);
        }
        return true;
      }
    }
    return this.isDestroyed;
  }
  
  private void onReceiveReqPullRoamMsg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"trpc.group_pro.synclogic.SyncLogic.GetChannelMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    try
    {
      if (getPullRoamMsgLogic(paramToServiceMsg) != null)
      {
        getPullRoamMsgLogic(paramToServiceMsg).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.w("BaseGuildMessageHandler.GuildRoamMessageHandler", 2, "onReceiveReqPullRoamMsg exception ! ", paramObject);
      }
      if (getPullRoamMsgLogic(paramToServiceMsg) != null) {
        getPullRoamMsgLogic(paramToServiceMsg).b(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  private void onReceiveSuccess(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    onReceiveReqPullRoamMsg(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("trpc.group_pro.synclogic.SyncLogic.GetChannelMsg");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GuildMessageObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.isDestroyed = true;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq:");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" serviceCmd: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", resultCode:");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      QLog.d("BaseGuildMessageHandler.GuildRoamMessageHandler", 2, localStringBuilder.toString());
    }
    if (onReceiveFailed(paramToServiceMsg, paramFromServiceMsg, str)) {
      return;
    }
    onReceiveSuccess(paramToServiceMsg, paramFromServiceMsg, paramObject, str);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle [cmd]=");
      paramToServiceMsg.append(str);
      paramToServiceMsg.append(" , costTime = [");
      paramToServiceMsg.append(l2 - l1);
      paramToServiceMsg.append("]");
      QLog.d("BaseGuildMessageHandler.GuildRoamMessageHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  public void removePullRoamMsgLogic(ToServiceMsg paramToServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getBundle("context").getLong("pullSeq");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("removePullRoamMsgLogic pullSeq:");
      paramToServiceMsg.append(l);
      QLog.i("BaseGuildMessageHandler.GuildRoamMessageHandler", 2, paramToServiceMsg.toString());
    }
    this.logicMaps.remove(Long.valueOf(l));
  }
  
  public boolean reqPullRoamMsg(String paramString, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (localBundle.getLong("pullSeq", -1L) == -1L) {
      localBundle.putLong("pullSeq", this.pullSeq.incrementAndGet());
    }
    long l = localBundle.getLong("pullSeq");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("reqPullRoamMsg pullSeq:");
      paramBundle.append(l);
      QLog.i("BaseGuildMessageHandler.GuildRoamMessageHandler", 2, paramBundle.toString());
    }
    return getPullRoamMsgLogic(localBundle).a(paramString, paramLong1, paramLong2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildRoamMessageHandler
 * JD-Core Version:    0.7.0.1
 */