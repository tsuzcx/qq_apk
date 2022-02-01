package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.av.core.AVMsgUtil;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class VideoDecoder
  implements Decoder<MessageHandler>
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if (paramDecodeProtoPkgContext.d) {
      return;
    }
    if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) && (!paramDecodeProtoPkgContext.a) && (!paramDecodeProtoPkgContext.f))
    {
      long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
      long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
      long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
      long l5 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
      Long.valueOf(paramMessageHandler.a.getCurrentAccountUin()).longValue();
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append(l1);
      paramMessageHandler.append("-");
      paramMessageHandler.append(l5);
      paramMessageHandler.append("-");
      paramMessageHandler.append(l4);
      paramMessageHandler.append("-");
      paramMessageHandler.append(l3);
      paramMessageHandler = paramMessageHandler.toString();
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("<---decodeC2CMsgPkg_Video :  key:");
        paramList.append(paramMessageHandler);
        QLog.d("VideoDecoder", 2, paramList.toString());
      }
      paramMessageHandler = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      l2 = MessageCache.a() - l2;
      int i = AVMsgUtil.a(paramMessageHandler);
      if (!VcSystemInfo.isSupportSharpAudio())
      {
        if (QLog.isColorLevel()) {
          QLog.d("svenxu", 2, "Discard video message cause device not support");
        }
      }
      else if (l2 >= 60L)
      {
        if (QLog.isColorLevel())
        {
          paramMessageHandler = new StringBuilder();
          paramMessageHandler.append("Discard video message because of time out ");
          paramMessageHandler.append(l2);
          paramMessageHandler.append(" s");
          QLog.d("svenxu", 2, paramMessageHandler.toString());
        }
      }
      else
      {
        paramMessageHandler = (HashMap)paramDecodeProtoPkgContext.a(1000);
        paramList = (HashSet)paramDecodeProtoPkgContext.a(1001);
        if (i == 1)
        {
          if (!VcSystemInfo.isSupportSharpAudio())
          {
            if (QLog.isColorLevel()) {
              QLog.d("shanezhaiSHARP", 2, "discard video push message because the sdk is lower");
            }
            return;
          }
          if (paramMessageHandler != null) {
            paramMessageHandler.put(Long.valueOf(l1), paramMsg);
          }
        }
        else if (i == 3)
        {
          if (!VcSystemInfo.isSupportSharpAudio()) {
            return;
          }
          if (paramList != null) {
            paramList.add(Long.valueOf(l1));
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessageHandler = new StringBuilder();
      paramMessageHandler.append("<---decodeC2CMsgPkg_Video return null:hasBody:");
      paramMessageHandler.append(paramMsg.msg_body.has());
      paramMessageHandler.append(",hasMsgContent");
      paramMessageHandler.append(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      paramMessageHandler.append(",isReaded:");
      paramMessageHandler.append(paramDecodeProtoPkgContext.a);
      paramMessageHandler.append("syncOther:");
      paramMessageHandler.append(paramDecodeProtoPkgContext.f);
      QLog.e("VideoDecoder", 2, paramMessageHandler.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */