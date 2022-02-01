package com.tencent.mobileqq.filemanageraux.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import aqfb;
import aqfd;
import aqfs;
import asdg;
import aser;
import asgv;
import asii;
import atcu;
import atcv;
import atcw;
import atcx;
import atcy;
import atcz;
import atda;
import atdb;
import atdc;
import atdd;
import atde;
import atdf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class QFileDebugSettingFragment
  extends IphoneTitleBarFragment
{
  private aser a;
  
  private void a()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381289);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new atcu(this));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381290);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new atcy(this));
  }
  
  private void b()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131373664);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new atcz(this));
  }
  
  private void c()
  {
    Object localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368843);
    ((FormSwitchItem)localObject1).setChecked(asgv.a().b());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atda(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368839);
    ((FormSwitchItem)localObject1).setChecked(asgv.a().c());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atdb(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368842);
    ((FormSwitchItem)localObject1).setChecked(asgv.a().d());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atdc(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368841);
    ((FormSwitchItem)localObject1).setChecked(asgv.a().e());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atdd(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368840);
    ((FormSwitchItem)localObject1).setChecked(asgv.a().f());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atde(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368838);
    ((FormSwitchItem)localObject1).setChecked(asgv.a());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new atdf(this));
    localObject1 = (RadioGroup)this.mContentView.findViewById(2131377830);
    Object localObject2;
    TextView localTextView;
    switch (asgv.a().a())
    {
    default: 
      ((RadioGroup)localObject1).setOnCheckedChangeListener(new atcv(this));
      localObject2 = (TextView)this.mContentView.findViewById(2131370364);
      localObject1 = "当前登录协议栈：IPv4";
      if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
        localObject1 = "当前登录协议栈：IPv6";
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = (aser)getActivity().app.getManager(317);
      localTextView = (TextView)this.mContentView.findViewById(2131364974);
      localObject1 = "c2c开关：关闭";
      if (((aser)localObject2).d()) {
        localObject1 = "c2c开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364977);
      localObject1 = "group开关：关闭";
      if (((aser)localObject2).e()) {
        localObject1 = "group开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364976);
      localObject1 = "disc开关：关闭";
      if (((aser)localObject2).f()) {
        localObject1 = "disc开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364975);
      localObject1 = "数据线开关：关闭";
      if (((aser)localObject2).g()) {
        localObject1 = "数据线开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364982);
      if (((aser)localObject2).a() == 0) {
        localObject1 = "IPv6策略：v4优先";
      }
      break;
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject1);
      return;
      ((RadioGroup)localObject1).check(2131377827);
      break;
      ((RadioGroup)localObject1).check(2131377828);
      break;
      ((RadioGroup)localObject1).check(2131377829);
      break;
      if (((aser)localObject2).a() == 1) {
        localObject1 = "IPv6策略：v6优先";
      } else if (((aser)localObject2).a() == 2) {
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
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362730);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().a().a());
    localFormSwitchItem.setOnCheckedChangeListener(new atcw(this, localQQAppInterface));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362729);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().a().b());
    localFormSwitchItem.setOnCheckedChangeListener(new atcx(this, localQQAppInterface));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((aser)getActivity().app.getManager(317));
    a();
    c();
    b();
    d();
  }
  
  public int getContentLayoutId()
  {
    return 2131560784;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */