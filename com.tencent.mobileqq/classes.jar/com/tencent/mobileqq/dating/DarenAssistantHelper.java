package com.tencent.mobileqq.dating;

import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.darenassistant.pb.DarenAssistantMsg.MsgBody;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class DarenAssistantHelper
{
  public static MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    Object localObject = null;
    if (paramArrayOfByte != null)
    {
      try
      {
        DarenAssistantMsg.MsgBody localMsgBody = new DarenAssistantMsg.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (MessageForDarenAssistant)MessageRecordFactory.a(-2068);
        paramArrayOfByte.msg = localMsgBody.bytes_wording.get().toStringUtf8();
        paramArrayOfByte.jumpUrl = localMsgBody.bytes_jump_url.get().toStringUtf8();
        long l2 = localMsgBody.uint32_update_time.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = paramMsgInfo.uRealMsgTime;
        }
        paramArrayOfByte.time = l1;
        paramArrayOfByte.msgseq = l1;
        paramArrayOfByte.shmsgseq = paramMsgInfo.shMsgSeq;
        paramArrayOfByte.msgUid = paramMsgInfo.lMsgUid;
        paramArrayOfByte.selfuin = paramQQAppInterface.getCurrentAccountUin();
        paramArrayOfByte.istroop = 1001;
        paramArrayOfByte.isread = false;
        paramArrayOfByte.frienduin = AppConstants.LBS_HELLO_UIN;
        paramArrayOfByte.senderuin = AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN;
        paramArrayOfByte.getBytes();
        try
        {
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("decodePush0x210_0x100,decodeDarenAssistantMsg ");
            paramQQAppInterface.append("msg=");
            paramQQAppInterface.append(localMsgBody.bytes_wording.get().toStringUtf8());
            paramQQAppInterface.append(",jumpUrl=");
            paramQQAppInterface.append(localMsgBody.bytes_jump_url.get().toStringUtf8());
            paramQQAppInterface.append(",updateTime=");
            paramQQAppInterface.append(localMsgBody.uint32_update_time.get());
            paramQQAppInterface.append(",fromUin=");
            paramQQAppInterface.append(paramMsgInfo.lFromUin);
            QLog.i("DarenAssistantHelper", 2, paramQQAppInterface.toString());
          }
          return paramArrayOfByte;
        }
        catch (InvalidProtocolBufferMicroException paramMsgInfo)
        {
          paramQQAppInterface = paramArrayOfByte;
          paramArrayOfByte = paramMsgInfo;
        }
        paramMsgInfo = new StringBuilder();
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramQQAppInterface = localObject;
      }
      paramMsgInfo.append("decodePush0x210_0x100 decode error, e=");
      paramMsgInfo.append(paramArrayOfByte.toString());
      QLog.i("DarenAssistantHelper", 1, paramMsgInfo.toString());
      return paramQQAppInterface;
    }
    QLog.i("DarenAssistantHelper", 1, "decodePush0x210_0x100 pbData = null");
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    Object localObject = null;
    if (paramArrayOfByte != null)
    {
      try
      {
        DarenAssistantMsg.MsgBody localMsgBody = new DarenAssistantMsg.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (MessageForDarenAssistant)MessageRecordFactory.a(-2068);
        paramArrayOfByte.msg = localMsgBody.bytes_wording.get().toStringUtf8();
        paramArrayOfByte.jumpUrl = localMsgBody.bytes_jump_url.get().toStringUtf8();
        long l2 = localMsgBody.uint32_update_time.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        }
        paramArrayOfByte.time = l1;
        paramArrayOfByte.msgseq = l1;
        paramArrayOfByte.shmsgseq = paramMsg.msg_head.msg_seq.get();
        paramArrayOfByte.msgUid = paramMsg.msg_head.msg_uid.get();
        paramArrayOfByte.selfuin = paramQQAppInterface.getCurrentAccountUin();
        paramArrayOfByte.istroop = 1001;
        paramArrayOfByte.isread = false;
        paramArrayOfByte.frienduin = AppConstants.LBS_HELLO_UIN;
        paramArrayOfByte.senderuin = AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN;
        paramArrayOfByte.getBytes();
        try
        {
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("decodePull0x210_0x100, decodeDarenAssistantMsg ");
            paramQQAppInterface.append("msg=");
            paramQQAppInterface.append(localMsgBody.bytes_wording.get().toStringUtf8());
            paramQQAppInterface.append(",jumpUrl=");
            paramQQAppInterface.append(localMsgBody.bytes_jump_url.get().toStringUtf8());
            paramQQAppInterface.append(",updateTime=");
            paramQQAppInterface.append(localMsgBody.uint32_update_time.get());
            paramQQAppInterface.append(",fromUin=");
            paramQQAppInterface.append(paramMsg.msg_head.from_uin.get());
            QLog.i("DarenAssistantHelper", 2, paramQQAppInterface.toString());
          }
          return paramArrayOfByte;
        }
        catch (InvalidProtocolBufferMicroException paramMsg)
        {
          paramQQAppInterface = paramArrayOfByte;
          paramArrayOfByte = paramMsg;
        }
        paramMsg = new StringBuilder();
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramQQAppInterface = localObject;
      }
      paramMsg.append("decodePull0x210_0x100 decode error, e=");
      paramMsg.append(paramArrayOfByte.toString());
      QLog.i("DarenAssistantHelper", 1, paramMsg.toString());
      return paramQQAppInterface;
    }
    QLog.i("DarenAssistantHelper", 1, "decodePull0x210_0x100 pbData = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DarenAssistantHelper
 * JD-Core Version:    0.7.0.1
 */