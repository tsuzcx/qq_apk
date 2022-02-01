package com.tencent.mobileqq.guild.vas.pbrequest;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.UniBalanceFromAdminReq;
import java.io.UnsupportedEncodingException;

public class GetBalanceFromAdminRequestHandler
{
  private static final GetBalanceFromAdminRequestHandler a = new GetBalanceFromAdminRequestHandler();
  
  public static GetBalanceFromAdminRequestHandler a()
  {
    return a;
  }
  
  public void a(String paramString, BusinessObserver paramBusinessObserver)
  {
    giftList.UniBalanceFromAdminReq localUniBalanceFromAdminReq = new giftList.UniBalanceFromAdminReq();
    localUniBalanceFromAdminReq.appid.set("1003");
    localUniBalanceFromAdminReq.Authkey.set(paramString);
    localUniBalanceFromAdminReq.DomainID.set(5);
    try
    {
      VasUtil.a().getPbRequest().request("trpc.gift.channel_gift_currency.GiftCurrency.UniGetBalanceFromAdmin", new String(localUniBalanceFromAdminReq.toByteArray(), "ISO8859_1"), paramBusinessObserver);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.pbrequest.GetBalanceFromAdminRequestHandler
 * JD-Core Version:    0.7.0.1
 */