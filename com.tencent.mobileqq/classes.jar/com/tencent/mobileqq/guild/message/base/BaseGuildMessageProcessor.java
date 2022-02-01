package com.tencent.mobileqq.guild.message.base;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.GuildMsgProxyUtils;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.callback.GuildMessageProcessorCallbackConfig;
import com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfo;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ChannelMsgNode.Builder;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode.Builder;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.MsgRouttingHead;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.QMessageProtoCodec;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.group_pro_proto.common.common.ContentHead;
import tencent.im.group_pro_proto.common.common.ExtInfo;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.common.common.MsgHead;
import tencent.im.group_pro_proto.common.common.MsgMeta;
import tencent.im.group_pro_proto.common.common.RoutingHead;
import tencent.im.group_pro_proto.user.msgTransData.ClientIdentity;
import tencent.im.group_pro_proto.user.msgTransData.TransData;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class BaseGuildMessageProcessor
  implements IGuildMessageProcessor
{
  protected AppInterface d;
  protected Comparator e = new BaseGuildMessageProcessor.1(this);
  
  public BaseGuildMessageProcessor(AppInterface paramAppInterface)
  {
    this.d = paramAppInterface;
  }
  
  private IGProClientIdentityInfo a(msgTransData.ClientIdentity paramClientIdentity)
  {
    return new BaseGuildMessageProcessor.3(this, paramClientIdentity);
  }
  
  private Boolean a(List<common.Msg> paramList, Boolean paramBoolean, StringBuilder paramStringBuilder, Set<String> paramSet, common.Msg paramMsg)
  {
    if (!paramMsg.head.has()) {
      return paramBoolean;
    }
    String str = a(paramMsg);
    if (paramSet.contains(str))
    {
      paramList = Boolean.valueOf(true);
      paramBoolean = paramList;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("< duplicatedMsg:");
        paramStringBuilder.append(str);
        paramStringBuilder.append(" >");
        return paramList;
      }
    }
    else
    {
      paramSet.add(str);
      paramList.add(paramMsg);
    }
    return paramBoolean;
  }
  
  private void a(MessageRecord paramMessageRecord, common.Msg paramMsg)
  {
    Object localObject = new msgTransData.TransData();
    if (!Proto2JsonUtil.a(paramMessageRecord.getExtInfoFromExtStr("MSG_GUILD_TRANS_DATA"), (MessageMicro)localObject)) {
      localObject = a(new msgTransData.ClientIdentity());
    } else {
      localObject = a(((msgTransData.TransData)localObject).rpt_client_identity);
    }
    String str = paramMessageRecord.getExtInfoFromExtStr("GUILD_ID");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getGuildInfo(str) == null) {
      return;
    }
    long l = paramMsg.ext_info.uint32_timestamp.get();
    ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).setMemberClientIdentityForMsg(str, paramMessageRecord.senderuin, (IGProClientIdentityInfo)localObject, 1000L * l);
  }
  
  private void a(IGPSService paramIGPSService, String paramString, int paramInt, common.Msg paramMsg)
  {
    paramIGPSService = paramIGPSService.getChannelInfo(paramString);
    if (paramIGPSService != null)
    {
      int i = paramIGPSService.getFinalMsgNotify();
      if (i != paramInt)
      {
        paramIGPSService = (common.ContentHead)paramMsg.head.content_head.get();
        paramMsg = new StringBuilder();
        paramMsg.append("syncGuildMsgPrintLog channelId: ");
        paramMsg.append(paramString);
        paramMsg.append(", currentNotifyType:");
        paramMsg.append(i);
        paramMsg.append(", newNotifyType: ");
        paramMsg.append(paramInt);
        paramMsg.append(", shmsgseq: ");
        if (paramIGPSService != null) {
          paramIGPSService = Long.valueOf(paramIGPSService.msg_seq.get());
        } else {
          paramIGPSService = "";
        }
        paramMsg.append(paramIGPSService);
        QLog.i("BaseGuildMessageProcessor", 1, paramMsg.toString());
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, List<im_msg_body.Elem> paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (im_msg_body.Elem)paramList.next();
      if ((!paramBoolean) && (((im_msg_body.Elem)localObject).extra_info.has()))
      {
        localObject = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject).extra_info.get();
        if (((im_msg_body.ExtraInfo)localObject).uint32_msg_tail_id.has())
        {
          int i = ((im_msg_body.ExtraInfo)localObject).uint32_msg_tail_id.get();
          if (i > 0)
          {
            localObject = ((IMessageRecordFactoryService)QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1002);
            if (localObject != null)
            {
              String str = Integer.toString(i);
              SafeMsg.SafeMoreInfo localSafeMoreInfo = new SafeMsg.SafeMoreInfo();
              localSafeMoreInfo.strMsgTxt.set(str);
              ((MessageRecord)localObject).init(paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.senderuin, str, paramMessageRecord.time, -1002, paramMessageRecord.istroop, paramMessageRecord.msgseq);
              ((MessageRecord)localObject).isread = true;
              ((MessageRecord)localObject).shmsgseq = paramMessageRecord.shmsgseq;
              ((MessageRecord)localObject).msgData = localSafeMoreInfo.toByteArray();
              paramArrayList.add(localObject);
            }
          }
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, common.Msg paramMsg, long paramLong1, String paramString, MessageInfo paramMessageInfo1, MessageInfo paramMessageInfo2, im_msg_body.RichText paramRichText, long paramLong2)
  {
    common.ContentHead localContentHead = (common.ContentHead)paramMsg.head.content_head.get();
    common.RoutingHead localRoutingHead = (common.RoutingHead)paramMsg.head.routing_head.get();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      localMessageRecord.msgUid = paramLong1;
      localMessageRecord.time = localContentHead.msg_time.get();
      localMessageRecord.msgseq = localContentHead.msg_time.get();
      localMessageRecord.shmsgseq = localContentHead.msg_seq.get();
      localMessageRecord.selfuin = paramString;
      localMessageRecord.istroop = 10014;
      localMessageRecord.senderuin = String.valueOf(localRoutingHead.from_tinyid.get());
      localMessageRecord.frienduin = String.valueOf(localRoutingHead.channel_id.get());
      localMessageRecord.longMsgId = 0;
      localMessageRecord.longMsgCount = 0;
      localMessageRecord.longMsgIndex = 0;
      localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_CNT_NAME", String.valueOf(localContentHead.cnt_seq.get()));
      localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_TYPE", String.valueOf(localContentHead.msg_type.get()));
      localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_SUB_TYPE", String.valueOf(localContentHead.sub_type.get()));
      localMessageRecord.saveExtInfoToExtStr("MSG_GUILD_CODE", String.valueOf(localRoutingHead.guild_code.get()));
      IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
      localIGuildMessageUtilsApi.saveGuildIdToMR(localMessageRecord, String.valueOf(localRoutingHead.guild_id.get()));
      Object localObject2 = localContentHead.msg_meta.get().toByteArray();
      localIGuildMessageUtilsApi.saveMsgMetaToMr(localMessageRecord, (byte[])localObject2);
      Object localObject1 = new common.MsgMeta();
      try
      {
        ((common.MsgMeta)localObject1).mergeFrom((byte[])localObject2);
        localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_AT_ALL_SEQ", String.valueOf(((common.MsgMeta)localObject1).at_all_seq.get()));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("msg_meta has() = ");
        ((StringBuilder)localObject2).append(localContentHead.msg_meta.has());
        ((StringBuilder)localObject2).append(", atAllSeq: ");
        ((StringBuilder)localObject2).append(((common.MsgMeta)localObject1).at_all_seq.get());
        QLog.i("BaseGuildMessageProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      catch (Exception localException)
      {
        label404:
        int i;
        long l;
        String str;
        break label404;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("msg_meta merge exception! decodeMsg, MR: ");
      ((StringBuilder)localObject1).append(localMessageRecord.toString());
      ((StringBuilder)localObject1).append(", extstr: ");
      ((StringBuilder)localObject1).append(localMessageRecord.extStr);
      QLog.e("BaseGuildMessageProcessor", 2, ((StringBuilder)localObject1).toString());
      if (paramMsg.ext_info.has())
      {
        if (paramMsg.ext_info.visibility.has())
        {
          localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_VISIBLE_FLAG", String.valueOf(paramMsg.ext_info.visibility.get()));
          if (!a(paramMsg.ext_info.visibility.get())) {
            localMessageRecord.msgtype = -2006;
          }
        }
        if (paramMsg.ext_info.from_nick.has())
        {
          localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_FROM_NICK", paramMsg.ext_info.from_nick.get().toStringUtf8());
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("from_nick is empty!! decodeMsg, MR: ");
          ((StringBuilder)localObject1).append(localMessageRecord.toString());
          ((StringBuilder)localObject1).append(", extstr: ");
          ((StringBuilder)localObject1).append(localMessageRecord.extStr);
          QLog.e("BaseGuildMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramMsg.ext_info.channel_name.has()) {
          localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_CHANNEL_NAME", paramMsg.ext_info.channel_name.get().toStringUtf8());
        }
        if (paramMsg.ext_info.guild_name.has()) {
          localMessageRecord.saveExtInfoToExtStr("MSG_GUILD_NAME", paramMsg.ext_info.guild_name.get().toStringUtf8());
        }
        if (paramMsg.ext_info.notify_type.has()) {
          localMessageRecord.saveExtInfoToExtStr("MSG_GUILD_NOTIFY_TYPE", String.valueOf(paramMsg.ext_info.notify_type.get()));
        }
        if (paramMsg.ext_info.name_type.has()) {
          localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_NAME_TYPE", String.valueOf(paramMsg.ext_info.name_type.get()));
        }
        if (paramMsg.ext_info.offline_flag.has())
        {
          if (paramMsg.ext_info.offline_flag.get() == 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            localObject1 = "1";
          } else {
            localObject1 = "0";
          }
          localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_LOCAL_ONLY", (String)localObject1);
        }
        if (paramMsg.ext_info.bytes_member_name.has())
        {
          localObject1 = paramMsg.ext_info.bytes_member_name.get().toStringUtf8();
          localMessageRecord.saveExtInfoToExtStr("MSG_GUILD_MEMBER_NAME", paramMsg.ext_info.bytes_member_name.get().toStringUtf8());
        }
        else
        {
          localObject1 = "";
        }
        if (paramMsg.ext_info.uint32_timestamp.has())
        {
          l = paramMsg.ext_info.uint32_timestamp.get();
          localMessageRecord.saveExtInfoToExtStr("MSG_GUILD_MEMBER_NAME_SYNC_TIME", String.valueOf(l));
          localObject2 = localMessageRecord.getExtInfoFromExtStr("GUILD_MSG_FROM_NICK");
          str = localMessageRecord.getExtInfoFromExtStr("GUILD_ID");
          ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).setMemberNameForMsg(str, localMessageRecord.senderuin, (String)localObject2, (String)localObject1, 1000L * l);
        }
        a(localMessageRecord, paramMsg);
      }
      localObject1 = paramMsg.ext_info.events.get();
      if (paramLong2 > 0L) {
        l = paramLong2;
      } else {
        l = localMessageRecord.time;
      }
      localIGuildMessageUtilsApi.saveEventFlowToMsg(localMessageRecord, new GuildMsgEventInfo((List)localObject1, l));
      ((IGuildEventFlowService)this.d.getRuntimeService(IGuildEventFlowService.class, "")).processEvents(localMessageRecord, paramMsg.ext_info.events.get(), String.valueOf(localIGuildMessageUtilsApi.getGuildIdFromMR(localMessageRecord)), localMessageRecord.frienduin, localMessageRecord.shmsgseq);
      if (localRoutingHead.from_appid.has()) {
        localMessageRecord.saveExtInfoToExtStr("GUILD_MSG_FROME_APPID", String.valueOf(localRoutingHead.from_appid.get()));
      }
      if (localMessageRecord.msgtype == -1035) {
        ((ChatMessage)localMessageRecord).parse();
      }
      if (paramRichText != null)
      {
        GuildMessageProcessorCallbackConfig.a();
        GuildMessageProcessorCallbackConfig.a(this.d, paramMessageInfo1, paramMessageInfo2, localMessageRecord);
        a(paramArrayList, paramRichText.elems.get(), localMessageRecord);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("processPush : decodeMsg, MR: ");
        ((StringBuilder)localObject1).append(localMessageRecord.toString());
        ((StringBuilder)localObject1).append(", extstr: ");
        ((StringBuilder)localObject1).append(localMessageRecord.extStr);
        QLog.d("BaseGuildMessageProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processPush : decodeMsg, shmsgseq: ");
      ((StringBuilder)localObject1).append(localMessageRecord.shmsgseq);
      QLog.i("BaseGuildMessageProcessor", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt != 1) && (paramInt != 2);
  }
  
  private static boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject = ((IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localIGuildMessageUtilsApi.isMsgVisible(paramMessageRecord))
        {
          if (GuildMsgProxyUtils.a(paramAppRuntime, localMessageRecord, paramMessageRecord, false, paramBoolean))
          {
            if (QLog.isColorLevel())
            {
              paramAppRuntime = new StringBuilder();
              paramAppRuntime.append("isDuplicatedMsg = true. visible msg. MR: ");
              paramAppRuntime.append(paramMessageRecord.toString());
              QLog.d("BaseGuildMessageProcessor", 2, paramAppRuntime.toString());
            }
            return true;
          }
        }
        else if (paramMessageRecord.shmsgseq == localMessageRecord.shmsgseq)
        {
          if (QLog.isColorLevel())
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("isDuplicatedMsg = true. invisible msg. MR: ");
            paramAppRuntime.append(paramMessageRecord.toString());
            QLog.d("BaseGuildMessageProcessor", 2, paramAppRuntime.toString());
          }
          return true;
        }
      }
    }
    if (((MessageCache)paramAppRuntime.getMsgCache()).h(paramMessageRecord))
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("isDuplicatedMsg = true. inRevokeNotifyCache. MR: ");
        paramAppRuntime.append(paramMessageRecord.toString());
        QLog.d("BaseGuildMessageProcessor", 2, paramAppRuntime.toString());
      }
      return true;
    }
    return false;
  }
  
  private void b(common.Msg paramMsg)
  {
    Object localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.body.get()).rich_text.get()).elems.get().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
      if (((im_msg_body.Elem)localObject2).common_elem.has())
      {
        localObject1 = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject2).common_elem.get();
        break label76;
      }
    }
    localObject1 = null;
    label76:
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (IGPSService)this.d.getRuntimeService(IGPSService.class, "");
    if ((paramMsg.head.has()) && (paramMsg.head.content_head.has()))
    {
      common.ContentHead localContentHead = (common.ContentHead)paramMsg.head.content_head.get();
      paramMsg = (common.RoutingHead)paramMsg.head.routing_head.get();
      paramMsg = new MsgRouttingHead(String.valueOf(paramMsg.guild_id.get()), String.valueOf(paramMsg.channel_id.get()), "", String.valueOf(paramMsg.from_tinyid.get()), String.valueOf(paramMsg.guild_code.get()));
      localObject1 = ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.get().toByteArray();
      ((IGPSService)localObject2).onSrvPushMsg((int)localContentHead.msg_type.get(), (int)localContentHead.sub_type.get(), paramMsg, (byte[])localObject1);
    }
  }
  
  private MessageRecord c(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if (localMessageRecord.msgtype != -2006) {
          return localMessageRecord;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  protected Pair<Boolean, StringBuilder> a(List<common.Msg> paramList1, List<common.Msg> paramList2)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if ((paramList1 != null) && (paramList1.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramList1.iterator();
      for (paramList1 = localBoolean; localIterator.hasNext(); paramList1 = a(paramList2, paramList1, localStringBuilder, localHashSet, (common.Msg)localIterator.next())) {}
      return new Pair(paramList1, localStringBuilder);
    }
    return new Pair(localBoolean, null);
  }
  
  protected MessageRecord a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = ((IMessageFacade)this.d.getRuntimeService(IMessageFacade.class, "")).getMsgList(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    Object localObject2 = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (MessageRecord)((Iterator)localObject2).next();
        if (GuildMsgProxyUtils.a(this.d, (MessageRecord)localObject1, paramMessageRecord, false, true))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("queryDuplicatedMsg = true. visible msg. MR: ");
            ((StringBuilder)localObject2).append(paramMessageRecord.toString());
            QLog.d("BaseGuildMessageProcessor", 2, ((StringBuilder)localObject2).toString());
          }
          return localObject1;
        }
      }
    }
    return null;
  }
  
  protected String a(common.Msg paramMsg)
  {
    return String.valueOf(paramMsg.hashCode());
  }
  
  protected ArrayList<MessageRecord> a(common.Msg paramMsg, String paramString, MessageInfo paramMessageInfo, long paramLong)
  {
    localArrayList = new ArrayList();
    if ((paramMsg.head.has()) && (paramMsg.head.content_head.has()))
    {
      if (!paramMsg.head.routing_head.has()) {
        return null;
      }
      localObject = (common.ContentHead)paramMsg.head.content_head.get();
      localRoutingHead = (common.RoutingHead)paramMsg.head.routing_head.get();
      l = 0L;
      localMessageInfo = new MessageInfo();
      if ((paramMsg.body.has()) && (paramMsg.body.rich_text.has()))
      {
        localRichText = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.body.get()).rich_text.get();
        if (localRichText.attr.has()) {
          l = MessageUtils.a(((im_msg_body.Attr)localRichText.attr.get()).random.get());
        }
        localMessageInfo.a = String.valueOf(localRoutingHead.channel_id.get());
        localMessageInfo.b = 10014;
        localMsg = new msg_comm.Msg();
        localMsgHead = new msg_comm.MsgHead();
        String str = ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if ((str == null) || (!String.valueOf(localRoutingHead.from_tinyid.get()).equals(str))) {}
      }
    }
    try
    {
      localMsgHead.from_uin.set(Long.parseLong(paramString));
    }
    catch (Exception localException3)
    {
      try
      {
        localMsgHead.to_uin.set(Long.parseLong(paramString));
        localMsgHead.msg_type.set((int)((common.ContentHead)localObject).msg_type.get());
        localMsgHead.msg_seq.set((int)((common.ContentHead)localObject).msg_seq.get());
        localMsgHead.msg_time.set((int)((common.ContentHead)localObject).msg_time.get());
        localMsgHead.msg_uid.set(((common.ContentHead)localObject).random.get());
        if ((!paramMsg.ext_info.has()) || (!paramMsg.ext_info.from_nick.has())) {
          break label407;
        }
        localMsgHead.from_nick.set(paramMsg.ext_info.from_nick.get().toStringUtf8());
        localMsg.msg_head.set(localMsgHead);
        localMsg.msg_body.set(paramMsg.body.get());
      }
      catch (Exception localException3)
      {
        try
        {
          for (;;)
          {
            Long.parseLong(paramString);
            localObject = new DecodeProtoPkgContext(0L, localRoutingHead.channel_id.get(), false, false, false, false);
            ((DecodeProtoPkgContext)localObject).p = 10014;
            ((DecodeProtoPkgContext)localObject).v = localRoutingHead.guild_id.get();
            ((DecodeProtoPkgContext)localObject).b = localRoutingHead.from_tinyid.get();
            QMessageProtoCodec.a(this.d, localArrayList, localMsg, false, false, localMessageInfo, null, (DecodeProtoPkgContext)localObject);
            break label544;
            localArrayList.add(new MessageRecord());
            l = MessageUtils.a((int)((common.ContentHead)localObject).random.get());
            localRichText = null;
            a(localArrayList, paramMsg, l, paramString, paramMessageInfo, localMessageInfo, localRichText, paramLong);
            return localArrayList;
            return null;
            localException2 = localException2;
          }
          localException3 = localException3;
        }
        catch (Exception localException1)
        {
          break label437;
        }
      }
    }
    localMsgHead.from_uin.set(localRoutingHead.from_tinyid.get());
  }
  
  protected void a(String paramString) {}
  
  protected void a(ArrayList<MessageRecord> paramArrayList)
  {
    String str = ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramArrayList.next();
      if ((localMessageRecord1.senderuin != null) && (localMessageRecord1.senderuin.equalsIgnoreCase(str)) && (!localIGuildMessageUtilsApi.isSysMsg(localMessageRecord1)))
      {
        MessageRecord localMessageRecord2 = a(localMessageRecord1);
        if (localMessageRecord2 != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkAndHandleDuplicatedSelfSendMsg, messageRecord = ");
            localStringBuilder.append(localMessageRecord1.getBaseInfoString());
            localStringBuilder.append(", findMr = ");
            localStringBuilder.append(localMessageRecord2.getBaseInfoString());
            QLog.d("BaseGuildMessageProcessor", 2, localStringBuilder.toString());
          }
          ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).handleSelfSendMsg(this.d, localMessageRecord1, localMessageRecord2, 1);
        }
      }
    }
  }
  
  protected void a(ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord)
  {
    Object localObject = ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase((String)localObject)) && (!localIGuildMessageUtilsApi.isSysMsg(paramMessageRecord)))
    {
      if ((this.d instanceof BaseQQAppInterface)) {
        localObject = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(10014).a(10014).d(paramMessageRecord.frienduin, 10014, paramMessageRecord);
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).handleSelfSendMsg(this.d, paramMessageRecord, (MessageRecord)localObject, 2);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseGuildMessageProcessor", 2, "checkAndHandleSelfSendMessage : findMr is NULL! set Flag: SEND_FROM_OTHER_TERMINAL");
      }
      paramMessageRecord.isread = true;
      paramMessageRecord.issend = 2;
      ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).setMsgReaded(this.d, paramMessageRecord);
    }
    paramArrayList.add(paramMessageRecord);
  }
  
  protected void a(ArrayList<MessageRecord> paramArrayList, List<im_msg_body.Elem> paramList, MessageRecord paramMessageRecord)
  {
    Object localObject = ((IGPSService)this.d.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    if ((paramList != null) && (localObject != null) && (!TextUtils.equals((CharSequence)localObject, paramMessageRecord.senderuin)))
    {
      boolean bool = false;
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((im_msg_body.Elem)((Iterator)localObject).next()).anon_group_msg.has()) {
          bool = true;
        }
      }
      a(paramArrayList, paramList, paramMessageRecord, bool);
    }
  }
  
  protected void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 1) {
        return;
      }
      IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if ((localIGuildMessageUtilsApi.isMsgVisible(localMessageRecord)) && (MessageUtils.a(localMessageRecord)))
        {
          int j;
          if (((i > 0) && (((MessageRecord)paramList.get(i - 1)).shmsgseq == localMessageRecord.shmsgseq)) || ((i < paramList.size() - 1) && (((MessageRecord)paramList.get(i + 1)).shmsgseq == localMessageRecord.shmsgseq))) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("visibleBlankMsgFilter : removing ");
              localStringBuilder.append(localMessageRecord.toString());
              QLog.d("BaseGuildMessageProcessor", 2, localStringBuilder.toString());
            }
            localArrayList.add(localMessageRecord);
          }
        }
        i += 1;
      }
      paramList.removeAll(localArrayList);
    }
  }
  
  protected void a(List<common.Msg> paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      ((IGuildMsgFactory)this.d.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(3).a(new Object[] { paramList, Integer.valueOf(paramInt) });
    }
  }
  
  protected void a(List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (!a(this.d, localMessageRecord, paramBoolean)) {
        paramArrayList1.add(localMessageRecord);
      } else {
        paramArrayList2.add(localMessageRecord);
      }
    }
  }
  
  protected void a(List<common.Msg> paramList1, List<common.Msg> paramList2, List<common.Msg> paramList3, boolean paramBoolean)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      Object localObject = (common.Msg)paramList1.next();
      if ((((common.Msg)localObject).head.has()) && (((common.Msg)localObject).head.content_head.has()))
      {
        common.ContentHead localContentHead = (common.ContentHead)((common.Msg)localObject).head.content_head.get();
        if (localContentHead.msg_type.get() == 3841L)
        {
          if (paramBoolean) {
            b((common.Msg)localObject);
          }
          if ((localContentHead.sub_type.get() != 1L) && (localContentHead.sub_type.get() != 14L) && (localContentHead.sub_type.get() != 15L))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("filterSystemMsg, sub_type = ");
            ((StringBuilder)localObject).append(localContentHead.sub_type);
            ((StringBuilder)localObject).append(", msg_seq = ");
            ((StringBuilder)localObject).append(localContentHead.msg_seq);
            ((StringBuilder)localObject).append(", msg_time = ");
            ((StringBuilder)localObject).append(localContentHead.msg_time);
            QLog.d("BaseGuildMessageProcessor", 2, ((StringBuilder)localObject).toString());
          }
          else
          {
            paramList2.add(localObject);
          }
        }
        else
        {
          paramList3.add(localObject);
        }
      }
    }
  }
  
  protected void a(List<common.Msg> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      IGPSService localIGPSService = (IGPSService)this.d.getRuntimeService(IGPSService.class, "");
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        common.Msg localMsg = (common.Msg)localIterator.next();
        if (localMsg.head.routing_head.guild_id.has()) {
          paramList = String.valueOf(localMsg.head.routing_head.guild_id.get());
        } else {
          paramList = "";
        }
        String str1;
        if (localMsg.head.routing_head.channel_id.has()) {
          str1 = String.valueOf(localMsg.head.routing_head.channel_id.get());
        } else {
          str1 = "";
        }
        String str2;
        if (localMsg.ext_info.channel_name.has()) {
          str2 = localMsg.ext_info.channel_name.get().toStringUtf8();
        } else {
          str2 = "";
        }
        String str3;
        if (localMsg.ext_info.guild_name.has()) {
          str3 = localMsg.ext_info.guild_name.get().toStringUtf8();
        } else {
          str3 = "";
        }
        Object localObject;
        if (localMsg.ext_info.from_nick.has()) {
          localObject = localMsg.ext_info.from_nick.get().toStringUtf8();
        } else {
          localObject = "";
        }
        String str4;
        if (localMsg.head.routing_head.from_tinyid.has()) {
          str4 = String.valueOf(localMsg.head.routing_head.from_tinyid.get());
        } else {
          str4 = "";
        }
        int i = -1000;
        if (localMsg.ext_info.notify_type.has()) {
          i = localMsg.ext_info.notify_type.get();
        }
        ArrayList localArrayList2 = new ArrayList();
        if (paramBoolean)
        {
          a(localIGPSService, str1, i, localMsg);
          localArrayList2.add(new ChannelMsgNode.Builder().a(str1).b(str2).d((String)localObject).b(i).c(str4).a());
          localArrayList1.add(new GuildMsgNode.Builder().a(paramList).b(str3).a(localArrayList2).a());
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("syncGuildMsg. onlinePush: GuildMsgNode id:");
            ((StringBuilder)localObject).append(paramList);
            ((StringBuilder)localObject).append(" guildName:");
            ((StringBuilder)localObject).append(str3);
            ((StringBuilder)localObject).append(", channelId: ");
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append(", channelName:");
            ((StringBuilder)localObject).append(str2);
            ((StringBuilder)localObject).append(", finalNotifyType: ");
            ((StringBuilder)localObject).append(i);
            QLog.i("BaseGuildMessageProcessor", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localArrayList2.add(new ChannelMsgNode.Builder().a(str1).d((String)localObject).a());
          localArrayList1.add(new GuildMsgNode.Builder().a(paramList).a(localArrayList2).a());
          if (QLog.isColorLevel()) {
            QLog.i("BaseGuildMessageProcessor", 2, "syncGuildMsg. roam msg");
          }
        }
      }
      try
      {
        localIGPSService.onGuildMsg(localArrayList1);
        return;
      }
      catch (Exception paramList)
      {
        QLog.e("BaseGuildMessageProcessor", 2, paramList.getMessage());
      }
    }
  }
  
  public void a(Object... paramVarArgs) {}
  
  protected void b(MessageRecord paramMessageRecord)
  {
    IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = ((IGuildMsgSeqTimeService)this.d.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(paramMessageRecord.frienduin);
    if (localMsgSeqTimeItem.b > paramMessageRecord.shmsgseq)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkMsgReaded. cntSeq: ");
        localStringBuilder.append(localMsgSeqTimeItem.b);
        localStringBuilder.append(", shmsgseq: ");
        localStringBuilder.append(paramMessageRecord.shmsgseq);
        QLog.d("BaseGuildMessageProcessor", 2, localStringBuilder.toString());
      }
      paramMessageRecord.isread = true;
    }
  }
  
  protected void b(List<MessageRecord> paramList)
  {
    paramList = c(paramList);
    if (paramList != null) {
      ((IMessageFacade)this.d.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.BaseGuildMessageProcessor
 * JD-Core Version:    0.7.0.1
 */