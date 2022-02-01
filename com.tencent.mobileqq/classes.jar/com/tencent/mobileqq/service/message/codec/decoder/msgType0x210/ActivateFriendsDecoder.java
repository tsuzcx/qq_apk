package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MemorialDayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo;

public class ActivateFriendsDecoder
  implements SubTypeDecoder
{
  @Nullable
  private static MessageRecord a(QQAppInterface paramQQAppInterface, SubMsgType0x76.MsgBody paramMsgBody, MessageRecord paramMessageRecord)
  {
    Object localObject = paramMsgBody.msg_memorialday_notify.rpt_anniversary_info.get();
    if (((List)localObject).size() > 0)
    {
      localObject = (SubMsgType0x76.OneMemorialDayInfo)((List)localObject).get(0);
      MessageForActivateFriends localMessageForActivateFriends = (MessageForActivateFriends)paramMessageRecord;
      localMessageForActivateFriends.msgBody = paramMsgBody;
      localMessageForActivateFriends.msgData = paramMsgBody.toByteArray();
      localMessageForActivateFriends.msg = ActivateFriendsManager.a(paramQQAppInterface.getApp(), paramMsgBody);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007AD4", "0X8007AD4", (int)((SubMsgType0x76.OneMemorialDayInfo)localObject).uint32_type.get(), 0, "", "", "", "");
      return paramMessageRecord;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends", 2, "Memorial friend list size = 0");
    }
    return null;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      if ((localObject instanceof MessageForActivateFriends))
      {
        localObject = (MessageForActivateFriends)localObject;
        if ((((MessageForActivateFriends)localObject).getMsgBody() == null) || (((MessageForActivateFriends)localObject).getMsgBody().uint32_msg_type.get() == paramInt)) {
          paramQQAppInterface.getMessageFacade().b(AppConstants.ACTIVATE_FRIENDS_UIN, 0, ((MessageForActivateFriends)localObject).uniseq);
        }
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("local data is error.");
        localStringBuilder.append(localObject);
        QLog.e("ActivateFriends.Processor", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = paramQQAppInterface.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 0);
    Object localObject1 = new SubMsgType0x76.MsgBody();
    int j;
    int i;
    try
    {
      ((SubMsgType0x76.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      j = ((SubMsgType0x76.MsgBody)localObject1).uint32_msg_type.get();
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("receive push, msg type = ");
        paramArrayOfByte.append(j);
        paramArrayOfByte.append(", local msg count = ");
        if (localObject2 == null) {
          break label475;
        }
        i = ((List)localObject2).size();
        paramArrayOfByte.append(i);
        QLog.d("ActivateFriends.Processor", 2, paramArrayOfByte.toString());
      }
      a(paramQQAppInterface, (List)localObject2, j);
      paramArrayOfByte = MessageRecordFactory.a(-5003);
      paramArrayOfByte.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramArrayOfByte.frienduin = AppConstants.ACTIVATE_FRIENDS_UIN;
      paramArrayOfByte.istroop = 9002;
      paramArrayOfByte.senderuin = "";
      localActivateFriendsManager = (ActivateFriendsManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
      if (j == 1)
      {
        paramArrayOfByte = b(paramQQAppInterface, (SubMsgType0x76.MsgBody)localObject1, paramArrayOfByte);
      }
      else if (j == 2)
      {
        paramArrayOfByte = c(paramQQAppInterface, (SubMsgType0x76.MsgBody)localObject1, paramArrayOfByte);
      }
      else
      {
        if (j != 3) {
          break label484;
        }
        paramArrayOfByte = a(paramQQAppInterface, (SubMsgType0x76.MsgBody)localObject1, paramArrayOfByte);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      ActivateFriendsManager localActivateFriendsManager;
      label214:
      if (!QLog.isColorLevel()) {
        break label473;
      }
      label276:
      QLog.d("ActivateFriends", 2, "parse push got error.", paramQQAppInterface);
    }
    if (j == 1) {
      localObject1 = "0X8004E03";
    } else {
      localObject1 = "0X8004E04";
    }
    if (j == 1) {
      localObject2 = "0X8004E03";
    } else {
      localObject2 = "0X8004E04";
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject2, localActivateFriendsManager.a, 0, "", "", "", "");
    if (paramArrayOfByte != null)
    {
      if (!QLog.isColorLevel()) {
        break label507;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("activiate_friends|rec msg  fromUin:");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" toUin:");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(" seq:");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("ActivateFriends", 2, ((StringBuilder)localObject1).toString());
    }
    label473:
    label475:
    label484:
    label507:
    for (;;)
    {
      paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_from_uin", String.valueOf(paramLong1));
      paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_to_uin", String.valueOf(paramLong2));
      paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_seq", String.valueOf(paramInt1));
      paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_type", String.valueOf(paramInt2));
      paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_sub_type", String.valueOf(paramInt3));
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramArrayOfByte);
      paramQQAppInterface.getMessageFacade().a((ArrayList)localObject1, paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.isBackgroundStop);
      localActivateFriendsManager.a(j);
      return true;
      return false;
      i = -1;
      break;
      for (;;)
      {
        break;
        paramArrayOfByte = null;
      }
      if ((j == 1) || (j == 2)) {
        break label214;
      }
      break label276;
    }
  }
  
  @Nullable
  private static MessageRecord b(QQAppInterface paramQQAppInterface, SubMsgType0x76.MsgBody paramMsgBody, MessageRecord paramMessageRecord)
  {
    if (paramMsgBody.msg_geographic_notify.rpt_msg_one_friend.get().size() > 0)
    {
      MessageForActivateFriends localMessageForActivateFriends = (MessageForActivateFriends)paramMessageRecord;
      localMessageForActivateFriends.msg = ActivateFriendsManager.a(paramQQAppInterface.getApp(), paramMsgBody);
      localMessageForActivateFriends.msgBody = paramMsgBody;
      localMessageForActivateFriends.msgData = paramMsgBody.toByteArray();
      return paramMessageRecord;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends", 2, "Geo friend list size = 0");
    }
    return null;
  }
  
  @Nullable
  private static MessageRecord c(QQAppInterface paramQQAppInterface, SubMsgType0x76.MsgBody paramMsgBody, MessageRecord paramMessageRecord)
  {
    Object localObject = paramMsgBody.msg_birthday_notify.rpt_msg_one_friend.get();
    if (((List)localObject).size() > 0)
    {
      MessageForActivateFriends localMessageForActivateFriends = (MessageForActivateFriends)paramMessageRecord;
      localMessageForActivateFriends.msgBody = paramMsgBody;
      localMessageForActivateFriends.msgData = paramMsgBody.toByteArray();
      localMessageForActivateFriends.msg = ActivateFriendsManager.a(paramQQAppInterface.getApp(), paramMsgBody);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends", 2, "Birth friend list size = 0");
      }
      paramMessageRecord = null;
    }
    paramMsgBody = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramMsgBody.add(String.valueOf(((SubMsgType0x76.OneBirthdayFriend)((Iterator)localObject).next()).uint64_uin.get()));
    }
    paramQQAppInterface.getMsgCache().a(paramMsgBody);
    return paramMessageRecord;
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    long l1 = paramMsg.msg_head.to_uin.get();
    long l2 = paramMsg.msg_head.from_uin.get();
    int i = paramMsg.msg_head.msg_seq.get();
    long l3 = paramMsg.msg_head.msg_uid.get();
    int j = paramMsg.msg_head.msg_type.get();
    if (a(paramMessageHandler.a, paramMsgType0x210.msg_content.get().toByteArray(), l2, l1, i, j, paramMsgType0x210.sub_msg_type.get())) {
      paramMessageHandler.a().a("handleActivateFriendsPush2", true, 1, true, false);
    }
    MessageProtoCodec.a(l2, i, l3, j, paramMessageHandler.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.ActivateFriendsDecoder
 * JD-Core Version:    0.7.0.1
 */