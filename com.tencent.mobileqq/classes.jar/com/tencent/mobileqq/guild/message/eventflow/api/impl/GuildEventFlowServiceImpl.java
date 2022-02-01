package com.tencent.mobileqq.guild.message.eventflow.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfoForUpdate;
import com.tencent.mobileqq.guild.message.eventflow.PullChannelEventFlowLogic;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.common.common.Event;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp;

public class GuildEventFlowServiceImpl
  implements IGuildEventFlowService
{
  private static final String TAG = "GuildEventFlowServiceImpl";
  private AppRuntime appRuntime;
  private ConcurrentHashMap<String, PullChannelEventFlowLogic> channelLogicMaps = new ConcurrentHashMap();
  
  private void handleDeleteEvent(@Nullable MessageRecord paramMessageRecord, String paramString1, String paramString2, long paramLong)
  {
    Object localObject1 = (IGuildMessageBoxDataService)this.appRuntime.getRuntimeService(IGuildMessageBoxDataService.class, "");
    Object localObject2 = new ChannelMsgEvent();
    ((ChannelMsgEvent)localObject2).channelId = paramString2;
    ((ChannelMsgEvent)localObject2).eventType = 1L;
    ((ChannelMsgEvent)localObject2).msgSeq = paramLong;
    ((IGuildMessageBoxDataService)localObject1).removeChannelMsgBoxReadEvent((ChannelMsgEvent)localObject2);
    localObject1 = (IGuildMsgSeqTimeService)this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "");
    localObject2 = new DecreaseMsgSeqInfo();
    ((DecreaseMsgSeqInfo)localObject2).msgSeq = paramLong;
    if (paramMessageRecord != null)
    {
      if (((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isAtAllMsg(paramMessageRecord)) {
        ((DecreaseMsgSeqInfo)localObject2).msgType = DecreaseMsgSeqInfo.MSGTYPE_ATALL;
      }
      ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.appRuntime).a(10014).a(10014).a(paramMessageRecord, false);
    }
    ((IGuildMsgSeqTimeService)localObject1).addDecreaseMsgSeq(paramString1, paramString2, (DecreaseMsgSeqInfo)localObject2);
  }
  
  public void onChatMessageExposure(String paramString1, String paramString2, ArrayList<GuildMsgEventInfoForUpdate> paramArrayList)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramArrayList != null))
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      if (!this.channelLogicMaps.containsKey(paramString2)) {
        this.channelLogicMaps.put(paramString2, new PullChannelEventFlowLogic((AppInterface)this.appRuntime, paramString1, paramString2));
      }
      ((PullChannelEventFlowLogic)this.channelLogicMaps.get(paramString2)).a(paramArrayList);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void onPullRoamMsgEventFlowRsp(boolean paramBoolean, ToServiceMsg paramToServiceMsg, synclogic.ChannelMsgRsp paramChannelMsgRsp, ArrayList<common.Msg> paramArrayList)
  {
    String str = paramToServiceMsg.extraData.getString("channelId");
    if (this.channelLogicMaps.containsKey(str)) {
      ((PullChannelEventFlowLogic)this.channelLogicMaps.get(str)).a(paramBoolean, paramToServiceMsg, paramChannelMsgRsp, paramArrayList);
    }
  }
  
  public boolean processEvent(@Nullable MessageRecord paramMessageRecord, common.Event paramEvent, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processEvent. channelId: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" guildId: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" shmsgseq: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" eventType: ");
      localStringBuilder.append(paramEvent.type.get());
      QLog.d("GuildEventFlowServiceImpl", 2, localStringBuilder.toString());
    }
    if ((paramEvent.type.get() != 1L) && (paramEvent.type.get() != 2L)) {
      return false;
    }
    handleDeleteEvent(paramMessageRecord, paramString1, paramString2, paramLong);
    return true;
  }
  
  public void processEvents(@Nullable MessageRecord paramMessageRecord, List<common.Event> paramList, String paramString1, String paramString2, long paramLong)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      processEvent(paramMessageRecord, (common.Event)paramList.next(), paramString1, paramString2, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.eventflow.api.impl.GuildEventFlowServiceImpl
 * JD-Core Version:    0.7.0.1
 */