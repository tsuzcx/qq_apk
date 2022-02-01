package com.tencent.mobileqq.guild.client;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public abstract class GuildClientAuthorizationAbstractDialogFragment
  extends BottomSheetDialogFragment
  implements View.OnClickListener
{
  protected View a;
  public LinearLayout b;
  protected GuildClientAuthorizationAbstractViewModel c;
  protected GuildClientAuthDialogParams d;
  private TextView e;
  private TextView f;
  
  private void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, int paramInt)
  {
    this.c = ((GuildClientAuthorizationAbstractViewModel)ViewModelProviderHelper.a(this, GuildClientAuthorizationAbstractViewModel.a).get(GuildClientAuthorizationAbstractViewModel.class));
    this.c.a((AppInterface)paramQBaseActivity.getAppRuntime(), paramString1, paramString2, paramInt);
    this.c.e().observe(this, new GuildClientAuthorizationAbstractDialogFragment.1(this, paramQBaseActivity));
    this.c.d().observe(this, new GuildClientAuthorizationAbstractDialogFragment.2(this, paramQBaseActivity));
    this.c.f().observe(this, new GuildClientAuthorizationAbstractDialogFragment.3(this, paramQBaseActivity));
  }
  
  private void a(GuildClientManageViewModel.RoleInfo paramRoleInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("client_role_is_bind", paramRoleInfo.a);
    localIntent.putExtra("client_role_name", paramRoleInfo.b);
    localIntent.putExtra("client_role_id", paramRoleInfo.c);
    paramRoleInfo = getTargetFragment();
    if (paramRoleInfo != null) {
      paramRoleInfo.onActivityResult(getTargetRequestCode(), -1, localIntent);
    }
  }
  
  private void b()
  {
    this.d = ((GuildClientAuthDialogParams)getArguments().getParcelable("GuildClientAuthorizationParam"));
    if (this.d == null) {
      getActivity().finish();
    }
    String str1 = this.d.h();
    String str2 = this.d.f();
    int i = this.d.j();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      QLog.e("GuildClientAuthorizationAbstractDialogFragment", 1, String.format("open GuildClientAuthorizationAbstractDialogFragment clientId:%s, guildId:%s, jumpUrl:%s", new Object[] { str1, str2, this.d.k() }));
      dismiss();
    }
    a((QBaseActivity)getActivity(), str1, str2, i);
  }
  
  private void c()
  {
    if (TextUtils.isEmpty(this.c.b())) {
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.a, e());
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.a, this.c.b(), null);
  }
  
  private void d()
  {
    VideoReport.setElementId(this.f, f());
    VideoReport.setElementParam(this.f, "sgrp_otherapp_id", this.c.a());
    VideoReport.setElementClickPolicy(this.f, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(this.f, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementEndExposePolicy(this.f, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementId(this.e, g());
    VideoReport.setElementParam(this.e, "sgrp_otherapp_id", this.c.a());
    VideoReport.setElementClickPolicy(this.f, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(this.f, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementEndExposePolicy(this.f, EndExposurePolicy.REPORT_ALL);
  }
  
  private String e()
  {
    if ((this.c.c() != 2) && (this.c.c() != 4) && (this.c.c() != 5))
    {
      if (this.c.c() == 1) {
        return "pg_sgrp_personalfile_set";
      }
      if (this.c.c() == 3) {
        return "pg_sgrp_channel";
      }
      return "";
    }
    return "pg_sgrp_aio";
  }
  
  private String f()
  {
    if ((this.c.c() != 2) && (this.c.c() != 4) && (this.c.c() != 5))
    {
      if (this.c.c() == 1) {
        return "em_sgrp_otherapp_authorization_allow";
      }
      if (this.c.c() == 3) {
        return "em_sgrp_channel_otherapp_authorization_allow";
      }
      return "";
    }
    return "em_sgrp_aio_otherapp_authorization_allow";
  }
  
  private String g()
  {
    if ((this.c.c() != 2) && (this.c.c() != 4) && (this.c.c() != 5))
    {
      if (this.c.c() == 1) {
        return "em_sgrp_otherapp_authorization_refuse";
      }
      if (this.c.c() == 3) {
        return "em_sgrp_channel_otherapp_authorization_refuse";
      }
      return "";
    }
    return "em_sgrp_aio_otherapp_authorization_refuse";
  }
  
  protected abstract View a();
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      dismiss();
    } else if ((paramView == this.f) && (!QQGuildUIUtil.a())) {
      this.c.g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2131625022, paramViewGroup, false);
    this.e = ((TextView)this.a.findViewById(2131428912));
    this.f = ((TextView)this.a.findViewById(2131428916));
    this.b = ((LinearLayout)this.a.findViewById(2131431340));
    paramLayoutInflater = new LinearLayout.LayoutParams(-1, -2);
    this.b.addView(a(), paramLayoutInflater);
    setCancelable(false);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    b();
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    ((ViewGroup)this.a.getParent()).setBackgroundColor(0);
  }
  
  public void onStart()
  {
    super.onStart();
    c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientAuthorizationAbstractDialogFragment
 * JD-Core Version:    0.7.0.1
 */