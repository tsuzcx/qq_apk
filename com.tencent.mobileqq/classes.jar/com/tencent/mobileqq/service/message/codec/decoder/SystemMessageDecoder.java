package com.tencent.mobileqq.service.message.codec.decoder;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class SystemMessageDecoder
  implements Decoder<MessageHandler>
{
  private static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
    {
      long l1 = Long.valueOf(paramMessageHandler.n.getCurrentAccountUin()).longValue();
      long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
      short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
      if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
        paramMessageHandler.B().a(l1, l2, s, -1006 - (s - 187), paramMsg, paramInt);
      }
      Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (localObject != null)
      {
        paramMsg = new StringBuilder();
        paramMsg.append("");
        paramMsg.append(((msg_comm.MsgHead)localObject).auth_uin.get());
        paramMsg = paramMsg.toString();
        String str = ((msg_comm.MsgHead)localObject).auth_nick.get();
        localObject = ((msg_comm.MsgHead)localObject).auth_remark.get();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("FriendSys auUin:");
          localStringBuilder.append(paramMsg);
          localStringBuilder.append("aunick:");
          localStringBuilder.append(str);
          localStringBuilder.append("auRemark:");
          localStringBuilder.append((String)localObject);
          QLog.d("SystemMessageDecoder.sysnick", 2, localStringBuilder.toString());
        }
        if ((!TextUtils.isEmpty(paramMsg)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SystemMessageDecoder.sysremark", 2, "FriendSys saveremark");
          }
          paramMessageHandler.b(paramMsg, (String)localObject);
        }
        if ((!TextUtils.isEmpty(paramMsg)) && (!TextUtils.isEmpty(str)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SystemMessageDecoder.sysnick", 2, "FriendSys savenick");
          }
          paramMessageHandler.a(paramMsg, str);
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append("<---decodeC2CMsgPkg_AddFriend return null:hasBody:");
      paramMessageHandler.append(paramMsg.msg_body.has());
      paramMessageHandler.append(",hasMsgContent");
      paramMessageHandler.append(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      paramMessageHandler.append(",isReaded:");
      paramMessageHandler.append(paramBoolean1);
      paramMessageHandler.append("syncOther:");
      paramMessageHandler.append(paramBoolean2);
      QLog.e("SystemMessageDecoder", 2, paramMessageHandler.toString());
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "friend system msg notify");
    }
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int j = (short)paramList.msg_seq.get();
    long l1 = paramList.from_uin.get();
    long l2 = paramList.msg_uid.get();
    int k = paramList.msg_type.get();
    int i = 0;
    if ((k == 188) || (k == 189)) {
      i = 1;
    }
    if ((!paramDecodeProtoPkgContext.i) && (i == 0)) {
      paramMessageHandler.B().a(2);
    }
    paramDecodeProtoPkgContext.x = 9998L;
    a(paramMessageHandler, paramMsg, paramDecodeProtoPkgContext.g, paramDecodeProtoPkgContext.l, paramDecodeProtoPkgContext.j, j);
    MessageProtoCodec.a(l1, j, l2, k, paramMessageHandler.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.SystemMessageDecoder
 * JD-Core Version:    0.7.0.1
 */