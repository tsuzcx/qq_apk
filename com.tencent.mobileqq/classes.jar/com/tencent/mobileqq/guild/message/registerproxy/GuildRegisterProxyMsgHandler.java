package com.tencent.mobileqq.guild.message.registerproxy;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.registerproxy.observer.GuildRegisterProxyObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelNode;
import tencent.im.group_pro_proto.synclogic.synclogic.GuildNode;
import tencent.im.group_pro_proto.synclogic.synclogic.MultiChannelMsg;

public class GuildRegisterProxyMsgHandler
  extends BusinessHandler
  implements IGuildRegisterProxyMsgHandler
{
  private AppInterface a;
  private long b = -1L;
  private int c = -1;
  private int d = 0;
  private ConcurrentHashMap<Integer, IGuildRegisterProxyProcesser> e = new ConcurrentHashMap();
  private Map<Integer, IGuildRegisterProxyProcesser> f = new ConcurrentHashMap();
  private volatile GuildChannelMsgProcesser g;
  private GuildRegisterProxyObserver h = new GuildRegisterProxyMsgHandler.1(this);
  
  public GuildRegisterProxyMsgHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = paramAppInterface;
    paramAppInterface.addObserver(this.h);
    paramAppInterface.getRuntimeService(IGuildRegisterProxyGaryService.class, "");
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ("trpc.group_pro.synclogic.SyncLogic.GetMultiChannelMsg".equals(paramFromServiceMsg.getServiceCmd()))
    {
      i = paramToServiceMsg.extraData.getInt("registerProxyEndSeq");
    }
    else if ("trpc.group_pro.synclogic.SyncLogic.PushChannelMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject == null)
      {
        QLog.e("GuildRegisterProxyMsgHandler", 1, "onReceivePullMsg data == null");
        return;
      }
      synclogic.MultiChannelMsg localMultiChannelMsg = new synclogic.MultiChannelMsg();
      try
      {
        localMultiChannelMsg.mergeFrom((byte[])paramObject);
        i = localMultiChannelMsg.seq.get();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceivePullMsg mergeFrom error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.e("GuildRegisterProxyMsgHandler", 1, paramFromServiceMsg.toString());
        paramToServiceMsg.printStackTrace();
        return;
      }
    }
    else
    {
      i = 0;
    }
    if (i == this.d)
    {
      a(2).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (this.e.containsKey(Integer.valueOf(i)))
    {
      ((IGuildRegisterProxyProcesser)this.e.get(Integer.valueOf(i))).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("onReceivePullMsg can not find seq:");
    paramToServiceMsg.append(i);
    QLog.e("GuildRegisterProxyMsgHandler", 1, paramToServiceMsg.toString());
  }
  
  public GuildChannelMsgProcesser a()
  {
    try
    {
      if (this.g == null) {
        this.g = new GuildChannelMsgProcesser(this.a);
      }
      return this.g;
    }
    finally {}
  }
  
  public IGuildRegisterProxyProcesser a(int paramInt)
  {
    Object localObject1 = this.f;
    if (localObject1 == null) {
      return null;
    }
    if (!((Map)localObject1).containsKey(Integer.valueOf(paramInt))) {}
    for (;;)
    {
      synchronized (this.f)
      {
        if (!this.f.containsKey(Integer.valueOf(paramInt)))
        {
          if (1 == paramInt)
          {
            localObject1 = new GuildRegisterProxyFirstViewProcesser(this.a, this);
          }
          else
          {
            if (2 != paramInt) {
              break label139;
            }
            localObject1 = new GuildRegisterProxyPullMsgProcesser(this.a, this);
          }
          if (localObject1 == null) {
            return null;
          }
          this.f.put(Integer.valueOf(paramInt), localObject1);
        }
      }
      return (IGuildRegisterProxyProcesser)this.f.get(Integer.valueOf(paramInt));
      label139:
      Object localObject3 = null;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.b < paramLong)
    {
      this.b = paramLong;
      if (this.a.getCurrentAccountUin() != null) {
        this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).edit().putLong("guild_lastmsg_time", this.b).apply();
      }
    }
  }
  
  public void a(ArrayList<synclogic.GuildNode> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (synclogic.GuildNode)paramArrayList.next();
        GuildPullMsgParam localGuildPullMsgParam = new GuildPullMsgParam();
        localGuildPullMsgParam.a = ((synclogic.GuildNode)localObject).guild_id.get();
        localObject = ((synclogic.GuildNode)localObject).rpt_channel_nodes.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          synclogic.ChannelNode localChannelNode = (synclogic.ChannelNode)((Iterator)localObject).next();
          localGuildPullMsgParam.b.add(new GuildPullMsgParam.PullMsgChannelInfo(localChannelNode.channel_id.get(), localChannelNode.msg_seq.get(), localChannelNode.msg_time.get()));
        }
        localArrayList.add(localGuildPullMsgParam);
      }
      if (a(2).a(localArrayList)) {
        this.d = a(2).b();
      }
    }
  }
  
  public long b()
  {
    if ((this.b == -1L) && (this.a.getCurrentAccountUin() != null)) {
      this.b = this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).getLong("guild_lastmsg_time", 0L);
    }
    return this.b;
  }
  
  public void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGuildUdcFlag flag:");
    localStringBuilder.append(paramInt);
    QLog.i("GuildRegisterProxyMsgHandler", 1, localStringBuilder.toString());
    if (paramInt == -1) {
      return;
    }
    this.c = paramInt;
    if (this.a.getCurrentAccountUin() != null) {
      this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).edit().putInt("guild_registerproxy_udcflag", paramInt).apply();
    }
    if (this.c == 1) {
      ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).refreshGuildList(true);
    }
  }
  
  public void b(ArrayList<GuildPullMsgParam> paramArrayList)
  {
    GuildRegisterProxyPullMsgProcesser localGuildRegisterProxyPullMsgProcesser = new GuildRegisterProxyPullMsgProcesser(this.a, this);
    if (localGuildRegisterProxyPullMsgProcesser.a(paramArrayList)) {
      this.e.put(Integer.valueOf(localGuildRegisterProxyPullMsgProcesser.b()), localGuildRegisterProxyPullMsgProcesser);
    }
  }
  
  public boolean c()
  {
    if (d() != 1)
    {
      QLog.i("GuildRegisterProxyMsgHandler", 1, "filterSendRegisterProxy UdcFlag=0");
      return true;
    }
    if (!((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab())
    {
      QLog.i("GuildRegisterProxyMsgHandler", 1, "filterSendRegisterProxy isShowGuildTab=false");
      return true;
    }
    return false;
  }
  
  public int d()
  {
    if ((this.c == -1) && (this.a.getCurrentAccountUin() != null)) {
      this.c = this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).getInt("guild_registerproxy_udcflag", -1);
    }
    return this.c;
  }
  
  public boolean e()
  {
    if (c()) {
      return false;
    }
    a(1).a(null);
    return true;
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("trpc.group_pro.synclogic.SyncLogic.SyncFirstView");
      this.allowCmdSet.add("trpc.group_pro.synclogic.SyncLogic.PushFirstView");
      this.allowCmdSet.add("trpc.group_pro.synclogic.SyncLogic.GetMultiChannelMsg");
      this.allowCmdSet.add("trpc.group_pro.synclogic.SyncLogic.PushChannelMsg");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GuildRegisterProxyObserver.class;
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.f.values().iterator();
    while (localIterator.hasNext()) {
      ((IGuildRegisterProxyProcesser)localIterator.next()).a();
    }
    this.f.clear();
    localIterator = this.e.values().iterator();
    while (localIterator.hasNext()) {
      ((IGuildRegisterProxyProcesser)localIterator.next()).a();
    }
    this.e.clear();
    this.a.removeObserver(this.h);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.e("GuildRegisterProxyMsgHandler", 1, paramToServiceMsg.toString());
        return;
      }
      if ((!"trpc.group_pro.synclogic.SyncLogic.SyncFirstView".equals(paramFromServiceMsg.getServiceCmd())) && (!"trpc.group_pro.synclogic.SyncLogic.PushFirstView".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
      {
        if (("trpc.group_pro.synclogic.SyncLogic.GetMultiChannelMsg".equals(paramFromServiceMsg.getServiceCmd())) || ("trpc.group_pro.synclogic.SyncLogic.PushChannelMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
          a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else {
        a(1).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    QLog.e("GuildRegisterProxyMsgHandler", 1, "onReceive,resp == null or req == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyMsgHandler
 * JD-Core Version:    0.7.0.1
 */