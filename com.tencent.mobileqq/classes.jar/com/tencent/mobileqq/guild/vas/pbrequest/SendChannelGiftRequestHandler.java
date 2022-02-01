package com.tencent.mobileqq.guild.vas.pbrequest;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.SendGiftReq;
import java.io.UnsupportedEncodingException;

public class SendChannelGiftRequestHandler
{
  private static final SendChannelGiftRequestHandler a = new SendChannelGiftRequestHandler();
  
  public static SendChannelGiftRequestHandler a()
  {
    return a;
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, String paramString, BusinessObserver paramBusinessObserver)
  {
    giftList.SendGiftReq localSendGiftReq = new giftList.SendGiftReq();
    localSendGiftReq.SenderTinyid.set(paramLong1);
    localSendGiftReq.RecverTinyid.set(paramLong2);
    localSendGiftReq.GiftId.set(paramInt1);
    localSendGiftReq.SendType.set(paramInt2);
    localSendGiftReq.ChannelId.set(paramLong3);
    localSendGiftReq.GroupId.set(paramLong4);
    localSendGiftReq.AuthKey.set(paramString);
    try
    {
      VasUtil.a().getPbRequest().request("trpc.gift.channel_gift_send.GiftSend.SendChannelGift", new String(localSendGiftReq.toByteArray(), "ISO8859_1"), paramBusinessObserver);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.pbrequest.SendChannelGiftRequestHandler
 * JD-Core Version:    0.7.0.1
 */