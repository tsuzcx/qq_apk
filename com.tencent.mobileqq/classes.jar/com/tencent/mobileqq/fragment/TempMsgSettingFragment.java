package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import avgb;
import avgc;
import avgd;
import avge;
import avgf;
import avgg;
import avgh;
import avgi;
import avld;
import axae;
import axah;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import common.config.service.QzoneConfig;
import java.util.Map;

public class TempMsgSettingFragment
  extends IphoneTitleBarFragment
  implements axah
{
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  public QQAppInterface a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_g_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CompoundButton.OnCheckedChangeListener jdField_h_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378504));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378503));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378502));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378501));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378500));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131367293));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131367294));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378499));
    avld localavld = (avld)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358);
    boolean bool = localavld.b();
    QLog.i("TempMsgSettingFragment", 1, "isGameBuddyOpen:" + bool);
    if (!bool)
    {
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      if (!QzoneConfig.isQQCircleShowLebaEntrance()) {
        break label706;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    }
    for (;;)
    {
      Object localObject = (axae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303);
      ((axae)localObject).a(this);
      localObject = ((axae)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_troop_")).booleanValue());
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_nearby_")).booleanValue());
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_interest_v2")).booleanValue());
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_contact_")).booleanValue());
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_consult_")).booleanValue());
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_circle_v2")).booleanValue());
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_game_buddy_")).booleanValue());
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_audio_room")).booleanValue());
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718667));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718662));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718661));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718657));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718656));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131697171));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(localavld.a());
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718655));
      }
      this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new avgb(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new avgc(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new avgd(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new avge(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new avgf(this);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new avgg(this);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_g_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new avgh(this);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_g_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_h_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new avgi(this);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_h_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localavld.a());
      break;
      label706:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
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
    case -23166: 
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    case -23312: 
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    case -23168: 
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    case -23158: 
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_g_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_h_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
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
    return 2131561574;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getString(2131718663));
    return localView;
  }
  
  public void onDestroy()
  {
    ((axae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(303)).a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TempMsgSettingFragment
 * JD-Core Version:    0.7.0.1
 */