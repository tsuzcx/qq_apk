package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131377554));
    if (VersionUtils.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    ReportController.b(null, "dc00898", "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0X800ABAF", "0X800ABAF", 0, 1, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131363142));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131363141));
    this.c = ((FormSwitchItem)this.mContentView.findViewById(2131380961));
    this.d = ((FormSwitchItem)this.mContentView.findViewById(2131363143));
    this.e = ((FormSwitchItem)this.mContentView.findViewById(2131363144));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    boolean bool = SettingCloneUtil.readValue(getActivity(), null, getString(2131694996), "qqsetting_auto_receive_pic_key", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.1(this));
    FormSwitchItem localFormSwitchItem = this.b;
    if (MagicfaceViewController.a()) {}
    for (int i = 0;; i = 8)
    {
      localFormSwitchItem.setVisibility(i);
      bool = SettingCloneUtil.readValue(getActivity(), null, getString(2131694996), "qqsetting_auto_receive_magic_face_key", true);
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719058));
        this.b.setContentDescription(getString(2131719057));
        this.c.setContentDescription(getString(2131720397));
        this.d.setContentDescription(getString(2131719055));
        this.e.setContentDescription(getString(2131719056));
      }
      return;
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        a();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561593;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131719064));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment
 * JD-Core Version:    0.7.0.1
 */