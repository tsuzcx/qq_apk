package com.tencent.mobileqq.guild.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import java.util.List;

public class GuildClientSelectRoleDialogFragment
  extends BottomSheetDialogFragment
  implements View.OnClickListener
{
  private View a;
  private TextView b;
  private GuildClientSelectRoleListAdapter c;
  private GuildClientSelectRoleViewModel d;
  private GuildClientSelectRoleDialogParams e;
  
  private void a(View paramView)
  {
    VideoReport.setElementId(paramView, e());
    VideoReport.setElementParam(paramView, "sgrp_otherapp_id", this.d.e());
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_ALL);
  }
  
  public static void a(QBaseActivity paramQBaseActivity, Fragment paramFragment, GuildClientSelectRoleDialogParams paramGuildClientSelectRoleDialogParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showSelectRoleListDialog params：");
    ((StringBuilder)localObject).append(paramGuildClientSelectRoleDialogParams.toString());
    QLog.d("GuildClientSelectRoleDialogFragment", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("guildClientSelectRoleDialogFragment", paramGuildClientSelectRoleDialogParams);
    paramGuildClientSelectRoleDialogParams = new GuildClientSelectRoleDialogFragment();
    paramGuildClientSelectRoleDialogParams.setArguments((Bundle)localObject);
    if (paramFragment != null) {
      paramGuildClientSelectRoleDialogParams.setTargetFragment(paramFragment, 1);
    }
    paramGuildClientSelectRoleDialogParams.show(paramQBaseActivity.getSupportFragmentManager(), "GuildClientSelectRoleDialogFragment");
  }
  
  private void a(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, int paramInt)
  {
    this.d = ((GuildClientSelectRoleViewModel)ViewModelProviderHelper.a(this, GuildClientSelectRoleViewModel.b).get(GuildClientSelectRoleViewModel.class));
    this.d.a((AppInterface)paramQBaseActivity.getAppRuntime(), paramString1, paramString2, paramInt);
    this.d.a().observe(this, new GuildClientSelectRoleDialogFragment.1(this, paramQBaseActivity));
    this.d.b().observe(this, new GuildClientSelectRoleDialogFragment.2(this, paramQBaseActivity));
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
    this.e = ((GuildClientSelectRoleDialogParams)getArguments().getParcelable("guildClientSelectRoleDialogFragment"));
    if (this.e == null) {
      getActivity().finish();
    }
    String str = this.e.h();
    Object localObject = this.e.f();
    int i = this.e.j();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      QLog.e("GuildClientSelectRoleDialogFragment", 2, "open GuildClientSelectRoleDialogFragment clientId or guildId is null");
      dismiss();
    }
    a((QBaseActivity)getActivity(), str, (String)localObject, i);
    str = this.e.b().b();
    localObject = this.e.b().a();
    if (localObject == null)
    {
      QLog.e("GuildClientSelectRoleDialogFragment", 2, "open GuildClientSelectRoleDialogFragment roleList is null");
      dismiss();
    }
    this.b.setText(str);
    this.c.a((List)localObject);
  }
  
  private void c()
  {
    if (TextUtils.isEmpty(this.d.d())) {
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.a, d());
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.a, this.d.d(), null);
  }
  
  private String d()
  {
    if ((this.d.c() != 2) && (this.d.c() != 4) && (this.d.c() != 5))
    {
      if (this.d.c() == 1) {
        return "pg_sgrp_personalfile_set";
      }
      if (this.d.c() == 3) {
        return "pg_sgrp_channel";
      }
      return "";
    }
    return "pg_sgrp_aio";
  }
  
  private String e()
  {
    if ((this.d.c() != 2) && (this.d.c() != 4) && (this.d.c() != 5))
    {
      if (this.d.c() == 1) {
        return "em_sgrp_otherapp_role_selection_panel";
      }
      if (this.d.c() == 3) {
        return "em_sgrp_channel_otherapp_role_selection_panel";
      }
      return "";
    }
    return "em_sgrp_aio_otherapp_role_selection_panel";
  }
  
  private String f()
  {
    if ((this.d.c() != 2) && (this.d.c() != 4) && (this.d.c() != 5))
    {
      if (this.d.c() == 1) {
        return "em_sgrp_otherapp_role_confirm";
      }
      if (this.d.c() == 3) {
        return "em_sgrp_channel_otherapp_role_confirm";
      }
      return "";
    }
    return "em_sgrp_aio_otherapp_role_confirm";
  }
  
  private void g()
  {
    View localView = this.a.findViewById(2131446561);
    VideoReport.setElementId(localView, f());
    VideoReport.setElementParam(localView, "sgrp_otherapp_id", this.d.e());
    VideoReport.setElementExposePolicy(localView, ExposurePolicy.REPORT_ALL);
    VideoReport.setElementClickPolicy(localView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementEndExposePolicy(localView, EndExposurePolicy.REPORT_ALL);
  }
  
  public GuildClientRoleInfo.RoleInfo a()
  {
    return this.c.a();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131446561) && (!QQGuildUIUtil.a())) {
      this.d.a(a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = paramLayoutInflater.inflate(2131625025, paramViewGroup, false);
    this.b = ((TextView)this.a.findViewById(2131447463));
    paramLayoutInflater = (RecyclerView)this.a.findViewById(2131445118);
    paramLayoutInflater.setLayoutManager(new LinearLayoutManager(getActivity()));
    this.c = new GuildClientSelectRoleListAdapter(getActivity());
    paramLayoutInflater.setAdapter(this.c);
    this.a.findViewById(2131446561).setOnClickListener(this);
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
    a(this.a);
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientSelectRoleDialogFragment
 * JD-Core Version:    0.7.0.1
 */