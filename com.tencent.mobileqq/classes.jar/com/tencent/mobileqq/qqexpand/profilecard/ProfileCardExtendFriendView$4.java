package com.tencent.mobileqq.qqexpand.profilecard;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.widget.QQToast;

class ProfileCardExtendFriendView$4
  extends ClickableSpan
{
  ProfileCardExtendFriendView$4(ProfileCardExtendFriendView paramProfileCardExtendFriendView, Card paramCard) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.authState == 1L)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileCardExtendFriendView.getContext(), 0, 1913061378, 1).a();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.authState == 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.authState == 3L)) {
      CampusHelper.a((Activity)ProfileCardExtendFriendView.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileCardExtendFriendView), this.jdField_a_of_type_ComTencentMobileqqDataCard.idx, this.jdField_a_of_type_ComTencentMobileqqDataCard.schoolName, this.jdField_a_of_type_ComTencentMobileqqDataCard.schoolId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView.4
 * JD-Core Version:    0.7.0.1
 */