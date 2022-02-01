package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class TroopSystemMessageDecoder
  implements Decoder<MessageHandler>
{
  private long a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopSystemMessageDecoder", 2, "<---decodeC2CMsgPkg_GroupSys");
    }
    boolean bool = paramMsg.msg_body.has();
    long l2 = 0L;
    if ((bool) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
    {
      Long.valueOf(paramMessageHandler.n.getCurrentAccountUin()).longValue();
      long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
      int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
      byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      long l1 = l2;
      if (arrayOfByte != null)
      {
        l1 = l2;
        if (arrayOfByte.length > 0) {
          l1 = PkgTools.getLongData(arrayOfByte, 0);
        }
      }
      Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (localObject != null)
      {
        localObject = ((msg_comm.MsgHead)localObject).group_name.get();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("TroopCode:");
          localStringBuilder.append(l1);
          localStringBuilder.append("TroopName:");
          localStringBuilder.append((String)localObject);
          QLog.d("TroopSystemMessageDecoder.sysnick", 2, localStringBuilder.toString());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l1);
        paramMessageHandler.c(localStringBuilder.toString(), (String)localObject);
      }
      if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
        paramMessageHandler.B().a(i, arrayOfByte, l3, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), (msg_comm.MsgHead)paramMsg.msg_head.get());
      }
      return l1;
    }
    if (QLog.isColorLevel())
    {
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append("<---decodeC2CMsgPkg_GroupSys return null:hasBody:");
      paramMessageHandler.append(paramMsg.msg_body.has());
      paramMessageHandler.append(",hasMsgContent");
      paramMessageHandler.append(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      paramMessageHandler.append(",isReaded:");
      paramMessageHandler.append(paramBoolean1);
      paramMessageHandler.append("syncOther:");
      paramMessageHandler.append(paramBoolean2);
      QLog.e("TroopSystemMessageDecoder", 2, paramMessageHandler.toString());
    }
    return 0L;
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = paramList.from_uin.get();
    long l2 = paramList.msg_time.get();
    int i = paramList.msg_type.get();
    if ((i != 85) && (i != 36)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((!paramDecodeProtoPkgContext.i) && (i == 0)) {
      paramMessageHandler.B().a(3, 1, false);
    }
    paramDecodeProtoPkgContext.x = 9998L;
    a(paramMessageHandler, paramMsg, paramDecodeProtoPkgContext.g, paramDecodeProtoPkgContext.l, paramDecodeProtoPkgContext.j);
    if (i == 0) {
      GroupSystemMsgController.a().a(l1, l2, paramMessageHandler.n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.TroopSystemMessageDecoder
 * JD-Core Version:    0.7.0.1
 */