package com.tencent.mobileqq.guild.message;

import android.content.ContentValues;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.base.AbsGuildSystemMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageProcessor;
import com.tencent.mobileqq.guild.message.base.IGuildMessageCallback;
import com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfo.VersionItem;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Ltencent.im.group_pro_proto.common.common.Msg;>;
import java.util.Iterator;
import java.util.List;
import tencent.im.group_pro_proto.common.common.Event;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.common.common.MsgHead;
import tencent.im.group_pro_proto.common.common.RoutingHead;
import tencent.im.group_pro_proto.group_pro.comm.common.MsgSeq;
import tencent.im.group_pro_proto.msgpush.servtype.EventBody;
import tencent.im.group_pro_proto.msgpush.servtype.ReadNotify;
import tencent.im.group_pro_proto.msgpush.servtype.UpdateMsg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class GuildSystemMessageProcessor
  extends BaseGuildMessageProcessor
{
  private static AbsGuildSystemMessageProcessorCallback a;
  
  public GuildSystemMessageProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static void a(IGuildMessageCallback paramIGuildMessageCallback)
  {
    if ((paramIGuildMessageCallback instanceof AbsGuildSystemMessageProcessorCallback)) {
      a = (AbsGuildSystemMessageProcessorCallback)paramIGuildMessageCallback;
    }
  }
  
  private void a(ArrayList<common.Msg> paramArrayList, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("processSystem, msgs size = ");
    int i;
    if (paramArrayList == null) {
      i = 0;
    } else {
      i = paramArrayList.size();
    }
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", fromType = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 2, ((StringBuilder)localObject).toString());
    Iterator localIterator1 = paramArrayList.iterator();
    while (localIterator1.hasNext())
    {
      common.Msg localMsg = (common.Msg)localIterator1.next();
      localObject = null;
      Iterator localIterator2 = ((im_msg_body.RichText)((im_msg_body.MsgBody)localMsg.body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        paramArrayList = (ArrayList<common.Msg>)localObject;
        if (!localIterator2.hasNext()) {
          break;
        }
        paramArrayList = (im_msg_body.Elem)localIterator2.next();
      } while (!paramArrayList.common_elem.has());
      paramArrayList = (im_msg_body.CommonElem)paramArrayList.common_elem.get();
      if ((paramArrayList != null) && (500 == paramArrayList.uint32_service_type.get()))
      {
        localObject = new servtype.EventBody();
        try
        {
          ((servtype.EventBody)localObject).mergeFrom(paramArrayList.bytes_pb_elem.get().toByteArray());
          a((servtype.EventBody)localObject);
          a((servtype.EventBody)localObject, localMsg.head);
        }
        catch (InvalidProtocolBufferMicroException paramArrayList)
        {
          paramArrayList.printStackTrace();
          QLog.e("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "processSystem: error: parse EventBody");
        }
      }
    }
  }
  
  private void a(servtype.EventBody paramEventBody)
  {
    if (!paramEventBody.msg_read_notify.has()) {
      return;
    }
    paramEventBody = (servtype.ReadNotify)paramEventBody.msg_read_notify.get();
    if ((paramEventBody.uint64_channel_id.has()) && (paramEventBody.uint64_guild_id.has()) && (paramEventBody.msg_read_cnt_msg_seq.has()) && (paramEventBody.msg_read_msg_seq.has()))
    {
      Object localObject = (IGuildMsgReadedService)this.d.getRuntimeService(IGuildMsgReadedService.class, "");
      IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = new IGuildMsgSeqTimeService.MsgSeqTimeItem(paramEventBody.msg_read_msg_seq.uint64_seq.get(), paramEventBody.msg_read_cnt_msg_seq.uint64_seq.get(), paramEventBody.msg_read_msg_seq.uint64_time.get(), paramEventBody.bytes_read_msg_meta.get().toByteArray());
      ((IGuildMsgReadedService)localObject).onMsgReadedNotify(String.valueOf(paramEventBody.uint64_guild_id.get()), String.valueOf(paramEventBody.uint64_channel_id.get()), localMsgSeqTimeItem);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handlerReadNotify: guildid:");
        ((StringBuilder)localObject).append(paramEventBody.uint64_guild_id.get());
        ((StringBuilder)localObject).append(" channelid:");
        ((StringBuilder)localObject).append(paramEventBody.uint64_channel_id.get());
        ((StringBuilder)localObject).append("msgSeqTimeItem:");
        ((StringBuilder)localObject).append(localMsgSeqTimeItem.toString());
        QLog.i("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    QLog.e("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 1, "handlerReadNotify: error:not has seq or time");
  }
  
  private void a(servtype.EventBody paramEventBody, common.MsgHead paramMsgHead)
  {
    if (paramEventBody.msg_update_msg.has())
    {
      if (!paramEventBody.msg_update_msg.uint64_event_type.has()) {
        return;
      }
      Object localObject1 = (servtype.UpdateMsg)paramEventBody.msg_update_msg.get();
      Object localObject2 = String.valueOf(paramMsgHead.routing_head.guild_id.get());
      String str = String.valueOf(paramMsgHead.routing_head.channel_id.get());
      long l = ((servtype.UpdateMsg)localObject1).uint64_msg_seq.get();
      paramMsgHead = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(10014).a(10014);
      paramEventBody = paramMsgHead.d(str, 10014, l);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handlerUpdateMsg: guildid:");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(", channelid:");
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append(", shmsgseq:");
      ((StringBuilder)localObject3).append(l);
      ((StringBuilder)localObject3).append(", findMr = ");
      if (paramEventBody != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject3).append(bool);
      ((StringBuilder)localObject3).append(", eventType: ");
      ((StringBuilder)localObject3).append(((servtype.UpdateMsg)localObject1).uint64_event_type.get());
      ((StringBuilder)localObject3).append(", eventVersion: ");
      ((StringBuilder)localObject3).append(((servtype.UpdateMsg)localObject1).uint64_event_version.get());
      QLog.i("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 2, ((StringBuilder)localObject3).toString());
      localObject3 = (IGuildEventFlowService)this.d.getRuntimeService(IGuildEventFlowService.class, "");
      common.Event localEvent = new common.Event();
      localEvent.type.set(((servtype.UpdateMsg)localObject1).uint64_event_type.get());
      localEvent.version.set(((servtype.UpdateMsg)localObject1).uint64_event_version.get());
      boolean bool = ((IGuildEventFlowService)localObject3).processEvent(paramEventBody, localEvent, (String)localObject2, str, l);
      if (paramEventBody != null)
      {
        localObject2 = new GuildMsgEventInfo.VersionItem();
        ((GuildMsgEventInfo.VersionItem)localObject2).a = ((servtype.UpdateMsg)localObject1).uint64_event_type.get();
        ((GuildMsgEventInfo.VersionItem)localObject2).c = ((servtype.UpdateMsg)localObject1).uint64_event_version.get();
        ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).saveEventToMsg(paramEventBody, (GuildMsgEventInfo.VersionItem)localObject2);
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("extStr", paramEventBody.extStr);
        paramMsgHead.a(paramEventBody.frienduin, 10014, paramEventBody.uniseq, (ContentValues)localObject1);
        if (bool)
        {
          paramMsgHead = a;
          if (paramMsgHead != null) {
            paramMsgHead.a(this.d, paramEventBody.frienduin, paramEventBody);
          }
        }
      }
    }
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
      QLog.d("BaseGuildMessageProcessor.GuildSystemMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 2))
    {
      List localList = (List)paramVarArgs[0];
      int i = ((Integer)paramVarArgs[1]).intValue();
      paramVarArgs = new ArrayList();
      b(localList, paramVarArgs);
      a(paramVarArgs, i);
      return;
    }
    a(getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildSystemMessageProcessor
 * JD-Core Version:    0.7.0.1
 */