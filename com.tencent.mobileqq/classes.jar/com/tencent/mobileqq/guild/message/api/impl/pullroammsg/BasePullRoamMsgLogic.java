package com.tencent.mobileqq.guild.message.api.impl.pullroammsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.impl.GuildRoamMessageHandler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp;

public abstract class BasePullRoamMsgLogic
{
  public AppInterface a;
  MessageCache b;
  public GuildRoamMessageHandler c;
  private ArrayList<common.Msg> d = new ArrayList();
  
  public BasePullRoamMsgLogic(AppInterface paramAppInterface, GuildRoamMessageHandler paramGuildRoamMessageHandler)
  {
    this.a = paramAppInterface;
    this.c = paramGuildRoamMessageHandler;
    this.b = ((MessageCache)paramAppInterface.getMsgCache());
  }
  
  private IGPSService a()
  {
    return (IGPSService)this.a.getRuntimeService(IGPSService.class, "");
  }
  
  private void a(List<common.Msg> paramList)
  {
    this.d.addAll(paramList);
  }
  
  private void a(synclogic.ChannelMsgRsp paramChannelMsgRsp, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      int i = paramChannelMsgRsp.result.get();
      int j = paramChannelMsgRsp.with_version_flag.get();
      boolean bool = paramChannelMsgRsp.channel_msg.has();
      long l1 = 0L;
      long l2;
      if (bool)
      {
        l1 = paramChannelMsgRsp.channel_msg.rsp_begin_seq.get();
        l2 = paramChannelMsgRsp.channel_msg.rsp_end_seq.get();
      }
      else
      {
        l2 = 0L;
      }
      QLog.i("BasePullRoamMsgLogic", 2, String.format("handleReqPullRoamMsg() resCode=%d with_version_flag=%d channelId=%s key=%s seq=[%d,%d] rspSeq=[%d,%d] msgSize=%d startTime=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramString2, paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((synclogic.ChannelMsg)paramChannelMsgRsp.channel_msg.get()).rpt_msgs.size()), Long.valueOf(paramLong3) }));
    }
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, synclogic.ChannelMsgRsp paramChannelMsgRsp)
  {
    int i;
    if (((paramChannelMsgRsp.result.get() == 0) || (paramChannelMsgRsp.result.get() == 200003)) && (((synclogic.ChannelMsg)paramChannelMsgRsp.channel_msg.get()).rpt_msgs.size() > 0) && (((synclogic.ChannelMsg)paramChannelMsgRsp.channel_msg.get()).rsp_begin_seq.get() <= ((synclogic.ChannelMsg)paramChannelMsgRsp.channel_msg.get()).rsp_end_seq.get())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BasePullRoamMsgLogic", 2, "handleReqPullRoamMsgPullNext() data invalid return. ");
      }
      return false;
    }
    long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq", 0L);
    paramToServiceMsg.extraData.getLong("lEndSeq", 0L);
    long l2 = ((synclogic.ChannelMsg)paramChannelMsgRsp.channel_msg.get()).rsp_begin_seq.get();
    paramToServiceMsg.extraData.getString("guildId");
    String str = paramToServiceMsg.extraData.getString("channelId");
    a(((synclogic.ChannelMsg)paramChannelMsgRsp.channel_msg.get()).rpt_msgs.get());
    if (paramChannelMsgRsp.result.get() == 200003) {
      return false;
    }
    l2 -= 1L;
    if (l1 <= l2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BasePullRoamMsgLogic", 2, "handleReqPullRoamMsgPullNext() need pull next. ");
      }
      return a(str, l1, l2, paramToServiceMsg.extraData.getBundle("context"));
    }
    return false;
  }
  
  private ArrayList<common.Msg> b()
  {
    return this.d;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.c.removePullRoamMsgLogic(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new synclogic.ChannelMsgRsp();
    paramFromServiceMsg.mergeFrom((byte[])paramObject);
    paramObject = paramToServiceMsg.extraData.getString("guildId");
    String str = paramToServiceMsg.extraData.getString("channelId");
    long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq", 0L);
    long l2 = paramToServiceMsg.extraData.getLong("lEndSeq", 0L);
    long l3 = paramToServiceMsg.extraData.getLong("startTime", 0L);
    Bundle localBundle = paramToServiceMsg.extraData.getBundle("context");
    a(paramFromServiceMsg, paramObject, str, l1, l2, l3);
    if (a(paramToServiceMsg, paramFromServiceMsg)) {
      return;
    }
    localBundle.putInt("resCode", paramFromServiceMsg.result.get());
    a(str, paramToServiceMsg, paramFromServiceMsg, b());
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg, synclogic.ChannelMsgRsp paramChannelMsgRsp, ArrayList<common.Msg> paramArrayList)
  {
    this.c.removePullRoamMsgLogic(paramToServiceMsg);
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    long l = this.b.b(paramString, 10014);
    String str = a().getGuildIdOf(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>reqPullRoamMsg() channelId: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" pullSeq");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" endSeq: ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" delSeq: ");
      localStringBuilder.append(l);
      localStringBuilder.append(" pull num : ");
      localStringBuilder.append(paramLong2 - paramLong1 + 1L);
      localStringBuilder.append(" ThreadId:");
      localStringBuilder.append(Thread.currentThread().getId());
      QLog.d("BasePullRoamMsgLogic", 2, localStringBuilder.toString());
    }
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString))) {
      return a(str, paramString, paramLong1, paramLong2, paramBundle);
    }
    return false;
  }
  
  public abstract boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, Bundle paramBundle);
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.c.removePullRoamMsgLogic(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.pullroammsg.BasePullRoamMsgLogic
 * JD-Core Version:    0.7.0.1
 */