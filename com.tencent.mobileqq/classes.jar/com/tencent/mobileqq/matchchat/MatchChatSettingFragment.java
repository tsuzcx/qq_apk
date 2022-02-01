package com.tencent.mobileqq.matchchat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class MatchChatSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new MatchChatSettingFragment.1(this);
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  private void a()
  {
    boolean bool = ExtendFriendLimitChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
    a(bool);
    if (QLog.isColorLevel()) {
      QLog.i("MatchChatSettingFragment", 2, "initDefaultValue chatSwitchOpen:" + bool);
    }
    ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131374796));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131374795));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
        a(this.mContentView);
        a();
      }
      return;
    }
    QLog.w("MatchChatSettingFragment", 1, "error runtime?" + getActivity().getAppRuntime());
  }
  
  public int getContentLayoutId()
  {
    return 2131562929;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    HashMap localHashMap;
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      if (!NetworkUtil.d(getActivity())) {
        break label143;
      }
      ((ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramBoolean);
      if (!paramBoolean) {
        break label131;
      }
      i = 0;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A690", "0X800A690", i, 0, "", "", "", "");
      localHashMap = new HashMap();
      if (!paramBoolean) {
        break label136;
      }
    }
    label131:
    label136:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("ext_int1", str);
      ExpandReportUtils.a("click#message_setting_page#dnd_mode", true, -1L, -1L, localHashMap, true, true);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 1;
      break;
    }
    label143:
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      QQToast.a(getActivity(), 2131694469, 0).a();
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ThreadManagerV2.excute(new MatchChatSettingFragment.2(this), 16, null, true);
    }
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131698919));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ExpandReportUtils.a("expose#message_setting_page#view", true, -1L, -1L, null, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment
 * JD-Core Version:    0.7.0.1
 */