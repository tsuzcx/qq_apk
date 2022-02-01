package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;

public class SecSpyFileDecoder
  implements SubTypeDecoder
{
  public static void a(int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnLinePushMessageProcessor receive 0x7c push message, seq = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("submsgtype:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("SecSpyFileDecoder", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new submsgtype0x7c.MsgBody();
    try
    {
      ((submsgtype0x7c.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      long l = ((submsgtype0x7c.MsgBody)localObject).uint64_uin.get();
      if (paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l)))
      {
        ((SecSpyFileManager)paramQQAppInterface.getManager(QQManagerFactory.SEC_SPY_FILEMANAGER)).a((submsgtype0x7c.MsgBody)localObject, 3);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SecSpyFileDecoder", 2, "parse 0x7c push msg error", paramQQAppInterface);
      }
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    int i = paramMsg.msg_head.msg_seq.get();
    int j = paramMsg.msg_head.msg_type.get();
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    a(i, j, paramMessageHandler.n, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.SecSpyFileDecoder
 * JD-Core Version:    0.7.0.1
 */