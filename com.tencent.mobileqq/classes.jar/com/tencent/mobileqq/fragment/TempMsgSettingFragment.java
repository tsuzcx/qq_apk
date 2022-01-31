package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import aqjr;
import aqjs;
import aqjt;
import aqju;
import aqjv;
import aseu;
import asex;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.Map;

public class TempMsgSettingFragment
  extends IphoneTitleBarFragment
  implements asex
{
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  public QQAppInterface a;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  CompoundButton.OnCheckedChangeListener jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  CompoundButton.OnCheckedChangeListener jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131376935));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131376934));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131376933));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131376932));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131376931));
    Object localObject = (aseu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303);
    ((aseu)localObject).a(this);
    localObject = ((aseu)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_troop_")).booleanValue());
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_nearby_")).booleanValue());
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_interest_")).booleanValue());
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_contact_")).booleanValue());
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_consult_")).booleanValue());
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720190));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720185));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720184));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720180));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720179));
    }
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aqjr(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aqjs(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aqjt(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aqju(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aqjv(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  public void a(short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    switch (paramShort)
    {
    default: 
      return;
    case -23308: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    case -23309: 
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    case -23310: 
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    case -23311: 
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    }
    a();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561098;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getString(2131720186));
    return localView;
  }
  
  public void onDestroy()
  {
    ((aseu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303)).a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TempMsgSettingFragment
 * JD-Core Version:    0.7.0.1
 */