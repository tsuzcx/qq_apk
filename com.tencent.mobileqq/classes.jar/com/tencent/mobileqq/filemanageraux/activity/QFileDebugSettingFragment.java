package com.tencent.mobileqq.filemanageraux.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import arle;
import arlg;
import arlv;
import atqx;
import atsh;
import atul;
import atvy;
import auqm;
import auqn;
import auqo;
import auqp;
import auqq;
import auqr;
import auqs;
import auqt;
import auqu;
import auqv;
import auqw;
import auqx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class QFileDebugSettingFragment
  extends IphoneTitleBarFragment
{
  private atsh a;
  
  private void a()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381572);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new auqm(this));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131381573);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new auqq(this));
  }
  
  private void b()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131373742);
    localFormSwitchItem.setChecked(this.a.a().a);
    localFormSwitchItem.setOnCheckedChangeListener(new auqr(this));
  }
  
  private void c()
  {
    Object localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368818);
    ((FormSwitchItem)localObject1).setChecked(atul.a().b());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auqs(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368814);
    ((FormSwitchItem)localObject1).setChecked(atul.a().c());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auqt(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368817);
    ((FormSwitchItem)localObject1).setChecked(atul.a().d());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auqu(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368816);
    ((FormSwitchItem)localObject1).setChecked(atul.a().e());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auqv(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368815);
    ((FormSwitchItem)localObject1).setChecked(atul.a().f());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auqw(this));
    localObject1 = (FormSwitchItem)this.mContentView.findViewById(2131368813);
    ((FormSwitchItem)localObject1).setChecked(atul.a());
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new auqx(this));
    localObject1 = (RadioGroup)this.mContentView.findViewById(2131378060);
    Object localObject2;
    TextView localTextView;
    switch (atul.a().a())
    {
    default: 
      ((RadioGroup)localObject1).setOnCheckedChangeListener(new auqn(this));
      localObject2 = (TextView)this.mContentView.findViewById(2131370396);
      localObject1 = "当前登录协议栈：IPv4";
      if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
        localObject1 = "当前登录协议栈：IPv6";
      }
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = (atsh)getActivity().app.getManager(317);
      localTextView = (TextView)this.mContentView.findViewById(2131364947);
      localObject1 = "c2c开关：关闭";
      if (((atsh)localObject2).d()) {
        localObject1 = "c2c开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364950);
      localObject1 = "group开关：关闭";
      if (((atsh)localObject2).e()) {
        localObject1 = "group开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364949);
      localObject1 = "disc开关：关闭";
      if (((atsh)localObject2).f()) {
        localObject1 = "disc开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364948);
      localObject1 = "数据线开关：关闭";
      if (((atsh)localObject2).g()) {
        localObject1 = "数据线开关：打开";
      }
      localTextView.setText((CharSequence)localObject1);
      localTextView = (TextView)this.mContentView.findViewById(2131364955);
      if (((atsh)localObject2).a() == 0) {
        localObject1 = "IPv6策略：v4优先";
      }
      break;
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject1);
      return;
      ((RadioGroup)localObject1).check(2131378057);
      break;
      ((RadioGroup)localObject1).check(2131378058);
      break;
      ((RadioGroup)localObject1).check(2131378059);
      break;
      if (((atsh)localObject2).a() == 1) {
        localObject1 = "IPv6策略：v6优先";
      } else if (((atsh)localObject2).a() == 2) {
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
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362725);
    localFormSwitchItem.setChecked(localQQAppInterface.a().a().a());
    localFormSwitchItem.setOnCheckedChangeListener(new auqo(this, localQQAppInterface));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131362724);
    localFormSwitchItem.setChecked(localQQAppInterface.a().a().b());
    localFormSwitchItem.setOnCheckedChangeListener(new auqp(this, localQQAppInterface));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((atsh)getActivity().app.getManager(317));
    a();
    c();
    b();
    d();
  }
  
  public int getContentLayoutId()
  {
    return 2131560904;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */