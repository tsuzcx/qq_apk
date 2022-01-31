package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import asdf;
import asdg;
import asdh;
import asdi;
import asdj;
import asdk;
import atvu;
import atvx;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.Map;

public class TempMsgSettingFragment
  extends IphoneTitleBarFragment
  implements atvx
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
  private CompoundButton.OnCheckedChangeListener jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377455));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377454));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377453));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377452));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131377451));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131366962));
    Object localObject = (atvu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303);
    ((atvu)localObject).a(this);
    localObject = ((atvu)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_troop_")).booleanValue());
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_nearby_")).booleanValue());
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_interest_")).booleanValue());
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_contact_")).booleanValue());
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_consult_")).booleanValue());
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_circle_")).booleanValue());
    if (AppSetting.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720726));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720721));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720720));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720716));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131720715));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131698271));
    }
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new asdf(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new asdg(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new asdh(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new asdi(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new asdj(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new asdk(this);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
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
    case -23312: 
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
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
    return 2131561285;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getString(2131720722));
    return localView;
  }
  
  public void onDestroy()
  {
    ((atvu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303)).a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TempMsgSettingFragment
 * JD-Core Version:    0.7.0.1
 */