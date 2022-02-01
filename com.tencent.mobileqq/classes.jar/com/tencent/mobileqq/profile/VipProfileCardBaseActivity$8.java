package com.tencent.mobileqq.profile;

import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardSetReq;
import SummaryCardTaf.cardDiyComplicatedInfo;
import anum;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.QQAppInterface;

class VipProfileCardBaseActivity$8
  implements Runnable
{
  VipProfileCardBaseActivity$8(VipProfileCardBaseActivity paramVipProfileCardBaseActivity, long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = new SSummaryCardSetReq(2, Long.parseLong(this.this$0.app.getCurrentAccountUin()), 0L, "8.4.5", 109L, this.jdField_a_of_type_Long, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, null, null, new cardDiyComplicatedInfo());
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setFuncName("set");
    localUniPacket.setServantName("MCardSvc");
    localUniPacket.put("req", localObject);
    localObject = localUniPacket.encode();
    this.this$0.a.a(this.this$0.app.getCurrentAccountUin(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), (byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity.8
 * JD-Core Version:    0.7.0.1
 */