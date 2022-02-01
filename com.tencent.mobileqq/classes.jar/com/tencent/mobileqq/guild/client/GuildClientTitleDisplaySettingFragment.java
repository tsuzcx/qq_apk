package com.tencent.mobileqq.guild.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.SingleLiveEvent;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInstructionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ListView;

public class GuildClientTitleDisplaySettingFragment
  extends QQGuildTitleBarFragment
{
  public GuildClientTitleDisplaySettingViewModel o;
  private ListView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private RoundRectUrlImageView t;
  private TextView u;
  private RoundRectUrlImageView v;
  private QQProgressDialog w;
  private GuildClientTitleDisplaySettingListAdapter x;
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("guild_id", paramString);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, GuildClientTitleDisplaySettingFragment.class);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain()));
  }
  
  private void a(IGProIdentityInstructionInfo paramIGProIdentityInstructionInfo)
  {
    this.q.setText(paramIGProIdentityInstructionInfo.a());
    this.r.setText(paramIGProIdentityInstructionInfo.b());
    a(this.t, paramIGProIdentityInstructionInfo.c());
    a(this.v, paramIGProIdentityInstructionInfo.d());
  }
  
  private void a(RoundRectUrlImageView paramRoundRectUrlImageView)
  {
    paramRoundRectUrlImageView.setAllRadius(DisplayUtil.a(getContext(), 6.0F));
    int i = DisplayUtil.a(getContext()).a - DisplayUtil.a(getContext(), 18.0F) * 2;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramRoundRectUrlImageView.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = ((int)(i * 291.0F / 792.0F));
    paramRoundRectUrlImageView.setLayoutParams(localLayoutParams);
  }
  
  private void i()
  {
    a(getString(2131916359));
    View localView1 = LayoutInflater.from(getContext()).inflate(2131625027, null);
    this.p = ((ListView)this.l.findViewById(2131430790));
    View localView2 = LayoutInflater.from(getContext()).inflate(2131625028, null);
    this.p.addHeaderView(localView2);
    this.p.addFooterView(localView1);
    this.q = ((TextView)localView1.findViewById(2131435853));
    this.r = ((TextView)localView1.findViewById(2131439404));
    this.s = ((TextView)localView1.findViewById(2131430513));
    this.t = ((RoundRectUrlImageView)localView1.findViewById(2131450226));
    a(this.t);
    this.u = ((TextView)localView1.findViewById(2131438054));
    this.v = ((RoundRectUrlImageView)localView1.findViewById(2131438052));
    a(this.v);
    this.w = new QQProgressDialog(getActivity());
    this.l.postDelayed(new GuildClientTitleDisplaySettingFragment.1(this), 700L);
  }
  
  private void j()
  {
    this.o = ((GuildClientTitleDisplaySettingViewModel)ViewModelProviderHelper.a(this, GuildClientTitleDisplaySettingViewModel.a).get(GuildClientTitleDisplaySettingViewModel.class));
    this.x = new GuildClientTitleDisplaySettingListAdapter(this);
    this.p.setAdapter(this.x);
    String str = getActivity().getIntent().getExtras().getString("guild_id");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("GuildClientTitleDisplaySettingFragment", 2, "open GuildClientTitleDisplaySettingFragment guildId is null");
      getActivity().finish();
    }
    this.o.a(l(), str);
    this.o.b().observe(getViewLifecycleOwner(), new GuildClientTitleDisplaySettingFragment.2(this));
    this.o.c().observe(getViewLifecycleOwner(), new GuildClientTitleDisplaySettingFragment.3(this));
    this.o.d().observe(getViewLifecycleOwner(), new GuildClientTitleDisplaySettingFragment.4(this));
  }
  
  private void k()
  {
    if (TextUtils.isEmpty(this.o.a())) {
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_otherapp_identity_set");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.o.a(), null);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    i();
    j();
    k();
  }
  
  protected int b()
  {
    return 2131625026;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    QQProgressDialog localQQProgressDialog = this.w;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientTitleDisplaySettingFragment
 * JD-Core Version:    0.7.0.1
 */