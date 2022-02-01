package com.tencent.mobileqq.util;

import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardSetReq;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;

final class ProfileCardUtil$4
  implements Runnable
{
  ProfileCardUtil$4(int paramInt, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, String paramString3, long paramLong4, String paramString4, String paramString5) {}
  
  public void run()
  {
    if ((this.a > 0) && (!TextUtils.isEmpty(this.b))) {
      localObject = new cardDiyTextInfo(this.a, this.b, this.c, this.d, this.e, this.f);
    } else {
      localObject = null;
    }
    Object localObject = new SSummaryCardSetReq(2, Long.parseLong(this.g.getCurrentAccountUin()), this.h, "8.8.17", 109L, this.i, this.j, this.k, this.l, (cardDiyTextInfo)localObject, this.m, new cardDiyComplicatedInfo(this.n));
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setFuncName("set");
    localUniPacket.setServantName("MCardSvc");
    localUniPacket.put("req", localObject);
    localObject = localUniPacket.encode();
    ((CardHandler)this.g.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.g.getCurrentAccountUin(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), (byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.4
 * JD-Core Version:    0.7.0.1
 */