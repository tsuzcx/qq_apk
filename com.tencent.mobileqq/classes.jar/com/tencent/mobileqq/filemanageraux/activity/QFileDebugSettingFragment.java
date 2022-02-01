package com.tencent.mobileqq.filemanageraux.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileAppStorePromoteConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileAppStorePromoteDialogConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQFileDatalineConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileFileReaderConfigBean;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class QFileDebugSettingFragment
  extends IphoneTitleBarFragment
{
  private IQFileConfigManager a;
  
  private void a()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131382117);
    localFormSwitchItem.setChecked(((IQFileAppStorePromoteConfigBean)QRoute.api(IQFileAppStorePromoteConfigBean.class)).getActionSwitch());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.1(this));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131382118);
    localFormSwitchItem.setChecked(((IQFileAppStorePromoteDialogConfigBean)QRoute.api(IQFileAppStorePromoteDialogConfigBean.class)).getDialogSwitch());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.2(this));
  }
  
  private void b()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131374196);
    localFormSwitchItem.setChecked(((IQFileFileReaderConfigBean)QRoute.api(IQFileFileReaderConfigBean.class)).getIsShowReaderBar());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.3(this));
  }
  
  private void c()
  {
    EditText localEditText = (EditText)this.mContentView.findViewById(2131366007);
    localEditText.addTextChangedListener(new QFileDebugSettingFragment.4(this));
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131366008);
    localFormSwitchItem.setChecked(this.a.isHarcodeIP());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.5(this, localEditText));
    localEditText.setText(this.a.getHarcodeIP());
    localEditText.setEnabled(localFormSwitchItem.a());
  }
  
  private void d()
  {
    EditText localEditText = (EditText)this.mContentView.findViewById(2131365556);
    localEditText.addTextChangedListener(new QFileDebugSettingFragment.6(this));
    ((FormSimpleItem)this.mContentView.findViewById(2131378429)).setOnClickListener(new QFileDebugSettingFragment.7(this));
    RadioGroup localRadioGroup = (RadioGroup)this.mContentView.findViewById(2131365549);
    localRadioGroup.setOnCheckedChangeListener(new QFileDebugSettingFragment.8(this));
    Object localObject = (FormSwitchItem)this.mContentView.findViewById(2131365555);
    ((FormSwitchItem)localObject).setChecked(((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).getFileAssistantSwitch());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.9(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131365550);
    ((FormSwitchItem)localObject).setChecked(((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).getIpadOnline());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.10(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131365557);
    ((FormSwitchItem)localObject).setChecked(this.a.isWlanOnly());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.11(this));
    localObject = getActivity().app;
    localObject = getActivity().app.getApp().getSharedPreferences("file_debug_" + getActivity().app.getCurrentUin(), 0);
    String str = ((SharedPreferences)localObject).getString("file_debug_dataline_uin", "");
    if (!TextUtils.isEmpty(str)) {
      localEditText.setText(str);
    }
    int i = ((SharedPreferences)localObject).getInt("file_debug_dataline_device", 65799);
    if (i == 65799) {
      localRadioGroup.check(2131365548);
    }
    do
    {
      return;
      if (i == 65793)
      {
        localRadioGroup.check(2131365547);
        return;
      }
    } while (i != 65793);
    localRadioGroup.check(2131365546);
  }
  
  private void e()
  {
    Object localObject = (FormSwitchItem)this.mContentView.findViewById(2131369233);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().b());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.12(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131369229);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().c());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.13(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131369232);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().d());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.14(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131369231);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().e());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.15(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131369230);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().f());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.16(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131369228);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.17(this));
    localObject = (RadioGroup)this.mContentView.findViewById(2131378533);
    TextView localTextView;
    switch (FileIPv6StrateyController.a().a())
    {
    default: 
      ((RadioGroup)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.18(this));
      localTextView = (TextView)this.mContentView.findViewById(2131370832);
      localObject = "当前登录协议栈：IPv4";
      if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
        localObject = "当前登录协议栈：IPv6";
      }
      localTextView.setText((CharSequence)localObject);
      localTextView = (TextView)this.mContentView.findViewById(2131365193);
      localObject = "c2c开关：关闭";
      if (this.a.getC2CFileIPv6Switch()) {
        localObject = "c2c开关：打开";
      }
      localTextView.setText((CharSequence)localObject);
      localTextView = (TextView)this.mContentView.findViewById(2131365196);
      localObject = "group开关：关闭";
      if (this.a.getGroupFileIPv6Switch()) {
        localObject = "group开关：打开";
      }
      localTextView.setText((CharSequence)localObject);
      localTextView = (TextView)this.mContentView.findViewById(2131365195);
      localObject = "disc开关：关闭";
      if (this.a.getDiscFileIPv6Switch()) {
        localObject = "disc开关：打开";
      }
      localTextView.setText((CharSequence)localObject);
      localTextView = (TextView)this.mContentView.findViewById(2131365194);
      localObject = "数据线开关：关闭";
      if (this.a.getDatalineFileIPv6Switch()) {
        localObject = "数据线开关：打开";
      }
      localTextView.setText((CharSequence)localObject);
      localTextView = (TextView)this.mContentView.findViewById(2131365201);
      if (this.a.getFileIPv6Strategy() == 0) {
        localObject = "IPv6策略：v4优先";
      }
      break;
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return;
      ((RadioGroup)localObject).check(2131378530);
      break;
      ((RadioGroup)localObject).check(2131378531);
      break;
      ((RadioGroup)localObject).check(2131378532);
      break;
      if (this.a.getFileIPv6Strategy() == 1) {
        localObject = "IPv6策略：v6优先";
      } else if (this.a.getFileIPv6Strategy() == 2) {
        localObject = "IPv6策略：跟随登录";
      } else {
        localObject = "IPv6策略：unkonw";
      }
    }
  }
  
  private void f()
  {
    QQAppInterface localQQAppInterface = getActivity().app;
    if (localQQAppInterface == null) {
      return;
    }
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362776);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().a().a());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.19(this, localQQAppInterface));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362775);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().a().b());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.20(this, localQQAppInterface));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((IQFileConfigManager)getActivity().app.getRuntimeService(IQFileConfigManager.class, ""));
    a();
    e();
    b();
    c();
    f();
    d();
  }
  
  public int getContentLayoutId()
  {
    return 2131560936;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */