package com.tencent.mobileqq.guild.channel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QQGuildChannelChooseCategoryFragment
  extends QQGuildTitleBarFragment
  implements View.OnClickListener
{
  private static long t;
  private OverScrollRecyclerView o;
  private QQGuildChannelChooseCategoryFragment.QQGuildChannelListAdapter p;
  private String q;
  private String r;
  private String s;
  private List<String> u = new ArrayList();
  private List<Long> v = new ArrayList();
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QQToast.makeText(paramContext, 1, paramContext.getResources().getString(2131889041), 1).show();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_guild_id", paramString1);
    localIntent.putExtra("extra_channel_category", paramString3);
    localIntent.putExtra("extra_channel_id", paramString2);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildChannelChooseCategoryFragment.class);
  }
  
  private void b(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = (String)this.u.get(i);
    long l = ((Long)this.v.get(i)).longValue();
    if (i == 0) {
      paramView = "";
    }
    if (TextUtils.equals(this.r, paramView)) {
      return;
    }
    if (System.currentTimeMillis() - t < 300L)
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890277));
      return;
    }
    t = System.currentTimeMillis();
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).setChannelCategory(this.q, this.s, l, new QQGuildChannelChooseCategoryFragment.1(this, paramView));
  }
  
  private void i()
  {
    Object localObject = getActivity().getIntent();
    this.q = ((Intent)localObject).getStringExtra("extra_guild_id");
    this.r = ((Intent)localObject).getStringExtra("extra_channel_category");
    this.s = ((Intent)localObject).getStringExtra("extra_channel_id");
    this.p = new QQGuildChannelChooseCategoryFragment.QQGuildChannelListAdapter();
    this.p.a(this);
    this.p.a(this.r);
    this.o.setAdapter(this.p);
    localObject = new LinearLayoutManager(getContext());
    this.o.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new DefaultItemAnimator();
    ((DefaultItemAnimator)localObject).setSupportsChangeAnimations(false);
    this.o.setItemAnimator((RecyclerView.ItemAnimator)localObject);
    j();
  }
  
  private void j()
  {
    List localList = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getChannelCategoryList(this.q);
    this.u.clear();
    this.v.clear();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        ICategoryInfo localICategoryInfo = (ICategoryInfo)localList.get(i);
        this.u.add(localICategoryInfo.a());
        this.v.add(Long.valueOf(localICategoryInfo.b()));
        i += 1;
      }
    }
    this.p.a(this.u);
  }
  
  private void k()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_channel_category_set");
    HashMap localHashMap = new HashMap();
    localHashMap.put("sgrp_sub_channel_id", this.s);
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.q, localHashMap);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a(getResources().getString(2131890278));
    this.o = ((OverScrollRecyclerView)this.l.findViewById(2131434571));
    paramLayoutInflater = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
    paramLayoutInflater.topMargin = Utils.a(12.0F, getResources());
    this.o.setLayoutParams(paramLayoutInflater);
    paramLayoutInflater = new RecycleViewDivider(getContext(), 0, 1, getResources().getColor(2131166203));
    paramLayoutInflater.a((int)(DeviceInfoUtil.a * 16.0F), 0);
    this.o.addItemDecoration(paramLayoutInflater);
    i();
    k();
  }
  
  protected int b()
  {
    return 2131625007;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434621) {
      b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelChooseCategoryFragment
 * JD-Core Version:    0.7.0.1
 */