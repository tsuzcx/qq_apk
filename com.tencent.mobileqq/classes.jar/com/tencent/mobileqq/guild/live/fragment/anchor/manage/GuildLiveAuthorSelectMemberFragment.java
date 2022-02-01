package com.tencent.mobileqq.guild.live.fragment.anchor.manage;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout;
import com.tencent.mobileqq.guild.setting.QQGuildVisibleMemberListViewModel;
import com.tencent.mobileqq.guild.util.GuildLiveDtUtil;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildLiveAuthorSelectMemberFragment
  extends QQGuildTitleBarFragment
{
  public String o;
  protected GuildSelectGuildMemberLayout p;
  private QQGuildVisibleMemberListViewModel q;
  private final List<String> r = new ArrayList();
  private int s = 99;
  
  public static Intent a(IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QGL.GuildLiveAuthorSelectMemberFragment", 1, "guild is null");
      QQToast.makeText(paramActivity, 1, paramActivity.getResources().getString(2131889041), 1).show();
      return;
    }
    paramAppInterface = a(((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString1));
    paramAppInterface.putExtra("extra_channel_id", paramString2);
    paramAppInterface.putExtra("select_type", paramInt1);
    paramAppInterface.putExtra("title_str", paramString3);
    paramAppInterface.putExtra("max_count", paramInt2);
    if (paramArrayOfString != null) {
      paramAppInterface.putExtra("selected_list", paramArrayOfString);
    }
    QPublicFragmentActivity.Launcher.a(paramActivity, paramAppInterface, QPublicFragmentActivity.class, GuildLiveAuthorSelectMemberFragment.class, paramInt3);
  }
  
  private void i()
  {
    Object localObject2 = getActivity().getIntent();
    int i = ((Intent)localObject2).getIntExtra("select_type", 0);
    Object localObject1 = ((Intent)localObject2).getStringExtra("title_str");
    this.s = ((Intent)localObject2).getIntExtra("max_count", 99);
    Object localObject4 = (IGProGuildInfo)((Intent)localObject2).getSerializableExtra("extra_guild_guild_info");
    Object localObject3 = ((Intent)localObject2).getStringExtra("extra_channel_id");
    localObject2 = ((Intent)localObject2).getStringArrayExtra("selected_list");
    this.p = ((GuildSelectGuildMemberLayout)this.l.findViewById(2131437913));
    this.p.setInitData(l(), i, false);
    this.p.setIsFrom(5);
    a(2131887648, new GuildLiveAuthorSelectMemberFragment.1(this));
    b(2131888784, new GuildLiveAuthorSelectMemberFragment.2(this));
    a(true);
    this.q = ((QQGuildVisibleMemberListViewModel)ViewModelProviderHelper.a(this, QQGuildVisibleMemberListViewModel.v).get(QQGuildVisibleMemberListViewModel.class));
    this.q.a(l(), (IGProGuildInfo)localObject4, (String)localObject3);
    localObject4 = this.p;
    QQGuildVisibleMemberListViewModel localQQGuildVisibleMemberListViewModel = this.q;
    ((GuildSelectGuildMemberLayout)localObject4).setDataModel(localQQGuildVisibleMemberListViewModel, this, localQQGuildVisibleMemberListViewModel.l());
    a((String)localObject1, getResources().getString(2131887648), getResources().getString(2131888784));
    this.p.setSelectMemberCallback(new GuildLiveAuthorSelectMemberFragment.3(this));
    localObject3 = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getChannelInfo((String)localObject3);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((IGProChannelInfo)localObject3).getVisibleType() == 1) {
        localObject1 = null;
      }
    }
    if ((localObject1 != null) && (localObject1.length > 0)) {
      this.p.setSelectItems((String[])localObject1);
    }
    j();
    k();
  }
  
  private void j()
  {
    IGProChannelInfo localIGProChannelInfo = QQGuildLiveStartParamsCache.a().getChannelInfo();
    Object localObject = QQGuildLiveStartParamsCache.a().getGuildInfo();
    if (localIGProChannelInfo != null)
    {
      if (localObject == null) {
        return;
      }
      localObject = new GuildLiveDtUtil(localIGProChannelInfo, (IGProGuildInfo)localObject).a();
      ((HashMap)localObject).put("sgrp_pg_source_anchor", Integer.valueOf(2));
      VideoReport.setPageId(this.k.getRootView(), "pg_sgrp_access_anchor");
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.k.getRootView(), localIGProChannelInfo, (Map)localObject);
    }
  }
  
  private void k()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.k.findViewById(2131436211), "em_sgrp_access_member", null);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    i();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1);
    this.b.setText(paramString2);
    this.d.setText(paramString3);
    this.o = paramString3;
  }
  
  protected int b()
  {
    return 2131625118;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.p.c();
    this.q.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.manage.GuildLiveAuthorSelectMemberFragment
 * JD-Core Version:    0.7.0.1
 */