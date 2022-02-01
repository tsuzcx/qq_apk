package com.tencent.mobileqq.settings.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.managers.TempMsgManager.OnTempMsgSettingChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import common.config.service.QzoneConfig;
import java.util.Map;

public class NewTempMsgSettingFragment
  extends IphoneTitleBarFragment
  implements TempMsgManager.OnTempMsgSettingChangeListener
{
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378991));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378990));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378989));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378988));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378987));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131367628));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131367629));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378986));
    GameMsgManager localGameMsgManager = (GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    boolean bool = localGameMsgManager.b();
    QLog.i("TempMsgSettingFragment", 1, "isGameBuddyOpen:" + bool);
    Object localObject = (TextView)this.mContentView.findViewById(2131379000);
    if (!bool)
    {
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      ((TextView)localObject).setVisibility(8);
      if (!QzoneConfig.isQQCircleShowLebaEntrance(StudyModeManager.a())) {
        break label733;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    }
    for (;;)
    {
      localObject = (TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
      ((TempMsgManager)localObject).a(this);
      localObject = ((TempMsgManager)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_troop_")).booleanValue());
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_nearby_")).booleanValue());
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_interest_v2")).booleanValue());
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_contact_")).booleanValue());
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_consult_")).booleanValue());
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_circle_v2")).booleanValue());
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_game_buddy_")).booleanValue());
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_audio_room")).booleanValue());
      if (AppSetting.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719865));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719859));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719858));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719854));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719853));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131697845));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(localGameMsgManager.a());
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719852));
      }
      this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.1(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.2(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.3(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.4(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_d_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.5(this);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_e_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.6(this);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_f_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_g_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.7(this);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_g_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_h_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.8(this);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_h_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      ((TextView)localObject).setVisibility(0);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localGameMsgManager.a());
      break;
      label733:
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
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    }
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131561629;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getString(2131719860));
    return localView;
  }
  
  public void onDestroy()
  {
    ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NewTempMsgSettingFragment
 * JD-Core Version:    0.7.0.1
 */