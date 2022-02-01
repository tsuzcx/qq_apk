package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.message.DiscMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.MsgBody;

public class DiscussionUpdateDecoder
  implements Decoder<MessageHandler>
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((paramList == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          paramMsg = paramMsg.msg_body.msg_content.get().toByteArray();
          PkgTools.getLongData(paramMsg, 0);
          i = paramMsg[4];
          if (i != 25) {
            break;
          }
        } while (paramDecodeProtoPkgContext.d);
        DiscMessageProcessor.a(paramMessageHandler.a, paramMsg, 5, null, false);
        return;
      } while (i != 35);
      QLog.i("ApolloPushManager", 1, "[discuss.OffLine]");
    } while (paramDecodeProtoPkgContext.d);
    DiscMessageProcessor.b(paramMessageHandler.a, paramMsg, 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.DiscussionUpdateDecoder
 * JD-Core Version:    0.7.0.1
 */