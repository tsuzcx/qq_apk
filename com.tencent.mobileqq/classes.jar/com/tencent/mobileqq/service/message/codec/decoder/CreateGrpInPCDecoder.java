package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.troop.api.handler.ITroopBatchInfohandler;
import com.tencent.mobileqq.util.EndianUtil;
import com.tencent.mobileqq.util.Utils;
import java.util.List;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class CreateGrpInPCDecoder
  implements Decoder<MessageHandler>
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i = (short)paramList.msg_seq.get();
    long l1 = paramList.from_uin.get();
    long l2 = paramList.msg_uid.get();
    int j = paramList.msg_type.get();
    paramMsg = String.valueOf(Utils.a(EndianUtil.a(paramMsg.msg_body.msg_content.get().toByteArray())));
    paramList = (TroopManager)paramMessageHandler.a.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramList != null) && (paramList.b(paramMsg) == null))
    {
      paramDecodeProtoPkgContext = new TroopInfo();
      paramDecodeProtoPkgContext.troopuin = paramMsg;
      paramDecodeProtoPkgContext.troopcode = paramMsg;
      paramDecodeProtoPkgContext.dwAdditionalFlag = 1L;
      paramList.b(paramDecodeProtoPkgContext);
    }
    paramList = (ITroopBatchInfohandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.TROOP_BATCH_INFO_HANDLER);
    if (paramList != null) {
      paramMessageHandler.a.getHandler(getClass()).postDelayed(new CreateGrpInPCDecoder.1(this, paramList, paramMsg), 2000L);
    }
    MessageProtoCodec.a(l1, i, l2, j, paramMessageHandler.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.CreateGrpInPCDecoder
 * JD-Core Version:    0.7.0.1
 */