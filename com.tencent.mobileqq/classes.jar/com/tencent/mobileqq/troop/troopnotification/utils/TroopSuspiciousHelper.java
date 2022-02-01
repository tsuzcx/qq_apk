package com.tencent.mobileqq.troop.troopnotification.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.util.TroopSystemMsgUtils;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgNew;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopSuspiciousHelper
{
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    paramAppInterface = (IMessageHandler)paramAppInterface.getRuntimeService(IMessageHandler.class, "");
    if (paramAppInterface != null) {
      paramAppInterface.sendGetSystemMsgForSus();
    }
  }
  
  public static void a(AppInterface paramAppInterface, structmsg.RspNextSystemMsg paramRspNextSystemMsg, String paramString)
  {
    if (paramAppInterface != null)
    {
      if (paramRspNextSystemMsg == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramRspNextSystemMsg.msgs.get();
      int j = ((List)localObject1).size();
      boolean bool1 = QLog.isColorLevel();
      String str = "Q.systemmsg.";
      if (bool1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("<---sendGetNextGroupSystemMsg Resp : decode pb size = ");
        ((StringBuilder)localObject2).append(j);
        QLog.e("Q.systemmsg.", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new HashSet();
      boolean bool2 = false;
      int i = 0;
      while (i < j)
      {
        structmsg.StructMsg localStructMsg = (structmsg.StructMsg)((structmsg.StructMsg)((List)localObject1).get(i)).get();
        if ((localStructMsg == null) || (!localStructMsg.msg_seq.has()) || (!((Set)localObject2).contains(Long.valueOf(localStructMsg.msg_seq.get()))))
        {
          MessageForSystemMsg localMessageForSystemMsg = new MessageForSystemMsg();
          localMessageForSystemMsg.msgtype = -2018;
          localMessageForSystemMsg.selfuin = paramString;
          localMessageForSystemMsg.frienduin = AppConstants.TROOP_SUSPICIOUS_MSG_UIN;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((structmsg.StructMsg)((List)localObject1).get(i)).req_uin.get());
          ((StringBuilder)localObject3).append("");
          localMessageForSystemMsg.senderuin = ((StringBuilder)localObject3).toString();
          localMessageForSystemMsg.istroop = 0;
          localObject3 = (MessageForSystemMsg)localMessageForSystemMsg;
          ((MessageForSystemMsg)localObject3).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject1).get(i)).get());
          localMessageForSystemMsg.msgData = ((MessageForSystemMsg)localObject3).structMsg.toByteArray();
          localArrayList.add(localObject3);
          if ((localStructMsg != null) && (localStructMsg.msg_seq.has())) {
            ((Set)localObject2).add(Long.valueOf(localStructMsg.msg_seq.get()));
          }
        }
        i += 1;
      }
      localObject1 = (ITroopNotificationService)paramAppInterface.getRuntimeService(ITroopNotificationService.class, "");
      if (localArrayList.size() > 0)
      {
        if ((localArrayList.size() < 100) && (localObject1 != null)) {
          ((ITroopNotificationService)localObject1).setTroopSuspiciousNotificaitonGetAll(true);
        }
        long l2 = paramRspNextSystemMsg.following_group_seq.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = ((MessageCache)paramAppInterface.getMsgCache()).e("following_group_suspicious_seq");
        }
        if (QLog.isColorLevel())
        {
          paramRspNextSystemMsg = new StringBuilder();
          paramRspNextSystemMsg.append("<---sendGetNextGroupSystemMsg : decode pb following_group_seq");
          paramRspNextSystemMsg.append(l1);
          QLog.e(str, 2, paramRspNextSystemMsg.toString());
        }
        ((MessageCache)paramAppInterface.getMsgCache()).e("following_group_suspicious_seq", l1);
        paramRspNextSystemMsg = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
        paramString = String.valueOf(paramString);
        bool1 = bool2;
        if (BaseMessageHandlerUtils.a(localArrayList))
        {
          bool1 = bool2;
          if (paramAppInterface.isBackgroundStop) {
            bool1 = true;
          }
        }
        paramRspNextSystemMsg.addMessage(localArrayList, paramString, bool1);
      }
      else if (localObject1 != null)
      {
        ((ITroopNotificationService)localObject1).setTroopSuspiciousNotificaitonGetAll(true);
      }
      paramAppInterface = (IMessageHandler)paramAppInterface.getRuntimeService(IMessageHandler.class, "");
      if (paramAppInterface != null) {
        paramAppInterface.notifyBusinessMessageForSus(4019, true, localArrayList);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, structmsg.RspSystemMsgNew paramRspSystemMsgNew, List<structmsg.StructMsg> paramList, int paramInt, String paramString)
  {
    if ((paramAppInterface != null) && (paramList != null))
    {
      if (paramRspSystemMsgNew == null) {
        return;
      }
      if (paramList.size() == 0) {
        return;
      }
      ((MessageCache)paramAppInterface.getMsgCache()).e("last_group_suspicious_seq", paramRspSystemMsgNew.latest_group_seq.get());
      ((MessageCache)paramAppInterface.getMsgCache()).e("following_group_suspicious_seq", paramRspSystemMsgNew.following_group_seq.get());
      GroupSystemMsgController.a().b(paramAppInterface, paramInt);
      paramRspSystemMsgNew = new ArrayList();
      int i = paramList.size();
      Object localObject1 = (ITroopNotificationService)paramAppInterface.getRuntimeService(ITroopNotificationService.class, "");
      if (localObject1 != null) {
        ((ITroopNotificationService)localObject1).setTroopSuspiciousNotificaitonGetAll(false);
      }
      Collections.sort(paramList, new TroopSuspiciousHelper.1());
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = new MessageForSystemMsg();
        ((MessageRecord)localObject1).msgtype = -2018;
        ((MessageRecord)localObject1).selfuin = paramString;
        ((MessageRecord)localObject1).frienduin = AppConstants.TROOP_SUSPICIOUS_MSG_UIN;
        Object localObject2 = (structmsg.StructMsg)paramList.get(paramInt);
        int j = ((structmsg.StructMsg)localObject2).msg.group_msg_type.get();
        int k = TroopSystemMsgUtils.a(j);
        if (k == 1)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((structmsg.StructMsg)localObject2).msg.action_uin.get());
          ((StringBuilder)localObject3).append("");
          ((MessageRecord)localObject1).senderuin = ((StringBuilder)localObject3).toString();
        }
        else if (k == 2)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((structmsg.StructMsg)localObject2).req_uin.get());
          ((StringBuilder)localObject3).append("");
          ((MessageRecord)localObject1).senderuin = ((StringBuilder)localObject3).toString();
        }
        ((MessageRecord)localObject1).istroop = 0;
        Object localObject3 = (MessageForSystemMsg)localObject1;
        ((MessageForSystemMsg)localObject3).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)localObject2).get());
        ((MessageForSystemMsg)localObject3).shmsgseq = ((MessageForSystemMsg)localObject3).structMsg.msg_seq.get();
        k = ((MessageForSystemMsg)localObject3).structMsg.msg_type.get();
        int m = ((MessageForSystemMsg)localObject3).structMsg.msg.sub_type.get();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" type:");
          localStringBuilder.append(k);
          localStringBuilder.append(" groupMsgType:");
          localStringBuilder.append(j);
          localStringBuilder.append(" subType:");
          localStringBuilder.append(m);
          localStringBuilder.append(" troopUin:");
          localStringBuilder.append(((structmsg.StructMsg)localObject2).msg.group_code.get());
          localStringBuilder.append(" msgTime:");
          localStringBuilder.append(((structmsg.StructMsg)localObject2).msg_time.get());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("processGroupSystemMsg-->");
          ((StringBuilder)localObject2).append(localStringBuilder.toString());
          QLog.d("TroopSuspiciousHelper", 2, ((StringBuilder)localObject2).toString());
        }
        ((MessageRecord)localObject1).msgData = ((MessageForSystemMsg)localObject3).structMsg.toByteArray();
        paramRspSystemMsgNew.add(localObject3);
        paramInt += 1;
      }
      paramList = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
      localObject1 = AppConstants.TROOP_SUSPICIOUS_MSG_UIN;
      boolean bool2 = false;
      paramList.clearHistory((String)localObject1, 0);
      if (paramRspSystemMsgNew.size() > 0)
      {
        paramList = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
        paramString = String.valueOf(paramString);
        boolean bool1 = bool2;
        if (BaseMessageHandlerUtils.a(paramRspSystemMsgNew))
        {
          bool1 = bool2;
          if (paramAppInterface.isBackgroundStop) {
            bool1 = true;
          }
        }
        paramList.addMessage(paramRspSystemMsgNew, paramString, bool1);
      }
      paramAppInterface = (IMessageHandler)paramAppInterface.getRuntimeService(IMessageHandler.class, "");
      if (paramAppInterface != null) {
        paramAppInterface.notifyBusinessMessageForSus(4019, true, paramRspSystemMsgNew);
      }
    }
  }
  
  public static void a(List<MessageRecord> paramList, AppInterface paramAppInterface)
  {
    if (paramList.size() >= 40)
    {
      paramList = (MessageRecord)paramList.get(39);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l = paramList.msg_seq.get();
          if (l > 0L)
          {
            paramList = (ITroopSysMsgDependApiService)paramAppInterface.getRuntimeService(ITroopSysMsgDependApiService.class, "");
            if (paramList != null) {
              paramList.addSystemMsgSeq("following_group_suspicious_seq", l);
            }
          }
        }
      }
    }
  }
  
  public static void a(structmsg.StructMsg paramStructMsg)
  {
    if (paramStructMsg == null) {
      return;
    }
    if (paramStructMsg.msg.has())
    {
      if (!paramStructMsg.msg.actions.has()) {
        return;
      }
      paramStructMsg = paramStructMsg.msg.actions.get();
      if (paramStructMsg == null) {
        return;
      }
      int i = 0;
      while (i < paramStructMsg.size())
      {
        ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramStructMsg.get(i)).action_info.get()).uint32_req_msg_type.set(2);
        i += 1;
      }
    }
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, String paramString)
  {
    if (paramStructMsg == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramStructMsg.msg.group_code.get());
    String str = "";
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramStructMsg.msg.group_msg_type.get());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramStructMsg.msg.bytes_warning_tips.get() != null) {
      str = paramStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
    }
    TroopReportor.a("Grp_contacts_news", "notice", paramString, 0, 0, new String[] { localObject1, localObject2, str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.utils.TroopSuspiciousHelper
 * JD-Core Version:    0.7.0.1
 */