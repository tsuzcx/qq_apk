package com.tencent.mobileqq.guild.channel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QQGuildChannelCategorySortFragment
  extends QQGuildTitleBarFragment
  implements View.OnClickListener
{
  private String o;
  private ArrayList<ICategoryInfo> p = new ArrayList();
  private RecyclerView q;
  private BaseDragTouchCallBack<ICategoryInfo> r;
  private QQGuildChannelCategorySortFragment.QQGuildChannelCategoryAdapter s;
  
  public static Intent a(String paramString)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_guild_id", paramString);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void i()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.k, "pg_sgrp_channel_category_sort");
    HashMap localHashMap = new HashMap();
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.k, this.o, localHashMap);
  }
  
  private void j()
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.d, "em_sgrp_channel_category_sort_submit", null);
  }
  
  private void k()
  {
    this.q = ((RecyclerView)this.l.findViewById(2131434548));
    RecycleViewDivider localRecycleViewDivider = new RecycleViewDivider(getContext(), 0, 1, getResources().getColor(2131166203));
    this.q.addItemDecoration(localRecycleViewDivider);
    this.s = new QQGuildChannelCategorySortFragment.QQGuildChannelCategoryAdapter();
    this.q.setAdapter(this.s);
    this.d.setVisibility(0);
    this.d.setOnClickListener(this);
    this.d.setText(getContext().getString(2131888784));
    a(getResources().getString(2131890274));
    a(2131887648, null);
  }
  
  private void m()
  {
    this.o = getActivity().getIntent().getExtras().getString("extra_guild_id");
    Object localObject = ((IGPSService)l().getRuntimeService(IGPSService.class, "")).getChannelCategoryList(this.o);
    if (localObject != null)
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        if (!TextUtils.isEmpty(((ICategoryInfo)((List)localObject).get(i)).a())) {
          this.p.add(((List)localObject).get(i));
        }
        i += 1;
      }
    }
    this.r = new BaseDragTouchCallBack(this.q, this.p);
    new ItemTouchHelper(this.r).attachToRecyclerView(this.q);
    localObject = new LinearLayoutManager(getContext());
    this.q.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new DefaultItemAnimator();
    ((DefaultItemAnimator)localObject).setSupportsChangeAnimations(false);
    this.q.setItemAnimator((RecyclerView.ItemAnimator)localObject);
    this.s.a(this.p);
  }
  
  private void n()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890335));
      return;
    }
    if (this.p.isEmpty())
    {
      QQGuildUtil.c(BaseApplication.getContext().getString(2131890273));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(((ICategoryInfo)localIterator.next()).b()));
    }
    ((IGPSService)l().getRuntimeService(IGPSService.class, "")).setChannelCategoryOrder(this.o, localArrayList, new QQGuildChannelCategorySortFragment.1(this));
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    k();
    m();
    i();
    j();
  }
  
  protected int b()
  {
    return 2131625000;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a) {
      getActivity().finish();
    } else if (paramView == this.d) {
      n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.QQGuildChannelCategorySortFragment
 * JD-Core Version:    0.7.0.1
 */