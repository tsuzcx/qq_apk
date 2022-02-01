package com.tencent.mobileqq.settings.fragment;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;

class PrivacyPermissionSettingFragment$1
  extends CardObserver
{
  PrivacyPermissionSettingFragment$1(PrivacyPermissionSettingFragment paramPrivacyPermissionSettingFragment) {}
  
  public void onGetAllowStrangerInviteToGroupSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.a.getActivity().isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (!paramBoolean1)
    {
      this.a.a(2131719116, 1);
      Card localCard = ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      PrivacyPermissionSettingFragment.a(this.a, this.a.b.a(), localCard.strangerInviteMeGroupOpen);
      return;
    }
    PrivacyPermissionSettingFragment.a(this.a, this.a.b.a(), paramBoolean2);
  }
  
  public void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    PrivacyPermissionSettingFragment.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean2);
  }
  
  public void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString)) {}
    do
    {
      return;
      if (!paramBoolean1) {
        this.a.a(2131719116, 1);
      }
    } while (!paramBoolean2);
    PrivacyPermissionSettingFragment.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyPermissionSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */