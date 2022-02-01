package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class MsgType0x2dcDecoder
  implements Decoder<MessageHandler>
{
  private void a(MessageHandler paramMessageHandler, byte[] paramArrayOfByte)
  {
    long l = PkgTools.getLongData(paramArrayOfByte, 0);
    String str = String.valueOf(l);
    PkgTools.getLongData(paramArrayOfByte, 10);
    int i = PkgTools.getShortData(paramArrayOfByte, 16);
    if (i > 0) {
      paramArrayOfByte = PkgTools.getUTFString(paramArrayOfByte, 18, i);
    } else {
      paramArrayOfByte = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----->handleHotChatAnnouncementMsg dwGroupCode = ");
      localStringBuilder.append(l);
      localStringBuilder.append(", len = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", announcement = ");
      localStringBuilder.append(paramArrayOfByte);
      QLog.i("MsgType0x2dcDecoder", 2, localStringBuilder.toString());
    }
    paramArrayOfByte = (IHotChatHandler)paramMessageHandler.a.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
    paramMessageHandler = (HotChatManager)paramMessageHandler.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((paramArrayOfByte != null) && (paramMessageHandler != null))
    {
      paramMessageHandler = paramMessageHandler.a(str);
      if (paramMessageHandler != null)
      {
        if (paramMessageHandler.userCreate == 1)
        {
          paramArrayOfByte.getUserCreateHotChatAnnounce(str);
          return;
        }
        paramArrayOfByte.getHotChatAnnounce(paramMessageHandler.uuid.getBytes(), str);
      }
    }
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((paramList != null) && (paramMsg != null) && (paramMsg.msg_body.has()))
    {
      if (!paramMsg.msg_body.msg_content.has()) {
        return;
      }
      Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
      int i = (short)((msg_comm.MsgHead)localObject1).msg_seq.get();
      long l1 = ((msg_comm.MsgHead)localObject1).from_uin.get();
      long l2 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
      int j = ((msg_comm.MsgHead)localObject1).msg_type.get();
      localObject1 = paramMsg.msg_body.msg_content.get().toByteArray();
      Object localObject2 = new byte[localObject1.length];
      PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject1, 0, localObject2.length);
      if (localObject2.length < 5) {
        return;
      }
      int k = localObject2[4];
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("<---hotchat and opentroop push  groupCode:");
        ((StringBuilder)localObject3).append(PkgTools.getLongData((byte[])localObject1, 0));
        ((StringBuilder)localObject3).append(" subType:");
        ((StringBuilder)localObject3).append(k);
        QLog.d("MsgType0x2dcDecoder", 2, ((StringBuilder)localObject3).toString());
      }
      if ((k != 12) && (k != 14))
      {
        if ((k != 16) && (k != 17) && (k != 20) && (k != 21))
        {
          if (k == 3) {
            a(paramMessageHandler, (byte[])localObject2);
          }
        }
        else
        {
          localObject2 = new MsgType0x2dcDecoder.Parse0x2dcContext(this);
          if (localObject1.length > 7)
          {
            localObject3 = (TroopTipsMsgMgr)paramMessageHandler.a.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
            byte[] arrayOfByte = new byte[localObject1.length - 7];
            PkgTools.copyData(arrayOfByte, 0, (byte[])localObject1, 7, arrayOfByte.length);
            paramList.add(((TroopTipsMsgMgr)localObject3).a(paramMessageHandler.a, arrayOfByte, i, paramMsg.msg_head.msg_time.get(), 0L, 0, true, paramDecodeProtoPkgContext.d, (MsgType0x2dcDecoder.Parse0x2dcContext)localObject2, false));
          }
          if (((MsgType0x2dcDecoder.Parse0x2dcContext)localObject2).a)
          {
            MessageProtoCodec.a(l1, i, l2, j, paramMessageHandler.a.getMsgHandler().a());
            if (QLog.isColorLevel()) {
              QLog.d("MsgType0x2dcDecoder", 2, String.format("handle0x2dcMessage==>sendDelMsgReqToServer fromUin:%d, seq:%d, msgUid:%d, msgType:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j) }));
            }
          }
        }
      }
      else if (((TroopGagMgr)paramMessageHandler.a.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a((byte[])localObject2, i)) {
        MessageProtoCodec.a(l1, i, l2, j, paramMessageHandler.a.getMsgHandler().a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.MsgType0x2dcDecoder
 * JD-Core Version:    0.7.0.1
 */