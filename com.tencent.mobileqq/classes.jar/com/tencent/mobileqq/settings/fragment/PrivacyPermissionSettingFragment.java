package com.tencent.mobileqq.settings.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import javax.annotation.Nullable;

public class PrivacyPermissionSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new PrivacyPermissionSettingFragment.2(this);
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new PrivacyPermissionSettingFragment.1(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  View jdField_b_of_type_AndroidViewView;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372454);
    ReportController.b(null, "dc00898", "", "", "0X800B7FB", "0X800B7FB", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131372452));
    ReportController.b(null, "dc00898", "", "", "0X800B7FC", "0X800B7FC", 0, 0, "", "", "", "");
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131372443));
    ReportController.b(null, "dc00898", "", "", "0X800B7FD", "0X800B7FD", 0, 0, "", "", "", "");
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLocZanAllowedForPeople();
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), bool);
    a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), localCard.strangerInviteMeGroupOpen);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getResources().getString(2131699220));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131694421));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getResources().getString(2131689986));
    }
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(a());
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_AndroidViewView = this.mContentView;
    setTitle(getBaseActivity().getString(2131699259));
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561463;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131372454)
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localUserInfo.nickname = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      QZoneHelper.forwardToPermissionSetting(getBaseActivity(), localUserInfo, -1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "0X8009C06", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B85F", "0X800B85F", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateCenterView()
  {
    setTitle(getBaseActivity().getString(2131699259));
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyPermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */