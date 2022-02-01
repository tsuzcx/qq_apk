package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.util.AutoSaveUtils;
import com.tencent.util.VersionUtils;
import mqq.app.AppRuntime;

public class QQSettingAutoDownloadAndSaveFragment
  extends IphoneTitleBarFragment
{
  FormSwitchItem a;
  FormSwitchItem b;
  FormSwitchItem c;
  FormSwitchItem d;
  FormSwitchItem e;
  private QQAppInterface f;
  private BounceScrollView g;
  
  private void a()
  {
    this.g = ((BounceScrollView)this.mContentView.findViewById(2131445362));
    if (VersionUtils.c()) {
      this.g.setOverScrollMode(0);
    }
    ReportController.b(null, "dc00898", "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0X800ABAF", "0X800ABAF", 0, 1, "", "", "", "");
    this.a = ((FormSwitchItem)this.mContentView.findViewById(2131428925));
    this.b = ((FormSwitchItem)this.mContentView.findViewById(2131428924));
    this.c = ((FormSwitchItem)this.mContentView.findViewById(2131449145));
    this.d = ((FormSwitchItem)this.mContentView.findViewById(2131428926));
    this.e = ((FormSwitchItem)this.mContentView.findViewById(2131428927));
    this.a.setVisibility(0);
    boolean bool = SettingCloneUtil.readValue(getBaseActivity(), null, getString(2131892713), "qqsetting_auto_receive_pic_key", true);
    this.a.setChecked(bool);
    this.a.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.1(this));
    FormSwitchItem localFormSwitchItem = this.b;
    int i;
    if (MagicfaceViewController.b()) {
      i = 0;
    } else {
      i = 8;
    }
    localFormSwitchItem.setVisibility(i);
    bool = SettingCloneUtil.readValue(getBaseActivity(), null, getString(2131892713), "qqsetting_auto_receive_magic_face_key", true);
    this.b.setChecked(bool);
    this.b.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.2(this));
    bool = ConfigHandler.a(this.f, false);
    this.c.setChecked(bool);
    this.c.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.3(this));
    bool = AutoSaveUtils.a(true);
    this.d.setChecked(bool);
    this.d.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.4(this));
    bool = AutoSaveUtils.a(false);
    this.e.setChecked(bool);
    this.e.setOnCheckedChangeListener(new QQSettingAutoDownloadAndSaveFragment.5(this));
    if (VersionUtils.c()) {
      this.g.setOverScrollMode(0);
    }
    if (AppSetting.e)
    {
      this.a.setContentDescription(getString(2131916280));
      this.b.setContentDescription(getString(2131916279));
      this.c.setContentDescription(getString(2131917766));
      this.d.setContentDescription(getString(2131916277));
      this.e.setContentDescription(getString(2131916278));
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.f = ((QQAppInterface)getBaseActivity().getAppRuntime());
      if (this.f != null) {
        a();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627791;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131916286));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment
 * JD-Core Version:    0.7.0.1
 */