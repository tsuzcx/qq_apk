package com.tencent.mobileqq.guild.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;

public class GuildClientManageFragment
  extends QQGuildTitleBarFragment
  implements View.OnClickListener
{
  private GuildSwitchButton o;
  private GuildSwitchButton p;
  private GuildSwitchButton q;
  private TextView r;
  private TextView s;
  private QQProgressDialog t;
  private GuildClientManageViewModel u;
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131890567));
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, @NonNull String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("guild_id", paramString);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, GuildClientManageFragment.class);
  }
  
  private void a(String paramString, GuildClientManageViewModel.RoleInfo paramRoleInfo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_otherapp_id", ((GuildClientManageViewModel.ClientInfo)this.u.g().getValue()).a);
    int i;
    if (paramRoleInfo.a) {
      i = 1;
    } else {
      i = 2;
    }
    localHashMap.put("sgrp_bind_result", Integer.valueOf(i));
    VideoReport.reportEvent(paramString, this.o, localHashMap);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_otherapp_id", ((GuildClientManageViewModel.ClientInfo)this.u.g().getValue()).a);
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    localHashMap.put("sgrp_record_switch_status", Integer.valueOf(i));
    VideoReport.reportEvent(paramString, this.p, localHashMap);
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_otherapp_id", ((GuildClientManageViewModel.ClientInfo)this.u.g().getValue()).a);
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    localHashMap.put("sgrp_status_switch_status", Integer.valueOf(i));
    VideoReport.reportEvent(paramString, this.q, localHashMap);
  }
  
  private void j()
  {
    this.a.setOnClickListener(this);
    this.c.setText(getString(2131890583));
    this.o = ((GuildSwitchButton)this.l.findViewById(2131429508));
    this.r = ((TextView)this.l.findViewById(2131430785));
    this.s = ((TextView)this.l.findViewById(2131445119));
    this.p = ((GuildSwitchButton)this.l.findViewById(2131445891));
    this.q = ((GuildSwitchButton)this.l.findViewById(2131445908));
    this.t = new QQProgressDialog(getActivity());
    this.l.postDelayed(new GuildClientManageFragment.1(this), 700L);
    if (AppSetting.e)
    {
      this.p.setContentDescription(getString(2131890592));
      this.q.setContentDescription(getString(2131890593));
    }
  }
  
  private void k()
  {
    this.u = ((GuildClientManageViewModel)ViewModelProviderHelper.a(this, GuildClientManageViewModel.a).get(GuildClientManageViewModel.class));
    i();
    String str = getActivity().getIntent().getExtras().getString("guild_id");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("GuildClientManageFragment", 1, String.format("open openGuildClientManageFragment guildId is null", new Object[0]));
      getActivity().finish();
    }
    this.u.a(l(), str);
    this.o.setOnCheckedChangeListener(new GuildClientManageFragment.2(this));
    this.p.setOnCheckedChangeListener(new GuildClientManageFragment.3(this));
    this.q.setOnCheckedChangeListener(new GuildClientManageFragment.4(this));
  }
  
  private void m()
  {
    if (TextUtils.isEmpty(this.u.h())) {
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_personalfile_set");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.u.h(), null);
  }
  
  private void n()
  {
    QQGuildUtil.a(this.o, "em_sgrp_bind_otherapp_accout", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    QQGuildUtil.a(this.q, "em_sgrp_showstatus_switch", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    QQGuildUtil.a(this.p, "em_sgrp_showrecord_switch", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    j();
    k();
    m();
    n();
  }
  
  protected int b()
  {
    return 2131625024;
  }
  
  void i()
  {
    this.u.c().observe(getViewLifecycleOwner(), new GuildClientManageFragment.5(this));
    this.u.a().observe(getViewLifecycleOwner(), new GuildClientManageFragment.6(this));
    this.u.b().observe(getViewLifecycleOwner(), new GuildClientManageFragment.7(this));
    this.u.d().observe(getViewLifecycleOwner(), new GuildClientManageFragment.8(this));
    this.u.e().observe(getViewLifecycleOwner(), new GuildClientManageFragment.9(this));
    this.u.f().observe(getViewLifecycleOwner(), new GuildClientManageFragment.10(this));
    this.u.g().observe(getViewLifecycleOwner(), new GuildClientManageFragment.11(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("client_role_is_bind", false);
      paramIntent = new GuildClientManageViewModel.RoleInfo(bool, paramIntent.getStringExtra("client_role_name"), paramIntent.getStringExtra("client_role_id"));
      this.u.c().setValue(paramIntent);
      this.p.setChecked(bool);
      this.q.setChecked(bool);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a) {
      onBackEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    QQProgressDialog localQQProgressDialog = this.t;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.u.n();
  }
  
  public void onResume()
  {
    super.onResume();
    this.u.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment
 * JD-Core Version:    0.7.0.1
 */