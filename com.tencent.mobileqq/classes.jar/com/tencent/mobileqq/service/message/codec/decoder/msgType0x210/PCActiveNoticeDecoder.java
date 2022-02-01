package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b.MsgBody;

public class PCActiveNoticeDecoder
  implements SubTypeDecoder
{
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Push_PCActive_Notice_Decode", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    try
    {
      localObject = new SubMsgType0x6b.MsgBody();
      ((SubMsgType0x6b.MsgBody)localObject).mergeFrom(paramMsgType0x210);
      l = ((SubMsgType0x6b.MsgBody)localObject).uint64_to_uin.get();
      paramMsgType0x210 = BaseApplicationImpl.getApplication();
      paramList = Long.toString(l);
      paramDecodeProtoPkgContext = null;
      if (SettingCloneUtil.readValue(paramMsgType0x210, paramList, null, "qqsetting_pcactive_key", false)) {
        break label298;
      }
      boolean bool = ((SubMsgType0x6b.MsgBody)localObject).bytes_tips_content.has();
      if (!bool) {
        break label355;
      }
      paramMsgType0x210 = new String(((SubMsgType0x6b.MsgBody)localObject).bytes_tips_content.get().toByteArray(), "utf-8");
    }
    catch (InvalidProtocolBufferMicroException paramMsgType0x210)
    {
      Object localObject;
      long l;
      break label284;
    }
    catch (UnsupportedEncodingException paramMsgType0x210)
    {
      for (;;)
      {
        label284:
        label298:
        continue;
        paramMsgType0x210 = null;
        continue;
        paramList = null;
      }
    }
    if (((SubMsgType0x6b.MsgBody)localObject).bytes_yes_text.has())
    {
      paramList = new String(((SubMsgType0x6b.MsgBody)localObject).bytes_yes_text.get().toByteArray(), "utf-8");
      if (((SubMsgType0x6b.MsgBody)localObject).bytes_no_text.has()) {
        paramDecodeProtoPkgContext = new String(((SubMsgType0x6b.MsgBody)localObject).bytes_no_text.get().toByteArray(), "utf-8");
      }
      BaseApplicationImpl.getApplication().setPCActiveNotice(Long.toString(l), paramMsgType0x210, paramDecodeProtoPkgContext, paramList);
      localObject = new Intent("mqq.intent.action.PCACTIVE_TIPS");
      ((Intent)localObject).putExtra("uin", Long.toString(l));
      ((Intent)localObject).putExtra("Message", paramMsgType0x210);
      ((Intent)localObject).putExtra("lButton", paramDecodeProtoPkgContext);
      ((Intent)localObject).putExtra("rButton", paramList);
      if (NotifyPCActiveActivity.a == null)
      {
        BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
        break label298;
        if (QLog.isColorLevel())
        {
          QLog.d("Push_PCActive_Notice_Decode", 2, "failed to parse msg0x210.SubMsgType0x6b");
          break label298;
          if (QLog.isColorLevel()) {
            QLog.d("Push_PCActive_Notice_Decode", 2, "failed to get msg0x210.SubMsgType0x6b");
          }
        }
      }
      MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.b());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.PCActiveNoticeDecoder
 * JD-Core Version:    0.7.0.1
 */