package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.av.VideoConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class MultiVideoDecoder
  implements Decoder<MessageHandler>
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if (!paramDecodeProtoPkgContext.d)
    {
      if (!VideoConstants.a) {
        return;
      }
      long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      paramList = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
      if (QLog.isColorLevel())
      {
        paramDecodeProtoPkgContext = new StringBuilder();
        paramDecodeProtoPkgContext.append("decodeC2CMsgPkg_MultiVideo, msg[");
        paramDecodeProtoPkgContext.append(l);
        paramDecodeProtoPkgContext.append("]");
        QLog.d("AVMsg", 2, paramDecodeProtoPkgContext.toString());
      }
      paramMessageHandler.a.getGAudioHandler().a(paramList, paramMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.MultiVideoDecoder
 * JD-Core Version:    0.7.0.1
 */