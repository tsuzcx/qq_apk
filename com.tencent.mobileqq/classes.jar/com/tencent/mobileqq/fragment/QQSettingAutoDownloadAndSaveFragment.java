package com.tencent.mobileqq.fragment;

import allq;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ascl;
import ascm;
import ascn;
import asco;
import ascp;
import atva;
import awfo;
import azmj;
import bhnu;
import bhou;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131376146));
    if (bhou.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    azmj.b(null, "dc00898", "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0X800ABAF", "0X800ABAF", 0, 1, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131362929));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131362928));
    this.c = ((FormSwitchItem)this.mContentView.findViewById(2131379286));
    this.d = ((FormSwitchItem)this.mContentView.findViewById(2131362930));
    this.e = ((FormSwitchItem)this.mContentView.findViewById(2131362931));
    if (awfo.c == 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (!atva.a()) {
        break label439;
      }
      this.b.setVisibility(0);
    }
    for (;;)
    {
      boolean bool = SettingCloneUtil.readValue(getActivity(), null, getString(2131695480), "qqsetting_auto_receive_pic_key", true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new ascl(this));
      bool = SettingCloneUtil.readValue(getActivity(), null, getString(2131695480), "qqsetting_auto_receive_magic_face_key", true);
      this.b.setChecked(bool);
      this.b.setOnCheckedChangeListener(new ascm(this));
      bool = allq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      this.c.setChecked(bool);
      this.c.setOnCheckedChangeListener(new ascn(this));
      bool = bhnu.a(true);
      this.d.setChecked(bool);
      this.d.setOnCheckedChangeListener(new asco(this));
      bool = bhnu.a(false);
      this.e.setChecked(bool);
      this.e.setOnCheckedChangeListener(new ascp(this));
      if (bhou.c()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719782));
        this.b.setContentDescription(getString(2131719781));
        this.c.setContentDescription(getString(2131721219));
        this.d.setContentDescription(getString(2131719779));
        this.e.setContentDescription(getString(2131719780));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break;
      label439:
      this.b.setVisibility(8);
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
    return 2131561253;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131719792));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment
 * JD-Core Version:    0.7.0.1
 */