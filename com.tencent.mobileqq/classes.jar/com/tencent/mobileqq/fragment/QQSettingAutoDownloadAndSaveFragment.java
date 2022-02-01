package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.util.AutoSaveUtils;
import com.tencent.util.VersionUtils;
import mqq.app.AppRuntime;

public class QQSettingAutoDownloadAndSaveFragment
  extends IphoneTitleBarFragment
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchItem b;
  FormSwitchItem c;
  FormSwitchItem d;
  FormSwitchItem e;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131376998));
    if (VersionUtils.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    ReportController.b(null, "dc00898", "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0X800ABAF", "0X800ABAF", 0, 1, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131363083));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131363082));
    this.c = ((FormSwitchItem)this.mContentView.findViewById(2131380227));
    this.d = ((FormSwitchItem)this.mContentView.findViewById(2131363084));
    this.e = ((FormSwitchItem)this.mContentView.findViewById(2131363085));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    boolean bool = SettingCloneUtil.readValue(getBaseActivity(), null, getString(2131694986), "qqsetting_auto_receive_pic_key", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.1(this));
    FormSwitchItem localFormSwitchItem = this.b;
    int i;
    if (MagicfaceViewController.a()) {
      i = 0;
    } else {
      i = 8;
    }
    localFormSwitchItem.setVisibility(i);
    bool = SettingCloneUtil.readValue(getBaseActivity(), null, getString(2131694986), "qqsetting_auto_receive_magic_face_key", true);
    this.b.setChecked(bool);
    this.b.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.2(this));
    bool = ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.c.setChecked(bool);
    this.c.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.3(this));
    bool = AutoSaveUtils.a(true);
    this.d.setChecked(bool);
    this.d.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.4(this));
    bool = AutoSaveUtils.a(false);
    this.e.setChecked(bool);
    this.e.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.5(this));
    if (VersionUtils.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718774));
      this.b.setContentDescription(getString(2131718773));
      this.c.setContentDescription(getString(2131720136));
      this.d.setContentDescription(getString(2131718771));
      this.e.setContentDescription(getString(2131718772));
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        a();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561435;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131718780));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment
 * JD-Core Version:    0.7.0.1
 */