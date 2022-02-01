package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import Wallet.AcsMsg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForReminder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.SystemNotify;

public class ReminderDecoder
  implements SubTypeDecoder
{
  public final String a = "{\n        \"msg_id\":\"55ecbfd4d4ba6a744605361199cc7be7\",\n        \"ark_data\":{\n        \"app\":\"com.tencent.qqremind_anniversary\",\n        \"meta\":{\n        \"metaData\":{\n        \"friend_type\":\"1\",\n        \"friend_uin\":\"1\",\n        \"since_time\":0,\n        \"jump_url\":\"www.qq.com?token=xczczc\"\n        }\n        },\n        \"view\":\"1\"\n        }\n        }";
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = paramQQAppInterface.getMessageFacade().h(AppConstants.ACTIVATE_FRIENDS_UIN, 0).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForReminder))
      {
        paramQQAppInterface.getMessageFacade().h(AppConstants.ACTIVATE_FRIENDS_UIN, 0, localMessageRecord.uniseq);
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("local data is error.");
        localStringBuilder.append(localMessageRecord);
        QLog.e("ReminderDecoder", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, IQQReminderDataService paramIQQReminderDataService, submsgtype0x13a.MsgBody paramMsgBody, int paramInt)
  {
    paramMsgBody = new JSONObject(paramMsgBody.bytes_push_data.get().toStringUtf8());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[notify][push] multiple tskTriPushData: ");
      ((StringBuilder)localObject).append(paramMsgBody);
      QLog.d("ReminderDecoder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new AcsMsg();
    ((AcsMsg)localObject).msg_id = paramMsgBody.optString("msg_id");
    ((AcsMsg)localObject).type = paramInt;
    ((AcsMsg)localObject).title = paramMsgBody.getString("title");
    ((AcsMsg)localObject).content = paramMsgBody.getString("msg");
    ((AcsMsg)localObject).btn_text = paramMsgBody.getString("btn_text");
    ((AcsMsg)localObject).notice_time = paramLong;
    ((AcsMsg)localObject).sub_time = paramLong;
    paramInt = paramMsgBody.getInt("jump_type");
    if (paramInt == 0)
    {
      ((AcsMsg)localObject).jump_url = paramMsgBody.getString("jump_url");
    }
    else if (paramInt == 4)
    {
      ((AcsMsg)localObject).applet_jump_url = paramMsgBody.getString("jump_url");
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[notify][push] unknown jump type: ");
      localStringBuilder.append(paramInt);
      QLog.e("ReminderDecoder", 1, localStringBuilder.toString());
    }
    ((AcsMsg)localObject).banner_type = paramMsgBody.getInt("banner_type");
    ((AcsMsg)localObject).banner_url = paramMsgBody.getString("banner_url");
    ((AcsMsg)localObject).banner_type = paramMsgBody.getInt("banner_type");
    ((AcsMsg)localObject).mn_appid = paramMsgBody.optInt("mn_appid", 0);
    ((AcsMsg)localObject).mn_reserved = paramMsgBody.optString("mn_reserve", "");
    QQNotifyHelper.a(paramQQAppInterface, "remindmessage_push", null, ((AcsMsg)localObject).msg_id, null, ((AcsMsg)localObject).mn_reserved);
    paramIQQReminderDataService.doNotifyByPush((AcsMsg)localObject);
  }
  
  private void a(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, int paramInt, submsgtype0x13a.MsgBody paramMsgBody)
  {
    long l1 = paramMsg.msg_head.from_uin.get();
    int i = paramMsg.msg_head.msg_seq.get();
    long l2 = paramMsg.msg_head.to_uin.get();
    paramMsg = MessageRecordFactory.a(-7090);
    paramMsg.selfuin = paramQQAppInterface.getCurrentAccountUin();
    paramMsg.frienduin = AppConstants.ACTIVATE_FRIENDS_UIN;
    paramMsg.istroop = 9002;
    paramMsg.senderuin = "";
    paramMsg.time = paramMsgBody.uint32_timestamp.get();
    MessageForReminder localMessageForReminder = (MessageForReminder)paramMsg;
    localMessageForReminder.mMsgBody = paramMsgBody;
    localMessageForReminder.msgData = paramMsgBody.toByteArray();
    localMessageForReminder.msg = paramMsgBody.msg_system_notify.bytes_msg_summary.get().toStringUtf8();
    a(paramQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramMsgBody = new StringBuilder();
      paramMsgBody.append("activiate_friends|rec msg  fromUin:");
      paramMsgBody.append(l1);
      paramMsgBody.append(" toUin:");
      paramMsgBody.append(l2);
      paramMsgBody.append(" seq:");
      paramMsgBody.append(i);
      QLog.d("ActivateFriends", 2, paramMsgBody.toString());
    }
    paramMsg.saveExtInfoToExtStr("key_msg_ext_from_uin", String.valueOf(l1));
    paramMsg.saveExtInfoToExtStr("key_msg_ext_to_uin", String.valueOf(l2));
    paramMsg.saveExtInfoToExtStr("key_msg_ext_msg_seq", String.valueOf(i));
    paramMsg.saveExtInfoToExtStr("key_msg_ext_msg_type", String.valueOf(paramInt));
    paramMsg.saveExtInfoToExtStr("key_msg_need_notify", String.valueOf(true));
    paramMsg.saveExtInfoToExtStr("key_msg_notify_summary", localMessageForReminder.msg);
    paramMsgBody = new ArrayList();
    paramMsgBody.add(paramMsg);
    paramQQAppInterface.getMessageFacade().a(paramMsgBody, paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.isBackgroundStop);
    paramQQAppInterface.handleReceivedMessage(1, true, true);
  }
  
  private void a(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, short paramShort, long paramLong, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    IQQReminderDataService localIQQReminderDataService = (IQQReminderDataService)paramQQAppInterface.getRuntimeService(IQQReminderDataService.class, "");
    boolean bool = ((ActivateFriendsManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).b(paramShort);
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDecoder", 1, new Object[] { "isPushMessageDuplicated: ", Boolean.valueOf(bool) });
    }
    if (!bool)
    {
      submsgtype0x13a.MsgBody localMsgBody = new submsgtype0x13a.MsgBody();
      try
      {
        localMsgBody.mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
        int i = localMsgBody.uint32_push_type.get();
        if (i == 1)
        {
          a(paramQQAppInterface, paramLong, localIQQReminderDataService, localMsgBody, i);
          return;
        }
        if (i == 2)
        {
          a(paramQQAppInterface, paramMsg, i, localMsgBody);
          return;
        }
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("[notify][push] unknown push type: ");
        paramQQAppInterface.append(i);
        QLog.e("ReminderDecoder", 1, paramQQAppInterface.toString());
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("QQReminder", 2, "parse push got error.", paramQQAppInterface);
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ReminderDecoder", 1, new Object[] { "receive same message, seq = ", Short.valueOf(paramShort) });
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    a(paramMessageHandler.n, paramMsg, (short)paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), paramMsgType0x210);
    MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.ReminderDecoder
 * JD-Core Version:    0.7.0.1
 */