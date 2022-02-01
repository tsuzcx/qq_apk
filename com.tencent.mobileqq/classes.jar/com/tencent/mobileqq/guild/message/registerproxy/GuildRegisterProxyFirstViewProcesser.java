package com.tencent.mobileqq.guild.message.registerproxy;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.registerproxy.observer.GuildRegisterProxyObserver;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ChannelMsgNode;
import com.tencent.mobileqq.qqguildsdk.data.ChannelMsgNode.Builder;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode.Builder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelNode;
import tencent.im.group_pro_proto.synclogic.synclogic.FirstViewMsg;
import tencent.im.group_pro_proto.synclogic.synclogic.FirstViewReq;
import tencent.im.group_pro_proto.synclogic.synclogic.FirstViewRsp;
import tencent.im.group_pro_proto.synclogic.synclogic.GuildNode;

public class GuildRegisterProxyFirstViewProcesser
  implements IGuildProcesserCallBack, IGuildRegisterProxyProcesser
{
  private static String c = "GuildRegisterProxyFirstViewProcesser";
  GuildRegisterProxyMsgHandler a;
  protected int b = 0;
  private AppInterface d;
  private ArrayList<synclogic.GuildNode> e = new ArrayList();
  private Set<Long> f = new HashSet();
  private boolean g = false;
  private int h = 0;
  
  public GuildRegisterProxyFirstViewProcesser(AppInterface paramAppInterface, GuildRegisterProxyMsgHandler paramGuildRegisterProxyMsgHandler)
  {
    this.a = paramGuildRegisterProxyMsgHandler;
    this.d = paramAppInterface;
    this.a.a().a(this);
  }
  
  private void a(long paramLong)
  {
    if (paramLong == 0L)
    {
      QLog.e(c, 1, "saveTinyId FAILED! Invalid tinyId.");
      return;
    }
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).setSelfTinyId(String.valueOf(paramLong));
  }
  
  private void a(synclogic.FirstViewMsg paramFirstViewMsg)
  {
    if (!paramFirstViewMsg.rpt_guild_nodes.has()) {
      return;
    }
    if (paramFirstViewMsg.rpt_guild_nodes.get().size() == 0)
    {
      paramFirstViewMsg = c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGuildNode GuildNode push完成 guildNodes size:");
      localStringBuilder.append(this.e.size());
      QLog.i(paramFirstViewMsg, 1, localStringBuilder.toString());
      return;
    }
    b(paramFirstViewMsg);
    c(paramFirstViewMsg);
    this.e.addAll(paramFirstViewMsg.rpt_guild_nodes.get());
    paramFirstViewMsg = c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleGuildNode GuildNode push 继续 guildNodes size:");
    localStringBuilder.append(this.e.size());
    QLog.i(paramFirstViewMsg, 1, localStringBuilder.toString());
  }
  
  private void a(synclogic.FirstViewMsg paramFirstViewMsg, FromServiceMsg paramFromServiceMsg)
  {
    Iterator localIterator = ((ArrayList)paramFirstViewMsg.rpt_channel_msgs.get()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (synclogic.ChannelMsg)localIterator.next();
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("selfuin", paramFromServiceMsg.getUin());
      ((Bundle)localObject2).putLong("getMsgTime", paramFirstViewMsg.get_msg_time.get());
      long l = this.a.a().a((synclogic.ChannelMsg)localObject1, (Bundle)localObject2);
      this.f.add(Long.valueOf(l));
      if (QLog.isColorLevel())
      {
        localObject1 = c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleChannelMsg seq:");
        ((StringBuilder)localObject2).append(l);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getInt("registerProxyEndSeq") != this.b)
    {
      paramFromServiceMsg = c;
      paramObject = new StringBuilder();
      paramObject.append("registerProxyEndSeq:");
      paramObject.append(this.b);
      paramObject.append(" reqSeq:");
      paramObject.append(paramToServiceMsg.extraData.getInt("registerProxyEndSeq"));
      QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      return;
    }
    if (paramObject == null)
    {
      QLog.e(c, 1, "handleSendRegisterProxy data == null");
      this.a.notifyUI(GuildRegisterProxyObserver.b, false, null);
      return;
    }
    paramToServiceMsg = new synclogic.FirstViewRsp();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg.result.get() != 0)
      {
        paramFromServiceMsg = c;
        paramObject = new StringBuilder();
        paramObject.append("handleSendRegisterProxy errorCode:");
        paramObject.append(paramToServiceMsg.result.get());
        paramObject.append(" errormsg:");
        paramObject.append(paramToServiceMsg.err_msg.get());
        QLog.e(paramFromServiceMsg, 1, paramObject.toString());
        this.a.notifyUI(GuildRegisterProxyObserver.b, false, null);
        return;
      }
      this.h = paramToServiceMsg.guild_count.get();
      a(paramToServiceMsg.self_tinyid.get());
      paramFromServiceMsg = c;
      paramObject = new StringBuilder();
      paramObject.append("onUpdateRegisterProxyReq guild_count:");
      paramObject.append(this.h);
      QLog.i(paramFromServiceMsg, 1, paramObject.toString());
      this.a.notifyUI(GuildRegisterProxyObserver.b, true, new Object[] { paramToServiceMsg });
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramFromServiceMsg = c;
      paramObject = new StringBuilder();
      paramObject.append("handleSendRegisterProxy mergeFrom error:");
      paramObject.append(paramToServiceMsg.getMessage());
      QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      paramToServiceMsg.printStackTrace();
      this.a.notifyUI(GuildRegisterProxyObserver.b, false, null);
    }
  }
  
  private void b(synclogic.FirstViewMsg paramFirstViewMsg)
  {
    IGPSService localIGPSService = (IGPSService)this.d.getRuntimeService(IGPSService.class, "");
    ArrayList localArrayList = new ArrayList();
    paramFirstViewMsg = paramFirstViewMsg.rpt_guild_nodes.get().iterator();
    while (paramFirstViewMsg.hasNext())
    {
      Object localObject1 = (synclogic.GuildNode)paramFirstViewMsg.next();
      Object localObject2 = new ArrayList();
      Object localObject3 = ((synclogic.GuildNode)localObject1).rpt_channel_nodes.get().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (synclogic.ChannelNode)((Iterator)localObject3).next();
        localObject4 = new ChannelMsgNode.Builder().a(String.valueOf(((synclogic.ChannelNode)localObject4).channel_id.get())).b(((synclogic.ChannelNode)localObject4).channel_name.get().toStringUtf8()).b(((synclogic.ChannelNode)localObject4).msg_notify_type.get()).a(((synclogic.ChannelNode)localObject4).channel_type.get()).a();
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("syncGuildNode channelMsgNode id:");
        localStringBuilder.append(((ChannelMsgNode)localObject4).a());
        localStringBuilder.append(" name:");
        localStringBuilder.append(((ChannelMsgNode)localObject4).b());
        localStringBuilder.append(" finalNotifyType:");
        localStringBuilder.append(((ChannelMsgNode)localObject4).e());
        localStringBuilder.append(" type:");
        localStringBuilder.append(((ChannelMsgNode)localObject4).c());
        QLog.i(str, 1, localStringBuilder.toString());
        ((List)localObject2).add(localObject4);
      }
      localObject1 = new GuildMsgNode.Builder().a(String.valueOf(((synclogic.GuildNode)localObject1).guild_id.get())).b(((synclogic.GuildNode)localObject1).guild_name.get().toStringUtf8()).a((List)localObject2).a();
      localArrayList.add(localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = c;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("syncGuildNode GuildMsgNode id:");
        ((StringBuilder)localObject3).append(((GuildMsgNode)localObject1).a());
        ((StringBuilder)localObject3).append(" name:");
        ((StringBuilder)localObject3).append(((GuildMsgNode)localObject1).c());
        QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    localIGPSService.onGuildMsg(localArrayList);
  }
  
  private void c()
  {
    this.e.clear();
    this.b = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    this.f.clear();
    this.g = false;
    this.h = 0;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e(c, 1, "handleRegisterProxyFirstViewPush data == null");
      this.a.notifyUI(GuildRegisterProxyObserver.c, false, null);
      return;
    }
    paramToServiceMsg = new synclogic.FirstViewMsg();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg.seq.get() != this.b)
      {
        paramFromServiceMsg = c;
        paramObject = new StringBuilder();
        paramObject.append("registerProxyEndSeq:");
        paramObject.append(this.b);
        paramObject.append(" seq:");
        paramObject.append(paramToServiceMsg.seq.get());
        QLog.e(paramFromServiceMsg, 1, paramObject.toString());
        return;
      }
      a(paramToServiceMsg);
      a(paramToServiceMsg, paramFromServiceMsg);
      d(paramToServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramFromServiceMsg = c;
      paramObject = new StringBuilder();
      paramObject.append("handleRegisterProxyFirstViewPush mergeFrom error:");
      paramObject.append(paramToServiceMsg.getMessage());
      QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      paramToServiceMsg.printStackTrace();
      this.a.notifyUI(GuildRegisterProxyObserver.c, false, null);
    }
  }
  
  private void c(synclogic.FirstViewMsg paramFirstViewMsg)
  {
    IGuildMsgSeqTimeService localIGuildMsgSeqTimeService = (IGuildMsgSeqTimeService)this.d.getRuntimeService(IGuildMsgSeqTimeService.class, "");
    IGuildUnreadCntService localIGuildUnreadCntService = (IGuildUnreadCntService)this.d.getRuntimeService(IGuildUnreadCntService.class, "");
    IGuildMsgReadedService localIGuildMsgReadedService = (IGuildMsgReadedService)this.d.getRuntimeService(IGuildMsgReadedService.class, "");
    paramFirstViewMsg = paramFirstViewMsg.rpt_guild_nodes.get().iterator();
    while (paramFirstViewMsg.hasNext())
    {
      synclogic.GuildNode localGuildNode = (synclogic.GuildNode)paramFirstViewMsg.next();
      String str1 = String.valueOf(localGuildNode.guild_id.get());
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localGuildNode.rpt_channel_nodes.get().iterator();
      while (localIterator.hasNext())
      {
        synclogic.ChannelNode localChannelNode = (synclogic.ChannelNode)localIterator.next();
        String str2 = String.valueOf(localChannelNode.channel_id.get());
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem1 = new IGuildMsgSeqTimeService.MsgSeqTimeItem(localChannelNode.msg_seq.get(), localChannelNode.cnt_seq.get(), localChannelNode.msg_time.get(), localChannelNode.msg_meta.get().toByteArray());
        localIGuildMsgSeqTimeService.verifyLastSvrMsgSeq(str1, str2, localMsgSeqTimeItem1);
        Object localObject1 = localIGuildMsgSeqTimeService.getReadedMsgSeq(str2);
        Object localObject2;
        if ((((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).a()) && (localChannelNode.member_read_cnt_seq.get() > ((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).b))
        {
          localArrayList.add(str2);
          if (QLog.isColorLevel())
          {
            localObject1 = c;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleGuildNode readseqChange channel_id:");
            ((StringBuilder)localObject2).append(str2);
            QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
        }
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem2 = new IGuildMsgSeqTimeService.MsgSeqTimeItem();
        localMsgSeqTimeItem2.b = localChannelNode.member_read_cnt_seq.get();
        localMsgSeqTimeItem2.a = localChannelNode.member_read_msg_seq.get();
        localMsgSeqTimeItem2.d = localChannelNode.read_msg_meta.get().toByteArray();
        localIGuildMsgSeqTimeService.verifyReadedMsgSeq(str1, str2, localMsgSeqTimeItem2);
        if (QLog.isColorLevel())
        {
          String str3 = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleGuildNode GuildNode channel_id:");
          localStringBuilder.append(str2);
          localStringBuilder.append(" msg_seq:");
          localStringBuilder.append(localChannelNode.msg_seq.get());
          localStringBuilder.append(" cnt_seq:");
          localStringBuilder.append(localChannelNode.cnt_seq.get());
          localStringBuilder.append(" msg_time:");
          localStringBuilder.append(localChannelNode.msg_time.get());
          localStringBuilder.append(" member_read_msg_seq:");
          localStringBuilder.append(localChannelNode.member_read_msg_seq.get());
          localStringBuilder.append(" member_read_cnt_seq:");
          localStringBuilder.append(localChannelNode.member_read_cnt_seq.get());
          localStringBuilder.append(" msg_notify_type:");
          localStringBuilder.append(localChannelNode.msg_notify_type.get());
          localStringBuilder.append(" msg_meta: ");
          boolean bool = localChannelNode.msg_meta.has();
          localObject2 = "null";
          if (bool) {
            localObject1 = "not null";
          } else {
            localObject1 = "null";
          }
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" lastMsgSeqSvr at_all_seq: ");
          localStringBuilder.append(localMsgSeqTimeItem1.c());
          localStringBuilder.append(" read_msg_meta: ");
          localObject1 = localObject2;
          if (localChannelNode.read_msg_meta.has()) {
            localObject1 = "not null";
          }
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" msgSeqReadedItem at_all_seq: ");
          localStringBuilder.append(localMsgSeqTimeItem2.c());
          localStringBuilder.append(" event_time:");
          localStringBuilder.append(localChannelNode.event_time.get());
          QLog.i(str3, 2, localStringBuilder.toString());
        }
        localIGuildUnreadCntService.refreshAndNotifyChannelUnreadCntInfo(str2);
        localIGuildMsgSeqTimeService.setEventFlowTimeItem(str1, str2, localChannelNode.event_time.get());
      }
      localIGuildUnreadCntService.refreshAndNotifyGuildUnreadCntInfo(String.valueOf(localGuildNode.guild_id.get()));
      long l = localGuildNode.guild_id.get();
      localIGuildMsgReadedService.onRegisterProxyMsgReaded(String.valueOf(l), localArrayList);
    }
  }
  
  private void d()
  {
    if ((this.g) && (this.f.size() == 0))
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildNodes size:");
      ArrayList localArrayList = this.e;
      int i;
      if (localArrayList != null) {
        i = localArrayList.size();
      } else {
        i = 0;
      }
      localStringBuilder.append(i);
      localStringBuilder.append(" guildCount:");
      localStringBuilder.append(this.h);
      QLog.i(str, 1, localStringBuilder.toString());
      this.a.notifyUI(GuildRegisterProxyObserver.c, true, new Object[] { this.e });
    }
  }
  
  private void d(synclogic.FirstViewMsg paramFirstViewMsg)
  {
    if ((paramFirstViewMsg.push_flag.has()) && (paramFirstViewMsg.push_flag.get() == 1))
    {
      this.g = true;
      QLog.i(c, 1, "handlePushFlag end");
      d();
    }
  }
  
  public void a()
  {
    if (this.a.a() != null) {
      this.a.a().b(this);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    try
    {
      boolean bool = paramObject instanceof Long;
      if (!bool) {
        return;
      }
      long l = ((Long)paramObject).longValue();
      if (this.f.contains(Long.valueOf(l)))
      {
        this.f.remove(Long.valueOf(l));
        if (QLog.isColorLevel())
        {
          paramObject = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onNotifyg seq:");
          localStringBuilder.append(l);
          QLog.i(paramObject, 2, localStringBuilder.toString());
        }
        d();
      }
      return;
    }
    finally {}
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      if ("trpc.group_pro.synclogic.SyncLogic.SyncFirstView".equals(paramFromServiceMsg.getServiceCmd())) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if ("trpc.group_pro.synclogic.SyncLogic.PushFirstView".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    finally {}
  }
  
  public boolean a(Object paramObject)
  {
    try
    {
      c();
      Object localObject = new synclogic.FirstViewReq();
      ((synclogic.FirstViewReq)localObject).last_msg_time.set(this.a.b());
      ((synclogic.FirstViewReq)localObject).seq.set(this.b);
      paramObject = this.a.createToServiceMsg("trpc.group_pro.synclogic.SyncLogic.SyncFirstView", null);
      paramObject.putWupBuffer(((synclogic.FirstViewReq)localObject).toByteArray());
      paramObject.extraData.putInt("registerProxyEndSeq", this.b);
      localObject = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend registerProxyEndSeq:");
      localStringBuilder.append(this.b);
      localStringBuilder.append("lastMsgTime:");
      localStringBuilder.append(this.a.b());
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      this.a.sendPbReq(paramObject);
      return true;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public int b()
  {
    try
    {
      int i = this.b;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyFirstViewProcesser
 * JD-Core Version:    0.7.0.1
 */