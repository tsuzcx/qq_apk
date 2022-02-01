package com.tencent.qidian;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;

class QidianProfileCardActivity$14
  extends FriendListObserver
{
  QidianProfileCardActivity$14(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin.equals(String.valueOf(paramObject)))) {
      this.a.b();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin != null) && (!ProfilePAUtils.isPaTypeFriend(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin)) && (!this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin.equals(this.a.app.getCurrentAccountUin())))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.pa = 1;
      QidianProfileCardActivity localQidianProfileCardActivity = this.a;
      QidianProfileCardActivity.b(localQidianProfileCardActivity, localQidianProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.14
 * JD-Core Version:    0.7.0.1
 */