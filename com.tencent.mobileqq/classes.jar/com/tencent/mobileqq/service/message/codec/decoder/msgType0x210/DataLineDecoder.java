package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;

public class DataLineDecoder
  implements SubTypeDecoder
{
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineDecoder", 2, "<---decodeC2CMsgPkg_Dataline");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        paramMessageHandler = new StringBuilder();
        paramMessageHandler.append("<---decodeC2CMsgPkg_Dataline: return isReaded4DataLine:");
        paramMessageHandler.append(paramBoolean);
        QLog.e("DataLineDecoder", 2, paramMessageHandler.toString());
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DataLineDecoder.1(this, paramMessageHandler, paramMsg));
      return;
    }
    ((DataLineHandler)paramMessageHandler.n.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramMsg);
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    a(paramMessageHandler, paramMsg, paramDecodeProtoPkgContext.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.DataLineDecoder
 * JD-Core Version:    0.7.0.1
 */