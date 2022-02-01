package com.tencent.mobileqq.guild.message;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.base.AbsGuildGuestMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageProcessor;
import com.tencent.mobileqq.guild.message.base.IGuildMessageCallback;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.oidb0xfa2.Oidb0xfa2.ChannelMsg;

public class GuildGuestMessageProcessor
  extends BaseGuildMessageProcessor
{
  private static String a = "BaseGuildMessageProcessor.GuildGuestMessageProcessor";
  private static AbsGuildGuestMessageProcessorCallback b;
  
  public GuildGuestMessageProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(Bundle paramBundle, ArrayList<MessageRecord> paramArrayList)
  {
    if (paramBundle == null) {
      return;
    }
    Object localObject2 = (IMessageFacade)this.d.getRuntimeService(IMessageFacade.class, "");
    Object localObject1 = (List)((IMessageFacade)localObject2).getPullCache().get(Integer.valueOf(paramBundle.getInt("counter")));
    ((IMessageFacade)localObject2).getPullCache().remove(Integer.valueOf(paramBundle.getInt("counter")));
    if (localObject1 != null)
    {
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          MsgProxyUtils.c((List)localObject1, (MessageRecord)paramArrayList.next(), true);
        }
      }
      paramArrayList = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyLocalList, counter: ");
      ((StringBuilder)localObject2).append(paramBundle.getInt("counter"));
      QLog.i(paramArrayList, 2, ((StringBuilder)localObject2).toString());
      try
      {
        localObject1.notify();
        return;
      }
      finally {}
    }
    paramArrayList = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("notifyLocalList, locallist is null! counter: ");
    ((StringBuilder)localObject1).append(paramBundle.getInt("counter"));
    QLog.e(paramArrayList, 2, ((StringBuilder)localObject1).toString());
  }
  
  public static void a(IGuildMessageCallback paramIGuildMessageCallback)
  {
    if ((paramIGuildMessageCallback instanceof AbsGuildGuestMessageProcessorCallback)) {
      b = (AbsGuildGuestMessageProcessorCallback)paramIGuildMessageCallback;
    }
  }
  
  private void a(Oidb0xfa2.ChannelMsg paramChannelMsg, Bundle paramBundle, int paramInt)
  {
    if (paramChannelMsg == null)
    {
      if (paramInt == 2) {
        a(paramBundle, null);
      }
      return;
    }
    long l1 = paramChannelMsg.guild_id.get();
    long l2 = paramChannelMsg.channel_id.get();
    long l3 = paramChannelMsg.rsp_begin_seq.get();
    long l4 = paramChannelMsg.rsp_end_seq.get();
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processGuestMsg: guildId:");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(", channelId: ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(", beginSeq: ");
      ((StringBuilder)localObject2).append(l3);
      ((StringBuilder)localObject2).append(", endSeq: ");
      ((StringBuilder)localObject2).append(l4);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ArrayList();
    a(paramChannelMsg.rpt_msgs.get(), (List)localObject2);
    if (((ArrayList)localObject2).isEmpty())
    {
      QLog.e(a, 1, "msgs is empty! notify locallist");
      if (paramInt == 2) {
        a(paramBundle, null);
      }
      return;
    }
    Object localObject1 = new ArrayList();
    paramChannelMsg = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ArrayList localArrayList = a((common.Msg)((Iterator)localObject2).next(), this.d.getCurrentAccountUin(), new MessageInfo(), -1L);
      a(localArrayList);
      a(localArrayList, (ArrayList)localObject1, paramChannelMsg, true);
    }
    Collections.sort((List)localObject1, this.e);
    paramChannelMsg = ((ArrayList)localObject1).iterator();
    while (paramChannelMsg.hasNext()) {
      b((MessageRecord)paramChannelMsg.next());
    }
    if (QLog.isColorLevel())
    {
      paramChannelMsg = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("processGuestMsg, before add to cache, msgRecords size:");
      ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
      QLog.d(paramChannelMsg, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 1) {
      ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(10014).a(10014).b(String.valueOf(l2), 10014, l3, (List)localObject1);
    } else {
      a(paramBundle, (ArrayList)localObject1);
    }
    b.a(this.d, (ArrayList)localObject1);
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((Oidb0xfa2.ChannelMsg)paramVarArgs[0], (Bundle)paramVarArgs[1], ((Integer)paramVarArgs[2]).intValue());
      return;
    }
    a(getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildGuestMessageProcessor
 * JD-Core Version:    0.7.0.1
 */