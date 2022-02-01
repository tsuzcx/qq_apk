package com.tencent.mobileqq.vipgift;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class VipGiftManager$3
  implements AsyncBack
{
  VipGiftManager$3(VipGiftManager paramVipGiftManager, long paramLong1, String paramString1, long paramLong2, String paramString2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("checkUpAndNotifyByBid loaded,code:");
      paramString.append(paramInt);
      paramString.append(",cost:");
      paramString.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.d("VipGiftManager", 2, paramString.toString());
    }
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("280")) {
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
    }
    if ((paramInt != 0) && (8 != paramInt) && (5 != paramInt))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(5L, this.jdField_b_of_type_Long))
      {
        paramString = this.jdField_b_of_type_JavaLangString;
        if (paramString != null) {
          this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(paramString, this.jdField_b_of_type_Long);
        }
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(2L, this.jdField_b_of_type_Long)) {
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long);
    }
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpAndNotifyByBid progress:");
      localStringBuilder.append(paramInt);
      QLog.d("VipGiftManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vipgift.VipGiftManager.3
 * JD-Core Version:    0.7.0.1
 */