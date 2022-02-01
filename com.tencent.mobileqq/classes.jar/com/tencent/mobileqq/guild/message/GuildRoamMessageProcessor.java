package com.tencent.mobileqq.guild.message;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.base.AbsGuildRoamMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageProcessor;
import com.tencent.mobileqq.guild.message.base.IGuildMessageCallback;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp;

public class GuildRoamMessageProcessor
  extends BaseGuildMessageProcessor
{
  private static AbsGuildRoamMessageProcessorCallback a;
  
  public GuildRoamMessageProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static void a(IGuildMessageCallback paramIGuildMessageCallback)
  {
    if ((paramIGuildMessageCallback instanceof AbsGuildRoamMessageProcessorCallback)) {
      a = (AbsGuildRoamMessageProcessorCallback)paramIGuildMessageCallback;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, synclogic.ChannelMsgRsp paramChannelMsgRsp, ArrayList<common.Msg> paramArrayList, String paramString)
  {
    paramToServiceMsg.extraData.getString("guildId");
    String str = paramToServiceMsg.extraData.getString("channelId");
    paramToServiceMsg.extraData.getLong("lBeginSeq", 0L);
    paramToServiceMsg.extraData.getLong("lEndSeq", 0L);
    paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
    paramToServiceMsg.putLong("beginSeq", paramChannelMsgRsp.channel_msg.rsp_begin_seq.get());
    paramToServiceMsg.putLong("endSeq", paramChannelMsgRsp.channel_msg.rsp_end_seq.get());
    paramToServiceMsg.putBoolean("success", true);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<---reqPullRoamMsg() processRoam: size:");
      int i;
      if (paramArrayList == null) {
        i = 0;
      } else {
        i = paramArrayList.size();
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      a(paramArrayList, false);
      localObject1 = new ArrayList();
      Object localObject2 = new ArrayList();
      a(paramArrayList, (List)localObject1, (List)localObject2, false);
      paramArrayList = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (common.Msg)((Iterator)localObject2).next();
        MessageInfo localMessageInfo = new MessageInfo();
        localObject3 = a((common.Msg)localObject3, String.valueOf(paramString), localMessageInfo, paramChannelMsgRsp.get_msg_time.get());
        a((List)localObject3);
        a((List)localObject3, paramArrayList, localArrayList, true);
        localObject3 = a;
        if (localObject3 != null) {
          ((AbsGuildRoamMessageProcessorCallback)localObject3).a(this.d, paramArrayList, localMessageInfo);
        }
      }
      Collections.sort(paramArrayList, this.e);
      paramChannelMsgRsp = new ArrayList();
      a(String.valueOf(str), 10014, paramArrayList, paramChannelMsgRsp, paramToServiceMsg);
      a((List)localObject1, 0);
      a(paramArrayList, paramChannelMsgRsp);
      return;
    }
    QLog.e("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 1, "msgs is empty! notify locallist");
    paramArrayList = b();
    paramChannelMsgRsp = (List)paramArrayList.getPullCache().get(Integer.valueOf(paramToServiceMsg.getInt("counter")));
    paramArrayList.getPullCache().remove(Integer.valueOf(paramToServiceMsg.getInt("counter")));
    if (paramChannelMsgRsp != null) {
      try
      {
        paramChannelMsgRsp.notify();
        return;
      }
      finally {}
    }
  }
  
  private boolean a(List<MessageRecord> paramList1, List<MessageRecord> paramList2, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refresh roam msg rewrite sending msg  mr.senderuin: ");
        ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
        ((StringBuilder)localObject).append(" mr.msgtype: ");
        ((StringBuilder)localObject).append(paramMessageRecord.msgtype);
        ((StringBuilder)localObject).append(" mr.frienduin: ");
        ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
        ((StringBuilder)localObject).append(" mr.shmsgseq: ");
        ((StringBuilder)localObject).append(paramMessageRecord.shmsgseq);
        ((StringBuilder)localObject).append(" mr.time:");
        ((StringBuilder)localObject).append(paramMessageRecord.time);
        ((StringBuilder)localObject).append(" mr.msg: ");
        ((StringBuilder)localObject).append(paramMessageRecord.getLogColorContent());
        QLog.d("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
      if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase((String)localObject)))
      {
        paramList2 = a().a(paramList2, paramMessageRecord);
        if (paramList2 != null)
        {
          ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).updateMsgSeqAndTime(this.d, paramList2.uniseq, paramMessageRecord);
          return true;
        }
        paramMessageRecord.issend = 2;
      }
      paramMessageRecord.isread = true;
      paramList1.add(paramMessageRecord);
    }
    return false;
  }
  
  private void b(List<common.Msg> paramList1, List<common.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:");
      localStringBuilder.append(paramList1.size());
      localStringBuilder.append(" outListSize:");
      localStringBuilder.append(paramList2.size());
      QLog.d("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public BaseMsgProxy a()
  {
    return ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageProxy((BaseQQAppInterface)this.d, 10014);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("key_from_parallel_pull", false);
    IMessageFacade localIMessageFacade = b();
    BaseMsgProxy localBaseMsgProxy = a();
    boolean bool2 = paramBundle.getBoolean("success");
    long l4 = paramBundle.getLong("beginSeq", -1L);
    long l5 = paramBundle.getLong("endSeq", -1L);
    List localList = (List)localIMessageFacade.getPullCache().get(Integer.valueOf(paramBundle.getInt("counter")));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doRefreshMessageListHead() refresh roam step 1 , resultSize = ");
    int j = -1;
    int i;
    if (paramList1 == null) {
      i = -1;
    } else {
      i = paramList1.size();
    }
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", localListSize = ");
    if (localList == null) {
      i = j;
    } else {
      i = localList.size();
    }
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" , success = ");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(" , beginSeq = ");
    ((StringBuilder)localObject).append(l4);
    ((StringBuilder)localObject).append(" , endSeq = ");
    ((StringBuilder)localObject).append(l5);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" , time = [");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("]");
    localIMessageFacade.qLogColor((String)localObject, localStringBuilder.toString());
    localIMessageFacade.getPullCache().remove(Integer.valueOf(paramBundle.getInt("counter")));
    if (localList != null)
    {
      if (paramList2 == null) {
        paramList2 = new ArrayList();
      }
      if ((paramList1 != null) && (!paramList1.isEmpty()))
      {
        paramBundle = new ArrayList();
        long l1 = l4 - 15L;
        long l2 = 0L;
        if (l1 <= 0L) {
          l1 = 0L;
        }
        long l3 = l4 - 1L;
        if (l3 > 0L) {
          l2 = l3;
        }
        paramBundle.addAll(localBaseMsgProxy.c(paramString, paramInt, l1, l2));
        paramBundle.addAll(localList);
        a(paramList1, paramList2, paramBundle);
      }
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext()) {
        b((MessageRecord)paramList1.next());
      }
      if (!paramList2.isEmpty()) {
        localBaseMsgProxy.a(paramList2, null);
      }
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext()) {
        a(localList, (MessageRecord)paramList1.next());
      }
      if (QLog.isColorLevel()) {
        QLog.e("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, "notify locallist");
      }
      try
      {
        localList.notify();
      }
      finally {}
    }
    if (bool1) {
      localIMessageFacade.clearInAioParallerPullMsgMark(paramString, l4, l5);
    }
  }
  
  void a(ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2)
  {
    a.a(this.d, paramArrayList1, paramArrayList2);
  }
  
  public void a(List<MessageRecord> paramList, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.getId() < 0L)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("doRefreshMessageListHead() refresh insert db error ! , mr.msg = ");
        paramList.append(paramMessageRecord.getLogColorContent());
        paramList.append(" , mr.seq = ");
        paramList.append(paramMessageRecord.shmsgseq);
        paramList.append(" , mr.uniseq = ");
        paramList.append(paramMessageRecord.uniseq);
        paramList.append(" , extra = ");
        paramList.append(paramMessageRecord.extraflag);
        QLog.w("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, paramList.toString());
      }
    }
    else
    {
      MsgProxyUtils.c(paramList, paramMessageRecord, true);
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("doRefreshMessageListHead() refresh roam step 3 , mr.msg = ");
        paramList.append(paramMessageRecord.getLogColorContent());
        paramList.append(" , mr.seq = ");
        paramList.append(paramMessageRecord.shmsgseq);
        paramList.append(" , mr.uniseq = ");
        paramList.append(paramMessageRecord.uniseq);
        paramList.append(" , extra = ");
        paramList.append(paramMessageRecord.extraflag);
        QLog.d("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, paramList.toString());
      }
    }
  }
  
  public void a(List<MessageRecord> paramList1, List<MessageRecord> paramList2, List<MessageRecord> paramList3)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList1.next();
      Object localObject = paramList3.iterator();
      MessageRecord localMessageRecord2;
      do
      {
        boolean bool2 = ((Iterator)localObject).hasNext();
        bool1 = true;
        if (!bool2) {
          break;
        }
        localMessageRecord2 = (MessageRecord)((Iterator)localObject).next();
      } while (!GuildMsgProxyUtils.a(this.d, localMessageRecord2, localMessageRecord1, false, true));
      break label86;
      boolean bool1 = false;
      label86:
      if ((!a(paramList2, paramList3, localMessageRecord1, bool1)) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doRefreshMessageListHead() refresh roam step 2 , mr.msg = ");
        ((StringBuilder)localObject).append(localMessageRecord1.getLogColorContent());
        ((StringBuilder)localObject).append(" , mr.seq = ");
        ((StringBuilder)localObject).append(localMessageRecord1.shmsgseq);
        ((StringBuilder)localObject).append(" , mr.msgtype = ");
        ((StringBuilder)localObject).append(localMessageRecord1.msgtype);
        ((StringBuilder)localObject).append(", isExist = ");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" , extra = ");
        ((StringBuilder)localObject).append(localMessageRecord1.extraflag);
        QLog.d("BaseGuildMessageProcessor.GuildRoamMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      ArrayList localArrayList = new ArrayList();
      b((ArrayList)paramVarArgs[2], localArrayList);
      a((ToServiceMsg)paramVarArgs[0], (synclogic.ChannelMsgRsp)paramVarArgs[1], localArrayList, (String)paramVarArgs[3]);
      return;
    }
    a(getClass().getName());
  }
  
  public IMessageFacade b()
  {
    return (IMessageFacade)this.d.getRuntimeService(IMessageFacade.class, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildRoamMessageProcessor
 * JD-Core Version:    0.7.0.1
 */