package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import auyh;
import auyi;
import auyj;
import auyk;
import auyl;
import auym;
import auyn;
import auyo;
import avds;
import awtq;
import awtt;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.FormSwitchItem;
import common.config.service.QzoneConfig;
import java.util.Map;

public class TempMsgSettingFragment
  extends IphoneTitleBarFragment
  implements awtt
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378560));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378559));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378558));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378557));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378556));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131367441));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131367442));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378555));
    avds localavds = (avds)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    boolean bool = localavds.b();
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
      Object localObject = (awtq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
      ((awtq)localObject).a(this);
      localObject = ((awtq)localObject).a();
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719309));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719304));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719303));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719299));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719298));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131697591));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(localavds.a());
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719297));
      }
      this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new auyh(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new auyi(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new auyj(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new auyk(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new auyl(this);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new auym(this);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_g_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new auyn(this);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_g_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_h_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new auyo(this);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_h_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localavds.a());
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
    return 2131561514;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getString(2131719305));
    return localView;
  }
  
  public void onDestroy()
  {
    ((awtq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TempMsgSettingFragment
 * JD-Core Version:    0.7.0.1
 */