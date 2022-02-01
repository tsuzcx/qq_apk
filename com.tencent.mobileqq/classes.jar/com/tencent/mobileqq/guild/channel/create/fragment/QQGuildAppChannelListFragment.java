package com.tencent.mobileqq.guild.channel.create.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.adapter.QQGuildAppChannelPageListener;
import com.tencent.mobileqq.guild.channel.create.adapter.QQGuildAppChannelRvAdapter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;

public class QQGuildAppChannelListFragment
  extends BaseCreateSubChannelFragment
{
  private RecyclerView d;
  private QQGuildAppChannelRvAdapter e;
  private QQGuildAppChannelPageListener f;
  private List<IAppInfo> g;
  private GPServiceObserver h = new QQGuildAppChannelListFragment.1(this);
  
  public static QQGuildAppChannelListFragment a(CreateSubChannelInfo paramCreateSubChannelInfo)
  {
    QQGuildAppChannelListFragment localQQGuildAppChannelListFragment = new QQGuildAppChannelListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra_key_subchannel_info", paramCreateSubChannelInfo);
    localQQGuildAppChannelListFragment.setArguments(localBundle);
    return localQQGuildAppChannelListFragment;
  }
  
  private void d()
  {
    this.d = ((RecyclerView)this.a.findViewById(2131428607));
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(getContext(), 2);
    localGridLayoutManager.setOrientation(1);
    this.d.setLayoutManager(localGridLayoutManager);
    this.e = new QQGuildAppChannelRvAdapter(getContext());
    this.e.a(this.f);
    this.d.setAdapter(this.e);
  }
  
  private void e()
  {
    if (a() != null)
    {
      IGPSService localIGPSService = (IGPSService)a().getRuntimeService(IGPSService.class, "");
      this.g = localIGPSService.getAppInfoList();
      this.e.a(this.g);
      localIGPSService.refreshAppInfoList();
    }
  }
  
  private void f()
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(this.d, "pg_create_sub_appchannel");
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.d, this.b.a, null);
  }
  
  public void a(QQGuildAppChannelPageListener paramQQGuildAppChannelPageListener)
  {
    this.f = paramQQGuildAppChannelPageListener;
  }
  
  protected int b()
  {
    return 2131624985;
  }
  
  protected void c()
  {
    if (a() != null) {
      ((IGPSService)a().getRuntimeService(IGPSService.class, "")).addObserver(this.h);
    }
    d();
    e();
    f();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (a() != null) {
      ((IGPSService)a().getRuntimeService(IGPSService.class, "")).deleteObserver(this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildAppChannelListFragment
 * JD-Core Version:    0.7.0.1
 */