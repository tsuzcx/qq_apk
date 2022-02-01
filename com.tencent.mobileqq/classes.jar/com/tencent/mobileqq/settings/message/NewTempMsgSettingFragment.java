package com.tencent.mobileqq.settings.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.managers.TempMsgManager.OnTempMsgSettingChangeListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import java.util.HashMap;
import java.util.Map;

public class NewTempMsgSettingFragment
  extends IphoneTitleBarFragment
  implements TempMsgManager.OnTempMsgSettingChangeListener
{
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new NewTempMsgSettingFragment.4(this);
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QFormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
  private Map<Short, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new NewTempMsgSettingFragment.5(this);
  private CompoundButton.OnCheckedChangeListener jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QFormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
  private Map<Integer, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private CompoundButton.OnCheckedChangeListener jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QFormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
  private Map<Integer, View> jdField_c_of_type_JavaUtilMap = new HashMap();
  private QFormSimpleItem d;
  private QFormSimpleItem e;
  
  private String a(String paramString, Map<String, Boolean> paramMap1, Map<String, Boolean> paramMap2)
  {
    paramMap1 = (Boolean)paramMap1.get(paramString);
    paramString = (Boolean)paramMap2.get(paramString);
    if (paramMap1 != null)
    {
      if (paramString == null) {
        return "";
      }
      int i = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempSettingStatus(paramString.booleanValue(), paramMap1.booleanValue());
      paramString = (String)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if (paramString != null) {
        return paramString;
      }
      return "";
    }
    return "";
  }
  
  private String a(short paramShort)
  {
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Short.valueOf(paramShort))) {
      return "";
    }
    return (String)this.jdField_a_of_type_JavaUtilMap.get(Short.valueOf(paramShort));
  }
  
  private void a()
  {
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(1000), this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem);
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(1006), this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem);
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(1005), this.jdField_c_of_type_ComTencentMobileqqWidgetQFormSimpleItem);
    this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(1024), this.d);
  }
  
  private void b()
  {
    if (getActivity() != null)
    {
      if (getActivity().getIntent() == null) {
        return;
      }
      int i = getActivity().getIntent().getIntExtra("uinType", 0);
      ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
      if (this.jdField_c_of_type_JavaUtilMap.containsKey(Integer.valueOf(i)))
      {
        if (!localITempMsgBoxManager.configContains(i)) {
          return;
        }
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick((View)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(i)));
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Short.valueOf((short)-23308), getString(2131719597));
    this.jdField_a_of_type_JavaUtilMap.put(Short.valueOf((short)-23310), getString(2131719580));
    this.jdField_a_of_type_JavaUtilMap.put(Short.valueOf((short)-23309), getString(2131719579));
    this.jdField_a_of_type_JavaUtilMap.put(Short.valueOf((short)-20457), getString(2131719578));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(0), getString(2131719590));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(1), getString(2131719589));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), getString(2131719591));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)this.mContentView.findViewById(2131371821));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)this.mContentView.findViewById(2131371819));
    this.jdField_c_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)this.mContentView.findViewById(2131371818));
    this.d = ((QFormSimpleItem)this.mContentView.findViewById(2131371817));
    this.e = ((QFormSimpleItem)this.mContentView.findViewById(2131371820));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378367));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378366));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131378365));
    e();
    Object localObject = (TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
    ((TempMsgManager)localObject).a(this);
    Map localMap = ((TempMsgManager)localObject).b();
    localObject = ((TempMsgManager)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText(a("temp_msg_setting_troop_", localMap, (Map)localObject));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText(a("temp_msg_setting_contact_", localMap, (Map)localObject));
    this.jdField_c_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText(a("temp_msg_setting_consult_", localMap, (Map)localObject));
    this.d.setRightText(a("temp_msg_setting_company_", localMap, (Map)localObject));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_troop_")).booleanValue());
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_contact_")).booleanValue());
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Boolean)((Map)localObject).get("temp_msg_setting_consult_")).booleanValue());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setTag(Short.valueOf((short)-23308));
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setTag(Short.valueOf((short)-23310));
    this.jdField_c_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setTag(Short.valueOf((short)-23309));
    this.d.setTag(Short.valueOf((short)-20457));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.e.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setContentDescription(getString(2131719597));
      this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setContentDescription(getString(2131719580));
      this.jdField_c_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setContentDescription(getString(2131719579));
      this.d.setContentDescription(getString(2131719578));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719597));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719580));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719579));
    }
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.2(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new NewTempMsgSettingFragment.3(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void e()
  {
    ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
    if (localITempMsgBoxManager.configContains(1000)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setVisibility(8);
    }
    if (localITempMsgBoxManager.configContains(1006)) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    } else {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setVisibility(8);
    }
    if (localITempMsgBoxManager.configContains(1005)) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    } else {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setVisibility(8);
    }
    if (!localITempMsgBoxManager.configContains(1024)) {
      this.d.setVisibility(8);
    }
    if (!localITempMsgBoxManager.configContains(10007)) {
      this.e.setVisibility(8);
    }
  }
  
  public void a(short paramShort, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      return;
    }
    int i = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempSettingStatus(paramBoolean2, paramBoolean3);
    if ((paramShort != -20457) && (paramShort != -20455))
    {
      switch (paramShort)
      {
      default: 
        switch (paramShort)
        {
        default: 
          return;
        }
      case -23308: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText((CharSequence)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(i)));
        return;
      case -23309: 
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_c_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
        this.jdField_c_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText((CharSequence)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(i)));
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean2);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_b_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQFormSimpleItem.setRightText((CharSequence)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(i)));
      return;
    }
    this.d.setRightText((CharSequence)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(i)));
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
    }
    c();
    d();
    a();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561471;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getString(2131719593));
    return localView;
  }
  
  public void onDestroy()
  {
    ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NewTempMsgSettingFragment
 * JD-Core Version:    0.7.0.1
 */