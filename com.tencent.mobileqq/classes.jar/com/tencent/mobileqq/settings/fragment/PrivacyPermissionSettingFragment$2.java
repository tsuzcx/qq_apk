package com.tencent.mobileqq.settings.fragment;

import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class PrivacyPermissionSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  PrivacyPermissionSettingFragment$2(PrivacyPermissionSettingFragment paramPrivacyPermissionSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    boolean bool;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == this.a.b.a())) && (!NetworkUtil.d(this.a.getActivity())))
    {
      this.a.a(2131694507, 1);
      localObject = this.a;
      if (!paramBoolean)
      {
        bool = true;
        PrivacyPermissionSettingFragment.a((PrivacyPermissionSettingFragment)localObject, paramCompoundButton, bool);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (AppSetting.d) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(this.a.getResources().getString(2131694456));
        }
        if (paramBoolean)
        {
          i = 1;
          label135:
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!paramBoolean) {
            break label227;
          }
        }
        label227:
        for (int i = 1;; i = 0)
        {
          ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800B860", "0X800B860", i, 0, "", "", "", "");
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setZanAllowed(true, paramBoolean);
          break;
          i = 0;
          break label135;
        }
      }
      if (paramCompoundButton == this.a.b.a())
      {
        ((CardHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).o(paramBoolean);
        if (paramBoolean) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B861", "0X800B861", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B861", "0X800B861", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyPermissionSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */