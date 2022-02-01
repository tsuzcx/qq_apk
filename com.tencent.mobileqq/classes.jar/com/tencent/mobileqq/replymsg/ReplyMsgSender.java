package com.tencent.mobileqq.replymsg;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgRequest;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ReplyMsgSender
{
  private static volatile ReplyMsgSender a;
  
  public static ReplyMsgSender a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ReplyMsgSender();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, String paramString1, ArrayList<AtTroopMemberInfo> paramArrayList1, ChatActivityFacade.SendMsgParams paramSendMsgParams, MessageRecord paramMessageRecord, String paramString2, ArrayList<AtTroopMemberInfo> paramArrayList2)
  {
    MessageForReplyText localMessageForReplyText = new MessageForReplyText();
    localMessageForReplyText.msg = paramString1;
    localMessageForReplyText.istroop = paramBaseSessionInfo.jdField_a_of_type_Int;
    localMessageForReplyText.msgtype = -1049;
    localMessageForReplyText.atInfoList = paramArrayList1;
    localMessageForReplyText.mSourceMsgInfo = paramSendMsgParams.a;
    localMessageForReplyText.setSourceMessageRecord(paramMessageRecord);
    localMessageForReplyText.isBarrageMsg = paramSendMsgParams.jdField_d_of_type_Boolean;
    localMessageForReplyText.barrageTimeLocation = paramSendMsgParams.b;
    localMessageForReplyText.barrageSourceMsgType = paramSendMsgParams.jdField_d_of_type_Int;
    if ((!TextUtils.isEmpty(paramString2)) && (paramArrayList2 != null) && (!paramArrayList2.isEmpty()))
    {
      localMessageForReplyText.saveExtInfoToExtStr("sens_reply_special_msg", paramString2);
      localMessageForReplyText.saveExtInfoToExtStr("sens_reply_special_at_list", AtTroopMemberSpan.a(paramArrayList2));
    }
    int i;
    if ((paramSendMsgParams.a != null) && (!TextUtils.isEmpty(paramSendMsgParams.a.mSourceMsgTroopName))) {
      i = 0;
    } else {
      i = 2;
    }
    a(paramQQAppInterface, localMessageForReplyText, paramBaseSessionInfo, i, 0, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("FORWARD_MSG_UNISEQ", 0L);
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgSender", 2, "sendReplyMessage uniseq=0");
      }
      return;
    }
    ChatMessage localChatMessage = ((ForwardMsgManager)paramQQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(l);
    if (localChatMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgSender", 2, "sendReplyMessage chatMessage is null");
      }
      return;
    }
    a(paramQQAppInterface, localChatMessage, paramSessionInfo, 0, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", 0), true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    new ArrayList(1).add(paramChatMessage);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramChatMessage);
    paramChatMessage = new MultiMsgRequest();
    paramChatMessage.jdField_a_of_type_Int = paramInt1;
    paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramBaseSessionInfo);
    paramChatMessage.jdField_a_of_type_JavaUtilList = localArrayList;
    paramChatMessage.jdField_a_of_type_JavaUtilMap = null;
    paramChatMessage.g = paramInt2;
    paramChatMessage.b = 8;
    paramChatMessage.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = new MessageForStructing();
    paramChatMessage.jdField_a_of_type_Boolean = paramBoolean;
    new ReplyMsgController(paramQQAppInterface).e(paramChatMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramMessageForMixedMsg == null) {
      return;
    }
    if (paramMessageForMixedMsg.getReplyMessage(paramQQAppInterface) != null)
    {
      new ArrayList(1).add(paramMessageForMixedMsg);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramMessageForMixedMsg);
      paramMessageForMixedMsg = new MultiMsgRequest();
      paramMessageForMixedMsg.jdField_a_of_type_Int = 0;
      paramMessageForMixedMsg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
      paramMessageForMixedMsg.jdField_a_of_type_JavaUtilList = localArrayList;
      paramMessageForMixedMsg.jdField_a_of_type_JavaUtilMap = null;
      paramMessageForMixedMsg.b = 9;
      paramMessageForMixedMsg.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = new MessageForStructing();
      new MixMsgController(paramQQAppInterface).e(paramMessageForMixedMsg);
      return;
    }
    ((MixedMsgManager)paramQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(paramSessionInfo, paramMessageForMixedMsg, false, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.replymsg.ReplyMsgSender
 * JD-Core Version:    0.7.0.1
 */