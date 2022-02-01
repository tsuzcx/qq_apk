package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x13b.submsgtype0x13b.MsgBody;

public class FilterMsgDecoder
  implements SubTypeDecoder
{
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterMsgDecoder", 2, "decode0x210Sub0x13b() called ");
    }
    submsgtype0x13b.MsgBody localMsgBody = new submsgtype0x13b.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX);
      if ((localMsgBody.op.has()) && (localMsgBody.uint64_mute_friend.has()))
      {
        long l = localMsgBody.uint64_mute_friend.get();
        if (localMsgBody.op.get() == 2)
        {
          paramArrayOfByte.a(String.valueOf(l), paramQQAppInterface);
          paramArrayOfByte.b(String.valueOf(l));
        }
        if (localMsgBody.op.get() == 3)
        {
          paramArrayOfByte.c(String.valueOf(l));
          paramArrayOfByte.a(String.valueOf(l));
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FilterMsgDecoder", 2, "parse error.", paramQQAppInterface);
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    a(paramMessageHandler.a, paramMsgType0x210.msg_content.get().toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.FilterMsgDecoder
 * JD-Core Version:    0.7.0.1
 */