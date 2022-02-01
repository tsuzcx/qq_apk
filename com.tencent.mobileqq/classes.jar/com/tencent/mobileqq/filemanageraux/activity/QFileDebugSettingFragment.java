package com.tencent.mobileqq.filemanageraux.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qfile.IQFileAppStorePromoteConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileAppStorePromoteDialogConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileDatalineConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileFileReaderConfigBean;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class QFileDebugSettingFragment
  extends IphoneTitleBarFragment
{
  private IQFileConfigManager a;
  
  private void a()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381321);
    localFormSwitchItem.setChecked(a().a());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.1(this));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381322);
    IQFileAppStorePromoteDialogConfigBean localIQFileAppStorePromoteDialogConfigBean = a();
    localFormSwitchItem.setChecked(localIQFileAppStorePromoteDialogConfigBean.a());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.2(this, localIQFileAppStorePromoteDialogConfigBean));
  }
  
  private void b()
  {
    IQFileFileReaderConfigBean localIQFileFileReaderConfigBean = ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class, "qqfav")).getFileReaderConfig();
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131373752);
    localFormSwitchItem.setChecked(localIQFileFileReaderConfigBean.getIsShowReaderBar());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.3(this, localIQFileFileReaderConfigBean));
  }
  
  private void c()
  {
    EditText localEditText = (EditText)this.mContentView.findViewById(2131365840);
    localEditText.addTextChangedListener(new QFileDebugSettingFragment.4(this));
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131365841);
    localFormSwitchItem.setChecked(this.a.isHarcodeIP());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.5(this, localEditText));
    localEditText.setText(this.a.getHarcodeIP());
    localEditText.setEnabled(localFormSwitchItem.a());
  }
  
  private void d()
  {
    EditText localEditText = (EditText)this.mContentView.findViewById(2131365399);
    localEditText.addTextChangedListener(new QFileDebugSettingFragment.6(this));
    ((FormSimpleItem)this.mContentView.findViewById(2131377842)).setOnClickListener(new QFileDebugSettingFragment.7(this));
    RadioGroup localRadioGroup = (RadioGroup)this.mContentView.findViewById(2131365392);
    localRadioGroup.setOnCheckedChangeListener(new QFileDebugSettingFragment.8(this));
    Object localObject1 = a();
    Object localObject2 = (FormSwitchItem)this.mContentView.findViewById(2131365398);
    ((FormSwitchItem)localObject2).setChecked(((IQFileDatalineConfigBean)localObject1).a());
    ((FormSwitchItem)localObject2).setOnCheckedChangeListener(new QFileDebugSettingFragment.9(this, (IQFileDatalineConfigBean)localObject1));
    localObject2 = (FormSwitchItem)this.mContentView.findViewById(2131365393);
    ((FormSwitchItem)localObject2).setChecked(((IQFileDatalineConfigBean)localObject1).b());
    ((FormSwitchItem)localObject2).setOnCheckedChangeListener(new QFileDebugSettingFragment.10(this, (IQFileDatalineConfigBean)localObject1));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131365400);
    ((FormSwitchItem)localObject1).setChecked(this.a.isWlanOnly());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new QFileDebugSettingFragment.11(this));
    localObject1 = getBaseActivity().app;
    localObject1 = getBaseActivity().app.getApp();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("file_debug_");
    ((StringBuilder)localObject2).append(getBaseActivity().app.getCurrentUin());
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    localObject2 = ((SharedPreferences)localObject1).getString("file_debug_dataline_uin", "");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localEditText.setText((CharSequence)localObject2);
    }
    int i = ((SharedPreferences)localObject1).getInt("file_debug_dataline_device", 65799);
    if (i == 65799)
    {
      localRadioGroup.check(2131365391);
      return;
    }
    if (i == 65793)
    {
      localRadioGroup.check(2131365390);
      return;
    }
    if (i == 65793) {
      localRadioGroup.check(2131365389);
    }
  }
  
  private void e()
  {
    Object localObject = (FormSwitchItem)this.mContentView.findViewById(2131368962);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().debugIsUseLocalConfig());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.12(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131368958);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().debugIsLocalConfigEnableC2CIPv6());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.13(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131368961);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().debugIsLocalConfigEnableGroupIPv6());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.14(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131368960);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().debugIsLocalConfigEnableDiscIPv6());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.15(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131368959);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a().debugIsLocalConfigEnableDatalineIPv6());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.16(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131368957);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.17(this));
    localObject = (RadioGroup)this.mContentView.findViewById(2131377944);
    int i = FileIPv6StrateyController.a().debugGetLocalConfigIPv6Strategy();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          ((RadioGroup)localObject).check(2131377943);
        }
      }
      else {
        ((RadioGroup)localObject).check(2131377942);
      }
    }
    else {
      ((RadioGroup)localObject).check(2131377941);
    }
    ((RadioGroup)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.18(this));
    TextView localTextView = (TextView)this.mContentView.findViewById(2131370463);
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
      localObject = "当前登录协议栈：IPv6";
    } else {
      localObject = "当前登录协议栈：IPv4";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131365072);
    if (this.a.getC2CFileIPv6Switch()) {
      localObject = "c2c开关：打开";
    } else {
      localObject = "c2c开关：关闭";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131365075);
    if (this.a.getGroupFileIPv6Switch()) {
      localObject = "group开关：打开";
    } else {
      localObject = "group开关：关闭";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131365074);
    if (this.a.getDiscFileIPv6Switch()) {
      localObject = "disc开关：打开";
    } else {
      localObject = "disc开关：关闭";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131365073);
    if (this.a.getDatalineFileIPv6Switch()) {
      localObject = "数据线开关：打开";
    } else {
      localObject = "数据线开关：关闭";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131365080);
    if (this.a.getFileIPv6Strategy() == 0) {
      localObject = "IPv6策略：v4优先";
    } else if (this.a.getFileIPv6Strategy() == 1) {
      localObject = "IPv6策略：v6优先";
    } else if (this.a.getFileIPv6Strategy() == 2) {
      localObject = "IPv6策略：跟随登录";
    } else {
      localObject = "IPv6策略：unkonw";
    }
    localTextView.setText((CharSequence)localObject);
  }
  
  private void f()
  {
    QQAppInterface localQQAppInterface = getBaseActivity().app;
    if (localQQAppInterface == null) {
      return;
    }
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362726);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().a().a());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.19(this, localQQAppInterface));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362725);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().a().b());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.20(this, localQQAppInterface));
  }
  
  IQFileAppStorePromoteConfigBean a()
  {
    return ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteConfig();
  }
  
  IQFileAppStorePromoteDialogConfigBean a()
  {
    return ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteDialogConfig();
  }
  
  IQFileDatalineConfigBean a()
  {
    return ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class)).getDatalineConfig();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class, ""));
    a();
    e();
    b();
    c();
    f();
    d();
  }
  
  protected int getContentLayoutId()
  {
    return 2131560811;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */