package com.tencent.qidian;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;

class QidianProfileCardActivity$19
  extends CardObserver
{
  QidianProfileCardActivity$19(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAccountType isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" | type: ");
      localStringBuilder.append(paramBmqqAccountType);
      localStringBuilder.append(" | cardInfo.allinone.uin: ");
      localStringBuilder.append(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
      QLog.d("QidianProfileCardActivity", 2, localStringBuilder.toString());
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne != null) && (paramBmqqAccountType.getUin().equals(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin)))
    {
      this.a.c = paramBmqqAccountType.getAccountType();
      this.a.b();
      if (this.a.c == 1)
      {
        this.a.jdField_a_of_type_ComTencentQidianQidianManager.b(this.a, paramBmqqAccountType);
        return;
      }
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.19
 * JD-Core Version:    0.7.0.1
 */