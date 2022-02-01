package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ansg;
import auxh;
import auxi;
import auxj;
import auxk;
import auxl;
import awsw;
import bdla;
import bkxr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131377134));
    if (VersionUtils.isGingerBread()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    bdla.b(null, "dc00898", "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0X800ABAF", "0X800ABAF", 0, 1, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131363097));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131363096));
    this.c = ((FormSwitchItem)this.mContentView.findViewById(2131380515));
    this.d = ((FormSwitchItem)this.mContentView.findViewById(2131363098));
    this.e = ((FormSwitchItem)this.mContentView.findViewById(2131363099));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    boolean bool = SettingCloneUtil.readValue(getActivity(), null, getString(2131694758), "qqsetting_auto_receive_pic_key", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new auxh(this));
    FormSwitchItem localFormSwitchItem = this.b;
    if (awsw.a()) {}
    for (int i = 0;; i = 8)
    {
      localFormSwitchItem.setVisibility(i);
      bool = SettingCloneUtil.readValue(getActivity(), null, getString(2131694758), "qqsetting_auto_receive_magic_face_key", true);
      this.b.setChecked(bool);
      this.b.setOnCheckedChangeListener(new auxi(this));
      bool = ansg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      this.c.setChecked(bool);
      this.c.setOnCheckedChangeListener(new auxj(this));
      bool = bkxr.a(true);
      this.d.setChecked(bool);
      this.d.setOnCheckedChangeListener(new auxk(this));
      bool = bkxr.a(false);
      this.e.setChecked(bool);
      this.e.setOnCheckedChangeListener(new auxl(this));
      if (VersionUtils.isGingerBread()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718535));
        this.b.setContentDescription(getString(2131718534));
        this.c.setContentDescription(getString(2131719827));
        this.d.setContentDescription(getString(2131718532));
        this.e.setContentDescription(getString(2131718533));
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
    return 2131561483;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131718541));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment
 * JD-Core Version:    0.7.0.1
 */