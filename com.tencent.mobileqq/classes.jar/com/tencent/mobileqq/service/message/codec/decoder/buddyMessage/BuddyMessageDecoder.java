package com.tencent.mobileqq.service.message.codec.decoder.buddyMessage;

import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.basic.MapClassGeneratorImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.codec.decoder.Decoder;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class BuddyMessageDecoder
  implements Decoder<MessageHandler>
{
  private MapClassGenerator<Integer, Decoder> a = new MapClassGeneratorImpl();
  
  public BuddyMessageDecoder()
  {
    a();
  }
  
  protected void a()
  {
    this.a.a(Integer.valueOf(169), OfflineFileDecoder.class);
    this.a.a(Integer.valueOf(241), OfflineFileDecoder.class);
    this.a.a(Integer.valueOf(242), OfflineFileDecoder.class);
    this.a.a(Integer.valueOf(243), OfflineFileDecoder.class);
    this.a.a(Integer.valueOf(175), NormalBuddyDecoder.class);
    this.a.a(Integer.valueOf(11), NormalBuddyDecoder.class);
    this.a.a(Integer.valueOf(129), OnlineFileDecoder.class);
    this.a.a(Integer.valueOf(131), OnlineFileDecoder.class);
    this.a.a(Integer.valueOf(133), OnlineFileDecoder.class);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()) {}
    Decoder localDecoder;
    do
    {
      return;
      int i = paramMsg.msg_head.c2c_cmd.get();
      localDecoder = (Decoder)this.a.a(Integer.valueOf(i));
    } while (localDecoder == null);
    localDecoder.a(paramMessageHandler, paramMsg, paramList, paramDecodeProtoPkgContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.BuddyMessageDecoder
 * JD-Core Version:    0.7.0.1
 */