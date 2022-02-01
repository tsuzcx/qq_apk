package com.tencent.mobileqq.guild.message;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.base.AbsGuildOfflineMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageProcessor;
import com.tencent.mobileqq.guild.message.base.IGuildMessageCallback;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsg;

public class GuildOfflineMessageProcessor
  extends BaseGuildMessageProcessor
{
  private static String a = "BaseGuildMessageProcessor.GuildOfflineMessageProcessor";
  private static AbsGuildOfflineMessageProcessorCallback b;
  
  public GuildOfflineMessageProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(Bundle paramBundle, synclogic.ChannelMsg paramChannelMsg)
  {
    if (paramChannelMsg != null)
    {
      if (!paramChannelMsg.rpt_msgs.has()) {
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = paramChannelMsg.rpt_msgs.get();
      a((List)localObject1, (List)localObject2);
      Object localObject3 = a;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("processOffline. inListSize:");
      ((StringBuilder)localObject4).append(((List)localObject1).size());
      ((StringBuilder)localObject4).append(", outListSize: ");
      ((StringBuilder)localObject4).append(((List)localObject2).size());
      QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      if (((List)localObject2).isEmpty()) {
        return;
      }
      localObject4 = new ArrayList();
      Object localObject5 = new ArrayList();
      a((List)localObject1, (List)localObject4, (List)localObject5, false);
      a((List)localObject5, false);
      if (paramChannelMsg.channel_id.has()) {
        localObject1 = String.valueOf(paramChannelMsg.channel_id.get());
      } else {
        localObject1 = "";
      }
      if (paramChannelMsg.guild_id.has()) {
        localObject3 = String.valueOf(paramChannelMsg.guild_id.get());
      } else {
        localObject3 = "";
      }
      if (paramBundle.getString("selfuin") == null) {
        localObject2 = this.d.getCurrentAccountUin();
      } else {
        localObject2 = paramBundle.getString("selfuin");
      }
      long l1 = paramBundle.getLong("getMsgTime");
      if (paramChannelMsg.result.get() == 200003)
      {
        long l2 = paramChannelMsg.rsp_begin_seq.get();
        if (QLog.isColorLevel())
        {
          paramBundle = a;
          paramChannelMsg = new StringBuilder();
          paramChannelMsg.append("processOffline MsgLifeOver !! beginSeq = ");
          paramChannelMsg.append(l2);
          QLog.d(paramBundle, 2, paramChannelMsg.toString());
        }
        ((IGuildMsgSeqTimeService)this.d.getRuntimeService(IGuildMsgSeqTimeService.class, "")).setExpiredMsgSeq((String)localObject3, (String)localObject1, l2);
      }
      paramBundle = new ArrayList();
      paramChannelMsg = ((List)localObject5).iterator();
      while (paramChannelMsg.hasNext())
      {
        localObject5 = (common.Msg)paramChannelMsg.next();
        localObject3 = new MessageInfo();
        Object localObject6 = a((common.Msg)localObject5, (String)localObject2, (MessageInfo)localObject3, l1);
        a((List)localObject6);
        if (QLog.isColorLevel())
        {
          localObject5 = a;
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("processOffline : after visibleBlankMsgFilter, msgListSize: ");
          ((StringBuilder)localObject7).append(((ArrayList)localObject6).size());
          QLog.d((String)localObject5, 2, ((StringBuilder)localObject7).toString());
        }
        if (((ArrayList)localObject6).size() == 0) {
          return;
        }
        localObject5 = new ArrayList();
        Object localObject7 = new ArrayList();
        a((List)localObject6, (ArrayList)localObject5, (ArrayList)localObject7, true);
        if (QLog.isColorLevel())
        {
          localObject6 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("processOffline : after filterDuplicatedMsg, msgListSize: ");
          localStringBuilder.append(((ArrayList)localObject5).size());
          QLog.d((String)localObject6, 2, localStringBuilder.toString());
        }
        a((ArrayList)localObject7);
        localObject6 = new ArrayList();
        int i = 0;
        while (i < ((ArrayList)localObject5).size())
        {
          a((ArrayList)localObject6, (MessageRecord)((ArrayList)localObject5).get(i));
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          localObject5 = a;
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("processOffline : after checkAndHandleSelfSendMessage, msgListSize: ");
          ((StringBuilder)localObject7).append(((ArrayList)localObject6).size());
          QLog.d((String)localObject5, 2, ((StringBuilder)localObject7).toString());
        }
        localObject5 = ((ArrayList)localObject6).iterator();
        while (((Iterator)localObject5).hasNext()) {
          b((MessageRecord)((Iterator)localObject5).next());
        }
        localObject5 = b;
        if (localObject5 != null) {
          ((AbsGuildOfflineMessageProcessorCallback)localObject5).a(this.d, (String)localObject1, (ArrayList)localObject6, (MessageInfo)localObject3);
        }
        a((String)localObject1, (ArrayList)localObject6, (String)localObject2);
        ((IGuildMsgSeqTimeService)this.d.getRuntimeService(IGuildMsgSeqTimeService.class, "")).updateLastSeqAndTime((ArrayList)localObject6);
        paramBundle.addAll((Collection)localObject6);
      }
      Collections.sort(paramBundle, this.e);
      a((List)localObject4, 1);
      paramChannelMsg = b;
      if (paramChannelMsg != null) {
        paramChannelMsg.a(this.d, paramBundle);
      }
      b(paramBundle);
    }
  }
  
  public static void a(IGuildMessageCallback paramIGuildMessageCallback)
  {
    if ((paramIGuildMessageCallback instanceof AbsGuildOfflineMessageProcessorCallback)) {
      b = (AbsGuildOfflineMessageProcessorCallback)paramIGuildMessageCallback;
    }
  }
  
  private void a(String paramString1, ArrayList<MessageRecord> paramArrayList, String paramString2)
  {
    if ((paramArrayList != null) && (paramArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w(a, 2, "refresh autopull FAIL! mrList is empty!");
      }
      return;
    }
    boolean bool4 = BaseMessageHandlerUtils.a(paramArrayList);
    IMessageFacade localIMessageFacade = (IMessageFacade)this.d.getRuntimeService(IMessageFacade.class, "");
    Object localObject = localIMessageFacade.getAutoPullCache();
    String str = UinTypeUtil.a(paramString1, 10014);
    boolean bool3 = true;
    boolean bool2 = true;
    ((ConcurrentHashMap)localObject).put(str, Boolean.valueOf(true));
    localObject = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(10014).a(10014);
    paramString1 = ((BaseMsgProxy)localObject).g(paramString1, 10014);
    boolean bool1;
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      paramArrayList = MsgProxyUtils.a(paramArrayList, true);
      long l1 = ((MessageRecord)paramArrayList.get(0)).shmsgseq;
      long l2 = ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq + 1L;
      if (l1 <= l2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveMsgListToDB : in AIO, isJoined: ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", continuedListFirstSeq: ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", aioLastSeq: ");
        localStringBuilder.append(l2);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (bool1)
      {
        int i = 0;
        while (i < paramArrayList.size())
        {
          if (((MessageRecord)paramArrayList.get(i)).shmsgseq > ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq) {
            break label359;
          }
          i += 1;
        }
        i = 0;
        label359:
        paramArrayList = paramArrayList.subList(i, paramArrayList.size());
        localObject = new ArrayList(paramArrayList);
        if ((!paramArrayList.isEmpty()) && (((MessageRecord)paramString1.get(0)).shmsgseq <= ((MessageRecord)paramArrayList.get(0)).shmsgseq))
        {
          if ((bool4) && (this.d.isBackgroundStop)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          localIMessageFacade.addMessage((ArrayList)localObject, paramString2, bool1, false, true);
        }
      }
      else
      {
        ((BaseMsgProxy)localObject).e();
        paramString1 = new ArrayList(paramArrayList);
        if ((bool4) && (this.d.isBackgroundStop)) {
          bool1 = bool3;
        } else {
          bool1 = false;
        }
        localIMessageFacade.addMessage(paramString1, paramString2, bool1, false, true);
      }
    }
    else
    {
      if ((bool4) && (this.d.isBackgroundStop)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localIMessageFacade.addMessage(paramArrayList, paramString2, bool1, false, true);
    }
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 2))
    {
      a((Bundle)paramVarArgs[0], (synclogic.ChannelMsg)paramVarArgs[1]);
      return;
    }
    a(getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildOfflineMessageProcessor
 * JD-Core Version:    0.7.0.1
 */