package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;

public class DecodePBMsgElementImpl
  implements IDecodePBMsgElement
{
  public void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, MessageInfo paramMessageInfo)
  {
    MessagePBElemDecoder localMessagePBElemDecoder = new MessagePBElemDecoder();
    if (paramList1.isEmpty()) {
      localMessagePBElemDecoder.f(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    }
    if (paramList1.isEmpty()) {
      localMessagePBElemDecoder.i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.DecodePBMsgElementImpl
 * JD-Core Version:    0.7.0.1
 */