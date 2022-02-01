package com.tencent.mobileqq.filemanageraux.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import aqvq;
import aqvs;
import aqwh;
import aszd;
import atam;
import atcq;
import atee;
import atyr;
import atys;
import atyt;
import atyu;
import atyv;
import atyw;
import atyx;
import atyy;
import atyz;
import atza;
import atzb;
import atzc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class QFileDebugSettingFragment
  extends IphoneTitleBarFragment
{
  private atam a;
  
  private void a()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381383);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new atyr(this));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381384);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new atyv(this));
  }
  
  private void b()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131373623);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new atyw(this));
  }
  
  private void c()
  {
    Object localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368744);
    ((FormSwitchItem)localObject1).setChecked(atcq.a().b());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atyx(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368740);
    ((FormSwitchItem)localObject1).setChecked(atcq.a().c());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atyy(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368743);
    ((FormSwitchItem)localObject1).setChecked(atcq.a().d());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atyz(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368742);
    ((FormSwitchItem)localObject1).setChecked(atcq.a().e());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atza(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368741);
    ((FormSwitchItem)localObject1).setChecked(atcq.a().f());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atzb(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368739);
    ((FormSwitchItem)localObject1).setChecked(atcq.a());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atzc(this));
    localObject1 = (RadioGroup)this.mContentView.findViewById(2131377907);
    Object localObject2;
    TextView localTextView;
    switch (atcq.a().a())
    {
    default: 
      ((RadioGroup)localObject1).setOnCheckedChangeListener(new atys(this));
      localObject2 = (TextView)this.mContentView.findViewById(2131370295);
      localObject1 = "当前登录协议栈：IPv4";
      if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
        localObject1 = "当前登录协议栈：IPv6";
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = (atam)getActivity().app.getManager(317);
      localTextView = (TextView)this.mContentView.findViewById(2131364900);
      localObject1 = "c2c开关：关闭";
      if (((atam)localObject2).d()) {
        localObject1 = "c2c开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364903);
      localObject1 = "group开关：关闭";
      if (((atam)localObject2).e()) {
        localObject1 = "group开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364902);
      localObject1 = "disc开关：关闭";
      if (((atam)localObject2).f()) {
        localObject1 = "disc开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364901);
      localObject1 = "数据线开关：关闭";
      if (((atam)localObject2).g()) {
        localObject1 = "数据线开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364908);
      if (((atam)localObject2).a() == 0) {
        localObject1 = "IPv6策略：v4优先";
      }
      break;
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject1);
      return;
      ((RadioGroup)localObject1).check(2131377904);
      break;
      ((RadioGroup)localObject1).check(2131377905);
      break;
      ((RadioGroup)localObject1).check(2131377906);
      break;
      if (((atam)localObject2).a() == 1) {
        localObject1 = "IPv6策略：v6优先";
      } else if (((atam)localObject2).a() == 2) {
        localObject1 = "IPv6策略：跟随登录";
      } else {
        localObject1 = "IPv6策略：unkonw";
      }
    }
  }
  
  private void d()
  {
    QQAppInterface localQQAppInterface = getActivity().app;
    if (localQQAppInterface == null) {
      return;
    }
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362707);
    localFormSwitchItem.setChecked(localQQAppInterface.a().a().a());
    localFormSwitchItem.setOnCheckedChangeListener(new atyt(this, localQQAppInterface));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362706);
    localFormSwitchItem.setChecked(localQQAppInterface.a().a().b());
    localFormSwitchItem.setOnCheckedChangeListener(new atyu(this, localQQAppInterface));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((atam)getActivity().app.getManager(317));
    a();
    c();
    b();
    d();
  }
  
  public int getContentLayoutId()
  {
    return 2131560873;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */