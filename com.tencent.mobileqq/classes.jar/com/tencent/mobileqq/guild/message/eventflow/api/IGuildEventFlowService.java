package com.tencent.mobileqq.guild.message.eventflow.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfoForUpdate;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;
import tencent.im.group_pro_proto.common.common.Event;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp;

@Service(process={""})
public abstract interface IGuildEventFlowService
  extends IRuntimeService
{
  public abstract void onChatMessageExposure(String paramString1, String paramString2, ArrayList<GuildMsgEventInfoForUpdate> paramArrayList);
  
  public abstract void onPullRoamMsgEventFlowRsp(boolean paramBoolean, ToServiceMsg paramToServiceMsg, synclogic.ChannelMsgRsp paramChannelMsgRsp, ArrayList<common.Msg> paramArrayList);
  
  public abstract boolean processEvent(@Nullable MessageRecord paramMessageRecord, common.Event paramEvent, String paramString1, String paramString2, long paramLong);
  
  public abstract void processEvents(@Nullable MessageRecord paramMessageRecord, List<common.Event> paramList, String paramString1, String paramString2, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService
 * JD-Core Version:    0.7.0.1
 */