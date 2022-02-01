package com.tencent.mobileqq.guild.message.api.impl;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.message.GuildMessageCache;
import com.tencent.mobileqq.guild.message.GuildMessageObserver;
import com.tencent.mobileqq.guild.message.GuildOnlineMessageProcessor;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler.SendTextMsgParams;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.guild.message.callback.GuildSendMessageCallbackConfig;
import com.tencent.mobileqq.guild.message.pbsendhandler.BeforeSendGuildMsgPbHandlerImpl;
import com.tencent.mobileqq.guild.message.pbsendhandler.IBeforeSendGuildMsgPbHandler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.MsgSendingInfo;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import tencent.im.group_pro_proto.common.common.ContentHead;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.common.common.MsgHead;
import tencent.im.group_pro_proto.common.common.MsgMeta;
import tencent.im.group_pro_proto.common.common.RoutingHead;
import tencent.im.group_pro_proto.oidb0xf62.Oidb0xf62.ReqBody;
import tencent.im.group_pro_proto.oidb0xf62.Oidb0xf62.RspBody;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class GuildSendMessageHandler
  extends BaseGuildMessageHandler
  implements IGuildSendMessageHandler
{
  private static int a = 480000;
  private static int b = 3;
  private List<MessageRecord> c = new ArrayList();
  private AppInterface d;
  
  public GuildSendMessageHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.d = paramAppInterface;
    AppSetting.m = paramAppInterface.getApp().getSharedPreferences("mobileQQ", 0).getBoolean(AppSetting.n, true);
  }
  
  private static String a(String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    int i = 0;
    int j = 0;
    while ((i < paramString.length()) && (paramString.codePointAt(i) == 0))
    {
      j += 1;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow, at info starts with char 0");
      }
      i += 1;
    }
    Object localObject = paramString;
    if (j > 0)
    {
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject = (AtTroopMemberInfo)paramArrayList.next();
          ((AtTroopMemberInfo)localObject).startPos = ((short)(((AtTroopMemberInfo)localObject).startPos - j));
          if (((AtTroopMemberInfo)localObject).startPos < 0)
          {
            if (QLog.isColorLevel()) {
              QLog.e("SendMsgBtn", 2, " createTextMessageToshow error, at info starts with char 0");
            }
            return null;
          }
        }
      }
      localObject = paramString.substring(j);
    }
    return localObject;
  }
  
  static Oidb0xf62.ReqBody a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject2 = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().B().iterator();
    Oidb0xf62.ReqBody localReqBody = null;
    Object localObject1 = null;
    for (int i = 0; ((Iterator)localObject2).hasNext(); i = ((Integer)localObject3[1]).intValue())
    {
      localObject3 = ((IRichTextAndMsgViaProvider)((Iterator)localObject2).next()).a(paramAppInterface, paramMessageRecord, (im_msg_body.RichText)localObject1, i);
      localObject1 = (im_msg_body.RichText)localObject3[0];
    }
    if (localObject1 == null) {
      return null;
    }
    Object localObject3 = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    long l2 = ((IGuildMessageUtilsApi)localObject3).getGuildIdFromMR(paramMessageRecord);
    try
    {
      localObject2 = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
      long l1;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(paramMessageRecord.senderuin))) {
        l1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
      } else {
        l1 = Long.parseLong(paramMessageRecord.senderuin);
      }
      long l3 = Long.parseLong(paramMessageRecord.frienduin);
      localObject2 = localReqBody;
      if (l2 != 0L)
      {
        localObject2 = localReqBody;
        if (l3 != 0L)
        {
          if (l1 == 0L) {
            return null;
          }
          localReqBody = new Oidb0xf62.ReqBody();
          localObject2 = new common.Msg();
          common.MsgHead localMsgHead = new common.MsgHead();
          im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
          Object localObject4 = new common.RoutingHead();
          ((common.RoutingHead)localObject4).guild_id.set(l2);
          ((common.RoutingHead)localObject4).channel_id.set(l3);
          ((common.RoutingHead)localObject4).from_uin.set(l1);
          localMsgHead.routing_head.set((MessageMicro)localObject4);
          localObject4 = new common.ContentHead();
          i = ((IGuildMessageUtilsApi)localObject3).getMsgRandomByMsgUid_Hummer(paramMessageRecord.msgUid);
          ((common.ContentHead)localObject4).msg_type.set(3840L);
          ((common.ContentHead)localObject4).random.set(i);
          localMsgHead.content_head.set((MessageMicro)localObject4);
          localMsgBody.rich_text.set((MessageMicro)localObject1);
          ((common.Msg)localObject2).body.set(localMsgBody);
          ((common.Msg)localObject2).head.set(localMsgHead);
          localReqBody.msg.set((MessageMicro)localObject2);
          localObject1 = BeforeSendGuildMsgPbHandlerImpl.a().iterator();
          for (;;)
          {
            localObject2 = localReqBody;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            ((IBeforeSendGuildMsgPbHandler)((Iterator)localObject1).next()).a(paramAppInterface, paramMessageRecord, localReqBody);
          }
        }
      }
      return localObject2;
    }
    catch (Exception paramAppInterface) {}
    return null;
  }
  
  static void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, ToServiceMsg paramToServiceMsg, long paramLong, int paramInt, boolean paramBoolean)
  {
    paramAppInterface = a(paramAppInterface, paramMessageRecord);
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildSendMessageHandler", 2, new Object[] { "fillSendMsgRequest : the reqBody is null!", paramMessageRecord.getBaseInfoString() });
      }
      return;
    }
    paramToServiceMsg.putWupBuffer(paramAppInterface.toByteArray());
    paramToServiceMsg.setTimeout(paramLong);
    long l2 = System.currentTimeMillis();
    long l1;
    if (paramMessageRecord.msg == null) {
      l1 = 0L;
    } else {
      l1 = paramMessageRecord.msg.getBytes().length;
    }
    long l3 = paramMessageRecord.msgUid;
    int i = (short)(int)paramMessageRecord.msgseq;
    int j = MessageUtils.a(l3);
    QLog.i("GuildSendMessageHandler", 1, String.format(Locale.getDefault(), "createSendMsgRequest, uint32Seq:%d, random:%d, %s", new Object[] { Integer.valueOf(0xFFFF & i), Integer.valueOf(j), paramMessageRecord.getBaseInfoString() }));
    a(paramMessageRecord, paramToServiceMsg);
    paramToServiceMsg.extraData.putString("uin", paramMessageRecord.frienduin);
    paramToServiceMsg.extraData.putLong("msgsize", l1);
    paramToServiceMsg.extraData.putLong("uniseq", paramMessageRecord.uniseq);
    paramToServiceMsg.extraData.putLong("timeOut", paramLong);
    paramToServiceMsg.extraData.putLong("msgSeq", paramMessageRecord.msgseq);
    paramToServiceMsg.extraData.putLong("startTime", l2);
    paramToServiceMsg.extraData.putInt("retryIndex", paramInt);
    paramToServiceMsg.extraData.putInt("uintype", paramMessageRecord.istroop);
    paramToServiceMsg.extraData.putInt("msgtype", paramMessageRecord.msgtype);
    paramToServiceMsg.extraData.putInt("send_msg_req_size", paramToServiceMsg.getWupBuffer().length);
    paramToServiceMsg.addAttribute("msgtype", Integer.valueOf(paramMessageRecord.msgtype));
    paramToServiceMsg.addAttribute("msgSeq", Long.valueOf(paramMessageRecord.msgseq));
    paramToServiceMsg.addAttribute("resend_by_user", Boolean.valueOf(paramBoolean));
    paramToServiceMsg.addAttribute("retryIndex", Integer.valueOf(paramInt));
    paramAppInterface = paramMessageRecord.frienduin;
    String str = "";
    if (paramAppInterface == null) {
      paramAppInterface = "";
    } else {
      paramAppInterface = paramMessageRecord.frienduin;
    }
    paramToServiceMsg.addAttribute("uin", paramAppInterface);
    if (paramMessageRecord.senderuin == null) {
      paramAppInterface = str;
    } else {
      paramAppInterface = paramMessageRecord.senderuin;
    }
    paramToServiceMsg.addAttribute("fromUin", paramAppInterface);
    paramToServiceMsg.addAttribute("normal_msg", Boolean.valueOf(true));
  }
  
  private void a(MessageRecord paramMessageRecord, long paramLong, int paramInt, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    paramBusinessObserver = createToServiceMsg("MsgProxy.SendMsg", paramBusinessObserver);
    a(this.d, paramMessageRecord, paramBusinessObserver, paramLong, paramInt, paramBoolean);
    paramBusinessObserver.setNeedRemindSlowNetwork(true);
    sendPbReq(paramBusinessObserver);
  }
  
  private static void a(MessageRecord paramMessageRecord, ToServiceMsg paramToServiceMsg)
  {
    if (MsgProxyUtils.i(paramMessageRecord.msgtype)) {
      paramToServiceMsg.extraData.putBoolean("RichNotify", true);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(paramMessageRecord, null);
        return;
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("GuildSendMessageHandler", 1, "addAndSendMessage:", paramMessageRecord);
        return;
      }
    }
    ThreadManager.post(new GuildSendMessageHandler.1(this, paramMessageRecord), 10, null, false);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildSendMessageHandler", 2, "handleSendRichTextMessageResp enter");
    }
    recordSendMessageRetryResult(paramToServiceMsg, paramFromServiceMsg);
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    String str = paramToServiceMsg.extraData.getString("uin");
    boolean bool1;
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      paramToServiceMsg = getHandlerFromQueue(l2);
      if (paramFromServiceMsg.getResultCode() == 2901) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((480000L != l3) && ((paramToServiceMsg == null) || (!paramToServiceMsg.b()))) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      a(str, bool1, bool2, l2, l1, 0, paramFromServiceMsg.getResultCode());
      return;
    }
    Object localObject = new Oidb0xf62.RspBody();
    int i;
    try
    {
      Oidb0xf62.RspBody localRspBody = (Oidb0xf62.RspBody)((Oidb0xf62.RspBody)localObject).mergeFrom((byte[])paramObject);
      i = 0;
      paramObject = localRspBody;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleSendRichTextMessageResp:");
        if (paramObject == null) {
          paramObject = "null";
        } else {
          paramObject = Arrays.toString((byte[])paramObject);
        }
        localStringBuilder.append(paramObject);
        QLog.e("GuildSendMessageHandler", 2, localStringBuilder.toString(), localException);
      }
      paramObject = localObject;
      i = 65535;
    }
    if (paramObject.result.has()) {
      i = paramObject.result.get();
    }
    paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
    int j;
    if (i == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSendRichTextMessageResp, FAILED! result: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", errType: ");
      ((StringBuilder)localObject).append(paramObject.err_type.get());
      ((StringBuilder)localObject).append(", errmsg: ");
      if (paramObject.errmsg.has()) {
        paramObject = paramObject.errmsg.get().toStringUtf8();
      } else {
        paramObject = "";
      }
      ((StringBuilder)localObject).append(paramObject);
      QLog.e("GuildSendMessageHandler", 1, ((StringBuilder)localObject).toString());
      a(str, false, true, l2, l1, i, 0);
    }
    else
    {
      a(paramToServiceMsg, str, l2, l1, paramObject);
      a(paramObject);
    }
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a(paramToServiceMsg, paramFromServiceMsg, i, l1, bool1);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleSendRichTextMessageResp: ---result:");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(" ssoseq:");
      paramToServiceMsg.append(paramFromServiceMsg.getRequestSsoSeq());
      paramToServiceMsg.append(" appseq:");
      paramToServiceMsg.append(paramFromServiceMsg.getAppSeq());
      paramToServiceMsg.append(",SendTroopMessageResp : channelId:");
      paramToServiceMsg.append(str);
      paramToServiceMsg.append(",uniseq:");
      paramToServiceMsg.append(l1);
      paramToServiceMsg.append(",msgSeq:");
      paramToServiceMsg.append(l2);
      QLog.d("GuildSendMessageHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString, long paramLong1, long paramLong2, Oidb0xf62.RspBody paramRspBody)
  {
    Object localObject = (MessageCache)this.d.getMsgCache();
    if (localObject != null)
    {
      localObject = ((MessageCache)localObject).b(paramString, 10014, paramLong2);
      paramToServiceMsg.extraData.putBoolean("isJuhuaExist", MessageCache.a((MessageCache.MsgSendingInfo)localObject));
    }
    if ((paramRspBody.head.has()) && (((common.MsgHead)paramRspBody.head.get()).content_head.has()))
    {
      paramToServiceMsg = (common.ContentHead)((common.MsgHead)paramRspBody.head.get()).content_head.get();
      paramRspBody = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(10014).a(10014);
      if (!paramToServiceMsg.msg_seq.has()) {
        paramRspBody.a(paramString, 10014, paramLong2, 0, 0);
      }
    }
    a(paramString, paramLong2, paramLong1);
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleSendMsgFailure, channelId: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", uniseq: ");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(", msgseq: ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", result: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", respCode: ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.e("GuildSendMessageHandler", 1, ((StringBuilder)localObject).toString());
    localObject = getHandlerFromQueue(paramLong1);
    if ((paramBoolean1) && (retrySendMessage((SendMessageHandler)localObject, "server")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildSendMessageHandler", 2, "handleSendMsgFailure, retry");
      }
      return;
    }
    removeSendMessageHandler(paramLong1);
    if (paramBoolean2)
    {
      localObject = (MessageCache)this.d.getMsgCache();
      if (localObject != null) {
        ((MessageCache)localObject).b(paramString, 10014, paramLong2);
      }
    }
    if ((this.d instanceof BaseQQAppInterface)) {
      ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(paramString, 10014, paramLong2, 32768, paramInt1);
    }
    if (paramInt1 == 100100) {
      localObject = BaseApplication.getContext().getResources().getString(2131890564);
    } else if (paramInt1 == 100306) {
      localObject = BaseApplication.getContext().getResources().getString(2131890535);
    } else {
      localObject = "";
    }
    notifyUI(GuildMessageObserver.d, false, new Object[] { paramString, Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject });
  }
  
  private void a(ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      ((AtTroopMemberInfo)paramArrayList.next()).isResvAttr = true;
    }
  }
  
  private void a(Oidb0xf62.RspBody paramRspBody)
  {
    if (c(paramRspBody)) {
      return;
    }
    b(paramRspBody);
  }
  
  private void a(Oidb0xf62.RspBody paramRspBody, MessageRecord paramMessageRecord)
  {
    common.ContentHead localContentHead = (common.ContentHead)paramRspBody.head.content_head.get();
    Object localObject = (common.RoutingHead)paramRspBody.head.routing_head.get();
    paramMessageRecord.saveExtInfoToExtStr("GUILD_MSG_CNT_NAME", String.valueOf(localContentHead.cnt_seq.get()));
    paramMessageRecord.saveExtInfoToExtStr("GUILD_MSG_TYPE", String.valueOf(localContentHead.msg_type.get()));
    paramMessageRecord.saveExtInfoToExtStr("GUILD_MSG_SUB_TYPE", String.valueOf(localContentHead.sub_type.get()));
    paramMessageRecord.saveExtInfoToExtStr("MSG_GUILD_CODE", String.valueOf(((common.RoutingHead)localObject).guild_code.get()));
    paramMessageRecord.saveExtInfoToExtStr("GUILD_MSG_LOCAL_ONLY", String.valueOf(0));
    paramRspBody = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    paramRspBody.saveGuildIdToMR(paramMessageRecord, String.valueOf(((common.RoutingHead)localObject).guild_id.get()));
    localObject = localContentHead.msg_meta.get().toByteArray();
    paramRspBody.saveMsgMetaToMr(paramMessageRecord, (byte[])localObject);
    paramRspBody = new common.MsgMeta();
    try
    {
      paramRspBody.mergeFrom((byte[])localObject);
      paramMessageRecord.saveExtInfoToExtStr("GUILD_MSG_AT_ALL_SEQ", String.valueOf(paramRspBody.at_all_seq.get()));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msg_meta has() = ");
      ((StringBuilder)localObject).append(localContentHead.msg_meta.has());
      ((StringBuilder)localObject).append(", atAllSeq: ");
      ((StringBuilder)localObject).append(paramRspBody.at_all_seq.get());
      QLog.i("GuildSendMessageHandler", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramRspBody)
    {
      label255:
      break label255;
    }
    paramRspBody = new StringBuilder();
    paramRspBody.append("msg_meta merge exception! decodeMsg, MR: ");
    paramRspBody.append(paramMessageRecord.toString());
    paramRspBody.append(", extstr: ");
    paramRspBody.append(paramMessageRecord.extStr);
    QLog.e("GuildSendMessageHandler", 2, paramRspBody.toString());
  }
  
  private boolean a(IGuildSendMessageHandler.SendTextMsgParams paramSendTextMsgParams)
  {
    if (paramSendTextMsgParams == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildSendMessageHandler", 2, " checkParamValid params = null!");
      }
      return false;
    }
    boolean bool1 = TextUtils.isEmpty(paramSendTextMsgParams.b);
    boolean bool2 = TextUtils.isEmpty(paramSendTextMsgParams.c);
    boolean bool3 = TextUtils.isEmpty(paramSendTextMsgParams.d);
    if ((!bool1) && (!bool2) && (!bool3)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramSendTextMsgParams = new StringBuilder();
      paramSendTextMsgParams.append(" checkParamValid isGuildIdEmpty: ");
      paramSendTextMsgParams.append(bool1);
      paramSendTextMsgParams.append(", isChannelIdEmpty: ");
      paramSendTextMsgParams.append(bool2);
      paramSendTextMsgParams.append(", isMsgStrEmpty: ");
      paramSendTextMsgParams.append(bool3);
      QLog.d("GuildSendMessageHandler", 2, paramSendTextMsgParams.toString());
    }
    return false;
  }
  
  private void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).b(paramMessageRecord, null);
        return;
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("GuildSendMessageHandler", 1, "sendMessage:", paramMessageRecord);
        return;
      }
    }
    ThreadManager.post(new GuildSendMessageHandler.2(this, paramMessageRecord), 10, null, false);
  }
  
  private void b(Oidb0xf62.RspBody paramRspBody)
  {
    MessageRecord localMessageRecord1 = d(paramRspBody);
    if (localMessageRecord1 == null)
    {
      QLog.d("GuildSendMessageHandler", 2, "handleSelfSendMessage, mr == null");
      return;
    }
    MessageRecord localMessageRecord2 = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.d).a(10014).a(10014).d(localMessageRecord1.frienduin, 10014, localMessageRecord1);
    if (localMessageRecord2 == null)
    {
      QLog.d("GuildSendMessageHandler", 2, "handleSelfSendMessage, findMr == null");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSelfSendMessage, mr extstr = ");
      localStringBuilder.append(localMessageRecord1.extStr);
      localStringBuilder.append(", findMr extstr = ");
      localStringBuilder.append(localMessageRecord2.extStr);
      QLog.d("GuildSendMessageHandler", 2, localStringBuilder.toString());
    }
    localMessageRecord1.extStr = localMessageRecord2.extStr;
    localMessageRecord1.mExJsonObject = localMessageRecord2.mExJsonObject;
    localMessageRecord1.extLong = localMessageRecord2.extLong;
    a(paramRspBody, localMessageRecord1);
    ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).handleSelfSendMsg(this.d, localMessageRecord1, localMessageRecord2, 1);
  }
  
  private boolean b(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (!((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab())
    {
      QLog.e("GuildSendMessageHandler", 1, "filterRealSendMessage notshowguildtab");
      a(paramMessageRecord.frienduin, false, true, paramMessageRecord.shmsgseq, paramMessageRecord.uniseq, 0, -1);
      return true;
    }
    return false;
  }
  
  private static MessageRecord c(AppInterface paramAppInterface, IGuildSendMessageHandler.SendTextMsgParams paramSendTextMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildSendMessageHandler", 2, " createMsgQueueAndSend start.");
    }
    String str = a(paramSendTextMsgParams.d, paramSendTextMsgParams.e);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildSendMessageHandler", 2, " checkMsgStartWithChar0 failed.");
      }
      return null;
    }
    ChatMessage localChatMessage = (ChatMessage)((IMessageRecordFactoryService)QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1000);
    IGuildMessageUtilsApi localIGuildMessageUtilsApi = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
    localIGuildMessageUtilsApi.saveGuildIdToMR(localChatMessage, paramSendTextMsgParams.b);
    ((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).setSendingMsgRecordBaseInfo(paramAppInterface, localChatMessage, paramSendTextMsgParams.c, null, 10014);
    str = MessageUtils.a(str, true, paramSendTextMsgParams.e);
    int i = Math.abs(new Random().nextInt());
    localChatMessage.msg = str;
    localChatMessage.msgUid = MessageUtils.a(i);
    localChatMessage.longMsgCount = 0;
    localChatMessage.longMsgIndex = 0;
    localChatMessage.longMsgId = 0;
    localChatMessage.mAnimFlag = true;
    localChatMessage.mNewAnimFlag = true;
    localChatMessage.saveExtInfoToExtStr("GUILD_MSG_LOCAL_ONLY", "1");
    str = ((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    if ((!TextUtils.isEmpty(str)) && (!str.equals("0"))) {
      localChatMessage.senderuin = str;
    }
    if (paramSendTextMsgParams.i) {
      localChatMessage.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(1));
    }
    if (paramSendTextMsgParams.e != null) {
      localIGuildMessageUtilsApi.saveAtInfoList(localChatMessage, paramSendTextMsgParams.e);
    }
    GuildSendMessageCallbackConfig.a();
    GuildSendMessageCallbackConfig.a(paramAppInterface, localChatMessage, paramSendTextMsgParams);
    return localChatMessage;
  }
  
  private boolean c(Oidb0xf62.RspBody paramRspBody)
  {
    boolean bool1 = GuildOnlineMessageProcessor.a();
    boolean bool2 = GuildOnlineMessageProcessor.a(this.d);
    if ((!bool1) && (!bool2)) {
      return false;
    }
    ((IGuildMsgFactory)this.d.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().b(new Object[] { paramRspBody });
    paramRspBody = new StringBuilder();
    paramRspBody.append("noNeedProcessSendResp : isNeedToProcess = ");
    paramRspBody.append(bool1);
    paramRspBody.append(", isSyncFinish = ");
    paramRspBody.append(bool2);
    QLog.d("GuildSendMessageHandler", 2, paramRspBody.toString());
    return true;
  }
  
  private MessageRecord d(Oidb0xf62.RspBody paramRspBody)
  {
    if ((paramRspBody.head.has()) && (paramRspBody.head.content_head.has()) && (paramRspBody.head.routing_head.has()))
    {
      MessageRecord localMessageRecord = new MessageRecord();
      common.ContentHead localContentHead = (common.ContentHead)paramRspBody.head.content_head.get();
      common.RoutingHead localRoutingHead = (common.RoutingHead)paramRspBody.head.routing_head.get();
      localMessageRecord.msgUid = MessageUtils.a((int)localContentHead.random.get());
      localMessageRecord.time = localContentHead.msg_time.get();
      localMessageRecord.msgseq = localContentHead.msg_time.get();
      localMessageRecord.shmsgseq = localContentHead.msg_seq.get();
      localMessageRecord.selfuin = this.d.getCurrentAccountUin();
      localMessageRecord.istroop = 10014;
      localMessageRecord.senderuin = String.valueOf(localRoutingHead.from_tinyid.get());
      localMessageRecord.frienduin = String.valueOf(localRoutingHead.channel_id.get());
      localMessageRecord.longMsgId = 0;
      localMessageRecord.longMsgCount = 0;
      localMessageRecord.longMsgIndex = 0;
      a(paramRspBody, localMessageRecord);
      return localMessageRecord;
    }
    return null;
  }
  
  public long a(AppInterface paramAppInterface, IGuildSendMessageHandler.SendTextMsgParams paramSendTextMsgParams)
  {
    if (!a(paramSendTextMsgParams))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildSendMessageHandler", 2, " checkParamValid failed.");
      }
      return -1L;
    }
    a(paramSendTextMsgParams.e);
    paramAppInterface = c(paramAppInterface, paramSendTextMsgParams);
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildSendMessageHandler", 2, " createMessageRecord failed.");
      }
      return -1L;
    }
    a(paramAppInterface, paramSendTextMsgParams.h);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendTextMessage | addAndSendMessage, key: ");
      localStringBuilder.append(paramSendTextMsgParams.b);
      localStringBuilder.append(", channelId: ");
      localStringBuilder.append(paramSendTextMsgParams.c);
      localStringBuilder.append(", uniseq: ");
      localStringBuilder.append(paramAppInterface.uniseq);
      QLog.d("GuildSendMessageHandler", 2, localStringBuilder.toString());
    }
    return paramAppInterface.uniseq;
  }
  
  public List<MessageRecord> a()
  {
    return this.c;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {
      this.c.add(paramMessageRecord);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendRichTextMessageWith_MR. MR: ");
      ((StringBuilder)localObject).append(paramMessageRecord.toString());
      QLog.d("GuildSendMessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (b(paramMessageRecord, paramBusinessObserver, paramBoolean)) {
      return;
    }
    Object localObject = new SendMessageHandler();
    boolean bool = addToQueue(paramMessageRecord.msgseq, (SendMessageHandler)localObject);
    a(paramMessageRecord, a, 0, paramBusinessObserver, paramBoolean);
    ((SendMessageHandler)localObject).postDelayed(new GuildSendMessageHandler.3(this, paramMessageRecord), MessageCache.a);
    if (bool)
    {
      int i = 0;
      while (i < 8)
      {
        ((SendMessageHandler)localObject).a(new GuildSendMessageHandler.4(this, paramMessageRecord, paramBusinessObserver, paramBoolean));
        i += 1;
      }
      i = 1;
      while (i < 3)
      {
        long l = (3 - i) * 480000 / 3 - i * 2000;
        ((SendMessageHandler)localObject).a(480000 * i / 3, l, "period");
        i += 1;
      }
    }
    GuildSendMessageCallbackConfig.a();
    GuildSendMessageCallbackConfig.a(paramMessageRecord);
    this.c.add(paramMessageRecord);
    if (this.c.size() > b) {
      this.c.remove(0);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    super.notifyUI(paramToServiceMsg, paramInt, paramBoolean, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramToServiceMsg.extraData.getBoolean("RichNotify", false))
    {
      int i = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      StatictisInfo localStatictisInfo = new StatictisInfo();
      if (paramBoolean)
      {
        localStatictisInfo.b = paramFromServiceMsg.getResultCode();
        localStatictisInfo.c = (i + 1);
      }
      else
      {
        localStatictisInfo.b = 2900;
        localStatictisInfo.d = paramInt;
        localStatictisInfo.c = (i + 1);
        localStatictisInfo.e = BaseMessageHandler.a(paramFromServiceMsg);
      }
      localStatictisInfo.f = 1;
      a(paramToServiceMsg, 5006, paramBoolean, new Object[] { Long.valueOf(paramLong), localStatictisInfo });
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSendMessageSuccessful, channelId: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", uniseq: ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", msgseq: ");
      localStringBuilder.append(paramLong2);
      QLog.d("GuildSendMessageHandler", 2, localStringBuilder.toString());
    }
    ((MessageCache)this.d.getMsgCache()).b(paramString, 10014, paramLong1);
    notifyUI(GuildMessageObserver.c, true, new Object[] { paramString, Long.valueOf(paramLong1) });
    removeSendMessageHandler(paramLong2);
  }
  
  public long b(AppInterface paramAppInterface, IGuildSendMessageHandler.SendTextMsgParams paramSendTextMsgParams)
  {
    if (!a(paramSendTextMsgParams))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildSendMessageHandler", 2, " checkParamValid failed.");
      }
      return -1L;
    }
    a(paramSendTextMsgParams.e);
    paramAppInterface = c(paramAppInterface, paramSendTextMsgParams);
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildSendMessageHandler", 2, " createMessageRecord failed.");
      }
      return -1L;
    }
    b(paramAppInterface, paramSendTextMsgParams.h);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendTextMessage | addAndSendMessage, key: ");
      localStringBuilder.append(paramSendTextMsgParams.b);
      localStringBuilder.append(", channelId: ");
      localStringBuilder.append(paramSendTextMsgParams.c);
      localStringBuilder.append(", uniseq: ");
      localStringBuilder.append(paramAppInterface.uniseq);
      QLog.d("GuildSendMessageHandler", 2, localStringBuilder.toString());
    }
    return paramAppInterface.uniseq;
  }
  
  public void b()
  {
    Iterator localIterator = ((IGuildMsgFactory)this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().d().iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      if ((arrayOfObject != null) && (arrayOfObject.length == 1) && ((arrayOfObject[0] instanceof Oidb0xf62.RspBody))) {
        b((Oidb0xf62.RspBody)arrayOfObject[0]);
      }
    }
    ((IGuildMsgFactory)this.appRuntime.getRuntimeService(IGuildMsgFactory.class, "")).getMsgCache().e();
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MsgProxy.SendMsg");
    }
    return this.allowCmdSet;
  }
  
  public void onDestroy()
  {
    MessageCache localMessageCache = (MessageCache)this.d.getMsgCache();
    if (localMessageCache != null) {
      localMessageCache.s();
    }
    destroySendQueue();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("GuildSendMessageHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("MsgProxy.SendMsg".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildSendMessageHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler
 * JD-Core Version:    0.7.0.1
 */