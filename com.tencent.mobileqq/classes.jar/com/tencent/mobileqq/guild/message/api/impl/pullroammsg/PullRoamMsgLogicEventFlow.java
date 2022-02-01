package com.tencent.mobileqq.guild.message.api.impl.pullroammsg;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.impl.GuildRoamMessageHandler;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgReq;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelParam;

public class PullRoamMsgLogicEventFlow
  extends BasePullRoamMsgLogic
{
  public PullRoamMsgLogicEventFlow(AppInterface paramAppInterface, GuildRoamMessageHandler paramGuildRoamMessageHandler)
  {
    super(paramAppInterface, paramGuildRoamMessageHandler);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    ((IGuildEventFlowService)this.a.getRuntimeService(IGuildEventFlowService.class, "")).onPullRoamMsgEventFlowRsp(false, paramToServiceMsg, null, null);
    super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg, synclogic.ChannelMsgRsp paramChannelMsgRsp, ArrayList<common.Msg> paramArrayList)
  {
    ((IGuildEventFlowService)this.a.getRuntimeService(IGuildEventFlowService.class, "")).onPullRoamMsgEventFlowRsp(false, paramToServiceMsg, paramChannelMsgRsp, paramArrayList);
    super.a(paramString, paramToServiceMsg, paramChannelMsgRsp, paramArrayList);
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    if (paramBundle != null) {
      localObject1 = (ArrayList)paramBundle.getSerializable("msgevent_version_list");
    } else {
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      QLog.e("BasePullRoamMsgLogic", 1, "reqPullRoamMsgEventFlow: versionSeqList is null");
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((ArrayList)localObject1).size())
    {
      localObject2 = (Pair)((ArrayList)localObject1).get(i);
      if ((((Long)((Pair)localObject2).first).longValue() >= paramLong1) && (((Long)((Pair)localObject2).first).longValue() <= paramLong2)) {
        localArrayList.add(((Pair)localObject2).second);
      }
      i += 1;
    }
    long l1 = localArrayList.size();
    long l2 = paramLong2 - paramLong1 + 1L;
    if (l1 != l2)
    {
      paramString1 = new StringBuilder();
      paramString1.append("reqPullRoamMsgEventFlow: versionList.size():");
      paramString1.append(localArrayList.size());
      paramString1.append(" seqRange:");
      paramString1.append(l2);
      QLog.e("BasePullRoamMsgLogic", 1, paramString1.toString());
      return false;
    }
    Object localObject1 = this.c.createToServiceMsg("trpc.group_pro.synclogic.SyncLogic.GetChannelMsg");
    ((ToServiceMsg)localObject1).extraData.putString("guildId", paramString1);
    ((ToServiceMsg)localObject1).extraData.putString("channelId", paramString2);
    ((ToServiceMsg)localObject1).extraData.putLong("lBeginSeq", paramLong1);
    ((ToServiceMsg)localObject1).extraData.putLong("lEndSeq", paramLong2);
    ((ToServiceMsg)localObject1).extraData.putBundle("context", paramBundle);
    ((ToServiceMsg)localObject1).extraData.putLong("startTime", System.currentTimeMillis());
    paramBundle = new synclogic.ChannelMsgReq();
    Object localObject2 = new synclogic.ChannelParam();
    ((synclogic.ChannelParam)localObject2).begin_seq.set(paramLong1);
    ((synclogic.ChannelParam)localObject2).end_seq.set(paramLong2);
    ((synclogic.ChannelParam)localObject2).guild_id.set(Long.valueOf(paramString1).longValue());
    ((synclogic.ChannelParam)localObject2).channel_id.set(Long.valueOf(paramString2).longValue());
    ((synclogic.ChannelParam)localObject2).rpt_version.set(localArrayList);
    paramBundle.channel_param.set((MessageMicro)localObject2);
    paramBundle.with_version_flag.set(1);
    ((ToServiceMsg)localObject1).putWupBuffer(paramBundle.toByteArray());
    this.c.sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("--->>reqPullRoamMsgEventFlow channelId: ");
      paramBundle.append(paramString2);
      paramBundle.append(" key: ");
      paramBundle.append(paramString1);
      paramBundle.append(" beginSeq: ");
      paramBundle.append(paramLong1);
      paramBundle.append(" endSeq: ");
      paramBundle.append(paramLong2);
      paramBundle.append(" rpt_version:");
      paramBundle.append(localArrayList.toString());
      QLog.d("BasePullRoamMsgLogic", 2, paramBundle.toString());
    }
    return true;
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    ((IGuildEventFlowService)this.a.getRuntimeService(IGuildEventFlowService.class, "")).onPullRoamMsgEventFlowRsp(false, paramToServiceMsg, null, null);
    super.b(paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.pullroammsg.PullRoamMsgLogicEventFlow
 * JD-Core Version:    0.7.0.1
 */