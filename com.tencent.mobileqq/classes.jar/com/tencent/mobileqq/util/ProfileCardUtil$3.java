package com.tencent.mobileqq.util;

import QQService.CARDSETTYPE;
import SummaryCardTaf.SSummaryCardSetReq;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import alpk;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ProfileCardUtil$3
  implements Runnable
{
  public ProfileCardUtil$3(int paramInt, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, String paramString3, long paramLong4, String paramString4, String paramString5) {}
  
  public void run()
  {
    UniPacket localUniPacket = null;
    Object localObject = localUniPacket;
    if (this.jdField_a_of_type_Int > 0)
    {
      localObject = localUniPacket;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localObject = new cardDiyTextInfo(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float);
      }
    }
    localObject = new SSummaryCardSetReq(2, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), this.jdField_a_of_type_Long, "8.3.5", 109L, this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Long, (cardDiyTextInfo)localObject, this.jdField_d_of_type_JavaLangString, new cardDiyComplicatedInfo(this.e));
    localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setFuncName("set");
    localUniPacket.setServantName("MCardSvc");
    localUniPacket.put("req", localObject);
    localObject = localUniPacket.encode();
    ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), CARDSETTYPE.TYPE_SET_TEMPLATE.value(), (byte)0, null, null, null, null, (byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.3
 * JD-Core Version:    0.7.0.1
 */