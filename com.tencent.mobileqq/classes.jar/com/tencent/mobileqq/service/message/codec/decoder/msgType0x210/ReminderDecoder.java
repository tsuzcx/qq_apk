package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import Wallet.AcsMsg;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.MsgBody;

public class ReminderDecoder
  implements SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, short paramShort, long paramLong, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    IQQReminderDataService localIQQReminderDataService = (IQQReminderDataService)paramQQAppInterface.getRuntimeService(IQQReminderDataService.class, "");
    boolean bool = ((ActivateFriendsManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(paramShort);
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDecoder", 1, new Object[] { "isPushMessageDuplicated: ", Boolean.valueOf(bool) });
    }
    if (!bool)
    {
      Object localObject = new submsgtype0x13a.MsgBody();
      int i;
      for (;;)
      {
        try
        {
          ((submsgtype0x13a.MsgBody)localObject).mergeFrom(paramMsgType0x210.msg_content.get().toByteArray());
          i = ((submsgtype0x13a.MsgBody)localObject).uint32_push_type.get();
          if (i != 1) {
            break;
          }
          paramMsgType0x210 = new JSONObject(((submsgtype0x13a.MsgBody)localObject).bytes_push_data.get().toStringUtf8());
          if (QLog.isColorLevel()) {
            QLog.d("ReminderDecoder", 2, "[notify][push] multiple tskTriPushData: " + paramMsgType0x210);
          }
          localObject = new AcsMsg();
          ((AcsMsg)localObject).msg_id = paramMsgType0x210.optString("msg_id");
          ((AcsMsg)localObject).type = i;
          ((AcsMsg)localObject).title = paramMsgType0x210.getString("title");
          ((AcsMsg)localObject).content = paramMsgType0x210.getString("msg");
          ((AcsMsg)localObject).btn_text = paramMsgType0x210.getString("btn_text");
          ((AcsMsg)localObject).notice_time = paramLong;
          ((AcsMsg)localObject).sub_time = paramLong;
          i = paramMsgType0x210.getInt("jump_type");
          if (i == 0)
          {
            ((AcsMsg)localObject).jump_url = paramMsgType0x210.getString("jump_url");
            ((AcsMsg)localObject).banner_type = paramMsgType0x210.getInt("banner_type");
            ((AcsMsg)localObject).banner_url = paramMsgType0x210.getString("banner_url");
            ((AcsMsg)localObject).banner_type = paramMsgType0x210.getInt("banner_type");
            ((AcsMsg)localObject).mn_appid = paramMsgType0x210.optInt("mn_appid", 0);
            ((AcsMsg)localObject).mn_reserved = paramMsgType0x210.optString("mn_reserve", "");
            QQNotifyHelper.a(paramQQAppInterface, "remindmessage_push", null, ((AcsMsg)localObject).msg_id, null, ((AcsMsg)localObject).mn_reserved);
            localIQQReminderDataService.doNotifyByPush((AcsMsg)localObject);
            return;
          }
          if (i != 4) {
            break label388;
          }
          ((AcsMsg)localObject).applet_jump_url = paramMsgType0x210.getString("jump_url");
          continue;
          QLog.d("QQReminder", 2, "parse push got error.", paramQQAppInterface);
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        return;
        label388:
        QLog.e("ReminderDecoder", 1, "[notify][push] unknown jump type: " + i);
      }
      QLog.e("ReminderDecoder", 1, "[notify][push] unknown push type: " + i);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReminderDecoder", 1, new Object[] { "receive same message, seq = ", Short.valueOf(paramShort) });
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    a(paramMessageHandler.a, (short)paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_time.get(), paramMsgType0x210);
    MessageProtoCodec.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.ReminderDecoder
 * JD-Core Version:    0.7.0.1
 */