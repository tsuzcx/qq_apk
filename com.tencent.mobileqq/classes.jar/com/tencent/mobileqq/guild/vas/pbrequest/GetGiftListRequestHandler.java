package com.tencent.mobileqq.guild.vas.pbrequest;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GetGiftListReq;
import java.io.UnsupportedEncodingException;

public class GetGiftListRequestHandler
{
  private static final GetGiftListRequestHandler a = new GetGiftListRequestHandler();
  
  public static GetGiftListRequestHandler a()
  {
    return a;
  }
  
  public void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    giftList.GetGiftListReq localGetGiftListReq = new giftList.GetGiftListReq();
    localGetGiftListReq.GiftListId.set(paramString1);
    localGetGiftListReq.AttachInfo.set(paramString2);
    try
    {
      VasUtil.a().getPbRequest().request("trpc.gift.channel_gift_list.GiftList.GetGiftList", new String(localGetGiftListReq.toByteArray(), "ISO8859_1"), paramBusinessObserver);
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.pbrequest.GetGiftListRequestHandler
 * JD-Core Version:    0.7.0.1
 */