package com.tencent.mobileqq.service.message.api;

import com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler;
import com.tencent.imcore.message.IGrpDisPTTDecoder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.Elem;

@Service(process={""})
public abstract interface IBaseMessageProcessorForTroopAndDiscService
  extends IRuntimeService
{
  public abstract void decodeC2CMsgPkgAppShared(BaseMessageHandler paramBaseMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract String decodeTroopMsg(MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo1, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, int paramInt1, int paramInt2, int paramInt3, List<MessageRecord> paramList, List<im_msg_body.Elem> paramList1, MessageInfo paramMessageInfo2, byte paramByte, String paramString2);
  
  public abstract IGrpDisPTTDecoder<BaseMessageHandler> getGrpDisPTTDecoder();
  
  public abstract BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler getQTroopHotChatTopicHandler(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<im_msg_body.Elem> paramList, byte paramByte, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.api.IBaseMessageProcessorForTroopAndDiscService
 * JD-Core Version:    0.7.0.1
 */