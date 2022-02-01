package com.tencent.mobileqq.service.message.codec.decoder.buddyMessage;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.codec.decoder.Decoder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class OnlineFileDecoder
  implements Decoder<MessageHandler>
{
  private void a(MessageHandler paramMessageHandler, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt1, im_msg_body.MsgBody paramMsgBody, int paramInt2, long paramLong3, short paramShort, String paramString)
  {
    paramMsgBody = paramMessageHandler.n.getFileTransferHandler().b(paramMsgBody.msg_content.get().toByteArray());
    if (paramMsgBody != null)
    {
      if (!paramMessageHandler.n.getFileTransferHandler().b(paramMsgBody))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x85  is error.");
        }
        return;
      }
      paramMessageHandler.n.getFileTransferHandler().b(paramInt2, String.valueOf(paramLong1), paramString, paramLong3, paramShort, paramBoolean, 0, null, paramMsgBody, paramLong2, paramInt1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
    }
  }
  
  private void a(MessageHandler paramMessageHandler, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, int paramInt1, im_msg_body.MsgBody paramMsgBody, int paramInt2, Long paramLong, long paramLong3, short paramShort, String paramString1, String paramString2)
  {
    if (paramString2.equalsIgnoreCase(String.valueOf(paramLong)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.it is from self!!!");
      }
      return;
    }
    if (paramBoolean2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OnlineFileDecoder", 2, "recv roam online msg, return!");
      }
      return;
    }
    paramMsgBody = paramMessageHandler.n.getFileTransferHandler().a(paramMsgBody.msg_content.get().toByteArray());
    if (paramMsgBody != null)
    {
      if (!paramMessageHandler.n.getFileTransferHandler().b(paramMsgBody))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.");
        }
        return;
      }
      if (!paramMsgBody.l)
      {
        if (QLog.isColorLevel()) {
          QLog.w("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81. requset is no mulitend olfile.");
        }
        return;
      }
      paramMessageHandler.n.getFileTransferHandler().b(paramInt2, String.valueOf(paramLong1), paramString1, paramLong3, paramShort, paramBoolean1, 0, null, paramMsgBody, paramLong2, paramInt1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x81 failed.");
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, int paramInt)
  {
    im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
    Long localLong1 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    Long localLong2 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    paramMsg = localLong1.toString();
    String str = paramMessageHandler.n.getCurrentAccountUin();
    if (i == 129)
    {
      if ((paramMsg.equals(String.valueOf(localLong2))) && (paramMsg.equals(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile recv  a 0x81 that is from self.");
        }
        return;
      }
    }
    else if (str.equals(String.valueOf(localLong1))) {
      paramMsg = String.valueOf(localLong2);
    } else {
      paramMsg = String.valueOf(localLong1);
    }
    if (i != 129)
    {
      if (i != 131)
      {
        if (i != 133) {
          return;
        }
        a(paramMessageHandler, paramLong1, paramBoolean1, paramLong2, paramInt, localMsgBody, i, l, s, paramMsg);
        return;
      }
      b(paramMessageHandler, paramLong1, paramBoolean1, paramLong2, paramInt, localMsgBody, i, l, s, paramMsg);
      return;
    }
    a(paramMessageHandler, paramLong1, paramBoolean1, paramBoolean2, paramLong2, paramInt, localMsgBody, i, localLong1, l, s, paramMsg, str);
  }
  
  private void b(MessageHandler paramMessageHandler, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt1, im_msg_body.MsgBody paramMsgBody, int paramInt2, long paramLong3, short paramShort, String paramString)
  {
    paramMsgBody = paramMessageHandler.n.getFileTransferHandler().a(paramMsgBody.msg_content.get().toByteArray());
    if (paramMsgBody != null)
    {
      if (!paramMessageHandler.n.getFileTransferHandler().b(paramMsgBody))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x83  is error.");
        }
        return;
      }
      paramMessageHandler.n.getFileTransferHandler().b(paramInt2, String.valueOf(paramLong1), paramString, paramLong3, paramShort, paramBoolean, 0, null, paramMsgBody, paramLong2, paramInt1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x83 failed.");
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a(paramMessageHandler, paramMsg, paramDecodeProtoPkgContext.x, paramDecodeProtoPkgContext.g, paramDecodeProtoPkgContext.h, paramDecodeProtoPkgContext.d, paramDecodeProtoPkgContext.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.OnlineFileDecoder
 * JD-Core Version:    0.7.0.1
 */