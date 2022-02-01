package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;

public class DevLockQuickLoginDecoder
  implements SubTypeDecoder
{
  private void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv msg0x210.Submsgtype0x51");
    }
    if (paramMsgType0x210.sub_msg_type.get() != 81)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush submsgtype != 0x51");
      }
      return;
    }
    if (paramMsgType0x210.msg_content == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush msg_content is null");
      }
      return;
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    if (paramMsgType0x210 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush decode ox210Stream is null");
      }
      return;
    }
    new SubMsgType0x51.MsgBody();
    try
    {
      localObject = new SubMsgType0x51.MsgBody();
      ((SubMsgType0x51.MsgBody)localObject).mergeFrom(paramMsgType0x210);
      boolean bool = ((SubMsgType0x51.MsgBody)localObject).bytes_qrsig_url.has();
      arrayOfByte = null;
      if (!bool) {
        break label362;
      }
      paramMsgType0x210 = new String(((SubMsgType0x51.MsgBody)localObject).bytes_qrsig_url.get().toByteArray(), "utf-8");
    }
    catch (Exception paramMsgType0x210)
    {
      for (;;)
      {
        Object localObject;
        byte[] arrayOfByte;
        continue;
        paramMsgType0x210 = null;
        continue;
        paramMsg = null;
        continue;
        String str = null;
      }
    }
    if (((SubMsgType0x51.MsgBody)localObject).bytes_hint1.has())
    {
      paramMsg = new String(((SubMsgType0x51.MsgBody)localObject).bytes_hint1.get().toByteArray(), "utf-8");
      if (!((SubMsgType0x51.MsgBody)localObject).bytes_hint2.has()) {
        break label372;
      }
      str = new String(((SubMsgType0x51.MsgBody)localObject).bytes_hint2.get().toByteArray(), "utf-8");
      if (((SubMsgType0x51.MsgBody)localObject).bytes_login_conf.has()) {
        arrayOfByte = ((SubMsgType0x51.MsgBody)localObject).bytes_login_conf.get().toByteArray();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeDevlockQuickLoginPush recv devlock quicklogin push qrcode=");
        ((StringBuilder)localObject).append(paramMsgType0x210);
        ((StringBuilder)localObject).append(" maintip=");
        ((StringBuilder)localObject).append(paramMsg);
        ((StringBuilder)localObject).append(" smalltip");
        ((StringBuilder)localObject).append(str);
        QLog.d("DevLock", 2, ((StringBuilder)localObject).toString());
      }
      EquipmentLockImpl.a().a(paramMessageHandler.a, paramMsgType0x210, paramMsg, str, arrayOfByte);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
      }
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevLockQuickLoginDecoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x51");
    }
    a(paramMsgType0x210, paramMsg, paramMessageHandler);
    MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.DevLockQuickLoginDecoder
 * JD-Core Version:    0.7.0.1
 */