package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.BaseActivity;
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
  
  protected void onGetAllowStrangerInviteToGroupSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.getBaseActivity().isFinishing())
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      if (!paramBoolean1)
      {
        this.a.a(2131718834, 1);
        localObject = ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        PrivacyPermissionSettingFragment localPrivacyPermissionSettingFragment = this.a;
        PrivacyPermissionSettingFragment.a(localPrivacyPermissionSettingFragment, localPrivacyPermissionSettingFragment.b.a(), ((Card)localObject).strangerInviteMeGroupOpen);
        return;
      }
      Object localObject = this.a;
      PrivacyPermissionSettingFragment.a((PrivacyPermissionSettingFragment)localObject, ((PrivacyPermissionSettingFragment)localObject).b.a(), paramBoolean2);
    }
  }
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    paramString = this.a;
    PrivacyPermissionSettingFragment.a(paramString, paramString.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean2);
  }
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (!paramBoolean1) {
      this.a.a(2131718834, 1);
    }
    if (paramBoolean2)
    {
      paramString = this.a;
      PrivacyPermissionSettingFragment.a(paramString, paramString.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyPermissionSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */