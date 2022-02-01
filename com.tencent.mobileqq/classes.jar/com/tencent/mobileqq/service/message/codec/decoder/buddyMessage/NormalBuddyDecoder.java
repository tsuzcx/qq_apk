package com.tencent.mobileqq.service.message.codec.decoder.buddyMessage;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.codec.decoder.Decoder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class NormalBuddyDecoder
  implements Decoder<MessageHandler>
{
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
    {
      if (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()) {
        return;
      }
      if (!paramMsg.content_head.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("NormalBuddyDecoder", 2, "<---decodeC2CMessagePackage: msg doesn't has the contentHead.");
        }
        return;
      }
      Object localObject = (msg_comm.ContentHead)paramMsg.content_head.get();
      paramBoolean3 = ((msg_comm.ContentHead)localObject).auto_reply.has();
      paramBoolean2 = true;
      if ((!paramBoolean3) || (((msg_comm.ContentHead)localObject).auto_reply.get() != 1)) {
        paramBoolean2 = false;
      }
      localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("<---decodeC2CMsgPkg_Buddy:elems size:");
        localStringBuilder.append(((List)localObject).size());
        localStringBuilder.append(" isAutoReply:");
        localStringBuilder.append(paramBoolean2);
        QLog.d("NormalBuddyDecoder", 2, localStringBuilder.toString());
      }
      if (paramBoolean2)
      {
        if (localObject != null)
        {
          if (((List)localObject).size() <= 0) {
            return;
          }
          paramMessageHandler = BaseApplicationImpl.getApplication().getString(2131887155);
          paramMsg = new MessagePBElemDecoder().a((List)localObject);
          if (TextUtils.isEmpty(paramMsg)) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramMessageHandler);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramMsg);
          paramMessageHandler = ((StringBuilder)localObject).toString();
          paramMsg = MessageRecordFactory.a(-10000);
          paramMsg.msgtype = -10000;
          paramMsg.msg = paramMessageHandler;
          paramList.add(paramMsg);
        }
      }
      else {
        MessageProtoCodec.a(paramMessageHandler, paramList, paramMsg, true, paramBoolean1, null);
      }
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a(paramMessageHandler, paramList, paramMsg, paramDecodeProtoPkgContext.x, paramDecodeProtoPkgContext.h, paramDecodeProtoPkgContext.g, paramDecodeProtoPkgContext.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.NormalBuddyDecoder
 * JD-Core Version:    0.7.0.1
 */