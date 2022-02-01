package com.tencent.mobileqq.guild.message;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi.MsgSeqItem;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.base.AbsGuildPushMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageProcessor;
import com.tencent.mobileqq.guild.message.base.IGuildMessageCallback;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.common.common.MsgHead;
import tencent.im.group_pro_proto.common.common.RoutingHead;
import tencent.im.group_pro_proto.msgpush.msgpush.FocusInfo;
import tencent.im.group_pro_proto.msgpush.msgpush.MsgOnlinePush;
import tencent.im.group_pro_proto.msgpush.msgpush.PressMsg;

public class GuildOnlineMessageProcessor
  extends BaseGuildMessageProcessor
{
  public static int b = 1;
  public static int c = 2;
  private static AbsGuildPushMessageProcessorCallback f;
  final String a = "BaseGuildMessageProcessor.GuildOnlineMessageProcessor";
  private long g = 0L;
  
  public GuildOnlineMessageProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private List<common.Msg> a(@NonNull msgpush.MsgOnlinePush paramMsgOnlinePush)
  {
    int i = paramMsgOnlinePush.compress_flag.get();
    Object localObject = null;
    if (i == 1)
    {
      if (!paramMsgOnlinePush.compress_msg.has()) {
        return localObject;
      }
      paramMsgOnlinePush = paramMsgOnlinePush.compress_msg.get().toByteArray();
      paramMsgOnlinePush = ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).lz4DecompressBuf(paramMsgOnlinePush);
      localObject = new msgpush.PressMsg();
      try
      {
        ((msgpush.PressMsg)localObject).mergeFrom(paramMsgOnlinePush);
        paramMsgOnlinePush = ((msgpush.PressMsg)localObject).msgs.get();
        return paramMsgOnlinePush;
      }
      catch (NullPointerException paramMsgOnlinePush)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeMsgList e: ");
        ((StringBuilder)localObject).append(paramMsgOnlinePush);
        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, ((StringBuilder)localObject).toString());
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramMsgOnlinePush)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeMsgList e: ");
        ((StringBuilder)localObject).append(paramMsgOnlinePush);
        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, ((StringBuilder)localObject).toString());
        return null;
      }
    }
    localObject = paramMsgOnlinePush.msgs.get();
    return localObject;
  }
  
  private void a(long paramLong, List<common.Msg> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    a(paramList, localArrayList, (List)localObject1, true);
    paramList = new StringBuilder();
    paramList.append("processPush, pushMsgList: ");
    paramList.append(((List)localObject1).size());
    paramList.append(", from: ");
    paramList.append(paramInt);
    QLog.i("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 1, paramList.toString());
    if (paramInt == c) {
      a((List)localObject1, true);
    } else {
      a((List)localObject1, false);
    }
    paramList = ((List)localObject1).iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (common.Msg)paramList.next();
      localObject1 = new MessageInfo();
      Object localObject3 = a((common.Msg)localObject2, String.valueOf(paramLong), (MessageInfo)localObject1, -1L);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processPush, after decodeMsg, msgTempListSize: ");
        ((StringBuilder)localObject2).append(((ArrayList)localObject3).size());
        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      a((List)localObject3);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("processPush : after visibleBlankMsgFilter, msgListSize: ");
        ((StringBuilder)localObject2).append(((ArrayList)localObject3).size());
        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      if (((ArrayList)localObject3).size() == 0) {
        return;
      }
      localObject2 = new ArrayList();
      Object localObject4 = new ArrayList();
      a((List)localObject3, (ArrayList)localObject2, (ArrayList)localObject4, true);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("processPush : after filterDuplicatedMsg, msgListSize: ");
        ((StringBuilder)localObject3).append(((ArrayList)localObject2).size());
        ((StringBuilder)localObject3).append(", msgFilteredRecords size: ");
        ((StringBuilder)localObject3).append(((ArrayList)localObject4).size());
        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, ((StringBuilder)localObject3).toString());
      }
      a((ArrayList)localObject4);
      if (((ArrayList)localObject2).size() == 0) {
        return;
      }
      localObject3 = new ArrayList();
      paramInt = 0;
      while (paramInt < ((ArrayList)localObject2).size())
      {
        localObject4 = (MessageRecord)((ArrayList)localObject2).get(paramInt);
        a((ArrayList)localObject3, (MessageRecord)localObject4);
        c((MessageRecord)localObject4);
        paramInt += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("processPush : after checkAndHandleSelfSendMessage, msgListSize: ");
        ((StringBuilder)localObject4).append(((ArrayList)localObject3).size());
        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, ((StringBuilder)localObject4).toString());
      }
      localObject4 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject4).hasNext()) {
        b((MessageRecord)((Iterator)localObject4).next());
      }
      localObject4 = f;
      if (localObject4 != null) {
        ((AbsGuildPushMessageProcessorCallback)localObject4).a(this.d, (ArrayList)localObject2, (MessageInfo)localObject1);
      }
      boolean bool = BaseMessageHandlerUtils.a((ArrayList)localObject3);
      localObject1 = (IMessageFacade)this.d.getRuntimeService(IMessageFacade.class, "");
      if ((bool) && (this.d.isBackgroundStop)) {
        bool = true;
      } else {
        bool = false;
      }
      ((IMessageFacade)localObject1).addMessage((ArrayList)localObject3, String.valueOf(paramLong), bool, false, true);
      ((IGuildMsgSeqTimeService)this.d.getRuntimeService(IGuildMsgSeqTimeService.class, "")).updateLastSeqAndTime((ArrayList)localObject3);
      localObject1 = f;
      if (localObject1 != null) {
        ((AbsGuildPushMessageProcessorCallback)localObject1).a(this.d, (ArrayList)localObject3);
      }
      b((List)localObject3);
    }
    a(localArrayList, 2);
  }
  
  public static void a(IGuildMessageCallback paramIGuildMessageCallback)
  {
    if ((paramIGuildMessageCallback instanceof AbsGuildPushMessageProcessorCallback)) {
      f = (AbsGuildPushMessageProcessorCallback)paramIGuildMessageCallback;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, msgpush.MsgOnlinePush paramMsgOnlinePush, int paramInt)
  {
    if (a(paramFromServiceMsg, paramMsgOnlinePush)) {
      return;
    }
    if ((!paramMsgOnlinePush.msgs.has()) && (!paramMsgOnlinePush.compress_msg.has())) {
      return;
    }
    if (b(paramFromServiceMsg, paramMsgOnlinePush)) {
      return;
    }
    int j = paramMsgOnlinePush.general_flag.get();
    int i = 0;
    if ((j & 0x20) == 32) {
      NoDisturbUtil.a(true);
    } else {
      NoDisturbUtil.a(false);
    }
    j = paramMsgOnlinePush.general_flag.get();
    AbsGuildPushMessageProcessorCallback localAbsGuildPushMessageProcessorCallback = f;
    if (localAbsGuildPushMessageProcessorCallback != null) {
      localAbsGuildPushMessageProcessorCallback.a(this.d, j & 0x1);
    }
    if (paramFromServiceMsg.getUin() == null) {
      paramFromServiceMsg = this.d.getCurrentAccountUin();
    } else {
      paramFromServiceMsg = paramFromServiceMsg.getUin();
    }
    this.g = Long.valueOf(paramFromServiceMsg).longValue();
    paramFromServiceMsg = a(paramMsgOnlinePush);
    a(paramMsgOnlinePush, paramFromServiceMsg);
    if (QLog.isColorLevel())
    {
      paramMsgOnlinePush = new StringBuilder();
      paramMsgOnlinePush.append("decodeMsgList, size : ");
      if (paramFromServiceMsg != null) {
        i = paramFromServiceMsg.size();
      }
      paramMsgOnlinePush.append(i);
      QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, paramMsgOnlinePush.toString());
    }
    a(this.g, paramFromServiceMsg, paramInt);
  }
  
  private void a(@NonNull msgpush.MsgOnlinePush paramMsgOnlinePush, List<common.Msg> paramList)
  {
    IGuildFocusChannelService localIGuildFocusChannelService = (IGuildFocusChannelService)this.d.getRuntimeService(IGuildFocusChannelService.class, "");
    if (paramMsgOnlinePush.huge_flag.has())
    {
      if (paramMsgOnlinePush.huge_flag.get() != 1) {
        return;
      }
      if (paramList != null)
      {
        HashSet localHashSet = new HashSet();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localHashSet.add(String.valueOf(((common.Msg)paramList.next()).head.routing_head.channel_id.get()));
        }
        localIGuildFocusChannelService.updateHugeChannel(localHashSet);
      }
      if ((paramMsgOnlinePush.focus_info.has()) && (paramMsgOnlinePush.focus_info.uint64_channel_id_list.size() != 0))
      {
        paramList = new HashSet();
        paramMsgOnlinePush = paramMsgOnlinePush.focus_info.uint64_channel_id_list.get().iterator();
        while (paramMsgOnlinePush.hasNext()) {
          paramList.add(String.valueOf(((Long)paramMsgOnlinePush.next()).longValue()));
        }
        localIGuildFocusChannelService.updateFocusChannel(paramList);
        return;
      }
      localIGuildFocusChannelService.updateFocusChannel(null);
    }
  }
  
  public static boolean a()
  {
    AbsGuildPushMessageProcessorCallback localAbsGuildPushMessageProcessorCallback = f;
    if (localAbsGuildPushMessageProcessorCallback != null) {
      return localAbsGuildPushMessageProcessorCallback.a();
    }
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    AbsGuildPushMessageProcessorCallback localAbsGuildPushMessageProcessorCallback = f;
    if (localAbsGuildPushMessageProcessorCallback != null) {
      return localAbsGuildPushMessageProcessorCallback.a(paramAppInterface);
    }
    return true;
  }
  
  private boolean a(FromServiceMsg paramFromServiceMsg, msgpush.MsgOnlinePush paramMsgOnlinePush)
  {
    if (!((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab())
    {
      QLog.e("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 1, "filterHandleOnlinePush notshowguildtab");
      return true;
    }
    return false;
  }
  
  private boolean b(FromServiceMsg paramFromServiceMsg, msgpush.MsgOnlinePush paramMsgOnlinePush)
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, "noNeedProcessPushNow : isNeedToProcessMsg = false");
      }
      return true;
    }
    if (!a(this.d))
    {
      ((IGuildMsgFactory)this.d.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().a(new Object[] { paramFromServiceMsg, paramMsgOnlinePush, Integer.valueOf(b) });
      if (QLog.isColorLevel()) {
        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 2, "noNeedProcessPushNow : isSyncNormalMsgFinish = false");
      }
      return true;
    }
    return false;
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    Object localObject = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    if ((!((IGuildMessageUtilsApi)localObject).isSysMsg(paramMessageRecord)) && (!((IGuildMessageUtilsApi)localObject).isLocalOnlyMsg(paramMessageRecord)))
    {
      localObject = new IGuildAioMsgFilterApi.MsgSeqItem();
      try
      {
        ((IGuildAioMsgFilterApi.MsgSeqItem)localObject).b = paramMessageRecord.shmsgseq;
        ((IGuildAioMsgFilterApi.MsgSeqItem)localObject).c = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("GUILD_MSG_CNT_NAME"));
        ((IGuildAioMsgFilterApi.MsgSeqItem)localObject).a = paramMessageRecord.uniseq;
        ((IGuildAioMsgFilterApi)QRoute.api(IGuildAioMsgFilterApi.class)).updateOnlinePushLatestMsgSeqItem(paramMessageRecord.frienduin, (IGuildAioMsgFilterApi.MsgSeqItem)localObject, false);
        return;
      }
      catch (NumberFormatException paramMessageRecord)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processPushAfterDecodeMsg, e = ");
        ((StringBuilder)localObject).append(paramMessageRecord);
        QLog.d("BaseGuildMessageProcessor.GuildOnlineMessageProcessor", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((FromServiceMsg)paramVarArgs[0], (msgpush.MsgOnlinePush)paramVarArgs[1], ((Integer)paramVarArgs[2]).intValue());
      return;
    }
    a(getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildOnlineMessageProcessor
 * JD-Core Version:    0.7.0.1
 */