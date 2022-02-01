package com.tencent.mobileqq.service.message.api.impl;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler;
import com.tencent.imcore.message.IGrpDisPTTDecoder;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.nearby.api.INearbyFlowerMessage;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.service.message.TroopHotChatTopicHandler;
import com.tencent.mobileqq.service.message.api.IBaseMessageProcessorForTroopAndDiscService;
import com.tencent.mobileqq.service.message.codec.decoder.AppShareInfoDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.GrpDisPTTDecoder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;

public class BaseMessageProcessorForTroopAndDiscServiceImpl
  implements IBaseMessageProcessorForTroopAndDiscService
{
  private static final String TAG = "BaseMessageProcessorForTroopAndDiscServiceImpl";
  private QQAppInterface app;
  
  private void decodeAnonymousGroupMsg(MessageRecord paramMessageRecord, im_msg_body.Elem paramElem)
  {
    Object localObject = (im_msg_body.AnonymousGroupMsg)paramElem.anon_group_msg.get();
    int i = ((im_msg_body.AnonymousGroupMsg)localObject).uint32_flags.get();
    paramElem = ((im_msg_body.AnonymousGroupMsg)localObject).str_anon_id.get().toByteArray();
    byte[] arrayOfByte = ((im_msg_body.AnonymousGroupMsg)localObject).str_anon_nick.get().toByteArray();
    int j = ((im_msg_body.AnonymousGroupMsg)localObject).uint32_head_portrait.get();
    int k = ((im_msg_body.AnonymousGroupMsg)localObject).uint32_expire_time.get();
    String str = ((im_msg_body.AnonymousGroupMsg)localObject).str_rank_color.get().toStringUtf8();
    localObject = "";
    if (paramElem != null) {
      try
      {
        paramElem = new String(paramElem, "ISO-8859-1");
      }
      catch (UnsupportedEncodingException paramElem)
      {
        paramElem.printStackTrace();
      }
    } else {
      paramElem = "";
    }
    if (arrayOfByte != null) {
      localObject = new String(arrayOfByte);
    }
    paramMessageRecord.saveExtInfoToExtStr("anonymous", AnonymousChatHelper.a(i, paramElem, (String)localObject, j, k, str));
    paramMessageRecord.extLong |= 0x3;
    if (QLog.isColorLevel())
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("anonymous_flags = ");
      paramMessageRecord.append(i);
      QLog.d("anonymous_decode", 2, paramMessageRecord.toString());
    }
  }
  
  private String decodeAnonymousMsg(PBDecodeContext paramPBDecodeContext, List<im_msg_body.Elem> paramList, String paramString, MessageRecord paramMessageRecord)
  {
    if (((paramPBDecodeContext.w == 1) || (paramPBDecodeContext.w == 1026)) && (paramList != null))
    {
      Iterator localIterator = paramList.iterator();
      paramList = paramString;
      for (;;)
      {
        paramString = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject = (im_msg_body.Elem)localIterator.next();
        if (((im_msg_body.Elem)localObject).anon_group_msg.has())
        {
          decodeAnonymousGroupMsg(paramMessageRecord, (im_msg_body.Elem)localObject);
          return paramList;
        }
        paramString = paramList;
        if (((im_msg_body.Elem)localObject).extra_info.has()) {
          paramString = decodeAnonymousSenderTitle(paramPBDecodeContext, (im_msg_body.Elem)localObject);
        }
        paramList = paramString;
        if (((im_msg_body.Elem)localObject).group_business_msg.has())
        {
          localObject = TroopBusinessUtil.TroopBusinessMessage.a(((im_msg_body.Elem)localObject).group_business_msg);
          TroopBusinessUtil.a(paramMessageRecord, (TroopBusinessUtil.TroopBusinessMessage)localObject);
          QQAppInterface localQQAppInterface = this.app;
          if (paramMessageRecord.frienduin == null) {
            paramList = "";
          } else {
            paramList = paramMessageRecord.frienduin;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramMessageRecord.msgtype);
          localStringBuilder.append("");
          ReportController.b(localQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "revice_msg", 0, 0, paramList, localStringBuilder.toString(), ((TroopBusinessUtil.TroopBusinessMessage)localObject).d, "");
          paramList = paramString;
          if (QLog.isColorLevel())
          {
            paramList = new StringBuilder();
            paramList.append("decode group_business_msg:");
            paramList.append(localObject);
            QLog.i("BaseMessageProcessorForTroopAndDiscServiceImpl", 2, paramList.toString());
            paramList = paramString;
          }
        }
      }
    }
    return paramString;
  }
  
  @NotNull
  private String decodeAnonymousSenderTitle(PBDecodeContext paramPBDecodeContext, im_msg_body.Elem paramElem)
  {
    paramElem = (im_msg_body.ExtraInfo)paramElem.extra_info.get();
    String str = paramElem.bytes_sender_title.get().toStringUtf8();
    int i = paramElem.uint32_flags.get();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dwFlags:");
      localStringBuilder.append(i);
      QLog.d("BaseMessageProcessorForTroopAndDiscServiceImpl.troop.special_msg", 2, localStringBuilder.toString());
    }
    if (paramElem.uint32_new_group_flag.has())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPBDecodeContext.x);
      localStringBuilder.append("");
      paramPBDecodeContext = localStringBuilder.toString();
      if (getConversationFacade().getTroopMask(paramPBDecodeContext) != paramElem.uint32_new_group_flag.get()) {
        getConversationFacade().setTroopMsgFilterToServer(paramPBDecodeContext, Integer.valueOf(paramElem.uint32_new_group_flag.get()));
      }
    }
    return str;
  }
  
  private void decodeArkMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (isArkMsg(paramMessageRecord)) {
      paramMessageInfo.c.a(20, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void decodeCalendarMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    paramStructMsgForGeneralShare = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    long l = paramMessageRecord.uniseq;
    paramStructMsgForGeneralShare = paramMessageRecord.frienduin;
    Object localObject2 = new BaseMessageManager.AddMessageContext(this.app);
    Object localObject1 = ((BaseMessageManager.AddMessageContext)localObject2).k;
    localObject2 = ((BaseMessageManager.AddMessageContext)localObject2).a;
    localObject1 = ((RecentUserProxy)localObject1).b(paramStructMsgForGeneralShare, 1);
    ((IBizTroopMemberInfoService)this.app.getRuntimeService(IBizTroopMemberInfoService.class, "")).getCalendarNoticeTroopMember(paramMessageRecord.frienduin, StructMsgForGeneralShare.eventId, paramMessageRecord.shmsgseq, new BaseMessageProcessorForTroopAndDiscServiceImpl.1(this, false, paramMessageInfo, paramLong, l, (RecentUser)localObject1, paramStructMsgForGeneralShare, paramMessageRecord, (Map)localObject2));
  }
  
  private void decodeGamePartyMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (isGamePartyMsg(paramMessageRecord)) {
      paramMessageInfo.c.a(19, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void decodeHomeworkMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (isHomeworkMsg(paramMessageRecord)) {
      paramMessageInfo.c.a(5, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void decodeMixMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -1035)
    {
      Object localObject1 = (MessageForMixedMsg)paramMessageRecord;
      int i = 0;
      while (i < ((MessageForMixedMsg)localObject1).msgElemList.size())
      {
        Object localObject2 = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(i);
        if ((localObject2 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForReplyText)localObject2;
          if (this.app.getCurrentAccountUin() == null) {
            break;
          }
          localObject2 = this.app.getCurrentAccountUin();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((MessageForReplyText)localObject1).mSourceMsgInfo.mSourceMsgSenderUin);
          localStringBuilder.append("");
          if (!((String)localObject2).equals(localStringBuilder.toString())) {
            break;
          }
          paramMessageInfo.c.a(22, paramLong, paramMessageRecord.uniseq);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void decodeNearbyFlowerMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).isNearbyFlowerMsg(paramMessageRecord))
    {
      Object localObject = (INearbyFlowerMessage)QRoute.api(INearbyFlowerMessage.class);
      ((INearbyFlowerMessage)localObject).init(this.app, (MessageForStructing)paramMessageRecord);
      if (this.app.getCurrentAccountUin() != null)
      {
        if (this.app.getCurrentAccountUin().equals(((INearbyFlowerMessage)localObject).getrUin()))
        {
          paramMessageInfo = paramMessageInfo.c;
          localObject = this.app;
          boolean bool;
          if (paramMessageRecord.istroop == 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramMessageInfo.a((AppRuntime)localObject, bool, paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
          return;
        }
        if (!this.app.getCurrentAccountUin().equals(((INearbyFlowerMessage)localObject).getsUin())) {
          paramMessageInfo.c.a(7, paramLong, paramMessageRecord.uniseq);
        }
      }
    }
  }
  
  private void decodeReplyTextMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -1049)
    {
      MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
      if (this.app.getCurrentAccountUin() != null)
      {
        String str = this.app.getCurrentAccountUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin);
        localStringBuilder.append("");
        if (str.equals(localStringBuilder.toString())) {
          paramMessageInfo.c.a(22, paramLong, paramMessageRecord.uniseq);
        }
      }
    }
  }
  
  private void decodeStickerMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2058) {
      EmojiStickerManager.a(paramMessageRecord, this.app);
    }
  }
  
  private void decodeStructingMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      Object localObject = StructMsgFactory.a(paramMessageRecord.msgData);
      if ((localObject instanceof StructMsgForGeneralShare))
      {
        localObject = (StructMsgForGeneralShare)localObject;
        if ((localObject != null) && (((StructMsgForGeneralShare)localObject).mMsgServiceID == 75))
        {
          decodeCalendarMsg(paramLong, paramMessageInfo, paramMessageRecord, (StructMsgForGeneralShare)localObject);
          return;
        }
        if ((localObject != null) && (((StructMsgForGeneralShare)localObject).mMsgServiceID == 19) && (!((StructMsgForGeneralShare)localObject).mMsgBrief.startsWith(HardCodeUtil.a(2131899252))) && (!((StructMsgForGeneralShare)localObject).mMsgBrief.equals(HardCodeUtil.a(2131899246))))
        {
          paramMessageInfo.c.a(2, paramLong, paramMessageRecord.uniseq);
          return;
        }
        if ((localObject != null) && (((StructMsgForGeneralShare)localObject).mMsgServiceID == 106))
        {
          if ((((StructMsgForGeneralShare)localObject).atMembers != null) && (((StructMsgForGeneralShare)localObject).atMembers.contains(this.app.getCurrentAccountUin()))) {
            paramMessageInfo.c.a(24, paramLong, paramMessageRecord.uniseq);
          }
        }
        else if ((localObject != null) && (((StructMsgForGeneralShare)localObject).mMsgServiceID == 107)) {
          paramMessageInfo.c.a(12, paramLong, paramMessageRecord.uniseq);
        }
      }
    }
  }
  
  private void decodeTroopArkApp(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype == -5008) && ((paramMessageRecord instanceof MessageForArkApp)))
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramMessageRecord;
      if ((localMessageForArkApp.ark_app_message != null) && (localMessageForArkApp.ark_app_message.appName.equals("com.tencent.mannounce"))) {
        paramMessageInfo.c.a(11, paramLong, paramMessageRecord.uniseq);
      }
    }
  }
  
  private void decodeTroopAttention(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1) && (TroopKeywordManager.a(this.app).a(paramMessageRecord.msg, paramMessageRecord.frienduin))) {
      paramMessageInfo.c.a(16, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void decodeTroopConfess(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord instanceof MessageForTroopConfess)) && (((MessageForTroopConfess)paramMessageRecord).isToSelf)) {
      paramMessageInfo.c.a(10, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void decodeTroopDeliverGiftMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    troopGiftArk(paramMessageRecord);
    if ((paramMessageRecord.msgtype == -2035) || (paramMessageRecord.msgtype == -2038))
    {
      MessageForDeliverGiftTips localMessageForDeliverGiftTips = (MessageForDeliverGiftTips)paramMessageRecord;
      Object localObject = ContactUtils.a(this.app, localMessageForDeliverGiftTips.istroop, localMessageForDeliverGiftTips.frienduin, localMessageForDeliverGiftTips.senderuin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localMessageForDeliverGiftTips.senderName = ((String)localObject);
      }
      if (!localMessageForDeliverGiftTips.isFromNearby)
      {
        localObject = this.app.getCurrentAccountUin();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localMessageForDeliverGiftTips.receiverUin);
          localStringBuilder.append("");
          if ((!((String)localObject).equals(localStringBuilder.toString())) && (!localMessageForDeliverGiftTips.isToAll()))
          {
            if (localMessageForDeliverGiftTips.animationPackageId > 0) {
              paramMessageInfo.c.a(7, paramLong, paramMessageRecord.uniseq);
            }
          }
          else
          {
            paramMessageInfo = paramMessageInfo.c;
            localObject = this.app;
            boolean bool;
            if (paramMessageRecord.istroop == 1) {
              bool = true;
            } else {
              bool = false;
            }
            paramMessageInfo.a((AppRuntime)localObject, bool, paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
          }
        }
        paramMessageInfo = (AIOAnimationControlManager)this.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
        if (paramMessageInfo != null) {
          paramMessageInfo.b(localMessageForDeliverGiftTips);
        }
      }
    }
  }
  
  private void decodeTroopFile(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForTroopFile)) {
      paramMessageInfo.c.a(3, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void decodeTroopScriptMsg(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (TroopBindPublicAccountMgr.a(paramMessageRecord)) {
      paramMessageInfo.c.a(8, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void decodeVasApolloMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2039) {
      ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).decodeTroopVasApolloMsg(this.app, paramMessageRecord);
    }
  }
  
  private IConversationFacade getConversationFacade()
  {
    return (IConversationFacade)this.app.getRuntimeService(IConversationFacade.class, "");
  }
  
  private boolean isArkMsg(MessageRecord paramMessageRecord)
  {
    boolean bool3 = paramMessageRecord instanceof MessageForArkApp;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      bool1 = bool2;
      if (paramMessageRecord.ark_app_message != null)
      {
        bool1 = bool2;
        if (ArkAiAppCenter.a(paramMessageRecord.ark_app_message.appName)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean isGamePartyMsg(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForArkApp)) && ("com.tencent.qqopen.teamup".equals(((MessageForArkApp)paramMessageRecord).ark_app_message.appName));
  }
  
  private boolean isHomeworkMsg(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if ((paramMessageRecord != null) && (("com.tencent.homeworkContent".equals(paramMessageRecord.appName)) || ("com.tencent.test.homeworkContent".equals(paramMessageRecord.appName)))) {
        return true;
      }
    }
    else if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord != null) && (paramMessageRecord.mMsgServiceID == 60)) {
        return true;
      }
    }
    return false;
  }
  
  private void troopGiftArk(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype != -5008) {
      return;
    }
    if (!(paramMessageRecord instanceof MessageForArkApp)) {
      return;
    }
    paramMessageRecord = (MessageForArkApp)paramMessageRecord;
    if ((paramMessageRecord.ark_app_message != null) && (paramMessageRecord.ark_app_message.appName.equals("com.tencent.qzone.qungift")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseMessageProcessorForTroopAndDiscServiceImpl", 2, "com.tencent.qzone.qungift");
      }
      AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localAIOAnimationControlManager != null) {
        localAIOAnimationControlManager.a(paramMessageRecord.ark_app_message.metaList, paramMessageRecord.isread, paramMessageRecord.shmsgseq);
      }
    }
  }
  
  public void decodeC2CMsgPkgAppShared(BaseMessageHandler paramBaseMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseMessageProcessorForTroopAndDiscServiceImpl", 2, "decodeC2CMsgPkgAppShared");
    }
    AppShareInfoDecoder.a(paramBaseMessageHandler, paramList, paramMsg, paramLong1, paramLong2, false);
  }
  
  public String decodeTroopMsg(MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo1, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, int paramInt1, int paramInt2, int paramInt3, List<MessageRecord> paramList, List<im_msg_body.Elem> paramList1, MessageInfo paramMessageInfo2, byte paramByte, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseMessageProcessorForTroopAndDiscServiceImpl", 2, "decodeTroopMsg");
    }
    if (((paramMessageRecord instanceof MessageForFoldMsg)) && (QLog.isColorLevel())) {
      QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, frienduin: %s, senduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { paramMessageRecord.frienduin, paramMessageRecord.senderuin, Long.valueOf(paramMessageRecord.msgUid), Long.valueOf(paramMessageRecord.shmsgseq), paramMessageRecord.getLogColorContent() }));
    }
    decodeTroopAttention(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeTroopConfess(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeHomeworkMsg(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeGamePartyMsg(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeArkMsg(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeReplyTextMsg(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeStickerMsg(paramMessageRecord);
    decodeMixMsg(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeTroopDeliverGiftMsg(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeNearbyFlowerMsg(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeStructingMsg(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeTroopFile(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeTroopScriptMsg(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeTroopArkApp(paramLong2, paramMessageInfo2, paramMessageRecord);
    decodeVasApolloMsg(paramMessageRecord);
    return decodeAnonymousMsg(paramPBDecodeContext, paramList1, paramString2, paramMessageRecord);
  }
  
  public IGrpDisPTTDecoder<BaseMessageHandler> getGrpDisPTTDecoder()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseMessageProcessorForTroopAndDiscServiceImpl", 2, "getGrpDisPTTDecoder");
    }
    return new GrpDisPTTDecoder();
  }
  
  public BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler getQTroopHotChatTopicHandler(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<im_msg_body.Elem> paramList, byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseMessageProcessorForTroopAndDiscServiceImpl", 2, "getQTroopHotChatTopicHandler");
    }
    return new TroopHotChatTopicHandler(paramArrayList, paramPBDecodeContext, paramBoolean, paramMsgHead, paramLong1, paramLong2, paramLong3, paramLong4, paramList, paramByte, paramString);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((QQAppInterface)paramAppRuntime);
    if (QLog.isColorLevel()) {
      QLog.d("BaseMessageProcessorForTroopAndDiscServiceImpl", 2, "onCreate");
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.api.impl.BaseMessageProcessorForTroopAndDiscServiceImpl
 * JD-Core Version:    0.7.0.1
 */