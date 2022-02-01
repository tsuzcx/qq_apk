package com.tencent.mobileqq.filemanageraux.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import arii;
import arik;
import ariz;
import athn;
import atix;
import atlb;
import atmo;
import auhb;
import auhc;
import auhd;
import auhe;
import auhf;
import auhg;
import auhh;
import auhi;
import auhj;
import auhk;
import auhl;
import auhm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class QFileDebugSettingFragment
  extends IphoneTitleBarFragment
{
  private atix a;
  
  private void a()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381652);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new auhb(this));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381653);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new auhf(this));
  }
  
  private void b()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131373881);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new auhg(this));
  }
  
  private void c()
  {
    Object localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131369001);
    ((FormSwitchItem)localObject1).setChecked(atlb.a().b());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auhh(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368997);
    ((FormSwitchItem)localObject1).setChecked(atlb.a().c());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auhi(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131369000);
    ((FormSwitchItem)localObject1).setChecked(atlb.a().d());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auhj(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368999);
    ((FormSwitchItem)localObject1).setChecked(atlb.a().e());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auhk(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368998);
    ((FormSwitchItem)localObject1).setChecked(atlb.a().f());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auhl(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368996);
    ((FormSwitchItem)localObject1).setChecked(atlb.a());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auhm(this));
    localObject1 = (RadioGroup)this.mContentView.findViewById(2131378112);
    Object localObject2;
    TextView localTextView;
    switch (atlb.a().a())
    {
    default: 
      ((RadioGroup)localObject1).setOnCheckedChangeListener(new auhc(this));
      localObject2 = (TextView)this.mContentView.findViewById(2131370547);
      localObject1 = "当前登录协议栈：IPv4";
      if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
        localObject1 = "当前登录协议栈：IPv6";
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = (atix)getActivity().app.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
      localTextView = (TextView)this.mContentView.findViewById(2131365058);
      localObject1 = "c2c开关：关闭";
      if (((atix)localObject2).d()) {
        localObject1 = "c2c开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131365061);
      localObject1 = "group开关：关闭";
      if (((atix)localObject2).e()) {
        localObject1 = "group开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131365060);
      localObject1 = "disc开关：关闭";
      if (((atix)localObject2).f()) {
        localObject1 = "disc开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131365059);
      localObject1 = "数据线开关：关闭";
      if (((atix)localObject2).g()) {
        localObject1 = "数据线开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131365066);
      if (((atix)localObject2).a() == 0) {
        localObject1 = "IPv6策略：v4优先";
      }
      break;
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject1);
      return;
      ((RadioGroup)localObject1).check(2131378109);
      break;
      ((RadioGroup)localObject1).check(2131378110);
      break;
      ((RadioGroup)localObject1).check(2131378111);
      break;
      if (((atix)localObject2).a() == 1) {
        localObject1 = "IPv6策略：v6优先";
      } else if (((atix)localObject2).a() == 2) {
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
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362746);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().a().a());
    localFormSwitchItem.setOnCheckedChangeListener(new auhd(this, localQQAppInterface));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362745);
    localFormSwitchItem.setChecked(localQQAppInterface.getFileManagerEngine().a().b());
    localFormSwitchItem.setOnCheckedChangeListener(new auhe(this, localQQAppInterface));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((atix)getActivity().app.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER));
    a();
    c();
    b();
    d();
  }
  
  public int getContentLayoutId()
  {
    return 2131560844;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */