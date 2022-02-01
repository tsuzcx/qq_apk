package com.tencent.qidian;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;

class QidianProfileCardActivity$19
  extends CardObserver
{
  QidianProfileCardActivity$19(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "onGetAccountType isSuccess: " + paramBoolean + " | type: " + paramBmqqAccountType + " | cardInfo.allinone.uin: " + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null) && (paramBmqqAccountType.getUin().equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)))
    {
      this.a.c = paramBmqqAccountType.getAccountType();
      this.a.b();
      if (this.a.c == 1) {
        this.a.jdField_a_of_type_ComTencentQidianQidianManager.b(this.a, paramBmqqAccountType);
      }
    }
    else
    {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.19
 * JD-Core Version:    0.7.0.1
 */