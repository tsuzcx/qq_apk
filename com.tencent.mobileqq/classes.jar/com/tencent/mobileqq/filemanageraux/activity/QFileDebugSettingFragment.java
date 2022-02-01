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
  
  private void d()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131450373);
    localFormSwitchItem.setChecked(a().a());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.1(this));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131450374);
    IQFileAppStorePromoteDialogConfigBean localIQFileAppStorePromoteDialogConfigBean = b();
    localFormSwitchItem.setChecked(localIQFileAppStorePromoteDialogConfigBean.a());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.2(this, localIQFileAppStorePromoteDialogConfigBean));
  }
  
  private void e()
  {
    IQFileFileReaderConfigBean localIQFileFileReaderConfigBean = ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class, "qqfav")).getFileReaderConfig();
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131441426);
    localFormSwitchItem.setChecked(localIQFileFileReaderConfigBean.getIsShowReaderBar());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.3(this, localIQFileFileReaderConfigBean));
  }
  
  private void f()
  {
    EditText localEditText = (EditText)this.mContentView.findViewById(2131432098);
    localEditText.addTextChangedListener(new QFileDebugSettingFragment.4(this));
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131432099);
    localFormSwitchItem.setChecked(this.a.isHarcodeIP());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.5(this, localEditText));
    localEditText.setText(this.a.getHarcodeIP());
    localEditText.setEnabled(localFormSwitchItem.a());
  }
  
  private void g()
  {
    EditText localEditText = (EditText)this.mContentView.findViewById(2131431599);
    localEditText.addTextChangedListener(new QFileDebugSettingFragment.6(this));
    ((FormSimpleItem)this.mContentView.findViewById(2131446315)).setOnClickListener(new QFileDebugSettingFragment.7(this));
    RadioGroup localRadioGroup = (RadioGroup)this.mContentView.findViewById(2131431592);
    localRadioGroup.setOnCheckedChangeListener(new QFileDebugSettingFragment.8(this));
    Object localObject1 = c();
    Object localObject2 = (FormSwitchItem)this.mContentView.findViewById(2131431598);
    ((FormSwitchItem)localObject2).setChecked(((IQFileDatalineConfigBean)localObject1).a());
    ((FormSwitchItem)localObject2).setOnCheckedChangeListener(new QFileDebugSettingFragment.9(this, (IQFileDatalineConfigBean)localObject1));
    localObject2 = (FormSwitchItem)this.mContentView.findViewById(2131431593);
    ((FormSwitchItem)localObject2).setChecked(((IQFileDatalineConfigBean)localObject1).e());
    ((FormSwitchItem)localObject2).setOnCheckedChangeListener(new QFileDebugSettingFragment.10(this, (IQFileDatalineConfigBean)localObject1));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131431600);
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
      localRadioGroup.check(2131431591);
      return;
    }
    if (i == 65793)
    {
      localRadioGroup.check(2131431590);
      return;
    }
    if (i == 65793) {
      localRadioGroup.check(2131431589);
    }
  }
  
  private void h()
  {
    Object localObject = (FormSwitchItem)this.mContentView.findViewById(2131435915);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.b().debugIsUseLocalConfig());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.12(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131435911);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.b().debugIsLocalConfigEnableC2CIPv6());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.13(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131435914);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.b().debugIsLocalConfigEnableGroupIPv6());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.14(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131435913);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.b().debugIsLocalConfigEnableDiscIPv6());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.15(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131435912);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.b().debugIsLocalConfigEnableDatalineIPv6());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.16(this));
    localObject = (FormSwitchItem)this.mContentView.findViewById(2131435910);
    ((FormSwitchItem)localObject).setChecked(FileIPv6StrateyController.a());
    ((FormSwitchItem)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.17(this));
    localObject = (RadioGroup)this.mContentView.findViewById(2131446430);
    int i = FileIPv6StrateyController.b().debugGetLocalConfigIPv6Strategy();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          ((RadioGroup)localObject).check(2131446429);
        }
      }
      else {
        ((RadioGroup)localObject).check(2131446428);
      }
    }
    else {
      ((RadioGroup)localObject).check(2131446427);
    }
    ((RadioGroup)localObject).setOnCheckedChangeListener(new QFileDebugSettingFragment.18(this));
    TextView localTextView = (TextView)this.mContentView.findViewById(2131437735);
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
      localObject = "当前登录协议栈：IPv6";
    } else {
      localObject = "当前登录协议栈：IPv4";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131431207);
    if (this.a.getC2CFileIPv6Switch()) {
      localObject = "c2c开关：打开";
    } else {
      localObject = "c2c开关：关闭";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131431210);
    if (this.a.getGroupFileIPv6Switch()) {
      localObject = "group开关：打开";
    } else {
      localObject = "group开关：关闭";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131431209);
    if (this.a.getDiscFileIPv6Switch()) {
      localObject = "disc开关：打开";
    } else {
      localObject = "disc开关：关闭";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131431208);
    if (this.a.getDatalineFileIPv6Switch()) {
      localObject = "数据线开关：打开";
    } else {
      localObject = "数据线开关：关闭";
    }
    localTextView.setText((CharSequence)localObject);
    localTextView = (TextView)this.mContentView.findViewById(2131431217);
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
  
  private void i()
  {
    QQAppInterface localQQAppInterface = getBaseActivity().app;
    if (localQQAppInterface == null) {
      return;
    }
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131428412);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().i().c());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.19(this, localQQAppInterface));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131428411);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().i().d());
    localFormSwitchItem.setOnCheckedChangeListener(new QFileDebugSettingFragment.20(this, localQQAppInterface));
  }
  
  IQFileAppStorePromoteConfigBean a()
  {
    return ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteConfig();
  }
  
  IQFileAppStorePromoteDialogConfigBean b()
  {
    return ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class)).getYYBPromoteDialogConfig();
  }
  
  IQFileDatalineConfigBean c()
  {
    return ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class)).getDatalineConfig();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((IQFileConfigManager)getBaseActivity().app.getRuntimeService(IQFileConfigManager.class, ""));
    d();
    h();
    e();
    f();
    i();
    g();
  }
  
  protected int getContentLayoutId()
  {
    return 2131627069;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */