package com.tencent.qidian;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;

class QidianProfileCardActivity$14
  extends FriendListObserver
{
  QidianProfileCardActivity$14(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramObject)))) {
      this.a.b();
    }
  }
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString != null) && (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString)) && (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin())))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int = 1;
      QidianProfileCardActivity.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.14
 * JD-Core Version:    0.7.0.1
 */