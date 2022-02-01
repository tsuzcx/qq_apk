package com.tencent.mobileqq.widget;

import android.support.annotation.NonNull;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;

class ProfileCardExtendFriendView$4
  extends ClickableSpan
{
  ProfileCardExtendFriendView$4(ProfileCardExtendFriendView paramProfileCardExtendFriendView, Card paramCard) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.authState == 1L) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardExtendFriendView.getContext(), 0, 2131698710, 1).a();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataCard.authState != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.authState != 3L)) {
      return;
    }
    CampusHelper.a((FriendProfileCardActivity)ProfileCardExtendFriendView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardExtendFriendView), this.jdField_a_of_type_ComTencentMobileqqDataCard.idx, this.jdField_a_of_type_ComTencentMobileqqDataCard.schoolName, this.jdField_a_of_type_ComTencentMobileqqDataCard.schoolId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView.4
 * JD-Core Version:    0.7.0.1
 */